package com.gildedrose.control.quality;

import com.gildedrose.Item;

public class AgedBrieQualityControl implements QualityControl {


    @Override
    public boolean isApplicable(Item item) {
        return item.isAgedBrie();
    }

    @Override
    public void updateQualityFor(Item item) {
        int updatedQuality = getIncreasedQuality(item.getQuality());
        item.setQuality(updatedQuality);
    }

    private int getIncreasedQuality(int quality) {
        if (quality < MAX_QUALITY_ALLOWED) {
            return quality + STANDARD_QUALITY_RISE;
        }
        return quality;
    }
}
