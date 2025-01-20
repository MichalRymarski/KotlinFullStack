package website.front.components.video

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.h3
import kotlinx.html.img
import website.VideoObject

fun FlowContent.VideoThumbnail(video: VideoObject) {
    div("flex flex-col transition-all duration-300 cursor-pointer mb-4") {
        attributes["x-data"] = "{ hovered: false, timeout: null }"
        attributes["x-on:mouseenter"] = "timeout = setTimeout(() => hovered = true, 500)"
        attributes["x-on:mouseleave"] = "clearTimeout(timeout); hovered = false"

        div("relative w-full pt-[56.25%]") {
            div("absolute inset-0  overflow-hidden") {
                attributes["x-bind:class"] =
                    """hovered ? 'rounded-none transition-all duration-300 ease-in-out' : 'rounded-lg transition-all duration-300 ease-in-out'"""
                attributes["hx-get"] = "/video/${video.id}"
                attributes["hx-target"] = "#home"
                attributes["hx-push-url"] = "true"
                attributes["hx-swap"] = "innerHTML"
                attributes["hx-trigger"] = "click"
                attributes["hx-vals"] = """{"isOpen": false}"""

                img(classes = "w-full h-full object-cover") {
                    src = video.thumbnailUrl
                    alt = "Video preview"
                }
            }
        }

        div("mt-2 flex justify-center") {
            div("flex-grow text-center") {
                h3("text-xl my-video-title mb-1 line-clamp-2") {
                    +video.title
                }
            }
        }
    }
}

