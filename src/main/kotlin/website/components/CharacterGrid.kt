
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.html.*
import website.KtorClient
import website.constants.*
import website.dto.Character

private fun DIV.RoundedCharacterImage(character: Character, transition: String) {
    img(alt = "Character Image ${character.id}") {
        attributes["onerror"] = "console.log('Error loading image ${character.id}')"
        src = character.image
        id = "characterImage${character.id}"
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
            CoroutineScope(Dispatchers.IO).launch{
                    val character = KtorClient.fetchCharacter(index)
                    div {
                        classes = classes(COLUMN_3)
                        id = "characterDiv${character.id}"
                        RoundedCharacterImage(character, transition)
                    }
                }
            }
        }
    }

