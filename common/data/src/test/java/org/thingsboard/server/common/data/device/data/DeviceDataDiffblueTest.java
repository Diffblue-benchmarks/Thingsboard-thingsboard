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
package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class DeviceDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceData#equals(Object)}
   *   <li>{@link DeviceData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(null);

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(null);

    // Act and Assert
    assertEquals(deviceData, deviceData2);
    int expectedHashCodeResult = deviceData.hashCode();
    assertEquals(expectedHashCodeResult, deviceData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceData#equals(Object)}
   *   <li>{@link DeviceData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertEquals(deviceData, deviceData);
    int expectedHashCodeResult = deviceData.hashCode();
    assertEquals(expectedHashCodeResult, deviceData.hashCode());
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(mock(DeviceConfiguration.class));
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(mock(DeviceConfiguration.class));
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(null);

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, null);
  }

  /**
   * Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, "Different type to DeviceData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceData}
   *   <li>{@link DeviceData#setConfiguration(DeviceConfiguration)}
   *   <li>
   * {@link DeviceData#setTransportConfiguration(DeviceTransportConfiguration)}
   *   <li>{@link DeviceData#toString()}
   *   <li>{@link DeviceData#getConfiguration()}
   *   <li>{@link DeviceData#getTransportConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceData actualDeviceData = new DeviceData();
    DeviceConfiguration configuration = mock(DeviceConfiguration.class);
    actualDeviceData.setConfiguration(configuration);
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    actualDeviceData.setTransportConfiguration(transportConfiguration);
    actualDeviceData.toString();
    DeviceConfiguration actualConfiguration = actualDeviceData.getConfiguration();

    // Assert that nothing has changed
    assertSame(configuration, actualConfiguration);
    assertSame(transportConfiguration, actualDeviceData.getTransportConfiguration());
  }
}
