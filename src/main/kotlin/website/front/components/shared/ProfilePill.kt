package website.front.components.shared

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.style
import website.back.plugins.UserSession
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.ProfilePill(userSession: UserSession, disabled : Boolean = false) {
    div(classes = classes(
        " w-10 h-10 button text-2xl",
        "flex",
        "items-center",
        "justify-center",
        "font-medium",
        "rounded-full",
        if(disabled) "" else "absolute top-3 right-8 cursor-pointer"
    )
    ){
        id = "profileButton"
        if (!disabled) {
            attributes["x-on:click"] = "isOpen = !isOpen; console.log(isOpen)"
        }
        style = "background-color: ${userSession.color}"
        addContent(userSession.getInitial().toString())
    }
}