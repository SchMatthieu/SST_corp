package edu.insightr.gildedrose;


public class Elixir_of_the_Mongoose extends Item{

    public Elixir_of_the_Mongoose(int id, String name, int sellIn, int quality) {
        super(id, name, sellIn, quality);
    }

    public Elixir_of_the_Mongoose()
    {
        this.id = 5;
        this.name = "Elixir of the Mongoose";
        this.quality=0;
        this.sellIn=10;
    }
    
    public Elixir_of_the_Mongoose(String name)
    {
        this.name = name;
        this.quality=12;
        this.sellIn=17;
    }

    public void updateQuality(){
        super.updateQuality();
        if(this.quality > 0){

            this.quality = this.quality- 1;
            if (this.sellIn == 0 && this.quality> 0){
                this.quality = this.quality - 1;
            }
        }
        
    }
}
