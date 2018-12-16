package edu.insightr.gildedrose.model;


public class Aged_Brie extends Item {

    public  Aged_Brie()
    {
        super();
        this.name = "Aged Brie";
        this.quality=17;
        this.sellIn=10;
    }


    public Aged_Brie(String name, int sellIn, int quality, int year, int month, int day) {
        super(name,sellIn,quality, year, month, day);

    }
  
  public Aged_Brie(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }
  
    public void updateQuality()
    { super.updateQuality();
      
        if (this.quality < 50) {
            this.quality = this.quality +1;
        }

    }

}

