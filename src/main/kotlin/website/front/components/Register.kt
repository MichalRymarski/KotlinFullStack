package website.front.components

import kotlinx.html.*
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.register() {
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
                    addContent("Register")
                }
            }
            formInput(InputType.text, "Username", true, "register-email")

            formInput(InputType.text, "Password", true, "register-password")

            formButton(
                "Register",
                "register-email",
                "register-password",
                "/register",
            )
            div(classes = classes("w-full", "text-red-500", "text-center", "mb-4","text-xl")) {
                id = "error"
            }
        }
    }
}



