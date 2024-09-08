@file:Suppress("unused")

package website.front.components

import kotlinx.html.*
import website.front.Colors
import website.front.links.API_LINK
import website.syntax_extensions.addContent
import website.syntax_extensions.classes
import website.syntax_extensions.contentClasses

fun FORM.formInput(
    inputType: InputType,
    inputPlaceholder: String,
    inputRequired: Boolean,
    inputId: String
) {
    input(
        classes = classes(
            "w-full",
            "border-2",
            "border-gray-900",
            "bg-gray-500",
            "p-2",
            "h-12",
            "rounded",
            "focus:outline-none",
            "focus:border-gray-400"
        )
    ) {
        type = inputType
        formEncType = InputFormEncType.textPlain
        placeholder = inputPlaceholder
        required = inputRequired
        id = inputId
        name = inputId
    }
}

fun FORM.formButton(content: String, usernameID: String, passwordID: String, link: String) {
    button(
        classes = classes(
            "w-full",
            "bg-gradient-to-r",
            "from-blue-500",
            "to-indigo-500",
            "text-white",
            "rounded-lg",
            "p-3",
            "mt-4",
            "transition duration-300 ease-in-out hover:bg-blue-600 transform hover:scale-102",
        )
    ) {
        onClick =
            "console.log('Username:', document.getElementById('$usernameID').value, 'Password:', document.getElementById('$passwordID').value)"
        attributes["hx-post"] = link
        attributes["hx-include"] = "#$usernameID,#$passwordID"
        attributes["hx-push-url"] = "true"
        attributes["hx-trigger"] = "click"
        attributes["hx-redirect"] = "true"
        attributes["hx-on::after-request"] =
            "if(event.detail.failed) htmx.find('#error').innerHTML = event.detail.xhr.responseText;"

        type = ButtonType.submit
        addContent(content)
    }
}

fun DIV.LoginButton(classes: String) {
    button(classes = classes) {
        attributes["hx-get"] = "$API_LINK/login"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Login")
    }
}

fun DIV.RegisterButton(classes: String) {
    button(classes = classes) {
        attributes["hx-get"] = "$API_LINK/register"
        attributes["hx-target"] = "#home"
        attributes["hx-push-url"] = "true"
        attributes["hx-swap"] = "innerHTML"
        attributes["hx-trigger"] = "click"
        addContent("Register")
    }
}

fun DIV.dropdownMenu(
    containerStyling: String? = null,
    contentStyling: String? = null,
    containerPlacement: String? = null,
    contentPlacement: String? = null,
    containerSize: String? = null,
    contentSize: String? = null,
    containerTransition: String? = null,
    contentTransition: String? = null,
    buttonText: String? = null,
    vararg items: DIV.() -> Unit
) {
    div(classes = contentClasses(containerStyling, containerPlacement, containerTransition)) {
        div(classes = classes("relative", "inline-block")) {
            attributes["x-data"] = "{ isOpen: false }"
            button(
                classes = classes(
                    containerSize,
                    "py-2",
                    "inline-flex",
                    "items-center",
                    "justify-center"
                )
            ) {
                attributes["x-on:click"] = "isOpen = !isOpen"
                addContent(buttonText ?: "")
                i(classes("ml-1")) {
                    attributes["x-bind:class"] = "isOpen ? 'fas fa-chevron-up' : 'fas fa-chevron-down'"
                }
            }
            div(
                classes = classes(
                    "absolute",
                    contentStyling,
                    "mt-2",
                    "py-2",
                    "w-48",
                    "shadow-lg",
                    "z-10",
                    "center",
                    "rounded-md",
                    "border",
                    "border-gray-200",
                    "transition-all",
                    "transform",
                    "scale-95",
                    "origin-top-right",
                    "right-0",
                    "mt-2"
                )
            ) {
                attributes["x-show"] = "isOpen"
                attributes["x-transition:enter"] = "transition ease-out duration-150"
                attributes["x-transition:enter-start"] = "opacity-0"
                attributes["x-transition:enter-end"] = "opacity-100"
                attributes["x-transition:leave"] = "transition ease-in duration-150"
                attributes["x-transition:leave-start"] = "opacity-100"
                attributes["x-transition:leave-end"] = "opacity-0"
                id = "dropdownContent"
                items.forEachIndexed { index, item ->
                    div(
                        classes = contentClasses(
                            contentPlacement,
                            contentTransition,
                            contentSize,
                            if (index != items.size - 1) "border-b border-gray-600" else "" // Add border between items except for the last one
                        )
                    ) {
                        item()
                    }
                }
            }
        }
    }
}

