package com.gildedrose.control.quality;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassQualityControlTest {

    private QualityControl backstagePassQualityControl = new BackstagePassQualityControl();

    @Test
    public void shouldBeApplicable_whenBackstagePassNamedItem() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        boolean result = backstagePassQualityControl.isApplicable(backstagePass);
        assertThat(result).isTrue();
    }
    
    
    @Test
    public void shouldIncreaseTwiceQuality_whenSellInValueIsLessThanTen() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 1);
        backstagePassQualityControl.updateQualityFor(backStagePass);
        assertThat(backStagePass.getQuality()).isEqualTo(3);
    }

    @Test
    public void shouldIncreaseThreeTimesQuality_whenSellInValueIsLessThanFive() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 1);
        backstagePassQualityControl.updateQualityFor(backStagePass);
        assertThat(backStagePass.getQuality()).isEqualTo(4);
    }

    @Test
    public void shouldSetQualityToZero_whenSellInValueIsOverdue() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1);
        backstagePassQualityControl.updateQualityFor(backStagePass);
        assertThat(backStagePass.getQuality()).isEqualTo(0);
    }


    @Test
    public void shouldIncreaseOnceQuality_whenSellInValueIsAboveTen() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 1);
        backstagePassQualityControl.updateQualityFor(backStagePass);
        assertThat(backStagePass.getQuality()).isEqualTo(2);
    }
}