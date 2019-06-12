package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public boolean isAgedBrie() {
        return this.name.equals("Aged Brie");
    }

    public boolean isBackstagePasses() {
        return this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
