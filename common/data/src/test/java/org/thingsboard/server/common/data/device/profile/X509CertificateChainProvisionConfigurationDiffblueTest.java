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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class X509CertificateChainProvisionConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(null);

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret(null);

    // Act and Assert
    assertEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(false);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern("Provision Device Secret");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(".*");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(null);

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, null);
  }

  /**
   * Method under test:
   * {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration,
        "Different type to X509CertificateChainProvisionConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link X509CertificateChainProvisionConfiguration}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#setAllowCreateNewDevicesByX509Certificate(boolean)}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#setCertificateRegExPattern(String)}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#setProvisionDeviceSecret(String)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#toString()}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#getCertificateRegExPattern()}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>{@link X509CertificateChainProvisionConfiguration#getType()}
   *   <li>
   * {@link X509CertificateChainProvisionConfiguration#isAllowCreateNewDevicesByX509Certificate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    X509CertificateChainProvisionConfiguration actualX509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    actualX509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    actualX509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    actualX509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");
    String actualToStringResult = actualX509CertificateChainProvisionConfiguration.toString();
    String actualCertificateRegExPattern = actualX509CertificateChainProvisionConfiguration
        .getCertificateRegExPattern();
    String actualProvisionDeviceSecret = actualX509CertificateChainProvisionConfiguration.getProvisionDeviceSecret();
    DeviceProfileProvisionType actualType = actualX509CertificateChainProvisionConfiguration.getType();

    // Assert that nothing has changed
    assertEquals(".*", actualCertificateRegExPattern);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals("X509CertificateChainProvisionConfiguration(provisionDeviceSecret=Provision Device Secret, certificat"
        + "eRegExPattern=.*, allowCreateNewDevicesByX509Certificate=true)", actualToStringResult);
    assertEquals(DeviceProfileProvisionType.X509_CERTIFICATE_CHAIN, actualType);
    assertTrue(actualX509CertificateChainProvisionConfiguration.isAllowCreateNewDevicesByX509Certificate());
  }
}
