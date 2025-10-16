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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceTypeFilterDiffblueTest {
  /**
   * Test {@link DeviceTypeFilter#getDeviceTypes()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return first is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#getDeviceTypes()}
   */
  @Test
  @DisplayName("Test getDeviceTypes(); given ArrayList() add 'foo'; then return first is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceTypeFilter.getDeviceTypes()"})
  void testGetDeviceTypes_givenArrayListAddFoo_thenReturnFirstIsFoo() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("foo");
    DeviceTypeFilter deviceTypeFilter =
        new DeviceTypeFilter("Device Type", deviceTypes, "Device Name Filter");

    // Act
    List<String> actualDeviceTypes = deviceTypeFilter.getDeviceTypes();

    // Assert
    assertEquals(1, actualDeviceTypes.size());
    assertEquals("foo", actualDeviceTypes.get(0));
    assertSame(deviceTypes, actualDeviceTypes);
  }

  /**
   * Test {@link DeviceTypeFilter#getDeviceTypes()}.
   *
   * <ul>
   *   <li>Given {@link DeviceTypeFilter#DeviceTypeFilter()}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#getDeviceTypes()}
   */
  @Test
  @DisplayName("Test getDeviceTypes(); given DeviceTypeFilter(); then return first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceTypeFilter.getDeviceTypes()"})
  void testGetDeviceTypes_givenDeviceTypeFilter_thenReturnFirstIsNull() {
    // Arrange and Act
    List<String> actualDeviceTypes = new DeviceTypeFilter().getDeviceTypes();

    // Assert
    assertEquals(1, actualDeviceTypes.size());
    assertNull(actualDeviceTypes.get(0));
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}, and {@link DeviceTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();
    DeviceTypeFilter deviceTypeFilter2 = new DeviceTypeFilter();

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    assertEquals(deviceTypeFilter.hashCode(), deviceTypeFilter2.hashCode());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}, and {@link DeviceTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter =
        new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");
    DeviceTypeFilter deviceTypeFilter2 =
        new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    assertEquals(deviceTypeFilter.hashCode(), deviceTypeFilter2.hashCode());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}, and {@link DeviceTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter =
        new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");
    DeviceTypeFilter deviceTypeFilter2 =
        new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter2);
    assertEquals(deviceTypeFilter.hashCode(), deviceTypeFilter2.hashCode());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}, and {@link DeviceTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceTypeFilter#equals(Object)}
   *   <li>{@link DeviceTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertEquals(deviceTypeFilter, deviceTypeFilter);
    int expectedHashCodeResult = deviceTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceTypeFilter.hashCode());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter =
        new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter =
        new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertNotEquals(
        deviceTypeFilter, new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter"));
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter();

    // Act and Assert
    assertNotEquals(
        deviceTypeFilter,
        new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter"));
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("foo");
    DeviceTypeFilter deviceTypeFilter = new DeviceTypeFilter(deviceTypes, "Device Name Filter");

    // Act and Assert
    assertNotEquals(deviceTypeFilter, new DeviceTypeFilter());
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceTypeFilter(), null);
  }

  /**
   * Test {@link DeviceTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceTypeFilter.equals(Object)", "int DeviceTypeFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceTypeFilter(), "Different type to DeviceTypeFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceTypeFilter.<init>()",
    "void DeviceTypeFilter.<init>(String, List, String)",
    "void DeviceTypeFilter.<init>(List, String)",
    "String DeviceTypeFilter.getDeviceNameFilter()",
    "EntityFilterType DeviceTypeFilter.getType()",
    "void DeviceTypeFilter.setDeviceNameFilter(String)",
    "void DeviceTypeFilter.setDeviceType(String)",
    "void DeviceTypeFilter.setDeviceTypes(List)",
    "String DeviceTypeFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter = new DeviceTypeFilter();
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name"
            + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceTypeFilter.<init>()",
    "void DeviceTypeFilter.<init>(String, List, String)",
    "void DeviceTypeFilter.<init>(List, String)",
    "String DeviceTypeFilter.getDeviceNameFilter()",
    "EntityFilterType DeviceTypeFilter.getType()",
    "void DeviceTypeFilter.setDeviceNameFilter(String)",
    "void DeviceTypeFilter.setDeviceType(String)",
    "void DeviceTypeFilter.setDeviceTypes(List)",
    "String DeviceTypeFilter.toString()"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter =
        new DeviceTypeFilter(new ArrayList<>(), "Device Name Filter");
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name"
            + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Device Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; when 'Device Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceTypeFilter.<init>()",
    "void DeviceTypeFilter.<init>(String, List, String)",
    "void DeviceTypeFilter.<init>(List, String)",
    "String DeviceTypeFilter.getDeviceNameFilter()",
    "EntityFilterType DeviceTypeFilter.getType()",
    "void DeviceTypeFilter.setDeviceNameFilter(String)",
    "void DeviceTypeFilter.setDeviceType(String)",
    "void DeviceTypeFilter.setDeviceTypes(List)",
    "String DeviceTypeFilter.toString()"
  })
  void testGettersAndSetters_whenDeviceType() {
    // Arrange and Act
    DeviceTypeFilter actualDeviceTypeFilter =
        new DeviceTypeFilter("Device Type", new ArrayList<>(), "Device Name Filter");
    actualDeviceTypeFilter.setDeviceNameFilter("Device Name Filter");
    actualDeviceTypeFilter.setDeviceType("Device Type");
    actualDeviceTypeFilter.setDeviceTypes(new ArrayList<>());
    String actualToStringResult = actualDeviceTypeFilter.toString();
    String actualDeviceNameFilter = actualDeviceTypeFilter.getDeviceNameFilter();

    // Assert
    assertEquals("Device Name Filter", actualDeviceNameFilter);
    assertEquals(
        "DeviceTypeFilter(deviceType=Device Type, deviceTypes=[Device Type], deviceNameFilter=Device Name"
            + " Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.DEVICE_TYPE, actualDeviceTypeFilter.getType());
  }
}
