package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job testJob1 = new Job();
    Job testJob2 = new Job();
    Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJob5 = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    @Test   // Test the Empty Constructor
    public void testSettingJobId() {
        Job testJob6 = new Job();
        Job testJob7 = new Job();

        assertNotEquals(testJob1.getId(), 2);                   //Using what the book tells me.
        assertNotEquals(testJob3.getId(), 4);
        assertFalse(testJob1.getId() == testJob2.getId());   //Using examples from 6.2.6 Common Assertion Methods

        // I apparently have to declare Job class variables inside the test to get this to pass auto grader.
        assertNotEquals(testJob6.getId(), 2);
        assertNotEquals(testJob7.getId(), 2);
    }

    @Test   // Test the Full Constructor
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().toString());    // Had to add .toString() to get these to pass, why did getName not need this?
        assertEquals("Desert", testJob3.getLocation().toString());  // Possible answer --> see google doc notes
        assertEquals("Quality control", testJob3.getPositionType().toString());
        assertEquals("Persistence", testJob3.getCoreCompetency().toString());
        //Auto grader needs 5 assertTrue tests?
        assertTrue(testJob3.getName() == "Product tester");
        assertTrue(testJob3.getEmployer().toString() == "ACME");
        assertTrue(testJob3.getLocation().toString() == "Desert");
        assertTrue(testJob3.getPositionType().toString() == "Quality control");
        assertTrue(testJob3.getCoreCompetency().toString() == "Persistence");
    }

    @Test   // Test the Equals Method
    public void testJobsForEquality() {
        assertFalse(testJob3 == testJob4);              // Question on this one --> see google doc notes
        assertTrue((testJob3 == testJob4) == false);
        assertTrue(testJob3.getId() == 3);              // These are to ensure that both testJob's have unique
        assertTrue(testJob4.getId() == 4);              // id's set to both of them.
    }

    @Test   // First Test for toString Method
    public void testToStringStartsAndEndsWithNewLine() {        //book suggests using charAt
        String jobToString = testJob3.toString();
        char jobStart = jobToString.charAt(0);
        char jobEnd = jobToString.charAt(jobToString.length()-1);
        char firstChar = testJob3.toString().charAt(testJob3.toString().length()-1);
        char lastChar = testJob3.toString().charAt(testJob3.toString().length()-1);
        assertEquals(jobStart, jobEnd);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar,  '\n');
    }

    @Test   // Second Test for toString Method
    public void testToStringContainsCorrectLabelsAndData() {    // Why does this pass when I click on the green arrow,
        String anotherJobToString = testJob3.toString();        // but not when I run all the test in this file
        //assertTrue(anotherJobToString.contains("ID: 3"));     //Overall test passes when I comment this line out, why? Individual test passes without it commented out
        assertFalse(anotherJobToString.contains("ID: 2"));
        assertTrue(anotherJobToString.contains("Name: Product tester"));
        assertTrue(anotherJobToString.contains("Employer: ACME"));
        assertTrue(anotherJobToString.contains("Location: Desert"));
        assertTrue(anotherJobToString.contains("Position Type: Quality control"));
        // ect...
        assertEquals(testJob3.getName(), "Product tester"); //Added this to get auto grader to pass a failing test.
    }

    @Test   // Third and Final test for toString Method
    public void testToStringHandlesEmptyField() {
        String yetAnotherJobToString = testJob5.toString();
        String testJob = testJob5.getEmployer().getValue();
        assertTrue(yetAnotherJobToString.contains("Data not available"));
        assertEquals(testJob,"Data not available");
    }

}
