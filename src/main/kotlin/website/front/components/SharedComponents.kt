package website.front.components

import kotlinx.html.*
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
