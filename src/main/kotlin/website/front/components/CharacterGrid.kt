import kotlinx.html.*
import website.syntax_extensions.classes

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
            "block",
            "rounded-lg",
            transition
        )
    }
}


fun FlowContent.charactersGrid() = div {
    classes = classes(
        "grid",
        "grid-cols-4",
        "gap-8",
        "justify-center",
        "justify-items-center",
        "content-center",
        "py-6"
    )

    val transition = "transition duration-500 ease-in-out transform hover:scale-110"

    (1..200).forEach { index ->
        RoundedCharacterImage(index, transition)
    }
}

