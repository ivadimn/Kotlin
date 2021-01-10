package ui

import controller.Controller
import listeners.PageListener
import listeners.SelectListener
import model.PDFDocument
import model.PDFPage
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.image.BufferedImage
import java.io.File
import javax.swing.JFileChooser
import javax.swing.JPanel
import javax.swing.JSplitPane

class TabPdfPanel(
    val key : String
) : JPanel(), SelectListener, PageListener   {


    private lateinit var smallPdfImagesPanel: SmallPdfImagesPanel
    private lateinit var bigPdfImagesPanel: BigPdfImagesPanel
    private lateinit var splitPane : JSplitPane

    init {
        layout = BorderLayout()
        smallPdfImagesPanel = SmallPdfImagesPanel(this)
        smallPdfImagesPanel.preferredSize = Dimension(150, 0)
        smallPdfImagesPanel.setPageListener(this)
        bigPdfImagesPanel = BigPdfImagesPanel(this)
        splitPane = JSplitPane(JSplitPane.HORIZONTAL_SPLIT, smallPdfImagesPanel, bigPdfImagesPanel)
        add(splitPane, BorderLayout.CENTER)
    }

    fun submitDocument(pages : List<PDFPage>) {
        smallPdfImagesPanel.setData(pages)
        bigPdfImagesPanel.setData(pages)
        updateUI()
    }

    override fun selectSmallPage(index: Int) {
        bigPdfImagesPanel.selectPage(index)
    }

    override fun selectBigPage(index: Int) {
        smallPdfImagesPanel.selectPage(index)
    }

    override fun insertPage(index: Int, file: File) {
        Controller.insertPage(key, index, file)
        updatePane()
        smallPdfImagesPanel.selectPage(index)
        bigPdfImagesPanel.selectPage(index)

    }

    override fun deletePage(index: Int) {
        Controller.removePage(key, index)
        updatePane()
    }

    override fun exportPage(index: Int) {
        val image = Controller.getPages(key)[index].image
        val fileChooser = JFileChooser()
        fileChooser.fileFilter = ImageFileFilter()
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            Controller.exportAsImage(image, fileChooser.selectedFile)
        }
    }


    private fun updatePane() {
        smallPdfImagesPanel.refresh()
        bigPdfImagesPanel.refresh()
    }


}