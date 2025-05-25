package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MobileSessionInfoDiffblueTest {
  /**
   * Test {@link MobileSessionInfo#equals(Object)}, and {@link MobileSessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileSessionInfo#equals(Object)}
   *   <li>{@link MobileSessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileSessionInfo.equals(Object)", "int MobileSessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    MobileSessionInfo mobileSessionInfo2 = new MobileSessionInfo();
    mobileSessionInfo2.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertEquals(mobileSessionInfo, mobileSessionInfo2);
    int expectedHashCodeResult = mobileSessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileSessionInfo2.hashCode());
  }

  /**
   * Test {@link MobileSessionInfo#equals(Object)}, and {@link MobileSessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileSessionInfo#equals(Object)}
   *   <li>{@link MobileSessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileSessionInfo.equals(Object)", "int MobileSessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertEquals(mobileSessionInfo, mobileSessionInfo);
    int expectedHashCodeResult = mobileSessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileSessionInfo.hashCode());
  }

  /**
   * Test {@link MobileSessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileSessionInfo.equals(Object)", "int MobileSessionInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(3L);

    MobileSessionInfo mobileSessionInfo2 = new MobileSessionInfo();
    mobileSessionInfo2.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, mobileSessionInfo2);
  }

  /**
   * Test {@link MobileSessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileSessionInfo.equals(Object)", "int MobileSessionInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, null);
  }

  /**
   * Test {@link MobileSessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileSessionInfo.equals(Object)", "int MobileSessionInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, "Different type to MobileSessionInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MobileSessionInfo}
   *   <li>{@link MobileSessionInfo#setFcmTokenTimestamp(long)}
   *   <li>{@link MobileSessionInfo#toString()}
   *   <li>{@link MobileSessionInfo#getFcmTokenTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileSessionInfo.<init>()", "long MobileSessionInfo.getFcmTokenTimestamp()",
      "void MobileSessionInfo.setFcmTokenTimestamp(long)", "String MobileSessionInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    MobileSessionInfo actualMobileSessionInfo = new MobileSessionInfo();
    actualMobileSessionInfo.setFcmTokenTimestamp(1L);
    String actualToStringResult = actualMobileSessionInfo.toString();

    // Assert
    assertEquals("MobileSessionInfo(fcmTokenTimestamp=1)", actualToStringResult);
    assertEquals(1L, actualMobileSessionInfo.getFcmTokenTimestamp());
  }
}
