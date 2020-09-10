import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestSalary {

    @Test
    fun testSalary() {
       Assertions.assertEquals(80000.toBigDecimal(), japaneseSalary(50000.toBigDecimal(), 3))
    }

    @Test
    fun testNegativeSalary() {
        val th = assertThrows<IllegalArgumentException> {
            japaneseSalary((-10).toBigDecimal(), 12)
        }

    }

}