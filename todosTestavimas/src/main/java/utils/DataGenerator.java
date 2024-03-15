package utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    static Faker faker = new Faker();
    public static String getRandomHamlet(){
        return faker.shakespeare().hamletQuote();
    }
    public static String getRandomQuote(){
        return faker.matz().quote();
    }
}
