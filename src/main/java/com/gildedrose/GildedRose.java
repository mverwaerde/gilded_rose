package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].isNotAgedBrie() && !items[i].isBackstagePasses()) {
                if (items[i].hasPositiveQuality() && items[i].isNotSulfuras()) {
                    items[i].decreaseQuality();
                }
            } else {
                if (items[i].hasLowerQualityThanMaxAuthorizedQuality()) {
                    items[i].increaseQuality();

                    if (items[i].isBackstagePasses()) {
                        manageBackstagePassesQuality(items[i]);
                    }
                }
            }

            if (items[i].isNotSulfuras()) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].hasSellInExpired()) {
                manageSellInExpiredItem(items[i]);
            }
        }
    }

    private void manageSellInExpiredItem(Item item) {
        if (item.isNotAgedBrie()) {
            if (!item.isBackstagePasses()) {
                if (item.hasPositiveQuality()) {
                    if (item.isNotSulfuras()) {
                        item.decreaseQuality();
                    }
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
                item.increaseQuality();
            }
        }
    }

    private void manageBackstagePassesQuality(Item item) {
        if (item.sellIn < 11) {
            if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
                item.increaseQuality();
            }
        }

        if (item.sellIn < 6) {
            if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
                item.increaseQuality();
            }
        }
    }

}