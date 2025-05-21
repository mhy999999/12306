package com.example.tickets;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;


class TicketsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        Random random = new Random();
        String seatLetters = "ABCDE"; // 可选字母
        String carriageNumber = "";
        String seatNumber = "";

        int temp1 = random.nextInt(16) + 1; // 1~16
        if (temp1 < 10){
            carriageNumber = "0" + temp1;
        }else {
            carriageNumber = "" + temp1;
        }
        System.out.println(carriageNumber);

        int temp2 = random.nextInt(16) + 1; // 1~16
        char seatLetter = seatLetters.charAt(random.nextInt(5)); // A~E
        if (temp2 < 10){
            seatNumber = "0" + temp2 + seatLetter;
        }else {
            seatNumber = "" + temp2 + seatLetter;
        }
        System.out.println(seatNumber);
    }
}
