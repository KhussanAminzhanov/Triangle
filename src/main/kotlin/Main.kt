import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class Vector(var x: Double, var y: Double)

class Triangle(first: Vector, second: Vector, third: Vector) {

    var first: Vector = first
        set(vector) {
            field = vector
            throwExceptionIfCollinear()
        }

    var second: Vector = second
        set(vector) {
            field = vector
            throwExceptionIfCollinear()
        }

    var third: Vector = third
        set(vector) {
            field = vector
            throwExceptionIfCollinear()
        }

    private var lengthA = getDistance(first, second)
    private var lengthB = getDistance(second, third)
    private var lengthC = getDistance(first, third)

    val perimeter: Double
        get() = ((lengthA + lengthB + lengthC) * 100).roundToInt() / 100.0

    val area: Double
        get() = abs(0.5 * (first.x * (second.y - third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    init {
        if (isCollinear()) throwExceptionIfCollinear()
    }

    private fun getDistance(first: Vector, second: Vector): Double {
        return sqrt((second.x - first.x).pow(2) + (second.y - first.y).pow(2))
    }

    private fun isCollinear(): Boolean {
        return area == 0.0
    }

    private fun throwExceptionIfCollinear() {
        if (isCollinear()) throw java.lang.IllegalArgumentException()
    }

    override fun toString(): String {
        return "First vector: x = ${first.x}, y = ${first.y}\n" +
                "Second vector: x = ${second.x}, y = ${second.y}\n" +
                "Third vector: x = ${third.x}, y = ${third.y}"
    }
}

fun main() {
    val triangle = Triangle(Vector(-2.0, 7.0), Vector(1.0, 1.0), Vector(-3.0, 3.0))

    println(triangle)
    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")

    triangle.second = Vector(-2.0, 7.0)
}