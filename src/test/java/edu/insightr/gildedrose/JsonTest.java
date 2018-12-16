package edu.insightr.gildedrose;

import edu.insightr.gildedrose.model.Inventory;
import edu.insightr.gildedrose.model.Item;
import edu.insightr.gildedrose.model.JSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.json.simple.*;


public class JsonTest {

    protected Inventory inv = new Inventory();
    Item[] ancienneListeDesItems = inv.getItems();


    @Test
    public void testIfAllObjectAreLoaded() throws Exception
    {
        Item[] items = inv.getItems();
        int lengthInv = items.length;
        int lengthJSON = 16;
       // JSON.ReadJson("test.json");
      //  assertEquals(inv.getItems().length, lengthJSON + lengthInv);
    }
}
