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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemInfoDiffblueTest {
  /**
   * Test {@link SystemInfo#equals(Object)}, and {@link SystemInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfo#equals(Object)}
   *   <li>{@link SystemInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    SystemInfo systemInfo2 = new SystemInfo();
    systemInfo2.setMonolith(true);
    systemInfo2.setSystemData(new ArrayList<>());

    // Act and Assert
    assertEquals(systemInfo, systemInfo2);
    assertEquals(systemInfo.hashCode(), systemInfo2.hashCode());
  }

  /**
   * Test {@link SystemInfo#equals(Object)}, and {@link SystemInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfo#equals(Object)}
   *   <li>{@link SystemInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    // Act and Assert
    assertEquals(systemInfo, systemInfo);
    int expectedHashCodeResult = systemInfo.hashCode();
    assertEquals(expectedHashCodeResult, systemInfo.hashCode());
  }

  /**
   * Test {@link SystemInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(false);
    systemInfo.setSystemData(new ArrayList<>());

    SystemInfo systemInfo2 = new SystemInfo();
    systemInfo2.setMonolith(true);
    systemInfo2.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, systemInfo2);
  }

  /**
   * Test {@link SystemInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    ArrayList<SystemInfoData> systemData = new ArrayList<>();
    systemData.add(systemInfoData);

    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(systemData);

    SystemInfo systemInfo2 = new SystemInfo();
    systemInfo2.setMonolith(true);
    systemInfo2.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, systemInfo2);
  }

  /**
   * Test {@link SystemInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, null);
  }

  /**
   * Test {@link SystemInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfo.equals(Object)", "int SystemInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, "Different type to SystemInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemInfo}
   *   <li>{@link SystemInfo#setMonolith(boolean)}
   *   <li>{@link SystemInfo#setSystemData(List)}
   *   <li>{@link SystemInfo#toString()}
   *   <li>{@link SystemInfo#getSystemData()}
   *   <li>{@link SystemInfo#isMonolith()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemInfo.<init>()",
    "List SystemInfo.getSystemData()",
    "boolean SystemInfo.isMonolith()",
    "void SystemInfo.setMonolith(boolean)",
    "void SystemInfo.setSystemData(List)",
    "String SystemInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SystemInfo actualSystemInfo = new SystemInfo();
    actualSystemInfo.setMonolith(true);
    ArrayList<SystemInfoData> systemData = new ArrayList<>();
    actualSystemInfo.setSystemData(systemData);
    String actualToStringResult = actualSystemInfo.toString();
    List<SystemInfoData> actualSystemData = actualSystemInfo.getSystemData();
    boolean actualIsMonolithResult = actualSystemInfo.isMonolith();

    // Assert
    assertEquals("SystemInfo(isMonolith=true, systemData=[])", actualToStringResult);
    assertTrue(actualSystemData.isEmpty());
    assertTrue(actualIsMonolithResult);
    assertSame(systemData, actualSystemData);
  }
}
