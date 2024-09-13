package website.front.components

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.main
import kotlinx.html.span
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative h-screen overflow-hidden")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuMovingSidebar()
    MenuStaticSidebar()

    main(classes("mx-auto", "my-background", "overflow-hidden","h-full", "w-full", "relative", "flex flex-col", "text-center")) {
        attributes["x-bind:class"] = "{ 'pl-56': sidebarOpen, 'pl-20': !sidebarOpen }"

        span(classes = classes("top-0 my-background w-full h-12 flex items-center space-x-4 justify-start absolute")) {
            val tagList = listOf("Everything", "Music", "Action", "New Recommendations")
            TagItem(tagList)
        }

        div(classes = classes("overflow-y-auto h-full pt-20 left-0 my-grid scrollbar-hide")){
            div(classes = classes("grid grid-cols-4 gap-4 ")) {
                for (i in 0..15) {
                    div(classes = classes(" my-grid-box bg-red-900 rounded-lg"))
                }
            }
        }
    }

}









