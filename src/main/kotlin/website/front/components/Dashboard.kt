package website.front.components

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.main
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuSidebar()
    main(
        classes("mx-auto", "sm:py-6", "lg:py-8", "min-h-screen", "w-full", "relative", "flex justify-center", "text-center")
    ) {
        attributes ["x-bind:class"] = "{ 'ml-56': sidebarOpen, 'ml-0': !sidebarOpen }"

        div(classes = classes("inline-block","w-full", "bg-gray-700","px-8")) {
            img(classes = classes("w-full", "h-full", "object-cover")) {
                src = "/static/background.jpg"
                alt = "Background Image"
            }
        }
    }

    val dropdownItemStyling = classes("w-full", "text-white font-bold", "p-2", "rounded-sm", "bg-gray-700", "transition  duration-200  hover:text-blue-700")

  /*  dropdownMenu(
        containerStyling = containerStyling("bg-blue-400 text-white font-bold p-2 rounded-lg"),
        containerPlacement = containerPlacement("absolute top-4 right-4 "),
        containerTransition = containerTransition("transition duration-400 easy-in-out hover:bg-blue-700 transform hover:scale-103"),
        containerSize = containerSize("w-48"),
        contentSize = contentSize("w-full"),
        contentTransition = contentTransition("transition duration-200 hover:scale-105"),
        contentStyling = contentStyling("bg-gray-700 text-white font-bold p-2 rounded-sm"),
        buttonText = "Settings",
        items = arrayOf(
            { LoginButton(classes = dropdownItemStyling) },
            { RegisterButton(classes = dropdownItemStyling) },
            { ToggleSwitch("dark-mode", "Dark Mode", classes = dropdownItemStyling) }
        )
    )*/
}







