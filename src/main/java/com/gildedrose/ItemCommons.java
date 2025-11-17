package com.gildedrose;

public class ItemCommons {
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;

    private ItemCommons() {
    }

    public static boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }
}
