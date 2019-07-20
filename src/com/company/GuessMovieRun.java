package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessMovieRun {

    public static void main(String[] args) throws Exception {

        chooseOneFilm();

    }

        private static String chooseOneFilm() throws Exception{

            File file = new File("movies.txt");
            String lists = "";
            String[] movieLists = {};

            try{
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine() + "\n";
                    lists += line + "\n";
                    movieLists = lists.split("\n");
                }

            }catch (FileNotFoundException e){
                System.out.println("File doesn't found!");
            }
            int randomMovie = (int)(Math.random() * movieLists.length);
            //System.out.println(movieLists[randomMovie]);
            return movieLists[randomMovie];
        }
}
