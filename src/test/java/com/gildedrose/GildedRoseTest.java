package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    // region random items
    @Test
    void assertAnyItemQualityNotBelowZero() {
        Item[] items = new Item[] {
                new Item("Any Item", 1, 0),
                new Item("Any Item", -1, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void assertAnyItemQualityDecreasesBeforeSellIn() {
        Item[] items = new Item[] { new Item("Any Item", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void assertAnyItemQualityDecreasesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("Any Item", -1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void assertAnyItemSellInDecreases() {
        Item[] items = new Item[] {
                new Item("Any Item", 3, 0),
                new Item("Any Item", 1, 0),
                new Item("Any Item", -1, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(-2, app.items[2].sellIn);
    }

    // endregion
    // region Aged Brie
    @Test
    void assertAgedBrieSellInDecreases() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 10),
                new Item("Aged Brie", -5, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(-6, app.items[1].sellIn);
    }

    @Test
    void assertAgedBrieQualityAugmentsBeforeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void assertAgedBrieQualityAugmentsTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void assertAgedBrieQualityStopsAugmentingPastLimit() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 50),
                new Item("Aged Brie", -5, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    // endregion
    // region Concert
    @Test
    void assertConcertQualityAugmentsBeforeSellIn() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(2, app.items[1].quality);
        assertEquals(3, app.items[2].quality);
    }

    @Test
    void assertConcertQualitySetsToZeroAfterSellIn() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void assertConcertQualityStopsAugmentingPastLimit() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

    // endregion
    // region Sulfuras

    @Test
    void assertSulfurasQualityNeverChanges() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 5, 80),
                new Item("Sulfuras, Hand of Ragnaros", -5, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
    }

    @Test
    void assertSulfurasSellInNeverChanges() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 5, 80),
                new Item("Sulfuras, Hand of Ragnaros", -5, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(-5, app.items[1].sellIn);
    }
    // endregion
}
