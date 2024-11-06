package website.front.components.shared

import kotlinx.html.ButtonType
import kotlinx.html.FlowContent
import kotlinx.html.button
import kotlinx.html.unsafe
import website.front.components.youtubeLogo
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.YoutubeButton() {
    button(
        classes = classes("absolute top-6 left-16 w-32 h-6  flex items-center justify-center"),
        type = ButtonType.button
    ) {
        attributes["hx-trigger"] = "click"
        attributes["hx-target"] = "#home"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-push-url"] = "true"
        attributes["hx-get"] = "/"

        unsafe { addContent(youtubeLogo) }
    }
}
