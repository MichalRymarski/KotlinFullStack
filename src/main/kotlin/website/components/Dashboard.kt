package website.components

import kotlinx.html.*
import website.constants.*
import website.syntax_extensions.addContent

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

    }
}

