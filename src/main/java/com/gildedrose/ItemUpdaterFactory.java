package com.gildedrose;

public class ItemUpdaterFactory {

    private ItemUpdaterFactory() {
    }

    public static ItemUdpater updaterFor(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgingItemUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new ConcertPassUpdater();
            default:
                return new CommonUpdater();
        }
    }

}
