package sample;

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

    List<Item> listOfItem = new LinkedList<>();


    private Item fetchItem(String name)
    {
        Item item = null;
        for(int i = 0; i < listOfItem.size();i++)
        {
            if(listOfItem.get(i).getName().compareTo(name) == 0)
            {
                item = listOfItem.get(i);
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
            quality.setText(String.valueOf(item.getQuality()));
            nameField.setText(item.getName());
            sellinField.setText(String.valueOf(item.getSellIn()));
            String[] tmp = String.valueOf(item.getClass()).split("\\.");
            typeField.setText(tmp[tmp.length-1]);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
