/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.FileItem;
import service.FileCategorizer;

public class FilePanel extends JPanel {

    private JTable fileTable;

    private DefaultTableModel tableModel;

    private JLabel countLabel;

    private JTextField searchField;

    private List<FileItem> allFiles;

    private String currentCategory;

    private FileCategorizer categorizer;

    private final Color BACKGROUND =
            new Color(
                    245,
                    246,
                    248
            );

    private final Color TEXT =
            new Color(
                    35,
                    35,
                    40
            );

    private final Color SECONDARY =
            new Color(
                    120,
                    120,
                    130
            );

    private final Color BORDER =
            new Color(
                    225,
                    226,
                    230
            );

    private final Color SEARCH_BACKGROUND =
            new Color(
                    250,
                    251,
                    253
            );

    public FilePanel() {

        allFiles =
                new ArrayList<>();

        currentCategory =
                "All";

        categorizer =
                new FileCategorizer();

        setLayout(
                new BorderLayout(
                        15,
                        15
                )
        );

        setBackground(
                BACKGROUND
        );

        setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        30,
                        15,
                        30
                )
        );

        createHeader();

        createTable();

        createBottomButtons();
    }

    private void createHeader() {

        JPanel titlePanel =
                new JPanel(
                        new BorderLayout()
                );

        titlePanel.setOpaque(
                false
        );

        JLabel title =
                new JLabel(
                        "Fichiers"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );

        title.setForeground(
                TEXT
        );

        countLabel =
                new JLabel(
                        "0 fichier"
                );

        countLabel.setForeground(
                SECONDARY
        );

        countLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        titlePanel.add(
                title,
                BorderLayout.WEST
        );

        titlePanel.add(
                countLabel,
                BorderLayout.EAST
        );

        searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setBackground(
                SEARCH_BACKGROUND
        );

        searchField.setCaretColor(
                new Color(
                        70,
                        90,
                        220
                )
        );

        searchField.setMargin(
                new Insets(
                        12,
                        16,
                        12,
                        16
                )
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        218,
                                        220,
                                        226
                                ),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                2,
                                4,
                                2,
                                4
                        )
                )
        );

        searchField.setToolTipText(
                "Rechercher par nom ou emplacement"
        );

        searchField.setText(
                "Rechercher par nom ou emplacement..."
        );

        searchField.setForeground(
                new Color(
                        145,
                        147,
                        155
                )
        );

        searchField.addFocusListener(
                new java.awt.event.FocusAdapter() {

                    @Override
                    public void focusGained(
                            java.awt.event.FocusEvent e) {

                        if (searchField
                                .getText()
                                .equals(
                                    "Rechercher par nom ou emplacement..."
                                )) {

                            searchField.setText(
                                    ""
                            );

                            searchField.setForeground(
                                    TEXT
                            );
                        }
                    }

                    @Override
                    public void focusLost(
                            java.awt.event.FocusEvent e) {

                        if (searchField
                                .getText()
                                .trim()
                                .isEmpty()) {

                            searchField.setText(
                                    "Rechercher par nom ou emplacement..."
                            );

                            searchField.setForeground(
                                    new Color(
                                            145,
                                            147,
                                            155
                                    )
                            );
                        }
                    }
                }
        );

        searchField
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                    @Override
                    public void insertUpdate(
                            DocumentEvent e) {

                        refreshTable();
                    }

                    @Override
                    public void removeUpdate(
                            DocumentEvent e) {

                        refreshTable();
                    }

                    @Override
                    public void changedUpdate(
                            DocumentEvent e) {

                        refreshTable();
                    }
                }
        );

        JPanel searchPanel =
                new JPanel(
                        new BorderLayout()
                );

        searchPanel.setOpaque(
                false
        );

        searchPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        0,
                        5,
                        0
                )
        );

        searchPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(
                false
        );

        header.add(
                titlePanel,
                BorderLayout.NORTH
        );

        header.add(
                searchPanel,
                BorderLayout.CENTER
        );

        add(
                header,
                BorderLayout.NORTH
        );
    }

    private void createTable() {

        tableModel =
                new DefaultTableModel(
                        new Object[]{
                            "Nom",
                            "Catégorie",
                            "Extension",
                            "Emplacement"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        fileTable =
                new JTable(
                        tableModel
                );

        fileTable.setBackground(
                Color.WHITE
        );

        fileTable.setForeground(
                TEXT
        );

        fileTable.setSelectionBackground(
                new Color(
                        225,
                        230,
                        255
                )
        );

        fileTable.setSelectionForeground(
                TEXT
        );

        fileTable.setGridColor(
                new Color(
                        238,
                        238,
                        240
                )
        );

        fileTable.setRowHeight(
                34
        );

        fileTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        fileTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                13
                        )
                );

        fileTable.getTableHeader()
                .setBackground(
                        new Color(
                                235,
                                236,
                                240
                        )
                );

        fileTable.getTableHeader()
                .setForeground(
                        TEXT
                );

        fileTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        fileTable.setAutoCreateRowSorter(
                true
        );

        fileTable.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(
                        220
                );

        fileTable.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(
                        120
                );

        fileTable.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(
                        100
                );

        fileTable.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(
                        600
                );

        fileTable.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent e) {

                        if (e.getClickCount() == 2
                                && e.getButton()
                                == java.awt.event.MouseEvent.BUTTON1) {

                            openSelectedFile();
                        }
                    }

                    @Override
                    public void mousePressed(
                            java.awt.event.MouseEvent e) {

                        showContextMenu(e);
                    }

                    @Override
                    public void mouseReleased(
                            java.awt.event.MouseEvent e) {

                        showContextMenu(e);
                    }
                }
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        fileTable
                );

        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        add(
                scrollPane,
                BorderLayout.CENTER
        );
    }

    private void showContextMenu(
            java.awt.event.MouseEvent e) {

        if (!e.isPopupTrigger()) {
            return;
        }

        int row =
                fileTable.rowAtPoint(
                        e.getPoint()
                );

        if (row == -1) {
            return;
        }

        fileTable.setRowSelectionInterval(
                row,
                row
        );

        JPopupMenu popupMenu =
                new JPopupMenu();

        JMenuItem copyPathItem =
                new JMenuItem(
                        "Copier le chemin"
                );

        JMenuItem propertiesItem =
                new JMenuItem(
                        "Propriétés"
                );

        copyPathItem.addActionListener(
                event ->
                        copySelectedPath()
        );

        propertiesItem.addActionListener(
                event ->
                        showProperties()
        );

        popupMenu.add(
                copyPathItem
        );

        popupMenu.addSeparator();

        popupMenu.add(
                propertiesItem
        );

        popupMenu.show(
                fileTable,
                e.getX(),
                e.getY()
        );
    }

    private void createBottomButtons() {

        JButton openButton =
                new JButton(
                        "Ouvrir"
                );

        JButton locationButton =
                new JButton(
                        "Ouvrir l'emplacement"
                );

        styleButton(
                openButton,
                true
        );

        styleButton(
                locationButton,
                false
        );

        openButton.addActionListener(
                e ->
                        openSelectedFile()
        );

        locationButton.addActionListener(
                e ->
                        openFileLocation()
        );

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttonPanel.setOpaque(
                false
        );

        buttonPanel.add(
                openButton
        );

        buttonPanel.add(
                locationButton
        );

        add(
                buttonPanel,
                BorderLayout.SOUTH
        );
    }

    private void styleButton(
            JButton button,
            boolean primary) {

        button.setFocusPainted(
                false
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        if (primary) {

            button.setBackground(
                    new Color(
                            70,
                            90,
                            220
                    )
            );

            button.setForeground(
                    Color.WHITE
            );

            button.setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            18,
                            10,
                            18
                    )
            );

        } else {

            button.setBackground(
                    Color.WHITE
            );

            button.setForeground(
                    TEXT
            );

            button.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    BORDER
                            ),
                            BorderFactory.createEmptyBorder(
                                    9,
                                    17,
                                    9,
                                    17
                            )
                    )
            );
        }
    }

    public void displayFiles(
            List<FileItem> files) {

        allFiles.clear();

        if (files != null) {

            allFiles.addAll(
                    files
            );
        }

        refreshTable();
    }

    public void addFiles(
            List<FileItem> files) {

        if (files == null
                || files.isEmpty()) {

            return;
        }

        allFiles.addAll(
                files
        );

        refreshTable();
    }

    public void filterByCategory(
            String category) {

        currentCategory =
                category;

        refreshTable();
    }

    private void refreshTable() {

        tableModel.setRowCount(
                0
        );

        String searchText =
                searchField
                        .getText()
                        .trim()
                        .toLowerCase();

        if (searchText.equals(
                "rechercher par nom ou emplacement..."
        )) {

            searchText = "";
        }

        int count = 0;

        for (FileItem fileItem :
                allFiles) {

            String category =
                    categorizer.categorize(
                            fileItem
                    );

            if (!currentCategory.equals(
                    "All"
            )
                    && !category.equals(
                            currentCategory
                    )) {

                continue;
            }

            String fileName =
                    fileItem
                            .getName()
                            .toLowerCase();

            String filePath =
                    fileItem
                            .getPath()
                            .toLowerCase();

            if (!searchText.isEmpty()
                    && !fileName.contains(
                            searchText
                    )
                    && !filePath.contains(
                            searchText
                    )) {

                continue;
            }
            tableModel.addRow(
                    new Object[]{
                        fileItem.getName(),
                        category,
                        fileItem.getExtension(),
                        fileItem.getPath()
                    }
            );

            count++;
        }

        countLabel.setText(
                count
                + (
                    count <= 1
                    ? " fichier"
                    : " fichiers"
                )
        );
    }

    private File getSelectedFile() {

        int selectedRow =
                fileTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Veuillez sélectionner un fichier.",
                    "Aucun fichier sélectionné",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return null;
        }

        int modelRow =
                fileTable.convertRowIndexToModel(
                        selectedRow
                );

        Object value =
                tableModel.getValueAt(
                        modelRow,
                        3
                );

        if (value == null) {
            return null;
        }

        return new File(
                value.toString()
        );
    }

    private void openSelectedFile() {

        File file =
                getSelectedFile();

        if (file == null) {
            return;
        }

        if (!file.exists()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ce fichier n'existe plus :\n"
                    + file.getAbsolutePath(),
                    "Fichier introuvable",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            if (!java.awt.Desktop
                    .isDesktopSupported()) {

                JOptionPane.showMessageDialog(
                        this,
                        "L'ouverture des fichiers "
                        + "n'est pas disponible.",
                        "Fonction indisponible",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            java.awt.Desktop
                    .getDesktop()
                    .open(
                            file
                    );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Impossible d'ouvrir le fichier.\n\n"
                    + file.getAbsolutePath()
                    + "\n\n"
                    + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void openFileLocation() {

        File file =
                getSelectedFile();

        if (file == null) {
            return;
        }

        if (!file.exists()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ce fichier n'existe plus :\n"
                    + file.getAbsolutePath(),
                    "Fichier introuvable",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        File parent =
                file.getParentFile();

        if (parent == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Impossible de trouver "
                    + "l'emplacement du fichier.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {

            if (!java.awt.Desktop
                    .isDesktopSupported()) {

                JOptionPane.showMessageDialog(
                        this,
                        "L'ouverture des dossiers "
                        + "n'est pas disponible.",
                        "Fonction indisponible",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            java.awt.Desktop
                    .getDesktop()
                    .open(
                            parent
                    );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Impossible d'ouvrir l'emplacement.\n\n"
                    + parent.getAbsolutePath()
                    + "\n\n"
                    + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void copySelectedPath() {

        File file =
                getSelectedFile();

        if (file == null) {
            return;
        }

        String path =
                file.getAbsolutePath();

        StringSelection selection =
                new StringSelection(
                        path
                );

        java.awt.Toolkit
                .getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        selection,
                        null
                );

        JOptionPane.showMessageDialog(
                this,
                "Chemin copié dans le presse-papiers.",
                "Chemin copié",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void showProperties() {

        File file =
                getSelectedFile();

        if (file == null) {
            return;
        }

        String name =
                file.getName();

        String path =
                file.getAbsolutePath();

        String extension =
                getExtension(
                        file
                );

        long size =
                file.length();

        String sizeFormatted =
                formatSize(
                        size
                );

        String type =
                extension.isEmpty()
                ? "Fichier"
                : extension.toUpperCase();

        String message =
                "<html>"
                + "<b>Nom :</b> "
                + name
                + "<br><br>"
                + "<b>Type :</b> "
                + type
                + "<br><br>"
                + "<b>Taille :</b> "
                + sizeFormatted
                + "<br><br>"
                + "<b>Emplacement :</b><br>"
                + path
                + "</html>";

        JOptionPane.showMessageDialog(
                this,
                message,
                "Propriétés du fichier",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private String getExtension(
            File file) {

        String name =
                file.getName();

        int index =
                name.lastIndexOf(
                        "."
                );

        if (index > 0
                && index < name.length() - 1) {

            return name.substring(
                    index + 1
            );
        }

        return "";
    }

    private String formatSize(
            long size) {

        if (size < 1024) {

            return size
                    + " octets";
        }

        if (size < 1024 * 1024) {

            return String.format(
                    "%.2f Ko",
                    size / 1024.0
            );
        }

        if (size
                < 1024L
                * 1024L
                * 1024L) {

            return String.format(
                    "%.2f Mo",
                    size
                    / (
                        1024.0
                        * 1024.0
                    )
            );
        }

        return String.format(
                "%.2f Go",
                size
                / (
                    1024.0
                    * 1024.0
                    * 1024.0
                )
        );
    }

}