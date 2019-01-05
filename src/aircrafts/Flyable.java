/**
 * Created by ovirchen on 12/1/18.
 */
package aircrafts;
import WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
