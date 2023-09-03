package org.FinData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;

public class JsonWorker {
    public void jsonProcessor(String jsonPathFolder) {
        File folder = new File(jsonPathFolder);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null) {
            ObjectMapper objectMapper = new ObjectMapper();

            for (File file : files) {
                try {
                    // Чтение JSON из файла и маппинг на объект JsonFile
                    JsonData finData = objectMapper.readValue(file, JsonData.class);

                    // Теперь можно использовать объект JsonFile
                    // De exemplu in redarea datelor in terminal
                    System.out.println("ID: " + finData.getDenumire ());
                    System.out.println ("Cod Fiscal: " + finData.getCodFiscal ());

                    // Calculate current Liquidity and Financial Leverage and round to 2 digits and convert
                    // to String for save in json for DB
                    float LC = Float.parseFloat (finData.getActiveCirculante ()) / Float.parseFloat (finData.getDTS ());
                    String currentLiquidity = String.format("%.2f", LC);
                    float Levier = (Float.parseFloat (finData.getDTL ()) + Float.parseFloat (finData.getDTS ()))
                            / Float.parseFloat (finData.getCapitalPropriu ());
                    String FinLeverage = String.format("%.2f", Levier);

                    // prepare here json for save in DB

                    // save in database



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }}}