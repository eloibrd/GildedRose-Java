package com.gildedrose;

public class LegendaryItemUpdater implements ItemUdpater {

    @Override
    public void update(Item item) {
        item.quality = 80;
        item.sellIn = 0;
    }

}
