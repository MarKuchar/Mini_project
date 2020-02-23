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

    public void newGame(){
        usedLetters.add('i');
        usedLetters.add('a');
        usedLetters.add('a');
        numOfGuesses = 2;
        createCities();
        randomCity();
        underscoredCity();
        System.out.println(guessedCity);
        System.out.println(underscoredCity());
        System.out.println(revealLetter());
        while(true){
            System.out.println((guessLetter()));
            System.out.println(revealLetter());
        }
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
            if (guessedCity.get(i).equals(usedLetters.get(numOfGuesses - 1))) {
                test[i] = usedLetters.get(numOfGuesses - 1);
            } else if (guessedCity.get(i).equals((usedLetters.get(numOfGuesses - 1))) && i == 0) {
                test[i] = usedLetters.get(numOfGuesses - 1);
            } else if (test[i] == ' ') {
                continue;
            } else {
                continue;
            }
        }
        return test;
    }
}
