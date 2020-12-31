package ui

import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel

class Toolbar : JPanel() {
    private lateinit var newButton : JButton
    private lateinit var openButton : JButton
    private lateinit var saveButton : JButton

    init {
        newButton = JButton("New")
        openButton = JButton("Open")
        saveButton = JButton("Save")

        layout = FlowLayout(FlowLayout.LEFT)
        add(newButton)
        add(openButton)
        add(saveButton)
    }

}