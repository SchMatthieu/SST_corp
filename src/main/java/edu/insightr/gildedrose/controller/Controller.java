package edu.insightr.gildedrose.controller;

import edu.insightr.gildedrose.model.*;
import javafx.application.Platform;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller  {

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
    @FXML
    Button btnDelete;
    @FXML
    Button btnAdd;
    @FXML
    private ResourceBundle resource;
    @FXML
    private URL location;
    @FXML
    Button btnSave;
    @FXML
    Button btnCancel;
    @FXML
    ComboBox cmbType;
    @FXML
    Button pieChartButton;
    @FXML
    Button barChartButton1;
    @FXML
    Button barChartButton2;
    @FXML
    BarChart bar1;
    @FXML
    public Button closeButton;
    @FXML
    BarChart bar2;
    @FXML
    TextField textfield_id;
    @FXML
    LineChart lineChartSell;
    @FXML
    LineChart lineChartBuy;
    @FXML
    Button lineChartButtonSell;
    @FXML
    Button lineChartButtonBuy;


    public Inventory inventory = new Inventory();
    public Historique historique = new Historique();

    public void initialize() {
        List<String> tValues = new ArrayList<String>();
        tValues.add("Aged_Brie");
        tValues.add("Backstage_passes_to_a_TAFKAL80ETC_concert");
        tValues.add("Conjured_Mana_Cake");
        tValues.add("Dexterity_Vest");
        tValues.add("Elixir_of_the_Mongoose");
        tValues.add("Sulfuras_Hand_of_Ragnaros");
        ObservableList<String> gender = FXCollections.observableArrayList(tValues);
        cmbType.setItems(gender);
        fetchItems();
        list_items.getSelectionModel().selectedItemProperty().addListener(e->
                displayItemsDetails(list_items.getSelectionModel().getSelectedItem()));

        pieChart();
        barChartSellIn();
        barChartDate();
        bar1.setVisible(false);
        bar2.setVisible(false);
        pie.setVisible(true);
        lineChartBuy.setVisible(false);
        lineChartSell.setVisible(false);
        lineChartBoughtItems();
        lineChartSoldItems();
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
            textfield_id.setText(String.valueOf(item.getId()));
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
        historique.addDay();
        initialize();
    }

    public void pieChart()
    {
        this.inventory.proportion(this.inventory.getItems());
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

    public void addButton() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose a file");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String[] test = String.valueOf(chooser.getSelectedFile()).split("\\\\");
            String path = test[test.length-1];
            System.out.println(path);
            JSON.ReadJson(path, this.inventory.getItems(), this.inventory);
        } else {
            System.out.println("No Selection ");
        }
        fetchItems();
        pieChart();

    }

    public void deleteButton()
    {
        this.inventory.setItems(SoldButton());
        initialize();
    }

    public Item[] SoldButton()
    {
        int selectedIdx = list_items.getSelectionModel().getSelectedIndex();
        Item deleteObject = fetchItemByName(list_items.getSelectionModel().getSelectedItem());
        Item[] newList = new Item[inventory.getItems().length - 1];
        for(int i = 0 ; i <newList.length; i++)
        {
            newList[i] = inventory.getItems()[i];

            if( newList[i] == deleteObject)
            {
                for(int j = selectedIdx ; j < newList.length; j++) {
                    newList[j] = inventory.getItems()[j + 1];
                }
                break;
            }
        }
        historique.soldItem(deleteObject);
        return newList;
    }

    public void onNew(){
        btnSave.setDisable(false);
        btnCancel.setDisable(false);

        pieChartButton.setDisable(true);
        lineChartButtonBuy.setDisable(true);
        lineChartButtonSell.setDisable(false);
        barChartButton1.setDisable(true);
        barChartButton2.setDisable(true);
        addButton.setDisable(true);

        textfield_id.setText(null);
        cmbType.setValue(null);
        textfield_name.setText(null);
        textfield_sellin.setText(null);
        textfield_quality.setText(null);
    }

    public void onSave(){
        Item tmp = null;
        boolean exist = false;

        if(cmbType.getValue() == "Aged_Brie")
        {
            tmp = new Aged_Brie(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }
        if(cmbType.getValue() == "Backstage_passes_to_a_TAFKAL80ETC_concert")
        {
            tmp = new Backstage_passes_to_a_TAFKAL80ETC_concert(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }
        if(cmbType.getValue() == "Conjured_Mana_Cake")
        {
            tmp = new Conjured_Mana_Cake(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }
        if(cmbType.getValue() == "Dexterity_Vest")
        {
            tmp = new Dexterity_Vest(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }
        if(cmbType.getValue() == "Elixir_of_the_Mongoose")
        {
            tmp = new Elixir_of_the_Mongoose(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }
        if(cmbType.getValue() == "Sulfuras_Hand_of_Ragnaros")
        {
            tmp = new Sulfuras_Hand_of_Ragnaros(Integer.valueOf(textfield_id.getText()), textfield_name.getText(), Integer.valueOf(textfield_sellin.getText()), Integer.valueOf(textfield_quality.getText()));
            if(verifItem(tmp))
            {
                exist = true;
            }
        }

        if(!exist)
        {
            onCancel();
            inventory.setItems(addList(tmp));
            historique.boughtItem(tmp);
            initialize();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The entered ID already corresponds to another item...");
        }

        pieChartButton.setDisable(false);
        lineChartButtonBuy.setDisable(false);
        lineChartButtonSell.setDisable(false);
        barChartButton1.setDisable(false);
        barChartButton2.setDisable(false);
        addButton.setDisable(false);
    }

    public boolean verifItem(Item item){
        boolean found = false;
        for(int i = 0; i < inventory.getItems().length; i++)
        {
            if(inventory.getItems()[i].getId() == item.getId())
            {
                found = true;
                break;
            }
        }

        return found;
    }

    public void onCancel(){
        btnSave.setDisable(true);
        btnCancel.setDisable(true);

        pieChartButton.setDisable(false);
        lineChartButtonSell.setDisable(false);
        lineChartButtonBuy.setDisable(false);
        barChartButton1.setDisable(false);
        barChartButton2.setDisable(false);
        addButton.setDisable(false);
    }

    public Item[] addList(Item item){
        Item[] newList = new Item[inventory.getItems().length + 1];
        for(int i = 0; i < inventory.getItems().length; i++)
        {
            newList[i] = inventory.getItems()[i];
        }
        newList[newList.length - 1] = item;

        return newList;
    }


    public void setPieChartButton()
    {
        bar1.setVisible(false);
        bar2.setVisible(false);
        pie.setVisible(true);
        lineChartBuy.setVisible(false);
        lineChartSell.setVisible(false);
    }

    public void setBarChartButton1()
    {
        bar1.setVisible(true);
        bar2.setVisible(false);
        pie.setVisible(false);
        lineChartBuy.setVisible(false);
        lineChartSell.setVisible(false);
    }

    public void setBarChartButton2()
    {
        bar1.setVisible(false);
        bar2.setVisible(true);
        pie.setVisible(false);
        lineChartBuy.setVisible(false);
        lineChartSell.setVisible(false);
    }

    public void setLineChartButtonBuy()
    {
        bar1.setVisible(false);
        bar2.setVisible(false);
        pie.setVisible(false);
        lineChartBuy.setVisible(true);
        lineChartSell.setVisible(false);
    }

    public void setLineChartButtonSell()
    {
        bar1.setVisible(false);
        bar2.setVisible(false);
        pie.setVisible(false);
        lineChartBuy.setVisible(false);
        lineChartSell.setVisible(true);
    }

    public void setCloseButton()
    {
        Platform.exit();
    }

    public void barChartDate()
    {
        bar1.getData().clear();
        int[] tab = this.inventory.LocalDateCount();
        int i = 0;
        while(i < this.inventory.LocalDateCount().length)
        {
            XYChart.Series series1 = new XYChart.Series();
            series1.getData().add(new XYChart.Data(String.valueOf(this.inventory.getTabDate()[i]), tab[i]));
            bar1.getData().add(series1);
            i++;
        }
    }

    public void barChartSellIn()
    {
        bar2.getData().clear();
        int i = 0;
        int[] tab = this.inventory.getSellInOfAllItem();
        while(i < this.inventory.getSellInOfAllItem().length)
        {
            XYChart.Series series1 = new XYChart.Series();
            series1.getData().add(new XYChart.Data(String.valueOf(this.inventory.getTabSellIn()[i]), tab[i]));
            bar2.getData().add(series1);
            i++;
        }
    }

    public void lineChartBoughtItems(){
        lineChartBuy.getData().clear();

        lineChartBuy.setTitle("Buy History");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Days");
        yAxis.setLabel("Number of items bought");

        XYChart.Series seriesAgedBrie = new XYChart.Series();
        seriesAgedBrie.setName("Aged Brie");
        int i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesAgedBrie.getData().add(new XYChart.Data("Day "+ i, nbItemsBought(boughtItems, "Aged_Brie")));
            i++;
        }

        XYChart.Series seriesBackstage = new XYChart.Series();
        seriesBackstage.setName("Backstage passes");
        i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesBackstage.getData().add(new XYChart.Data("Day " + i, nbItemsBought(boughtItems, "Backstage_passes_to_a_TAFKAL80ETC_concert")));
            i++;
        }

        XYChart.Series seriesConjured = new XYChart.Series();
        seriesConjured.setName("Conjured Mana Cake");
        i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesConjured.getData().add(new XYChart.Data("Day " + i, nbItemsBought(boughtItems, "Conjured_Mana_Cake")));
            i++;
        }

        XYChart.Series seriesDexterity = new XYChart.Series();
        seriesDexterity.setName("Dexterity Vest");
        i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesDexterity.getData().add(new XYChart.Data("Day " + i, nbItemsBought(boughtItems, "Dexterity_Vest")));
            i++;
        }

        XYChart.Series seriesElixir = new XYChart.Series();
        seriesElixir.setName("Elixir of the Mongoose");
        i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesElixir.getData().add(new XYChart.Data("Day " + i, nbItemsBought(boughtItems, "Elixir_of_the_Mongoose")));
            i++;
        }

        XYChart.Series seriesSulfuras = new XYChart.Series();
        seriesSulfuras.setName("Sulfuras");
        i = 0;
        for(List<Item> boughtItems : historique.getHistoriqueAchat())
        {
            seriesSulfuras.getData().add(new XYChart.Data("Day " + i, nbItemsBought(boughtItems, "Sulfuras_Hand_of_Ragnaros")));
            i++;
        }

        lineChartBuy.getData().addAll(seriesAgedBrie, seriesBackstage, seriesConjured, seriesDexterity, seriesElixir, seriesSulfuras);

    }

    public void lineChartSoldItems(){
        lineChartSell.getData().clear();

        lineChartSell.setTitle("Sales History");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Days");
        yAxis.setLabel("Number of items bought");

        XYChart.Series seriesAgedBrie = new XYChart.Series();
        seriesAgedBrie.setName("Aged Brie");
        int i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesAgedBrie.getData().add(new XYChart.Data("Day "+ i, nbItemsSold(soldItems, "Aged_Brie")));
            i++;
        }

        XYChart.Series seriesBackstage = new XYChart.Series();
        seriesBackstage.setName("Backstage passes");
        i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesBackstage.getData().add(new XYChart.Data("Day " + i, nbItemsSold(soldItems, "Backstage_passes_to_a_TAFKAL80ETC_concert")));
            i++;
        }

        XYChart.Series seriesConjured = new XYChart.Series();
        seriesConjured.setName("Conjured Mana Cake");
        i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesConjured.getData().add(new XYChart.Data("Day " + i, nbItemsSold(soldItems, "Conjured_Mana_Cake")));
            i++;
        }

        XYChart.Series seriesDexterity = new XYChart.Series();
        seriesDexterity.setName("Dexterity Vest");
        i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesDexterity.getData().add(new XYChart.Data("Day " + i, nbItemsSold(soldItems, "Dexterity_Vest")));
            i++;
        }

        XYChart.Series seriesElixir = new XYChart.Series();
        seriesElixir.setName("Elixir of the Mongoose");
        i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesElixir.getData().add(new XYChart.Data("Day " + i, nbItemsSold(soldItems, "Elixir_of_the_Mongoose")));
            i++;
        }

        XYChart.Series seriesSulfuras = new XYChart.Series();
        seriesSulfuras.setName("Sulfuras");
        i = 0;
        for(List<Item> soldItems : historique.getHistoriqueVente())
        {
            seriesSulfuras.getData().add(new XYChart.Data("Day " + i, nbItemsSold(soldItems, "Sulfuras_Hand_of_Ragnaros")));
            i++;
        }

        lineChartSell.getData().addAll(seriesAgedBrie, seriesBackstage, seriesConjured, seriesDexterity, seriesElixir, seriesSulfuras);

    }

    public int nbItemsSold(List<Item> listItemsSold, String typeItem){
        int nb = 0;
        for(Item item : listItemsSold)
        {
            String[] tmp = String.valueOf(item.getClass()).split("\\.");
            if(tmp[tmp.length-1].compareTo(typeItem) == 0)
            {
                nb++;
            }
        }

        return nb;
    }

    public int nbItemsBought(List<Item> listItemsBought, String typeItem){
        int nb = 0;
        for(Item item : listItemsBought)
        {
            String[] tmp = String.valueOf(item.getClass()).split("\\.");
            if(tmp[tmp.length-1].compareTo(typeItem)==0)
            {
                nb++;
            }
        }

        return nb;
    }


}


