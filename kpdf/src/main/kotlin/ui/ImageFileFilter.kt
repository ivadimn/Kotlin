package ui

import core.getFileExtension
import java.io.File
import javax.swing.filechooser.FileFilter

class ImageFileFilter : FileFilter() {

    private val extensions = listOf("jpg", "png", "tiff", "bmp", "jpeg", "tif")

    override fun accept(f: File?): Boolean {
        if (f?.isDirectory as Boolean) {
            return true
        }
        val fileName = f?.name ?: ""
        val ext = getFileExtension(fileName)
        if (ext in extensions)
            return true

        return false
    }

    override fun getDescription(): String {
        return "Image files (*.jpg, *.png, *.bmp)"
    }

}
