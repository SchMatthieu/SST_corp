
package edu.insightr.gildedrose.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Inventory {



    private Item[] items;

    private int[] tabProportion;

    private int[] tabSellIn;
    private LocalDate[] tabDate;

    public Item[] getItems() {
        return items;
    }

    public int[] getProportion()
    {
        return this.tabProportion;
    }


    public void setItems(Item[] items)
    {
        this.items = items;
    }

    public int[] getTabSellIn()
    {
        return this.tabSellIn;
    }

    public LocalDate[] getTabDate()
    {
        return this.tabDate;
    }


    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Aged_Brie(),
                new Backstage_passes_to_a_TAFKAL80ETC_concert(),
                new Conjured_Mana_Cake(),
                new Dexterity_Vest(),
                new Elixir_of_the_Mongoose(),
                new Sulfuras_Hand_of_Ragnaros(),
                new Aged_Brie("new Aged Brie", 14, 50, 2018, 7, 30)
        };
        this.tabProportion = new int[6];
        this.tabSellIn = new int[0];
        this.tabDate = new LocalDate[0];
    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {

        this.updateSellin();

        for(int i = 0; i < items.length; i++) {

            items[i].updateQuality();

        }
    }

    public void updateSellin()
    {
        for(int i = 0; i < items.length; i++)
        {
            if(items[i].getSellIn()>0) items[i].setSellIn(items[i].getSellIn() - 1);
        }
    }

    public void proportion(Item[] tab)
    {
        String[] type = { "Aged_Brie", "Backstage_passes_to_a_TAFKAL80ETC_concert",
                "Conjured_Mana_Cake", "Dexterity_Vest", "Elixir_of_the_Mongoose", "Sulfuras_Hand_of_Ragnaros"};

        for(int i = 0; i < tabProportion.length; i++)
        {
            this.tabProportion[i]=0;
        }
        for(int i = 0; i < this.tabProportion.length; i++)
        {
            for(int j = 0; j < tab.length; j++)
            {
                if(String.valueOf(tab[j].getClass()).split("\\.")[4].compareTo(type[i])==0)
                {
                    this.tabProportion[i]++;
                }
            }
        }
    }

    public LinkedList<Integer> presence()
    {
        LinkedList<Integer> count = new LinkedList<>();

        for(int i = 0; i < this.items.length; i++)
        {
            boolean pres = false;
            for(int j = 0; j < count.size(); j++)
            {
                if(this.items[i].sellIn == count.get(j))
                {
                    pres = true;
                    break;
                }
            }
            if(pres== false) {
                count.add(this.items[i].sellIn);
            }
        }
        return count;
    }

    public int[] getSellInOfAllItem()
    {
        LinkedList<Integer> count = presence();
        int[] tab1 = new int[count.size()];
        int[] tab2 = new int[count.size()];

         for(int j = 0; j < count.size(); j++)
         {
             tab1[j] = count.get(j);
         }

        for(int i = 0; i < this.items.length; i++)
        {
            for(int j = 0; j < tab2.length; j++)
            {
                if(tab1[j] == this.items[i].sellIn)
                {
                    tab2[j]++;
                    break;
                }
            }
        }
        this.tabSellIn = tab1;
        return tab2;
    }


    public LinkedList<LocalDate> presenceDate()
    {
        LinkedList<LocalDate> count = new LinkedList<>();

        for(int i = 0; i < this.items.length; i++)
        {
            boolean pres = false;
            for(int j = 0; j < count.size(); j++)
            {
                if(this.items[i].date.compareTo(count.get(j)) == 0)
                {
                    pres = true;
                    break;
                }
            }
            if(pres== false) {
                count.add(this.items[i].date);
            }
        }
        return count;
    }

    public int[] LocalDateCount()
    {
        LinkedList<LocalDate> count = presenceDate();
        LocalDate[] tab1 = new LocalDate[count.size()];
        int[] tab2 = new int[count.size()];

        for(int j = 0; j < count.size(); j++)
        {
            tab1[j] = count.get(j);
        }

        for(int i = 0; i < this.items.length; i++)
        {
            for(int j = 0; j < tab2.length; j++)
            {
                if(tab1[j].compareTo(this.items[i].date) == 0)
                {
                    tab2[j]++;
                    break;
                }
            }
        }
        this.tabDate = tab1;
        return tab2;
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
    public void proportion(Item[] tab)
    {
        String[] type = { "Aged_Brie", "Backstage_passes_to_a_TAFKAL80ETC_concert",
                "Conjured_Mana_Cake", "Dexterity_Vest", "Elixir_of_the_Mongoose", "Sulfuras_Hand_of_Ragnaros"};

        for(int i = 0; i < tabProportion.length; i++)
        {
            this.tabProportion[i]=0;
        }
        for(int i = 0; i < this.tabProportion.length; i++)
        {
            for(int j = 0; j < tab.length; j++)
            {
                if(String.valueOf(tab[j].getClass()).split("\\.")[4].compareTo(type[i])==0)
                {
                    this.tabProportion[i]++;
                }
            }
        }
    }
}

