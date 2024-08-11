@file:Suppress("unused")

package website.constants

/**
 * ALT: Specifies an alternative text for an image, if the image cannot be displayed.
 * This is useful for accessibility and when the image cannot be loaded.
 */
const val ALT = "alt"

/**
 * CLASS: Specifies one or more class names for an element.
 * This is used to select elements with specific classes for CSS styling.
 */
const val CLASS = "class"

/**
 * ID: Specifies a unique id for an element.
 * This is used to select a specific element for CSS styling or JavaScript manipulation.
 */
const val ID = "id"

/**
 * LANG: Specifies the language of the element's content.
 * This can help search engines and browsers render the content correctly.
 */
const val LANG = "lang"

/**
 * STYLE: Specifies an inline CSS style for an element.
 * This can be used to apply specific styles directly to an element, but generally external stylesheets are preferred.
 */
const val STYLE = "style"

/**
 * TITLE: Specifies extra information about an element.
 * This information is usually displayed as a tooltip when the mouse hovers over the element.
 */
const val TITLE = "title"

/**
 * ACCESS_KEY: Specifies a shortcut key to activate/focus an element.
 * This can be used to provide keyboard shortcuts for user actions.
 */
const val ACCESS_KEY = "accesskey"

/**
 * CONTENTEDITABLE: Specifies whether the content of an element is editable or not.
 * This can be used to make an element's content editable by the user.
 */
const val CONTENTEDITABLE = "contenteditable"

/**
 * DIR: Specifies the text direction for the content in an element.
 * This can be used to control the direction of text display (e.g., left-to-right or right-to-left).
 */
const val DIR = "dir"

/**
 * DRAGGABLE: Specifies whether an element is draggable or not.
 * This can be used to allow the user to drag and drop elements in a webpage.
 */
const val DRAGGABLE = "draggable"

/**
 * HIDDEN: Specifies that an element is not yet, or is no longer, relevant.
 * This can be used to hide elements from the user.
 */
const val HIDDEN = "hidden"

/**
 * TABINDEX: Specifies the tabbing order of an element.
 * This can be used to control the order in which elements receive focus when the user uses the Tab key.
 */
const val TABINDEX = "tabindex"

/**
 * SPELLCHECK: Specifies whether the element is to have its spelling and grammar checked or not.
 * This can be used to control whether the browser should provide spelling and grammar checking for the element.
 */
const val SPELLCHECK = "spellcheck"

/**
 * VALUE: Specifies the value of the element.
 * This can be used to set or get the value of form elements.
 */
const val VALUE = "value"

/**
 * PLACEHOLDER: Specifies a short hint that describes the expected value of an input element.
 * This can be used to provide a hint to the user about what they should enter the input.
 */
const val PLACEHOLDER = "placeholder"

/**
 * DISABLED: Specifies that a button should be disabled.
 * This can be used to prevent the user from interacting with the button.
 */
const val DISABLED = "disabled"

/**
 * MAXLENGTH: Specifies the maximum number of characters allowed in an input element.
 * This can be used to limit the length of input provided by the user.
 */
const val MAXLENGTH = "maxlength"

/**
 * READONLY: Specifies that an input field is read-only.
 * This can be used to prevent the user from modifying the value of the input.
 */
const val READONLY = "readonly"

/**
 * REQUIRED: Specifies that an input field must be filled out before submitting the form.
 * This can be used to enforce that certain inputs must be provided by the user.
 */
const val REQUIRED = "required"

/**
 * AUTOCOMPLETE: Specifies whether the value of an input field should be autocompleted as the user types.
 * This can be used to provide automatic completion of input based on previous user input.
 */
const val AUTOCOMPLETE = "autocomplete"

/**
 * HREF: Specifies the URL of the page the link goes to.
 * This can be used to create a hyperlink to another webpage.
 */
const val HREF = "href"

/**
 * TARGET: Specifies where to open the linked document.
 * This can be used to control whether the link opens in a new window, the same window, a parent window, or a specific frame.
 */
const val TARGET = "target"

