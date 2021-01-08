package core

fun getFileExtension(fileName : String) : String? {
    val pointIndex = fileName.lastIndexOf(".")
    if (pointIndex == -1 || pointIndex == fileName.lastIndex) {
        return null
    }
    return fileName.substring(pointIndex + 1, fileName.length )
}