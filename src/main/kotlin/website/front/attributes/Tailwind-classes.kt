@file:Suppress("unused")

package website.front.attributes

/**
 * Creates a Set of CSS classes from the given string values.
 * @param values The CSS class names to be combined.
 * @return A Set of unique CSS class names.
 */
fun classes(vararg values: String): Set<String> = values.toSet()

/**
 * Combines multiple CSS class names into a single space-separated string.
 * @param values The CSS class names to be combined.
 * @return A string of CSS class names separated by spaces.
 */
fun classesToString(vararg values: String): String = values.joinToString(" ")

/**
 * Generates a Tailwind CSS class for applying margin to all sides of an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for margin.
 */
fun margin(value: String): String = "m-$value"

/**
 * Generates a Tailwind CSS class for applying horizontal margin (left and right) to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for horizontal margin.
 */
fun marginX(value: String): String = "mx-$value"

/**
 * Generates a Tailwind CSS class for applying vertical margin (top and bottom) to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for vertical margin.
 */
fun marginY(value: String): String = "my-$value"

/**
 * Generates a Tailwind CSS class for setting the width of an element.
 * @param value The width value (e.g., "full", "1/2", "screen").
 * @return A Tailwind CSS class string for width.
 */
fun width(value: String): String = "w-$value"

/**
 * Generates a Tailwind CSS class for setting the maximum width of an element.
 * @param value The maximum width value from the MaxWidth enum.
 * @return A Tailwind CSS class string for maximum width.
 */
fun maxWidth(value: MaxWidth): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the height of an element.
 * @param value The height value (e.g., "full", "screen", "32").
 * @return A Tailwind CSS class string for height.
 */
fun height(value: String): String = "h-$value"

/**
 * Generates a Tailwind CSS class for setting the font size of text.
 * @param value The font size value from the TextSize enum.
 * @return A Tailwind CSS class string for font size.
 */
fun fontSize(value: TextSize): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the font weight of text.
 * @param value The font weight value (e.g., "normal", "bold", "600").
 * @return A Tailwind CSS class string for font weight.
 */
fun fontWeight(value: String): String = "font-$value"

/**
 * Generates a Tailwind CSS class for applying padding to all sides of an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for padding.
 */
fun padding(value: String): String = "p-$value"

/**
 * Generates a Tailwind CSS class for applying horizontal padding (left and right) to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for horizontal padding.
 */
fun paddingX(value: String): String = "px-$value"

/**
 * Generates a Tailwind CSS class for applying vertical padding (top and bottom) to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for vertical padding.
 */
fun paddingY(value: String): String = "py-$value"

/**
 * Generates a Tailwind CSS class for setting the text color.
 * @param value The color value (e.g., "blue-500", "red-700").
 * @return A Tailwind CSS class string for text color.
 */
fun textColor(value: String): String = "text-$value"

/**
 * Generates a Tailwind CSS class for setting the display property of an element.
 * @param value The display value (e.g., "block", "flex", "inline").
 * @return A Tailwind CSS class string for display.
 */
fun display(value: String): String = "display-$value"

/**
 * Generates a Tailwind CSS class for setting the background color of an element.
 * @param value The color value (e.g., "blue-500", "red-700").
 * @return A Tailwind CSS class string for background color.
 */
fun backgroundColor(value: String): String = "bg-$value"

/**
 * Generates a Tailwind CSS class for applying a border width to an element.
 * @param value The border width value (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for border width.
 */
fun border(value: String): String = "border-$value"

/**
 * Generates a Tailwind CSS class for applying flex properties to an element.
 * @param value The flex value (e.g., "1", "auto", "initial").
 * @return A Tailwind CSS class string for flex.
 */
fun flex(value: String): String = "flex-$value"

/**
 * Generates a Tailwind CSS class for setting the opacity of an element.
 * @param value The opacity value (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for opacity.
 */
fun opacity(value: String): String = "opacity-$value"

/**
 * Generates a Tailwind CSS class for applying rounded corners to an element.
 * @param value The border radius value (e.g., "sm", "md", "full").
 * @return A Tailwind CSS class string for rounded corners.
 */
fun rounded(value: String): String = "rounded-$value"

/**
 * Generates a Tailwind CSS class for setting the z-index of an element.
 * @param value The z-index value (e.g., "0", "10", "auto").
 * @return A Tailwind CSS class string for z-index.
 */
