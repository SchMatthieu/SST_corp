package edu.insightr.gildedrose;

public class Elixir_of_the_Mongoose extends Item {

    public Elixir_of_the_Mongoose()
    {
        this.name = "Elixir of the Mongoose";
        this.quality=0;
        this.sellIn=10;
    }

    public Elixir_of_the_Mongoose(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public Elixir_of_the_Mongoose(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


}