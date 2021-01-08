package ui

import core.getFileExtension
import java.io.File
import javax.swing.filechooser.FileFilter

class PdfFileFilter : FileFilter() {
    override fun accept(f: File?): Boolean {
        if (f?.isDirectory as Boolean) {
            return true
        }
        val fileName = f?.name ?: ""
        val ext = getFileExtension(fileName)
        if (ext.equals("pdf", ignoreCase=true ))
            return true

        return false
    }

    override fun getDescription(): String {
        return "Adobe PDF files (*.pdf)"
    }
}