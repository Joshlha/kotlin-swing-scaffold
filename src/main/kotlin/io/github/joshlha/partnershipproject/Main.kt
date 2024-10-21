package io.github.joshlha.partnershipproject

import com.formdev.flatlaf.FlatDarkLaf
import net.miginfocom.swing.MigLayout
import org.slf4j.LoggerFactory
import java.awt.Color
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

/*
    "Main" is a subclass of JPanel. It gives JPanel's constructor a new MigLayout instance.
    This tells the JPanel to use MigLayout for laying out the components.
    There are many other layouts available in swing, but Mig is most used.
 */
class Main : JPanel(MigLayout("ins 4, fill")) {
    // Initialize a bunch of components
    private val northButton = JButton("North!")
    private val southButton = JButton("South!")
    private val eastButton = JButton("East!")
    private val westButton = JButton("West!")

    private val topLeft = JLabel("Top Left").apply {
        border = BorderFactory.createLineBorder(Color.GREEN)
    }
    private val topMiddle = JLabel("Top Middle").apply {
        border = BorderFactory.createLineBorder(Color.BLUE)
    }
    private val topRight = JLabel("Top Right").apply {
        border = BorderFactory.createLineBorder(Color.RED)
    }

    private var number = 0

    private val labelText: String
        get() = "Click to increment number: $number"

    private val bottom = JButton(labelText).apply {
        border = BorderFactory.createLineBorder(Color.WHITE)
        horizontalAlignment = JButton.CENTER

        addActionListener {
            number += 1
            text = labelText
        }
    }

    init {
        // Add the components to the layout, providing MigLayout constraints for their position
        add(northButton, "north")
        add(southButton, "south")
        add(eastButton, "east")
        add(westButton, "west")
        add(topLeft, "grow")
        add(topMiddle, "grow")
        add(topRight, "grow, wrap")
        add(bottom, "grow, span")
    }

    // A singleton instance object called "Main" because it is the companion to the Main class.
    companion object {
        private val logger = LoggerFactory.getLogger(Main::class.java)

        // This annotation is needed to tell the compiler that this is our java main function.
        @JvmStatic
        fun main(args: Array<String>) {
            FlatDarkLaf.setup() // Setup the Look-and-feel. This gives us a dark mode, modern UI
            logger.info("Showing JFrame!")

            // Create an instance of JFrame and set it visible to show it.
            // A JFrame is effectively just a window.
            // Set the "contentPane" to an instance of the "Main" class, which is a customized JPanel.
            JFrame("Partnership Program").apply {
                contentPane = Main()
                setSize(800, 600)
                setLocationRelativeTo(null) // Centers the JFrame on the screen.
                isVisible = true // false by default.
                defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
                // Disposing one frame removes it and its children from memory.
                // Disposing all frames ends the program.
            }
        }
    }
}
