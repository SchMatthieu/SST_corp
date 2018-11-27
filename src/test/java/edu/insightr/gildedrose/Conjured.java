package edu.insightr.gildedrose;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class Conjured {

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

