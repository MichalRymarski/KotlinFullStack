@file:Suppress("unused")

package website.front.attributes

/**
 * Specifies the URL to issue a GET request to.
 */
const val HX_GET = "hx-get"

/**
 * Specifies the URL to issue a POST request to.
 */
const val HX_POST = "hx-post"

/**
 * Specifies the URL to issue a PUT request to.
 */
const val HX_PUT = "hx-put"

/**
 * Specifies the URL to issue a DELETE request to.
 */
const val HX_DELETE = "hx-delete"

/**
 * Specifies the URL to issue a PATCH request to.
 */
const val HX_PATCH = "hx-patch"

/**
 * Specifies the event that triggers the AJAX request.
 */
const val HX_TRIGGER = "hx-trigger"

/**
 * Specifies the target element to swap the response into.
 */
const val HX_TARGET = "hx-target"

/**
 * Specifies how the response will be swapped into the DOM.
 */
const val HX_SWAP = "hx-swap"

/**
 * Shows a confirm() dialog before issuing a request.
 */
const val HX_CONFIRM = "hx-confirm"

/**
 * Shows a prompt() dialog before issuing a request.
 */
const val HX_PROMPT = "hx-prompt"

/**
 * Specifies the element to use as the "loading" indicator.
 */
const val HX_INDICATOR = "hx-indicator"

/**
 * Pushes the URL into the browser's address bar.
 */
const val HX_PUSH_URL = "hx-push-url"

/**
 * Specifies the element to snapshot and restore during history navigation.
 */
const val HX_HISTORY_ELT = "hx-history-elt"

/**
 * Includes additional HTMX extensions.
 */
const val HX_EXT = "hx-ext"

/**
 * Adds values to the parameters to submit with the request.
 */
const val HX_VARS = "hx-vars"

/**
 * Adds headers to the request.
 */
const val HX_HEADERS = "hx-headers"

/**
 * Filters the parameters to submit with the request.
 */
const val HX_PARAMS = "hx-params"

/**
 * Specifies a path to use for the request.
 */
const val HX_PATH = "hx-path"

/**
 * Specifies an anchor element to use for the request.
 */
const val HX_ANCHOR = "hx-anchor"

/**
 * Specifies behavior when an error occurs during the request.
 */
const val HX_ERROR = "hx-error"

/**
 * Specifies a URL to redirect to after a successful request.
 */
const val HX_REDIRECT = "hx-redirect"

/**
 * Specifies the encoding for the request.
 */
const val HX_ENCODING = "hx-encoding"

/**
 * Specifies additional request parameters.
 */
const val HX_REQUEST = "hx-request"

/**
 * Specifies how to handle the response.
 */
const val HX_RESPONSE = "hx-response"

/**
 * Specifies values to submit with the request.
 */
const val HX_VALUES = "hx-values"

/**
 * Progressively enhances links and forms to use AJAX requests.
 */
const val HX_BOOST = "hx-boost"

/**
 * Establishes a Server Sent Event (SSE) connection to the specified URL.
 */
const val HX_SSE_SRC = "hx-sse-src"

/**
 * Establishes a WebSocket connection to the specified URL.
 */
const val HX_WS_SRC = "hx-ws-src"

/**
 * Prevents the default event behavior.
 */
const val HX_PREVENT_DEFAULT = "hx-prevent-default"

/**
 * Includes additional data in the request.
 */
const val HX_INCLUDE = "hx-include"

/**
 * Specifies additional data to send with the request.
 */
const val HX_WITH = "hx-with"

/**
 * Specifies the HTTP verbs allowed for the request.
 */
const val HX_VERBS = "hx-verbs"

/**
 * Specifies a delay before the request is triggered.
 */
const val HX_TRIGGER_DELAY = "hx-trigger-delay"

/**
 * Specifies the Server Sent Event to listen for.
 */
const val HX_SSE_EVENT = "hx-sse-event"

/**
 * Specifies the WebSocket message to listen for.
 */
const val HX_WS_MSG = "hx-ws-msg"

/**
 * Disables HTMX processing for the element and its children.
 */
const val HX_DISABLED = "hx-disabled"

/**
 * Allows you to select a subset of the server response to process.
 */
