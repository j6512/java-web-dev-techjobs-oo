package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    Job testEmptyJobOne;
    Job testEmptyJobTwo;
    Job testConstructorJobThree;
    Job testEqualsJobFour;
    Job testEqualsJobFive;
    Job testMissingFieldJobSix;

    @Before
    public void testJobObjects() {
        testEmptyJobOne = new Job();
        testEmptyJobTwo = new Job();
        testConstructorJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testEqualsJobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testEqualsJobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testMissingFieldJobSix = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(testEmptyJobOne.getId() + 1, testEmptyJobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testConstructorJobThree instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testEqualsJobFour.equals(testEqualsJobFive));
    }

    @Test
    public void testJobStringForBlankLineBefore() {
        assertTrue(testEqualsJobFour.toString().startsWith("\n"));
    }

    @Test
    public void testJobStringForBlankLineAfter() {
        assertTrue(testEqualsJobFour.toString().endsWith("\n"));
    }

    @Test
    public void testJobStringForBlankField() {
        assertEquals("\nID: 6\n" +
                "Name: Product tester\n" +
                "Employer: null\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n", testMissingFieldJobSix.toString());
    }

    @Test
    public void testJobStringOnlyContainsId() {
        assertEquals("OOPS! This job does not seem to exist.", testEmptyJobOne.toString());
    }

    @Test
    public void testJobStringReturnsFields() {
        assertTrue(testEqualsJobFour.toString().contains("ID: " + testEqualsJobFour.getId()));
        assertTrue(testEqualsJobFour.toString().contains("Name: " + testEqualsJobFour.getName()));
        assertTrue(testEqualsJobFour.toString().contains("Employer: " + testEqualsJobFour.getEmployer()));
        assertTrue(testEqualsJobFour.toString().contains("Location: " + testEqualsJobFour.getLocation()));
        assertTrue(testEqualsJobFour.toString().contains("Position Type: " + testEqualsJobFour.getPositionType()));
        assertTrue(testEqualsJobFour.toString().contains("Core Competency: " + testEqualsJobFour.getCoreCompetency()));
    }
}
