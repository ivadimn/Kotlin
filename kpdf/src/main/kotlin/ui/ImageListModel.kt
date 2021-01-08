package ui

import model.PDFPage
import javax.swing.AbstractListModel

class ImageListModel : AbstractListModel<PDFPage>(){

    private var list : List<PDFPage> = emptyList()

    override fun getSize(): Int =if (list == null) 0 else list.size

    override fun getElementAt(index: Int): PDFPage? = if(index < list.size) list[index] else null

    fun setData(list: List<PDFPage>) {
        this.list = list
    }
}