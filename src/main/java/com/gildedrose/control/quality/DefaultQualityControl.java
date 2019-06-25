package com.gildedrose.control.quality;

import com.gildedrose.Item;

public class DefaultQualityControl implements QualityControl {

    private static int DROP_QUALITY_VALUE = 1;

    @Override
    public boolean isApplicable(Item item) {
        return item.isDefaultItem();
    }

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(getUpdatedQuality(item));
    }

    private int getUpdatedQuality(Item item) {
        if (item.hasPositiveQuality()) {
            return item.getQuality() - dropQualityValue(item);
        }
        return item.getQuality();
    }

    private int dropQualityValue(Item item) {
        if (item.hasSellInExpired()) {
            return DROP_QUALITY_VALUE * 2;
        }
        return DROP_QUALITY_VALUE;
    }
}
