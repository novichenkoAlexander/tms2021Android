package by.home.service;

import by.home.output.HomeFileWriter;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    private final String dirPath;
    private final String dirName;
    private final String newDirName;
    private final String zipName;
    private final String FILE_NAME_1 = "bio.txt";
    private final String FILE_NAME_2 = "info.txt";
    private final String FILE_NAME_3 = "demo.txt";

    public FileUtil(String dirPath, String dirName, String zipName, String newDirName) {
        this.dirPath = dirPath;
        this.dirName = dirName;
        this.zipName = zipName;
        this.newDirName = newDirName;
    }


    public void workWithFiles() throws IOException {
        File dir = createDir();

        File file1 = createFile(dir, FILE_NAME_1);
        File file2 = createFile(dir, FILE_NAME_2);
        File file3 = createFile(dir, FILE_NAME_3);

        writeInfoToFile(file1);
        writeInfoToFile(file2);
        writeInfoToFile(file3);

        List<File> fileList = new LinkedList<>();
        fileList.add(file1);
        fileList.add(file2);
        fileList.add(file3);

        createZip(zipName, fileList);

        File newDir = reNameDir(dir);

        printAllIncludes(newDir);

        deleteDir(newDir);
    }

    private File createDir() {
        File dir = new File(dirPath + "/" + dirName);
        boolean isExists = dir.exists();
        boolean created = dir.mkdir();
        if (isExists) {
            System.out.println("Directory is already exists!");
            return dir;
        } else if (created) {
            System.out.println("Directory was successfully created!");
            return dir;
        } else {
            System.out.println("Directory was not created!");
            return null;
        }
    }

    private void printAllIncludes(File dir) {
        if (dir.isDirectory()) {
            System.out.println("The list of files in dir: ");
            for (File item : dir.listFiles()) {
                System.out.println(item.getName());
            }
        }
    }

    private File reNameDir(File dir) {
        File newDir = new File(dirPath + "/" + newDirName);
        if (dir.renameTo(newDir)) {
            System.out.println("Dir renamed!");
        }
        return newDir;
    }

    private void deleteDir(File file) throws FileNotFoundException {
        if (file.isDirectory() && file.listFiles().length != 0) {
            for (File item : file.listFiles()) {
                deleteFile(item);
            }
        }
        if (file.listFiles().length == 0) {
            deleteFile(file);
        }

    }

    private File createFile(File dir, String fileName) throws IOException {
        File file = new File(dir, fileName);
        if (file.exists()) {
            System.out.println("File " + fileName + " exists!");
            return file;
        } else if (file.createNewFile()) {
            System.out.println("File " + fileName + " has been created!");
            return file;
        } else {
            System.out.println("File " + fileName + " not found!");
            return null;
        }
    }

    private void writeInfoToFile(File file) throws IOException {
        if (file != null) {
            HomeFileWriter writer = new HomeFileWriter(file.getPath());
            writer.write("aa");
        } else {
            throw new FileNotFoundException("Can't write to file!");
        }

    }

    private void deleteFile(File file) throws FileNotFoundException {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File " + file.getName() + " has been deleted!");
            }
        } else {
            throw new FileNotFoundException("Can't delete file" + file.getName() + " !");
        }
    }

    private void createZip(String zipName, List<File> files) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(dirPath + "/" + zipName))) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOut.putNextEntry(zipEntry);
                    byte[] fileInfo = new byte[fis.available()];
                    fis.read(fileInfo);
                    zipOut.write(fileInfo);
                    zipOut.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Files have been added to zip!");
        }
    }
}