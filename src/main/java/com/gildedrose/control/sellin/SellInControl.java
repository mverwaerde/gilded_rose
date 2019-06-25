package com.gildedrose.control.sellin;

import com.gildedrose.Item;

public class SellInControl {

    public void updateSellIn(Item item) {
        if (item.isNotSulfuras()) {
            item.decreaseSellInDays();
        }
    }
}
