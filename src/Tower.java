/**
 * Created by ovirchen on 12/1/18.
 */

import aircrafts.Flyable;

public abstract class Tower implements Flyable{
    private Flyable* observers;

    public void register(Flyable flyable){
        observers = flyable;
    }
    public void unregister(Flyable flyable){
        observers = 0;
    }
    protected void conditionsChanged() {

    }
}
