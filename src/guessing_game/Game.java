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
        System.out.println(guessedCity);
        while (numOfGuesses < 10) {
                if (underscoreCity.contains('_')) {
                    guessLetter();
                    revealLetter();
                    System.out.println(Arrays.toString(underscoreCity.toArray()));
                } else if (numOfGuesses < 10 && !underscoreCity.contains('_')) {
                    System.out.print("You guessed the city!");
                    break;
                }
        if (numOfGuesses == 10 && underscoreCity.contains('_')) {
            System.out.println();
            System.out.println("GAME OVER!");
            break;
        }
        }
    }

    public static void underscoredCity () {
        for (int i = 0; i < guessedCity.size(); i++) {
            if (guessedCity.get(i) == ' ') {
                underscoreCity.add((" ").charAt(0));
            } else {
                underscoreCity.add(("_").charAt(0));
            }
        }
    }

    public static void createCities () {
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
    public static void guessLetter () {
        Scanner scan = new Scanner(System.in);
        char letter;
        boolean validInput = false;
        do {
            System.out.println("Guess letter: ");
            String input = scan.nextLine();
            letter = input.charAt(0);
            if (!(letter >= 65 && letter <= 122 && input.length() < 2)) {
                System.out.println("Please try again, remember that you only can put 1 character and must be between A/a to Z/z");
                validInput = false;
            } else {
                if (usedLetters.contains(letter)) {
                    validInput = false;
                    System.out.println("You already used that letter");
                } else {
                    numOfGuesses++;
                    usedLetters.add(String.valueOf(letter).toLowerCase().charAt(0));
                    usedLetters.add(String.valueOf(letter).toUpperCase().charAt(0));
                }
            }
        } while (validInput);

    }

    public static boolean revealLetter () {
        for (int i = 0; i < guessedCity.size(); i++) {
            if (usedLetters.contains(guessedCity.get(i))) {
                underscoreCity.set(i, guessedCity.get(i));
            } else if (usedLetters.contains(guessedCity.get(i)) && i == 0) {
                underscoreCity.set(i, guessedCity.get(i));
            }
        }
        System.out.println("Number of guesses: " + numOfGuesses + ". Used letters: " + usedLetters);
        return false;
    }
}