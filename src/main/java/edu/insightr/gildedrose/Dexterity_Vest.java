package edu.insightr.gildedrose;

public class Dexterity_Vest extends Item{

    public Dexterity_Vest()
    {
        this.name = "+5 Dexterity Vest";
        this.quality=25;
        this.sellIn=4;
    }

    public Dexterity_Vest(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public Dexterity_Vest(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /*public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }*/

}