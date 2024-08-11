@file:Suppress("unused")

package website.constants

enum class MaxWidth(private val value: String) {
    NONE("none"),
    XS("xs"),
    SM("sm"),
    MD("md"),
    LG("lg"),
    XL("xl"),
    XL2("2xl"),
    XL3("3xl"),
    XL4("4xl"),
    XL5("5xl"),
    XL6("6xl"),
    XL7("7xl"),
    FULL("full"),
    MIN("min"),
    MAX("max"),
    PROSE("prose"),
    SMALL_SCREEN("screen-sm"),
    MEDIUM_SCREEN("screen-md"),
    LARGE_SCREEN("screen-lg"),
    XL_SCREEN("screen-xl"),
    XL2_SCREEN("screen-2xl");

    override fun toString(): String {
        return "max-w-$value"
    }
}

enum class TextSize(private val value: String) {
    XS("xs"),
    SM("sm"),
    BASE("base"),
    LG("lg"),
    XL("xl"),
    XL2("2xl"),
    XL3("3xl"),
    XL4("4xl"),
    XL5("5xl"),
    XL6("6xl"),
    XL7("7xl"),
    XL8("8xl"),
    XL9("9xl");

    override fun toString(): String {
        return "text-$value"
    }
}


enum class Display(private val value: String) {
    BLOCK("block"),
    INLINE_BLOCK("inline-block"),
    INLINE("inline"),
    FLEX("flex"),
    INLINE_FLEX("inline-flex"),
    GRID("grid"),
    INLINE_GRID("inline-grid"),
    FLOW_ROOT("flow-root"),
    CONTENTS("contents"),
    TABLE("table"),
    HIDDEN("hidden");

    override fun toString(): String {
        return "display-$value"
    }
}

enum class Position(private val value: String) {
    STATIC("static"),
    FIXED("fixed"),
    ABSOLUTE("absolute"),
    RELATIVE("relative"),
    STICKY("sticky");

    override fun toString(): String {
        return "position-$value"
    }
}

enum class Overflow(private val value: String) {
    AUTO("auto"),
    HIDDEN("hidden"),
    VISIBLE("visible"),
    SCROLL("scroll");

    override fun toString(): String {
        return "overflow-$value"
    }
}

enum class TextAlign(private val value: String) {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right"),
    JUSTIFY("justify");

    override fun toString(): String {
        return "text-$value"
    }
}

enum class FlexDirection(private val value: String) {
    ROW("row"),
    ROW_REVERSE("row-reverse"),
    COL("col"),
    COL_REVERSE("col-reverse");

    override fun toString(): String {
        return "flex-$value"
    }
}

enum class FlexWrap(private val value: String) {
    NO_WRAP("no-wrap"),
    WRAP("wrap"),
    WRAP_REVERSE("wrap-reverse");

    override fun toString(): String {
        return "flex-$value"
    }
}

enum class ObjectFit(private val value: String) {
    CONTAIN("contain"),
    COVER("cover"),
    FILL("fill"),
    NONE("none"),
    SCALE_DOWN("scale-down");

    override fun toString(): String {
        return "object-$value"
    }
}

enum class Visibility(private val value: String) {
    VISIBLE("visible"),
    INVISIBLE("invisible");

    override fun toString(): String {
        return "visibility-$value"
    }
}

enum class FontWeight(private val value: String) {
    THIN("thin"),
    EXTRALIGHT("extralight"),
    LIGHT("light"),
    NORMAL("normal"),
    MEDIUM("medium"),
    SEMIBOLD("semibold"),
    BOLD("bold"),
    EXTRABOLD("extrabold"),
    BLACK("black");

    override fun toString(): String {
        return "font-$value"
    }
}

