
package edu.insightr.gildedrose;

import edu.insightr.gildedrose.model.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CucumberTest {

    @Test
    public void addJSONFile()
    {
        Inventory inv = new Inventory();

        assertThat(inv.getItems().length, is(7));
        JSON.ReadJson("test.json", inv.getItems(), inv);
        assertThat(inv.getItems().length, is(9));
    }

    @Test
    public void truthWorthyPie()
    {
        Inventory inv = new Inventory();

        inv.proportion(inv.getItems());
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
    public void addButton()
    {
        Inventory inventory = new Inventory();
        assertThat(inventory.getItems().length, is(6));
        Item item = new Dexterity_Vest();
        Item[] newList = new Item[inventory.getItems().length + 1];
        for(int i = 0; i < inventory.getItems().length; i++)
        {
            newList[i] = inventory.getItems()[i];
        }
        newList[newList.length - 1] = item;
        inventory.setItems(newList);

        assertThat(inventory.getItems().length, is(7));
    }

    @Test
    public void deleteButton()
    {
        Inventory inventory = new Inventory();

        assertThat(inventory.getItems().length, is(7));
        Item[] tmp = new Item[inventory.getItems().length-1];
        int selectedIdx = 1;
        for(int i = 0; i < tmp.length; i ++)
        {
            if(i < selectedIdx)
            {
                tmp[i] = inventory.getItems()[i];
            }
            else if(i > selectedIdx)
            {
                tmp[i] = inventory.getItems()[i+1];
            }

        }
        inventory.setItems(tmp);
        assertThat(inventory.getItems().length, is(6));
    }


}


