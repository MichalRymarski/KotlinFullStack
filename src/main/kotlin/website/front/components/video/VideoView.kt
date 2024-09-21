package website.front.components.video

import kotlinx.html.*
import website.back.plugins.UserSession
import website.front.components.HeaderLoggedIn
import website.front.components.HeaderNotLoggedIn
import website.front.components.MenuMovingSidebar
import website.syntax_extensions.classes

fun FlowContent.VideoView(id: Int, userSession: UserSession?) {
    attributes["x-data"] = "{ sidebarOpen: false }"
    div("fixed w-screen h-screen inset-0 bg-black bg-opacity-50 z-40 transition-opacity") {
        attributes["x-on:click"] = "sidebarOpen = false"
        attributes["x-show"] = "sidebarOpen"
        attributes["x-transition:enter"] = "ease-out duration-300"
        attributes["x-transition:enter-start"] = "opacity-0"
        attributes["x-transition:enter-end"] = "opacity-100"
        attributes["x-transition:leave"] = "ease-in duration-200"
        attributes["x-transition:leave-start"] = "opacity-100"
        attributes["x-transition:leave-end"] = "opacity-0"
    }

    if(userSession != null) {
        HeaderLoggedIn(userSession)
    } else {
        HeaderNotLoggedIn()
    }
    MenuMovingSidebar()
    PlayerAndSideContent()
}

