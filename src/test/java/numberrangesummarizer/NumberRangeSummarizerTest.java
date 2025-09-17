package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*Unit tests for NumberRangeSummarizerClass.
 * 
 * Covers:
 * - Standard collection of numbers of input strings
 * - Handling of empty or invalid input
 * - Ignoring non-integer values
 * - Removing duplicates
 * - Sorting and summarizing numbers, including negative ranges.
*/

public class NumberRangeSummarizerTest {
    
private final NumberRangeSummarizerClass summarizer = new NumberRangeSummarizerClass();

//Test that a standard comma-seperated input string is correctly collected and sorted
@Test 
void testCollectValidNumbers(){
    String input = "1, 2, 3, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31";
    Collection<Integer> expected = Arrays.asList(1, 2, 3, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);

    Collection<Integer> result = summarizer.collect(input);

      System.out.println("Collected: " + result);
    assertEquals(expected, result, "Should correctly collect and sort numbers");

}

//Test that a collection of numbers is correctly summarized into ranges despite input not in correct sequence
@Test
void testSummarizeCollection() {
    Collection<Integer> input = Arrays.asList(1,3,2,7,8,12,13,14,15,22,21,23,24,31);
    String expected = "1-3, 7-8, 12-15, 21-24, 31";

    String result = summarizer.summarizeCollection(input);
    System.out.println("Collected: " + result);

    assertEquals(expected, result);
}

//Test that an empty input string returns an empty collection
@Test
void testCollectEmptyInput() {
    String input = "";
    Collection<Integer> expected = Collections.emptyList();

    Collection<Integer> result = summarizer.collect(input);

    System.out.println("Collected: " + result);
    assertEquals(expected, result);
}

//Test that extra spaces in input are ignored
@Test
void testCollectWithSpaces() {
    String input = " 1 ,  2,3 ,  7 ";
    Collection<Integer> expected = Arrays.asList(1,2,3,7);

    Collection<Integer> result = summarizer.collect(input);
    System.out.println("Collected: " + result);

    assertEquals(expected, result);
}


//Test the non-integer values are ignored
@Test
void testCollectInvalidNumbers() {
    String input = "1, 2,3, abc, 4, xyz";
    Collection<Integer> expected = Arrays.asList(1,2,3,4);

    Collection<Integer> result = summarizer.collect(input);
    System.out.println("Collected: " + result);

    assertEquals(expected, result);
}

//Test that duplicates (positive and negative) are removed

@Test
void testCollectAndRemoveDuplicates() {
    String input = "-3, -3, 1, 2, 2, 3, 3, 3, 7, -3";
    Collection<Integer> expected = Arrays.asList(-3, 1, 2, 3, 7);

    Collection<Integer> result = summarizer.collect(input);
    System.out.println("Collected: " + result);

    assertEquals(expected, result);
}

//Test that negative numbers are handled correctly into ranges


@Test
void testSummarizeNegativeNumbers() {
    Collection<Integer> input = Arrays.asList(-3, -2, -1, 0, 2, 3, 4);
    String expected = "-3-0, 2-4"; 

    String result = summarizer.summarizeCollection(input);
    System.out.println("Collected: " + result);

    assertEquals(expected, result);
}



}
