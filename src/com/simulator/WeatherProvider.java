package com.simulator;

import com.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random random = new Random();
        if (coordinates.getHeight() < 50) {
            if ((coordinates.getLatitude() % 2 != 0) & (coordinates.getLongitude() % 2 == 0))
                return weather[random.nextInt(2)];
                return weather[random.nextInt(4)];
        }
        return weather[2];
    }
}
