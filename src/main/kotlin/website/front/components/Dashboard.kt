package website.front.components

import kotlinx.html.*
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuMovingSidebar()
    MenuStaticSidebar()
    main(
        classes(
            "mx-auto",
            "my-background",
            "sm:py-6",
            "lg:py-8",
            "min-h-screen",
            "w-full",
            "relative",
            "flex justify-center",
            "text-center",
            "inline-block",
        )
    ) {
        attributes["x-bind:class"] = "{ 'ml-56': sidebarOpen, 'ml-20': !sidebarOpen }"

        div(classes = classes("inline-block", "w-full", "px-8")) {
            img(classes = classes("w-full", "h-full", "object-cover")) {
                src = "/static/background.jpg"
                alt = "Background Image"
            }
        }
    }

}

fun DIV.MenuStaticSidebar() {
    aside(classes = classes("left-0 min-h-screen fixed w-20 my-sidebar")) {
        nav(classes = "pl-0") {
            ul(classes = "space-y-1") {
                listOf("Home", "Shorts", "Subscriptions","You").forEach { item ->
                    li {
                        a(href = "#", classes = "flex items-center h-16 hover:bg-gray-700 px-4 py-2 rounded-lg") {
                            img(classes = "h-7 w-7 block") {
                                src = "/static/${item}.svg"
                                alt = "/static/loading.gif"
                            }
                        }
                    }
                }
            }
        }
    }
}







