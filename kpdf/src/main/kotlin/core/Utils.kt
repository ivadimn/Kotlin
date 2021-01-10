package core

import java.io.File
import java.nio.file.FileSystems

fun getFileExtension(fileName : String) : String? {
    val pointIndex = fileName.lastIndexOf(".")
    if (pointIndex == -1 || pointIndex == fileName.lastIndex) {
        return null
    }
    return fileName.substring(pointIndex + 1, fileName.length )
}

fun getFileClearName(fileName : String) : String? {
    val pointIndex = fileName.lastIndexOf(".")
    if (pointIndex == -1 || pointIndex == fileName.lastIndex) {
        return fileName
    }
    return fileName.substring(0, pointIndex)
}

fun createIndexedFileName(index : Int, file : File) : String {
    return "${file.toPath().parent.toString()}${FileSystems.getDefault().separator}${getFileClearName(file.name)}" +
            "-${index}.${getFileExtension(file.name) ?: "png"}"
}