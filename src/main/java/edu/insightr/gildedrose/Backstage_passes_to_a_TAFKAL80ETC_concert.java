package edu.insightr.gildedrose;

public class Backstage_passes_to_a_TAFKAL80ETC_concert extends Item{

    public Backstage_passes_to_a_TAFKAL80ETC_concert()
    {
        this.name = "Backstage passes to a TAFKAL80ETC concert";
        this.quality=12;
        this.sellIn=17;
    }

    public Backstage_passes_to_a_TAFKAL80ETC_concert(String name, int sellIn, int quality)
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