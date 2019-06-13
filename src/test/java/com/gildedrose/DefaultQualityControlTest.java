package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultQualityControlTest {

    private DefaultQualityControl defaultQualityControl = new DefaultQualityControl();

    @Test
    public void shouldDecreaseQualityByOne_whenSellInIsPositive() {
        Item defaultItem = new Item("defaultItem", 2, 2);

        defaultQualityControl.updateQualityFor(defaultItem);

        assertThat(defaultItem.getQuality()).isEqualTo(1);
    }

    @Test
    public void shouldNotDecreaseQuality_whenQualityIsZero() {
        Item zeroQualityItem = new Item("DefaultItem", 1, 0);

        defaultQualityControl.updateQualityFor(zeroQualityItem);

        assertThat(zeroQualityItem.getQuality()).isEqualTo(0);
    }

    @Test
    public void shouldDecreaseTwiceQuality_whenSellInIsExpired() {
        Item expiredItem = new Item("defaultItem", -1, 6);

        defaultQualityControl.updateQualityFor(expiredItem);

        assertThat(expiredItem.getQuality()).isEqualTo(4);
    }
}