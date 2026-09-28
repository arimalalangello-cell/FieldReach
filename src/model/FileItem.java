/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;

public class FileItem {

    private File file;

    public FileItem(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getName() {
        return file.getName();
    }

    public String getPath() {
        return file.getAbsolutePath();
    }

    public long getSize() {
        return file.length();
    }

    public String getExtension() {
        String name = file.getName();
        int index = name.lastIndexOf(".");

        if (index > 0 && index < name.length() - 1) {
            return name.substring(index + 1).toLowerCase();
        }

        return "";
    }
}