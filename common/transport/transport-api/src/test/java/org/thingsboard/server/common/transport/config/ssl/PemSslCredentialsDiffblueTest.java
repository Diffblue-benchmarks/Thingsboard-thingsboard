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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.junit.jupiter.api.Test;

class PemSslCredentialsDiffblueTest {
  /**
   * Method under test: {@link PemSslCredentials#canUse()}
   */
  @Test
  void testCanUse() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertTrue(pemSslCredentials.canUse());
  }

  /**
   * Method under test: {@link PemSslCredentials#canUse()}
   */
  @Test
  void testCanUse2() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    // Act and Assert
    assertFalse(pemSslCredentials.canUse());
  }

  /**
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  void testLoadKeyStore() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  void testLoadKeyStore2() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("BC");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  void testLoadKeyStore3() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("classpath:");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  void testLoadKeyStore4() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setCertFile("Cert File");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("Key File");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyFile("Key File");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyPassword("iloveyou");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials.hashCode());
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), 1);
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("Key File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setCertFile("Cert File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyFile("Key File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), null);
  }

  /**
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), "Different type to PemSslCredentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PemSslCredentials}
   *   <li>{@link PemSslCredentials#setCertFile(String)}
   *   <li>{@link PemSslCredentials#setKeyFile(String)}
   *   <li>{@link PemSslCredentials#setKeyPassword(String)}
   *   <li>{@link PemSslCredentials#updateKeyAlias(String)}
   *   <li>{@link PemSslCredentials#toString()}
   *   <li>{@link PemSslCredentials#getCertFile()}
   *   <li>{@link PemSslCredentials#getKeyAlias()}
   *   <li>{@link PemSslCredentials#getKeyFile()}
   *   <li>{@link PemSslCredentials#getKeyPassword()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PemSslCredentials actualPemSslCredentials = new PemSslCredentials();
    actualPemSslCredentials.setCertFile("Cert File");
    actualPemSslCredentials.setKeyFile("Key File");
    actualPemSslCredentials.setKeyPassword("iloveyou");
    actualPemSslCredentials.updateKeyAlias("Key Alias");
    String actualToStringResult = actualPemSslCredentials.toString();
    String actualCertFile = actualPemSslCredentials.getCertFile();
    String actualKeyAlias = actualPemSslCredentials.getKeyAlias();
    String actualKeyFile = actualPemSslCredentials.getKeyFile();

    // Assert that nothing has changed
    assertEquals("Cert File", actualCertFile);
    assertEquals("Key File", actualKeyFile);
    assertEquals("PemSslCredentials(certFile=Cert File, keyFile=Key File, keyPassword=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPemSslCredentials.getKeyPassword());
    assertEquals("server", actualKeyAlias);
  }
}
