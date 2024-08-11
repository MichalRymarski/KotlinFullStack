/**
 * This file contains a collection of constants representing various Bootstrap classes and utilities.
 * These constants can be used to easily apply Bootstrap styles and functionality in a Kotlin application.
 * The constants cover a wide range of Bootstrap features, including the grid system, display, flex, text, colors, borders, sizing, and more.
 * These constants can be imported and used throughout the application to ensure consistent and standardized use of Bootstrap classes.
 */
@file:Suppress("unused")

package website.constants

// Bootstrap Grid System
/**
 * Represents the main container class in Bootstrap's grid system.
 * Use this for a responsive fixed-width container.
 */
const val CONTAINER = "container"

/**
 * Represents a full-width container class in Bootstrap's grid system.
 * Use this for a container that spans the entire width of the viewport.
 */
const val CONTAINER_FLUID = "container-fluid"

/**
 * Represents a row in Bootstrap's grid system.
 * Use this to create horizontal groups of columns.
 */
const val ROW = "row"

/**
 * Represents a basic column class in Bootstrap's grid system.
 * Use this for equal-width columns that automatically size themselves.
 */
const val COLUMN = "col"

/**
 * Represents a column class for small screens in Bootstrap's grid system.
 * Use this for column behavior on screens that are at least 576px wide.
 */
const val COLUMN_SM = "col-sm"

/**
 * Represents a column class for medium screens in Bootstrap's grid system.
 * Use this for column behavior on screens that are at least 768px wide.
 */
const val COLUMN_MD = "col-md"

/**
 * Represents a column class for large screens in Bootstrap's grid system.
 * Use this for column behavior on screens that are at least 992px wide.
 */
const val COLUMN_LG = "col-lg"

/**
 * Represents a column class for extra large screens in Bootstrap's grid system.
 * Use this for column behavior on screens that are at least 1200px wide.
 */
const val COLUMN_XL = "col-xl"

// Bootstrap Display
/**
 * Represents a utility class to hide an element.
 * Use this to remove an element from the document flow and hide it visually.
 */
const val D_NONE = "d-none"

/**
 * Represents a utility class to set an element's display property to inline.
 * Use this to make an element generate one or more inline boxes.
 */
const val D_INLINE = "d-inline"

/**
 * Represents a utility class to set an element's display property to inline-block.
 * Use this to make an element generate an inline-level block container.
 */
const val D_INLINE_BLOCK = "d-inline-block"

/**
 * Represents a utility class to set an element's display property to block.
 * Use this to make an element generate a block-level box.
 */
const val D_BLOCK = "d-block"

/**
 * Represents a utility class to set an element's display property to table.
 * Use this to make an element behave like a <table> HTML element.
 */
const val D_TABLE = "d-table"

/**
 * Represents a utility class to set an element's display property to table-cell.
 * Use this to make an element behave like a <td> HTML element.
 */
const val D_TABLE_CELL = "d-table-cell"

/**
 * Represents a utility class to set an element's display property to flex.
 * Use this to create a block-level flex container.
 */
const val D_FLEX = "d-flex"

/**
 * Represents a utility class to set an element's display property to inline-flex.
 * Use this to create an inline-level flex container.
 */
const val D_INLINE_FLEX = "d-inline-flex"

// Bootstrap Flex
/**
 * Represents a utility class to set flex direction to row.
 * Use this to arrange flex items horizontally from left to right.
 */
const val FLEX_ROW = "flex-row"

/**
 * Represents a utility class to set flex direction to column.
 * Use this to arrange flex items vertically from top to bottom.
 */
const val FLEX_COLUMN = "flex-column"

/**
 * Represents a utility class to allow flex items to wrap onto multiple lines.
 * Use this when you want flex items to wrap to the next line if they don't fit on one line.
 */
const val FLEX_WRAP = "flex-wrap"

/**
 * Represents a utility class to force flex items to stay on a single line.
 * Use this when you want flex items to remain on one line, even if they overflow.
 */
