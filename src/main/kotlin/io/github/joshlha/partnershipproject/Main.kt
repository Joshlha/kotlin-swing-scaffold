package io.github.joshlha.partnershipproject

import com.formdev.flatlaf.FlatDarkLaf
import net.miginfocom.swing.MigLayout
import org.slf4j.LoggerFactory
import java.awt.Color
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class Main : JPanel(MigLayout("ins 4, fill")) {

    private val titleLabel = JLabel(TITLE, JLabel.CENTER).apply {
        font = font.deriveFont(Font.BOLD, 30F)
    }

    private val gameMenu = GameMenu()
    private val descriptionPanel = DescriptionPanel()

    init {
        add(titleLabel, "north")
        add(gameMenu, "grow")
        add(descriptionPanel, "grow")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Main::class.java)

        const val TITLE = "Elder Scrolls VI"

        @JvmStatic
        fun main(args: Array<String>) {
            FlatDarkLaf.setup()
            logger.info("Starting Game: $TITLE")
            JFrame(TITLE).apply {
                contentPane = Main()
                setSize(800, 600)
                setLocationRelativeTo(null)
                isVisible = true
                defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
            }
        }
    }
}
