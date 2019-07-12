/**
 * Created by ovirchen on 12/1/18.
 */

package com.aircrafts;

import com.simulator.WeatherTower;
import com.simulator.Writer;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                Writer.writeMessage("Helicopter#" + name + "(" + id + "): This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5,
                        coordinates.getLatitude(), coordinates.getHeight());
                Writer.writeMessage("Helicopter#" + name + "(" + id + "): It is raining men... you know");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1,
                        coordinates.getLatitude(), coordinates.getHeight());
                Writer.writeMessage("Helicopter#" + name + "(" + id + "): It is milk everywhere!");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 12);
                Writer.writeMessage("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
                break;
        }
        if (coordinates.getHeight() <= 0)
        {
            Writer.writeMessage("Helicopter#" + name + "(" + id + ") landing.");
            weatherTower.unregister(this);
            Writer.writeMessage("Tower says: Helicopter#" + name + "(" + id + ") unregistered from weather tower.");
            Writer.writeMessage("Coordinates of Helicopter#" + super.name + "(" + super.id + "): " +
                    super.coordinates.getLongitude() + " " + super.coordinates.getLatitude() +
                    " " + super.coordinates.getHeight());
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (this.coordinates.getHeight() > 0) {
            Writer.writeMessage("Tower says: Helicopter#" + name + "(" + id + ") registered to weather tower.");
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
        }
    }
}
