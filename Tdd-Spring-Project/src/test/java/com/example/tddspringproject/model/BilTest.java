package com.example.tddspringproject.model;

import com.example.tddspringproject.service.BilManipulator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BilTest {

    BilManipulator bilManipulator;

    @Autowired
    public BilTest(BilManipulator bilManipulator) {
        this.bilManipulator = bilManipulator;
    }


    @Test
    void lightIsOn() {

        Bil testbil = new Bil();
        assertThat(testbil.lightsOn).isFalse();
        testbil = bilManipulator.lightOn(testbil);
        assertThat(testbil.lightsOn).isTrue();
    }

    @Test
    void lightIsOff() {

        Bil testbil = new Bil();
        testbil = bilManipulator.lightOff(testbil);
        assertThat(testbil.lightsOn).isFalse();
    }

    @Test
    void TestCarHasFullLights() {

        Bil testbil = new Bil();
        assertThat(testbil.fullLight).isTrue();
    }

    @Test
    void TestCarHasHalfLights() {

        Bil testbil = new Bil();
        assertThat(testbil.halfLights).isTrue();
    }

    @Test
    void TestCarHasBackLights() {

        Bil testbil = new Bil();
        assertThat(testbil.backLights).isTrue();
    }

    @Test
    void TestStartCar() {

        Bil testbil = new Bil();
        assertThat(testbil.running).isFalse();
        testbil = bilManipulator.startCar(testbil);
        assertThat(testbil.running).isTrue();
    }

    @Test
    void TestCarOff() {

        Bil testbil = new Bil();
        testbil = bilManipulator.lightOn(testbil);
        testbil = bilManipulator.stopCar(testbil);

        assertThat(testbil.running).isFalse();
        assertThat(testbil.lightsOn).isFalse();
    }

    @Test
    void TestWarningLight


}
//    @Test
//    void convertCsvToList() throws FileNotFoundException {
//
//        File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");
//
//        List<BeerCSVRecord> recs = beerCsvService.convertCSVToList(file);
//
//        assertThat(recs.size()).isGreaterThan(0);
//    }
