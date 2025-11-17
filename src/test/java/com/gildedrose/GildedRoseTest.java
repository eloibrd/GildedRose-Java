package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    // region random items
    @Test
    void assertAnyItemQualityInsideBoundariesAtCreation() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Any item").expiresIn(1).withQuality(-6).build(),
                new ItemBuilder().named("Any item").expiresIn(1).withQuality(55).build(),
        };
        assertEquals(0, items[0].quality);
        assertEquals(50, items[1].quality);
    }

    @Test
    void assertAnyItemQualityNotBelowZero() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Any item").expiresIn(1).withQuality(0).build(),
                new ItemBuilder().named("Any item").expiresIn(-1).withQuality(0).build(),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void assertAnyItemQualityDecreasesBeforeSellIn() {
        Item[] items = new Item[] { new ItemBuilder().named("Any item").expiresIn(3).withQuality(3).build() };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void assertAnyItemQualityDecreasesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new ItemBuilder().named("Any item").expiresIn(-1).withQuality(3).build() };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void assertAnyItemSellInDecreases() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Any item").expiresIn(3).withQuality(0).build(),
                new ItemBuilder().named("Any item").expiresIn(1).withQuality(0).build(),
                new ItemBuilder().named("Any item").expiresIn(-1).withQuality(0).build(),
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
                new ItemBuilder().named("Aged Brie").expiresIn(5).withQuality(10).build(),
                new ItemBuilder().named("Aged Brie").expiresIn(-5).withQuality(10).build(),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(-6, app.items[1].sellIn);
    }

    @Test
    void assertAgedBrieQualityAugmentsBeforeSellIn() {
        Item[] items = new Item[] { new ItemBuilder().named("Aged Brie").expiresIn(5).withQuality(10).build(), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void assertAgedBrieQualityAugmentsTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new ItemBuilder().named("Aged Brie").expiresIn(-1).withQuality(10).build(), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void assertAgedBrieQualityStopsAugmentingPastLimit() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Aged Brie").expiresIn(5).withQuality(50).build(),
                new ItemBuilder().named("Aged Brie").expiresIn(-5).withQuality(50).build(),
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
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(15).withQuality(0)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(10).withQuality(0)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(5).withQuality(0)
                        .build(),
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
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(0).withQuality(30)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(-1).withQuality(0)
                        .build(),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void assertConcertQualityStopsAugmentingPastLimit() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(15).withQuality(50)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(10).withQuality(50)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(5).withQuality(50)
                        .build(),
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
    void assertLegendaryQualityIsProperlySet() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(5).withQuality(110)
                        .build(),
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(-5).withQuality(-30)
                        .build(),
        };
        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
    }

    @Test
    void assertLegendaryQualityNeverChanges() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(5).withQuality(80)
                        .build(),
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(-5).withQuality(80)
                        .build(),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
    }

    @Test
    void assertLegendarySellInNeverChanges() {
        Item[] items = new Item[] {
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(5).withQuality(80)
                        .build(),
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(-5).withQuality(80)
                        .build(),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(-5, app.items[1].sellIn);
    }
    // endregion
}
