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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SystemInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SystemInfo#equals(Object)}
   *   <li>{@link SystemInfo#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = systemInfo.hashCode();
    assertEquals(expectedHashCodeResult, systemInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SystemInfo#equals(Object)}
   *   <li>{@link SystemInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SystemInfoData systemInfoData = mock(SystemInfoData.class);
    doNothing().when(systemInfoData).setCpuCount(Mockito.<Long>any());
    doNothing().when(systemInfoData).setCpuUsage(Mockito.<Long>any());
    doNothing().when(systemInfoData).setDiscUsage(Mockito.<Long>any());
    doNothing().when(systemInfoData).setMemoryUsage(Mockito.<Long>any());
    doNothing().when(systemInfoData).setServiceId(Mockito.<String>any());
    doNothing().when(systemInfoData).setServiceType(Mockito.<String>any());
    doNothing().when(systemInfoData).setTotalDiscSpace(Mockito.<Long>any());
    doNothing().when(systemInfoData).setTotalMemory(Mockito.<Long>any());
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
   * Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, null);
  }

  /**
   * Method under test: {@link SystemInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(systemInfo, "Different type to SystemInfo");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    SystemInfo actualSystemInfo = new SystemInfo();
    actualSystemInfo.setMonolith(true);
    ArrayList<SystemInfoData> systemData = new ArrayList<>();
    actualSystemInfo.setSystemData(systemData);
    String actualToStringResult = actualSystemInfo.toString();
    List<SystemInfoData> actualSystemData = actualSystemInfo.getSystemData();
    boolean actualIsMonolithResult = actualSystemInfo.isMonolith();

    // Assert that nothing has changed
    assertEquals("SystemInfo(isMonolith=true, systemData=[])", actualToStringResult);
    assertTrue(actualSystemData.isEmpty());
    assertTrue(actualIsMonolithResult);
    assertSame(systemData, actualSystemData);
  }
}
