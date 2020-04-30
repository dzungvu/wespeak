package com.juzung.wespeak.utils;

import com.juzung.wespeak.models.PlaylistItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by VTDung on 5/1/20.
 */
public class Utils {

    /**
     * Load samples item FOR TEST ONLY
     *
     * @return list of test items
     */
    public static ArrayList<PlaylistItem> loadSamples() {
        ArrayList<PlaylistItem> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new PlaylistItem(
                            "",
                            random(),
                            randomColor(),
                            ""
                    )
            );
        }
        return data;
    }

    /**
     * Random text for title - FOR TEST ONLY
     *
     * @return String
     */
    private static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(20);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    private static String randomColor() {
        Random random = new Random();

        // create a big random number - maximum is ffffff (hex) = 16777215 (dez)
        int nextInt = random.nextInt(0xffffff + 1);

        // format it as hexadecimal string (with hash tag and leading zeros)

        return String.format("#%06x", nextInt);
    }
}
