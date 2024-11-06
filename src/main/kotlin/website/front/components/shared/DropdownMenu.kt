package website.front.components.shared

import kotlinx.html.FlowContent
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import website.syntax_extensions.classes
import website.syntax_extensions.contentClasses

fun FlowContent.DropdownMenu(
    containerStyling: String? = null,
    contentStyling: String? = null,
    containerPlacement: String? = null,
    contentPlacement: String? = null,
    containerSize: String? = null,
    contentSize: String? = null,
    containerTransition: String? = null,
    contentTransition: String? = null,
    buttonText: String? = null,
    vararg items: FlowContent.() -> Unit
) {
    div(classes = contentClasses(containerStyling, containerPlacement, containerTransition)) {
        id = "dropdown-menu"
        div(classes = classes("relative", "inline-block")) {
            button(
                classes = classes(
                    containerSize,
                    "py-2",
                    "inline-flex",
                    "items-center",
                    "justify-center"
                )
            ) {
                attributes["x-on:click"] = "isOpen = !isOpen"

            }
            div(
                classes = classes(
                    "absolute",
                    contentStyling,
                    "mt-2",
                    "py-2",
                    "w-64",
                    "shadow-lg",
                    "z-10",
                    "center",
                    "rounded-md",
                    "border",
                    "border-gray-200",
                    "transition-all",
                    "transform",
                    "scale-95",
                    "origin-top-right",
                    "right-0",
                    "mt-2"
                )
            ) {
                attributes["x-show"] = "isOpen"
                attributes["x-transition:enter"] = "transition ease-out duration-150"
                attributes["x-transition:enter-start"] = "opacity-0"
                attributes["x-transition:enter-end"] = "opacity-100"
                attributes["x-transition:leave"] = "transition ease-in duration-150"
                attributes["x-transition:leave-start"] = "opacity-100"
                attributes["x-transition:leave-end"] = "opacity-0"
                id = "dropdownContent"
                items.forEachIndexed { index, item ->
                    div(
                        classes = contentClasses(
                            contentPlacement,
                            contentTransition,
                            contentSize,
                            if (index != items.size - 1) "border-b border-gray-600" else "" // Add border between items except for the last one
                        )
                    ) {
                        item()
                    }
                }
            }
        }
    }
}