const val FLEX_NOWRAP = "flex-nowrap"

/**
 * Represents a utility class to wrap flex items in reverse order.
 * Use this to wrap flex items from right to left instead of left to right.
 */
const val FLEX_WRAP_REVERSE = "flex-wrap-reverse"

/**
 * Represents a utility class to make a flex item grow and shrink as needed.
 * Use this to allow a flex item to fill available space along the main axis.
 */
const val FLEX_FILL = "flex-fill"

/**
 * Represents a utility class to prevent a flex item from growing.
 * Use this when you don't want a flex item to expand to fill available space.
 */
const val FLEX_GROW_0 = "flex-grow-0"

/**
 * Represents a utility class to allow a flex item to grow.
 * Use this when you want a flex item to expand to fill available space.
 */
const val FLEX_GROW_1 = "flex-grow-1"

/**
 * Represents a utility class to prevent a flex item from shrinking.
 * Use this when you don't want a flex item to shrink below its initial size.
 */
const val FLEX_SHRINK_0 = "flex-shrink-0"

/**
 * Represents a utility class to allow a flex item to shrink.
 * Use this when you want a flex item to be able to shrink if necessary.
 */
const val FLEX_SHRINK_1 = "flex-shrink-1"

// Bootstrap Justify Content
/**
 * Represents a utility class to align flex items to the start of the container.
 * Use this to pack flex items from the start of the main axis.
 */
const val JUSTIFY_CONTENT_START = "justify-content-start"

/**
 * Represents a utility class to align flex items to the end of the container.
 * Use this to pack flex items from the end of the main axis.
 */
const val JUSTIFY_CONTENT_END = "justify-content-end"

/**
 * Represents a utility class to align flex items at the center of the container.
 * Use this to center flex items along the main axis.
 */
const val JUSTIFY_CONTENT_CENTER = "justify-content-center"

/**
 * Represents a utility class to distribute flex items evenly.
 * Use this to create equal space between flex items, with the first and last items aligned to the edges.
 */
const val JUSTIFY_CONTENT_BETWEEN = "justify-content-between"

/**
 * Represents a utility class to distribute flex items evenly with space around them.
 * Use this to create equal space around flex items, including before the first and after the last item.
 */
const val JUSTIFY_CONTENT_AROUND = "justify-content-around"

// Bootstrap Align Items
/**
 * Represents a utility class to align flex items to the start of the cross axis.
 * Use this to align flex items to the top of a flex container.
 */
const val ALIGN_ITEMS_START = "align-items-start"

/**
 * Represents a utility class to align flex items to the end of the cross axis.
 * Use this to align flex items to the bottom of a flex container.
 */
const val ALIGN_ITEMS_END = "align-items-end"

/**
 * Represents a utility class to align flex items at the center of the cross axis.
 * Use this to vertically center flex items within a flex container.
 */
const val ALIGN_ITEMS_CENTER = "align-items-center"

/**
 * Represents a utility class to align flex items along their baselines.
 * Use this to align flex items based on their text baselines.
 */
const val ALIGN_ITEMS_BASELINE = "align-items-baseline"

/**
 * Represents a utility class to stretch flex items to fill the container's cross axis.
 * Use this to make flex items expand vertically to fill the container's height.
 */
const val ALIGN_ITEMS_STRETCH = "align-items-stretch"

// Bootstrap Text Alignment
/**
 * Represents a utility class to align text to the left.
 * Use this to left-align text within an element.
 */
const val TEXT_LEFT = "text-left"

/**
 * Represents a utility class to center-align text.
 * Use this to center text within an element.
 */
const val TEXT_CENTER = "text-center"

/**
 * Represents a utility class to align text to the right.
 * Use this to right-align text within an element.
 */
const val TEXT_RIGHT = "text-right"

// Bootstrap Text Transform
/**
 * Represents a utility class to transform text to lowercase.
 * Use this to convert all characters in text to lowercase.
 */
