package uo.mp.lab03.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Cd::setComment(arg)
 * 
 * - Right comment
 * - null argument
 * - empty string
 * - blank comment
 * - argument does not contain meaningful chars
 */
public class CdSetCommentTest {
    private Item aCD;
    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;

    @BeforeEach
    public void setUp() {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	aCD = new Cd(theTitle, theArtist, theTracks, theTime, false, "No comment");
    }

    /**
     * GIVEN cd with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void rightComment() {
	aCD.setComment("Excellent");
	assertEquals("Excellent", aCD.getComment());
    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
	try {
	    aCD.setComment("Excellent");
	    aCD.setComment(null);
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("null is an invalid value for the argument.", i.getMessage());
	}

    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
	try {
	    aCD.setComment("Excellent");
	    aCD.setComment("");
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("Null or empty string is an invalid value for the argument.", i.getMessage());
	}
    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
	try {
	    aCD.setComment("Excellent");
	    aCD.setComment("        ");
	    fail("Exception expected");
	} catch (IllegalArgumentException i) {
	    assertEquals("Blank string is an invalid value for the argument.", i.getMessage());
	}
    }
}
