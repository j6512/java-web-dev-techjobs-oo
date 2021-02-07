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

    @Before
    public void testJobObjects() {
        testEmptyJobOne = new Job();
        testEmptyJobTwo = new Job();
        testConstructorJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testEqualsJobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testEqualsJobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
}
