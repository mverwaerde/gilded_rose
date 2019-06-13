package com.gildedrose.control.quality;

import com.gildedrose.Item;

import java.util.Optional;

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
        return Optional.of(item)
                .map(Item::getQuality)
                .filter(this::isPositiveOrNull)
                .orElse(item.getQuality() - dropQualityValue(item));
    }

    private boolean isPositiveOrNull(Integer quality) {
        return quality <= 0;
    }

    private int dropQualityValue(Item item) {
        if (item.hasSellInExpired()) {
            return DROP_QUALITY_VALUE * 2;
        }
        return DROP_QUALITY_VALUE;
    }
}
