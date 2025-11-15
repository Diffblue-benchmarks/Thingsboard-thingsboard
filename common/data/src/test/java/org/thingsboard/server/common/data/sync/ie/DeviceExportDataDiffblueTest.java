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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceExportDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    DeviceExportData deviceExportData2 = new DeviceExportData();

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData2);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData2.hashCode());
  }

  /**
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  void testHasCredentials() {
    // Arrange, Act and Assert
    assertFalse((new DeviceExportData()).hasCredentials());
  }

  /**
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  void testHasCredentials2() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertTrue(deviceExportData.hasCredentials());
  }

  /**
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  void testHasCredentials3() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setAttributes(attributes);

    // Act and Assert
    assertFalse(deviceExportData.hasCredentials());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    DeviceExportData deviceExportData2 = new DeviceExportData();
    deviceExportData2.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData2);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData.hashCode());
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), 1);
    assertNotEquals(new DeviceExportData(), mock(EntityExportData.class));
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertNotEquals(deviceExportData, new DeviceExportData());
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setEntity(new Device());

    // Act and Assert
    assertNotEquals(deviceExportData, new DeviceExportData());
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();

    DeviceExportData deviceExportData2 = new DeviceExportData();
    deviceExportData2.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertNotEquals(deviceExportData, deviceExportData2);
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), null);
  }

  /**
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), "Different type to DeviceExportData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceExportData}
   *   <li>{@link DeviceExportData#setCredentials(DeviceCredentials)}
   *   <li>{@link DeviceExportData#toString()}
   *   <li>{@link DeviceExportData#getCredentials()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceExportData actualDeviceExportData = new DeviceExportData();
    DeviceCredentials credentials = new DeviceCredentials();
    actualDeviceExportData.setCredentials(credentials);
    String actualToStringResult = actualDeviceExportData.toString();

    // Assert that nothing has changed
    assertEquals(
        "DeviceExportData(super=EntityExportData(entity=null, entityType=null, relations=null, attributes=null),"
            + " credentials=DeviceCredentials [deviceId=null, credentialsType=null, credentialsId=null, credentialsValue"
            + "=null, createdTime=0, id=null])",
        actualToStringResult);
    assertSame(credentials, actualDeviceExportData.getCredentials());
  }
}
