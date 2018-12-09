package edu.insightr.gildedrose;


public class Aged_Brie extends Item {

    public  Aged_Brie()
    {
        this.name = "Aged Brie";
        this.quality=17;
        this.sellIn=10;
    }


    public Aged_Brie(String name, int sellIn, int quality) {
        super(name,sellIn,quality);

    }
  
  public Aged_Brie(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }
  
    public void updateQuality()
    { super.updateQuality();
        if (this.sellIn > 0) {
            this.sellIn = this.sellIn - 1;
        }
        if (this.quality < 50) {
            this.quality = this.quality +1;
        }

    }

}

