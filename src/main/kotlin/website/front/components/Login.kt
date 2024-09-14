package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes


fun FlowContent.Login() {
    div(classes = classes(
        "w-screen",
        "h-screen",
        "flex",
        "bg-gradient-to-br",
        "from-gray-900",
        "min-h-screen",
        "to-gray-500",
        "flex",
        "justify-center",
        "justify-center",
        "items-center",
        "overflow-hidden"
    )) {
        form(
            classes = classes(
                "flex",
                "flex-col",
                "justify-center",
                "items-center",
                "space-y-6",
                "w-full", "max-w-md",
                "p-8",
                "bg-gray-800",
                "rounded-lg",
                "shadow-md",
                "border-2",
                "border-gray-900",
            )
        ) {
            attributes["hx-post"] = "/login"
            attributes["hx-push-url"] = "true"
            attributes["hx-redirect"] = "true"
            attributes["hx-on::after-request"] =
                "if(event.detail.failed) htmx.find('#error').innerHTML = event.detail.xhr.responseText;"

            div(classes = classes("w-full", "space-y-2")) {
                h2(classes = classes("text-4xl", "font-bold", "text-center", "mb-4", "text-white")) {
                    addContent("Login")
                }
            }
            formInput(InputType.text, "Username", true, "login-email")

            formInput(InputType.text, "Password", true, "login-password")

            button(classes = classes("w-full", "bg-gradient-to-r", "from-blue-500", "to-indigo-500", "text-white", "rounded-lg", "p-3", "mt-4", "transition duration-300 ease-in-out hover:bg-blue-600 transform hover:scale-102")){
                type = ButtonType.submit
                addContent("Login")
            }
            div(classes = classes("w-full", "text-red-500", "text-center", "mb-4")) {
                id = "error"
            }

            div(classes = classes("flex", "items-center", "justify-between", "mt-4", "w-full")) {
                div(classes = classes("flex", "items-center")) {
                    checkBoxInput(classes = classes("mr-2")) {
                        name = "rememberMe"
                        id = "remember-me"
                        type = InputType.checkBox
                    }
                    label(classes = classes("text-sm", "text-white")) {
                        addContent("Remember Me")
                    }
                }

                a(href = "#", classes = classes("text-sm", "text-blue-600", "hover:underline")) {
                    addContent("Forgot your password?")
                }
            }

            a(href = "$API_LINK/register", classes = classes("text-sm", "text-blue-600", "hover:underline")) {
                addContent("Not registered? Register here!")
            }
        }
    }
}


