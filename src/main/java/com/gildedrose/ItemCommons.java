package com.gildedrose;

public class ItemCommons {

    private ItemCommons() {
    }

    public static boolean canDecreaseQuality(Item item) {
        return item.quality > 0;
    }

    public static boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }

    public static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
