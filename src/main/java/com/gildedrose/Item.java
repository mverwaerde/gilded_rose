package com.gildedrose;

public class Item {

    private String name;

    public int sellIn;

    public int quality;

    private static int maxAuthorizedQuality = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    public boolean isNotAgedBrie() {
        return !this.name.equals("Aged Brie");
    }

    public boolean isBackstagePasses() {
        return this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isNotBackstagePasses() {
        return !this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isNotSulfuras() {
        return !this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean hasPositiveQuality() {
        return this.quality > 0;
    }

    public boolean hasLowerQualityThanMaxAuthorizedQuality() {
        maxAuthorizedQuality = 50;
        return this.quality < maxAuthorizedQuality;
    }

    public void increaseQuality() {
        this.quality = this.quality + 1;
    }

    public void decreaseQuality() {
        this.quality = this.quality - 1;
    }

    public boolean hasSellInExpired(){
        return this.sellIn < 0;
    }

    public void decreaseSellInDays(){
        this.sellIn = this.sellIn - 1;
    }


}
