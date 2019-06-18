package com.gildedrose.control.quality;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieQualityControlTest {

    private AgedBrieQualityControl agedBrieQualityControl = new AgedBrieQualityControl();

    @Test
    public void shouldReturnTrue_whenItemHasAgedBrieName() {
        Item agedBrie = new Item("Aged Brie", 1, 1);
        boolean result = agedBrieQualityControl.isApplicable(agedBrie);
        assertThat(result).isTrue();
    }
    
    @Test
    public void shouldAlwaysIncreaseQuality() {
        Item agedBrie = new Item("Aged Brie", 1, 2);
        agedBrieQualityControl.updateQualityFor(agedBrie);
        assertThat(agedBrie.getQuality()).isEqualTo(3);
    }

}