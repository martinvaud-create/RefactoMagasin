package com.magasin;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() throws IOException {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        int version = 1;
        File file;
        while (true) {
            file = new File("Version" + version + ".txt");
            if (!file.exists()) {
                break;
            }
            version++;
        }

        FileWriter writer = new FileWriter(file);
        for (Item item : items) {
            writer.write("name" + item.name + ", quality" + item.quality + ", sellIn" + item.sellIn + "\n");
        }
        writer.close();
        System.out.println("File " + file.getName() + " created successfully.");
    }
}
