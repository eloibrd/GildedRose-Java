package com.gildedrose;

public class ConjuredItemUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        item.quality -= getQualityDecreaseValue(item);
        item.sellIn--;
    }

    private int getQualityDecreaseValue(Item item) {
        int value;
        if (ItemCommons.isExpired(item)) {
            value = 4;
        } else {
            value = 2;
        }
        if (item.quality - value < ItemCommons.MIN_ITEM_QUALITY) {
            value = item.quality;
        }
        return value;
    }
}
