package com.gildedrose;

import java.util.List;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private String name;

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


    public boolean isNotAgedBrie() {
        return !isAgedBrie();
    }

    public boolean isAgedBrie() {
        return this.name.equals(AGED_BRIE);
    }

    public boolean isBackstagePasses() {
        return this.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    public boolean isNotBackstagePasses() {
        return !this.isBackstagePasses();
    }

    public boolean isNotSulfuras() {
        return !this.isSulfuras();
    }

    public boolean isSulfuras() {
        return this.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    public boolean hasPositiveQuality() {
        return this.quality > 0;
    }

    public boolean isDefaultItem() {
        List<String> specialItems = List.of(AGED_BRIE, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, SULFURAS_HAND_OF_RAGNAROS);
        return specialItems.stream().noneMatch(s -> s.equals(this.name));
    }

    public boolean hasLowerQualityThanMaxAuthorizedQuality() {
        int maxAuthorizedQuality = 50;
        return this.quality < maxAuthorizedQuality;
    }

    public void increaseQuality() {
        this.quality = this.quality + 1;
    }

    public void decreaseQuality() {
        this.quality = this.quality - 1;
    }

    public boolean hasSellInExpired() {
        return this.sellIn <= 0;
    }

    public void decreaseSellInDays() {
        this.sellIn = this.sellIn - 1;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
