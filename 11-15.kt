data class Product(val name: String, val price: Double, var quantity: Int)

class Store {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(name: String) {
        products.removeIf { it.name == name }
    }

    fun findProduct(name: String): Product? {
        return products.find { it.name == name }
    }
}

interface PaymentSystem {
    fun pay(amount: Double)
    fun refund(amount: Double)
}

internal class CreditCard : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using Credit Card")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount using Credit Card")
    }
}

class PayPal : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using PayPal")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount using PayPal")
    }
}

class UniqueID {
    companion object {
        private var counter = 0

        fun getUniqueID(): Int {
            return ++counter
        }
    }
}

data class Point(val x: Int, val y: Int)

class Rectangle(private val topLeft: Point, private val bottomRight: Point) {
    fun calculateArea(): Int {
        val width = bottomRight.x - topLeft.x
        val height = topLeft.y - bottomRight.y
        return width * height
    }
}

data class ComplexNumber(val real: Double, val imaginary: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        val realPart = this.real * other.real - this.imaginary * other.imaginary
        val imaginaryPart = this.real * other.imaginary + this.imaginary * other.real
        return ComplexNumber(realPart, imaginaryPart)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val denominator = other.real * other.real + other.imaginary * other.imaginary
        val realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator
        val imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator
        return ComplexNumber(realPart, imaginaryPart)
    }
}

fun main() {
    // Пример использования классов
    val store = Store()
    val product1 = Product("Apple", 1.0, 10)
    val product2 = Product("Banana", 0.5, 20)
    store.addProduct(product1)
    store.addProduct(product2)
    println(store.findProduct("Apple"))
    store.removeProduct("Banana")
    println(store.findProduct("Banana"))

    val creditCard = CreditCard()
    val payPal = PayPal()
    creditCard.pay(100.0)
    payPal.refund(50.0)

    println(UniqueID.getUniqueID())
    println(UniqueID.getUniqueID())

    val topLeft = Point(0, 10)
    val bottomRight = Point(10, 0)
    val rectangle = Rectangle(topLeft, bottomRight)
    println("Rectangle Area: ${rectangle.calculateArea()}")

    val complex1 = ComplexNumber(1.0, 2.0)
    val complex2 = ComplexNumber(3.0, 4.0)
    val sum = complex1 + complex2
    val difference = complex1 - complex2
    val product = complex1 * complex2
    val quotient = complex1 / complex2
    println("Sum: $sum")
    println("Difference: $difference")
    println("Product: $product")
    println("Quotient: $quotient")
}