const val HX_SELECT = "hx-select"

/**
 * Adds a debounce to the request.
 */
const val HX_DEBOUNCE = "hx-debounce"

/**
 * Adds a throttle to the request.
 */
const val HX_THROTTLE = "hx-throttle"

/**
 * Specifies an action to take instead of issuing a request.
 */
const val HX_ACTION = "hx-action"

/**
 * Ensures that the request will only be made once.
 */
const val HX_ONCE = "hx-once"

/**
 * Specifies a delay before swapping the response into the DOM.
 */
const val HX_DELAY = "hx-delay"

/**
 * Specifies that the element should poll periodically.
 */
const val HX_POLL = "hx-poll"

/**
 * Specifies a timeout for the request.
 */
const val HX_TIMEOUT = "hx-timeout"

/**
 * Specifies caching behavior for the request.
 */
const val HX_CACHE_CONTROL = "hx-cache-control"

/**
 * Defers the loading of the element until it is visible in the viewport.
 */
const val HX_LAZY = "hx-lazy"

/**
 * Marks content in a response to be swapped into the DOM somewhere other than the target.
 */
const val HX_SWAP_OOB = "hx-swap-oob"

/**
 * Specifies the HTTP method to use for the request.
 */
const val HX_METHOD = "hx-method"

/**
 * Specifies a CSS selector for updating the browser's location bar.
 */
const val HX_PUSH = "hx-push"

/**
 * Allows you to specify how the response will be swapped in relative to the target.
 */
const val HX_SWAP_OOBB = "hx-swap-oob"

/**
 * Allows you to validate a form before it is submitted.
 */
const val HX_VALIDATE = "hx-validate"

/**
 * Allows you to filter the parameters that will be submitted with a request.
 */
const val HX_PARAMS_NOT = "hx-params-not"

/**
 * Allows you to preserve elements across requests.
 */
const val HX_PRESERVE = "hx-preserve"

/**
 * Allows you to specify a CSS selector that indicates which elements to include in the request.
 */
const val HX_INCLUDE_SELECTOR = "hx-include-selector"

/**
 * Specifies the amount of time to wait before issuing a request.
 */
const val HX_WAIT = "hx-wait"

/**
 * Allows you to specify a CSS selector for elements to sync.
 */
const val HX_SYNC = "hx-sync"

/**
 * Disables HTMX processing for the element.
 */
const val HX_DISINHERIT = "hx-disinherit"

/**
 * Allows you to specify a CSS selector for elements to update on a successful response.
 */
const val HX_UPDATE = "hx-update"

/**
 * Specifies how HTMX should handle history.
 */
const val HX_HISTORY = "hx-history"

/**
 * Allows you to specify a request that should be made in the background.
 */
const val HX_BACKGROUND = "hx-background"

/**
 * Specifies that the element should not be removed from the DOM when it is swapped out.
 */
const val HX_PRESERVE_ON_SWAP = "hx-preserve-on-swap"

/**
 * Allows you to specify a CSS selector for elements that should be removed when the response is swapped in.
 */
const val HX_REMOVE = "hx-remove"

/**
 * Specifies that the request should only be made if the element is visible.
 */
const val HX_VISIBLE = "hx-visible"

/**
 * Allows you to specify a CSS selector for elements that should be focused after the swap.
 */
const val HX_FOCUS = "hx-focus"

/**
 * Specifies that the request should be made even if the values haven't changed.
 */
const val HX_IGNORE_UNCHANGED = "hx-ignore-unchanged"



object HxSwap {
    const val NONE = "none"
    const val OUTER_HTML = "outer-html"
    const val INNER_HTML = "inner-html"
    const val BEFORE_BEGIN = "before-begin"
    const val AFTER_BEGIN = "after-begin"
    const val BEFORE_END = "before-end"
    const val AFTER_END = "after-end"
}

object HxTrigger {
    const val CLICK = "click"
    const val HOVER = "hover"
    const val FOCUS = "focus"
    const val BLUR = "blur"
    const val LOAD = "load"
    const val CHANGED = "changed"
    const val REVEALED = "revealed"
    const val SETTLE = "settle"
}

object HxBoost{
    const val TRUE = "true"
    const val FALSE = "false"
}