package website.front.components.shared

import kotlinx.html.FlowContent
import kotlinx.html.header
import website.front.components.MenuButton
import website.front.components.SignInButton
import website.front.components.signInIcon
import website.syntax_extensions.classes

fun FlowContent.HeaderNotLoggedIn() {
    attributes["x-data"] = "{ sidebarOpen: false }"

    header(classes = classes("my-header text-white font-bold relative w-full z-10 fixed ")) {
        MenuButton()
        YoutubeButton()
        SearchBar()
        SignInButton(signInIcon)
    }
}
