package guessing_game;
import java.util.*;
import java.io.*;
import java.util.List;


public class Game {
     /*
     *
     *       VARIABLES
     *
     * */

    private static String FILE_PATH = "cities.txt";
    private static List<String> cities = new ArrayList<String>();
    private static List<Character> guessedCity = new ArrayList<Character>();
    private static List<Character> usedLetters = new ArrayList<Character>();
    private static int numOfGuesses;
    private static String revealedLetters;
    private static List<Character> underscoreCity = new ArrayList<Character>();

    /*
    *
    * Constructor
    *
    * */

    public Game() {
        this.guessedCity= new ArrayList<Character>();
   }
    /*
    *
    *       METHODS
    *
    * */

    public static void randomCity() {
        Random random = new Random();
        String city = cities.get(random.nextInt(cities.size()));
        for (char letter : city.toCharArray()) {
            guessedCity.add(letter);
        }
    }

    public void newGame() {
        createCities();
        randomCity();
        underscoredCity();
        usedLetters.add('a');
        System.out.println(guessedCity);
        System.out.println(underscoredCity());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < revealLetter().length; j++) {
                if (revealLetter()[i] == '_') {
                    char[] test = underscoredCity();
                    guessLetter();
                    // how to set a permanent variable in revealdLetters, not to be always rewritten
                    System.out.println(revealLetter());

                } else if (j == revealLetter().length && revealLetter()[i] != '_') {
                    System.out.println("You guessed the city!");
                }
            }

        }
        System.out.println("Game over!");
    }


    public static char[] underscoredCity() {
        String underscore = "";
        for (int i = 0; i < guessedCity.size(); i++) {
            if (guessedCity.get(i) == ' ') {
                underscore += " ";
            } else {
                underscore += "_";
            }
        }
        char[] underscoreCity = underscore.toCharArray();
        return underscoreCity;
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
    public static boolean guessLetter() {
        System.out.println("Guess letter: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char letter = input.charAt(0);
        usedLetters.add(letter);

        /*
        *
        * number of guesses - I always take a letter from 'usedLetters(numOfGuesses - 1) to compare with letters in the City
        *                     each attempt will be += 1, (If guesser guess right, we will also count + 1
        * getter - to get usedLetters
        *
        * */

        return letter >= 65 && letter <= 122 && input.length() < 2;
    }

    public static char[] revealLetter() {
        char[] test = underscoredCity();
        for(int i = 0; i < guessedCity.size(); i++) {
            if (guessedCity.get(i) == usedLetters.get(usedLetters.size()) && test[i] == '_') {
                test[i] = usedLetters.get(usedLetters.size() );
            } else if (guessedCity.get(i) == usedLetters.get(usedLetters.size()) && i == 0) {
                test[i] = usedLetters.get(usedLetters.size());
            } else if (test[i] == ' ') {
                continue;
            } else {
                continue;
            }
        }
        return test;
    }
}