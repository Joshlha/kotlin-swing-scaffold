package io.github.joshlha.partnershipproject

import net.miginfocom.swing.MigLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JPanel

class GameMenu : JPanel(MigLayout("flowy, alignx center, aligny center, gap 50")) {

    private val buttonFont = font.deriveFont(Font.BOLD, 20F)

    // Step 1: Initialize all data and components
    val newGameButton = JButton("New Game")
    val loadButton = JButton("Load Game")
    val optionsButton = JButton("Options")
    val exitButton = JButton("Exit")

    // Step 2; Add all the components to the layout
    init {
        listOf(newGameButton, loadButton, optionsButton, exitButton).forEach {
            it.font = buttonFont
        }

        add(newGameButton, "sg")
        add(loadButton, "sg")
        add(optionsButton, "sg")
        add(exitButton, "sg")
    }

    // Step 3: Set up event listeners for your components

}