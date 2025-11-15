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
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class RedisSslCredentialsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile(null);
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile(null);
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile(null);
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile(null);
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile(null);

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile(null);

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials.hashCode());
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("User Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile(null);
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile(null);
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("Cert File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile(null);

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, null);
  }

  /**
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, "Different type to RedisSslCredentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#setCertFile(String)}
   *   <li>{@link RedisSslCredentials#setUserCertFile(String)}
   *   <li>{@link RedisSslCredentials#setUserKeyFile(String)}
   *   <li>{@link RedisSslCredentials#toString()}
   *   <li>{@link RedisSslCredentials#getCertFile()}
   *   <li>{@link RedisSslCredentials#getUserCertFile()}
   *   <li>{@link RedisSslCredentials#getUserKeyFile()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();

    // Act
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");
    String actualToStringResult = redisSslCredentials.toString();
    String actualCertFile = redisSslCredentials.getCertFile();
    String actualUserCertFile = redisSslCredentials.getUserCertFile();

    // Assert that nothing has changed
    assertEquals("Cert File", actualCertFile);
    assertEquals("RedisSslCredentials(certFile=Cert File, userCertFile=User Cert File, userKeyFile=User Key File)",
        actualToStringResult);
    assertEquals("User Cert File", actualUserCertFile);
    assertEquals("User Key File", redisSslCredentials.getUserKeyFile());
  }
}
