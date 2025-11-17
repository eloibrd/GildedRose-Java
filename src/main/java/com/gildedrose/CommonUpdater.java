package com.gildedrose;

public class CommonUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        item.quality -= getQualityDecreaseValue(item);
        item.sellIn--;
    }

    private int getQualityDecreaseValue(Item item) {
        int value;
        if (ItemCommons.isExpired(item)) {
            value = 2;
        } else {
            value = 1;
        }
        if (item.quality - value < ItemCommons.MIN_ITEM_QUALITY) {
            value = item.quality;
        }
        return value;
    }
}
