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
    vararg items: DIV.() -> Unit
) {
    div(classes = contentClasses(containerStyling, containerPlacement, containerSize, containerTransition)) {
        div(classes = classes("relative", "inline-block")) {
            attributes["x-data"] = "{ isOpen: false }"
            button(
                classes = classes(
                    "bg-blue-500",
                    "text-white",
                    "font-bold",
                    "py-2",
                    "w-48",
                    "inline-flex",
                    "items-center",
                    "justify-center"
                )
            ) {
                attributes["x-on:click"] = "isOpen = !isOpen"
                addContent("Settings")
                i(classes("ml-1")) {
                    attributes["x-bind:class"] = "isOpen ? 'fas fa-chevron-up' : 'fas fa-chevron-down'"
                }
            }
            div(
                classes = classes(
                    "absolute",
                    "bg-white",
                    "text-gray-700",
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
                attributes["x-on:click"] = "isOpen = !isOpen"
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
                            contentStyling,
                            contentPlacement,
                            contentTransition,
                            contentSize,
                            if (index != items.size - 1) "border-b" else "" // Add border between items except for the last one
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
            label(classes = classes("ml-2", "text-gray-700")) {
                addContent(label)
            }

            div(
                classes = classes(
                    "w-10", "h-6", "rounded-full", "shadow-inner",
                    "transition-colors", "duration-300", "ease-in-out",
                    "flex", "items-center"
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





