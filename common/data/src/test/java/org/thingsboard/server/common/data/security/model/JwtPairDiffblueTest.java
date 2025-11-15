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
import org.thingsboard.server.common.data.security.Authority;

class JwtPairDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JwtPair jwtPair = new JwtPair(null, "ABC123");
    JwtPair jwtPair2 = new JwtPair(null, "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", null);
    JwtPair jwtPair2 = new JwtPair("ABC123", null);

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    jwtPair.setScope(Authority.SYS_ADMIN);

    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");
    jwtPair2.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair.hashCode());
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("Token", "ABC123");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtPair jwtPair = new JwtPair(null, "ABC123");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "Refresh Token");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", null);

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    jwtPair.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");
    jwtPair2.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(jwtPair, jwtPair2);
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPair("ABC123", "ABC123"), null);
  }

  /**
   * Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPair("ABC123", "ABC123"), "Different type to JwtPair");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#JwtPair()}
   *   <li>{@link JwtPair#setRefreshToken(String)}
   *   <li>{@link JwtPair#setScope(Authority)}
   *   <li>{@link JwtPair#setToken(String)}
   *   <li>{@link JwtPair#toString()}
   *   <li>{@link JwtPair#getRefreshToken()}
   *   <li>{@link JwtPair#getScope()}
   *   <li>{@link JwtPair#getToken()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JwtPair actualJwtPair = new JwtPair();
    actualJwtPair.setRefreshToken("ABC123");
    actualJwtPair.setScope(Authority.SYS_ADMIN);
    actualJwtPair.setToken("ABC123");
    String actualToStringResult = actualJwtPair.toString();
    String actualRefreshToken = actualJwtPair.getRefreshToken();
    Authority actualScope = actualJwtPair.getScope();

    // Assert that nothing has changed
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("ABC123", actualJwtPair.getToken());
    assertEquals("JwtPair(token=ABC123, refreshToken=ABC123, scope=SYS_ADMIN)", actualToStringResult);
    assertEquals(Authority.SYS_ADMIN, actualScope);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JwtPair#JwtPair(String, String)}
   *   <li>{@link JwtPair#setRefreshToken(String)}
   *   <li>{@link JwtPair#setScope(Authority)}
   *   <li>{@link JwtPair#setToken(String)}
   *   <li>{@link JwtPair#toString()}
   *   <li>{@link JwtPair#getRefreshToken()}
   *   <li>{@link JwtPair#getScope()}
   *   <li>{@link JwtPair#getToken()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    JwtPair actualJwtPair = new JwtPair("ABC123", "ABC123");
    actualJwtPair.setRefreshToken("ABC123");
    actualJwtPair.setScope(Authority.SYS_ADMIN);
    actualJwtPair.setToken("ABC123");
    String actualToStringResult = actualJwtPair.toString();
    String actualRefreshToken = actualJwtPair.getRefreshToken();
    Authority actualScope = actualJwtPair.getScope();

    // Assert that nothing has changed
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("ABC123", actualJwtPair.getToken());
    assertEquals("JwtPair(token=ABC123, refreshToken=ABC123, scope=SYS_ADMIN)", actualToStringResult);
    assertEquals(Authority.SYS_ADMIN, actualScope);
  }
}
