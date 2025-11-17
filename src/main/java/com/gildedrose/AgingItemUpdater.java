package com.gildedrose;

public class AgingItemUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        item.quality += getQualityIncreaseValue(item);
        item.sellIn--;
    }

    private int getQualityIncreaseValue(Item item) {
        int value;
        if (ItemCommons.isExpired(item)) {
            value = 2;
        } else {
            value = 1;
        }
        if (item.quality + value > ItemCommons.MAX_ITEM_QUALITY) {
            return ItemCommons.MAX_ITEM_QUALITY - item.quality;
        }
        return value;
    }

}
