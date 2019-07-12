package com.simulator;

import com.aircrafts.*;

import java.io.*;

public class Simulator {
    private static AircraftFactory factory = new AircraftFactory() {

        public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
            try {
                if (type.equals("Baloon"))
                    return new Baloon(name, new Coordinates(longitude, latitude, height));
                else if (type.equals("Helicopter"))
                    return new Helicopter(name, new Coordinates(longitude, latitude, height));
                else if (type.equals("JetPlane"))
                    return new JetPlane(name, new Coordinates(longitude, latitude, height));
                else {
                    throw new Exception("Wrong aircraft type");
                }
            }
            catch (Exception e)
            {
                System.out.println("Wrong aircraft type");
            }
            return null;
        }
    };

    public static void main(String args[])
    {
        try {
            File f = new File("simulation.txt");
            if(f.exists() && !f.isDirectory())
            {
                f.delete();
            }
            if (args.length != 1)
                throw new WrongArgumentsException();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            int cycles = Integer.parseInt(reader.readLine());
            if (cycles <= 0)
                throw new NumberFormatException();
            WeatherTower weatherTower = new WeatherTower();
            if (readLines(reader, weatherTower) == 1)
                throw new NumberFormatException();
            while (--cycles >= 0)
                weatherTower.changeWeather();
        }
        catch (WrongArgumentsException e)
        {
            System.out.println("Wrong arguments");
        }
        catch (FileNotFoundException e) {
            System.out.println("404. File not found");
        }
        catch (IOException e)
        {
            System.out.println("File reading error");
        }
        catch(NumberFormatException e){
            System.out.println("Error in scenario");
        }
    }

    private static int readLines(BufferedReader reader, WeatherTower weatherTower)
    {
        try {
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(" ");
                if (splitLine.length != 5) {
                    throw new WrongLineFormatException();
                }
                factory.newAircraft(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]),
                        Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4])).registerTower(weatherTower);
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("File reading error");
            return 1;
        }
        catch (WrongLineFormatException e)
        {
            System.out.println("Wrong line format");
            return 1;
        }
        catch(NumberFormatException e){
            System.out.println("Error in scenario");
            return 1;
        }
        return 0;
    }

    private static class WrongArgumentsException extends Exception{
    }
    private static class WrongLineFormatException extends Exception{
    }
}
