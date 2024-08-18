import kotlinx.html.*
import website.syntax_extensions.classes

private fun DIV.CharacterImage(index: Int, transition : String) {
    div(
        classes = classes(
            "w-full",
            "aspect-square",
            "overflow-hidden",
            "rounded-lg",
            "relative",
            "cursor-pointer"
        )
    ) {
        onClick = "toggleCheckbox('checkbox$index', event)"

        img(
            classes = classes(
                "w-full",
                "h-full",
                "object-cover",
                transition
            )
        ) {
            alt = "Character Image $index"
            src = "/static/loading.gif"
            id = "characterImage$index"
            onLoad = "swapImageFromJson('https://rickandmortyapi.com/api/character/$index', 'characterImage$index')"
            onError = "console.log('Error loading image $index')"

            checkBoxInput(classes = classes("absolute", "top-0", "right-0", "m-2", "pointer-events-none")) {
                id = "checkbox$index"
                value = "unchecked"
            }
        }
    }
}

fun FlowContent.charactersGrid() =
    div(
        classes = classes(
            "container",
            "mx-auto",
            "px-4",
            "py-8"
        )
    ) {
        val transition = "transition duration-300 ease-in-out transform hover:scale-105"

        div(
            classes = classes(
                "grid",
                "grid-cols-2",
                "sm:grid-cols-3",
                "md:grid-cols-4",
                "lg:grid-cols-5",
                "gap-4"
            )
        )
        {
            (1..200).forEach { index ->
                CharacterImage(index,transition)
            }
        }
    }


