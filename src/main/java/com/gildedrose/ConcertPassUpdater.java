package com.gildedrose;

public class ConcertPassUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        if (!ItemCommons.isExpired(item)) {
            item.quality += getQualityIncreaseValue(item);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private int getQualityIncreaseValue(Item item) {
        int value;
        if (item.sellIn <= 5) {
            value = 3;
        } else if (item.sellIn <= 10) {
            value = 2;
        } else {
            value = 1;
        }
        if (item.quality + value > 50) {
            return 50 - item.quality;
        }
        return value;
    }

}
