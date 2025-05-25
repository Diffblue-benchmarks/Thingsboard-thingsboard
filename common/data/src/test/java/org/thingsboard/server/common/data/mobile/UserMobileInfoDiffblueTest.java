package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserMobileInfoDiffblueTest {
  /**
   * Test {@link UserMobileInfo#equals(Object)}, and {@link UserMobileInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserMobileInfo#equals(Object)}
   *   <li>{@link UserMobileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserMobileInfo.equals(Object)", "int UserMobileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    UserMobileInfo userMobileInfo2 = new UserMobileInfo();
    userMobileInfo2.setSessions(new HashMap<>());

    // Act and Assert
    assertEquals(userMobileInfo, userMobileInfo2);
    int expectedHashCodeResult = userMobileInfo.hashCode();
    assertEquals(expectedHashCodeResult, userMobileInfo2.hashCode());
  }

  /**
   * Test {@link UserMobileInfo#equals(Object)}, and {@link UserMobileInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserMobileInfo#equals(Object)}
   *   <li>{@link UserMobileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserMobileInfo.equals(Object)", "int UserMobileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertEquals(userMobileInfo, userMobileInfo);
    int expectedHashCodeResult = userMobileInfo.hashCode();
    assertEquals(expectedHashCodeResult, userMobileInfo.hashCode());
  }

  /**
   * Test {@link UserMobileInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserMobileInfo.equals(Object)", "int UserMobileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    HashMap<String, MobileSessionInfo> sessions = new HashMap<>();
    sessions.put("foo", mobileSessionInfo);

    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(sessions);

    UserMobileInfo userMobileInfo2 = new UserMobileInfo();
    userMobileInfo2.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, userMobileInfo2);
  }

  /**
   * Test {@link UserMobileInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserMobileInfo.equals(Object)", "int UserMobileInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, null);
  }

  /**
   * Test {@link UserMobileInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserMobileInfo.equals(Object)", "int UserMobileInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, "Different type to UserMobileInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserMobileInfo}
   *   <li>{@link UserMobileInfo#setSessions(Map)}
   *   <li>{@link UserMobileInfo#toString()}
   *   <li>{@link UserMobileInfo#getSessions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserMobileInfo.<init>()", "Map UserMobileInfo.getSessions()",
      "void UserMobileInfo.setSessions(Map)", "String UserMobileInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    UserMobileInfo actualUserMobileInfo = new UserMobileInfo();
    HashMap<String, MobileSessionInfo> sessions = new HashMap<>();
    actualUserMobileInfo.setSessions(sessions);
    String actualToStringResult = actualUserMobileInfo.toString();
    Map<String, MobileSessionInfo> actualSessions = actualUserMobileInfo.getSessions();

    // Assert
    assertEquals("UserMobileInfo(sessions={})", actualToStringResult);
    assertTrue(actualSessions.isEmpty());
    assertSame(sessions, actualSessions);
  }
}
