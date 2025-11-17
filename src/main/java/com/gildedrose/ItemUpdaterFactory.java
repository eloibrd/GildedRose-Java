package com.gildedrose;

public class ItemUpdaterFactory {

    private ItemUpdaterFactory() {
    }

    public static ItemUdpater updaterFor(Item item) {
        if (ItemCommons.isAging(item))
            return new AgingItemUpdater();

        if (ItemCommons.isConcertPass(item))
            return new ConcertPassUpdater();

        if (ItemCommons.isLegendary(item))
            return new LegendaryItemUpdater();

        return new CommonUpdater();
    }

}
