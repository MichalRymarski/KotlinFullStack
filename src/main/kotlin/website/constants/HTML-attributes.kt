@file:Suppress("unused")

package website.constants

/**
 * Enum class representing HTML attributes.
 * Each enum entry represents a different HTML attribute.
 */
enum class HtmlAttributes(val attribute: String) {
    /**
     * ALT: Specifies an alternative text for an image, if the image cannot be displayed.
     * This is useful for accessibility and when the image cannot be loaded.
     */
    ALT("alt"),

    /**
     * CLASS: Specifies one or more class names for an element.
     * This is used to select elements with specific classes for CSS styling.
     */
    CLASS("class"),

    /**
     * ID: Specifies a unique id for an element.
     * This is used to select a specific element for CSS styling or JavaScript manipulation.
     */
    ID("id"),

    /**
     * LANG: Specifies the language of the element's content.
     * This can help search engines and browsers render the content correctly.
     */
    LANG("lang"),

    /**
     * STYLE: Specifies an inline CSS style for an element.
     * This can be used to apply specific styles directly to an element, but generally external stylesheets are preferred.
     */
    STYLE("style"),

    /**
     * TITLE: Specifies extra information about an element.
     * This information is usually displayed as a tooltip when the mouse hovers over the element.
     */
    TITLE("title"),

    /**
     * ACCESS_KEY: Specifies a shortcut key to activate/focus an element.
     * This can be used to provide keyboard shortcuts for user actions.
     */
    ACCESS_KEY("accesskey"),

    /**
     * CONTENTEDITABLE: Specifies whether the content of an element is editable or not.
     * This can be used to make an element's content editable by the user.
     */
    CONTENTEDITABLE("contenteditable"),

    /**
     * DIR: Specifies the text direction for the content in an element.
     * This can be used to control the direction of text display (e.g., left-to-right or right-to-left).
     */
    DIR("dir"),

    /**
     * DRAGGABLE: Specifies whether an element is draggable or not.
     * This can be used to allow the user to drag and drop elements in a webpage.
     */
    DRAGGABLE("draggable"),

    /**
     * HIDDEN: Specifies that an element is not yet, or is no longer, relevant.
     * This can be used to hide elements from the user.
     */
    HIDDEN("hidden"),

    /**
     * TABINDEX: Specifies the tabbing order of an element.
     * This can be used to control the order in which elements receive focus when the user uses the Tab key.
     */
    TABINDEX("tabindex"),

    /**
     * SPELLCHECK: Specifies whether the element is to have its spelling and grammar checked or not.
     * This can be used to control whether the browser should provide spelling and grammar checking for the element.
     */
    SPELLCHECK("spellcheck"),

    /**
     * VALUE: Specifies the value of the element.
     * This can be used to set or get the value of form elements.
     */
    VALUE("value"),

    /**
     * PLACEHOLDER: Specifies a short hint that describes the expected value of an input element.
     * This can be used to provide a hint to the user about what they should enter in the input.
     */
    PLACEHOLDER("placeholder"),

    /**
     * DISABLED: Specifies that a button should be disabled.
     * This can be used to prevent the user from interacting with the button.
     */
    DISABLED("disabled"),

    /**
     * MAXLENGTH: Specifies the maximum number of characters allowed in an input element.
     * This can be used to limit the length of input provided by the user.
     */
    MAXLENGTH("maxlength"),

    /**
     * READONLY: Specifies that an input field is read-only.
     * This can be used to prevent the user from modifying the value of the input.
     */
    READONLY("readonly"),

    /**
     * REQUIRED: Specifies that an input field must be filled out before submitting the form.
     * This can be used to enforce that certain inputs must be provided by the user.
     */
    REQUIRED("required"),

    /**
     * AUTOCOMPLETE: Specifies whether the value of an input field should be autocompleted as the user types.
     * This can be used to provide automatic completion of input based on previous user input.
     */
    AUTOCOMPLETE("autocomplete"),

    /**
     * HREF: Specifies the URL of the page the link goes to.
     * This can be used to create a hyperlink to another webpage.
     */
    HREF("href"),

