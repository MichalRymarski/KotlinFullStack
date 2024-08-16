package website.components

import kotlinx.html.*
import website.constants.*
import website.links.API_LINK
import website.syntax_extensions.addContent

fun FlowContent.dashboard() = div {
    val transition = Transition.Builder()
        .applyTransitionType(TransitionType.TRANSFORM)
        .applyDuration("500")
        .applyEase(TransitionEase.EASE_IN_OUT)
        .applyEffect(hover1 { scale("110") })
        .build()

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
            div {
                classes = classes(
                    fontWeight(FontWeight.MEDIUM),
                    fontSize(TextSize.XL3),
                    tracking("light"),
                    textColor(Color.GRAY_900),
                )
                span {
                    onClick = "navigateTo('$API_LINK/characters')"
                    id = "dashboard"
                    classes = classes(cursor(CursorStyle.POINTER),transition)
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

    }
}

