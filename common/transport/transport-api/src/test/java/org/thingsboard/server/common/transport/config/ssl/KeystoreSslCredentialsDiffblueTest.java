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
package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class KeystoreSslCredentialsDiffblueTest {
  /**
   * Method under test: {@link KeystoreSslCredentials#canUse()}
   */
  @Test
  void testCanUse() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("classpath:");

    // Act and Assert
    assertTrue(keystoreSslCredentials.canUse());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#canUse()}
   */
  @Test
  void testCanUse2() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    // Act and Assert
    assertFalse(keystoreSslCredentials.canUse());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.updateKeyAlias("Key Alias");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.updateKeyAlias("Key Alias");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setType("Type");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setType("Type");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStoreFile("Store File");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStorePassword("iloveyou");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStorePassword("iloveyou");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setKeyPassword("iloveyou");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials.hashCode());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), 1);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.updateKeyAlias("Key Alias");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setType("Type");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.updateKeyAlias("Key Alias");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setType("Type");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStoreFile("Store File");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), null);
  }

  /**
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), "Different type to KeystoreSslCredentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KeystoreSslCredentials}
   *   <li>{@link KeystoreSslCredentials#setKeyAlias(String)}
   *   <li>{@link KeystoreSslCredentials#setKeyPassword(String)}
   *   <li>{@link KeystoreSslCredentials#setStoreFile(String)}
   *   <li>{@link KeystoreSslCredentials#setStorePassword(String)}
   *   <li>{@link KeystoreSslCredentials#setType(String)}
   *   <li>{@link KeystoreSslCredentials#updateKeyAlias(String)}
   *   <li>{@link KeystoreSslCredentials#toString()}
   *   <li>{@link KeystoreSslCredentials#getKeyAlias()}
   *   <li>{@link KeystoreSslCredentials#getKeyPassword()}
   *   <li>{@link KeystoreSslCredentials#getStoreFile()}
   *   <li>{@link KeystoreSslCredentials#getStorePassword()}
   *   <li>{@link KeystoreSslCredentials#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    KeystoreSslCredentials actualKeystoreSslCredentials = new KeystoreSslCredentials();
    actualKeystoreSslCredentials.setKeyAlias("Key Alias");
    actualKeystoreSslCredentials.setKeyPassword("iloveyou");
    actualKeystoreSslCredentials.setStoreFile("Store File");
    actualKeystoreSslCredentials.setStorePassword("iloveyou");
    actualKeystoreSslCredentials.setType("Type");
    actualKeystoreSslCredentials.updateKeyAlias("Key Alias");
    String actualToStringResult = actualKeystoreSslCredentials.toString();
    String actualKeyAlias = actualKeystoreSslCredentials.getKeyAlias();
    String actualKeyPassword = actualKeystoreSslCredentials.getKeyPassword();
    String actualStoreFile = actualKeystoreSslCredentials.getStoreFile();
    String actualStorePassword = actualKeystoreSslCredentials.getStorePassword();

    // Assert that nothing has changed
    assertEquals("Key Alias", actualKeyAlias);
    assertEquals("KeystoreSslCredentials(type=Type, storeFile=Store File, storePassword=iloveyou, keyPassword=iloveyou,"
        + " keyAlias=Key Alias)", actualToStringResult);
    assertEquals("Store File", actualStoreFile);
    assertEquals("Type", actualKeystoreSslCredentials.getType());
    assertEquals("iloveyou", actualKeyPassword);
    assertEquals("iloveyou", actualStorePassword);
  }
}
