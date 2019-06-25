package com.gildedrose.control.sellin;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellInControlTest {

    private SellInControl sellInControl = new SellInControl();

    @Test
    public void shouldDecreaseSellIn() {
        Item item = new Item("Standard Item", 2, 2);
        sellInControl.updateSellIn(item);
        assertThat(item.getSellIn()).isEqualTo(1);
    }

    @Test
    public void shouldNotDecrease_whenSulfuraItem() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 2, 2);
        sellInControl.updateSellIn(item);
        assertThat(item.getSellIn()).isEqualTo(2);
    }
}