enum class Color(private val value: String) {
    TRANSPARENT("transparent"),
    CURRENT("current"),
    BLACK("black"),
    WHITE("white"),
    GRAY("gray"),
    GRAY_50("gray-50"),
    GRAY_100("gray-100"),
    GRAY_200("gray-200"),
    GRAY_300("gray-300"),
    GRAY_400("gray-400"),
    GRAY_500("gray-500"),
    GRAY_600("gray-600"),
    GRAY_700("gray-700"),
    GRAY_800("gray-800"),
    GRAY_900("gray-900"),
    RED("red"),
    RED_50("red-50"),
    RED_100("red-100"),
    RED_200("red-200"),
    RED_300("red-300"),
    RED_400("red-400"),
    RED_500("red-500"),
    RED_600("red-600"),
    RED_700("red-700"),
    RED_800("red-800"),
    RED_900("red-900"),
    YELLOW("yellow"),
    YELLOW_50("yellow-50"),
    YELLOW_100("yellow-100"),
    YELLOW_200("yellow-200"),
    YELLOW_300("yellow-300"),
    YELLOW_400("yellow-400"),
    YELLOW_500("yellow-500"),
    YELLOW_600("yellow-600"),
    YELLOW_700("yellow-700"),
    YELLOW_800("yellow-800"),
    YELLOW_900("yellow-900"),
    GREEN("green"),
    GREEN_50("green-50"),
    GREEN_100("green-100"),
    GREEN_200("green-200"),
    GREEN_300("green-300"),
    GREEN_400("green-400"),
    GREEN_500("green-500"),
    GREEN_600("green-600"),
    GREEN_700("green-700"),
    GREEN_800("green-800"),
    GREEN_900("green-900"),
    BLUE("blue"),
    BLUE_50("blue-50"),
    BLUE_100("blue-100"),
    BLUE_200("blue-200"),
    BLUE_300("blue-300"),
    BLUE_400("blue-400"),
    BLUE_500("blue-500"),
    BLUE_600("blue-600"),
    BLUE_700("blue-700"),
    BLUE_800("blue-800"),
    BLUE_900("blue-900"),
    INDIGO("indigo"),
    INDIGO_50("indigo-50"),
    INDIGO_100("indigo-100"),
    INDIGO_200("indigo-200"),
    INDIGO_300("indigo-300"),
    INDIGO_400("indigo-400"),
    INDIGO_500("indigo-500"),
    INDIGO_600("indigo-600"),
    INDIGO_700("indigo-700"),
    INDIGO_800("indigo-800"),
    INDIGO_900("indigo-900"),
    PURPLE("purple"),
    PURPLE_50("purple-50"),
    PURPLE_100("purple-100"),
    PURPLE_200("purple-200"),
    PURPLE_300("purple-300"),
    PURPLE_400("purple-400"),
    PURPLE_500("purple-500"),
    PURPLE_600("purple-600"),
    PURPLE_700("purple-700"),
    PURPLE_800("purple-800"),
    PURPLE_900("purple-900"),
    PINK("pink"),
    PINK_50("pink-50"),
    PINK_100("pink-100"),
    PINK_200("pink-200"),
    PINK_300("pink-300"),
    PINK_400("pink-400"),
    PINK_500("pink-500"),
    PINK_600("pink-600"),
    PINK_700("pink-700"),
    PINK_800("pink-800"),
    PINK_900("pink-900");

    fun textColor() = "text-$value"
    fun backgroundColor() = "bg-$value"
    fun borderColor() = "border-$value"

}



enum class BorderRadius(private val value: String) {
    NONE("none"),
    SM("sm"),
    DEFAULT(""),
    MD("md"),
    LG("lg"),
    XL("xl"),
    XL2("2xl"),
    XL3("3xl"),
    FULL("full");

    override fun toString(): String {
        return "rounded-$value"
    }
}

enum class Width(private val value: String) {
    AUTO("auto"),
    FULL("full"),
    SCREEN("screen"),
    MIN("min"),
    MAX("max");

    override fun toString(): String {
        return "w-$value"
    }
}

enum class Height(private val value: String) {
    AUTO("auto"),
    FULL("full"),
    SCREEN("screen"),
    MIN("min"),
    MAX("max");

    override fun toString(): String {
        return "h-$value"
    }
}

enum class JustifyContent(private val value: String) {
    START("start"),
    END("end"),
    CENTER("center"),
    BETWEEN("between"),
    AROUND("around"),
    EVENLY("evenly");

    override fun toString(): String {
        return "justify-$value"
    }
}

enum class AlignItems(private val value: String) {
    START("start"),
    END("end"),
    CENTER("center"),
    BASELINE("baseline"),
    STRETCH("stretch");

    override fun toString(): String {
        return "items-$value"
    }
}

enum class FlexGrow(private val value: String) {
    ZERO("0"),
    DEFAULT("");

    override fun toString(): String {
        return "flex-grow-$value"
    }
}

enum class FlexShrink(private val value: String) {
    ZERO("0"),
    DEFAULT("");

    override fun toString(): String {
        return "flex-shrink-$value"
    }
}

enum class Order(private val value: String) {
    FIRST("first"),
    LAST("last"),
    NONE("none"),
    NUMBER_1("1"),
    NUMBER_2("2"),
    NUMBER_3("3"),
    NUMBER_4("4"),
    NUMBER_5("5"),
    NUMBER_6("6"),
    NUMBER_7("7"),
    NUMBER_8("8"),
    NUMBER_9("9"),
    NUMBER_10("10"),
    NUMBER_11("11"),
    NUMBER_12("12");

    override fun toString(): String {
        return "order-$value"
    }
}