/**
 * DOWNLOAD: Specifies that the target will be downloaded when a user clicks on the hyperlink.
 * This can be used to create a link that causes a file to be downloaded when clicked.
 */
const val DOWNLOAD = "download"

/**
 * PING: Specifies a space-separated list of URLs to which, when the hyperlink is followed, post requests with the body PING will be sent by the browser.
 * This can be used to track clicks on a link.
 */
const val PING = "ping"

/**
 * REL: Specifies the relationship between the current document and the linked document.
 * This can be used to specify the relationship between the current document and the linked document.
 */
const val REL = "rel"

/**
 * HREFLANG: Specifies the language of the linked resource.
 * This can be used to indicate the language of the linked resource to search engines and browsers.
 */
const val HREFLANG = "hreflang"

/**
 * TYPE: Specifies the type of the element.
 * This can be used to specify the type of input element to display.
 */
const val TYPE = "type"

/**
 * SRC: Specifies the URL of the media file.
 * This can be used to specify the source of media elements like <img>, <audio>, and <video>.
 */
const val SRC = "src"

/**
 * HEIGHT: Specifies the height of the element.
 * This can be used to set the height of elements like <iframe>, <img>, or <object>.
 */
const val HEIGHT = "height"

/**
 * WIDTH: Specifies the width of the element.
 * This can be used to set the width of elements like <iframe>, <img>, or <object>.
 */
const val WIDTH = "width"

/**
 * SRCSET: Specifies the URL of the image to use in different situations.
 * This can be used to specify different images to use in different situations, such as when the screen is a different size or resolution.
 */
const val SRCSET = "srcset"

/**
 * SIZES: Specifies the sizes of the icons for visual media.
 * This can be used to specify multiple sizes of icons for visual media like <img> or <source>.
 */
const val SIZES = "sizes"

/**
 * USEMAP: Specifies the name of a client-side image map to be used with the object.
 * This can be used to create an image map, which allows different parts of an image to link to different destinations.
 */
const val USEMAP = "usemap"

/**
 * ISMAP: Specifies that an image is part of a server-side image-map.
 * This can be used to create a server-side image map, which allows different parts of an image to link to different destinations.
 */
const val ISMAP = "ismap"

/**
 * SHAPE: Specifies the shape of a server-side image-map.
 * This can be used to specify the shape of a clickable area in a server-side image map.
 */
const val SHAPE = "shape"

/**
 * COORDS: Specifies the coordinates of the area.
 * This can be used to specify the coordinates of a clickable area in an image map.
 */
const val COORDS = "coords"

/**
 * DATA: Specifies the URL of the resource to be used by the object.
 * This can be used to specify the data that should be used by objects like <object> and <embed>.
 */
const val DATA = "data"

/**
 * CODETYPE: Specifies the Internet media type of the code referred to by the classid attribute.
 * This can be used to specify the media type of code that should be used by an <object>.
 */
const val CODETYPE = "codetype"

/**
 * SANDBOX: Enables an extra set of restrictions for the content in an iframe.
 * This can be used to apply extra security restrictions to an <iframe>.
 */
const val SANDBOX = "sandbox"

/**
 * SCROLLING: Specifies whether to display scrollbars in an iframe.
 * This can be used to control whether scrollbars are shown in an <iframe>.
 */
const val SCROLLING = "scrolling"

/**
 * SRCDOC: Specifies the HTML content of the page to show in the iframe.
 * This can be used to specify the HTML content that should be shown in an <iframe>.
 */
const val SRCDOC = "srcdoc"

/**
 * MEDIA: Specifies the media type of the script.
 * This can be used to specify the media type (e.g., screen, print) that a <style> or <link> applies to.
 */
const val MEDIA = "media"

/**
 * FORM: Specifies the name of the form the object belongs to.
 * This can be used to associate an element with a specific form.
 */
const val FORM = "form"

/**
 * FORM_ACTION: Specifies where to send the form-data when a form is submitted.
 * This can be used to specify the URL that a form should submit its data to.
 */
const val FORM_ACTION = "formaction"

