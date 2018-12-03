package edu.insightr.gildedrose;

public class Elixir_of_the_Mongoose extends Item {

    public Elixir_of_the_Mongoose()
    {
        this.name = "Elixir of the Mongoose";
        this.quality=9;
        this.sellIn=10;
    }

    public Elixir_of_the_Mongoose(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

  /*  public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }*/

}