    /**
     * TARGET: Specifies where to open the linked document.
     * This can be used to control whether the link opens in a new window, the same window, a parent window, or a specific frame.
     */
    TARGET("target"),

    /**
     * DOWNLOAD: Specifies that the target will be downloaded when a user clicks on the hyperlink.
     * This can be used to create a link that causes a file to be downloaded when clicked.
     */
    DOWNLOAD("download"),

    /**
     * PING: Specifies a space-separated list of URLs to which, when the hyperlink is followed, post requests with the body PING will be sent by the browser.
     * This can be used to track clicks on a link.
     */
    PING("ping"),

    /**
     * REL: Specifies the relationship between the current document and the linked document.
     * This can be used to specify the relationship between the current document and the linked document.
     */
    REL("rel"),

    /**
     * HREFLANG: Specifies the language of the linked resource.
     * This can be used to indicate the language of the linked resource to search engines and browsers.
     */
    HREFLANG("hreflang"),

    /**
     * TYPE: Specifies the type of the element.
     * This can be used to specify the type of input element to display.
     */
    TYPE("type"),

    /**
     * SRC: Specifies the URL of the media file.
     * This can be used to specify the source of media elements like <img>, <audio>, and <video>.
     */
    SRC("src"),

    /**
     * HEIGHT: Specifies the height of the element.
     * This can be used to set the height of elements like <iframe>, <img>, or <object>.
     */
    HEIGHT("height"),

    /**
     * WIDTH: Specifies the width of the element.
     * This can be used to set the width of elements like <iframe>, <img>, or <object>.
     */
    WIDTH("width"),

    /**
     * SRCSET: Specifies the URL of the image to use in different situations.
     * This can be used to specify different images to use in different situations, such as when the screen is a different size or resolution.
     */
    SRCSET("srcset"),

    /**
     * SIZES: Specifies the sizes of the icons for visual media.
     * This can be used to specify multiple sizes of icons for visual media like <img> or <source>.
     */
    SIZES("sizes"),

    /**
     * USEMAP: Specifies the name of a client-side image map to be used with the object.
     * This can be used to create an image map, which allows different parts of an image to link to different destinations.
     */
    USEMAP("usemap"),

    /**
     * ISMAP: Specifies that an image is part of a server-side image-map.
     * This can be used to create a server-side image map, which allows different parts of an image to link to different destinations.
     */
    ISMAP("ismap"),

    /**
     * SHAPE: Specifies the shape of a server-side image-map.
     * This can be used to specify the shape of a clickable area in a server-side image map.
     */
    SHAPE("shape"),

    /**
     * COORDS: Specifies the coordinates of the area.
     * This can be used to specify the coordinates of a clickable area in an image map.
     */
    COORDS("coords"),

    /**
     * DATA: Specifies the URL of the resource to be used by the object.
     * This can be used to specify the data that should be used by objects like <object> and <embed>.
     */
    DATA("data"),

    /**
     * CODETYPE: Specifies the Internet media type of the code referred to by the classid attribute.
     * This can be used to specify the media type of code that should be used by an <object>.
     */
    CODETYPE("codetype"),

    /**
     * SANDBOX: Enables an extra set of restrictions for the content in an iframe.
     * This can be used to apply extra security restrictions to an <iframe>.
     */
    SANDBOX("sandbox"),

    /**
     * SCROLLING: Specifies whether to display scrollbars in an iframe.
     * This can be used to control whether scrollbars are shown in an <iframe>.
     */
    SCROLLING("scrolling"),

    /**
     * SRCDOC: Specifies the HTML content of the page to show in the iframe.
     * This can be used to specify the HTML content that should be shown in an <iframe>.
     */
    SRCDOC("srcdoc"),

    /**
     * MEDIA: Specifies the media type of the script.
     * This can be used to specify the media type (e.g., screen, print) that a <style> or <link> applies to.
     */
    MEDIA("media"),

    /**
     * FORM: Specifies the name of the form the object belongs to.
     * This can be used to associate an element with a specific form.
     */
    FORM("form"),

