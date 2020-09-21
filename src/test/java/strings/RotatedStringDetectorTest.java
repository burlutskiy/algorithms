package strings;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static strings.RotatedStringDetector.isRotation;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link RotatedStringDetector}
 */
public class RotatedStringDetectorTest {

    @Test
    public void testNullStrings() {
        assertFalse(isRotation(null, null));
        assertFalse(isRotation("a", null));
        assertFalse(isRotation("", null));
        assertFalse(isRotation(null, "a"));
        assertFalse(isRotation(null, ""));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(isRotation("", ""));
    }

    @Test
    public void testShortStrings() {
        assertTrue(isRotation("a", "a"));
    }

    @Test
    public void testFindsRotatedStrings() {
        assertTrue(isRotation("1111", "1111"));
        assertTrue(isRotation("1234", "1234"));
        assertTrue(isRotation("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "OPQRSTUVWXYZABCDEFGHIJKLMN"));
        assertTrue(isRotation("1234", "4123"));
        assertTrue(isRotation("ABBA", "AABB"));
        assertTrue(isRotation("IHdHdDAaiQ", "HdDAaiQIHd"));
    }

    @Test
    public void testFailsNonRotatedStrings() {
        assertFalse(isRotation("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "12345"));
        assertFalse(isRotation("12345", "1234"));
        assertFalse(isRotation("12345", "54321"));
    }

    @Test
    public void testRandomStrings() {
    	testRandomStrings(512);
    }

    @Test
    public void testBigStrings() {
    	testRandomStrings(8192);
    }
    
    private void testRandomStrings(int size) {
        /* make up a big random string */
        String bigString = RandomStringUtils.randomAlphabetic(size);
        /* create all possible rotations of string */
        Set<String> rotations =
                IntStream.range(0, bigString.length()).mapToObj(i -> bigString.substring(i, bigString.length()) + bigString.substring(0, i)).collect(Collectors.toSet());
        /* create some non-rotations by swapping characters around */
        Set<String> nonRotations = rotations.stream().map(str -> str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0))
                .filter(str -> !rotations.contains(str))
                .collect(Collectors.toSet());
        /* perform asserts */
        rotations.forEach(rotation -> assertTrue(String.format("Expected %s to be rotation of %s", rotation, bigString), isRotation(rotation, bigString)));
        rotations.forEach(rotation -> assertTrue(String.format("Expected %s to be rotation of %s", bigString, rotation), isRotation(bigString, rotation)));
        nonRotations.forEach(rotation -> assertFalse(String.format("Expected %s not to be a rotation of %s", rotation, bigString), isRotation(rotation, bigString)));
        nonRotations.forEach(rotation -> assertFalse(String.format("Expected %s not to be a rotation of %s", bigString, rotation), isRotation(bigString, rotation)));
    }


}
