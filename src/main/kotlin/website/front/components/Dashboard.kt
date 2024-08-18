package website.front.components

import kotlinx.html.*
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative")) {

    header(classes = classes("bg-yellow-200", "shadow-md")) {
        div(classes = classes("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")) {
            div(
                classes = classes("font-medium", "text-3xl", "tracking-light", "text-gray-900")
            ) {
                a(classes = classes("cursor-pointer", "text-white")) {
                    href = "$API_LINK/characters"
                    id = "dashboard"
                    addContent("Dashboard")
                }
            }

        }
    }

    main(classes = classes("mx-auto", "max-w-7xl", "py-6", "sm:py-6", "lg:py-8", "h-48")) {
        id = "main-content"

        audio {
            controls = true
            src = "/static/bazinga.mp3"
        }
        iframe(classes = classes("w-96", "mx-auto", "h-96")) {
            src = "https://www.youtube.com/embed/r0lDBzKCGAM"
            attributes["frameborder"] = "0"
            attributes["allow"] =
                "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            attributes["allowfullscreen"] = "true"
        }
    }


    val dropdownItemStyling = classes(
        "w-full",
        "text-gray-700", // Changed text color
        "p-2",
        "rounded-sm",
        "transition",
        "duration-200",
        "hover:bg-blue-100", // Lighter hover effect
        "hover:text-blue-700" // Text color change on hover
    )

    dropdownMenu(
        "absolute top-4 right-4 bg-blue-400 text-white p-2 rounded-lg transition duration-400 easy-in-out hover:bg-blue-700 transform hover:scale-103",
        {
            LoginButton(classes = dropdownItemStyling)
        },
        {
            RegisterButton(classes = dropdownItemStyling)
        },
        {
            RegisterButton(classes = dropdownItemStyling)
        },
        {
            RegisterButton(classes = dropdownItemStyling)
        },
    )


}




