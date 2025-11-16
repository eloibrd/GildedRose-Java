package com.gildedrose;

public class ItemUpdaterFactory {

    private ItemUpdaterFactory() {
    }

    public static ItemUdpater updaterFor(Item item) {
        if (item.name == "Aged Brie") {
            return new AgingItemUpdater();
        }
        return new CommonUpdater();
    }

}
