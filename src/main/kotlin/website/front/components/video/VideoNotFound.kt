package website.front.components.video

import kotlinx.html.FlowContent
import kotlinx.html.div
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.VideoNotFound() {
    div(classes = classes(
        "w-screen",
        "h-screen",
        "flex",
        "bg-gradient-to-br",
        "min-h-screen",
        "flex",
        "justify-center",
        "justify-center",
        "items-center",
        "my-background"
    )){
        div(classes = classes("w-full", "h-full", "flex", "flex-col", "justify-center", "items-center")) {
            div(classes = classes("my-text", "text-center", "text-4xl", "font-bold")) {
                addContent("Video not found")
            }
        }
    }
}