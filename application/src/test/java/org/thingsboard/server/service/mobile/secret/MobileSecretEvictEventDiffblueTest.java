package org.thingsboard.server.service.mobile.secret;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MobileSecretEvictEventDiffblueTest {
  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}, and {@link
   * MobileSecretEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileSecretEvictEvent#equals(Object)}
   *   <li>{@link MobileSecretEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileSecretEvictEvent mobileSecretEvictEvent = new MobileSecretEvictEvent("Secret");
    MobileSecretEvictEvent mobileSecretEvictEvent2 = new MobileSecretEvictEvent("Secret");

    // Act and Assert
    assertEquals(mobileSecretEvictEvent, mobileSecretEvictEvent2);
    int expectedHashCodeResult = mobileSecretEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileSecretEvictEvent2.hashCode());
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}, and {@link
   * MobileSecretEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileSecretEvictEvent#equals(Object)}
   *   <li>{@link MobileSecretEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileSecretEvictEvent mobileSecretEvictEvent = new MobileSecretEvictEvent(null);
    MobileSecretEvictEvent mobileSecretEvictEvent2 = new MobileSecretEvictEvent(null);

    // Act and Assert
    assertEquals(mobileSecretEvictEvent, mobileSecretEvictEvent2);
    int expectedHashCodeResult = mobileSecretEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileSecretEvictEvent2.hashCode());
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}, and {@link
   * MobileSecretEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileSecretEvictEvent#equals(Object)}
   *   <li>{@link MobileSecretEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileSecretEvictEvent mobileSecretEvictEvent = new MobileSecretEvictEvent("Secret");

    // Act and Assert
    assertEquals(mobileSecretEvictEvent, mobileSecretEvictEvent);
    int expectedHashCodeResult = mobileSecretEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileSecretEvictEvent.hashCode());
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileSecretEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileSecretEvictEvent mobileSecretEvictEvent = new MobileSecretEvictEvent(null);

    // Act and Assert
    assertNotEquals(mobileSecretEvictEvent, new MobileSecretEvictEvent("Secret"));
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileSecretEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileSecretEvictEvent mobileSecretEvictEvent =
        new MobileSecretEvictEvent(
            "org.thingsboard.server.service.mobile.secret.MobileSecretEvictEvent");

    // Act and Assert
    assertNotEquals(mobileSecretEvictEvent, new MobileSecretEvictEvent("Secret"));
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileSecretEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileSecretEvictEvent("Secret"), null);
  }

  /**
   * Test {@link MobileSecretEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileSecretEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileSecretEvictEvent.equals(Object)",
    "int MobileSecretEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MobileSecretEvictEvent("Secret"), "Different type to MobileSecretEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileSecretEvictEvent#MobileSecretEvictEvent(String)}
   *   <li>{@link MobileSecretEvictEvent#toString()}
   *   <li>{@link MobileSecretEvictEvent#getSecret()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MobileSecretEvictEvent.<init>(String)",
    "String MobileSecretEvictEvent.getSecret()",
    "String MobileSecretEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MobileSecretEvictEvent actualMobileSecretEvictEvent = new MobileSecretEvictEvent("Secret");
    String actualToStringResult = actualMobileSecretEvictEvent.toString();

    // Assert
    assertEquals("MobileSecretEvictEvent(secret=Secret)", actualToStringResult);
    assertEquals("Secret", actualMobileSecretEvictEvent.getSecret());
  }
}
