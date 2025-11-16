package com.gildedrose;

public class AgingItemUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        if (ItemCommons.canIncreaseQuality(item)) {
            increaseQuality(item);
        }
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (ItemCommons.isExpired(item)) {
            item.quality++;
        }
        item.quality++;
    }

}
