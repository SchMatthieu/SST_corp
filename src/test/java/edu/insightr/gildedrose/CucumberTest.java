
package edu.insightr.gildedrose;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CucumberTest {

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
  
    @Test
    public void agedBrieQualityCheck()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        Item itemConjured = ancienneListeDesItems[0];
        assertThat(itemConjured.getName(), is("Aged Brie"));
        assertThat(itemConjured.getQuality(), is(17));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(18));
    }
  
    @Test
    public void datePassedQualityCheck()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();
        Item itemConjured = ancienneListeDesItems[3];
        assertThat(itemConjured.sellIn, is(0));
        assertThat(itemConjured.getName(), is("+5 Dexterity Vest"));
        assertThat(itemConjured.getQuality(), is(25));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(23));
    }


    @Test
    public void qualityNeverNegativeQualityCheck()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        Item itemConjured = ancienneListeDesItems[4];
        assertThat(itemConjured.getName(), is("Elixir of the Mongoose"));
        assertThat(itemConjured.getQuality(), is(0));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(0));
    }

    @Test
    public void NeverMoreThan50QualityCheck()
    {
        Inventory inv = new Inventory();
        Item[] ancienneListeDesItems = inv.getItems();

        Item itemConjured = ancienneListeDesItems[6];
        assertThat(itemConjured.getName(), is("+5 Dexterity Vest"));
        assertThat(itemConjured.getQuality(), is(50));
        inv.updateQuality();
        assertThat(itemConjured.getQuality(), is(50));
    }


}