fun FlowContent.codeBlock(language: String, code: String) {
    pre(
        classes = classes(
            "bg-gray-800",
            "rounded-md",
            "p-4",
            "overflow-x-auto",
            "text-sm",
            "text-white"
        )
    ) {
        code(classes = classes("language-$language")) {
            +code
        }
    }
}

fun DIV.ToggleSwitch(id: String, label: String, classes: String? = null) {
    div(classes = classes("flex", "items-center", classes.toString())) {
        attributes["x-data"] = "{ isOn: false }"

        label(classes = classes("flex", "items-center", "cursor-pointer")) {
            input(type = InputType.checkBox, classes = classes("hidden")) {
                this.id = id
                attributes["x-model"] = "isOn"
            }
            label(classes = classes("ml-2")) {
                addContent(label)
            }

            div(
                classes = classes(
                    "w-10", "h-6", "rounded-full", "shadow-inner",
                    "transition-colors", "duration-300", "ease-in-out",
                    "flex", "items-center", "ml-4"
                )
            ) {
                attributes["x-bind:class"] = "isOn ? 'bg-blue-500' : 'bg-gray-400'"

                div(
                    classes = classes(
                        "w-4", "h-4", "bg-white", "rounded-full", "shadow",
                        "transition-transform", "duration-300", "ease-in-out"
                    )
                ) {
                    attributes["x-bind:class"] = "isOn ? 'transform translate-x-5' : 'transform translate-x-0.5'"
                }
            }
        }
    }
}

