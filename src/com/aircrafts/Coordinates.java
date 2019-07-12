/**
 * Created by ovirchen on 12/1/18.
 */

package com.aircrafts;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
            this.longitude = longitude;
            if (longitude > 360)
                this.longitude = 360;
            else if (longitude < 0)
                this.longitude = 0;
            this.latitude = latitude;
            if (latitude > 360)
                this.latitude = 360;
            else if (latitude < 0)
                this.latitude = 0;
            this.height = height;
            if (height > 100)
                this.height = 100;
            else if (height < 0)
                this.height = 0;
    }

    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }

}
