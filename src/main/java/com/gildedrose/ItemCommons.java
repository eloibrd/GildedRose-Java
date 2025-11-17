package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemCommons {
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;

    private static final ArrayList<String> AGING_ITEMS = new ArrayList<>(Arrays.asList("Aged Brie"));
    private static final ArrayList<String> CONCERT_PASS_ITEMS = new ArrayList<>(
            Arrays.asList("Backstage passes to a TAFKAL80ETC concert"));
    private static final ArrayList<String> LEGENDARY_ITEMS = new ArrayList<>(
            Arrays.asList("Sulfuras, Hand of Ragnaros"));

    private ItemCommons() {
    }

    public static boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    public static boolean isAging(Item item) {
        return AGING_ITEMS.contains(item.name);
    }

    public static boolean isConcertPass(Item item) {
        return CONCERT_PASS_ITEMS.contains(item.name);
    }

    public static boolean isLegendary(Item item) {
        return LEGENDARY_ITEMS.contains(item.name);
    }
}
