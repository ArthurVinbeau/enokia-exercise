package fr.vinbeau;

import java.util.ArrayList;
import java.util.List;

public class BillboardMaker {
    static int getTextSize(Billboard billboard) {
        // Check constraints
        if (billboard.getHeight() < 0 || billboard.getHeight() > 1000)
            throw new RuntimeException("height must respect 1 <= H <= 1000");
        if (billboard.getWidth() < 0 || billboard.getWidth() > 1000)
            throw new RuntimeException("width must respect 1 <= W <= 1000");
        if (billboard.getText().length() == 0)
            throw new RuntimeException("text must contain at least one character");

        // 20 6 hacker cup
        // Get words and their lengths
        final String[] words = billboard.getText().split(" ");
        List<String> lines = new ArrayList<>();
        lines.add("");

        // Try incrementing values of size
        int size = 0;
        boolean shouldBreak = false;
        while (!shouldBreak) {
            size++;

            int line = 0;
            for (var word : words) {
                // If the word doesn't fit alone
                if (word.length() * size > billboard.getWidth()) {
                    shouldBreak = true;
                    break;
                }

                // If we have remaining space on the line
                if ((lines.get(line).length() + word.length()) * size <= billboard.getWidth()) {
                    lines.set(line, lines.get(line) + word + " ");
                } else {
                    line++;
                    if (line * size > billboard.getHeight()) {
                        shouldBreak = true;
                        break;
                    }

                    // add a new line
                    lines.add(word);
                }
            }

            if (shouldBreak) size--;
        }

        return size;
    }

}
