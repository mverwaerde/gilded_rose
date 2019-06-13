package com.gildedrose.control.quality;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasQualityControlTest {

    SulfurasQualityControl sulfurasQualityControl = new SulfurasQualityControl();

    @Test
    public void shouldBeApplicable_whenSulfuraItemName() {
        Item SulfuraItem = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        boolean result = sulfurasQualityControl.isApplicable(SulfuraItem);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldNotBeApplicable_whenSulfuraItemName() {
        Item agedBrieItem = new Item("Aged Brie", 10, 10);
        boolean result = sulfurasQualityControl.isApplicable(agedBrieItem);
        assertThat(result).isFalse();
    }

    @Test
    public void shouldNotDecreaseQuality_whenSulfuraItem() {
        Item sulfuraItem = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        sulfurasQualityControl.updateQualityFor(sulfuraItem);
        assertThat(sulfuraItem.getQuality()).isEqualTo(10);
    }
}