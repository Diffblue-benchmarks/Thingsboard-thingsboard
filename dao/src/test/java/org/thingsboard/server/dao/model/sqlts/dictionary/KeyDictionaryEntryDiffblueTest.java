package org.thingsboard.server.dao.model.sqlts.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KeyDictionaryEntryDiffblueTest {
  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry2);
    int expectedHashCodeResult = keyDictionaryEntry.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryEntry2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey(null);
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey(null);
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry2);
    int expectedHashCodeResult = keyDictionaryEntry.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryEntry2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}, and {@link KeyDictionaryEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyDictionaryEntry#equals(Object)}
   *   <li>{@link KeyDictionaryEntry#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertEquals(keyDictionaryEntry, keyDictionaryEntry);
    int expectedHashCodeResult = keyDictionaryEntry.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryEntry.hashCode());
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey(null);
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryEntry");
    keyDictionaryEntry.setKeyId(1);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(2);

    KeyDictionaryEntry keyDictionaryEntry2 = new KeyDictionaryEntry();
    keyDictionaryEntry2.setKey("Key");
    keyDictionaryEntry2.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, keyDictionaryEntry2);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, null);
  }

  /**
   * Test {@link KeyDictionaryEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyDictionaryEntry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeyDictionaryEntry.equals(Object)", "int KeyDictionaryEntry.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);

    // Act and Assert
    assertNotEquals(keyDictionaryEntry, "Different type to KeyDictionaryEntry");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KeyDictionaryEntry}
   *   <li>{@link KeyDictionaryEntry#setKey(String)}
   *   <li>{@link KeyDictionaryEntry#setKeyId(int)}
   *   <li>{@link KeyDictionaryEntry#toString()}
   *   <li>{@link KeyDictionaryEntry#getKey()}
   *   <li>{@link KeyDictionaryEntry#getKeyId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeyDictionaryEntry.<init>()", "String KeyDictionaryEntry.getKey()",
      "int KeyDictionaryEntry.getKeyId()", "void KeyDictionaryEntry.setKey(String)",
      "void KeyDictionaryEntry.setKeyId(int)", "String KeyDictionaryEntry.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    KeyDictionaryEntry actualKeyDictionaryEntry = new KeyDictionaryEntry();
    actualKeyDictionaryEntry.setKey("Key");
    actualKeyDictionaryEntry.setKeyId(1);
    String actualToStringResult = actualKeyDictionaryEntry.toString();
    String actualKey = actualKeyDictionaryEntry.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("KeyDictionaryEntry(key=Key, keyId=1)", actualToStringResult);
    assertEquals(1, actualKeyDictionaryEntry.getKeyId());
  }
}
