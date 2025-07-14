package org.thingsboard.server.dao.model.sqlts.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyDictionaryCompositeKeyDiffblueTest {
  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey("Key");
    KeyDictionaryCompositeKey keyDictionaryCompositeKey2 = new KeyDictionaryCompositeKey("Key");

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey2);
    int expectedHashCodeResult = keyDictionaryCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryCompositeKey2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey(null);
    KeyDictionaryCompositeKey keyDictionaryCompositeKey2 = new KeyDictionaryCompositeKey(null);

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey2);
    int expectedHashCodeResult = keyDictionaryCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryCompositeKey2.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}, and {@link
   * KeyDictionaryCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#equals(Object)}
   *   <li>{@link KeyDictionaryCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey("Key");

    // Act and Assert
    assertEquals(keyDictionaryCompositeKey, keyDictionaryCompositeKey);
    int expectedHashCodeResult = keyDictionaryCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, keyDictionaryCompositeKey.hashCode());
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey = new KeyDictionaryCompositeKey(null);

    // Act and Assert
    assertNotEquals(keyDictionaryCompositeKey, new KeyDictionaryCompositeKey("Key"));
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyDictionaryCompositeKey keyDictionaryCompositeKey =
        new KeyDictionaryCompositeKey(
            "org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryCompositeKey");

    // Act and Assert
    assertNotEquals(keyDictionaryCompositeKey, new KeyDictionaryCompositeKey("Key"));
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeyDictionaryCompositeKey("Key"), null);
  }

  /**
   * Test {@link KeyDictionaryCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyDictionaryCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean KeyDictionaryCompositeKey.equals(Object)",
    "int KeyDictionaryCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new KeyDictionaryCompositeKey("Key"), "Different type to KeyDictionaryCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#KeyDictionaryCompositeKey()}
   *   <li>{@link KeyDictionaryCompositeKey#setKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#toString()}
   *   <li>{@link KeyDictionaryCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void KeyDictionaryCompositeKey.<init>()",
    "void KeyDictionaryCompositeKey.<init>(String)",
    "String KeyDictionaryCompositeKey.getKey()",
    "void KeyDictionaryCompositeKey.setKey(String)",
    "String KeyDictionaryCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KeyDictionaryCompositeKey actualKeyDictionaryCompositeKey = new KeyDictionaryCompositeKey();
    actualKeyDictionaryCompositeKey.setKey("Key");
    String actualToStringResult = actualKeyDictionaryCompositeKey.toString();

    // Assert
    assertEquals("Key", actualKeyDictionaryCompositeKey.getKey());
    assertEquals("KeyDictionaryCompositeKey(key=Key)", actualToStringResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyDictionaryCompositeKey#KeyDictionaryCompositeKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#setKey(String)}
   *   <li>{@link KeyDictionaryCompositeKey#toString()}
   *   <li>{@link KeyDictionaryCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void KeyDictionaryCompositeKey.<init>()",
    "void KeyDictionaryCompositeKey.<init>(String)",
    "String KeyDictionaryCompositeKey.getKey()",
    "void KeyDictionaryCompositeKey.setKey(String)",
    "String KeyDictionaryCompositeKey.toString()"
  })
  void testGettersAndSetters_whenKey() {
    // Arrange and Act
    KeyDictionaryCompositeKey actualKeyDictionaryCompositeKey =
        new KeyDictionaryCompositeKey("Key");
    actualKeyDictionaryCompositeKey.setKey("Key");
    String actualToStringResult = actualKeyDictionaryCompositeKey.toString();

    // Assert
    assertEquals("Key", actualKeyDictionaryCompositeKey.getKey());
    assertEquals("KeyDictionaryCompositeKey(key=Key)", actualToStringResult);
  }
}
