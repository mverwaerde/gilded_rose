package com.gildedrose.control.quality;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfuraQualityControlTest {

    SulfuraQualityControl sulfuraQualityControl = new SulfuraQualityControl();

    @Test
    public void shouldBeApplicable_whenSulfuraItemName() {
        Item SulfuraItem = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        boolean result = sulfuraQualityControl.isApplicable(SulfuraItem);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldNotBeApplicable_whenSulfuraItemName() {
        Item agedBrieItem = new Item("Aged Brie", 10, 10);
        boolean result = sulfuraQualityControl.isApplicable(agedBrieItem);
        assertThat(result).isFalse();
    }
}