package ui

import listeners.PageListener
import listeners.SelectListener
import model.PDFPage
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener

class SmallPdfImagesPanel(
    val selectListener: SelectListener
): JPanel() {

    val fileChooser = JFileChooser()
    private val imageList : JList<PDFPage>
    private val listModel : ImageListModel
    private val popup : JPopupMenu

    private var pageListener: PageListener? = null

    init {
        layout = BorderLayout()
        listModel = ImageListModel()
        imageList = JList(listModel)
        //imageList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //imageList.setLayoutOrientation(JList.VERTICAL_WRAP);
        imageList.setCellRenderer(SmallImageCellRenderer())
        add(JScrollPane(imageList), BorderLayout.CENTER)
        imageList.addListSelectionListener(object : ListSelectionListener {
            override fun valueChanged(e: ListSelectionEvent?) {
                selectListener.selectSmallPage(imageList.selectedIndex)
            }

        })

        popup = JPopupMenu()
        initPopupMenu()
    }

    fun setPageListener(listener: PageListener) {
        pageListener = listener
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
    }

    fun initPopupMenu() {
        val insertItem = JMenuItem("Вставить страницу...")
        val deleteItem = JMenuItem("Удалить страницу")
        val exportItem = JMenuItem("Сохранить как изображение")

        insertItem.addActionListener {
            insertPage()
        }
        deleteItem.addActionListener {
            removePage()
        }

        exportItem.addActionListener {
            exportPage()
        }
        popup.add(insertItem)
        popup.add(deleteItem)
        popup.addSeparator()
        popup.add(exportItem)

        imageList.addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent?) {
                if (e!!.button == MouseEvent.BUTTON3) {
                    popup.show(imageList, e.x, e.y)
                }
            }
        })
    }

    private fun insertPage() {
        fileChooser.fileFilter = ImageFileFilter()
        val index = imageList.selectedIndex + 1
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            pageListener?.insertPage(index, fileChooser.selectedFile)
        }
    }

    private fun removePage() {
        val index = imageList.selectedIndex
        if (index >= 0)
            pageListener?.deletePage(index)
    }

    private fun exportPage() {
        val index = imageList.selectedIndex
        if (index >= 0)
            pageListener?.exportPage(index)
    }


}