package website.front.components.shared

import kotlinx.html.*
import website.back.plugins.UserSession
import website.syntax_extensions.*

fun FlowContent.HeaderLoggedIn(userSession: UserSession) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    header(classes = classes("my-header text-white font-bold relative w-full z-10 fixed ")) {
        attributes["x-data"] = "{ isOpen: false }"
        YoutubeButton()
        SearchBar()
        ProfilePill(userSession)
        DropdownMenu(
            contentStyling = contentStyling("bg-customBlack"),
            contentPlacement = contentPlacement(" flex", "items-center", "justify-center z-30"),
            containerPlacement = containerPlacement("absolute right-3 top-10 z-20"),
            items = arrayOf(
                { ProfileLogo(userSession) },
                { GoToProfileButton(userSession) },
                { GoToChannelButton(userSession) },
                { LogoutButton() }
            )
        )
    }
}

fun FlowContent.GoToChannelButton(userSession: UserSession) {
    button(classes = "p-2 button") {
        attributes["hx-get"] = "/channel?email=${userSession.email}"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Your Channel")
    }
}

fun FlowContent.ProfileLogo(userSession: UserSession) {
    div(classes("relative w-full h-24 flex flex-col items-center justify-start")) {
        ProfilePill(userSession = userSession, disabled = true)
        span(classes = "p-2 block") {
            addContent(userSession.email)
        }
    }
}

fun FlowContent.GoToProfileButton(userSession: UserSession) {
    button(classes = "p-2 button") {
        attributes["hx-get"] = "/profile?email=${userSession.email}"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Your Profile")
    }
}

fun FlowContent.LogoutButton() {
    button(
        classes = classes(
            "w-10 h-10 p-2 button",
            "flex", "items-center", "justify-center",
            "rounded-full font-roboto",
        )
    ) {
        id = "profileButton"
        attributes["hx-get"] = "/logout"
        attributes["hx-target"] = "#home"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Logout")
    }
}