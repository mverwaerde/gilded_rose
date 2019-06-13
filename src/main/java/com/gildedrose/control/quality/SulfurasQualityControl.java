package com.gildedrose.control.quality;

import com.gildedrose.Item;

public class SulfurasQualityControl implements QualityControl {
    @Override
    public boolean isApplicable(Item item) {
        return item.isSulfuras();
    }

    @Override
    public void updateQualityFor(Item item) {

    }
}
