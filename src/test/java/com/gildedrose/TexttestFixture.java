package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new ItemBuilder().named("+5 Dexterity Vest").expiresIn(10).withQuality(20).build(), //
                new ItemBuilder().named("Aged Brie").expiresIn(2).withQuality(0).build(), //
                new ItemBuilder().named("Elixir of the Mongoose").expiresIn(5).withQuality(7).build(), //
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(0).withQuality(80).build(), //
                new ItemBuilder().named("Sulfuras, Hand of Ragnaros").expiresIn(-1).withQuality(80).build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(15)
                        .withQuality(20).build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(10).withQuality(49)
                        .build(),
                new ItemBuilder().named("Backstage passes to a TAFKAL80ETC concert").expiresIn(5).withQuality(49)
                        .build(),
                // this conjured item does not work properly yet
                new ItemBuilder().named("Conjured Mana Cake").expiresIn(3).withQuality(6).build()
        };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
