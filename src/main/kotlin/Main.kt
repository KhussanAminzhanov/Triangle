import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

data class Dot(var x: Int, var y: Int)

class Triangle(private val first: Dot, private val second: Dot, private val third: Dot) {

    init {
        if (first.x == second.x && second.x == third.x || first.y == second.y && second.y == third.y) {
            throw IllegalArgumentException()
        }
    }

    val perimeter: Double
        get() = getDistanceFromTwoDots(first, second) +
                getDistanceFromTwoDots(second, third) +
                getDistanceFromTwoDots(third, first)

    val area: Double
        get() = abs(0.5 * (first.x * (second.y-third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    fun print() {
        println("First dot: x = ${first.x}, y = ${first.y}")
        println("Second dot: x = ${second.x}, y = ${second.y}")
        println("Third dot: x = ${third.x}, y = ${third.y}")
    }

    private fun getDistanceFromTwoDots(first: Dot, second: Dot) : Double {
        return sqrt((second.x - first.x).toDouble().pow(2) + (second.y - first.y).toDouble().pow(2))
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    val first = Dot(scanner.nextInt(), scanner.nextInt())
    val second = Dot(scanner.nextInt(), scanner.nextInt())
    val third = Dot(scanner.nextInt(), scanner.nextInt())

    val triangle = Triangle(first, second, third)

    triangle.print()

    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")
}