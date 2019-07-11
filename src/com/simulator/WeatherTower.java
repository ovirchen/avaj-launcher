/**
 * Created by ovirchen on 12/1/18.
 */

package com.simulator;

import com.aircrafts.Coordinates;


public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    void changeWeather() {
        updateConditions();
    }
    @Override
    public void updateConditions() {
        conditionsChanged();
    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.register(weatherTower);
    }
}
