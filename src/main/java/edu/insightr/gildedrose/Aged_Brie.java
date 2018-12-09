package edu.insightr.gildedrose;

public class Aged_Brie extends Item {

    public  Aged_Brie()
    {
        this.name = "Aged Brie";
        this.quality=17;
        this.sellIn=10;
    }

    public Aged_Brie(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public Aged_Brie(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


}
