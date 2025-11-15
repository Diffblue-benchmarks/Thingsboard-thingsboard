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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SslCredentialsConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("{}: Initializing SSL credentials.");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit2() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit3() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit4() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setType("{}: Initializing SSL credentials.");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit5() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStorePassword("iloveyou");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  void testInit6() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setType("");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig(null, true);
    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig(null, true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setType(SslCredentialsType.PEM);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(new PemSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(new KeystoreSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setCredentials(new KeystoreSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig.hashCode());
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig(null, true);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig(
        "org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig", true);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", false);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(new PemSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(mock(PemSslCredentials.class));

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());
    PemSslCredentials pem = mock(PemSslCredentials.class);
    when(pem.canEqual(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(pem);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.equals(sslCredentialsConfig2));
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SslCredentialsConfig("Name", true), null);
  }

  /**
   * Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SslCredentialsConfig("Name", true), "Different type to SslCredentialsConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SslCredentialsConfig#SslCredentialsConfig(String, boolean)}
   *   <li>{@link SslCredentialsConfig#setCredentials(SslCredentials)}
   *   <li>{@link SslCredentialsConfig#setEnabled(boolean)}
   *   <li>{@link SslCredentialsConfig#setKeystore(KeystoreSslCredentials)}
   *   <li>{@link SslCredentialsConfig#setPem(PemSslCredentials)}
   *   <li>{@link SslCredentialsConfig#setType(SslCredentialsType)}
   *   <li>{@link SslCredentialsConfig#toString()}
   *   <li>{@link SslCredentialsConfig#getCredentials()}
   *   <li>{@link SslCredentialsConfig#getKeystore()}
   *   <li>{@link SslCredentialsConfig#getName()}
   *   <li>{@link SslCredentialsConfig#getPem()}
   *   <li>{@link SslCredentialsConfig#getType()}
   *   <li>{@link SslCredentialsConfig#isEnabled()}
   *   <li>{@link SslCredentialsConfig#isTrustsOnly()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SslCredentialsConfig actualSslCredentialsConfig = new SslCredentialsConfig("Name", true);
    KeystoreSslCredentials credentials = new KeystoreSslCredentials();
    actualSslCredentialsConfig.setCredentials(credentials);
    actualSslCredentialsConfig.setEnabled(true);
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    actualSslCredentialsConfig.setKeystore(keystore);
    PemSslCredentials pem = new PemSslCredentials();
    actualSslCredentialsConfig.setPem(pem);
    actualSslCredentialsConfig.setType(SslCredentialsType.PEM);
    String actualToStringResult = actualSslCredentialsConfig.toString();
    SslCredentials actualCredentials = actualSslCredentialsConfig.getCredentials();
    KeystoreSslCredentials actualKeystore = actualSslCredentialsConfig.getKeystore();
    String actualName = actualSslCredentialsConfig.getName();
    PemSslCredentials actualPem = actualSslCredentialsConfig.getPem();
    SslCredentialsType actualType = actualSslCredentialsConfig.getType();
    boolean actualIsEnabledResult = actualSslCredentialsConfig.isEnabled();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "SslCredentialsConfig(enabled=true, type=PEM, pem=PemSslCredentials(certFile=null, keyFile=null,"
            + " keyPassword=null), keystore=KeystoreSslCredentials(type=null, storeFile=null, storePassword=null,"
            + " keyPassword=null, keyAlias=null), credentials=KeystoreSslCredentials(type=null, storeFile=null,"
            + " storePassword=null, keyPassword=null, keyAlias=null), name=Name, trustsOnly=true)",
        actualToStringResult);
    assertEquals(SslCredentialsType.PEM, actualType);
    assertTrue(actualIsEnabledResult);
    assertTrue(actualSslCredentialsConfig.isTrustsOnly());
    assertSame(credentials, actualCredentials);
    assertSame(keystore, actualKeystore);
    assertSame(pem, actualPem);
  }
}
