package com.gildedrose.control.quality;

import com.gildedrose.Item;

public interface QualityControl {

    boolean isApplicable(Item item);

    void updateQualityFor(Item item);
}
