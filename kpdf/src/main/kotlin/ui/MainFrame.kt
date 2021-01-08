package ui

import controller.Controller
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*

class MainFrame : JFrame() {

    private val fileChooser : JFileChooser = JFileChooser()
    private val toolbar: Toolbar
    private val tabPane : JTabbedPane


    //private val smallImageListPanel : SmallPdfImagesPanel
    //private val bigImageListPanel : BigPdfImagesPanel


    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(900, 700)
        title = "PDF Manager"
        tabPane = JTabbedPane()

        toolbar = Toolbar()

        //smallImageListPanel = SmallPdfImagesPanel()
        //smallImageListPanel.preferredSize = Dimension(180, 0)
        //bigImageListPanel = BigPdfImagesPanel()
        jMenuBar = createMenuBar()
        layout = BorderLayout()
        add(toolbar, BorderLayout.NORTH)
        add(tabPane, BorderLayout.CENTER)
        //add(smallImageListPanel, BorderLayout.WEST)
        //add(bigImageListPanel, BorderLayout.CENTER)
        setLocationMain()
        isResizable = true
        isVisible = true
    }

    private fun setLocationMain() {
        val screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        val width = screenSize.getWidth();
        val height = screenSize.getHeight();
        location = Point((width / 4).toInt(), (height / 4).toInt())
    }

    private fun createMenuBar() : JMenuBar{
        val menuBar : JMenuBar = JMenuBar()
        val fileMenu = JMenu("Файл")
        val viewMenu = JMenu("Вид")
        val openFileItem = JMenuItem("Открыть...")
        val saveFileItem = JMenuItem("Сохранить")
        val saveAsFileItem = JMenuItem("Сохранить как...")
        val exitItem = JMenuItem("Выход")


        fileMenu.add(openFileItem)
        fileMenu.addSeparator()
        fileMenu.add(saveFileItem)
        fileMenu.add(saveAsFileItem)
        fileMenu.addSeparator()
        fileMenu.add(exitItem)


        menuBar.add(fileMenu)
        menuBar.add(viewMenu)

        fileMenu.setMnemonic(KeyEvent.VK_F)
        exitItem.setMnemonic(KeyEvent.VK_X)
        exitItem.accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)

        openFileItem.addActionListener {
            fileChooser.fileFilter = PdfFileFilter()
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                val key = fileChooser.selectedFile.absolutePath
                Controller.openDocument(fileChooser.selectedFile.absolutePath, key)
                val tabPdfPanel = TabPdfPanel(key)
                tabPdfPanel.submitDocument(Controller.getPages(key))
                tabPane.add(fileChooser.selectedFile.name, tabPdfPanel)
            }
        }

        saveFileItem.addActionListener {
            val key = (tabPane.selectedComponent as TabPdfPanel).key
            Controller.save(key)
        }

        exitItem.addActionListener {
            System.exit(0)
        }
        return menuBar
    }
}