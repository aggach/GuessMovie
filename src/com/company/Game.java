package com.company;

import java.util.Scanner;

public class Game {

    private String movie;
    private String goodLetter;
    private String wrongLetter;

    public Game(String movie) {
        this.movie = movie;
        this.goodLetter = "";
        this.wrongLetter = "";
    }

    public void StartGame(int checkNumber) {

        boolean isWin = false;
        int numberOfCheck = 0;
        while (numberOfCheck < checkNumber) {
            System.out.println("You are guessing: " + changeLetterToUnderscores());

            int numberOfWrongLetters = wrongLetter.isEmpty() ? 0 : wrongLetter.split(",").length;

            System.out.println("You have guess " + numberOfWrongLetters + " wrong letters: " + wrongLetter);
            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine();

            String letterToGuess = Character.toString(letter.charAt(0));

            if (movie.indexOf(letterToGuess) > -1) {
                goodLetter += letterToGuess;
            } else if (wrongLetter.indexOf(letterToGuess) == -1) {
                wrongLetter += (wrongLetter.isEmpty() ? "" : ",") + letterToGuess;
                numberOfCheck++;
            }

            if (movie.equals(changeLetterToUnderscores())) {
                System.out.println("YOU WIN! Movie title: " + movie);
                isWin = true;
                break;
            }
        }
        if (!isWin) {
            System.out.println("YOU LOSE! You tried guess to " + movie);
        }


    }

    public String changeLetterToUnderscores() {

        String movieWithDots = "";

        for (int i = 0; i < movie.length(); i++) {
            char letter = movie.charAt(i);


//            if (letter != ' ') {
//                letter = '_';
//                movieWithDots += letter;
//            } else {
//                movieWithDots += letter;
//                continue;
//            }
            if (letter == ' ') {
                movieWithDots += " ";
                continue;
            }
            if (goodLetter.indexOf(letter) == -1) {
                movieWithDots += '_';
            } else {
                movieWithDots += letter;
            }
        }
        //System.out.println(movieWithDots);
        return movieWithDots;
    }


}
