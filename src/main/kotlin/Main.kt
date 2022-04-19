import java.util.Scanner
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

data class Dot(var x: Int, var y: Int)

class Triangle() {

    private var first: Dot
    private var second: Dot
    private var third: Dot

    val perimeter: Double
        get() = getDistanceFromTwoDots(first, second) +
                getDistanceFromTwoDots(second, third) +
                getDistanceFromTwoDots(third, first)

    val area: Double
        get() = abs(0.5 * (first.x * (second.y-third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    init {
        val scanner = Scanner(System.`in`)

        println("Enter first coordinates:")
        first = Dot(scanner.nextInt(), scanner.nextInt())

        println("Enter second coordinates:")
        second = Dot(scanner.nextInt(), scanner.nextInt())

        println("Enter third coordinates:")
        third = Dot(scanner.nextInt(), scanner.nextInt())

        while (isCollinear()) {
            println("Vectors cannot be collinear. Enter third coordinates again:")
            third = Dot(scanner.nextInt(), scanner.nextInt())
        }

        scanner.close()
    }

    fun print() {
        println("First dot: x = ${first.x}, y = ${first.y}")
        println("Second dot: x = ${second.x}, y = ${second.y}")
        println("Third dot: x = ${third.x}, y = ${third.y}")
    }

    private fun getDistanceFromTwoDots(first: Dot, second: Dot) : Double {
        return sqrt((second.x - first.x).toDouble().pow(2) + (second.y - first.y).toDouble().pow(2))
    }

    private fun isCollinear(): Boolean {
        return first.x == second.x && second.x == third.x || first.y == second.y && second.y == third.y
    }
}

fun main() {
    val triangle = Triangle()

    triangle.print()

    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")
}