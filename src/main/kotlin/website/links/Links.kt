package website.links

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script
import website.main

const val stylesheet = "stylesheet"
const val tailwind = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
const val HTMX = "https://unpkg.com/htmx.org"
const val boootstrap = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"


fun HTML.imports() {
    head {
        link(rel = stylesheet, href = tailwind, type = "text/css")
        link(rel = stylesheet, href = boootstrap, type = "text/css")
        script(src = HTMX) {}
    }
}