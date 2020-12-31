import components.Toolbar
import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFrame
import java.awt.Dimension
import java.awt.Toolkit


class MainFrame : JFrame("Swing Applucation") {

    private lateinit var textPanel: TextPanel
    private lateinit var button : JButton
    private lateinit var toolbar : Toolbar


    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        val screenSize = getScreenSize()
        setSize(screenSize.width / 2, screenSize.height / 2)
        layout = BorderLayout()
        initUI()
        add(textPanel, BorderLayout.CENTER)
        add(button, BorderLayout.SOUTH)
        add(toolbar, BorderLayout.NORTH)
        isVisible = true

    }

    private fun getScreenSize() : Dimension =
       Toolkit.getDefaultToolkit().getScreenSize()

    private fun initUI() {
        textPanel = TextPanel()
        button = JButton("Click me")
        button.addActionListener { ae ->
            textPanel.appendText("Button clicked!!!\n")
        }
        toolbar = Toolbar(object : StringListener {
            override fun textEmmited(text: String) {
                textPanel.appendText(text)
            }

        } )
    }
}