    /**
     * FORM_ACTION: Specifies where to send the form-data when a form is submitted.
     * This can be used to specify the URL that a form should submit its data to.
     */
    FORM_ACTION("formaction"),

    /**
     * FORM_ENCTYPE: Specifies how the form-data should be encoded when submitting it to the server.
     * This can be used to specify how form data should be encoded before it is sent to the server.
     */
    FORM_ENCTYPE("formenctype"),

    /**
     * FORM_METHOD: Specifies the HTTP method to use when sending form-data.
     * This can be used to specify the HTTP method (e.g., GET, POST) that should be used when submitting a form.
     */
    FORM_METHOD("formmethod"),

    /**
     * FORM_NOVALIDATE: Specifies that the form should not be validated when submitted.
     * This can be used to disable browser-based form validation.
     */
    FORM_NOVALIDATE("formnovalidate"),

    /**
     * FORM_TARGET: Specifies where to display the response after submitting the form.
     * This can be used to specify where the response to a form submission should be displayed.
     */
    FORM_TARGET("formtarget"),

    /**
     * NAME: Specifies the name of the element.
     * This can be used to identify an element for scripting or styling purposes.
     */
    NAME("name"),

    /**
     * REVERSED: Specifies that the list order should be descending (9,8,7...).
     * This can be used to create a reversed (descending) numbered list.
     */
    REVERSED("reversed"),

    /**
     * HIGH: Specifies the highest value in a meter element.
     * This can be used to specify the upper bound of a <meter> element.
     */
    HIGH("high"),

    /**
     * LOW: Specifies the lowest value in a meter element.
     * This can be used to specify the lower bound of a <meter> element.
     */
    LOW("low"),

    /**
     * OPTIMUM: Specifies the optimal value in a meter element.
     * This can be used to specify the optimal (ideal) value for a <meter> element.
     */
    OPTIMUM("optimum"),

    /**
     * KIND: Specifies the kind of text track.
     * This can be used to specify the kind of text track for a <track> element.
     */
    KIND("kind"),

    /**
     * SRCLANG: Specifies the language of the track text data.
     * This can be used to specify the language of text track data for a <track> element.
     */
    SRCLANG("srclang"),

    /**
     * POSTER: Specifies an image to be shown while the video is downloading, or until the user hits the play button.
     * This can be used to specify an image to show before a <video> starts playing.
     */
    POSTER("poster"),

    /**
     * PRELOAD: Specifies if and how the author thinks the video should be loaded when the page loads.
     * This can be used to control how a <video> should be loaded when the page loads.
     */
    PRELOAD("preload"),

    /**
     * DEFAULT: Specifies that the track should be enabled if the user's preferences do not indicate that another track would be more appropriate.
     * This can be used to specify a default track for a <video> or <audio> element.
     */
    DEFAULT("default"),

    /**
     * CONTROLS: Specifies that audio/video controls should be displayed (such as a play/pause button etc.).
     * This can be used to specify that controls should be shown for a <video> or <audio> element.
     */
    CONTROLS("controls"),

    /**
     * LOOP: Specifies that the audio/video will start over again, every time it is finished.
     * This can be used to specify that a <video> or <audio> should loop (start over) when it finishes.
     */
    LOOP("loop"),

    /**
     * START: Specifies the start value of a list item.
     * This can be used to specify the starting number for an ordered list.
     */
    START("start"),

    /**
     * MEDIA_GROUP: Specifies the name of the media group the media element belongs to.
     * This can be used to group <audio> and <video> elements together for synchronized playback.
     */
    MEDIA_GROUP("mediagroup"),

    /**
     * MUTED: Specifies that the audio output of the video should be muted.
     * This can be used to specify that the audio output of a <video> or <audio> should be muted.
     */
    MUTED("muted"),

    /**
     * VOLUME: Specifies the volume of the audio or video.
     * This can be used to control the volume of a <video> or <audio> element.
     */
    VOLUME("volume"),

    /**
     * AUTOFOCUS: Specifies that the element should automatically get focus when the page loads.
     * This can be used to specify that an element should automatically get focus when the page loads.
     */
    AUTOFOCUS("autofocus"),

