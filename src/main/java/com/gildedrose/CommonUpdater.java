package com.gildedrose;

public class CommonUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        if (ItemCommons.canDecreaseQuality(item)) {
            decreaseQuality(item);
        }
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        if (ItemCommons.isExpired(item)) {
            item.quality--;
        }
        item.quality--;
    }
}
