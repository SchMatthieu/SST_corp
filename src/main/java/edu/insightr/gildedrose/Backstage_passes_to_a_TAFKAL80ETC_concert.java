package edu.insightr.gildedrose;


public class Backstage_passes_to_a_TAFKAL80ETC_concert extends Item{


    public Backstage_passes_to_a_TAFKAL80ETC_concert()
    {
        this.id = 2;
        this.name = "Backstage passes to a TAFKAL80ETC concert";
        this.quality=12;
        this.sellIn=17;
    }

    public Backstage_passes_to_a_TAFKAL80ETC_concert(int id, String name, int sellIn, int quality) {
        super(id, name, sellIn, quality);
    }
  
  public Backstage_passes_to_a_TAFKAL80ETC_concert(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public void updateQuality() {
        super.updateQuality();
        if (this.quality <= 49 && this.sellIn > 10) {

            this.quality = this.quality +1;
        }
        else if (this.sellIn  <= 10 && this.sellIn  > 5 && this.quality <= 48) {
            this.quality = this.quality +2;
        }
        else if (this.sellIn  <= 5 && this.quality <= 47) {
            
                this.quality=this.quality+3;
            
        }
        if (this.sellIn  == 0) {
            this.quality = 0;
        }
    }
}

