package sample;

import edu.insightr.gildedrose.Item;
import javafx.fxml.FXML;

import javafx.scene.control.*;


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

    private void displaDetail(String name)
    {
        try
        {
            Item item = new Item();
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