/**
 * FORM_ENCTYPE: Specifies how the form-data should be encoded when submitting it to the server.
 * This can be used to specify how form data should be encoded before it is sent to the server.
 */
const val FORM_ENCTYPE = "formenctype"

/**
 * FORM_METHOD: Specifies the HTTP method to use when sending form-data.
 * This can be used to specify the HTTP method (e.g., GET, POST) that should be used when submitting a form.
 */
const val FORM_METHOD = "formmethod"

/**
 * FORM_NOVALIDATE: Specifies that the form should not be validated when submitted.
 * This can be used to disable browser-based form validation.
 */
const val FORM_NOVALIDATE = "formnovalidate"

/**
 * FORM_TARGET: Specifies where to display the response after submitting the form.
 * This can be used to specify where the response to a form submission should be displayed.
 */
const val FORM_TARGET = "formtarget"

/**
 * NAME: Specifies the name of the element.
 * This can be used to identify an element for scripting or styling purposes.
 */
const val NAME = "name"

/**
 * REVERSED: Specifies that the list order should be descending (9,8,7...).
 * This can be used to create a reversed (descending) numbered list.
 */
const val REVERSED = "reversed"

/**
 * HIGH: Specifies the highest value in a meter element.
 * This can be used to specify the upper bound of a <meter> element.
 */
const val HIGH = "high"

/**
 * LOW: Specifies the lowest value in a meter element.
 * This can be used to specify the lower bound of a <meter> element.
 */
const val LOW = "low"

/**
 * OPTIMUM: Specifies the optimal value in a meter element.
 * This can be used to specify the optimal (ideal) value for a <meter> element.
 */
const val OPTIMUM = "optimum"

/**
 * KIND: Specifies the kind of text track.
 * This can be used to specify the kind of text track for a <track> element.
 */
const val KIND = "kind"

/**
 * SRCLANG: Specifies the language of the track text data.
 * This can be used to specify the language of text track data for a <track> element.
 */
const val SRCLANG = "srclang"

/**
 * POSTER: Specifies an image to be shown while the video is downloading, or until the user hits the play button.
 * This can be used to specify an image to show before a <video> starts playing.
 */
const val POSTER = "poster"

/**
 * PRELOAD: Specifies if and how the author thinks the video should be loaded when the page loads.
 * This can be used to control how a <video> should be loaded when the page loads.
 */
const val PRELOAD = "preload"

/**
 * DEFAULT: Specifies that the track should be enabled if the user's preferences do not indicate that another track would be more appropriate.
 * This can be used to specify a default track for a <video> or <audio> element.
 */
const val DEFAULT = "default"

/**
 * CONTROLS: Specifies that audio/video controls should be displayed (such as a play/pause button etc.).
 * This can be used to specify that controls should be shown for a <video> or <audio> element.
 */
const val CONTROLS = "controls"

/**
 * LOOP: Specifies that the audio/video will start over again, every time it is finished.
 * This can be used to specify that a <video> or <audio> should loop (start over) when it finishes.
 */
const val LOOP = "loop"

/**
 * START: Specifies the start value of a list item.
 * This can be used to specify the starting number for an ordered list.
 */
const val START = "start"

/**
 * MEDIA_GROUP: Specifies the name of the media group the media element belongs to.
 * This can be used to group <audio> and <video> elements together for synchronized playback.
 */
const val MEDIA_GROUP = "mediagroup"

/**
 * MUTED: Specifies that the audio output of the video should be muted.
 * This can be used to specify that the audio output of a <video> or <audio> should be muted.
 */
const val MUTED = "muted"

/**
 * VOLUME: Specifies the volume of the audio or video.
 * This can be used to control the volume of a <video> or <audio> element.
 */
const val VOLUME = "volume"

/**
 * AUTOFOCUS: Specifies that the element should automatically get focus when the page loads.
 * This can be used to specify that an element should automatically get focus when the page loads.
 */
const val AUTOFOCUS = "autofocus"

/**
 * ACCEPT: Specifies the types of files that the server accepts (only for type="file").
 * This can be used to specify the types of files that a file input should accept.
 */
