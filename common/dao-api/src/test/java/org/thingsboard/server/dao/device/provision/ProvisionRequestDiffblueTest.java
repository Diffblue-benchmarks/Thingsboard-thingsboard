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
package org.thingsboard.server.dao.device.provision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.ProvisionDeviceCredentialsData;
import org.thingsboard.server.common.data.device.profile.ProvisionDeviceProfileCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;

class ProvisionRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData2, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest(null, DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 = new ProvisionRequest(null, DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData2, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", null, credentialsData,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 = new ProvisionRequest("Device Name", null, credentialsData2,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest.hashCode());
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("ABC123", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest(null, DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", null, credentialsData,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.X509_CERTIFICATE,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("Device Name", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, null,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = mock(ProvisionDeviceCredentialsData.class);
    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Device Name", "Provision Device Secret"), true);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"), null, true);
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        false);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        null);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionRequest,
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData2,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true));
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true), null);
  }

  /**
   * Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
            new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true),
        "Different type to ProvisionRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProvisionRequest#ProvisionRequest(String, DeviceCredentialsType, ProvisionDeviceCredentialsData, ProvisionDeviceProfileCredentials, Boolean)}
   *   <li>
   * {@link ProvisionRequest#setCredentials(ProvisionDeviceProfileCredentials)}
   *   <li>
   * {@link ProvisionRequest#setCredentialsData(ProvisionDeviceCredentialsData)}
   *   <li>{@link ProvisionRequest#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link ProvisionRequest#setDeviceName(String)}
   *   <li>{@link ProvisionRequest#setGateway(Boolean)}
   *   <li>{@link ProvisionRequest#toString()}
   *   <li>{@link ProvisionRequest#getCredentials()}
   *   <li>{@link ProvisionRequest#getCredentialsData()}
   *   <li>{@link ProvisionRequest#getCredentialsType()}
   *   <li>{@link ProvisionRequest#getDeviceName()}
   *   <li>{@link ProvisionRequest#getGateway()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act
    ProvisionRequest actualProvisionRequest = new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN,
        credentialsData, new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        true);
    ProvisionDeviceProfileCredentials credentials = new ProvisionDeviceProfileCredentials("Provision Device Key",
        "Provision Device Secret");

    actualProvisionRequest.setCredentials(credentials);
    ProvisionDeviceCredentialsData credentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    actualProvisionRequest.setCredentialsData(credentialsData2);
    actualProvisionRequest.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualProvisionRequest.setDeviceName("Device Name");
    actualProvisionRequest.setGateway(true);
    String actualToStringResult = actualProvisionRequest.toString();
    ProvisionDeviceProfileCredentials actualCredentials = actualProvisionRequest.getCredentials();
    ProvisionDeviceCredentialsData actualCredentialsData = actualProvisionRequest.getCredentialsData();
    DeviceCredentialsType actualCredentialsType = actualProvisionRequest.getCredentialsType();
    String actualDeviceName = actualProvisionRequest.getDeviceName();

    // Assert that nothing has changed
    assertEquals("Device Name", actualDeviceName);
    assertEquals("ProvisionRequest(deviceName=Device Name, credentialsType=ACCESS_TOKEN, credentialsData=ProvisionDevi"
        + "ceCredentialsData(token=ABC123, clientId=42, username=janedoe, password=iloveyou, x509CertHash=X509"
        + " Cert Hash), credentials=ProvisionDeviceProfileCredentials(provisionDeviceKey=Provision Device Key,"
        + " provisionDeviceSecret=Provision Device Secret), gateway=true)", actualToStringResult);
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertTrue(actualProvisionRequest.getGateway());
    assertSame(credentialsData2, actualCredentialsData);
    assertSame(credentials, actualCredentials);
  }
}
