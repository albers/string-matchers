package net.mguenther.matchers.kmp;

import net.mguenther.matchers.Matcher;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
public class KnuthMorrisPrattMatcherTest {

    private final Matcher matcher = new KnuthMorrisPrattMatcher();

    @Test
    public void matchShouldYieldCorrectPositionsOfFoundSubStrings() {

        final String haystack = "abcdfffggffgg";
        final String needle = "fgg";

        final List<Integer> matchingPositions = matcher.match(haystack, needle);

        assertThat(matchingPositions.size(), is(2));
        assertTrue(matchingPositions.contains(6));
        assertTrue(matchingPositions.contains(10));
    }

    @Test
    public void matchShouldYieldEmptyListIfThereIsNoMatch() {

        final String haystack = "abcdfdasfasjfjasgjdlk";
        final String needle = "eee";

        final List<Integer> matchingPositions = matcher.match(haystack, needle);

        assertTrue(matchingPositions.isEmpty());
    }
}
