/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class FieldReachLogo extends JPanel {

    private final Color BLUE =
            new Color(70, 90, 220);

    public FieldReachLogo() {

        setPreferredSize(
                new Dimension(42, 42)
        );

        setMinimumSize(
                new Dimension(42, 42)
        );

        setMaximumSize(
                new Dimension(42, 42)
        );

        setOpaque(false);
    }

    @Override
    protected void paintComponent(
            Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );



        g2.setColor(
                new Color(
                        42,
                        43,
                        65
                )
        );

        g2.fill(
                new RoundRectangle2D.Double(
                        1,
                        1,
                        40,
                        40,
                        13,
                        13
                )
        );



        g2.setColor(Color.WHITE);

        g2.setStroke(
                new BasicStroke(
                        2f
                )
        );

        g2.drawRoundRect(
                10,
                8,
                17,
                22,
                3,
                3
        );



        g2.drawLine(
                21,
                8,
                27,
                14
        );

        g2.drawLine(
                21,
                8,
                21,
                14
        );

        g2.drawLine(
                21,
                14,
                27,
                14
        );



        g2.setColor(
                new Color(
                        190,
                        195,
                        230
                )
        );

        g2.setStroke(
                new BasicStroke(
                        1.5f
                )
        );

        g2.drawLine(
                14,
                19,
                23,
                19
        );

        g2.drawLine(
                14,
                23,
                21,
                23
        );



        g2.setColor(BLUE);

        g2.fillOval(
                22,
                21,
                16,
                16
        );



        g2.setColor(Color.WHITE);

        g2.fillOval(
                27,
                26,
                6,
                6
        );

        g2.dispose();
    }
}