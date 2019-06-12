package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItem() {
        Arrays.stream(items).filter(Item::isNotSulfuras)
                .forEach(this::manageItemQualityAndSellInDays);
    }

    private void manageItemQualityAndSellInDays(Item item) {
        manageItemQuality(item);
        item.decreaseSellInDays();
        if (item.hasSellInExpired()) {
            manageQualityFromSellInExpiredItem(item);
        }
    }

    private void manageItemQuality(Item item) {
        if (item.isNotAgedBrie() && item.isNotBackstagePasses()) {
            if (item.hasPositiveQuality()) {
                item.decreaseQuality();
            }
        } else {
            if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
                item.increaseQuality();

                if (item.isBackstagePasses()) {
                    manageBackstagePassesQuality(item);
                }
            }
        }
    }

    private void manageQualityFromSellInExpiredItem(Item item) {
        if (item.isAgedBrie()) {
            if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
                item.increaseQuality();
            }
        } else {
            if (item.isNotBackstagePasses() && item.hasPositiveQuality()) {
                item.decreaseQuality();
            } else {
                item.quality = item.quality - item.quality;
            }
        }
    }

    private void manageBackstagePassesQuality(Item item) {
        if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
            if (item.sellIn < 11) {
                item.increaseQuality();
            }

            if (item.sellIn < 6) {
                item.increaseQuality();
            }
        }
    }
}