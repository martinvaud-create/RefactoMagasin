package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Comté")
                    && !items[i].name.equals("Pass VIP Concert")) {

                if (items[i].quality > 0 && !items[i].name.equals("Kryptonite")) {
                    items[i].quality--;
                }

            } else {

                if (items[i].quality < 50) {
                    items[i].quality++;

                    if (items[i].name.equals("Pass VIP Concert")) {

                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality++;
                        }

                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality++;
                        }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {

                if (!items[i].name.equals("Comté")) {

                    if (!items[i].name.equals("Pass VIP Concert")) {

                        if (items[i].quality > 0 && !items[i].name.equals("Kryptonite")) {
                            items[i].quality--;
                        }

                    } else {
                        items[i].quality = 0;
                    }

                } else {

                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }
}
