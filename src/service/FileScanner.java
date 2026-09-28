/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import model.FileItem;

public class FileScanner {

    public void scanComputer(
            Consumer<FileItem> onFileFound) {

        File[] roots = File.listRoots();

        if (roots == null) {
            return;
        }

        for (File root : roots) {

            scanFolder(
                    root,
                    onFileFound
            );
        }
    }

    private void scanFolder(
            File folder,
            Consumer<FileItem> onFileFound) {

        File[] elements;

        try {
            elements = folder.listFiles();
        } catch (SecurityException e) {
            return;
        }

        if (elements == null) {
            return;
        }

        for (File element : elements) {

            try {

                if (element.isFile()) {

                    FileItem fileItem =
                            new FileItem(element);

                    onFileFound.accept(fileItem);

                } else if (element.isDirectory()) {

                    String path =
                            element
                                    .getAbsolutePath()
                                    .toLowerCase();

                    if (isExcludedFolder(path)) {
                        continue;
                    }

                    scanFolder(
                            element,
                            onFileFound
                    );
                }

            } catch (SecurityException e) {
                // Dossier ou fichier inaccessible
            }
        }
    }

    private boolean isExcludedFolder(
            String path) {

        return path.matches(
                    "^[a-z]:\\\\windows(\\\\.*)?$"
                )
                || path.matches(
                    "^[a-z]:\\\\program files(\\\\.*)?$"
                )
                || path.matches(
                    "^[a-z]:\\\\program files \\(x86\\)(\\\\.*)?$"
                )
                || path.matches(
                    "^[a-z]:\\\\programdata(\\\\.*)?$"
                )
                || path.matches(
                    "^[a-z]:\\\\\\$recycle\\.bin(\\\\.*)?$"
                )
                || path.matches(
                    "^[a-z]:\\\\system volume information(\\\\.*)?$"
                )
                || path.contains(
                    "\\appdata\\local\\temp"
                );
    }
}