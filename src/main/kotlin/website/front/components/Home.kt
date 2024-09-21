package website.front.components

import kotlinx.html.*
import website.back.plugins.UserSession
import website.front.components.video.VideoThumbnail
import website.syntax_extensions.classes

fun FlowContent.Home(userSession: UserSession?) = div(classes = classes("relative h-screen my-background")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    if(userSession != null) {
        HeaderLoggedIn(userSession)
    } else {
        HeaderNotLoggedIn()
    }
    MenuMovingSidebar()
    MenuStaticSidebar()
    VideoGrid()
}

private fun DIV.VideoGrid() {
    main(classes("mx-auto overflow-hidden h-full w-full relative flex flex-col")) {
        attributes["x-bind:class"] = "{ 'pl-56': sidebarOpen, 'pl-20': !sidebarOpen }"

        span(classes = classes("top-0 w-full h-16 flex items-center space-x-4 justify-start sticky z-10")) {
            val tagList = listOf("Everything", "Music", "Action", "New Recommendations")
            TagItem(tagList)
        }

        div(classes = classes("overflow-y-auto h-full pt-10 pr-8 scrollbar-hide")) {
            div(classes = classes("grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-y-8 gap-x-6")) {
                for (i in 0..15) {
                    VideoThumbnail(i)
                }
            }
        }

        div(classes = classes("h-32"))
    }
}