package com.gildedrose;

public class ItemBuilder {

    private Item item;

    public ItemBuilder() {
        this.item = new Item("common item", 0, 0);
    }

    public ItemBuilder named(String name) {
        this.item.name = name;
        return this;
    }

    public ItemBuilder withQuality(int quality) {
        // ensure quality is within boundaries
        if (quality < 0) {
            this.item.quality = 0;
            return this;
        }
        if (quality > 50) {
            this.item.quality = 50;
            return this;
        }
        this.item.quality = quality;
        return this;
    }

    public ItemBuilder expiresIn(int expiration) {
        this.item.sellIn = expiration;
        return this;
    }

    public Item build() {
        // explicitly set legendary items quality to 80
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.item.quality = 80;
        }
        return this.item;
    }
}