const val ACCEPT = "accept"

/**
 * MULTIPLE: Specifies that a user can enter more than one value in an input element.
 * This can be used to specify that a user can select multiple files in a file input.
 */
const val MULTIPLE = "multiple"

/**
 * PATTERN: Specifies a regular expression that an input element's value is checked against.
 * This can be used to specify a pattern that the value of an input should match.
 */
const val PATTERN = "pattern"

/**
 * STEP: Specifies the legal number intervals for an input element.
 * This can be used to specify the step size for an input of type number or range.
 */
const val STEP = "step"

/**
 * LIST: Specifies a name for the drop-down list.
 * This can be used to associate a <datalist> with an <input> to provide a drop-down list of options.
 */
const val LIST = "list"

/**
 * ACTION: Specifies where to send the form-data when a form is submitted.
 * This can be used to specify the URL that a form should submit its data to.
 */
const val ACTION = "action"

/**
 * ENCTYPE: Specifies how the form-data should be encoded when submitting it to the server (only for method="post").
 * This can be used to specify how form data should be encoded before it is sent to the server.
 */
const val ENCTYPE = "enctype"

/**
 * METHOD: Specifies the HTTP method to use when sending form-data.
 * This can be used to specify the HTTP method (e.g., GET, POST) that should be used when submitting a form.
 */
const val METHOD = "method"

/**
 * NOVALIDATE: Specifies that the form should not be validated when submitted.
 * This can be used to disable browser-based form validation.
 */
const val NOVALIDATE = "novalidate"

/**
 * CHARSET: Specifies the character encoding.
 * This can be used to specify the character encoding for the linked resource or file.
 */
const val CHARSET = "charset"

/**
 * CROSS_ORIGIN: Specifies how the element handles cross-origin requests.
 * This can be used to control how cross-origin requests are handled.
 */
const val CROSS_ORIGIN = "crossorigin"

/**
 * AS: Specifies the type of content that is used to submit the form to the server.
 * This can be used to specify the type of content that is used to submit the form to the server.
 */
const val AS = "as"

/**
 * LABEL: Specifies the visible text in a drop-down list.
 * This can be used to specify the visible text in a drop-down list.
 */
const val LABEL = "label"

/**
 * SELECTED: Specifies that an option should be pre-selected when the page loads.
 * This can be used to specify that an option in a drop-down list should be pre-selected when the page loads.
 */
const val SELECTED = "selected"

/**
 * CHECKED: Specifies that an input field should be pre-selected when the page loads (for type="checkbox" or type="radio").
 * This can be used to specify that a checkbox or radio button should be pre-selected when the page loads.
 */
const val CHECKED = "checked"

/**
 * COMMANDS: Specifies a command to be invoked.
 * This can be used to specify a command that can be invoked.
 */
const val COMMANDS = "commands"

/**
 * ICON: Specifies the icon for a command.
 * This can be used to specify an icon for a command.
 */
const val ICON = "icon"

/**
 * Specifies the name of the radio group for command elements.
 * This can be used when you have a group of radio buttons, and you want to submit the value of the selected one.
 */
const val RADIO_GROUP = "radiogroup"

/**
 * Specifies the number of columns a cell should span in a table.
 * This can be used to make a cell span multiple columns for layout purposes.
 */
const val COLSPAN = "colspan"

/**
 * Specifies the number of rows a cell should span in a table.
 * This can be used to make a cell span multiple rows for layout purposes.
 */
const val ROWSPAN = "rowspan"

/**
 * Specifies one or more headers cells a cell is related to in a table.
 * This can be used to associate a cell with headers for accessibility purposes.
 */
const val HEADERS = "headers"

/**
 * Specifies a way to categorize cells in a table.
 * This can be used to apply styles or perform other operations on specific categories of cells.
 */
const val SCOPE = "scope"

/**
 * Specifies an abbreviated version of the content in a cell.
 * This can be used to provide a shorter version of cell content for use where space is limited.
 */
const val ABBR = "abbr"

