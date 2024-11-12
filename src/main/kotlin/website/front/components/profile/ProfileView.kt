package website.front.components.profile

import kotlinx.html.*
import website.back.plugins.UserSession
import website.syntax_extensions.addContent

fun FlowContent.ProfileView(userSession: UserSession) {
    div("bg-customBlack text-gray-200 font-roboto scrollbar-hide min-h-screen") {
        a(classes = "absolute top-4 left-4 text-white text-lg font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline") {
            href = "javascript:history.back()"
            i(classes = "fas fa-arrow-left")
        }
        div("container mx-auto px-4 py-8") {
            h1("text-3xl font-bold mb-8 text-center text-gray-100") {
                addContent("Your Profile")
            }
            div("bg-customGray shadow-lg rounded-lg max-w-5xl mx-auto p-6") {
                form(classes = "flex flex-col md:flex-row") {


                    div("md:w-2/5 pr-0 md:pr-6 mb-6 md:mb-0") {
                        div("mb-6") {
                            label("block text-lg font-medium text-gray-300 mb-2") {
                                htmlFor = "profile-picture"
                                addContent("Profile Picture")
                            }
                            div("flex flex-col items-center") {
                                if (userSession.profilePictureUrl.isBlank()) {
                                    div(classes = "w-64 h-64 rounded-full flex items-center justify-center mb-4 bg-gray-700") {
                                        id = "profileButton"
                                        style = "background-color: ${userSession.color}"
                                        span("text-9xl") {
                                            addContent(userSession.getInitial().toString())
                                        }
                                    }
                                } else {
                                    img(classes = "w-64 h-64 rounded-full object-cover mb-4 bg-gray-700") {
                                        id = "preview"
                                        src = userSession.profilePictureUrl
                                        alt = "Profile picture preview"
                                    }
                                }
                                input(classes = "block w-full text-lg text-gray-400 file:mr-4 file:py-2 file:px-4 file:rounded-full file:border-0 file:text-lg file:font-semibold file:bg-gray-700 file:text-gray-200 hover:file:bg-gray-600") {
                                    type = InputType.file
                                    id = "profile-picture"
                                    name = "profile-picture"
                                    accept = "image/*"
                                }
                            }
                        }
                    }
                    div("md:w-3/5") {
                        div("mb-6") {
                            label("block text-lg font-medium text-gray-300 mb-2") {
                                htmlFor = "nickname"
                                addContent("Nickname")
                            }
                            input(classes = "mt-1 block w-full rounded-md bg-gray-700 border-gray-600 shadow-base focus:border-blue-500 focus:ring focus:ring-blue-500 focus:ring-opacity-50 text-gray-200 py-3") {
                                type = InputType.text
                                id = "nickname"
                                name = "nickname"
                                value = userSession.nick
                            }
                        }
                        div("mb-6") {
                            label("block text-lg font-medium text-gray-300 mb-2") {
                                htmlFor = "email"
                                addContent("Email")
                            }
                            input(classes = "mt-1 block w-full rounded-md bg-gray-800 border-gray-700 shadow-base text-gray-400 cursor-default py-3") {
                                type = InputType.email
                                id = "email"
                                name = "email"
                                readonly = true
                                value = userSession.email
                            }
                        }
                        div("flex justify-between items-center pt-24 ") {
                            button(classes = "bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline") {
                                type = ButtonType.submit
                                attributes["hx-post"] = "/profile"
                                attributes["hx-target"] = "#nickname"
                                attributes["hx-swap"] = "outerHTML"

                                addContent("Save Changes")
                            }
                            a(classes = "bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline") {
                                href = "/channel"
                                addContent("Go to My Channel")
                            }
                        }
                    }
                }
            }
        }
    }
}