const val TEXT_LOWERCASE = "text-lowercase"

/**
 * Represents a utility class to transform text to uppercase.
 * Use this to convert all characters in text to uppercase.
 */
const val TEXT_UPPERCASE = "text-uppercase"

/**
 * Represents a utility class to capitalize text.
 * Use this to capitalize the first character of each word in text.
 */
const val TEXT_CAPITALIZE = "text-capitalize"

// Bootstrap Font Weight
/**
 * Represents a utility class to set font weight to bold.
 * Use this to make text bold.
 */
const val FONT_WEIGHT_BOLD = "font-weight-bold"

/**
 * Represents a utility class to set font weight to bolder.
 * Use this to make text bolder than the parent element.
 */
const val FONT_WEIGHT_BOLDER = "font-weight-bolder"

/**
 * Represents a utility class to set font weight to normal.
 * Use this to reset text to normal weight.
 */
const val FONT_WEIGHT_NORMAL = "font-weight-normal"

/**
 * Represents a utility class to set font weight to light.
 * Use this to make text lighter.
 */
const val FONT_WEIGHT_LIGHT = "font-weight-light"

/**
 * Represents a utility class to set font weight to lighter.
 * Use this to make text lighter than the parent element.
 */
const val FONT_WEIGHT_LIGHTER = "font-weight-lighter"

// Bootstrap Margin and Padding
/**
 * Represents a utility class to set margin to 0 on all sides.
 * Use this to remove margin from an element.
 */
const val M_0 = "m-0"

/**
 * Represents a utility class to set margin to the smallest size on all sides.
 * Use this to add a small margin around an element.
 */
const val M_1 = "m-1"

/**
 * Represents a utility class to set margin to the second smallest size on all sides.
 * Use this to add a slightly larger margin around an element.
 */
const val M_2 = "m-2"

/**
 * Represents a utility class to set margin to the medium size on all sides.
 * Use this to add a medium margin around an element.
 */
const val M_3 = "m-3"

/**
 * Represents a utility class to set margin to the second largest size on all sides.
 * Use this to add a large margin around an element.
 */
const val M_4 = "m-4"

/**
 * Represents a utility class to set margin to the largest size on all sides.
 * Use this to add the largest predefined margin around an element.
 */
const val M_5 = "m-5"

/**
 * Represents a utility class to set padding to 0 on all sides.
 * Use this to remove padding from an element.
 */
const val P_0 = "p-0"

/**
 * Represents a utility class to set padding to the smallest size on all sides.
 * Use this to add a small padding inside an element.
 */
const val P_1 = "p-1"

/**
 * Represents a utility class to set padding to the second smallest size on all sides.
 * Use this to add a slightly larger padding inside an element.
 */
const val P_2 = "p-2"

/**
 * Represents a utility class to set padding to the medium size on all sides.
 * Use this to add a medium padding inside an element.
 */
const val P_3 = "p-3"

/**
 * Represents a utility class to set padding to the second largest size on all sides.
 * Use this to add a large padding inside an element.
 */
const val P_4 = "p-4"

/**
 * Represents a utility class to set padding to the largest size on all sides.
 * Use this to add the largest predefined padding inside an element.
 */
const val P_5 = "p-5"

// Bootstrap Colors
/**
 * Represents a utility class to set the background color to the primary theme color.
 * Use this to apply the primary color as a background.
 */
const val BG_PRIMARY = "bg-primary"

/**
 * Represents a utility class to set the background color to the secondary theme color.
 * Use this to apply the secondary color as a background.
 */
const val BG_SECONDARY = "bg-secondary"

/**
 * Represents a utility class to set the background color to indicate success.
 * Use this to apply a success-indicating background color.
 */
const val BG_SUCCESS = "bg-success"

/**
 * Represents a utility class to set the background color to indicate danger or error.
 * Use this to apply a danger-indicating background color.
 */