/**
 * Specifies the horizontal alignment of the content in a cell.
 * This can be used to align cell content to the left, right, or center.
 */
const val ALIGN = "align"

/**
 * Specifies a comma-separated list of related headers in a table.
 * This can be used to associate a cell with multiple headers for complex data tables.
 */
const val AXIS = "axis"

/**
 * Specifies a character that should be aligned vertically for each cell in a column.
 * This can be used to align cell content around a specific character.
 */
const val CHAR = "char"

/**
 * Specifies how many characters the cell should be shifted to the right.
 * This can be used in conjunction with the CHAR attribute to align cell content.
 */
const val CHAR_OFF = "charoff"

/**
 * Specifies the vertical alignment of the content in a cell.
 * This can be used to align cell content to the top, middle, or bottom.
 */
const val VALIGN = "valign"

/**
 * Specifies the number of columns a cell should span in a table.
 * This can be used to make a cell span multiple columns for layout purposes.
 */
const val SPAN = "span"

/**
 * Specifies whether a border should be displayed around an iframe.
 * This can be used to control the appearance of an iframe.
 */
const val FRAME_BORDER = "frameborder"

/**
 * Specifies a long description for an iframe.
 * This can be used to provide additional information about the content of an iframe.
 */
const val LONG_DESC = "longdesc"

/**
 * Specifies the top and bottom margins of the content of an iframe.
 * This can be used to control the spacing around the content inside an iframe.
 */
const val MARGIN_HEIGHT = "marginheight"

/**
 * Specifies the left and right margins of the content of an iframe.
 * This can be used to control the spacing around the content inside an iframe.
 */
const val MARGIN_WIDTH = "marginwidth"

/**
 * Specifies the color of the text.
 * This can be used to set the color of text in an element.
 */
const val COLOR = "color"

/**
 * Specifies the font of the text.
 * This can be used to set the font for text in an element.
 */
const val FACE = "face"

/**
 * Specifies the size of the text.
 * This can be used to set the size of text in an element.
 */
const val SIZE = "size"

/**
 * Specifies the side where lines will be broken.
 * This can be used to control where line breaks occur in text.
 */
const val CLEAR = "clear"

/**
 * Specifies that a hr element should be drawn as a shaded rule.
 * This can be used to give a hr element a 3D appearance.
 */
const val NO_SHADE = "noshade"

/**
 * Specifies that an ul element should render more compactly.
 * This can be used to reduce the amount of space used by a list.
 */
const val COMPACT = "compact"

/**
 * Specifies which parts of the outside borders that should be visible.
 * This can be used to control the appearance of the borders of a table.
 */
const val FRAME = "frame"

/**
 * Specifies which parts of the inside borders that should be visible.
 * This can be used to control the appearance of the borders between cells in a table.
 */
const val RULES = "rules"

/**
 * Specifies a summary of the content of a table.
 * This can be used to provide a brief overview of what information a table contains.
 */
const val SUMMARY = "summary"

/**
 * Specifies the space between the cell wall and the cell content.
 * This can be used to control the amount of space between the cell border and its content.
 */
const val CELL_PADDING = "cellpadding"

/**
 * Specifies the space between cells in a table.
 * This can be used to control the amount of space between cells in a table.
 */
const val CELLS_PACING = "cellspacing"

/**
 * Specifies the background color of a table.
 * This can be used to set the background color for a table.
 */
const val BG_COLOR = "bgcolor"

/**
 * Specifies the width of the borders around a table.
 * This can be used to control the thickness of a table's borders.
 */
const val BORDER = "border"

/**
 * Specifies the color of the borders around a table.
 * This can be used to set the color of a table's borders.
 */
const val BORDER_COLOR = "bordercolor"

/**
 * Specifies that the content inside a cell should not wrap.
 * This can be used to prevent the content in a cell from wrapping to multiple lines.
 */
const val NOWRAP = "nowrap"

/**
 * Specifies a script to be run when an element is clicked.
 * This can be used to run a JavaScript function when an element is clicked.
 */
const val ON_CLICK = "onclick"