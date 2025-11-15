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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DeviceTypeFilterDiffblueTest {
  /**
   * Method under test: {@link DeviceTypeFilter#getDeviceTypes()}
   */
  @Test
  void testGetDeviceTypes() {
    // Arrange and Act
    List<String> actualDeviceTypes = (new DeviceTypeFilter()).getDeviceTypes();

    // Assert
    assertEquals(1, actualDeviceTypes.size());
    assertNull(actualDeviceTypes.get(0));
  }

  /**
   * Method under test: {@link DeviceTypeFilter#getDeviceTypes()}
   */
  @Test
  void testGetDeviceTypes2() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("foo");

    // Act
    List<String> actualDeviceTypes = (new DeviceTypeFilter(deviceTypes, "Device Name Filter")).getDeviceTypes();

    // Assert
    assertEquals(1, actualDeviceTypes.size());
    assertEquals("foo", actualDeviceTypes.get(0));
    assertSame(deviceTypes, actualDeviceTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();
    DeviceTypeFilter deviceTypeFilter2 = new DeviceTypeFilter();

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    int expectedHashCodeResult = deviceTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");
    DeviceTypeFilter deviceTypeFilter2 = new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    int expectedHashCodeResult = deviceTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");
    DeviceTypeFilter deviceTypeFilter2 = new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    int expectedHashCodeResult = deviceTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter);
    int expectedHashCodeResult = deviceTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter"));
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter"));
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("foo");
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter(deviceTypes, "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceTypeFilter(), null);
  }

  /**
   * Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceTypeFilter(), "Different type to DeviceTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#DeviceTypeFilter()}
   *   <li>{@link DeviceTypeFilter#setDeviceNameFilter(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceType(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceTypes(List)}
   *   <li>{@link DeviceTypeFilter#toString()}
   *   <li>{@link DeviceTypeFilter#getDeviceNameFilter()}
   *   <li>{@link DeviceTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter = new DeviceTypeFilter();
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert that nothing has changed
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name" + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#DeviceTypeFilter(String, List, String)}
   *   <li>{@link DeviceTypeFilter#setDeviceNameFilter(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceType(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceTypes(List)}
   *   <li>{@link DeviceTypeFilter#toString()}
   *   <li>{@link DeviceTypeFilter#getDeviceNameFilter()}
   *   <li>{@link DeviceTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter = new DeviceTypeFilter("Device Type", new ArrayList<>(),
        "Device Name Filter");
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert that nothing has changed
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name" + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTypeFilter#DeviceTypeFilter(List, String)}
   *   <li>{@link DeviceTypeFilter#setDeviceNameFilter(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceType(String)}
   *   <li>{@link DeviceTypeFilter#setDeviceTypes(List)}
   *   <li>{@link DeviceTypeFilter#toString()}
   *   <li>{@link DeviceTypeFilter#getDeviceNameFilter()}
   *   <li>{@link DeviceTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter = new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert that nothing has changed
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name" + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }
}
