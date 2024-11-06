package website.front.components.shared

import kotlinx.html.*
import website.front.components.MenuButton
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.MenuMovingSidebar() {
    aside(
        classes = classes(
            "w-56",
            "fixed",
            "left-0",
            "bottom-0",
            "top-0",
            "overflow-y-auto",
            "transition-all",
            "duration-300",
            "ease-in-out",
            "z-40 my-sidebar"
        )
    ) {
        attributes["x-show"] = "sidebarOpen"

        nav(classes = "pl-0 p-4 my-1") {
            div(classes = "flex items-center justify-between p-4") {
                MenuButton()
                YoutubeButton()
            }
            ul(classes = "space-y-2") {
                listOf("Home", "Shorts", "Subscriptions").forEach { item ->
                    li {
                        attributes["x-on:click"] = "\$store.nav.setChosen('$item')"
                        a(href = "#", classes = "flex items-center  hover:bg-gray-700 px-4 py-2 rounded-lg") {
                            img(classes = "h-7 w-7 mr-3") {
                                attributes["x-bind:src"] = "\$store.nav.chosen === '$item' ? '/static/${item}_filled.svg' : '/static/${item}.svg'"
                                alt = "/static/loading.gif"
                            }
                            addContent(item)
                        }
                    }
                }
            }

            hr(classes = "my-4")

            h3(classes = "text-sm font-semibold  uppercase tracking-wider mb-2 ml-4") {
                +"Subscriptions"
            }

            ul(classes = "space-y-2") {
                listOf("Channel 1", "Channel 2", "Channel 3").forEachIndexed { index, channel ->
                    li {
                        a(href = "#", classes = "flex items-center hover:bg-gray-700 px-4 py-2 rounded-lg") {
                            img(
                                src = "https://placekitten.com/${24 + index}/${24 + index}",
                                alt = channel,
                                classes = "h-6 w-6 pl-1 rounded-full mr-3"
                            )
                            addContent(channel)
                        }
                    }
                }
            }
        }
    }
}
