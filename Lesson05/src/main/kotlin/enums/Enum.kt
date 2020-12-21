package enums

enum class GalleryTag(val value : String) {
    PORTRAIT("Портрет"),
    NATURE("Пейзаж"),
    LEGEND("Сказка"),
    BIBLE("Библейский сюжет"),
    SCENE("Сцена")
}

data class GalleryScreen(
        val titleRes : Int,
        val colorRes : Int,
        val imageRes : Int,
        val tags : List<GalleryTag>
)

val screens : List<GalleryScreen> = listOf(
        GalleryScreen(
                1,1,1,
                listOf(GalleryTag.PORTRAIT)
        ),
        GalleryScreen(
                2, 2, 2,
                listOf(GalleryTag.PORTRAIT, GalleryTag.LEGEND)
        ),
        GalleryScreen(
                3, 3, 3,
                listOf(GalleryTag.PORTRAIT)
        ),
        GalleryScreen(
                4, 4, 4,
                listOf(GalleryTag.NATURE)
        ),
        GalleryScreen(
                5, 5, 5,
                listOf(GalleryTag.NATURE)
        ),
        GalleryScreen(
                6, 6, 6,
                listOf(GalleryTag.NATURE)
        ),
        GalleryScreen(
                7,7, 7,
                listOf(GalleryTag.LEGEND, GalleryTag.NATURE)
        ),
        GalleryScreen(
                8, 8, 8,
                listOf(GalleryTag.BIBLE, GalleryTag.SCENE)
        ),
        GalleryScreen(
                9, 9, 9,
                listOf(GalleryTag.SCENE, GalleryTag.NATURE)
        ),
        GalleryScreen(
               10, 10, 10,
                listOf(GalleryTag.SCENE)
        ),
        GalleryScreen(
                11, 11, 11,
                listOf(GalleryTag.SCENE)
       )

)


fun main() {

    /*val cats: Array<String> = Array(GalleryTag.values().size) {
        index -> GalleryTag.values()[index].value
    }

    val chItems = BooleanArray(GalleryTag.values().size) { i -> i % 2 == 0}

    chItems.forEach { println(it) }

    println(GalleryTag.values().filterIndexed { index, galleryTag -> chItems[index] })

    val filtered =  screens.filter { gs -> gs.tags.intersect(
            GalleryTag.values().filterIndexed { index, galleryTag -> chItems[index] }
    ).isNotEmpty()}
    filtered.forEach { println("${it.titleRes} ${it.tags}") } */

    val color : UInt = 0u
    println(color.inv())

    /*val  f = screens[1].tags.toSet()
            .intersect(GalleryTag.values()
                    .filterIndexed { index, galleryTag -> chItems[index]}.toSet())
    f.forEach { println(it.name) }
    println(f.size)*/
}