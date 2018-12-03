package edu.insightr.gildedrose;


public class Conjured_Mana_Cake extends Item{

    public Conjured_Mana_Cake()
    {
        this.name = "Conjured Mana Cake";
        this.quality=7;
        this.sellIn=19;
    }

    public Conjured_Mana_Cake(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /* public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
*/
}