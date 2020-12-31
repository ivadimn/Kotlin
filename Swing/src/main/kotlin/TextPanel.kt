import java.awt.BorderLayout
import java.awt.ScrollPane
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea

class TextPanel : JPanel() {

    private lateinit var textArea: JTextArea
    init {
        layout = BorderLayout()
        textArea = JTextArea()

        add(JScrollPane(textArea), BorderLayout.CENTER)
    }

    fun appendText(text : String) {
        textArea.append(text)
    }

}