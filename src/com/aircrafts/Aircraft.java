/**
 * Created by ovirchen on 12/1/18.
 */

package com.aircrafts;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private long nextId()
    {
        return ++idCounter;
    }


}
