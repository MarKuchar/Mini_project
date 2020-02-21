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
        createCities();
        randomCity();
        underscoreCity();
        while(true){
            System.out.println((guessLetter()));
        }
    }

    public static String underscoreCity() {
        String a = "";
        for (int i = 0; i < guessedCity.size(); i++) {
            a += "_ ";
        }
        return a;
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
        return letter >= 65 && letter <= 122 && input.length()<2;
        /*
        *
        *
        *               TO DO
        *       CHECK THE COUNTER INCREMENT IF IT'S NECESSARY
        *       PUT THE USED LETTER INSIDE THE LIST (usedLetters)
        *
        *
        * */



    }
}
