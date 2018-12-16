package edu.insightr.gildedrose.model;


public class Conjured_Mana_Cake extends Item {

    public Conjured_Mana_Cake()
    {
        super();
        this.name = "Conjured Mana Cake";
        this.quality=7;
        this.sellIn=19;
    }

    public Conjured_Mana_Cake(String name, int sellIn, int quality) {
        super(name,sellIn,quality);
    }
  
  public Conjured_Mana_Cake(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public void updateQuality(){
        super.updateQuality();
         if(this.quality == 1) this.quality = 0;
        
        else if(this.quality >= 2){
            
            this.quality  = this.quality  - 2;
            
            if (this.sellIn == 0 &&  this.quality >= 2){
                this.quality  = this.quality  - 2;
            }
        }
        
    }
}
