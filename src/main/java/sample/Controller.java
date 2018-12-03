package sample;

import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;
import javafx.fxml.FXML;

import javafx.scene.control.*;

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
    ListView<String> listItem;

    @FXML
    TextField sellinField;

    @FXML
    TextField quality;

    @FXML
    TextField nameField;

    @FXML
    TextField typeField;

    @FXML
    Button updateButton;

    Item[] listOfItem;


    private void createList()
    {
        listOfItem = new Inventory().getItems();
    }


    private Item fetchItem(String name)
    {
        Item item = null;
        for(int i = 0; i < listOfItem.length;i++)
        {
            if(listOfItem[i].getName().compareTo(name) == 0)
            {
                item = listOfItem[i];
                break;
            }
        }
        return item;
    }

    private void displaDetail(String name)
    {
        try
        {
            Item item = fetchItem(name);
            quality.setText(item.getName());
            nameField.setText(item.getName());
            sellinField.setText(String.valueOf(item.getSellIn()));
            typeField.setText(String.valueOf(item.getClass()));

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