private fun FlowContent.PlayerAndSideContent() {
    div("w-full h-screen overflow-y-auto my-background relative") {
        div("container right-8 absolute p-4") {
            attributes["x-data"] = "{ cinematicMode: false }"

            div("flex flex-col lg:flex-row") {
                attributes["x-bind:class"] = "{ 'lg:flex-col': cinematicMode }"

                div("w-full") {
                    attributes["x-bind:class"] = "{ 'max-w-none': cinematicMode, 'max-w-4xl': !cinematicMode }"
                    attributes["x-data"] = "{ hovered: true }"

                    div("relative") {
                        attributes["x-data"] = "videoPlayer"

                        video(classes = "w-full aspect-video bg-black rounded-full cursor-pointer") {
                            attributes["x-ref"] = "video"
                            attributes["x-on:click"] = "togglePlay"
                            attributes["x-on:timeupdate"] = "updateProgress"
                            attributes["x-on:loadedmetadata"] = "initializeVideo"

                            source {
                                src =
                                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                                type = "video/mp4"
                            }
                            +"Your browser does not support the video tag."
                        }

                        div("absolute bottom-0 left-0 right-0 bg-gradient-to-t from-black to-transparent p-4") {
                            attributes["x-bind:class"] =
                                "{ 'opacity-0': !hovered && isPlaying, 'opacity-100': hovered || !isPlaying }"
                            attributes["x-on:mouseover"] = "hovered = true"
                            attributes["x-on:mouseleave"] = "hovered = false"

                            div("flex items-center justify-between text-white") {
                                div("flex items-center space-x-4") {
                                    button(classes = "focus:outline-none") {
                                        attributes["x-on:click"] = "togglePlay"
                                        attributes["aria-label"] = "Play/Pause"

                                        val playSvg =
                                            """<svg x-show="!isPlaying" class="w-8 h-8" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM9.555 7.168A1 1 0 008 8v4a1 1 0 001.555.832l3-2a1 1 0 000-1.664l-3-2z" clip-rule="evenodd" /></svg>"""
                                        val pauseSvg =
                                            """<svg x-show="isPlaying" class="w-8 h-8" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zM7 8a1 1 0 012 0v4a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v4a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd" /></svg>"""

                                        unsafe { +playSvg }
                                        unsafe { +pauseSvg }
                                    }

                                    button(classes = "focus:outline-none") {
                                        attributes["x-on:click"] = "skip(-10)"
                                        attributes["aria-label"] = "Rewind 10 seconds"
                                        unsafe {
                                            +"""<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm.707-10.293a1 1 0 00-1.414-1.414l-3 3a1 1 0 000 1.414l3 3a1 1 0 001.414-1.414L9.414 11H13a1 1 0 100-2H9.414l1.293-1.293z" clip-rule="evenodd" /></svg>"""
                                        }
                                    }

                                    button(classes = "focus:outline-none") {
                                        attributes["x-on:click"] = "skip(10)"
                                        attributes["aria-label"] = "Forward 10 seconds"
                                        unsafe {
                                            +"""<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-8.707l-3-3a1 1 0 00-1.414 1.414L10.586 9H7a1 1 0 100 2h3.586l-1.293 1.293a1 1 0 101.414 1.414l3-3a1 1 0 000-1.414z" clip-rule="evenodd" /></svg>"""
                                        }
                                    }

                                    div("flex items-center space-x-2") {
                                        unsafe {
                                            +"""<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M9.383 3.076A1 1 0 0110 4v12a1 1 0 01-1.707.707L4.586 13H2a1 1 0 01-1-1V8a1 1 0 011-1h2.586l3.707-3.707a1 1 0 011.09-.217zM14.657 2.929a1 1 0 011.414 0A9.972 9.972 0 0119 10a9.972 9.972 0 01-2.929 7.071 1 1 0 01-1.414-1.414A7.971 7.971 0 0017 10c0-2.21-.894-4.208-2.343-5.657a1 1 0 010-1.414zm-2.829 2.828a1 1 0 011.415 0A5.983 5.983 0 0115 10a5.984 5.984 0 01-1.757 4.243 1 1 0 01-1.415-1.415A3.984 3.984 0 0013 10a3.983 3.983 0 00-1.172-2.828 1 1 0 010-1.415z" clip-rule="evenodd" /></svg>"""
                                        }
                                        input(type = InputType.range, classes = "w-20") {
                                            attributes["min"] = "0"
                                            attributes["max"] = "1"
                                            attributes["step"] = "0.1"
                                            attributes["x-model"] = "volume"
                                            attributes["x-on:input"] = "changeVolume"
                                            attributes["aria-label"] = "Volume"
                                        }
                                    }
                                }

                                div("flex items-center space-x-4") {
                                    button(classes = "focus:outline-none") {
                                        attributes["x-on:click"] = "cinematicMode = !cinematicMode"
                                        attributes["aria-label"] = "Toggle cinematic mode"
                                        unsafe {
                                            +"""<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M4 3a2 2 0 00-2 2v10a2 2 0 002 2h12a2 2 0 002-2V5a2 2 0 00-2-2H4zm3 2h6v4H7V5zm8 8v2h1v-2h-1zm-2-2H7v4h6v-4zm2 0h1V9h-1v2zm1-4V5h-1v2h1zM5 5v2H4V5h1zm0 4H4v2h1V9zm-1 4h1v2H4v-2z" clip-rule="evenodd" /></svg>"""
                                        }
                                    }

                                    button(classes = "focus:outline-none") {
                                        attributes["x-on:click"] = "toggleFullscreen"
                                        attributes["aria-label"] = "Toggle fullscreen"
                                        unsafe {
                                            +"""<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"><path fill-rule="evenodd" d="M3 4a1 1 0 011-1h4a1 1 0 010 2H6.414l2.293 2.293a1 1 0 11-1.414 1.414L5 6.414V8a1 1 0 01-2 0V4zm9 1a1 1 0 010-2h4a1 1 0 011 1v4a1 1 0 01-2 0V6.414l-2.293 2.293a1 1 0 11-1.414-1.414L13.586 5H12zm-9 7a1 1 0 012 0v1.586l2.293-2.293a1 1 0 111.414 1.414L6.414 15H8a1 1 0 010 2H4a1 1 0 01-1-1v-4zm13-1a1 1 0 011 1v4a1 1 0 01-1 1h-4a1 1 0 010-2h1.586l-2.293-2.293a1 1 0 111.414-1.414L15 13.586V12a1 1 0 011-1z" clip-rule="evenodd" /></svg>"""
                                        }
                                    }
                                }
                            }

                            div("mt-2") {
                                div("rounded-full h-1.5 w-full cursor-pointer") {
                                    attributes["x-on:click"] = "seekTo(\$event)"
                                    div("bg-red-600 h-1.5 rounded-full") {
                                        attributes["x-bind:style"] = "{ width: `\${progress}%` }"
                                    }
                                }
                            }
                        }
                    }
                }

                div("w-full lg:w-1/3 mt-4 lg:mt-0 lg:pl-4") {
                    attributes["x-bind:class"] = "{ 'lg:w-full lg:pl-0': cinematicMode, 'lg:max-w-sm': !cinematicMode }"
                    div("grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-1 gap-4") {
                        attributes["x-bind:class"] = "{ 'xl:grid-cols-3': cinematicMode }"
                        repeat(5) { VideoThumbnail(it) }
                    }
                }
            }
        }
        div(classes = classes("h-32"))
    }
}

