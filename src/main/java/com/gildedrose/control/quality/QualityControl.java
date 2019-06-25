package com.gildedrose.control.quality;

import com.gildedrose.Item;

public interface QualityControl {

    int STANDARD_QUALITY_RISE = 1;

    int MAX_QUALITY_ALLOWED = 50;


    boolean isApplicable(Item item);

    void updateQualityFor(Item item);
}
