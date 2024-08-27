package website.front.components

import kotlinx.html.*
import website.syntax_extensions.*

fun FlowContent.dashboard() = div(classes = classes("relative")) {

    Header()


    main(
        classes(
            "mx-auto",
            "sm:py-6",
            "lg:py-8",
            "min-h-screen",
            "w-full",
            "relative",
            "flex justify-center",
            "text-center"
        )
    ) {
        attributes["x-data"] = "{ open: false }"

        div(
            classes("absolute top-0 left-0", "w-48 min-h-screen", "bg-gray-800", "transition-all duration-300")
        ) {
            attributes["x-show"] = "open"
            attributes["x-transition:enter"] = "transform translate-x-0 opacity-100"
            attributes["x-transition:enter-start"] = "transform -translate-x-full opacity-0"
            attributes["x-transition:leave-end"] = "transform -translate-x-full opacity-0"

            div(classes("border-t border-gray-500", "absolute", "top-0", "left-0", "w-full"))  //divider
            button(classes = classes("w-full h-12", "block")) {
                attributes["x-on:click"] = "open = !open"
                i(classes("fas fa-chevron-left"))
            }
            for (i in 0..5) {
                div(classes("border-t border-gray-500", "w-full"))  //divider
                div(classes("my-4")) {
                    addContent("Bazinga")
                }
            }
        }
        div(
            classes(
                "absolute top-0 -left-8",
                "w-12 h-12",
                "bg-gray-800",
                "transition-all",
                "duration-300",
                "-z-10",
                "transition duration-300 ease-in-out transform hover:translate-x-8"
            )
        ) {
            attributes["x-show"] = "!open"
            attributes["x-transition:enter"] = "opacity-100"
            attributes["x-transition:enter-start"] = "opacity-0"
            attributes["x-transition:leave-end"] = "opacity-0"

            div(classes("border-t border-gray-500", "w-full"))  //divider
            button(classes = classes(" w-full h-full ", "flex justify-end items-center")) {
                attributes["x-on:click"] = "open = !open"
                for (i in 1..4)
                    i(classes("fas fa-chevron-right"))
            }
        }

    }


    val dropdownItemStyling = classes("w-full", "text-gray-700", "p-2", "rounded-sm", "transition", "duration-200", "hover:bg-blue-100", "hover:text-blue-700")

    dropdownMenu(
        containerStyling = containerStyling("absolute top-4 right-4 bg-blue-400 text-white p-2 rounded-lg"),
        containerTransition = containerTransition("transition duration-400 easy-in-out hover:bg-blue-700 transform hover:scale-103"),
        contentStyling = contentStyling("text-gray-700 p-2 rounded-sm"),
        contentSize = contentSize("w-full"),
        contentTransition = contentTransition("transition duration-200 hover:bg-blue-100 hover:text-blue-700"),
        items = arrayOf(
            { LoginButton(classes = dropdownItemStyling) },
            { RegisterButton(classes = dropdownItemStyling) },
            { ToggleSwitch("dark-mode", "Dark Mode", classes = dropdownItemStyling) }
        )
    )


}






