package org.FinData;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main (String[] args) {
        int intervalInSeconds = 30; // Интервал в секундах

        Timer timer = new Timer ();
        timer.scheduleAtFixedRate (new TimerTask () {
            public void run () {
                String excelFolder = "src/Data/xlsx";
                String jsonFolder = "src/Data/json";

                xlsConverter worker = new xlsConverter ();
                worker.converter (excelFolder, jsonFolder);
                System.out.println ("Fisierele Ecxel au fost procesate");
            }
        }, 0, intervalInSeconds * 1000); // Переводим интервал в миллисекунды

        // Дайте циклу выполниться определенное время, например, 5 минут (300 секунд)
        try {
            Thread.sleep (300000); // Подождать 5 минут перед завершением программы
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        // Остановить таймер после заданного времени
        timer.cancel ();
        System.out.println ("Цикл завершен.");
    }
}
