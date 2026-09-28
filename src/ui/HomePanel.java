/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {

    private JLabel statusLabel;

    public HomePanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(
                BorderFactory.createEmptyBorder(
                        50, 50, 50, 50
                )
        );

        JLabel title = new JLabel(
                "Reach Files"
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        JLabel description = new JLabel(
                "<html><center>"
                + "Retrouvez rapidement n'importe quel fichier "
                + "sur votre ordinateur.<br><br>"
                + "File Organizer analyse automatiquement les fichiers "
                + "accessibles<br>"
                + "et les classe par catégorie."
                + "</center></html>"
        );

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17
                )
        );

        description.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        statusLabel = new JLabel(
                "Analyse automatique de l'ordinateur..."
        );

        statusLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        statusLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        add(
                title,
                BorderLayout.NORTH
        );

        add(
                description,
                BorderLayout.CENTER
        );

        add(
                statusLabel,
                BorderLayout.SOUTH
        );
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }
}
