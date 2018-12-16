package edu.insightr.gildedrose;

public class Sulfuras_Hand_of_Ragnaros extends Item{

    public Sulfuras_Hand_of_Ragnaros(int id, String name, int sellIn, int quality) {
        super(id, name, sellIn, quality);
    }
  
  public Sulfuras_Hand_of_Ragnaros(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }
  
  public Sulfuras_Hand_of_Ragnaros()
    {
        this.id = 6;
        this.name = "Sulfuras, Hand of Ragnaros";
        this.quality=80;
        this.sellIn=20;
    }
  

    @Override
    public void setSellIn(int sellIn) {

    }
    //This item has not to be sold

    public void updateQuality(){
        super.updateQuality();
        
    }
    //Its quality never change


}
