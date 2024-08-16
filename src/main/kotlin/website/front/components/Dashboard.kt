package website.front.components

import kotlinx.html.*
import website.front.attributes.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent

fun FlowContent.dashboard() = div {

    header {
        classes = classes(backgroundColor(Color.YELLOW_200), shadow("md"))
        div {
            classes = classes(
                margin("auto"),
                maxWidth(MaxWidth.XL7),
                paddingX("4"),
                paddingY("6"),
                smPadding("6"),
                lgPadding("8")
            )
            div  {
                classes = classes(
                    fontWeight(FontWeight.MEDIUM),
                    fontSize(TextSize.XL3),
                    tracking("light"),
                    textColor(Color.GRAY_900),
                )
                a{
                    href = "$API_LINK/characters"
                    id = "dashboard"
                    classes = classes(cursor(CursorStyle.POINTER), textColor(Color.WHITE))
                    addContent("Dashboard")
                }
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

        button(classes = classesToString("btn btn-primary")) {
            id = "button"
            type = ButtonType.submit
            addContent("Submit")
        }

    }
}

