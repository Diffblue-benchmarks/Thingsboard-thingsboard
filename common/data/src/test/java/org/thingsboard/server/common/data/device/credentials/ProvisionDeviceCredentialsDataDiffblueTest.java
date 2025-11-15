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
package org.thingsboard.server.common.data.device.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ProvisionDeviceCredentialsDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData.hashCode());
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("42", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123",
        "ABC123", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "ABC123", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "ABC123", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "ABC123");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", null);

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"), null);
  }

  /**
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"),
        "Different type to ProvisionDeviceCredentialsData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProvisionDeviceCredentialsData#ProvisionDeviceCredentialsData(String, String, String, String, String)}
   *   <li>{@link ProvisionDeviceCredentialsData#toString()}
   *   <li>{@link ProvisionDeviceCredentialsData#getClientId()}
   *   <li>{@link ProvisionDeviceCredentialsData#getPassword()}
   *   <li>{@link ProvisionDeviceCredentialsData#getToken()}
   *   <li>{@link ProvisionDeviceCredentialsData#getUsername()}
   *   <li>{@link ProvisionDeviceCredentialsData#getX509CertHash()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ProvisionDeviceCredentialsData actualProvisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123",
        "42", "janedoe", "iloveyou", "X509 Cert Hash");
    String actualToStringResult = actualProvisionDeviceCredentialsData.toString();
    String actualClientId = actualProvisionDeviceCredentialsData.getClientId();
    String actualPassword = actualProvisionDeviceCredentialsData.getPassword();
    String actualToken = actualProvisionDeviceCredentialsData.getToken();
    String actualUsername = actualProvisionDeviceCredentialsData.getUsername();

    // Assert
    assertEquals("42", actualClientId);
    assertEquals("ABC123", actualToken);
    assertEquals("ProvisionDeviceCredentialsData(token=ABC123, clientId=42, username=janedoe, password=iloveyou,"
        + " x509CertHash=X509 Cert Hash)", actualToStringResult);
    assertEquals("X509 Cert Hash", actualProvisionDeviceCredentialsData.getX509CertHash());
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
  }
}
