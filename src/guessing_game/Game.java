package guessing_game;


import com.sun.tools.internal.xjc.AbortException;

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
        if (guessLetter()) {

        }
    }
    public void randomCity() {
        Random random = new Random();
        guessedCity = Arrays.asList(cities.get(random.nextInt(cities.size())));
    }

    public static String underscoreCity() {
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
    public static boolean guessLetter() {
        System.out.println("Guess letter: ");
        Scanner scan = new Scanner(System.in);
        char letter = scan.next().charAt(0);
        return letter >= 65 && letter <= 122;
    }

}
