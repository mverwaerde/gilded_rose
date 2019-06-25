package com.gildedrose.control.quality;

import com.gildedrose.Item;

public class BackstagePassQualityControl implements QualityControl {

    public static final int ONE_EXTRA_QUALITY = 1;
    public static final int TWO_EXTRA_QUALITY = 2;
    public static final int NO_EXTRA_QUALITY = 0;
    public static final int RESET_QUALITY = 0;

    @Override
    public boolean isApplicable(Item item) {
        return item.isBackstagePasses();
    }

    @Override
    public void updateQualityFor(Item item) {
        if (item.hasLowerQualityThanMaxAuthorizedQuality()) {
            int updatedQuality = getUpdatedQuality(item);
            item.setQuality(updatedQuality);
        }
    }

    private int getUpdatedQuality(Item item) {
        if (item.hasSellInExpired()) {
            return RESET_QUALITY;
        }
        return item.getQuality() + STANDARD_QUALITY_RISE + getExtraQuality(item.getSellIn());
    }

    private int getExtraQuality(int sellIn) {
        if (concertIsWithinSixAndTenDays(sellIn)) {
            return ONE_EXTRA_QUALITY;
        } else if (concertIsInLessThanFiveDays(sellIn)) {
            return TWO_EXTRA_QUALITY;
        }
        return NO_EXTRA_QUALITY;
    }

    private boolean concertIsInLessThanFiveDays(int sellIn) {
        return sellIn <= 5;
    }

    private boolean concertIsWithinSixAndTenDays(int sellIn) {
        return sellIn <= 10 && sellIn > 6;
    }
}
