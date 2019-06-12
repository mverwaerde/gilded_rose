package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].isAgedBrie() && !items[i].isBackstagePasses()) {
                if (items[i].hasPositiveQuality() && !items[i].isSulfuras()) {
                    items[i].decreaseQuality();
                }
            } else {
                if (items[i].hasLowerQualityThanMaxAuthorizedQuality()) {
                    items[i].increaseQuality();

                    if (items[i].isBackstagePasses()) {
                        if (items[i].sellIn < 11) {
                            if (items[i].hasLowerQualityThanMaxAuthorizedQuality()) {
                                items[i].increaseQuality();
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].hasLowerQualityThanMaxAuthorizedQuality()) {
                                items[i].increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!items[i].isSulfuras()) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstagePasses()) {
                        if (items[i].hasPositiveQuality()) {
                            if (!items[i].isSulfuras()) {
                                items[i].decreaseQuality();
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].hasLowerQualityThanMaxAuthorizedQuality()) {
                        items[i].increaseQuality();
                    }
                }
            }
        }
    }

}