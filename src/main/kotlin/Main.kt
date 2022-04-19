import kotlin.math.*

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

    val perimeter: Double
        get() = ((getDistance(first, second) + getDistance(second, third) + getDistance(first, third)) * 100).roundToInt() / 100.0

    val area: Double
        get() = abs(0.5 * (first.x * (second.y - third.y) + second.x * (third.y - first.y) + third.x * (first.y - second.y)))

    val center: Vector
        get() = Vector((first.x + second.x + third.x) / 3, (first.y + second.y + third.y) / 3)

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

    fun rotate(a: Double) {
        val angle = Math.toRadians(a)
        val x1 = first.x
        val x2 = second.x
        val x3 = third.x
        val y1 = first.y
        val y2 = second.y
        val y3 = third.y
        val centerX = center.x
        val centerY = center.y

        val x1r = ((x1 - centerX) * cos(angle) - (y1 - centerY) * sin(angle) + centerX)
        val y1r = ((x1 - centerX) * sin(angle) + (y1 - centerY) * cos(angle) + centerY)

        val x2r = ((x2 - centerX) * cos(angle) - (y2 - centerY) * sin(angle) + centerX)
        val y2r = ((x2 - centerX) * sin(angle) + (y2 - centerY) * cos(angle) + centerY)

        val x3r = ((x3 - centerX) * cos(angle) - (y3 - centerY) * sin(angle) + centerX)
        val y3r = ((x3 - centerX) * sin(angle) + (y3 - centerY) * cos(angle) + centerY)

        first = Vector(x1r, y1r)
        second = Vector(x2r, y2r)
        third = Vector(x3r, y3r)
    }

    override fun toString(): String {
        return "First vector: x = ${first.x}, y = ${first.y}\n" +
                "Second vector: x = ${second.x}, y = ${second.y}\n" +
                "Third vector: x = ${third.x}, y = ${third.y}"
    }
}

fun main() {
    val triangle = Triangle(Vector(1.0, 1.0), Vector(1.0, 3.0), Vector(3.0, 1.0))

    println(triangle)
    println("Perimeter: ${triangle.perimeter}")
    println("Area: ${triangle.area}")
    println("Center: ${triangle.center}")

    //triangle.rotate(90.0)

    //println(triangle)

//    triangle.second = Vector(-2.0, 7.0)
}