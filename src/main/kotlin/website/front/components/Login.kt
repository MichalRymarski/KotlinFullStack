package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes


fun FlowContent.login() {
    div(classes = classes("w-screen", "h-screen", "flex", "justify-center", "items-center")) {
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
            div(classes = classes("w-full", "space-y-2")) {
                h2(classes = classes("text-4xl", "font-bold", "text-center", "mb-4", "text-white")) {
                    addContent("Login")
                }
            }
            formInput(InputType.text, "Username", true, "login-email")

            formInput(InputType.text, "Password", true, "login-password")

            formButton(
                "Login",
                "login-email",
                "login-password",
                "/login",
            )
            div(classes = classes("w-full", "text-red-500", "text-center", "mb-4")) {
                id = "error"
            }

            div(classes = classes("flex", "items-center", "justify-between", "mt-4", "w-full")) {
                div(classes = classes("flex", "items-center")) {
                    checkBoxInput(classes = classes("mr-2")) {
                        name = "rememberMe"
                        id = "rememberMe"
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


