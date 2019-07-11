/**
 * Created by ovirchen on 12/1/18.
 */
package com.aircrafts;

import com.simulator.WeatherTower;

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
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): Where is my sunglasses?");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): Again and again.");
                break;
            case "SNOW":
                super.coordinates = new Coordinates(super.coordinates.getLongitude(),
                        super.coordinates.getLatitude(), super.coordinates.getHeight() - 7);
                System.out.println("JetPlane#" + super.name + "(" + super.id + "): OMG! Winter is coming!");
                break;
        }
        if (this.coordinates.getHeight() == 0)
        {
            System.out.println("JetPlane#" + super.name + "(" + super.id + ") landing.");
            weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane#" + super.name + "(" + super.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: JetPlane#" + super.name + "(" + super.id + "): registered to weather tower.");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
