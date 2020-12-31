package components

import StringListener
import java.awt.Color
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JPanel

class Toolbar(
    var listener: StringListener? = null
) : JPanel(), ActionListener {

    private lateinit var newButton : JButton
    private lateinit var openButton : JButton
    private lateinit var saveButton : JButton

    init {
        newButton = JButton("New")
        openButton = JButton("Open")
        saveButton = JButton("Save")
        newButton.addActionListener(this)
        openButton.addActionListener(this)
        saveButton.addActionListener(this)
        background = Color(100, 100, 100)

        layout = FlowLayout(FlowLayout.LEFT)
        add(newButton)
        add(openButton)
        add(saveButton)
    }

    override fun actionPerformed(e: ActionEvent?) {
        when(e?.source) {
            newButton -> listener?.textEmmited("New Button\n")
            openButton -> listener?.textEmmited("Open button\n")
            saveButton -> listener?.textEmmited("Save button\n")
        }
    }
}