package website.syntax_extensions

import kotlinx.html.FlowContent

fun FlowContent.addContent(content: String) {
    +content
}