package website.front.components.shared

import kotlinx.html.*
import website.syntax_extensions.classes

fun FlowContent.MenuStaticSidebar() {
    aside(classes = classes("left-0 min-h-screen fixed w-20 my-sidebar z-10")) {
        nav(classes = "pr-4") {
            ul(classes = "space-y-1") {
                listOf("Home", "Shorts", "Subscriptions", "You").forEach { item ->
                    li {
                        attributes["x-on:click"] = "\$store.nav.setChosen('$item')"
                        a(href = "#", classes = "flex items-center h-16 hover:bg-gray-700 px-4 py-2 rounded-lg") {
                            img(classes = "h-7 w-7 block") {
                                attributes["x-bind:src"] = "\$store.nav.chosen === '$item' ? '/static/${item}_filled.svg' : '/static/${item}.svg'"
                                alt = "/static/loading.gif"
                            }
                        }
                    }
                }
            }
        }
    }
}
