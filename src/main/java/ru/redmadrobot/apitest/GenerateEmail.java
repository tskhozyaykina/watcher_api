package ru.redmadrobot.apitest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateEmail {
    private final static Random r = new Random();

    public static String generate(int nickLength, int domainLength) {
        StringBuilder builder = new StringBuilder();
        while (nickLength-- > 0) {
            builder.append(getRandomLetter());
        }

        builder.append('@');

        while (domainLength-- > 0) {
            builder.append(getRandomLetter());
        }

        builder.append(".com");

        return builder.toString();
    }


    public static Character getRandomLetter() {
        return (char) (r.nextInt(26) + 'a');
    }

    public static String getRandomEmail(int loginLenght, int domainLenght) {
        System.out.println(RandomStringUtils.random(5, 2, 10, true, false).toLowerCase() + "@" + RandomStringUtils.random(5, true, false).toLowerCase() + ".ru");
       /* byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        System.out.println(generatedString);*/
        return "d";
    }

    public static String getRandomEmail() {
        StringBuilder randomEmail = new StringBuilder();
        List<String> domain = Arrays.asList("ru", "com", "org", "info");

        randomEmail.append(RandomStringUtils.random(RandomUtils.nextInt(2, 10), true, false).toLowerCase())
                .append("@")
                .append(RandomStringUtils.random(RandomUtils.nextInt(2, 10), true, false).toLowerCase())
                .append(".")
                .append(domain.get(RandomUtils.nextInt(0, domain.size() - 1)));

        return randomEmail.toString();
    }
}