fun DIV.headerNotLoggedIn() {
    val menuIcon = "<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"24\" viewBox=\"0 0 24 24\" width=\"24\" focusable=\"false\" aria-hidden=\"true\" style=\"pointer-events: none; display: inherit; width: 100%; height: 100%;\" fill=\"${Colors.text}\"><path d=\"M21 6H3V5h18v1zm0 5H3v1h18v-1zm0 6H3v1h18v-1z\"></path></svg>"
    val signInIcon = "<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"24\" viewBox=\"0 0 24 24\" width=\"24\" focusable=\"false\" aria-hidden=\"true\" style=\"pointer-events: none; display: inherit; width: 100%; height: 100%;\" fill=\"currentColor\"><path  d=\"M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 1c4.96 0 9 4.04 9 9 0 1.42-.34 2.76-.93 3.96-1.53-1.72-3.98-2.89-7.38-3.03A3.996 3.996 0 0016 9c0-2.21-1.79-4-4-4S8 6.79 8 9c0 1.97 1.43 3.6 3.31 3.93-3.4.14-5.85 1.31-7.38 3.03C3.34 14.76 3 13.42 3 12c0-4.96 4.04-9 9-9zM9 9c0-1.65 1.35-3 3-3s3 1.35 3 3-1.35 3-3 3-3-1.35-3-3zm3 12c-3.16 0-5.94-1.64-7.55-4.12C6.01 14.93 8.61 13.9 12 13.9c3.39 0 5.99 1.03 7.55 2.98C17.94 19.36 15.16 21 12 21z\"></path></svg>"
    val youtubeLogo = """<svg xmlns="http://www.w3.org/2000/svg" id="yt-logo-updated-svg_yt9" class="external-icon" viewBox="0 0 90 20" focusable="false" aria-hidden="true" style="pointer-events: none; display: inherit; width: 100%; height: 100%;">
            <svg id="yt-logo-updated_yt9" viewBox="0 0 90 20" preserveAspectRatio="xMidYMid meet" xmlns="http://www.w3.org/2000/svg">
                <g>
                    <path d="M27.9727 3.12324C27.6435 1.89323 26.6768 0.926623 25.4468 0.597366C23.2197 2.24288e-07 14.285 0 14.285 0C14.285 0 5.35042 2.24288e-07 3.12323 0.597366C1.89323 0.926623 0.926623 1.89323 0.597366 3.12324C2.24288e-07 5.35042 0 10 0 10C0 10 2.24288e-07 14.6496 0.597366 16.8768C0.926623 18.1068 1.89323 19.0734 3.12323 19.4026C5.35042 20 14.285 20 14.285 20C14.285 20 23.2197 20 25.4468 19.4026C26.6768 19.0734 27.6435 18.1068 27.9727 16.8768C28.5701 14.6496 28.5701 10 28.5701 10C28.5701 10 28.5677 5.35042 27.9727 3.12324Z" fill="#FF0000" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #ff1a1a;"></path>
                    <path d="M11.4253 14.2854L18.8477 10.0004L11.4253 5.71533V14.2854Z" fill="white" data-darkreader-inline-fill="" style="--darkreader-inline-fill: ${Colors.text};"></path>
                </g>
                <g>
                    <g id="youtube-paths_yt9">
                        <path fill="${Colors.text}" d="M34.6024 13.0036L31.3945 1.41846H34.1932L35.3174 6.6701C35.6043 7.96361 35.8136 9.06662 35.95 9.97913H36.0323C36.1264 9.32532 36.3381 8.22937 36.665 6.68892L37.8291 1.41846H40.6278L37.3799 13.0036V18.561H34.6001V13.0036H34.6024Z"></path>
                        <path fill="${Colors.text}" d="M41.4697 18.1937C40.9053 17.8127 40.5031 17.22 40.2632 16.4157C40.0257 15.6114 39.9058 14.5437 39.9058 13.2078V11.3898C39.9058 10.0422 40.0422 8.95805 40.315 8.14196C40.5878 7.32588 41.0135 6.72851 41.592 6.35457C42.1706 5.98063 42.9302 5.79248 43.871 5.79248C44.7976 5.79248 45.5384 5.98298 46.0981 6.36398C46.6555 6.74497 47.0647 7.34234 47.3234 8.15137C47.5821 8.96275 47.7115 10.0422 47.7115 11.3898V13.2078C47.7115 14.5437 47.5845 15.6161 47.3329 16.4251C47.0812 17.2365 46.672 17.8292 46.1075 18.2031C45.5431 18.5771 44.7764 18.7652 43.8098 18.7652C42.8126 18.7675 42.0342 18.5747 41.4697 18.1937ZM44.6353 16.2323C44.7905 15.8231 44.8705 15.1575 44.8705 14.2309V10.3292C44.8705 9.43077 44.7929 8.77225 44.6353 8.35833C44.4777 7.94206 44.2026 7.7351 43.8074 7.7351C43.4265 7.7351 43.156 7.94206 43.0008 8.35833C42.8432 8.77461 42.7656 9.43077 42.7656 10.3292V14.2309C42.7656 15.1575 42.8408 15.8254 42.9914 16.2323C43.1419 16.6415 43.4123 16.8461 43.8074 16.8461C44.2026 16.8461 44.4777 16.6415 44.6353 16.2323Z"></path>
                        <path fill="${Colors.text}" d="M56.8154 18.5634H54.6094L54.3648 17.03H54.3037C53.7039 18.1871 52.8055 18.7656 51.6061 18.7656C50.7759 18.7656 50.1621 18.4928 49.767 17.9496C49.3719 17.4039 49.1743 16.5526 49.1743 15.3955V6.03751H51.9942V15.2308C51.9942 15.7906 52.0553 16.188 52.1776 16.4256C52.2999 16.6631 52.5045 16.783 52.7914 16.783C53.036 16.783 53.2712 16.7078 53.497 16.5573C53.7228 16.4067 53.8874 16.2162 53.9979 15.9858V6.03516H56.8154V18.5634Z"></path>
                        <path fill="${Colors.text}" d="M64.4755 3.68758H61.6768V18.5629H58.9181V3.68758H56.1194V1.42041H64.4755V3.68758Z"></path>
                        <path fill="${Colors.text}" d="M71.2768 18.5634H69.0708L68.8262 17.03H68.7651C68.1654 18.1871 67.267 18.7656 66.0675 18.7656C65.2373 18.7656 64.6235 18.4928 64.2284 17.9496C63.8333 17.4039 63.6357 16.5526 63.6357 15.3955V6.03751H66.4556V15.2308C66.4556 15.7906 66.5167 16.188 66.639 16.4256C66.7613 16.6631 66.9659 16.783 67.2529 16.783C67.4974 16.783 67.7326 16.7078 67.9584 16.5573C68.1842 16.4067 68.3488 16.2162 68.4593 15.9858V6.03516H71.2768V18.5634Z"></path>
                        <path fill="${Colors.text}" d="M80.609 8.0387C80.4373 7.24849 80.1621 6.67699 79.7812 6.32186C79.4002 5.96674 78.8757 5.79035 78.2078 5.79035C77.6904 5.79035 77.2059 5.93616 76.7567 6.23014C76.3075 6.52412 75.9594 6.90747 75.7148 7.38489H75.6937V0.785645H72.9773V18.5608H75.3056L75.5925 17.3755H75.6537C75.8724 17.7988 76.1993 18.1304 76.6344 18.3774C77.0695 18.622 77.554 18.7443 78.0855 18.7443C79.038 18.7443 79.7412 18.3045 80.1904 17.4272C80.6396 16.5476 80.8653 15.1765 80.8653 13.3092V11.3266C80.8653 9.92722 80.7783 8.82892 80.609 8.0387ZM78.0243 13.1492C78.0243 14.0617 77.9867 14.7767 77.9114 15.2941C77.8362 15.8115 77.7115 16.1808 77.5328 16.3971C77.3564 16.6158 77.1165 16.724 76.8178 16.724C76.585 16.724 76.371 16.6699 76.1734 16.5594C75.9759 16.4512 75.816 16.2866 75.6937 16.0702V8.96062C75.7877 8.6196 75.9524 8.34209 76.1852 8.12337C76.4157 7.90465 76.6697 7.79646 76.9401 7.79646C77.2271 7.79646 77.4481 7.90935 77.6034 8.13278C77.7609 8.35855 77.8691 8.73485 77.9303 9.26636C77.9914 9.79787 78.022 10.5528 78.022 11.5335V13.1492H78.0243Z"></path>
                        <path fill="${Colors.text}" d="M84.8657 13.8712C84.8657 14.6755 84.8892 15.2776 84.9363 15.6798C84.9833 16.0819 85.0821 16.3736 85.2326 16.5594C85.3831 16.7428 85.6136 16.8345 85.9264 16.8345C86.3474 16.8345 86.639 16.6699 86.7942 16.343C86.9518 16.0161 87.0365 15.4705 87.0506 14.7085L89.4824 14.8519C89.4965 14.9601 89.5035 15.1106 89.5035 15.3011C89.5035 16.4582 89.186 17.3237 88.5534 17.8952C87.9208 18.4667 87.0247 18.7536 85.8676 18.7536C84.4777 18.7536 83.504 18.3185 82.9466 17.446C82.3869 16.5735 82.1094 15.2259 82.1094 13.4008V11.2136C82.1094 9.33452 82.3987 7.96105 82.9772 7.09558C83.5558 6.2301 84.5459 5.79736 85.9499 5.79736C86.9165 5.79736 87.6597 5.97375 88.1771 6.32888C88.6945 6.684 89.059 7.23433 89.2707 7.98457C89.4824 8.7348 89.5882 9.76961 89.5882 11.0913V13.2362H84.8657V13.8712ZM85.2232 7.96811C85.0797 8.14449 84.9857 8.43377 84.9363 8.83593C84.8892 9.2381 84.8657 9.84722 84.8657 10.6657V11.5641H86.9283V10.6657C86.9283 9.86133 86.9001 9.25221 86.846 8.83593C86.7919 8.41966 86.6931 8.12803 86.5496 7.95635C86.4062 7.78702 86.1851 7.7 85.8864 7.7C85.5854 7.70235 85.3643 7.79172 85.2232 7.96811Z"></path>
                    </g>
                </g>
            </svg>
        </svg>"""

    header(classes = classes("my-header text-white font-bold relative")) {
        button(classes = classes("absolute top-6 left-8 "), type = ButtonType.button, name = "menu") {
            attributes["title"] = "Menu"
            unsafe { addContent(menuIcon) }
        }
        button(
            classes = classes("absolute top-6 left-16 w-32 h-6  flex items-center justify-center"),
            type = ButtonType.button
        ) {
            unsafe { addContent(youtubeLogo) }
        }
        button(
            classes = classes(
                "absolute top-3 right-8 w-32 h-12 my-sign-in border-2  background-color: ${Colors.background};",
                "flex", "items-center", "justify-center",  "hover:bg-blue-100",
                "text-blue-400", "font-medium",
                "rounded-full",
                "transition", "duration-150", "ease-in-out",
                "text-sm"
            )
        ) {
            span(classes = classes("mr-2 block ")) {
                unsafe { addContent(signInIcon) }
            }
            addContent("Sign in")
        }
    }
}