const val BG_DANGER = "bg-danger"

/**
 * Represents a utility class to set the background color to indicate a warning.
 * Use this to apply a warning-indicating background color.
 */
const val BG_WARNING = "bg-warning"

/**
 * Represents a utility class to set the background color to indicate information.
 * Use this to apply an info-indicating background color.
 */
const val BG_INFO = "bg-info"

/**
 * Represents a utility class to set the background color to a light shade.
 * Use this to apply a light background color.
 */
const val BG_LIGHT = "bg-light"

/**
 * Represents a utility class to set the background color to a dark shade.
 * Use this to apply a dark background color.
 */
const val BG_DARK = "bg-dark"

/**
 * Represents a utility class to set the text color to the primary theme color.
 * Use this to apply the primary color to text.
 */
const val TEXT_PRIMARY = "text-primary"

/**
 * Represents a utility class to set the text color to the secondary theme color.
 * Use this to apply the secondary color to text.
 */
const val TEXT_SECONDARY = "text-secondary"

/**
 * Represents a utility class to set the text color to indicate success.
 * Use this to apply a success-indicating color to text.
 */
const val TEXT_SUCCESS = "text-success"

/**
 * Represents a utility class to set the text color to indicate danger or error.
 * Use this to apply a danger-indicating color to text.
 */
const val TEXT_DANGER = "text-danger"
/**
 * Represents a utility class to set the text color to indicate a warning.
 * Use this to apply a warning-indicating color to text.
 */
const val TEXT_WARNING = "text-warning"

/**
 * Represents a utility class to set the text color to indicate information.
 * Use this to apply an info-indicating color to text.
 */
const val TEXT_INFO = "text-info"

/**
 * Represents a utility class to set the text color to a light shade.
 * Use this to apply a light color to text, typically used on dark backgrounds.
 */
const val TEXT_LIGHT = "text-light"

/**
 * Represents a utility class to set the text color to a dark shade.
 * Use this to apply a dark color to text, typically used on light backgrounds.
 */
const val TEXT_DARK = "text-dark"

// Bootstrap Borders
/**
 * Represents a utility class to add a border on all sides of an element.
 * Use this to apply a default border to all sides of an element.
 */
const val BORDER = "border"

/**
 * Represents a utility class to add a border to the top of an element.
 * Use this to apply a default border only to the top side of an element.
 */
const val BORDER_TOP = "border-top"

/**
 * Represents a utility class to add a border to the right side of an element.
 * Use this to apply a default border only to the right side of an element.
 */
const val BORDER_RIGHT = "border-right"

/**
 * Represents a utility class to add a border to the bottom of an element.
 * Use this to apply a default border only to the bottom side of an element.
 */
const val BORDER_BOTTOM = "border-bottom"

/**
 * Represents a utility class to add a border to the left side of an element.
 * Use this to apply a default border only to the left side of an element.
 */
const val BORDER_LEFT = "border-left"

// Bootstrap Sizing
/**
 * Represents a utility class to set the width of an element to 25% of its container.
 * Use this to make an element occupy 25% of the available width.
 */
const val W_25 = "w-25"

/**
 * Represents a utility class to set the width of an element to 50% of its container.
 * Use this to make an element occupy half of the available width.
 */
const val W_50 = "w-50"

/**
 * Represents a utility class to set the width of an element to 75% of its container.
 * Use this to make an element occupy 75% of the available width.
 */
const val W_75 = "w-75"

/**
 * Represents a utility class to set the width of an element to 100% of its container.
 * Use this to make an element occupy the full available width.
 */
const val W_100 = "w-100"

/**
 * Represents a utility class to set the height of an element to 25% of its container.
 * Use this to make an element occupy 25% of the available height.
 */
const val H_25 = "h-25"

/**
 * Represents a utility class to set the height of an element to 50% of its container.
 * Use this to make an element occupy half of the available height.
 */
