/**
 * Created by ovirchen on 12/1/18.
 */
package com.simulator;

import com.aircrafts.Flyable;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower implements Flyable{
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable))
            observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
    protected void conditionsChanged() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
