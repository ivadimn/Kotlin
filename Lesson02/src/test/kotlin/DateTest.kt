import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DateTest {
    @Test
    fun dateTest() {
        assertTrue(isDate("05 MAR 2018"))
        assertFalse(isDate("34 MAR 2018"))
    }
}