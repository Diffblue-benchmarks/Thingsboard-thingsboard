package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserCredentialsId;
import org.thingsboard.server.common.data.id.UserId;

class UserCredentialsDiffblueTest {
  /**
   * Test {@link UserCredentials#equals(Object)}, and {@link UserCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentials#equals(Object)}
   *   <li>{@link UserCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    UserCredentials userCredentials2 = new UserCredentials();

    // Act and Assert
    assertEquals(userCredentials, userCredentials2);
    assertEquals(userCredentials.hashCode(), userCredentials2.hashCode());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}, and {@link UserCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentials#equals(Object)}
   *   <li>{@link UserCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    // Act and Assert
    assertEquals(userCredentials, userCredentials);
    int expectedHashCodeResult = userCredentials.hashCode();
    assertEquals(expectedHashCodeResult, userCredentials.hashCode());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentialsId id =
        new UserCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCredentials userCredentials = new UserCredentials(id);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setEnabled(true);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setActivateToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setActivateTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setResetTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setLastLoginTs(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setFailedLoginAttempts(1);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setActivateToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setActivateTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setResetTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setLastLoginTs(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setFailedLoginAttempts(1);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentials(), null);
  }

  /**
   * Test {@link UserCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.equals(Object)", "int UserCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentials(), "Different type to UserCredentials");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentials#UserCredentials(UserCredentialsId)}
   *   <li>{@link UserCredentials#setActivateToken(String)}
   *   <li>{@link UserCredentials#setActivateTokenExpTime(Long)}
   *   <li>{@link UserCredentials#setEnabled(boolean)}
   *   <li>{@link UserCredentials#setFailedLoginAttempts(Integer)}
   *   <li>{@link UserCredentials#setLastLoginTs(Long)}
   *   <li>{@link UserCredentials#setPassword(String)}
   *   <li>{@link UserCredentials#setResetToken(String)}
   *   <li>{@link UserCredentials#setResetTokenExpTime(Long)}
   *   <li>{@link UserCredentials#toString()}
   *   <li>{@link UserCredentials#getActivateToken()}
   *   <li>{@link UserCredentials#getActivateTokenExpTime()}
   *   <li>{@link UserCredentials#getFailedLoginAttempts()}
   *   <li>{@link UserCredentials#getLastLoginTs()}
   *   <li>{@link UserCredentials#getPassword()}
   *   <li>{@link UserCredentials#getResetToken()}
   *   <li>{@link UserCredentials#getResetTokenExpTime()}
   *   <li>{@link UserCredentials#getUserId()}
   *   <li>{@link UserCredentials#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentials.<init>()",
    "void UserCredentials.<init>(UserCredentialsId)",
    "String UserCredentials.getActivateToken()",
    "Long UserCredentials.getActivateTokenExpTime()",
    "Integer UserCredentials.getFailedLoginAttempts()",
    "Long UserCredentials.getLastLoginTs()",
    "String UserCredentials.getPassword()",
    "String UserCredentials.getResetToken()",
    "Long UserCredentials.getResetTokenExpTime()",
    "UserId UserCredentials.getUserId()",
    "boolean UserCredentials.isEnabled()",
    "void UserCredentials.setActivateToken(String)",
    "void UserCredentials.setActivateTokenExpTime(Long)",
    "void UserCredentials.setEnabled(boolean)",
    "void UserCredentials.setFailedLoginAttempts(Integer)",
    "void UserCredentials.setLastLoginTs(Long)",
    "void UserCredentials.setPassword(String)",
    "void UserCredentials.setResetToken(String)",
    "void UserCredentials.setResetTokenExpTime(Long)",
    "void UserCredentials.setUserId(UserId)",
    "String UserCredentials.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UserCredentialsId id =
        new UserCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    UserCredentials actualUserCredentials = new UserCredentials(id);
    actualUserCredentials.setActivateToken("ABC123");
    actualUserCredentials.setActivateTokenExpTime(1L);
    actualUserCredentials.setEnabled(true);
    actualUserCredentials.setFailedLoginAttempts(1);
    actualUserCredentials.setLastLoginTs(1L);
    actualUserCredentials.setPassword("iloveyou");
    actualUserCredentials.setResetToken("ABC123");
    actualUserCredentials.setResetTokenExpTime(1L);
    String actualToStringResult = actualUserCredentials.toString();
    String actualActivateToken = actualUserCredentials.getActivateToken();
    Long actualActivateTokenExpTime = actualUserCredentials.getActivateTokenExpTime();
    Integer actualFailedLoginAttempts = actualUserCredentials.getFailedLoginAttempts();
    Long actualLastLoginTs = actualUserCredentials.getLastLoginTs();
    String actualPassword = actualUserCredentials.getPassword();
    String actualResetToken = actualUserCredentials.getResetToken();
    Long actualResetTokenExpTime = actualUserCredentials.getResetTokenExpTime();
    UserId actualUserId = actualUserCredentials.getUserId();
    boolean actualIsEnabledResult = actualUserCredentials.isEnabled();

    // Assert
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals(
        "UserCredentials(super=BaseData [createdTime=0, id=784f394c-42b6-435a-983c-b7beff2784f9], userId=null,"
            + " enabled=true, password=iloveyou, activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123,"
            + " resetTokenExpTime=1, lastLoginTs=1, failedLoginAttempts=1)",
        actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertNull(actualUserId);
    assertEquals(0L, actualUserCredentials.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
    assertSame(id, actualUserCredentials.getId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentials#UserCredentials()}
   *   <li>{@link UserCredentials#setActivateToken(String)}
   *   <li>{@link UserCredentials#setActivateTokenExpTime(Long)}
   *   <li>{@link UserCredentials#setEnabled(boolean)}
   *   <li>{@link UserCredentials#setFailedLoginAttempts(Integer)}
   *   <li>{@link UserCredentials#setLastLoginTs(Long)}
   *   <li>{@link UserCredentials#setPassword(String)}
   *   <li>{@link UserCredentials#setResetToken(String)}
   *   <li>{@link UserCredentials#setResetTokenExpTime(Long)}
   *   <li>{@link UserCredentials#toString()}
   *   <li>{@link UserCredentials#getActivateToken()}
   *   <li>{@link UserCredentials#getActivateTokenExpTime()}
   *   <li>{@link UserCredentials#getFailedLoginAttempts()}
   *   <li>{@link UserCredentials#getLastLoginTs()}
   *   <li>{@link UserCredentials#getPassword()}
   *   <li>{@link UserCredentials#getResetToken()}
   *   <li>{@link UserCredentials#getResetTokenExpTime()}
   *   <li>{@link UserCredentials#getUserId()}
   *   <li>{@link UserCredentials#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentials.<init>()",
    "void UserCredentials.<init>(UserCredentialsId)",
    "String UserCredentials.getActivateToken()",
    "Long UserCredentials.getActivateTokenExpTime()",
    "Integer UserCredentials.getFailedLoginAttempts()",
    "Long UserCredentials.getLastLoginTs()",
    "String UserCredentials.getPassword()",
    "String UserCredentials.getResetToken()",
    "Long UserCredentials.getResetTokenExpTime()",
    "UserId UserCredentials.getUserId()",
    "boolean UserCredentials.isEnabled()",
    "void UserCredentials.setActivateToken(String)",
    "void UserCredentials.setActivateTokenExpTime(Long)",
    "void UserCredentials.setEnabled(boolean)",
    "void UserCredentials.setFailedLoginAttempts(Integer)",
    "void UserCredentials.setLastLoginTs(Long)",
    "void UserCredentials.setPassword(String)",
    "void UserCredentials.setResetToken(String)",
    "void UserCredentials.setResetTokenExpTime(Long)",
    "void UserCredentials.setUserId(UserId)",
    "String UserCredentials.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    UserCredentials actualUserCredentials = new UserCredentials();
    actualUserCredentials.setActivateToken("ABC123");
    actualUserCredentials.setActivateTokenExpTime(1L);
    actualUserCredentials.setEnabled(true);
    actualUserCredentials.setFailedLoginAttempts(1);
    actualUserCredentials.setLastLoginTs(1L);
    actualUserCredentials.setPassword("iloveyou");
    actualUserCredentials.setResetToken("ABC123");
    actualUserCredentials.setResetTokenExpTime(1L);
    String actualToStringResult = actualUserCredentials.toString();
    String actualActivateToken = actualUserCredentials.getActivateToken();
    Long actualActivateTokenExpTime = actualUserCredentials.getActivateTokenExpTime();
    Integer actualFailedLoginAttempts = actualUserCredentials.getFailedLoginAttempts();
    Long actualLastLoginTs = actualUserCredentials.getLastLoginTs();
    String actualPassword = actualUserCredentials.getPassword();
    String actualResetToken = actualUserCredentials.getResetToken();
    Long actualResetTokenExpTime = actualUserCredentials.getResetTokenExpTime();
    UserId actualUserId = actualUserCredentials.getUserId();
    boolean actualIsEnabledResult = actualUserCredentials.isEnabled();

    // Assert
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals(
        "UserCredentials(super=BaseData [createdTime=0, id=null], userId=null, enabled=true, password=iloveyou,"
            + " activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123, resetTokenExpTime=1, lastLoginTs=1,"
            + " failedLoginAttempts=1)",
        actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertNull(actualUserCredentials.getId());
    assertNull(actualUserId);
    assertEquals(0L, actualUserCredentials.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
  }

  /**
   * Test {@link UserCredentials#isActivationTokenExpired()}.
   *
   * <ul>
   *   <li>Given {@link UserCredentials#UserCredentials()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#isActivationTokenExpired()}
   */
  @Test
  @DisplayName("Test isActivationTokenExpired(); given UserCredentials(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.isActivationTokenExpired()"})
  void testIsActivationTokenExpired_givenUserCredentials_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new UserCredentials().isActivationTokenExpired());
  }

  /**
   * Test {@link UserCredentials#isActivationTokenExpired()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#isActivationTokenExpired()}
   */
  @Test
  @DisplayName("Test isActivationTokenExpired(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.isActivationTokenExpired()"})
  void testIsActivationTokenExpired_thenReturnFalse() {
    // Arrange
    UserCredentialsId id =
        new UserCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserCredentials userCredentials = new UserCredentials(id);
    userCredentials.setActivateTokenExpTime(Long.MAX_VALUE);

    // Act and Assert
    assertFalse(userCredentials.isActivationTokenExpired());
  }

  /**
   * Test {@link UserCredentials#getActivationTokenTtl()}.
   *
   * <ul>
   *   <li>Given {@link UserCredentials#UserCredentials()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#getActivationTokenTtl()}
   */
  @Test
  @DisplayName("Test getActivationTokenTtl(); given UserCredentials(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long UserCredentials.getActivationTokenTtl()"})
  void testGetActivationTokenTtl_givenUserCredentials_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new UserCredentials().getActivationTokenTtl());
  }

  /**
   * Test {@link UserCredentials#isResetTokenExpired()}.
   *
   * <ul>
   *   <li>Given {@link UserCredentials#UserCredentials()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#isResetTokenExpired()}
   */
  @Test
  @DisplayName("Test isResetTokenExpired(); given UserCredentials(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.isResetTokenExpired()"})
  void testIsResetTokenExpired_givenUserCredentials_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new UserCredentials().isResetTokenExpired());
  }

  /**
   * Test {@link UserCredentials#isResetTokenExpired()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#isResetTokenExpired()}
   */
  @Test
  @DisplayName("Test isResetTokenExpired(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCredentials.isResetTokenExpired()"})
  void testIsResetTokenExpired_thenReturnFalse() {
    // Arrange
    UserCredentialsId id =
        new UserCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserCredentials userCredentials = new UserCredentials(id);
    userCredentials.setResetTokenExpTime(Long.MAX_VALUE);

    // Act and Assert
    assertFalse(userCredentials.isResetTokenExpired());
  }

  /**
   * Test {@link UserCredentials#getResetTokenTtl()}.
   *
   * <ul>
   *   <li>Given {@link UserCredentials#UserCredentials()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentials#getResetTokenTtl()}
   */
  @Test
  @DisplayName("Test getResetTokenTtl(); given UserCredentials(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long UserCredentials.getResetTokenTtl()"})
  void testGetResetTokenTtl_givenUserCredentials_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new UserCredentials().getResetTokenTtl());
  }
}
