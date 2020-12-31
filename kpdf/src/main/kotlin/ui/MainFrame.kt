package ui

import java.awt.BorderLayout
import javax.swing.JFileChooser
import javax.swing.JFrame

class MainFrame : JFrame() {

    private val fileChooser : JFileChooser = JFileChooser()
    private lateinit var toolbar: Toolbar

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(900, 700)
        title = "PDF Manager"
        //setLocationRelativeTo(null)
        initUI()
        layout = BorderLayout()
        add(toolbar, BorderLayout.NORTH)
        isResizable = true
        isVisible = true
    }

    private fun initUI() {
        toolbar = Toolbar()
    }
}