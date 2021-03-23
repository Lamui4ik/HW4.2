package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        GameProgress gameProgress1 = new GameProgress(1, 2, 1, 1);
        GameProgress gameProgress2 = new GameProgress(2, 3, 2, 2);
        GameProgress gameProgress3 = new GameProgress(3, 4, 3, 5);

        gameProgress1.saveGame("C://Games/savegames/save1.dat", gameProgress1);
        gameProgress2.saveGame("C://Games/savegames/save2.dat", gameProgress2);
        gameProgress3.saveGame("C://Games/savegames/save3.dat", gameProgress3);

        zipFiles("C://Games/savegames/zip.zip", new String[]{"C://Games/savegames/save1.dat", "C://Games/savegames/save2.dat", "C:/Games/savegames/save3.dat"});

        Files.delete(Path.of("C://Games/savegames/save1.dat"));
        Files.delete(Path.of("C://Games/savegames/save2.dat"));
        Files.delete(Path.of("C://Games/savegames/save3.dat"));
    }

    public static void zipFiles(String path, String[] list) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (int i = 0; i < 3; i++) {
            File fileToZip = new File(list[i]);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }
}
