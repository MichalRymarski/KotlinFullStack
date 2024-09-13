package website.front.components

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.main
import kotlinx.html.span
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuMovingSidebar()
    MenuStaticSidebar()

    main(classes("mx-auto", "my-background", "min-h-screen", "w-full", "relative", "flex justify-center", "text-center", "inline-block")) {
        attributes["x-bind:class"] = "{ 'ml-56': sidebarOpen, 'ml-20': !sidebarOpen }"

        span(classes = classes("top-0 left-0 w-full h-10 flex items-center space-x-4 justify-start")) {
            val tagList = listOf("Everything","Music","Action","New Recommendations")

            TagItem(tagList)
        }
    }

}









