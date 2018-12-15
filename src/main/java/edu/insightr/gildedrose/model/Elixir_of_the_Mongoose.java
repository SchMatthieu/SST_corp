package edu.insightr.gildedrose.model;


public class Elixir_of_the_Mongoose extends Item {

    public Elixir_of_the_Mongoose(String name, int sellIn, int quality, int year, int month, int day) {
        super(name,sellIn,quality, year, month, day);
    }

    public Elixir_of_the_Mongoose()
    {
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
