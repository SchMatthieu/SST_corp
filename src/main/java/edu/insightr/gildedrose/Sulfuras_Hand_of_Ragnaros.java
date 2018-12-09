package edu.insightr.gildedrose;

public class Sulfuras_Hand_of_Ragnaros extends Item{

    public Sulfuras_Hand_of_Ragnaros()
    {
        this.name = "Sulfuras, Hand of Ragnaros";
        this.quality=15;
        this.sellIn=15;
    }

    public Sulfuras_Hand_of_Ragnaros(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public Sulfuras_Hand_of_Ragnaros(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

}