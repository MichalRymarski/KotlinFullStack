package website.front.links

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script

const val  stylesheet = "stylesheet"
const val  styling = "/static/styling.css"
const val  Tailwind = "/static/output.css"
const val  HTMX = "https://unpkg.com/htmx.org"
const val  API_LINK = "http://127.0.0.1:8080"
const val  AlpineJS = "https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"
const val icons = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"

// Alpine.js Plugins
const val AlpineScroll = "https://cdn.jsdelivr.net/npm/@alpinejs/scroll@3.x.x/dist/cdn.min.js"


fun HTML.imports() {
    head {
        link(rel = stylesheet, href = styling, type = "text/css")
        link(rel = stylesheet, href = Tailwind, type = "text/css")
        link(rel = stylesheet, href = icons, type = "text/css")

        script(src = HTMX) {}
        script(src = AlpineJS) {
            defer = true
        }

        // Include Alpine.js plugins

        script(src = AlpineScroll) {
            defer = true
        }


    }
}