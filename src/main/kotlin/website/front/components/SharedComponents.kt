package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FORM.formInput(
    inputType : InputType,
    inputPlaceholder : String,
    inputRequired : Boolean,
    inputId : String
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

fun FORM.formButton(content: String, usernameID: String,passwordID:String, link : String) {
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
        onClick = "console.log('Username:', document.getElementById('$usernameID').value, 'Password:', document.getElementById('$passwordID').value)"
        attributes["hx-post"] = link
        attributes["hx-include"] = "#$usernameID,#$passwordID"
        attributes["hx-push-url"] = "true"
        attributes["hx-trigger"] = "click"
        attributes["hx-redirect"] = "true"
        attributes["hx-on::after-request"] = "if(event.detail.failed) htmx.find('#error').innerHTML = event.detail.xhr.responseText;"

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

fun DIV.dropdownMenu(classes: String, vararg items: DIV.() -> Unit) {
    div(classes = classes) {
        div(classes = classes("relative", "inline-block")) {
            button(
                classes = classes(
                    "bg-blue-500",
                    "text-white",
                    "font-bold",
                    "py-2",
                    "rounded",
                    "w-48",
                    "inline-flex",
                    "items-center",
                    "justify-center",
                )
            ) {
                onClick = "toggleDropdown()"
                addContent("Settings")
                span(classes = classes("ml-1")) {
                    id = "dropdownIcon"
                    addContent("▼")
                }
            }
            div(
                classes = classes(
                    "hidden",
                    "absolute",
                    "bg-white",
                    "text-gray-700",
                    "mt-2",
                    "py-2",
                    "w-48", // Increased width
                    "shadow-lg",
                    "z-10",
                    "center",
                    "rounded-md", // Rounded corners
                    "border", // Add a border
                    "border-gray-200"
                )
            ) {
                onClick = "toggleDropdown()"
                id = "dropdownContent"
                items.forEachIndexed { index, item ->
                    div(classes = classes(
                        "px-4",
                        "py-2",
                        "hover:bg-gray-100",
                        "transition",
                        "duration-200",
                        if (index != items.size - 1) "border-b" else "" // Add border between items except for the last one
                    )) {
                        item()
                    }
                }
            }
        }
    }
}

