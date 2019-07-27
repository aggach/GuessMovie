package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuessMovieRun {

    public static void main(String[] args) throws Exception {

        String movie = chooseOneFilm();
        Game game = new Game(movie);
        game.StartGame(10);
    }

    private static String chooseOneFilm() throws Exception {

        File file = new File("movies.txt");
        String lists = "";
        String[] movieLists = {};


        List<String> lista = Files.lines(Paths.get("movies.txt")).collect(Collectors.toList());


        int randomMovie = (int) (Math.random() * lista.size());
        //System.out.println(movieLists[randomMovie]);
        return lista.get(randomMovie);
    }
}
