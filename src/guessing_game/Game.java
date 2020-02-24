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
    private static int guessing = 0;

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
        System.out.println(Arrays.toString(guessedCity.toArray()));
        underscoreCity();
        while(true){
            guessLetter();
            System.out.println(Arrays.toString(usedLetters.toArray()));
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
    public static void guessLetter() {
        Scanner scan = new Scanner(System.in);
        char letter;
        boolean validInput = false;
        do{
            System.out.println("Guess letter: ");
            String input = scan.nextLine();
            letter = input.charAt(0);
            if(!(letter >= 65 && letter <= 122 && input.length()<2)){
                System.out.println("Please try again, remember that you only can put 1 character and must be between A/a to Z/z");
                validInput = false;
            }else{
                if(usedLetters.contains(letter)){
                    validInput = false;
                    System.out.println("You already used that letter");
                }else{
                    guessing++;
                    usedLetters.add(letter);
                }
            }
        }while(validInput);
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
