package ui

import java.awt.BorderLayout
import javax.swing.JFileChooser
import javax.swing.JFrame

class MainFrame : JFrame() {

    private val fileChooser : JFileChooser = JFileChooser()


    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(900, 700)
        title = "PDF Manager"
        setLocationRelativeTo(null)
        layout = BorderLayout()
        isResizable = true
        isVisible = true
    }
}