package edu.insightr.gildedrose.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public void WriteItems(Item[] items){

        JSONArray listItems = new JSONArray();

        for(int i = 0; i < items.length; i++)
        {
            JSONObject listAttributes = new JSONObject();

            String[] tmp = String.valueOf(items[i].getClass()).split("\\.");

            listAttributes.put("ID", items[i].getId());
            listAttributes.put("type", tmp[tmp.length-1]);
            listAttributes.put("name", items[i].getName());
            listAttributes.put("sellIn", items[i].getSellIn());
            listAttributes.put("quality", items[i].getQuality());

            listItems.add(listAttributes);
        }

        try (FileWriter file = new FileWriter("test.json")) {

            file.write(listItems.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + listItems);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadJson(String nameFile, Item[] ancienneListeDesItems, Inventory inventory){
        List<Item> item = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(nameFile));
            for(Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;

                String name = (String) jsonObject.get("name");

                String type = (String) jsonObject.get("type");

                int id = (int) (long) jsonObject.get("ID");
                int sellIn = (int) (long) jsonObject.get("sellIn");
                int quality = (int) (long) jsonObject.get("quality");

                Item tmp = null;
                boolean exist = false;

                if (type.compareTo("Aged_Brie") == 0) {
                    tmp = new Aged_Brie(id, name, sellIn, quality);
                }
                else  if (type.compareTo("Backstage_passes_to_a_TAFKAL80ETC_concert") == 0) {
                    tmp = new Backstage_passes_to_a_TAFKAL80ETC_concert(id, name, sellIn, quality);
                }
                else  if (type.compareTo("Conjured_Mana_Cake") == 0) {
                    tmp = new Conjured_Mana_Cake(id, name, sellIn, quality);
                }
                else if (type.compareTo("Dexterity_Vest") == 0) {
                    tmp = new Dexterity_Vest(id, name, sellIn, quality);
                }
                else  if (type.compareTo("Elixir_of_the_Mongoose") == 0) {

                    tmp = new Elixir_of_the_Mongoose(id, name, sellIn, quality);
                }
                else  if (type.compareTo("Sulfuras_Hand_of_Ragnaros") == 0) {
                    tmp = new Sulfuras_Hand_of_Ragnaros(id, name, sellIn, quality);
                }
                if(verifItem(tmp, inventory))
                {
                    exist = true;
                }
                if(!exist)
                {
                    item.add(tmp);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Item[] tmp = new Item[ancienneListeDesItems.length + item.size()];
        for(int i = 0; i < ancienneListeDesItems.length; i++)
        {
            tmp[i] = ancienneListeDesItems[i];
        }
        for(int i = 0; i < item.size(); i++)
        {
            tmp[i+ancienneListeDesItems.length] = item.get(i);
        }

        inventory.setItems(tmp);

    }

    static boolean verifItem(Item item, Inventory inventory) {
        boolean found = false;
        for (int i = 0; i < inventory.getItems().length; i++) {
            if (inventory.getItems()[i].getId() == item.getId()) {
                found = true;
                break;
            }
        }
        return found;
    }






}
