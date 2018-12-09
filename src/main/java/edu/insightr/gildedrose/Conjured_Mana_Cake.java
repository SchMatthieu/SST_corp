package edu.insightr.gildedrose;


public class Conjured_Mana_Cake extends Item{

    public Conjured_Mana_Cake()
    {
        this.name = "Conjured Mana Cake";
        this.quality=7;
        this.sellIn=19;
    }
    public Conjured_Mana_Cake(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        super.updateQuality();
        if(getQuality() >= 2){
            setQuality(getQuality() - 2);
            if (getSellIn() == 0 && getQuality() >= 2){
                setQuality(getQuality() - 2);
            }
        }
        if(getQuality() == 1) setQuality(0);
        if(getSellIn() > 0) {
            setSellIn(getSellIn() - 1);
        }
    }
}