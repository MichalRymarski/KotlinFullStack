package website.front.links

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script

const val stylesheet = "stylesheet"
const val styling = "/static/styling.css"
const val Tailwind = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
const val HTMX = "https://unpkg.com/htmx.org"
const val BootstrapCSS = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
const val API_LINK = "http://127.0.0.1:8081"
const val BootstrapJS = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
const val Popper = "https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"


fun HTML.imports() {
    head {
        link(rel = stylesheet, href = Tailwind, type = "text/css")
        link(rel = stylesheet, href = BootstrapCSS, type = "text/css")
        link(rel = stylesheet, href = styling, type = "text/css")

        script { src = Popper }
        script { src = BootstrapJS }


        script(src = HTMX) {}
    }
}