package edu.insightr.gildedrose;

public class Inventory {

    private Item[] items;

    public Item[] getItems() {
        return items;
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
                new Dexterity_Vest("+5 Dexterity Vest", 14, 50)
        };

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




    }

