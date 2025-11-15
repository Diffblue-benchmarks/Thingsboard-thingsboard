/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UserCredentialsId;

class UserCredentialsDiffblueTest {
  /**
   * Method under test: {@link UserCredentials#isActivationTokenExpired()}
   */
  @Test
  void testIsActivationTokenExpired() {
    // Arrange, Act and Assert
    assertTrue((new UserCredentials()).isActivationTokenExpired());
  }

  /**
   * Method under test: {@link UserCredentials#isActivationTokenExpired()}
   */
  @Test
  void testIsActivationTokenExpired2() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setActivateTokenExpTime(Long.MAX_VALUE);

    // Act and Assert
    assertFalse(userCredentials.isActivationTokenExpired());
  }

  /**
   * Method under test: {@link UserCredentials#getActivationTokenTtl()}
   */
  @Test
  void testGetActivationTokenTtl() {
    // Arrange, Act and Assert
    assertEquals(0L, (new UserCredentials()).getActivationTokenTtl());
  }

  /**
   * Method under test: {@link UserCredentials#isResetTokenExpired()}
   */
  @Test
  void testIsResetTokenExpired() {
    // Arrange, Act and Assert
    assertTrue((new UserCredentials()).isResetTokenExpired());
  }

  /**
   * Method under test: {@link UserCredentials#isResetTokenExpired()}
   */
  @Test
  void testIsResetTokenExpired2() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setResetTokenExpTime(Long.MAX_VALUE);

    // Act and Assert
    assertFalse(userCredentials.isResetTokenExpired());
  }

  /**
   * Method under test: {@link UserCredentials#getResetTokenTtl()}
   */
  @Test
  void testGetResetTokenTtl() {
    // Arrange, Act and Assert
    assertEquals(0L, (new UserCredentials()).getResetTokenTtl());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserCredentials#equals(Object)}
   *   <li>{@link UserCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    UserCredentials userCredentials2 = new UserCredentials();

    // Act and Assert
    assertEquals(userCredentials, userCredentials2);
    int expectedHashCodeResult = userCredentials.hashCode();
    assertEquals(expectedHashCodeResult, userCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserCredentials#equals(Object)}
   *   <li>{@link UserCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    // Act and Assert
    assertEquals(userCredentials, userCredentials);
    int expectedHashCodeResult = userCredentials.hashCode();
    assertEquals(expectedHashCodeResult, userCredentials.hashCode());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials(new UserCredentialsId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentials(), mock(DeviceCredentials.class));
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setEnabled(true);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setActivateToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setActivateTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setResetTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setLastLoginTs(1L);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setFailedLoginAttempts(1);

    // Act and Assert
    assertNotEquals(userCredentials, new UserCredentials());
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setActivateToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setActivateTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setResetTokenExpTime(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setLastLoginTs(1L);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();

    UserCredentials userCredentials2 = new UserCredentials();
    userCredentials2.setFailedLoginAttempts(1);

    // Act and Assert
    assertNotEquals(userCredentials, userCredentials2);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentials(), null);
  }

  /**
   * Method under test: {@link UserCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentials(), "Different type to UserCredentials");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
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
    actualUserCredentials.getUserId();
    boolean actualIsEnabledResult = actualUserCredentials.isEnabled();

    // Assert that nothing has changed
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals(
        "UserCredentials(super=BaseData [createdTime=0, id=null], userId=null, enabled=true, password=iloveyou,"
            + " activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123, resetTokenExpTime=1, lastLoginTs=1,"
            + " failedLoginAttempts=1)",
        actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals(0L, actualUserCredentials.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters2() {
    // Arrange
    UserCredentialsId id = new UserCredentialsId(EntityId.NULL_UUID);

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
    actualUserCredentials.getUserId();
    boolean actualIsEnabledResult = actualUserCredentials.isEnabled();

    // Assert that nothing has changed
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals("UserCredentials(super=BaseData [createdTime=0, id=13814000-1dd2-11b2-8080-808080808080], userId=null,"
        + " enabled=true, password=iloveyou, activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123,"
        + " resetTokenExpTime=1, lastLoginTs=1, failedLoginAttempts=1)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals(0L, actualUserCredentials.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
    assertSame(id, actualUserCredentials.getId());
  }
}
