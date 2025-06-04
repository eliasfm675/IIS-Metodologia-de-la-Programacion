package uo.mp.lab03.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Dvd::setComment(arg)
 * 
 * - Right comment
 * - null argument
 * - empty string
 * - argument does not contain meaningful chars
 */
public class DvdSetCommentTest {
    private Dvd aDVD;
    private String theTitle;
    private String theDirector;
    private int theTime;
    private String theComment;

    @BeforeEach
    public void setUp() {
	theTitle = "Star Wars";
	theDirector = "George Lucas";
	theTime = 125;
	aDVD = new Dvd(theTitle, theDirector, theTime, false, theComment, 0);
    }

    /**
     * GIVEN dvd with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void validComment() {
	aDVD.setComment("Excellent");

	assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
	try {
	    aDVD.setComment("Excellent");
	    aDVD.setComment(null);
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("null is an invalid value for the argument.", i.getMessage());
	}

    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
	try {
	    aDVD.setComment("Excellent");
	    aDVD.setComment("");
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("Null or empty string is an invalid value for the argument.", i.getMessage());
	}

    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
	try {
	    aDVD.setComment("Excellent");
	    aDVD.setComment("      ");
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("Blank string is an invalid value for the argument.", i.getMessage());
	}

    }
}