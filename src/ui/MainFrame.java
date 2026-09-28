/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import model.FileItem;
import service.FileCategorizer;
import service.FileScanner;

public class MainFrame extends JFrame {

    private JPanel sidebar;
    private JPanel contentPanel;
    private FilePanel filePanel;

    private JLabel statusLabel;
    private JProgressBar progressBar;

    private JLabel allCountLabel;
    private JLabel musicCountLabel;
    private JLabel videoCountLabel;
    private JLabel documentsCountLabel;
    private JLabel imagesCountLabel;
    private JLabel otherCountLabel;

    private final Map<String, Integer> categoryCounts =
            new HashMap<>();

    private final Color SIDEBAR_COLOR =
            Color.decode("#CFD9DF");

    private final Color BACKGROUND_COLOR =
            Color.decode("#E2EBF0");

    private final Color TEXT_COLOR =
            Color.decode("#263238");

    private final Color SECONDARY_TEXT =
            Color.decode("#607078");

    private final Color BUTTON_BORDER =
            Color.decode("#B8C6CE");

    private final Color HOVER_COLOR =
            Color.decode("#B8C6CE");

    private final Color HOVER_BORDER =
            Color.decode("#607078");

    public MainFrame() {

        initComponents();

        scanComputer();
    }

    private void initComponents() {

        setTitle(
                "FieldReach"
        );

        setSize(
                1250,
                780
        );

        setMinimumSize(
                new Dimension(
                        1050,
                        650
                )
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(
                new BorderLayout()
        );

        getContentPane().setBackground(
                BACKGROUND_COLOR
        );

        initializeCounters();

        createSidebar();

        contentPanel =
                new JPanel(
                        new BorderLayout()
                );

        contentPanel.setBackground(
                BACKGROUND_COLOR
        );

        filePanel =
                new FilePanel();

        contentPanel.add(
                filePanel,
                BorderLayout.CENTER
        );

        createStatusBar();

        add(
                sidebar,
                BorderLayout.WEST
        );

        add(
                contentPanel,
                BorderLayout.CENTER
        );

        add(
                createBottomPanel(),
                BorderLayout.SOUTH
        );
    }

    private void initializeCounters() {

        categoryCounts.put(
                "All",
                0
        );

        categoryCounts.put(
                FileCategorizer.MUSIC,
                0
        );

        categoryCounts.put(
                FileCategorizer.VIDEO,
                0
        );

        categoryCounts.put(
                FileCategorizer.DOCUMENTS,
                0
        );

        categoryCounts.put(
                FileCategorizer.IMAGES,
                0
        );

        categoryCounts.put(
                FileCategorizer.OTHER,
                0
        );
    }

    private void createSidebar() {

        sidebar =
                new JPanel(
                        new GridLayout(
                                8,
                                1,
                                0,
                                8
                        )
                );

        sidebar.setPreferredSize(
                new Dimension(
                        240,
                        780
                )
        );

        sidebar.setBackground(
                SIDEBAR_COLOR
        );

        sidebar.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        15,
                        25,
                        15
                )
        );

