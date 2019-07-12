package com.aircrafts;

import com.simulator.WeatherTower;
import com.simulator.Writer;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        switch (weather) {
            case "SUN":
                super.coordinates = new Coordinates(super.coordinates.getLongitude() + 2,
                        super.coordinates.getLatitude(), super.coordinates.getHeight() + 4);
                Writer.writeMessage("Baloon#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude(), super.coordinates.getHeight() - 5);
                Writer.writeMessage("Baloon#" + super.name + "(" + super.id + "): Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude(), super.coordinates.getHeight() - 3);
                Writer.writeMessage("Baloon#" + super.name + "(" + super.id + "): I don't see anything!");
                break;
            case "SNOW":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude(), super.coordinates.getHeight() - 15);
                Writer.writeMessage("Baloon#" + super.name + "(" + super.id + "): It's snowing. We're gonna crash.");
                break;
        }
        if (super.coordinates.getHeight() <= 0)
        {
            Writer.writeMessage("Baloon#" + super.name + "(" + super.id + ") landing.");
            weatherTower.unregister(this);
            Writer.writeMessage("Tower says: Baloon#" + super.name + "(" + super.id + ") unregistered from weather tower.");
            Writer.writeMessage("Coordinates of Baloon#" + super.name + "(" + super.id + "): " +
                    super.coordinates.getLongitude() + " " + super.coordinates.getLatitude() +
                    " " + super.coordinates.getHeight());
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (this.coordinates.getHeight() > 0) {
            Writer.writeMessage("Tower says: Baloon#" + super.name + "(" + super.id + ") registered to weather tower.");
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
        }
    }
}