    /**
     * ACCEPT: Specifies the types of files that the server accepts (only for type="file").
     * This can be used to specify the types of files that a file input should accept.
     */
    ACCEPT("accept"),

    /**
     * MULTIPLE: Specifies that a user can enter more than one value in an input element.
     * This can be used to specify that a user can select multiple files in a file input.
     */
    MULTIPLE("multiple"),

    /**
     * PATTERN: Specifies a regular expression that an input element's value is checked against.
     * This can be used to specify a pattern that the value of an input should match.
     */
    PATTERN("pattern"),

    /**
     * STEP: Specifies the legal number intervals for an input element.
     * This can be used to specify the step size for an input of type number or range.
     */
    STEP("step"),

    /**
     * LIST: Specifies a name for the drop-down list.
     * This can be used to associate a <datalist> with an <input> to provide a drop-down list of options.
     */
    LIST("list"),

    /**
     * ACTION: Specifies where to send the form-data when a form is submitted.
     * This can be used to specify the URL that a form should submit its data to.
     */
    ACTION("action"),

    /**
     * ENCTYPE: Specifies how the form-data should be encoded when submitting it to the server (only for method="post").
     * This can be used to specify how form data should be encoded before it is sent to the server.
     */
    ENCTYPE("enctype"),

    /**
     * METHOD: Specifies the HTTP method to use when sending form-data.
     * This can be used to specify the HTTP method (e.g., GET, POST) that should be used when submitting a form.
     */
    METHOD("method"),

    /**
     * NOVALIDATE: Specifies that the form should not be validated when submitted.
     * This can be used to disable browser-based form validation.
     */
    NOVALIDATE("novalidate"),

    /**
     * CHARSET: Specifies the character encoding.
     * This can be used to specify the character encoding for the linked resource or file.
     */
    CHARSET("charset"),

    /**
     * CROSS_ORIGIN: Specifies how the element handles cross-origin requests.
     * This can be used to control how cross-origin requests are handled.
     */
    CROSS_ORIGIN("crossorigin"),

    /**
     * AS: Specifies the type of content that is used to submit the form to the server.
     * This can be used to specify the type of content that is used to submit the form to the server.
     */
    AS("as"),

    /**
     * LABEL: Specifies the visible text in a drop-down list.
     * This can be used to specify the visible text in a drop-down list.
     */
    LABEL("label"),

    /**
     * SELECTED: Specifies that an option should be pre-selected when the page loads.
     * This can be used to specify that an option in a drop-down list should be pre-selected when the page loads.
     */
    SELECTED("selected"),

    /**
     * CHECKED: Specifies that an input field should be pre-selected when the page loads (for type="checkbox" or type="radio").
     * This can be used to specify that a checkbox or radio button should be pre-selected when the page loads.
     */
    CHECKED("checked"),

    /**
     * COMMANDS: Specifies a command to be invoked.
     * This can be used to specify a command that can be invoked.
     */
    COMMANDS("commands"),

    /**
     * ICON: Specifies the icon for a command.
     * This can be used to specify an icon for a command.
     */
    ICON("icon"),

    /**
     * Specifies the name of the radio group for command elements.
     * This can be used when you have a group of radio buttons and you want to submit the value of the selected one.
     */
    RADIO_GROUP("radiogroup"),

    /**
     * Specifies the number of columns a cell should span in a table.
     * This can be used to make a cell span multiple columns for layout purposes.
     */
    COLSPAN("colspan"),

    /**
     * Specifies the number of rows a cell should span in a table.
     * This can be used to make a cell span multiple rows for layout purposes.
     */
    ROWSPAN("rowspan"),

    /**
     * Specifies one or more headers cells a cell is related to in a table.
     * This can be used to associate a cell with headers for accessibility purposes.
     */
    HEADERS("headers"),

    /**
     * Specifies a way to categorize cells in a table.
     * This can be used to apply styles or perform other operations on specific categories of cells.
     */
    SCOPE("scope"),

