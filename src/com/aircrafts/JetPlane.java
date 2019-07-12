/**
 * Created by ovirchen on 12/1/18.
 */
package com.aircrafts;

import com.simulator.WeatherTower;
import com.simulator.Writer;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() + 10, super.coordinates.getHeight() + 2);
                Writer.writeMessage("JetPlane#" + super.name + "(" + super.id + "): Where is my sunglasses?");
                break;
            case "RAIN":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() + 5, super.coordinates.getHeight());
                Writer.writeMessage("JetPlane#" + super.name + "(" + super.id + "): It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() + 1, super.coordinates.getHeight());
                Writer.writeMessage("JetPlane#" + super.name + "(" + super.id + "): Again and again.");
                break;
            case "SNOW":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude(), super.coordinates.getHeight() - 7);
                Writer.writeMessage("JetPlane#" + super.name + "(" + super.id + "): OMG! Winter is coming!");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            Writer.writeMessage("JetPlane#" + super.name + "(" + super.id + ") landing.");
            weatherTower.unregister(this);
            Writer.writeMessage("Tower says: JetPlane#" + super.name + "(" + super.id + ") unregistered from weather tower.");
            Writer.writeMessage("Coordinates of JetPlane#" + super.name + "(" + super.id + "): " +
                    super.coordinates.getLongitude() + " " + super.coordinates.getLatitude() +
                    " " + super.coordinates.getHeight());
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        if (this.coordinates.getHeight() > 0) {
            Writer.writeMessage("Tower says: JetPlane#" + super.name + "(" + super.id + ") registered to weather tower.");
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
        }
    }
}