const val H_50 = "h-50"

/**
 * Represents a utility class to set the height of an element to 75% of its container.
 * Use this to make an element occupy 75% of the available height.
 */
const val H_75 = "h-75"

/**
 * Represents a utility class to set the height of an element to 100% of its container.
 * Use this to make an element occupy the full available height.
 */
const val H_100 = "h-100"

// Bootstrap Spacing (Margin and Padding)
/**
 * Represents a utility class to set vertical (top and bottom) margins to auto.
 * Use this to vertically center an element within its container.
 */
const val MY_AUTO = "my-auto"

/**
 * Represents a utility class to set horizontal (left and right) margins to auto.
 * Use this to horizontally center an element within its container.
 */
const val MX_AUTO = "mx-auto"

/**
 * Represents a utility class to set the top margin to the smallest size.
 * Use this to add a small margin to the top of an element.
 */
const val MT_1 = "mt-1"

/**
 * Represents a utility class to set the bottom margin to the second smallest size.
 * Use this to add a slightly larger margin to the bottom of an element.
 */
const val MB_2 = "mb-2"

/**
 * Represents a utility class to set the left margin to the medium size.
 * Use this to add a medium margin to the left of an element.
 */
const val ML_3 = "ml-3"

/**
 * Represents a utility class to set the right margin to the second largest size.
 * Use this to add a large margin to the right of an element.
 */
const val MR_4 = "mr-4"

/**
 * Represents a utility class to set vertical (top and bottom) padding to the second smallest size.
 * Use this to add a slightly larger padding to the top and bottom of an element.
 */
const val PY_2 = "py-2"

/**
 * Represents a utility class to set horizontal (left and right) padding to the medium size.
 * Use this to add a medium padding to the left and right of an element.
 */
const val PX_3 = "px-3"

/**
 * Represents a utility class to set the top padding to the second largest size.
 * Use this to add a large padding to the top of an element.
 */
const val PT_4 = "pt-4"

/**
 * Represents a utility class to set the bottom padding to the largest size.
 * Use this to add the largest predefined padding to the bottom of an element.
 */
const val PB_5 = "pb-5"

// Bootstrap Text
/**
 * Represents a utility class to set the text color to a muted (less emphasized) shade.
 * Use this to de-emphasize text or make it appear secondary.
 */
const val TEXT_MUTED = "text-muted"

/**
 * Represents a utility class to truncate text with an ellipsis if it exceeds its container.
 * Use this to prevent text from wrapping and show an ellipsis (...) for overflow.
 */
const val TEXT_TRUNCATE = "text-truncate"

/**
 * Represents a utility class to prevent text from wrapping.
 * Use this to keep text on a single line, even if it overflows its container.
 */
const val TEXT_NOWRAP = "text-nowrap"

/**
 * Represents a utility class to allow long words to break and wrap onto the next line.
 * Use this to prevent overflow and improve readability for long words or URLs.
 */
const val TEXT_BREAK = "text-break"

// Bootstrap Position
/**
 * Represents a utility class to set an element's position to static.
 * Use this to position an element according to the normal flow of the document.
 */
const val POSITION_STATIC = "position-static"

/**
 * Represents a utility class to set an element's position to relative.
 * Use this to position an element relative to its normal position.
 */
const val POSITION_RELATIVE = "position-relative"

/**
 * Represents a utility class to set an element's position to absolute.
 * Use this to position an element relative to its nearest positioned ancestor.
 */
const val POSITION_ABSOLUTE = "position-absolute"

/**
 * Represents a utility class to set an element's position to fixed.
 * Use this to position an element relative to the browser window.
 */
const val POSITION_FIXED = "position-fixed"

/**
 * Represents a utility class to set an element's position to sticky.
 * Use this to make an element stick to a specific position as the user scrolls.
 */
const val POSITION_STICKY = "position-sticky"

// Bootstrap Visibility
/**
 * Represents a utility class to make an element visible.
 * Use this to ensure an element is visible (not hidden).
 */
