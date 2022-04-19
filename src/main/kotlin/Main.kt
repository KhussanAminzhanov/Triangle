import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class Vector(var x: Double, var y: Double)

class Triangle(var first: Vector, var second: Vector, var third: Vector) {

    init {
        if (isCollinear()) throw java.lang.IllegalArgumentException()
    }

    private var lengthA = getDistance(first, second)
    private var lengthB = getDistance(second, third)
    private var lengthC = getDistance(first, third)

    val perimeter: Double
        get() = ((lengthA + lengthB + lengthC) * 100).roundToInt() / 100.0

    val area: Double
        get() = abs(0.5 * (first.x * (second.y - third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    private fun getDistance(first: Vector, second: Vector): Double {
        return sqrt((second.x - first.x).pow(2) + (second.y - first.y).pow(2))
    }

    private fun isCollinear(): Boolean {
        if (getSlope(first, second) == getSlope(second, third) && getSlope(first, second) == getSlope(second, third)) {
            return true
        }
//        } else if (lengthA + lengthB == lengthC || lengthC + lengthB == lengthA || lengthA + lengthC == lengthB) {
//            return true
//        }
        return false
    }

    private fun getSlope(vectorOne: Vector, vectorTwo: Vector): Double {
        return (vectorTwo.x - vectorOne.x) / (vectorTwo.y - vectorOne.y)
    }

    override fun toString(): String {
        return "First vector: x = ${first.x}, y = ${first.y}\n" +
                "Second vector: x = ${second.x}, y = ${second.y}\n" +
                "Third vector: x = ${third.x}, y = ${third.y}"
    }
}

fun main() {
    val triangle = Triangle(Vector(1.0, 1.0), Vector(2.0, 2.0), Vector(4.0, 6.0))

    println(triangle)
    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")
}