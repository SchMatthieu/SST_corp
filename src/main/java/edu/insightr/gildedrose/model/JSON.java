package edu.insightr.gildedrose.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public static void WriteItem(Item i){

        JSONObject tmp = new JSONObject();
        JSONObject listAttributes = new JSONObject();

        listAttributes.put("name", i.getName());
        listAttributes.put("sellIn", i.getSellIn());
        listAttributes.put("quality", i.getQuality());
        tmp.put("",listAttributes);

        /*tmp.put("name", i.getName());
        tmp.put("sellIn", i.getSellIn());
        tmp.put("quality", i.getQuality());
        */

        try (FileWriter file = new FileWriter("test.json")) {

            file.write(tmp.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.print(tmp);
    }


    public static void ReadJson(String nameFile, Item[] ancienneListeDesItems, Inventory inventory){
        List<Item> item = new ArrayList<Item>();
        JSONParser parser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(nameFile));
            for(Object o : jsonArray) {

                LocalDate today = LocalDate.now();
                String time = String.valueOf(today);
                String[] temp = time.split("-");
                int year = Integer.valueOf(temp[0]);
                int month = Integer.valueOf(temp[2]);
                int day = Integer.valueOf(temp[1]);

                JSONObject jsonObject = (JSONObject) o;
                //   System.out.println(jsonObject);

                String name = (String) jsonObject.get("name");
                // System.out.println(name);

                String type = (String) jsonObject.get("type");
                //System.out.println(name);

                int sellIn = (int) (long) jsonObject.get("sellIn");
                //System.out.println(sellIn);

                int quality = (int) (long) jsonObject.get("quality");
                //System.out.println(quality);

                if (type.compareTo("Aged_Brie") == 0) {
                    Aged_Brie NewAgedBrie = new Aged_Brie(name, sellIn, quality);
                    item.add(NewAgedBrie);
                }
                else  if (type.compareTo("Backstage_passes_to_a_TAFKAL80ETC_concert") == 0) {
                    Backstage_passes_to_a_TAFKAL80ETC_concert NewBackstage = new Backstage_passes_to_a_TAFKAL80ETC_concert(type, sellIn, quality);
                    item.add(NewBackstage);
                }
                else  if (type.compareTo("Conjured_Mana_Cake") == 0) {

                    Conjured_Mana_Cake NewConjured = new Conjured_Mana_Cake(name, sellIn, quality);
                    item.add(NewConjured);
                }
                else if (type.compareTo("Dexterity_Vest") == 0) {

                    Dexterity_Vest NewDexterity = new Dexterity_Vest(name, sellIn, quality);
                    item.add(NewDexterity);
                }
                else  if (type.compareTo("Elixir_of_the_Mongoose") == 0) {

                    Elixir_of_the_Mongoose NewElixir = new Elixir_of_the_Mongoose(name, sellIn, quality);
                    item.add(NewElixir);
                }
                else  if (type.compareTo("Sulfuras_Hand_of_Ragnaros") == 0) {
                    Sulfuras_Hand_of_Ragnaros NewSulfura = new Sulfuras_Hand_of_Ragnaros(name, sellIn, quality);
                    item.add(NewSulfura);
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



}
