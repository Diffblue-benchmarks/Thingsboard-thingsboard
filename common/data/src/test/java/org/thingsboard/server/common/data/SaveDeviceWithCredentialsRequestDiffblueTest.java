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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class SaveDeviceWithCredentialsRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(device2,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        new Device(), null);
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(
        new Device(), null);

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest.hashCode());
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());
    Device device = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()));
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfo device = new DeviceInfo();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Device device = mock(Device.class);
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        new Device(), null);
    Device device = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()));
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials(new DeviceCredentialsId(EntityId.NULL_UUID)));
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()), null);
  }

  /**
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()),
        "Different type to SaveDeviceWithCredentialsRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SaveDeviceWithCredentialsRequest#SaveDeviceWithCredentialsRequest(Device, DeviceCredentials)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#toString()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getCredentials()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getDevice()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Device device = new Device();
    DeviceCredentials credentials = new DeviceCredentials();

    // Act
    SaveDeviceWithCredentialsRequest actualSaveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        device, credentials);
    String actualToStringResult = actualSaveDeviceWithCredentialsRequest.toString();
    DeviceCredentials actualCredentials = actualSaveDeviceWithCredentialsRequest.getCredentials();

    // Assert
    assertEquals(
        "SaveDeviceWithCredentialsRequest(device=Device(super=BaseData [createdTime=0, id=null], tenantId=null,"
            + " customerId=null, name=null, type=null, label=null, deviceProfileId=null, deviceData=null, deviceDataBytes"
            + "=null, firmwareId=null, softwareId=null, externalId=null, version=null), credentials=DeviceCredentials"
            + " [deviceId=null, credentialsType=null, credentialsId=null, credentialsValue=null, createdTime=0,"
            + " id=null])",
        actualToStringResult);
    assertSame(device, actualSaveDeviceWithCredentialsRequest.getDevice());
    assertSame(credentials, actualCredentials);
  }
}
