package com.gildedrose;

public class ItemUpdaterFactory {

    private ItemUpdaterFactory() {
    }

    public static ItemUdpater updaterFor() {
        return new CommonUpdater();
    }

}
