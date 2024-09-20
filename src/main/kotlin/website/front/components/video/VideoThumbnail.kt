package website.front.components.video

import kotlinx.html.*

fun FlowContent.VideoThumbnail(id: Int) {
    div("flex flex-col transition-all duration-300 cursor-pointer mb-4") {
        attributes["x-data"] = "{ hovered: false, timeout: null }"
        attributes["x-on:mouseenter"] = "timeout = setTimeout(() => hovered = true, 500)"
        attributes["x-on:mouseleave"] = "clearTimeout(timeout); hovered = false"

        div("relative w-full pt-[56.25%]") {
            div("absolute inset-0  overflow-hidden") {
                attributes["x-bind:class"] = """hovered ? 'rounded-none transition-all duration-300 ease-in-out' : 'rounded-lg transition-all duration-300 ease-in-out'"""
                attributes["hx-get"] = "/video/$id"
                attributes["hx-target"] = "#home"
                attributes["hx-push-url"] = "true"
                attributes["hx-swap"] = "innerHTML"
                attributes["hx-trigger"] = "click"

                img(classes = "w-full h-full object-cover") {
                    src = "https://picsum.photos/id/${200 + id}/320/180"
                    alt = "Video preview"
                }
            }
        }

        div("mt-2 flex") {
            div("flex-shrink-0 mr-3") {
                div("w-9 h-9 rounded-full bg-gray-300")
            }
            div("flex-grow") {
                h3("text-base my-video-title mb-1 line-clamp-2") {
                    +"Video Title $id - This is a longer title to demonstrate wrapping"
                }
                p("text-sm my-video-details") { +"Channel Name" }
                p("text-sm my-video-details") { +"123K views • 2 days ago" }
            }
        }
    }
}

fun FlowContent.VideoThumbnailList(count: Int) {
    div("space-y-4") {
        for (i in 1..count) {
            VideoThumbnail(i)
        }
    }
}