const val VISIBLE = "visible"

/**
 * Represents a utility class to hide an element while preserving its layout space.
 * Use this to hide an element without affecting the layout of surrounding elements.
 */
const val INVISIBLE = "invisible"

// Bootstrap Grid Columns
/**
 * Represents a utility class for a column that spans 1/12 of its container's width.
 * Use this in Bootstrap's grid system to create a narrow column.
 */
const val COLUMN_1 = "col-1"

/**
 * Represents a utility class for a column that spans 2/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 1/6 of the total width.
 */
const val COLUMN_2 = "col-2"

/**
 * Represents a utility class for a column that spans 3/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 1/4 of the total width.
 */
const val COLUMN_3 = "col-3"

/**
 * Represents a utility class for a column that spans 4/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 1/3 of the total width.
 */
const val COLUMN_4 = "col-4"

/**
 * Represents a utility class for a column that spans 5/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column slightly less than half the total width.
 */
const val COLUMN_5 = "col-5"

/**
 * Represents a utility class for a column that spans 6/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column half the total width.
 */
const val COLUMN_6 = "col-6"

/**
 * Represents a utility class for a column that spans 7/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column slightly more than half the total width.
 */
const val COLUMN_7 = "col-7"

/**
 * Represents a utility class for a column that spans 8/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 2/3 of the total width.
 */
const val COLUMN_8 = "col-8"

/**
 * Represents a utility class for a column that spans 9/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 3/4 of the total width.
 */
const val COLUMN_9 = "col-9"

/**
 * Represents a utility class for a column that spans 10/12 of its container's width.
 * Use this in Bootstrap's grid system to create a column 5/6 of the total width.
 */
const val COLUMN_10 = "col-10"

/**
 * Represents a utility class for a column that spans 11/12 of its container's width.
 * Use this in Bootstrap's grid system to create a very wide column.
 */
const val COLUMN_11 = "col-11"

/**
 * Represents a utility class for a column that spans the full width of its container.
 * Use this in Bootstrap's grid system to create a column that takes up the entire row.
 */
const val COLUMN_12 = "col-12"

// Bootstrap Responsive Breakpoints
/**
 * Represents the small breakpoint in Bootstrap's responsive design.
 * Use this for styles that apply to screens 576px wide and up.
 */
const val SM = "sm"

/**
 * Represents the medium breakpoint in Bootstrap's responsive design.
 * Use this for styles that apply to screens 768px wide and up.
 */
const val MD = "md"

/**
 * Represents the large breakpoint in Bootstrap's responsive design.
 * Use this for styles that apply to screens 992px wide and up.
 */
const val LG = "lg"

/**
 * Represents the extra large breakpoint in Bootstrap's responsive design.
 * Use this for styles that apply to screens 1200px wide and up.
 */
const val XL = "xl"

// Bootstrap Alignment
/**
 * Represents a utility class to align an element's baseline with the baseline of its container.
 * Use this for inline or table-cell elements to align their text baselines.
 */
const val ALIGN_BASELINE = "align-baseline"

/**
 * Represents a utility class to align the top of an element with the top of its container.
 * Use this for inline or table-cell elements to align them to the top.
 */
const val ALIGN_TOP = "align-top"

/**
 * Represents a utility class to vertically center an element within its container.
 * Use this for inline or table-cell elements to center them vertically.
 */
const val ALIGN_MIDDLE = "align-middle"

/**
 * Represents a utility class to align the bottom of an element with the bottom of its container.
 * Use this for inline or table-cell elements to align them to the bottom.
 */
const val ALIGN_BOTTOM = "align-bottom"

/**
 * Represents a utility class to align the top of an element with the top of the parent's font.
 * Use this for precise text alignment within inline elements.
 */
const val ALIGN_TEXT_TOP = "align-text-top"

