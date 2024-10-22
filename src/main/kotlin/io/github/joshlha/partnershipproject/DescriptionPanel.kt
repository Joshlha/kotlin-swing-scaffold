package io.github.joshlha.partnershipproject

import net.miginfocom.swing.MigLayout
import java.awt.Font
import javax.swing.JLabel
import javax.swing.JPanel

class DescriptionPanel : JPanel(MigLayout("fill, aligny center")) {

    private val descriptionLabel = JLabel("Default Text").apply {
        font = font.deriveFont(Font.BOLD, 20F)
        horizontalAlignment = JLabel.CENTER
    }

    init {
        add(descriptionLabel, "growx")
    }
}