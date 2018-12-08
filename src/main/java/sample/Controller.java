package sample;

import edu.insightr.gildedrose.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    @FXML
    Label listLab;

    @FXML
    Label sellinLab;

    @FXML
    Label qualityLab;

    @FXML
    Label nameLab;

    @FXML
    Label typeLab;

    @FXML
    Item[] listItem;

    @FXML
    TextField sellinField;

    @FXML
    TextField quality;

    @FXML
    TextField nameField;

    @FXML
    TextField typeField;

    @SuppressWarnings("deprecation")
    @FXML
    Button updateButton = new Button("Update");

    List<Item> listOfItem = new LinkedList<>();

    private Item fetchItem(String name) {
        Item item = null;
        for (int i = 0; i < listOfItem.size(); i++) {
            if (listOfItem.get(i).getName() == name) {
                item = listOfItem.get(i);
                break;
            }
        }
        return item;
    }

    private void displaDetail(String name) {
        try {
            Item item = fetchItem(name);
            quality.setText(item.getName());
            nameField.setText(item.getName());
            sellinField.setText(String.valueOf(item.getSellIn()));
            typeField.setText(String.valueOf(item.getClass()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update() throws Exception{

        @SuppressWarnings("deprecation")
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                Item[] items = listItem;

                for (int i = 0; i < items.length; i++) {
                    String nom = items[i].getName();
                    switch (nom) {
                        case "+5 Dexterity Vest":
                            System.out.println(items[i].toString());

                            System.out.println(items[i].toString());
                            break;

                        case "Aged Brie":
                            System.out.println(items[i].toString());

                            System.out.println(items[i].toString());
                            break;

                        case "Elixir of the Mongoose":
                            System.out.println(items[i].toString());

                            System.out.println(items[i].toString());
                            break;

                        case "Sulfuras, Hand of Ragnaros":
                            System.out.println(items[i].toString());

                            System.out.println(items[i].toString());
                            break;

                        case "Backstage passes to a TAFKAL80ETC concert":
                            System.out.println(items[i].toString());

                            System.out.println(items[i].toString());
                            break;

                        case "Conjured Mana Cake":
                            System.out.println(items[i].toString());

                            items[i].toString();
                            break;

                        default:
                            break;
                    }
                }
            }
        };
        updateButton.setOnAction(event);

    }
}


