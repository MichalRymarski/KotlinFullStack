package website.syntax_extensions

import kotlinx.html.FlowContent
import kotlinx.html.Unsafe

fun FlowContent.addContent(content: String) {
    +content
}

fun Unsafe.addContent(content : String){
    +content
}


/**
 * Combines multiple CSS class names into a single space-separated string.
 * @param values The CSS class names to be combined.
 * @return A string of CSS class names separated by spaces.
 */
fun classes(vararg values: String?): String = values.joinToString(" ")
fun containerClasses(vararg values: String?): String = values.joinToString(" ")
fun contentClasses(vararg values: String?): String = values.joinToString(" ")


fun containerStyling(vararg values : String) = values.joinToString(" ")
fun contentStyling(vararg values : String) = values.joinToString(" ")
fun containerPlacement(vararg values : String) = values.joinToString(" ")
fun contentPlacement(vararg values : String) = values.joinToString(" ")
fun containerSize(vararg values : String) = values.joinToString(" ")
fun contentSize(vararg values : String) = values.joinToString(" ")
fun containerTransition(vararg values : String) = values.joinToString(" ")
fun contentTransition(vararg values : String) = values.joinToString(" ")



