
import kotlinx.html.*
import website.front.attributes.*

private fun DIV.RoundedCharacterImage(index: Int, transition: String) {
    val url = "https://rickandmortyapi.com/api/character/$index"
    val characterID = "characterImage$index"

    img(alt = "Character Image $index") {
        onLoad = "swapImageFromJson('$url', '$characterID')"
        onError = "console.log('Error loading image $index)"
        onClick = "addTransitionEffect('$characterID')"
        src = "/static/loading.gif"
        id = characterID
        classes = classes(
            marginX("auto"),
            marginY("3"),
            display(Display.BLOCK),
            ROUNDED_CIRCLE,
            transition
        )
    }
}


fun FlowContent.charactersGrid() = div {
    classes = classes(CONTAINER)
    div {
        classes = classes(ROW)
        val transition = Transition.Builder()
            .applyTransitionType(TransitionType.TRANSFORM)
            .applyDuration("500")
            .applyEase(TransitionEase.EASE_IN_OUT)
            .applyEffect(hover1 { scale("110") })
            .build()

        (1..200).forEach { index ->
            div {
                classes = classes(COLUMN_2)
                RoundedCharacterImage(index, transition)
            }
        }
    }
}

