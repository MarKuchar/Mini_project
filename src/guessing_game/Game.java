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
    private static List guessedCity = new ArrayList<String>();


    /**
     * Method
     *
     * @param
     * @return
     */

    public void newGame() {
        createCities();
        randomCity();
        underscoreCity();
        guessLetter();
    }
    public void randomCity() {
        Random random = new Random();

        guessedCity = Arrays.asList(cities.get(random.nextInt(cities.size())));
    }

    public String underscoreCity() {
        String a = "";
        for (int i = 0; i < guessedCity.size(); i++) {
            a += "_ ";
        }
        return a;
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
    public static String guessLetter() {
        System.out.println("Guess letter: ");
        Scanner scan = new Scanner(System.in);
        char letter = scan.next().charAt(0);
        int ascii = (int) letter;
        if (ascii > 65 && ascii <= 122) {
            return String.valueOf(letter);
        } else {
            return "Invalid character, try again: ";
        }
    }

}
