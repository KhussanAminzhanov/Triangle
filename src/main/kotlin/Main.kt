import java.util.Scanner
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

val scanner = Scanner(System.`in`)

data class Vector(var x: Int, var y: Int)

class Triangle() {

    private var first: Vector
    private var second: Vector
    private var third: Vector

    val perimeter: Double
        get() = getDistanceFromTwoDots(first, second) +
                getDistanceFromTwoDots(second, third) +
                getDistanceFromTwoDots(third, first)

    val area: Double
        get() = abs(0.5 * (first.x * (second.y - third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    init {
        first = getCoordinates("first")
        second = getCoordinates("second")
        third = getCoordinates("third")
    }

    private fun getCoordinates(message: String): Vector {
        print("Enter coordinates for ${message.trim().lowercase()} vector: ")
        var vector = Vector(scanner.nextInt(), scanner.nextInt())
        when (message) {
            "second" -> {
                while (isEqual(vector, first)) {
                    print("Coordinates of the vector must be unique: ")
                    vector = Vector(scanner.nextInt(), scanner.nextInt())
                }
            }
            "third" -> {
                while (isEqual(vector, first) || isEqual(vector, second)) {
                    print("Coordinates of the vector must be unique: ")
                    vector = Vector(scanner.nextInt(), scanner.nextInt())
                }
            }
        }
        return vector
    }

    private fun getDistanceFromTwoDots(first: Vector, second: Vector): Double {
        return sqrt((second.x - first.x).toDouble().pow(2) + (second.y - first.y).toDouble().pow(2))
    }

    private fun isCollinear(): Boolean {
        return first.x == second.x && second.x == third.x || first.y == second.y && second.y == third.y
    }

    private fun isEqual(vectorOne: Vector, vectorTwo: Vector): Boolean {
        return vectorOne.x == vectorTwo.x && vectorOne.y == vectorTwo.y
    }

    override fun toString(): String {
        return "First vector: x = ${first.x}, y = ${first.y}\n" +
                "Second vector: x = ${second.x}, y = ${second.y}\n" +
                "Third vector: x = ${third.x}, y = ${third.y}"
    }
}

fun main() {
    val triangle = Triangle()

    println(triangle)
    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")

    scanner.close()
}