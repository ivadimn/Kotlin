package ui

import model.PDFPage
import java.awt.Component
import javax.swing.DefaultListCellRenderer
import javax.swing.JList

class BigImageCellRenderer : DefaultListCellRenderer() {
    private lateinit var panel : BigImagePanel
    override fun getListCellRendererComponent(
        list: JList<*>?,
        value: Any?,
        index: Int,
        isSelected: Boolean,
        cellHasFocus: Boolean
    ): Component {
        if (value is PDFPage) {
            panel = BigImagePanel(value.image)
            return panel
        }
        else {
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
        }
    }
}