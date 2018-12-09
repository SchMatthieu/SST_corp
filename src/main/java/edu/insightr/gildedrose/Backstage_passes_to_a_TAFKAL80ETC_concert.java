package edu.insightr.gildedrose;

public class Backstage_passes_to_a_TAFKAL80ETC_concert extends Item {
    public Backstage_passes_to_a_TAFKAL80ETC_concert()
    {
        this.name = "Backstage passes to a TAFKAL80ETC concert";
        this.quality=12;
        this.sellIn=17;
    }
    public Backstage_passes_to_a_TAFKAL80ETC_concert(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        super.updateQuality();
        if (this.quality < 50) {
            if (this.sellIn >= 11) {
                if (this.quality < 50) {
                    this.quality = this.quality +1;
                }
            }
            if (this.sellIn  < 11) {
                if (this.quality < 49) {

                    this.quality = this.quality +2;
                }
            }
            if (this.sellIn  < 6) {
                if (this.quality < 50) {
                    setQuality(getQuality() + 1);
                    this.quality=this.quality+1;
                }
            }
            if (this.sellIn  == 0) {//ADD
                this.quality = 0;
            }
        }
        if (this.sellIn  > 0) {
            this.sellIn = this.sellIn - 1;
        }
    }
}
