package edu.insightr.gildedrose.controller;

import edu.insightr.gildedrose.model.Inventory;
import edu.insightr.gildedrose.model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField textfield_name;
    @FXML
    TextField textfield_sellin;
    @FXML
    TextField textfield_quality;
    @FXML
    TextField typeField;
    @FXML
    ListView<String> list_items;
    @FXML
    PieChart pie;
    @FXML
    Button addButton;

    public Inventory inventory;

    public void initialize(URL location, ResourceBundle resources) {
        fetchItems();
        list_items.getSelectionModel().selectedItemProperty().addListener(e->
                displayItemsDetails(list_items.getSelectionModel().getSelectedItem()));
        pieChart();
    }
    private Item fetchItemByName(String name)
    {
        Item item = null;
        for(int i = 0; i < this.inventory.getItems().length;i++)
        {
            if(this.inventory.getItems()[i].getName().compareTo(name) == 0)
            {
                item = this.inventory.getItems()[i];
                break;
            }
        }
        return item;
    }

    public void fetchItems(){
        this.inventory = new Inventory();

        ObservableList<String> listItems;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < inventory.getItems().length;i++)
        {
            list.add(inventory.getItems()[i].getName());
        }
        listItems = FXCollections.observableArrayList(list);
        list_items.setItems(listItems);
    }
    private void displayItemsDetails(Object o)
    {
        try
        {
            String name = (String) o;
            Item item = fetchItemByName(name);
            textfield_quality.setText(String.valueOf(item.getQuality()));
            textfield_name.setText(item.getName());
            textfield_sellin.setText(String.valueOf(item.getSellIn()));
            String[] tmp = String.valueOf(item.getClass()).split("\\.");
            typeField.setText(tmp[tmp.length-1]);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void updateQuality()
    {
        this.inventory.updateQuality();
        displayItemsDetails(inventory);
    }

    public void pieChart()
    {
        this.inventory.proportion();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Aged_Brie", this.inventory.getProportion()[0]),
                new PieChart.Data("Backstage_passes_to_a_TAFKAL80ETC_concert", this.inventory.getProportion()[1]),
                new PieChart.Data("Conjured_Mana_Cake", this.inventory.getProportion()[2]),
                new PieChart.Data("Dexterity_Vest", this.inventory.getProportion()[3]),
                new PieChart.Data("Elixir_of_the_Mongoose", this.inventory.getProportion()[4]),
                new PieChart.Data("Sulfuras_Hand_of_Ragnaros", this.inventory.getProportion()[5]));

        pie.setData(pieChartData);
        pie.setLegendSide(Side.BOTTOM);
        pie.setLabelLineLength(100);
        pie.setLabelsVisible(true);
        pie.setTitle("Proportion of each item");


    }

    public void addButton()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose a file");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            chooser.getSelectedFile();
        } else {
            System.out.println("No Selection ");
        }


    }
    public void deleteButton(){
        int selectedIdx = list_items.getSelectionModel().getSelectedIndex();
        list_items.getItems().remove(selectedIdx);
        Item[] tmp = new Item[this.inventory.getItems().length-1];
        for(int i = 0; i < tmp.length; i ++)
        {
            if(i < selectedIdx)
            {
                tmp[i] = this.inventory.getItems()[i];
            }
            else if(i > selectedIdx)
            {
                tmp[i] = this.inventory.getItems()[i+1];
            }

        }
        this.inventory.setItems(tmp);
    }


    }





