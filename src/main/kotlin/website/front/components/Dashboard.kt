package website.front.components

import kotlinx.html.*
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuMovingSidebar()
    MenuStaticSidebar()
    main(classes("mx-auto","my-background", "sm:py-6", "lg:py-8", "min-h-screen", "w-full", "relative", "flex justify-center", "text-center")) {
        attributes ["x-bind:class"] = "{ 'ml-56': sidebarOpen, 'ml-0': !sidebarOpen }"

        div(classes = classes("inline-block","w-full", "px-8")) {
            img(classes = classes("w-full", "h-full", "object-cover")) {
                src = "/static/background.jpg"
                alt = "Background Image"
            }
        }
    }

}

fun DIV.MenuStaticSidebar() {
    aside(classes = classes("left-0 h-full my-sidebar")){

    }
}







