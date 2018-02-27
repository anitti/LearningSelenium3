package ru.mycompany;

import java.util.Random;

public class RandomizeHelper {
    public static String getRandomString(Integer lengthString) {
        Random r = new Random();
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String str = "";

        for (int i = 0; i < lengthString; i++) {
            str = str +  eng.charAt(r.nextInt(eng.length()));
        }

        return str;
    }

    public static String getRandomStringInt(Integer lengthString) {
        Random r = new Random();
        String dig = "0123456789";
        String str = "";

        for (int i = 0; i < lengthString; i++) {
            str = str +  dig.charAt(r.nextInt(dig.length()));
        }

        return str;
    }

    public static String getRandomEmail() {
        String email = getRandomString(5) + "@" + getRandomString(3) + "." + getRandomString(3);
        return email;
    }

    public static String getRandomElementFromArray(String[] array) {
            int rnd = new Random().nextInt(array.length);
            return array[rnd];
    }
}
