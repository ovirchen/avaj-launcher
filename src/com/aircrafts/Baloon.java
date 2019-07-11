package com.aircrafts;

import com.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): I don't see anything!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
                break;
        }
        if (this.coordinates.getHeight() == 0)
        {
            System.out.println("Baloon#" + this.name + "(" + this.id + ") landing.");
            weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + "): registered to weather tower.");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
