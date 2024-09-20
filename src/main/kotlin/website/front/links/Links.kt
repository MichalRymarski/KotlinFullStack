package website.front.links

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script

const val stylesheet = "stylesheet"
const val preconnect = "preconnect"
const val styling = "/static/styling.css"
const val Tailwind = "/static/output.css"
const val HTMX = "https://unpkg.com/htmx.org"
const val API_LINK = "http://127.0.0.1:8080"
const val AlpineJS = "https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"
const val icons = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
const val loopIcon = "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,100,0,0"
const val googleFont =
    "https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
const val closeIcon = "https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@24,400,0,0"

// Alpine.js Plugins
const val AlpineScroll = "https://cdn.jsdelivr.net/npm/@alpinejs/scroll@3.x.x/dist/cdn.min.js"
const val AlpineFocus = "https://cdn.jsdelivr.net/npm/@alpinejs/focus@3.x.x/dist/cdn.min.js"
const val AlpineMorph = "https://unpkg.com/htmx.org/dist/ext/alpine-morph.js"

fun HTML.imports() {
    head {
        link(rel = stylesheet, href = styling, type = "text/css")
        link(rel = stylesheet, href = Tailwind, type = "text/css")
        link(rel = stylesheet, href = icons, type = "text/css")
        link(rel = stylesheet, href = loopIcon)
        link(rel = stylesheet, href = closeIcon)
        link(rel = preconnect, href = "https://fonts.googleapis.com")
        link(rel = preconnect, href = "https://fonts.gstatic.com") {
            attributes["crossorigin"] = "true"
        }
        link(rel = stylesheet, href = googleFont)

        script(src = AlpineMorph){
            defer = true
        }
        script(src = HTMX) {}
        script(src = AlpineJS) {
            defer = true
        }

        // Include Alpine.js plugins

        script(src = AlpineScroll) {
            defer = true
        }
        script(src = AlpineFocus) {
            defer = true
        }
    }
}