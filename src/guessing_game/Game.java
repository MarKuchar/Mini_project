package guessing_game;


import com.sun.jdi.ArrayReference;
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


    /**
     * Method
     *
     * @param
     * @return
     */

    public void newGame(){
        createCities();
        randomCity();
        underscoreCity();
        while(true){

            guessLetter();
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
    public static String guessLetter(){
        System.out.println("Guess letter: ");
        Scanner scan = new Scanner(System.in);
        char letter = scan.next().charAt(0);
        int ascii = (int) letter;
        System.out.println(ascii);
        //65 - 122
        if ((int)ascii >= (int)65 && (int)ascii <= (int)122) {
            return String.valueOf(letter);
        }
        return "Invalid character, try again: ";
    }


}
