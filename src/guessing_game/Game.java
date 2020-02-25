package guessing_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game{

    /*
     *
     *   VARIABLES
     *
     * */

    private static String FILE_PATH = "cities.txt";
    private static List<String> cities = new ArrayList<>();
    private static List<Character> guessedCity = new ArrayList<Character>();
    private static List<Character> underscoreCity = new ArrayList<Character>();
    private static List<Character> usedLetters = new ArrayList<Character>();
    private static int numOfGuesses = 0;

    /*
     *
     *  CONSTRUCTOR
     *
     * */

    public Game() {
        this.guessedCity= new ArrayList<Character>();
    }


    /*
     *
     *   METHODS
     *
     * */

    public void newGame(){
        boolean isWin = false;
        createCities();
        choseRandomCity();
        underscoredCity();
        System.out.println(guessedCity);
        System.out.println(underscoreCity);
        Scanner scan = new Scanner(System.in);
        char letter;
        do{
            try{
                do{
                    System.out.print("Guess a letter: ");
                    String input = scan.nextLine();
                    letter = input.charAt(0);
                    boolean found = false;
                    if (validInput(letter)){
                        for (int x = 0; x < guessedCity.size();x++){
                            if(underscoreCity.get(x).equals(letter)){
                                usedLetters.add(letter);
                                numOfGuesses++;
                            }else if (guessedCity.get(x).equals(letter)){
                                underscoreCity.set(x,letter);
                                found= true;
                            }
                        }
                        if (!found && !usedLetters.contains(letter)){
                            usedLetters.add(letter);
                            numOfGuesses++;
                        }
                        System.out.println(underscoreCity);
                        System.out.print("You have guessed ("+numOfGuesses+") wrong letters:");
                        for (char myLetter :usedLetters){
                            System.out.print(myLetter);
                        }
                        System.out.println("");
                        if (!underscoreCity.contains('_')){
                            isWin = true;
                            break;
                        }
                    }else{
                        System.out.println("Please try again, remember that you only can put 1 character and must be between A/a to Z/z");
                    }
                }while(numOfGuesses<=10);
                if (isWin){
                    System.out.println("You win!");
                }else{
                    System.out.println("You lose!");
                }
            }catch (Exception e){
                System.out.println("Something unexpected happened, remember that you can't put as input nothing ");
            }
        }while (true && !isWin);
    }

    public static void createCities(){
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String city = "";
            while ((city = br.readLine()) != null) {
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading: " + FILE_PATH);
        }
    }
    private void choseRandomCity() {
        Random random = new Random();
        String city = cities.get(random.nextInt(cities.size()));
        for (char letter : city.toCharArray()) {
            guessedCity.add(letter);
        }
    }

    public static boolean validInput(Character letter){
        if(letter >= 65 && letter <= 122){
            return true;
        }else{
            return false;
        }
    }
    public static void underscoredCity(){
        for (int i = 0; i < guessedCity.size(); i++) {
            if (guessedCity.get(i) == ' ') {
                underscoreCity.add((" ").charAt(0));
            } else {
                underscoreCity.add(("_").charAt(0));
            }
        }
    }
    public void printList(){

    }
}
