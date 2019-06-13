package com.gildedrose;

import java.util.Optional;

public class DefaultQualityControl implements QualityControl {

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(getUpdatedQuality(item));
    }

    private int getUpdatedQuality(Item item) {
        return Optional.of(item)
                .map(Item::getQuality)
                .filter(quality -> quality <= 0)
                .orElse(item.getQuality()- dropQualityValue(item));
    }

    private int dropQualityValue(Item item) {
        return item.hasSellInExpired() ? 2 : 1;
    }
}
