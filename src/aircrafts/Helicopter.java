/**
 * Created by ovirchen on 12/1/18.
 */
package aircrafts;
import WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    void updateConditions() {

    }
    void registerTower(WeatherTower weatherTower) {

    }
}