fun zIndex(value: String): String = "z-$value"

/**
 * Generates a Tailwind CSS class for applying a transition effect to an element.
 * @param value The transition property (e.g., "all", "colors", "opacity").
 * @return A Tailwind CSS class string for transition.
 */
fun transition(value: String): String = "transition-$value"

/**
 * Generates a Tailwind CSS class for setting the cursor style.
 * @param value The cursor style (e.g., "pointer", "not-allowed", "wait").
 * @return A Tailwind CSS class string for cursor style.
 */
fun cursor(value: CursorStyle): String = "cursor-$value"

/**
 * Generates a Tailwind CSS class for applying overflow behavior to an element.
 * @param value The overflow value (e.g., "auto", "hidden", "scroll").
 * @return A Tailwind CSS class string for overflow.
 */
fun overflow(value: String): String = "overflow-$value"

/**
 * Generates a Tailwind CSS class for setting the position of an element.
 * @param value The position value (e.g., "static", "relative", "absolute").
 * @return A Tailwind CSS class string for position.
 */
fun position(value: String): String = "position-$value"

/**
 * Generates a Tailwind CSS class for applying a shadow effect to an element.
 * @param value The shadow size (e.g., "sm", "md", "lg").
 * @return A Tailwind CSS class string for shadow.
 */
fun shadow(value: String): String = "shadow-$value"

/**
 * Generates a Tailwind CSS class for applying a default shadow effect to an element.
 * @return A Tailwind CSS class string for default shadow.
 */
fun shadow(): String = "shadow"

/**
 * Generates a Tailwind CSS class for setting the maximum width of an element.
 * @param value The maximum width value (e.g., "xs", "sm", "md").
 * @return A Tailwind CSS class string for maximum width.
 */
fun maxWidth(value: String): String = "max-w-$value"

/**
 * Generates a Tailwind CSS class for setting the minimum height of an element.
 * @param value The minimum height value (e.g., "0", "full", "screen").
 * @return A Tailwind CSS class string for minimum height.
 */
fun minHeight(value: String): String = "min-h-$value"

/**
 * Generates a Tailwind CSS class for applying gap between grid or flexbox items.
 * @param value The gap size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for gap.
 */
fun gap(value: String): String = "gap-$value"

/**
 * Generates a Tailwind CSS class for setting the number of columns in a grid layout.
 * @param value The number of columns (e.g., "1", "2", "3").
 * @return A Tailwind CSS class string for grid columns.
 */
fun gridCols(value: String): String = "grid-cols-$value"

/**
 * Generates a Tailwind CSS class for applying justify-content in flex or grid layouts.
 * @param value The justify-content value (e.g., "start", "center", "between").
 * @return A Tailwind CSS class string for justify-content.
 */
fun justifyContent(value: String): String = "justify-$value"

/**
 * Generates a Tailwind CSS class for aligning items in flex or grid layouts.
 * @param value The align-items value (e.g., "start", "center", "stretch").
 * @return A Tailwind CSS class string for align-items.
 */
fun alignItems(value: String): String = "items-$value"

/**
 * Generates a Tailwind CSS class for setting the letter spacing (tracking) of text.
 * @param value The tracking value (e.g., "tight", "normal", "wide").
 * @return A Tailwind CSS class string for letter spacing.
 */
fun tracking(value: String): String = "tracking-$value"

/**
 * Generates a Tailwind CSS class for applying left margin to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for left margin.
 */
fun marginLeft(value: String): String = "ml-$value"

/**
 * Generates a Tailwind CSS class for applying right margin to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for right margin.
 */
fun marginRight(value: String): String = "mr-$value"

/**
 * Generates a Tailwind CSS class for applying top margin to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for top margin.
 */
fun marginTop(value: String): String = "mt-$value"

/**
 * Generates a Tailwind CSS class for applying bottom margin to an element.
 * @param value The margin size (e.g., "2", "4", "auto").
 * @return A Tailwind CSS class string for bottom margin.
 */
fun marginBottom(value: String): String = "mb-$value"

/**
 * Generates a Tailwind CSS class for applying left padding to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for left padding.
 */
fun paddingLeft(value: String): String = "pl-$value"

/**
 * Generates a Tailwind CSS class for applying right padding to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for right padding.
 */
