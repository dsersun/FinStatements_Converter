package org.FinData;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main (String[] args) {
        int intervalInSeconds = 30;
        Timer timer = new Timer ();
        timer.scheduleAtFixedRate (new TimerTask () {
            public void run () {
                String excelFolder = "src/Data/xlsx";
                String ResultFolder = "src/Data/json";
                Converter saver = new Converter ();
                saver.converter (excelFolder, ResultFolder);
                System.out.println ("----------- Executed ------------\n");
            }
        }, 0, intervalInSeconds * 1000);

        try {
            Thread.sleep (300000); // Application will be stopped after 5 min.
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        timer.cancel ();
        System.out.println ("Job is done. Try Again!");
    }
}
