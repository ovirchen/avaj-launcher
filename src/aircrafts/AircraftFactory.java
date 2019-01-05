/**
 * Created by ovirchen on 12/1/18.
 */
package aircrafts;

public abstract class AircraftFactory {
    public abstract Flyable newAircraft(String type, String name, int longitude,
                               int latittude, int height);
}
