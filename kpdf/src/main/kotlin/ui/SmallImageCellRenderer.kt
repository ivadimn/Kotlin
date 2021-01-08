package ui

import model.PDFPage
import java.awt.Component
import javax.swing.DefaultListCellRenderer
import javax.swing.JList

class SmallImageCellRenderer : DefaultListCellRenderer() {
    private lateinit var panel : SmallImagePanel
    override fun getListCellRendererComponent(
        list: JList<*>?,
        value: Any?,
        index: Int,
        isSelected: Boolean,
        cellHasFocus: Boolean
    ): Component {
        if (value is PDFPage) {
            panel = SmallImagePanel(value.image)
            panel.isFocused = isSelected
            return panel
        }
        else {
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
        }
    }
}