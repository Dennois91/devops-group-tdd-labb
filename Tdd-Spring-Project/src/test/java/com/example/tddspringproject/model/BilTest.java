package com.example.tddspringproject.model;

import com.example.tddspringproject.service.BilManipulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BilTest {

    BilManipulator bilManipulator;

    Bil testbil;

    @Autowired
    public BilTest(BilManipulator bilManipulator) {
        this.bilManipulator = bilManipulator;
    }

    @BeforeEach
    void bilSetUp() {
        testbil = new Bil();
    }

    @Test
    void lightIsOn() {
        assertThat(testbil.lightsOn).isFalse();
        testbil = bilManipulator.lightsOn(testbil);
        assertThat(testbil.lightsOn).isTrue();
    }

    @Test
    void lightIsOff() {
        testbil = bilManipulator.lightsOff(testbil);
        assertThat(testbil.lightsOn).isFalse();
    }

    @Test
    void TestStartCar() {
        assertThat(testbil.running).isFalse();
        testbil = bilManipulator.startCar(testbil);
        assertThat(testbil.running).isTrue();
    }

    @Test
    void TestStopCar() {
        testbil = bilManipulator.lightsOn(testbil);
        testbil = bilManipulator.stopCar(testbil);

        assertThat(testbil.running).isFalse();
        assertThat(testbil.lightsOn).isFalse();
    }

    @Test
    void TestWarningLightOff () {
        testbil = bilManipulator.warningLightsOff(testbil);
        assertThat(testbil.warningLightsOn).isFalse();
    }
    @Test
    void TestWarningLightOn () {
        testbil = bilManipulator.warningLightsOn(testbil);
        assertThat(testbil.warningLightsOn).isTrue();
    }

    @Test
    void TestBackLightOff () {
        testbil = bilManipulator.backLightsOff(testbil);
        assertThat(testbil.backLightsOn).isFalse();
    }
    @Test
    void TestBackLightOn () {
        testbil = bilManipulator.backLightsOn(testbil);
        assertThat(testbil.backLightsOn).isTrue();
    }

    @Test
    void TestFullLightOff () {
        testbil = bilManipulator.fulLightsOff(testbil);
        assertThat(testbil.fullLightsOn).isFalse();
    }
    @Test
    void TestFullLightOn () {
        testbil = bilManipulator.fulLightsOn(testbil);
        assertThat(testbil.fullLightsOn).isTrue();
    }

    @Test
    void TestChangeSpeed () {
        testbil = bilManipulator.changeSpeed(testbil,50);
        assertThat(testbil.speed).isEqualTo(50);
    }

    @Test
    void TestMaxOrMinSpeed () {
        testbil = bilManipulator.changeSpeed(testbil,200);
        assertThat(testbil.speed).isNotEqualTo(200);

        testbil = bilManipulator.changeSpeed(testbil,-50);
        assertThat(testbil.speed).isNotEqualTo(-50);
    }

    @Test
    void testBrake () {
        testbil = bilManipulator.brake(testbil);
        assertThat(testbil.brakeLight).isTrue();
        assertThat(testbil.brake).isTrue();
        assertThat(testbil.speed).isEqualTo(0);
    }

    @Test
    void testReleaseBrake () {
        testbil = bilManipulator.brake(testbil);
        assertThat(testbil.brake).isTrue();
        assertThat(testbil.brakeLight).isTrue();

        testbil = bilManipulator.releaseBrake(testbil);
        assertThat(testbil.brake).isFalse();
        assertThat(testbil.brakeLight).isFalse();
    }

    @Test
    void testGearDrive () {
        testbil = bilManipulator.changeGear(testbil, 5);
        assertThat(testbil.gear).isEqualTo(5);
    }

    @Test
    void testDrive () {
        testbil = bilManipulator.drive(testbil);
        assertThat(testbil.gear).isGreaterThan(0);
    }

    @Test
    void testReverse () {
        testbil = bilManipulator.reverse(testbil);
        assertThat(testbil.gear).isLessThan(0);
    }

    @Test
    void testBatteryLife () {
        testbil = bilManipulator.batteryLife(testbil, 100);
        testbil = bilManipulator.changeSpeed(testbil, 40);
        assertThat(testbil.batteryLife).isEqualTo(96);
    }

    @Test
    void testBatteryUsageCombined () {
        testbil = bilManipulator.startCar(testbil);
        testbil = bilManipulator.changeSpeed(testbil, 40);
        assertThat(testbil.batteryUsage).isEqualTo(4);
        testbil = bilManipulator.lightsOn(testbil);
        assertThat(testbil.batteryUsage).isEqualTo(4.2);
    }
    @Test
    void testBatteryUsageLights (){
        testbil = bilManipulator.startCar(testbil);
        testbil = bilManipulator.lightsOn(testbil);
        assertThat(testbil.batteryUsage).isEqualTo(0.2);
    }
    @Test
    void testBatteryUsageSpeed () {

        testbil = bilManipulator.changeSpeed(testbil, 40);
        assertThat(testbil.batteryUsage).isEqualTo(4);
    }



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
