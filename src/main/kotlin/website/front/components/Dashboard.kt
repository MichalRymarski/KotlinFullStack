package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes
import website.syntax_extensions.classesToString

fun FlowContent.dashboard() = div {

    header {
        classes = classes("bg-yellow-200", "shadow-md")
        div {
            classes = classes(
                "mx-auto",
                "max-w-7xl",
                "px-4",
                "py-6",
                "sm:px-6",
                "lg:px-8"
            )
            div  {
                classes = classes(
                    "font-medium",
                    "text-3xl",
                    "tracking-light",
                    "text-gray-900",
                )
                a{
                    href = "$API_LINK/characters"
                    id = "dashboard"
                    classes = classes("cursor-pointer", "text-white")
                    addContent("Dashboard")
                }
            }
        }
    }
    main {
        classes = classes("mx-auto", "max-w-7xl", "py-6", "sm:py-6", "lg:py-8")
        input(
            type = InputType.text,
            formEncType = InputFormEncType.textPlain,
            classes = classesToString("border-2", "border-gray-300", "p-2")
        ) {
            id = "name"
            placeholder = "Enter your name"
            onInput = "fetchData(this.value)"
        }
        br {  }
        button(classes = classesToString("btn btn-primary","p-4","d-flex", "justify-content-center")) {
            id = "button"
            type = ButtonType.submit
            addContent("Submit")
        }
    }
}