/**
 * Represents a utility class to align the bottom of an element with the bottom of the parent's font.
 * Use this for precise text alignment within inline elements.
 */
const val ALIGN_TEXT_BOTTOM = "align-text-bottom"

// Bootstrap Float
/**
 * Represents a utility class to float an element to the left.
 * Use this to make an element float to the left of its container.
 */
const val FLOAT_LEFT = "float-left"

/**
 * Represents a utility class to float an element to the right.
 * Use this to make an element float to the right of its container.
 */
const val FLOAT_RIGHT = "float-right"

/**
 * Represents a utility class to remove float from an element.
 * Use this to prevent an element from floating.
 */
const val FLOAT_NONE = "float-none"

// Bootstrap Borders
/**
 * Represents a utility class to set the border color to the primary theme color.
 * Use this to apply the primary color to an element's border.
 */
const val BORDER_PRIMARY = "border-primary"

/**
 * Represents a utility class to set the border color to the secondary theme color.
 * Use this to apply the secondary color to an element's border.
 */
const val BORDER_SECONDARY = "border-secondary"

/**
 * Represents a utility class to set the border color to indicate success.
 * Use this to apply a success-indicating color to an element's border.
 */
const val BORDER_SUCCESS = "border-success"

/**
 * Represents a utility class to set the border color to indicate danger or error.
 * Use this to apply a danger-indicating color to an element's border.
 */
const val BORDER_DANGER = "border-danger"

/**
 * Represents a utility class to set the border color to indicate a warning.
 * Use this to apply a warning-indicating color to an element's border.
 */
const val BORDER_WARNING = "border-warning"

/**
 * Represents a utility class to set the border color to indicate information.
 * Use this to apply an info-indicating color to an element's border.
 */
const val BORDER_INFO = "border-info"



/**
 * Represents a utility class to set the border color to a light shade.
 * Use this to apply a light color to an element's border.
 */
const val BORDER_LIGHT = "border-light"

/**
 * Represents a utility class to set the border color to a dark shade.
 * Use this to apply a dark color to an element's border.
 */
const val BORDER_DARK = "border-dark"

// Bootstrap Rounded Corners
/**
 * Represents a utility class to remove border radius from all corners.
 * Use this to create elements with sharp corners.
 */
const val ROUNDED_0 = "rounded-0"

/**
 * Represents a utility class to add a default border radius to all corners.
 * Use this to create elements with slightly rounded corners.
 */
const val ROUNDED = "rounded"

/**
 * Represents a utility class to add border radius to the top corners.
 * Use this to round only the top corners of an element.
 */
const val ROUNDED_TOP = "rounded-top"

/**
 * Represents a utility class to add border radius to the right corners.
 * Use this to round only the right corners of an element.
 */
const val ROUNDED_RIGHT = "rounded-right"

/**
 * Represents a utility class to add border radius to the bottom corners.
 * Use this to round only the bottom corners of an element.
 */
const val ROUNDED_BOTTOM = "rounded-bottom"

/**
 * Represents a utility class to add border radius to the left corners.
 * Use this to round only the left corners of an element.
 */
const val ROUNDED_LEFT = "rounded-left"

/**
 * Represents a utility class to create a circular shape.
 * Use this to make an element (usually an image) perfectly circular.
 */
const val ROUNDED_CIRCLE = "rounded-circle"

/**
 * Represents a utility class to create a pill shape.
 * Use this to create elements with fully rounded sides and less rounded top and bottom.
 */
const val ROUNDED_PILL = "rounded-pill"

// Bootstrap Utilities
/**
 * Represents a utility class to clear floated content within a container.
 * Use this to ensure that a container fully encompasses floated children.
 */
const val CLEARFIX = "clearfix"

/**
 * Represents a utility class for creating a close icon (usually an "×").
 * Use this for dismissible components like alerts or modals.
 */
const val CLOSE = "close"

// Bootstrap Responsive Embeds
/**
 * Represents a utility class for creating responsive embed containers.
 * Use this as a wrapper for embedded content like videos to make them responsive.
 */
