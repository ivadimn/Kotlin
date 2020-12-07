package calculator

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    init {
        println("init")
    }
    @BeforeAll
    fun prepare() {
        println("prepare")
    }

    @BeforeEach
    fun prepareTest() {
        println("prepare test")
    }

    @AfterAll
    fun tearDown() {
        println("tear down")
    }

    @AfterEach
    fun tearTest() {
        println("tear test")
    }


    @Test
    @DisplayName("Calculator add test")
    fun calcAdd() {
        println("calcAdd")
        val calculator = Calculator(15)
        calculator.add(2)
        assertEquals(17, calculator.get(), "15 + 2 should give 17")
    }
    @Test
    fun calcMul() {
        println("calcMul")
        val calculator = Calculator(25)
        calculator.mul(2)
        assertEquals(50, calculator.get(), "50 * 2 should give 50")
    }

    @ParameterizedTest
    @CsvSource(
        "0, 1, 1",
        "10, 5, 15",
        "1, 100, 101"
    )
    fun paraAdd(f: Int, s : Int, r : Int) {
        println("paraTest")
        val calculator = Calculator(f)
        calculator.add(s)
        assertEquals(r, calculator.get(), "$f + $s should give $r")
    }

    fun data() : Stream<Arguments> = Stream.of(
        Arguments.of(0, 5, 0),
        Arguments.of(1, 3, 3),
        Arguments.of(12, 6, 72),
        Arguments.of(3, 6, 18),
    )

    @ParameterizedTest
    @MethodSource("data")
    fun paraMul(f: Int, s : Int, r : Int) {
        println("paraTest mul")
        val calculator = Calculator(f)
        calculator.mul(s)
        assertEquals(r, calculator.get(), "$f * $s should give $r")
    }

    @Test
    fun divisionByZeroException() {
        println("calc div zero")
        val calculator = Calculator(15)
        val exception = assertThrows<AssertionError> {
            calculator.div(0)
        }
        assertEquals("Divizion by zero", exception.message)
    }

    @Test
    fun combineAddAndMul() {
        val calculator = Calculator(15)
        assertAll("Проверка сложения и умножения",
                {
                    assertEquals(15, calculator.get())
                },
                {
                    calculator.add(2)
                    assertEquals(17, calculator.get())
                },
                {
                    calculator.mul(3)
                    assertEquals(51, calculator.get())
                }
        )
    }
}