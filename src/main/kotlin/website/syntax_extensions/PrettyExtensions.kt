package website.syntax_extensions

import kotlinx.html.FlowContent

fun FlowContent.addContent(content: String) {
    +content
}

/**
 * Creates a Set of CSS classes from the given string values.
 * @param values The CSS class names to be combined.
 * @return A Set of unique CSS class names.
 */
fun classes(vararg values: String): Set<String> = values.toSet()

/**
 * Combines multiple CSS class names into a single space-separated string.
 * @param values The CSS class names to be combined.
 * @return A string of CSS class names separated by spaces.
 */
fun classesToString(vararg values: String): String = values.joinToString(" ")