fun paddingRight(value: String): String = "pr-$value"

/**
 * Generates a Tailwind CSS class for applying top padding to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for top padding.
 */
fun paddingTop(value: String): String = "pt-$value"

/**
 * Generates a Tailwind CSS class for applying bottom padding to an element.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for bottom padding.
 */
fun paddingBottom(value: String): String = "pb-$value"

/**
 * Generates a Tailwind CSS class for setting the text alignment.
 * @param value The text alignment value (e.g., "left", "center", "right").
 * @return A Tailwind CSS class string for text alignment.
 */
fun textAlign(value: String): String = "text-$value"

/**
 * Generates a Tailwind CSS class for setting the flex direction.
 * @param value The flex direction value (e.g., "row", "column", "row-reverse").
 * @return A Tailwind CSS class string for flex direction.
 */
fun flexDirection(value: String): String = "flex-$value"

/**
 * Generates a Tailwind CSS class for setting the flex wrap behavior.
 * @param value The flex wrap value (e.g., "wrap", "nowrap", "wrap-reverse").
 * @return A Tailwind CSS class string for flex wrap.
 */
fun flexWrap(value: String): String = "flex-$value"

/**
 * Generates a Tailwind CSS class for setting the flex grow factor.
 * @param value The flex grow value (e.g., "0", "1").
 * @return A Tailwind CSS class string for flex grow.
 */
fun flexGrow(value: String): String = "flex-grow-$value"

/**
 * Generates a Tailwind CSS class for setting the flex shrink factor.
 * @param value The flex shrink value (e.g., "0", "1").
 * @return A Tailwind CSS class string for flex shrink.
 */
fun flexShrink(value: String): String = "flex-shrink-$value"

/**
 * Generates a Tailwind CSS class for setting the order of flex or grid items.
 * @param value The order value (e.g., "1", "2", "first", "last").
 * @return A Tailwind CSS class string for order.
 */
fun order(value: String): String = "order-$value"

/**
 * Generates a Tailwind CSS class for setting the grid row start/end positions.
 * @param value The grid row value (e.g., "1", "2", "span-2").
 * @return A Tailwind CSS class string for grid row.
 */
fun gridRow(value: String): String = "row-$value"



/**
 * Generates a Tailwind CSS class for setting the grid column start/end positions.
 * @param value The grid column value (e.g., "1", "2", "span-2").
 * @return A Tailwind CSS class string for grid column.
 */
fun gridColumn(value: String): String = "col-$value"

/**
 * Generates a Tailwind CSS class for applying place-content in grid layouts.
 * @param value The place-content value (e.g., "center", "start", "end").
 * @return A Tailwind CSS class string for place-content.
 */
fun placeContent(value: String): String = "place-content-$value"

/**
 * Generates a Tailwind CSS class for applying place-items in grid layouts.
 * @param value The place-items value (e.g., "center", "start", "end").
 * @return A Tailwind CSS class string for place-items.
 */
fun placeItems(value: String): String = "place-items-$value"

/**
 * Generates a Tailwind CSS class for setting the object-fit property of an element.
 * @param value The object-fit value (e.g., "cover", "contain", "fill").
 * @return A Tailwind CSS class string for object-fit.
 */
fun objectFit(value: String): String = "object-$value"

/**
 * Generates a Tailwind CSS class for setting the object-position property of an element.
 * @param value The object-position value (e.g., "center", "top", "left-bottom").
 * @return A Tailwind CSS class string for object-position.
 */
fun objectPosition(value: String): String = "object-$value"

/**
 * Generates a Tailwind CSS class for applying overflow behavior on the x-axis.
 * @param value The overflow-x value (e.g., "auto", "hidden", "scroll").
 * @return A Tailwind CSS class string for overflow-x.
 */
fun overflowX(value: String): String = "overflow-x-$value"

/**
 * Generates a Tailwind CSS class for applying overflow behavior on the y-axis.
 * @param value The overflow-y value (e.g., "auto", "hidden", "scroll").
 * @return A Tailwind CSS class string for overflow-y.
 */
fun overflowY(value: String): String = "overflow-y-$value"

/**
 * Generates a Tailwind CSS class for setting the top position of an element.
 * @param value The top position value (e.g., "0", "1/2", "full").
 * @return A Tailwind CSS class string for top position.
 */
fun top(value: String): String = "top-$value"

