package edu.insightr.gildedrose;

public class Sulfuras_Hand_of_Ragnaros extends Item{

    public Sulfuras_Hand_of_Ragnaros(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
  
  public Sulfuras_Hand_of_Ragnaros(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }
  
  public Sulfuras_Hand_of_Ragnaros()
    {
        this.name = "Sulfuras, Hand of Ragnaros";
        this.quality=15;
        this.sellIn=15;
    }
  

    

    public void updateQuality(){
        super.updateQuality();
        if(this.quality != 80) this.quality = 80;
        if(this.sellIn != 0) this.sellIn = 0;
    }


    

    public Sulfuras_Hand_of_Ragnaros(String name, int sellIn, int quality)
    {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}