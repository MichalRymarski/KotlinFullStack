@file:Suppress("unused")
package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes
import website.syntax_extensions.contentClasses

fun FORM.formInput(
    inputType: InputType,
    inputPlaceholder: String,
    inputRequired: Boolean,
    inputId: String
) {
    input(
        classes = classes(
            "w-full",
            "border-2",
            "border-gray-900",
            "bg-gray-500",
            "p-2",
            "h-12",
            "rounded",
            "focus:outline-none",
            "focus:border-gray-400"
        )
    ) {
        type = inputType
        formEncType = InputFormEncType.textPlain
        placeholder = inputPlaceholder
        required = inputRequired
        id = inputId
        name = inputId
    }
}

fun FORM.formButton(content: String, usernameID: String, passwordID: String, link: String) {
    button(
        classes = classes(
            "w-full",
            "bg-gradient-to-r",
            "from-blue-500",
            "to-indigo-500",
            "text-white",
            "rounded-lg",
            "p-3",
            "mt-4",
            "transition duration-300 ease-in-out hover:bg-blue-600 transform hover:scale-102",
        )
    ) {
        onClick =
            "console.log('Username:', document.getElementById('$usernameID').value, 'Password:', document.getElementById('$passwordID').value)"
        attributes["hx-post"] = link
        attributes["hx-include"] = "#$usernameID,#$passwordID"
        attributes["hx-push-url"] = "true"
        attributes["hx-trigger"] = "click"
        attributes["hx-redirect"] = "true"
        attributes["hx-on::after-request"] =
            "if(event.detail.failed) htmx.find('#error').innerHTML = event.detail.xhr.responseText;"

        type = ButtonType.submit
        addContent(content)
    }
}

fun DIV.LoginButton(classes: String) {
    button(classes = classes) {
        attributes["hx-get"] = "$API_LINK/login"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Login")
    }
}

fun DIV.RegisterButton(classes: String) {
    button(classes = classes) {
        attributes["hx-get"] = "$API_LINK/register"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Register")
    }
}

fun DIV.dropdownMenu(
    containerStyling: String? = null,
    contentStyling: String? = null,
    containerPlacement: String? = null,
    contentPlacement: String? = null,
    containerSize: String? = null,
    contentSize: String? = null,
    containerTransition: String? = null,
    contentTransition: String? = null,
    buttonText : String? = null,
    vararg items: DIV.() -> Unit
) {
    div(classes = contentClasses(containerStyling, containerPlacement, containerTransition)) {
        div(classes = classes("relative", "inline-block")) {
            attributes["x-data"] = "{ isOpen: false }"
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
                addContent(buttonText ?: "")
                i(classes("ml-1")) {
                    attributes["x-bind:class"] = "isOpen ? 'fas fa-chevron-up' : 'fas fa-chevron-down'"
                }
            }
            div(
                classes = classes(
                    "absolute",
                    contentStyling,
                    "mt-2",
                    "py-2",
                    "w-48",
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

fun FlowContent.codeBlock(language: String, code: String) {
    pre(
        classes = classes(
            "bg-gray-800",
            "rounded-md",
            "p-4",
            "overflow-x-auto",
            "text-sm",
            "text-white"
        )
    ) {
        code(classes = classes("language-$language")) {
            +code
        }
    }
}

fun DIV.ToggleSwitch(id: String, label: String, classes: String? = null) {
    div(classes = classes("flex", "items-center", classes.toString())) {
        attributes["x-data"] = "{ isOn: false }"

        label(classes = classes("flex", "items-center", "cursor-pointer")) {
            input(type = InputType.checkBox, classes = classes("hidden")) {
                this.id = id
                attributes["x-model"] = "isOn"
            }
            label(classes = classes("ml-2")) {
                addContent(label)
            }

            div(
                classes = classes(
                    "w-10", "h-6", "rounded-full", "shadow-inner",
                    "transition-colors", "duration-300", "ease-in-out",
                    "flex", "items-center" ,"ml-4"
                )
            ) {
                attributes["x-bind:class"] = "isOn ? 'bg-blue-500' : 'bg-gray-400'"

                div(
                    classes = classes(
                        "w-4", "h-4", "bg-white", "rounded-full", "shadow",
                        "transition-transform", "duration-300", "ease-in-out"
                    )
                ) {
                    attributes["x-bind:class"] = "isOn ? 'transform translate-x-5' : 'transform translate-x-0.5'"
                }
            }
        }
    }
}

fun DIV.Header() {
    header(classes = classes("shadow-md", "bg-gray-800")) {
        div(classes = classes("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")) {
            div(
                classes = classes("font-medium", "text-3xl", "tracking-light", "text-gray-900")
            ) {
                a(classes = classes("cursor-pointer", "text-white")) {
                    href = "$API_LINK/"
                    id = "dashboard"
                    addContent("Dashboard")
                }
            }

        }
    }
}

fun MAIN.sideBar(
    containerStyling: String? = null,
    contentStyling: String? = null,
    containerPlacement: String? = null,
    contentPlacement: String? = null,
    containerSize: String? = null,
    contentSize: String? = null,
    containerTransition: String? = null,
    contentTransition: String? = null,
    vararg items: DIV.() -> Unit
) {
    attributes["x-data"] = "{ open: false }"

    div(
        classes = contentClasses(
            "absolute top-0 left-0",
            "w-48 min-h-screen",
            "bg-gray-800",
            "transition-all duration-300",
            containerStyling,
            containerPlacement,
            containerSize,
            containerTransition
        )
    ) {
        attributes["x-show"] = "open"
        attributes["x-transition:enter"] = "transform translate-x-0 opacity-100"
        attributes["x-transition:enter-start"] = "transform -translate-x-full opacity-0"
        attributes["x-transition:leave-end"] = "transform -translate-x-full opacity-0"

        div(classes("border-t border-gray-500", "absolute", "top-0", "left-0", "w-full"))  // divider
        button(classes = classes("w-full h-12", "block","text-white")) {
            attributes["x-on:click"] = "open = !open"
            i(classes("fas fa-chevron-left"))
        }
        items.forEach { item ->
            div(classes("border-t border-gray-500", "w-full"))  // divider
            div(classes = contentClasses("my-4", "text-white", contentStyling, contentPlacement, contentSize, contentTransition)) {
                item()
            }
        }
    }
    div(
        classes = contentClasses(
            "absolute top-0 -left-8",
            "w-12 h-12",
            "bg-gray-800",
            "transition-all",
            "duration-300",
            "-z-10",
            "transition duration-300 ease-in-out transform hover:translate-x-8",
            containerStyling
        )
    ) {
        attributes["x-show"] = "!open"
        attributes["x-transition:enter"] = "opacity-100"
        attributes["x-transition:enter-start"] = "opacity-0"
        attributes["x-transition:leave-end"] = "opacity-0"

        div(classes("border-t border-gray-500", "w-full"))  // divider
        button(classes = classes("w-full h-full", "flex justify-end items-center")) {
            attributes["x-on:click"] = "open = !open"
            repeat(4) {
                i(classes("text-white fas fa-chevron-right"))
            }
        }
    }
}






