package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        GameProgress gameProgress1 = new GameProgress(1, 2, 1, 1);
        GameProgress gameProgress2 = new GameProgress(2, 3, 2, 2);
        GameProgress gameProgress3 = new GameProgress(3, 4, 3, 5);

        gameProgress1.saveGame("C://Games//savegames//save1.dat", gameProgress1);
        gameProgress2.saveGame("C://Games//savegames//save2.dat", gameProgress2);
        gameProgress3.saveGame("C://Games//savegames//save3.dat", gameProgress3);

        gameProgress1.zipFiles("C://Games//savegames//zip.zip", new String[]{"C://Games//savegames//save1.dat", "C://Games//savegames//save2.dat", "C://Games//savegames//save3.dat"});


        Files.delete(Path.of("C:\\Games\\savegames\\save1.dat"));
        Files.delete(Path.of("C:\\Games\\savegames\\save2.dat"));
        Files.delete(Path.of("C:\\Games\\savegames\\save3.dat"));
    }
}
