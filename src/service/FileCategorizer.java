/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.FileItem;

public class FileCategorizer {

    public static final String MUSIC = "Music";
    public static final String VIDEO = "Video";
    public static final String DOCUMENTS = "Documents";
    public static final String IMAGES = "Images";
    public static final String OTHER = "Other";

    public String categorize(FileItem fileItem) {

        String extension = fileItem.getExtension();

        switch (extension) {

            case "mp3":
            case "wav":
            case "flac":
            case "aac":
            case "ogg":
            case "m4a":
                return MUSIC;

            case "mp4":
            case "avi":
            case "mkv":
            case "mov":
            case "wmv":
            case "flv":
            case "webm":
                return VIDEO;

            case "jpg":
            case "jpeg":
            case "png":
            case "gif":
            case "bmp":
            case "webp":
            case "svg":
                return IMAGES;

            case "pdf":
            case "doc":
            case "docx":
            case "txt":
            case "odt":
            case "rtf":
            case "xls":
            case "xlsx":
            case "csv":
            case "ppt":
            case "pptx":
            case "odp":
                return DOCUMENTS;

            default:
                return OTHER;
        }
    }
}