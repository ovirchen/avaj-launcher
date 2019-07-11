/**
 * Created by ovirchen on 12/1/18.
 */
package com.aircrafts;

import com.simulator.WeatherTower;

public interface Flyable {
    public abstract void updateConditions();
    public abstract void registerTower(WeatherTower weatherTower);
}