        JPanel brandPanel =
                new JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                10,
                                5
                        )
                );

        brandPanel.setOpaque(false);

        FieldReachLogo logo =
                new FieldReachLogo();

        JLabel title =
                new JLabel(
                        "FieldReach"
                );

        title.setForeground(
                TEXT_COLOR
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        brandPanel.add(
                logo
        );

        brandPanel.add(
                title
        );

        sidebar.add(
                brandPanel
        );

        sidebar.add(
                createCategoryButton(
                        "Tous",
                        "All"
                )
        );

        sidebar.add(
                createCategoryButton(
                        "Music",
                        FileCategorizer.MUSIC
                )
        );

        sidebar.add(
                createCategoryButton(
                        "Video",
                        FileCategorizer.VIDEO
                )
        );

        sidebar.add(
                createCategoryButton(
                        "Documents",
                        FileCategorizer.DOCUMENTS
                )
        );

        sidebar.add(
                createCategoryButton(
                        "Images",
                        FileCategorizer.IMAGES
                )
        );

        sidebar.add(
                createCategoryButton(
                        "Other",
                        FileCategorizer.OTHER
                )
        );

        JPanel emptyPanel =
                new JPanel();

        emptyPanel.setOpaque(false);

        sidebar.add(
                emptyPanel
        );
    }

    private JButton createCategoryButton(
            String text,
            String category) {

        JButton button =
                new JButton();

        button.setLayout(
                new BorderLayout()
        );

        button.setFocusPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setContentAreaFilled(
                true
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BUTTON_BORDER,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                11,
                                13,
                                11,
                                13
                        )
                )
        );

        button.setBackground(
                SIDEBAR_COLOR
        );

        button.setForeground(
                TEXT_COLOR
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        JLabel nameLabel =
                new JLabel(
                        text
                );

        nameLabel.setForeground(
                TEXT_COLOR
        );

        nameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        JLabel countLabel =
                new JLabel(
                        "0"
                );

        countLabel.setForeground(
                SECONDARY_TEXT
        );

        countLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        countLabel.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        button.add(
                nameLabel,
                BorderLayout.WEST
        );

        button.add(
                countLabel,
                BorderLayout.EAST
        );

        if (category.equals("All")) {

            allCountLabel =
                    countLabel;

        } else if (
                category.equals(
                        FileCategorizer.MUSIC
                )) {

            musicCountLabel =
                    countLabel;

        } else if (
                category.equals(
                        FileCategorizer.VIDEO
                )) {

            videoCountLabel =
                    countLabel;

        } else if (
                category.equals(
                        FileCategorizer.DOCUMENTS
                )) {

            documentsCountLabel =
                    countLabel;

        } else if (
                category.equals(
                        FileCategorizer.IMAGES
                )) {

            imagesCountLabel =
                    countLabel;

        } else if (
                category.equals(
                        FileCategorizer.OTHER
                )) {

            otherCountLabel =
                    countLabel;
        }

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                HOVER_COLOR
                        );

                        button.setBorder(
                                BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(
                                                HOVER_BORDER,
                                                1
                                        ),
                                        BorderFactory.createEmptyBorder(
                                                11,
                                                13,
                                                11,
                                                13
                                        )
                                )
                        );

                        nameLabel.setForeground(
                                TEXT_COLOR
                        );

                        countLabel.setForeground(
                                TEXT_COLOR
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                SIDEBAR_COLOR
                        );

                        button.setBorder(
                                BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(
                                                BUTTON_BORDER,
                                                1
                                        ),
                                        BorderFactory.createEmptyBorder(
                                                11,
                                                13,
                                                11,
                                                13
                                        )
                                )
                        );

                        nameLabel.setForeground(
                                TEXT_COLOR
                        );

                        countLabel.setForeground(
                                SECONDARY_TEXT
                        );
                    }
                }
        );

        button.addActionListener(
                e ->
                        filePanel.filterByCategory(
                                category
                        )
        );

        return button;
    }

    private void createStatusBar() {

        statusLabel =
                new JLabel(
                        "Préparation de l'analyse..."
                );

        statusLabel.setForeground(
                SECONDARY_TEXT
        );

        statusLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        progressBar =
                new JProgressBar();

        progressBar.setIndeterminate(
                true
        );

        progressBar.setVisible(
                false
        );

        progressBar.setPreferredSize(
                new Dimension(
                        180,
                        16
                )
        );

        progressBar.setBackground(
                Color.decode("#CFD9DF")
        );

        progressBar.setForeground(
                Color.decode("#607078")
        );
    }

    private JPanel createBottomPanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(
                BACKGROUND_COLOR
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        20,
                        8,
                        20
                )
        );

        panel.add(
                statusLabel,
                BorderLayout.WEST
        );

        panel.add(
                progressBar,
                BorderLayout.EAST
        );

        return panel;
    }

    private void scanComputer() {

        progressBar.setVisible(
                true
        );

        statusLabel.setText(
                "Analyse de l'ordinateur..."
        );

        SwingWorker<Void, FileItem> worker =
                new SwingWorker<Void, FileItem>() {

                    private int fileCount = 0;

                    @Override
                    protected Void doInBackground() {

                        FileScanner scanner =
                                new FileScanner();

                        scanner.scanComputer(
                                fileItem ->
                                        publish(fileItem)
                        );

                        return null;
                    }

                    @Override
                    protected void process(
                            List<FileItem> chunks) {

                        for (FileItem fileItem :
                                chunks) {

                            fileCount++;

                            updateCategoryCounter(
                                    fileItem
                            );
                        }

                        filePanel.addFiles(
                                chunks
                        );

                        statusLabel.setText(
                                "Analyse : "
                                + fileCount
                                + " fichier(s)"
                        );
                    }

                    @Override
                    protected void done() {

                        try {

                            get();

                            progressBar.setIndeterminate(
                                    false
                            );

                            progressBar.setVisible(
                                    false
                            );

                            statusLabel.setText(
                                    fileCount
                                    + " fichier(s) analysé(s)"
                            );

                            updateCounterLabels();

                        } catch (Exception e) {

                            progressBar.setVisible(
                                    false
                            );

                            statusLabel.setText(
                                    "Erreur lors de l'analyse"
                            );

                            e.printStackTrace();
                        }
                    }
                };

        worker.execute();
    }

    private void updateCategoryCounter(
            FileItem fileItem) {

        FileCategorizer categorizer =
                new FileCategorizer();

        String category =
                categorizer.categorize(
                        fileItem
                );

        categoryCounts.put(
                "All",
                categoryCounts.get("All") + 1
        );

        categoryCounts.put(
                category,
                categoryCounts.get(category) + 1
        );

        updateCounterLabels();
    }

    private void updateCounterLabels() {

        if (allCountLabel != null) {

            allCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    "All"
                            )
                    )
            );
        }

        if (musicCountLabel != null) {

            musicCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    FileCategorizer.MUSIC
                            )
                    )
            );
        }

        if (videoCountLabel != null) {

            videoCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    FileCategorizer.VIDEO
                            )
                    )
            );
        }

        if (documentsCountLabel != null) {

            documentsCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    FileCategorizer.DOCUMENTS
                            )
                    )
            );
        }

        if (imagesCountLabel != null) {

            imagesCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    FileCategorizer.IMAGES
                            )
                    )
            );
        }

        if (otherCountLabel != null) {

            otherCountLabel.setText(
                    String.valueOf(
                            categoryCounts.get(
                                    FileCategorizer.OTHER
                            )
                    )
            );
        }
    }
}