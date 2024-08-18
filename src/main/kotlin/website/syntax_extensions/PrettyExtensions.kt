package website.syntax_extensions

import kotlinx.html.FlowContent

fun FlowContent.addContent(content: String) {
    +content
}



/**
 * Combines multiple CSS class names into a single space-separated string.
 * @param values The CSS class names to be combined.
 * @return A string of CSS class names separated by spaces.
 */
fun classes(vararg values: String): String = values.joinToString(" ")

