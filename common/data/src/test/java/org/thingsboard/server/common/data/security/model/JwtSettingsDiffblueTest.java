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
package org.thingsboard.server.common.data.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class JwtSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    JwtSettings jwtSettings2 = new JwtSettings();

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings2);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");
    JwtSettings jwtSettings2 = new JwtSettings(1, 1, "ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings2);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings.hashCode());
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings(1, 1, "ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenIssuer("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setTokenIssuer("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setTokenSigningKey("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtSettings(), null);
  }

  /**
   * Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtSettings(), "Different type to JwtSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtSettings#JwtSettings()}
   *   <li>{@link JwtSettings#setRefreshTokenExpTime(Integer)}
   *   <li>{@link JwtSettings#setTokenExpirationTime(Integer)}
   *   <li>{@link JwtSettings#setTokenIssuer(String)}
   *   <li>{@link JwtSettings#setTokenSigningKey(String)}
   *   <li>{@link JwtSettings#toString()}
   *   <li>{@link JwtSettings#getRefreshTokenExpTime()}
   *   <li>{@link JwtSettings#getTokenExpirationTime()}
   *   <li>{@link JwtSettings#getTokenIssuer()}
   *   <li>{@link JwtSettings#getTokenSigningKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JwtSettings actualJwtSettings = new JwtSettings();
    actualJwtSettings.setRefreshTokenExpTime(1);
    actualJwtSettings.setTokenExpirationTime(1);
    actualJwtSettings.setTokenIssuer("ABC123");
    actualJwtSettings.setTokenSigningKey("ABC123");
    String actualToStringResult = actualJwtSettings.toString();
    Integer actualRefreshTokenExpTime = actualJwtSettings.getRefreshTokenExpTime();
    Integer actualTokenExpirationTime = actualJwtSettings.getTokenExpirationTime();
    String actualTokenIssuer = actualJwtSettings.getTokenIssuer();

    // Assert that nothing has changed
    assertEquals("ABC123", actualTokenIssuer);
    assertEquals("ABC123", actualJwtSettings.getTokenSigningKey());
    assertEquals(
        "JwtSettings(tokenExpirationTime=1, refreshTokenExpTime=1, tokenIssuer=ABC123, tokenSigningKey" + "=ABC123)",
        actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime.intValue());
    assertEquals(1, actualTokenExpirationTime.intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtSettings#JwtSettings(Integer, Integer, String, String)}
   *   <li>{@link JwtSettings#setRefreshTokenExpTime(Integer)}
   *   <li>{@link JwtSettings#setTokenExpirationTime(Integer)}
   *   <li>{@link JwtSettings#setTokenIssuer(String)}
   *   <li>{@link JwtSettings#setTokenSigningKey(String)}
   *   <li>{@link JwtSettings#toString()}
   *   <li>{@link JwtSettings#getRefreshTokenExpTime()}
   *   <li>{@link JwtSettings#getTokenExpirationTime()}
   *   <li>{@link JwtSettings#getTokenIssuer()}
   *   <li>{@link JwtSettings#getTokenSigningKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    JwtSettings actualJwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");
    actualJwtSettings.setRefreshTokenExpTime(1);
    actualJwtSettings.setTokenExpirationTime(1);
    actualJwtSettings.setTokenIssuer("ABC123");
    actualJwtSettings.setTokenSigningKey("ABC123");
    String actualToStringResult = actualJwtSettings.toString();
    Integer actualRefreshTokenExpTime = actualJwtSettings.getRefreshTokenExpTime();
    Integer actualTokenExpirationTime = actualJwtSettings.getTokenExpirationTime();
    String actualTokenIssuer = actualJwtSettings.getTokenIssuer();

    // Assert that nothing has changed
    assertEquals("ABC123", actualTokenIssuer);
    assertEquals("ABC123", actualJwtSettings.getTokenSigningKey());
    assertEquals(
        "JwtSettings(tokenExpirationTime=1, refreshTokenExpTime=1, tokenIssuer=ABC123, tokenSigningKey" + "=ABC123)",
        actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime.intValue());
    assertEquals(1, actualTokenExpirationTime.intValue());
  }
}
