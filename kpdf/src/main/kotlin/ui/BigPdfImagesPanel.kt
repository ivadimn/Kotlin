package ui

import listeners.SelectListener
import model.PDFPage
import java.awt.BorderLayout
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener

class BigPdfImagesPanel(
    val selectListener : SelectListener
) : JPanel() {

    private val imageList : JList<PDFPage>
    private val listModel : ImageListModel

    init {
        layout = BorderLayout()
        listModel = ImageListModel()
        imageList = JList(listModel)
        imageList.setCellRenderer(BigImageCellRenderer())
        add(JScrollPane(imageList), BorderLayout.CENTER)
        imageList.addListSelectionListener(object : ListSelectionListener {
            override fun valueChanged(e: ListSelectionEvent?) {
                selectListener.selectBigPage(imageList.selectedIndex)
            }

        })
    }
    fun setData(pages : List<PDFPage>?) {
        listModel.setData(pages ?: emptyList())
        refresh()
    }

    fun refresh() {
        imageList.updateUI()
    }

    fun selectPage(index : Int) {
        imageList.ensureIndexIsVisible(index)
        //refresh()
    }

}