package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    @Ignore
    public void dummyTest() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(Integer.MIN_VALUE);
        assertThat(items[0].sellIn).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void shouldDecreaseOnceSellIn_whenStandardItem() {
        Item[] items = new Item[]{new Item("standard item", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
        assertThat(items[0].sellIn).isEqualTo(-1);
    }

    @Test
    public void shouldDecreaseOnceQuality_WhenStandardItemWithPositiveQuality() {
        Item[] items = new Item[]{new Item("standard item", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
    }

    @Test
    public void shouldIncreaseTwiceQuality_whenAgedBrieItem() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(3);
        assertThat(items[0].sellIn).isEqualTo(-1);
    }

    @Test
    public void shouldDecreaseSellInAndQuality_whenBackstagePassesItem() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
        assertThat(items[0].sellIn).isEqualTo(-1);
    }


    @Test
    public void shouldNotModify_whenSulfurasItem() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(1);
        assertThat(items[0].sellIn).isEqualTo(0);
    }

    @Test
    public void shouldDecreaseOnceAgainQuality_whenSellInOutdated() {
        Item[] items = new Item[]{new Item("Standard item", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(48);
        assertThat(items[0].sellIn).isEqualTo(-1);
    }

    @Test
    public void shouldIncreaseTwiceQuality_whenBackStagePassesAndSellInPositive() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(47);
        assertThat(items[0].sellIn).isEqualTo(9);
    }
}