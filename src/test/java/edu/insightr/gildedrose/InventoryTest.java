package edu.insightr.gildedrose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class InventoryTest {

    private Inventory inv;
    private Item[] ancienneListeDesItems;

    @Before
    public void setUp() {
        inv = new Inventory();
        ancienneListeDesItems = inv.getItems();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testUpDateQualitySellInFinished() throws Exception {
        inv.updateQuality();
        Item[] items = inv.getItems();
        for( int i = 0; i<items.length; i++)
        {
            if(ancienneListeDesItems[i].getSellIn() == 0) assertEquals(ancienneListeDesItems[i].getQuality() - 2, items[i].getQuality());
        }

    }

    @Test
    public void testNeverNegative()
    {
        inv.updateQuality();
        Item[] item = inv.getItems();
        for(int i = 0; i < item.length; i++)
        {
            if(ancienneListeDesItems[i].getQuality() == 0)  assertEquals(item[i].getQuality(), 0);
        }
    }

    @Test
    public void agedBrie()
    {
        inv.updateQuality();
        Item[] item = inv.getItems();
        for(int i = 0; i < item.length; i++)
        {
            if(ancienneListeDesItems[i].getName().equals("Aged Brie"))  assertEquals(ancienneListeDesItems[i].getQuality(), item[i].getQuality()-1);
        }
    }

    @Test
    public void lessThan50()
    {
        inv.updateQuality();
        Item[] item = inv.getItems();
        for(int i = 0; i < item.length; i++)
        {
            if(ancienneListeDesItems[i].getQuality() > 50)
            {
                assertEquals(item[i].getQuality(), 50);
            }
        }
    }

    @Test
    public void Sulfuras()
    {
        inv.updateQuality();
        Item[] item = inv.getItems();
        for(int i = 0; i < item.length; i++)
        {
            if(ancienneListeDesItems[i].getName().contains("Sulfuras"))
            {
                assertEquals(ancienneListeDesItems[i].getQuality(), item[i].getQuality());
                assertEquals(item[i].getSellIn(), 0);
            }
        }
    }

    @Test
    public void BackstagePass()
    {
        inv.updateQuality();
        Item[] item = inv.getItems();
        for(int i = 0; i < item.length; i++)
        {
            if(ancienneListeDesItems[i].getName().contains("Backstage"))
            {
                if(ancienneListeDesItems[i].getSellIn() <= 10 && ancienneListeDesItems[i].getSellIn() > 5) assertEquals(ancienneListeDesItems[i].getQuality(), item[i].getQuality()-2);
                if(ancienneListeDesItems[i].getSellIn() <= 5 && ancienneListeDesItems[i].getSellIn() > 0) assertEquals(ancienneListeDesItems[i].getQuality(), item[i].getQuality()-3);
                if(ancienneListeDesItems[i].getSellIn() == 0) assertEquals(item[i],0 );
            }

        }
    }

}
