package website.front.links

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script

const val stylesheet = "stylesheet"
const val styling = "/static/styling.css"
const val Tailwind = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
const val HTMX = "https://unpkg.com/htmx.org"
const val API_LINK = "http://127.0.0.1:8081"



fun HTML.imports() {
    head {
        link(rel = stylesheet, href = styling, type = "text/css")
        link(rel = stylesheet, href = Tailwind, type = "text/css")

        script(src = HTMX) {}
    }
}