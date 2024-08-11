import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*
import website.addContent
import website.constants.*


const val stylesheet = "stylesheet"
const val tailwind = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
const val HTMX = "https://unpkg.com/htmx.org"
const val boootstrap = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"

fun Application.configureRouting() {
    routing {
        staticResources("/static", "static")

        get("/") {
            call.respondHtml(status = HttpStatusCode.OK) {
                head {
                    link(rel = stylesheet, href = tailwind, type = "text/css")
                    link(rel = stylesheet, href = boootstrap, type = "text/css")
                    script(src = HTMX) {}
                }
                body {
                    dashboard()
                    script { src = "/static/test.js" }
                }
            }
        }
    }
}

fun FlowContent.dashboard() = div {
    id = "content"
    header {
        classes = classes(backgroundColor(Color.WHITE), shadow())
        div {
            classes = classes(
                margin("auto"),
                maxWidth(MaxWidth.XL7),
                paddingX("4"),
                paddingY("6"),
                smPadding("6"),
                lgPadding("8")
            )
            h1 {
                classes = classes(
                    fontWeight(FontWeight.MEDIUM),
                    fontSize(TextSize.XL3),
                    tracking("light"),
                    textColor(Color.GRAY_900)
                )
                addContent("Dashboard")
            }
        }
    }
    main {
        classes = classes(margin("auto"), maxWidth(MaxWidth.XL7), paddingY("6"), smPadding("6"), lgPadding("8"))
        input(
            type = InputType.text,
            formEncType = InputFormEncType.textPlain,
            classes = classesToString(border("2"), borderColor(Color.GRAY_300), padding("2"))
        ) {
            id = "name"
            placeholder = "Enter your name"
            onInput = "fetchData(this.value)"
        }

        div{
            classes = classes(CONTAINER)
            div {
                classes = classes(ROW)
                for (i in 1..50) {
                    div {
                        classes = classes(COLUMN_3)
                        id = "characterDiv$i"
                        attributes[HX_GET] = "https://rickandmortyapi.com/api/character/$i"
                        attributes[HX_TRIGGER] = "load"
                        attributes[HX_SWAP] = "none"
                        img {
                            id = "characterImage$i"
                            classes = classes(
                                marginX("auto"),
                                marginY("3"),
                                display(Display.BLOCK),
                                ROUNDED
                            )
                        }
                    }
                }
            }
        }
    }
}