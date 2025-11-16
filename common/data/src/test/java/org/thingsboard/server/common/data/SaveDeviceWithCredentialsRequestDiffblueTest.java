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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class SaveDeviceWithCredentialsRequestDiffblueTest {
  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and {@link
   * SaveDeviceWithCredentialsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());
    Device device2 = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    assertEquals(
        saveDeviceWithCredentialsRequest.hashCode(), saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and {@link
   * SaveDeviceWithCredentialsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(null, new DeviceCredentials());
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(null, new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    assertEquals(
        saveDeviceWithCredentialsRequest.hashCode(), saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and {@link
   * SaveDeviceWithCredentialsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(new Device(), null);
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(new Device(), null);

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    assertEquals(
        saveDeviceWithCredentialsRequest.hashCode(), saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and {@link
   * SaveDeviceWithCredentialsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(null, new DeviceCredentials());
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfo device = new DeviceInfo();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());
    Device device2 = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(new Device(), null);
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Device device = new Device();
    DeviceCredentials credentials =
        new DeviceCredentials(new DeviceCredentialsId(EntityId.NULL_UUID));

    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, credentials);
    Device device2 = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 =
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest, null);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SaveDeviceWithCredentialsRequest.equals(Object)",
    "int SaveDeviceWithCredentialsRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(
        saveDeviceWithCredentialsRequest, "Different type to SaveDeviceWithCredentialsRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#SaveDeviceWithCredentialsRequest(Device,
   *       DeviceCredentials)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#toString()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getCredentials()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getDevice()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SaveDeviceWithCredentialsRequest.<init>(Device, DeviceCredentials)",
    "DeviceCredentials SaveDeviceWithCredentialsRequest.getCredentials()",
    "Device SaveDeviceWithCredentialsRequest.getDevice()",
    "String SaveDeviceWithCredentialsRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Device device = new Device();
    DeviceCredentials credentials = new DeviceCredentials();

    // Act
    SaveDeviceWithCredentialsRequest actualSaveDeviceWithCredentialsRequest =
        new SaveDeviceWithCredentialsRequest(device, credentials);
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
