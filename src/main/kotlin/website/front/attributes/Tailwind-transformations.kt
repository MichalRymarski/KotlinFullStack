@file:Suppress("unused")

package website.front.attributes

class Transition private constructor(
    private val type: TransitionType,
    private val duration: String,
    private val ease: TransitionEase,
    private val effects: List<String>
) {
    override fun toString(): String {
        return "${type.value} ${transitionDuration(duration)} ${transitionEase(ease)} ${effects.joinToString(" ")}"
    }


    class Builder {
        private var type: TransitionType = TransitionType.ALL
        private var duration: String = "150"
        private var ease: TransitionEase = TransitionEase.EASE
        private val effects: MutableList<String> = mutableListOf()

        fun applyTransitionType(type: TransitionType) = apply { this.type = type }
        fun applyDuration(duration: String) = apply { this.duration = duration }
        fun applyEase(ease: TransitionEase) = apply { this.ease = ease }
        fun applyEffect(effect: String) = apply { effects.add(effect) }

        fun build(): String {
            return Transition(type, duration, ease, effects).toString()
        }
    }

    companion object {
        fun builder() = Builder()
    }

}

enum class TransitionType(val value: String) {
    NONE("transition none"),
    ALL("transition all"),
    COLORS("transition colors"),
    OPACITY("transition opacity"),
    SHADOW("transition shadow"),
    TRANSFORM("transition transform")
}

enum class TransitionEase(private val value: String) {
    EASE("ease"),
    LINEAR("linear"),
    EASE_IN("ease-in"),
    EASE_OUT("ease-out"),
    EASE_IN_OUT("ease-in-out");

    override fun toString(): String = value
}

private fun transitionDuration(value: String): String = "duration-$value"
private fun transitionEase(ease: TransitionEase): String = "ease-$ease"

typealias Transform1 = (String) -> String
typealias Transform2 = (String, String) -> String
typealias Transform3 = (String, String, String) -> String

fun hover1(transform: Transform1): String = "hover:${transform("")}"
fun focus1(transform: Transform1): String = "focus: $transform"
fun active1(transform: Transform1): String = "active: $transform"
fun checked1(transform: Transform1): String = "checked: $transform"
fun valid1(transform: Transform1): String = "valid: $transform"
fun invalid1(transform: Transform1): String = "invalid: $transform"
fun target1(transform: Transform1): String = "target: $transform"
fun enabled1(transform: Transform1): String = "enabled: $transform"
fun disabled1(transform: Transform1): String = "disabled: $transform"

fun translate(x: String, y: String): String = "translate-$x translate-$y"
fun translateX(x: String): String = "translate-x-$x"
fun translateY(y: String): String = "translate-y-$y"
fun scale(x: String, y: String): String = "scale-$x scale-$y"
fun scale(factor : String) : String = "scale-$factor"
fun scaleX(x: String): String = "scale-x-$x"
fun scaleY(y: String): String = "scale-y-$y"
fun rotate(angle: String): String = "rotate-$angle"
fun skew(x: String, y: String): String = "skew-$x skew-$y"
fun skewX(x: String): String = "skew-x-$x"
fun skewY(y: String): String = "skew-y-$y"
fun perspective(p: String): String = "perspective($p)"
fun rotateX(angle: String): String = "rotateX($angle)"
fun rotateY(angle: String): String = "rotateY($angle)"
fun rotateZ(angle: String): String = "rotateZ($angle)"
fun scale3d(x: String, y: String, z: String): String = "scale3d($x, $y, $z)"
fun scaleZ(z: String): String = "scaleZ($z)"
fun translate3d(x: String, y: String, z: String): String = "translate3d($x, $y, $z)"
fun translateZ(z: String): String = "translateZ($z)"

