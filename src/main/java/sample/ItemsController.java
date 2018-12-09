package sample;

import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ItemsController {
    @FXML
    TextField textfield_name;
    @FXML
    TextField textfield_sellin;
    @FXML
    TextField textfield_quality;
    @FXML
    ListView<String> list_items;
    @FXML
    Label label_list;
    @FXML
    Label label_sellin;
    @FXML
    Label label_quality;
    @FXML
    Label label_name;
    @FXML
    Button button_upgrade;

    Inventory inventory;

    public void initialize(URL location, ResourceBundle resources) {
        fetchItems();
        list_items.getSelectionModel().selectedItemProperty().addListener(e->
                displayItemsDetails(list_items.getSelectionModel().getSelectedItem()));
    }
    private Item fetchItemByName(String name)
    {
        Item item = null;
        for(int i = 0; i < inventory.getItems().length;i++)
        {
            if(inventory.getItems()[i].getName().compareTo(name) == 0)
            {
                item = inventory.getItems()[i];
                break;
            }
        }
        return item;
    }
    public void fetchItems(){
        ObservableList<String> listItems;
        List<String> list = new ArrayList<>();
        for(int i =0; i < inventory.getItems().length;i++)
        {
            list.add(inventory.getItems()[i].getName());
        }
        listItems = FXCollections.observableArrayList(list);
        list_items.setItems(listItems);
    }

    private void displayItemsDetails(String name)
    {
        try
        {
            Item item = fetchItemByName(name);
            textfield_quality.setText(String.valueOf(item.getQuality()));
            textfield_name.setText(item.getName());
            textfield_sellin.setText(String.valueOf(item.getSellIn()));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
