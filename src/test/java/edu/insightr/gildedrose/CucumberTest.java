
package edu.insightr.gildedrose;

import edu.insightr.gildedrose.model.Inventory;
import edu.insightr.gildedrose.model.Item;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CucumberTest {

    @Test
    public void addJSONFile()
    {
        Inventory inv = new Inventory();

        assertThat(inv.getItems().length, is(6));
        //read JSON
        assertThat(inv.getItems().length, is(10));
    }

    @Test
    public void truthWorthy()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        inv.proportion();
        int prop = inv.getProportion()[2];
        assertThat(prop, is(1));
    }

    @Test
    public void update()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        Item itemConjured = ancienneListeDesItems[3];
        assertThat(itemConjured.getName(), is("+5 Dexterity Vest"));
        assertThat(itemConjured.getQuality(), is(25));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(23));
    }


   @Test
    public void qualityCheck()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        Item itemConjured = ancienneListeDesItems[5];
        assertThat(itemConjured.getName(), is("Conjured Mana Cake"));
        assertThat(itemConjured.getQuality(), is(6));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(4));
    }
  


}