/**
 * Generates a Tailwind CSS class for setting the right position of an element.
 * @param value The right position value (e.g., "0", "1/2", "full").
 * @return A Tailwind CSS class string for right position.
 */
fun right(value: String): String = "right-$value"

/**
 * Generates a Tailwind CSS class for setting the bottom position of an element.
 * @param value The bottom position value (e.g., "0", "1/2", "full").
 * @return A Tailwind CSS class string for bottom position.
 */
fun bottom(value: String): String = "bottom-$value"

/**
 * Generates a Tailwind CSS class for setting the left position of an element.
 * @param value The left position value (e.g., "0", "1/2", "full").
 * @return A Tailwind CSS class string for left position.
 */
fun left(value: String): String = "left-$value"

/**
 * Generates a Tailwind CSS class for applying visibility to an element.
 * @param value The visibility value (e.g., "visible", "invisible").
 * @return A Tailwind CSS class string for visibility.
 */
fun visibility(value: String): String = "visibility-$value"

/**
 * Generates a Tailwind CSS class for applying backdrop filter effects.
 * @param value The backdrop filter value (e.g., "blur", "brightness", "contrast").
 * @return A Tailwind CSS class string for backdrop filter.
 */
fun backdropFilter(value: String): String = "backdrop-$value"

/**
 * Generates a Tailwind CSS class for applying a blur effect to an element.
 * @param value The blur amount (e.g., "sm", "md", "lg").
 * @return A Tailwind CSS class string for blur effect.
 */
fun blur(value: String): String = "blur-$value"

/**
 * Generates a Tailwind CSS class for applying a brightness effect to an element.
 * @param value The brightness amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for brightness effect.
 */
fun brightness(value: String): String = "brightness-$value"

/**
 * Generates a Tailwind CSS class for applying a contrast effect to an element.
 * @param value The contrast amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for contrast effect.
 */
fun contrast(value: String): String = "contrast-$value"

/**
 * Generates a Tailwind CSS class for applying a grayscale effect to an element.
 * @param value The grayscale amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for grayscale effect.
 */
fun grayscale(value: String): String = "grayscale-$value"

/**
 * Generates a Tailwind CSS class for applying a hue-rotate effect to an element.
 * @param value The hue-rotate amount (e.g., "0", "90", "180").
 * @return A Tailwind CSS class string for hue-rotate effect.
 */
fun hueRotate(value: String): String = "hue-rotate-$value"

/**
 * Generates a Tailwind CSS class for applying an invert effect to an element.
 * @param value The invert amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for invert effect.
 */
fun invert(value: String): String = "invert-$value"

/**
 * Generates a Tailwind CSS class for applying a saturate effect to an element.
 * @param value The saturate amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for saturate effect.
 */
fun saturate(value: String): String = "saturate-$value"

/**
 * Generates a Tailwind CSS class for applying a sepia effect to an element.
 * @param value The sepia amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for sepia effect.
 */
fun sepia(value: String): String = "sepia-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop blur effect.
 * @param value The backdrop blur amount (e.g., "sm", "md", "lg").
 * @return A Tailwind CSS class string for backdrop blur effect.
 */
fun backdropBlur(value: String): String = "backdrop-blur-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop brightness effect.
 * @param value The backdrop brightness amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop brightness effect.
 */
fun backdropBrightness(value: String): String = "backdrop-brightness-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop contrast effect.
 * @param value The backdrop contrast amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop contrast effect.
 */
fun backdropContrast(value: String): String = "backdrop-contrast-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop grayscale effect.
 * @param value The backdrop grayscale amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop grayscale effect.
 */
fun backdropGrayscale(value: String): String = "backdrop-grayscale-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop hue-rotate effect.
 * @param value The backdrop hue-rotate amount (e.g., "0", "90", "180").
 * @return A Tailwind CSS class string for backdrop hue-rotate effect.
 */
fun backdropHueRotate(value: String): String = "backdrop-hue-rotate-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop invert effect.
 * @param value The backdrop invert amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop invert effect.
 */
fun backdropInvert(value: String): String = "backdrop-invert-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop opacity effect.
 * @param value The backdrop opacity amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop opacity effect.
 */
fun backdropOpacity(value: String): String = "backdrop-opacity-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop saturate effect.
 * @param value The backdrop saturate amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop saturate effect.
 */