fun MAIN.sideBar(
    containerStyling: String? = null,
    contentStyling: String? = null,
    containerPlacement: String? = null,
    contentPlacement: String? = null,
    containerSize: String? = null,
    contentSize: String? = null,
    containerTransition: String? = null,
    contentTransition: String? = null,
    vararg items: DIV.() -> Unit
) {
    attributes["x-data"] = "{ open: false }"

    div(
        classes = contentClasses(
            "absolute top-0 left-0",
            "w-48 min-h-screen",
            "bg-gray-800",
            "transition-all duration-300",
            containerStyling,
            containerPlacement,
            containerSize,
            containerTransition
        )
    ) {
        attributes["x-show"] = "open"
        attributes["x-transition:enter"] = "transform translate-x-0 opacity-100"
        attributes["x-transition:enter-start"] = "transform -translate-x-full opacity-0"
        attributes["x-transition:leave-end"] = "transform -translate-x-full opacity-0"

        div(classes("border-t border-gray-500", "absolute", "top-0", "left-0", "w-full"))  // divider
        button(classes = classes("w-full h-12", "block", "text-white")) {
            attributes["x-on:click"] = "open = !open"
            i(classes("fas fa-chevron-left"))
        }
        items.forEach { item ->
            div(classes("border-t border-gray-500", "w-full"))  // divider
            div(
                classes = contentClasses(
                    "my-4",
                    "text-white",
                    contentStyling,
                    contentPlacement,
                    contentSize,
                    contentTransition
                )
            ) {
                item()
            }
        }
    }
    div(
        classes = contentClasses(
            "absolute top-0 -left-8",
            "w-12 h-12",
            "bg-gray-800",
            "transition-all",
            "duration-300",
            "-z-10",
            "transition duration-300 ease-in-out transform hover:translate-x-8",
            containerStyling
        )
    ) {
        attributes["x-show"] = "!open"
        attributes["x-transition:enter"] = "opacity-100"
        attributes["x-transition:enter-start"] = "opacity-0"
        attributes["x-transition:leave-end"] = "opacity-0"

        div(classes("border-t border-gray-500", "w-full"))  // divider
        button(classes = classes("w-full h-full", "flex justify-end items-center")) {
            attributes["x-on:click"] = "open = !open"
            repeat(4) {
                i(classes("text-white fas fa-chevron-right"))
            }
        }
    }
}






