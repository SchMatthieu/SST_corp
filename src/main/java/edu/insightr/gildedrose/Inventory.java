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
 /*
        this.updateSellin();

        for(int i = 0; i < items.length; i++) {

            String[] type = String.valueOf(items[i].getClass()).split("\\.");
            switch (type[type.length-1]) {
                case "Dexterity_Vest":
                    (Dexterity_Vest)items[i].updateQuality();
                    break;

                case "Aged_Brie":
                    (Aged_Brie)items[i].updateQuality();
                    break;

                case "Elixir_of_the_Mongoose":
                    (Elixir_of_the_Mongoose)items[i].updateQuality();
                    break;

                case "Sulfuras_Hand_of_Ragnaros":
                    (Sulfuras_Hand_of_Ragnaros)items[i].updateQuality();
                    break;

                case "Backstage_passes_to_a_TAFKAL80ETC_concert":
                    (Backstage_passes_to_a_TAFKAL80ETC_concert)items[i].updateQuality();
                    break;

                case "Conjured_Mana_Cake":
                    (Conjured_Mana_Cake)items[i].updateQuality();
                    break;

                default:
                    break;
            }
        }*/
    }

    public void updateSellin()
    {
        for(int i = 0; i < items.length; i++)
        {
            items[i].setSellIn(items[i].getSellIn() - 1);
        }
    }


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