fun backdropSaturate(value: String): String = "backdrop-saturate-$value"

/**
 * Generates a Tailwind CSS class for applying a backdrop sepia effect.
 * @param value The backdrop sepia amount (e.g., "0", "50", "100").
 * @return A Tailwind CSS class string for backdrop sepia effect.
 */
fun backdropSepia(value: String): String = "backdrop-sepia-$value"

/**
 * Generates a Tailwind CSS class for applying padding on small screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for small screen padding.
 */
fun smPadding(value: String): String = "sm:p-$value"

/**
 * Generates a Tailwind CSS class for applying padding on large screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for large screen padding.
 */
fun lgPadding(value: String): String = "lg:p-$value"

/**
 * Generates a Tailwind CSS class for applying top padding on small screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for small screen top padding.
 */
fun smPaddingTop(value: String): String = "sm:pt-$value"

/**
 * Generates a Tailwind CSS class for applying right padding on small screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for small screen right padding.
 */
fun smPaddingRight(value: String): String = "sm:pr-$value"

/**
 * Generates a Tailwind CSS class for applying bottom padding on small screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for small screen bottom padding.
 */
fun smPaddingBottom(value: String): String = "sm:pb-$value"

/**
 * Generates a Tailwind CSS class for applying left padding on small screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for small screen left padding.
 */
fun smPaddingLeft(value: String): String = "sm:pl-$value"

/**
 * Generates a Tailwind CSS class for applying top padding on large screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for large screen top padding.
 */
fun lgPaddingTop(value: String): String = "lg:pt-$value"

/**
 * Generates a Tailwind CSS class for applying right padding on large screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for large screen right padding.
 */
fun lgPaddingRight(value: String): String = "lg:pr-$value"

/**
 * Generates a Tailwind CSS class for applying bottom padding on large screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for large screen bottom padding.
 */
fun lgPaddingBottom(value: String): String = "lg:pb-$value"

/**
 * Generates a Tailwind CSS class for applying left padding on large screens.
 * @param value The padding size (e.g., "2", "4", "px").
 * @return A Tailwind CSS class string for large screen left padding.
 */
fun lgPaddingLeft(value: String): String = "lg:pl-$value"

/**
 * Generates a Tailwind CSS class for setting the font weight.
 * @param value The font weight value from the FontWeight enum.
 * @return A Tailwind CSS class string for font weight.
 */
fun fontWeight(value: FontWeight): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the display property.
 * @param value The display value from the Display enum.
 * @return A Tailwind CSS class string for display property.
 */
fun display(value: Display): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the text color.
 * @param value The color value from the Color enum.
 * @return A Tailwind CSS class string for text color.
 */
fun textColor(value: Color): String = value.textColor()

/**
 * Generates a Tailwind CSS class for setting the border color.
 * @param value The color value from the Color enum.
 * @return A Tailwind CSS class string for border color.
 */
fun borderColor(value: Color): String = value.borderColor()

/**
 * Generates a Tailwind CSS class for setting the background color.
 * @param value The color value from the Color enum.
 * @return A Tailwind CSS class string for background color.
 */
fun backgroundColor(value: Color): String = value.backgroundColor()

/**
 * Generates a Tailwind CSS class for applying justify-content in flex or grid layouts.
 * @param value The justify-content value from the JustifyContent enum.
 * @return A Tailwind CSS class string for justify-content.
 */
fun justifyContent(value: JustifyContent): String = value.toString()

/**
 * Generates a Tailwind CSS class for aligning items in flex or grid layouts.
 * @param value The align-items value from the AlignItems enum.
 * @return A Tailwind CSS class string for align-items.
 */
fun alignItems(value: AlignItems): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the flex grow factor.
 * @param value The flex grow value from the FlexGrow enum.
 * @return A Tailwind CSS class string for flex grow.
 */
fun flexGrow(value: FlexGrow): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the flex shrink factor.
 * @param value The flex shrink value from the FlexShrink enum.
 * @return A Tailwind CSS class string for flex shrink.
 */
fun flexShrink(value: FlexShrink): String = value.toString()

/**
 * Generates a Tailwind CSS class for setting the order of flex or grid items.
 * @param value The order value from the Order enum.
 * @return A Tailwind CSS class string for order.
 */
fun order(value: Order): String = value.toString()

