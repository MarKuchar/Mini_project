package guessing_game;

import java.util.List;
import java.util.Random;

public class Game {
    private String guessedCity;

    /**
     * Constructor
     * @param city
     */

    public Game(String city) {
        this.guessedCity = city;
    }

    /**
     * Method
     * @param cities
     * @return
     */
    private String randomCity(List<String> cities) {
        Random random = new Random();
        return cities.get(random.nextInt(List.lenght));
    }
    private String underscoreCity() {
        String a = new String[randomCity().length];
        for (int i = 0; i < this.randomCity().length; i++){
            a += "_";
        }
        return a;
    }
}
