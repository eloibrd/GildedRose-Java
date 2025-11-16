package com.gildedrose;

public class CommonUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        if (canDecreaseQuality(item)) {
            decreaseQuality(item);
        }
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        if (isExpired(item)) {
            item.quality--;
        }
        item.quality--;
    }

    private boolean canDecreaseQuality(Item item) {
        return item.quality > 0;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
