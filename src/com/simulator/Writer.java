package com.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeMessage(String message)
    {
        try {
            FileWriter writer = new FileWriter("simulation.txt", true);
            writer.write(message + "\n");
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