    /**
     * Specifies an abbreviated version of the content in a cell.
     * This can be used to provide a shorter version of cell content for use where space is limited.
     */
    ABBR("abbr"),

    /**
     * Specifies the horizontal alignment of the content in a cell.
     * This can be used to align cell content to the left, right, or center.
     */
    ALIGN("align"),

    /**
     * Specifies a comma-separated list of related headers in a table.
     * This can be used to associate a cell with multiple headers for complex data tables.
     */
    AXIS("axis"),

    /**
     * Specifies a character that should be aligned vertically for each cell in a column.
     * This can be used to align cell content around a specific character.
     */
    CHAR("char"),

    /**
     * Specifies how many characters the cell should be shifted to the right.
     * This can be used in conjunction with the CHAR attribute to align cell content.
     */
    CHAR_OFF("charoff"),

    /**
     * Specifies the vertical alignment of the content in a cell.
     * This can be used to align cell content to the top, middle, or bottom.
     */
    VALIGN("valign"),

    /**
     * Specifies the number of columns a cell should span in a table.
     * This can be used to make a cell span multiple columns for layout purposes.
     */
    SPAN("span"),

    /**
     * Specifies whether a border should be displayed around an iframe.
     * This can be used to control the appearance of an iframe.
     */
    FRAME_BORDER("frameborder"),

    /**
     * Specifies a long description for an iframe.
     * This can be used to provide additional information about the content of an iframe.
     */
    LONG_DESC("longdesc"),

    /**
     * Specifies the top and bottom margins of the content of an iframe.
     * This can be used to control the spacing around the content inside an iframe.
     */
    MARGIN_HEIGHT("marginheight"),

    /**
     * Specifies the left and right margins of the content of an iframe.
     * This can be used to control the spacing around the content inside an iframe.
     */
    MARGIN_WIDTH("marginwidth"),

    /**
     * Specifies the color of the text.
     * This can be used to set the color of text in an element.
     */
    COLOR("color"),

    /**
     * Specifies the font of the text.
     * This can be used to set the font for text in an element.
     */
    FACE("face"),

    /**
     * Specifies the size of the text.
     * This can be used to set the size of text in an element.
     */
    SIZE("size"),

    /**
     * Specifies the side where lines will be broken.
     * This can be used to control where line breaks occur in text.
     */
    CLEAR("clear"),

    /**
     * Specifies that a hr element should be drawn as a shaded rule.
     * This can be used to give a hr element a 3D appearance.
     */
    NO_SHADE("noshade"),

    /**
     * Specifies that an ul element should render more compactly.
     * This can be used to reduce the amount of space used by a list.
     */
    COMPACT("compact"),

    /**
     * Specifies which parts of the outside borders that should be visible.
     * This can be used to control the appearance of the borders of a table.
     */
    FRAME("frame"),

    /**
     * Specifies which parts of the inside borders that should be visible.
     * This can be used to control the appearance of the borders between cells in a table.
     */
    RULES("rules"),

    /**
     * Specifies a summary of the content of a table.
     * This can be used to provide a brief overview of what information a table contains.
     */
    SUMMARY("summary"),

    /**
     * Specifies the space between the cell wall and the cell content.
     * This can be used to control the amount of space between the cell border and its content.
     */
    CELL_PADDING("cellpadding"),

    /**
     * Specifies the space between cells in a table.
     * This can be used to control the amount of space between cells in a table.
     */
    CELLS_PACING("cellspacing"),

    /**
     * Specifies the background color of a table.
     * This can be used to set the background color for a table.
     */
    BG_COLOR("bgcolor"),

    /**
     * Specifies the width of the borders around a table.
     * This can be used to control the thickness of a table's borders.
     */
    BORDER("border"),

    /**
     * Specifies the color of the borders around a table.
     * This can be used to set the color of a table's borders.
     */
    BORDER_COLOR("bordercolor"),

    /**
     * Specifies that the content inside a cell should not wrap.
     * This can be used to prevent the content in a cell from wrapping to multiple lines.
     */
    NOWRAP("nowrap");
}