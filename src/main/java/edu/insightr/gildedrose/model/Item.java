package edu.insightr.gildedrose.model;

import java.time.LocalDate;

public abstract class Item {

    protected String name;
    protected int sellIn;

    protected int quality;

    protected LocalDate date;

    public Item() {
        super();
        this.name = "Object";
        this.sellIn = 25;
        this.quality = 17;
        this.date = LocalDate.of(2018, 10, 1);
    }
    public Item(String name, int sellIn, int quality, int year, int month, int day) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.date = LocalDate.of(year, month, day);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
    public void updateQuality()
    {

    }

}