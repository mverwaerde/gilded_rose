package com.gildedrose;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].isNotSulfuras()) {
                manageItemQuality(items[i]);
                items[i].decreaseSellInDays();

                if (items[i].hasSellInExpired()) {
                    manageSellInExpiredItem(items[i]);
                }
            }
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

    private void manageSellInExpiredItem(Item item) {
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