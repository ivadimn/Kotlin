import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import strings.allMatchesOf

class TestStringMatches {
    @Test
    fun testExctensionFunction() {
        assertIterableEquals(listOf("<html>", "<head>"),
        "<html><head>Hello".allMatchesOf("""<[a-zA-Z0-1/^>]+>"""))
    }
}