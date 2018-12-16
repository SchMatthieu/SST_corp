package edu.insightr.gildedrose;


public class Aged_Brie extends Item {

    public  Aged_Brie()
    {
        this.id = 1;
        this.name = "Aged Brie";
        this.quality=17;
        this.sellIn=10;
    }


    public Aged_Brie(int id, String name, int sellIn, int quality) {
        super(id,name,sellIn,quality);
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

