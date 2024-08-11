package website

import kotlinx.html.FlowContent

fun FlowContent.addContent(content: String) {
    +content
}