const val EMBED_RESPONSIVE = "embed-responsive"

/**
 * Represents a utility class for the embedded item within a responsive embed container.
 * Use this on the actual embedded element (e.g., iframe, embed, video) inside an embed-responsive container.
 */
const val EMBED_RESPONSIVE_ITEM = "embed-responsive-item"

// Bootstrap List Styles
/**
 * Represents a utility class to remove default list styles.
 * Use this to create lists without bullets or numbers.
 */
const val LIST_UNSTYLED = "list-unstyled"

/**
 * Represents a utility class to create inline lists.
 * Use this to make list items appear on a single line.
 */
const val LIST_INLINE = "list-inline"

/**
 * Represents a utility class for individual items in an inline list.
 * Use this on <li> elements within a list-inline container.
 */
const val LIST_INLINE_ITEM = "list-inline-item"

// Bootstrap Image Styles
/**
 * Represents a utility class to make images responsive.
 * Use this to make images scale with their parent width.
 */
const val IMG_FLUID = "img-fluid"

/**
 * Represents a utility class to create thumbnail images.
 * Use this to add a border and padding around images.
 */
const val IMG_THUMBNAIL = "img-thumbnail"

// Bootstrap Table Styles
/**
 * Represents the base class for Bootstrap tables.
 * Use this to apply basic styling to tables.
 */
const val TABLE = "table"

/**
 * Represents a utility class for striped tables.
 * Use this to add alternating background colors to table rows.
 */
const val TABLE_STRIPED = "table-striped"

/**
 * Represents a utility class for bordered tables.
 * Use this to add borders to all sides of the table and cells.
 */
const val TABLE_BORDERED = "table-bordered"

/**
 * Represents a utility class for hover effect on table rows.
 * Use this to add a hover effect when the mouse moves over table rows.
 */
const val TABLE_HOVER = "table-hover"

// Bootstrap Form Styles
/**
 * Represents the base class for Bootstrap form controls.
 * Use this on form elements like <input>, <select>, and <textarea> for basic styling.
 */
const val FORM_CONTROL = "form-control"

/**
 * Represents a container for form controls.
 * Use this to group a label with its corresponding form control.
 */
const val FORM_GROUP = "form-group"

/**
 * Represents a container for checkboxes and radio buttons.
 * Use this to properly style and position checkboxes and radio buttons.
 */
const val FORM_CHECK = "form-check"

/**
 * Represents the input element for checkboxes and radio buttons.
 * Use this on <input type="checkbox"> or <input type="radio"> elements.
 */
const val FORM_CHECK_INPUT = "form-check-input"

/**
 * Represents the label for checkbox and radio button inputs.
 * Use this on <label> elements associated with form-check-input elements.
 */
const val FORM_CHECK_LABEL = "form-check-label"

// Bootstrap Button Styles
/**
 * Represents the base class for Bootstrap buttons.
 * Use this as a base for all button styles.
 */
const val BTN = "btn"

/**
 * Represents the primary button style.
 * Use this for the main call-to-action buttons.
 */
const val BTN_PRIMARY = "btn-primary"

/**
 * Represents the secondary button style.
 * Use this for less prominent actions.
 */
const val BTN_SECONDARY = "btn-secondary"

/**
 * Represents a success-themed button style.
 * Use this for positive actions or to indicate successful operations.
 */
const val BTN_SUCCESS = "btn-success"

/**
 * Represents a danger-themed button style.
 * Use this for destructive actions or to indicate risky operations.
 */
const val BTN_DANGER = "btn-danger"

/**
 * Represents a warning-themed button style.
 * Use this for actions that require caution or attention.
 */
const val BTN_WARNING = "btn-warning"

/**
 * Represents an info-themed button style.
 * Use this for informational actions or to draw attention to non-critical information.
 */
const val BTN_INFO = "btn-info"

