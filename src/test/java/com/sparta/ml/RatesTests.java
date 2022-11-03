package com.sparta.ml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.ml.pojo.Rates.Rates;
import com.sparta.ml.pojo.Rates.RatesPojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class RatesTests {
    Rates rates;
    static RatesPojo ratesPojo;
    static ObjectMapper mapper = new ObjectMapper();
    @BeforeAll
    static void setUp() {
        try {
            ratesPojo = mapper.readValue(new File("src/main/resources/rates.json"),
                    RatesPojo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Check that base rates is three letters")
    void checkThatBaseRateIsThreeLetters() {
        Assertions.assertEquals(3, ratesPojo.getBase().length());
    }

    @Test
    @DisplayName("Check that Base Rates Is Capitalized")
    void checkThatBaseRateIsCapitalized() {
        Assertions.assertEquals(ratesPojo.getBase().toUpperCase(), ratesPojo.getBase());
    }

    @Test
    @DisplayName("Check that the date is the correct format")
    void checkThatTheDateIsTheCorrectFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assertions.assertEquals(LocalDate.parse(ratesPojo.getDate(), formatter).toString(), ratesPojo.getDate());
    }

    @Test
    @DisplayName("Check that the date is in the past")
    void checkThatTheDateIsInThePast() {
        Assertions.assertTrue(LocalDate.parse(ratesPojo.getDate()).isBefore(LocalDate.now()));
    }

    @Test
    @DisplayName("Check that isSuccess is true")
    void checkThatIsSuccessIsTrue() {
        Assertions.assertTrue(ratesPojo.isSuccess());
    }

    @Test
    @DisplayName("Check that rates are capitalized")
    void checkThatRatesAreCapitalized() {
        Assertions.assertEquals(ratesPojo.getRates().getBND().toString().toUpperCase(), ratesPojo.getRates().getBND().toString());
        Assertions.assertEquals(ratesPojo.getRates().getCZK().toString().toUpperCase(), ratesPojo.getRates().getCZK().toString());
        Assertions.assertEquals(ratesPojo.getRates().getIQD().toString().toUpperCase(), ratesPojo.getRates().getIQD().toString());
        Assertions.assertEquals(ratesPojo.getRates().getAED().toString().toUpperCase(), ratesPojo.getRates().getAED().toString());
        Assertions.assertEquals(ratesPojo.getRates().getMKD().toString().toUpperCase(), ratesPojo.getRates().getMKD().toString());
    }


}