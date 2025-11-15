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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AlarmPropagationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo.AlarmPropagationInfoBuilder#build()}
   *   <li>
   * {@link AlarmPropagationInfo.AlarmPropagationInfoBuilder#propagate(boolean)}
   *   <li>
   * {@link AlarmPropagationInfo.AlarmPropagationInfoBuilder#propagateRelationTypes(List)}
   *   <li>
   * {@link AlarmPropagationInfo.AlarmPropagationInfoBuilder#propagateToOwner(boolean)}
   *   <li>
   * {@link AlarmPropagationInfo.AlarmPropagationInfoBuilder#propagateToTenant(boolean)}
   * </ul>
   */
  @Test
  void testAlarmPropagationInfoBuilderBuild() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();

    // Act
    AlarmPropagationInfo actualBuildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Assert
    List<String> propagateRelationTypes2 = actualBuildResult.getPropagateRelationTypes();
    assertTrue(propagateRelationTypes2.isEmpty());
    assertTrue(actualBuildResult.isPropagate());
    assertTrue(actualBuildResult.isPropagateToOwner());
    assertTrue(actualBuildResult.isPropagateToTenant());
    assertSame(propagateRelationTypes, propagateRelationTypes2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagate(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder.propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagate(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagateRelationTypes(Mockito.<List<String>>any()))
        .thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder2 = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder2.propagate(anyBoolean())).thenReturn(alarmPropagationInfoBuilder);
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder2.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagateToOwner(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder2 = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder2.propagateRelationTypes(Mockito.<List<String>>any()))
        .thenReturn(alarmPropagationInfoBuilder);
    AlarmPropagationInfo.AlarmPropagationInfoBuilder alarmPropagationInfoBuilder3 = mock(
        AlarmPropagationInfo.AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder3.propagate(anyBoolean())).thenReturn(alarmPropagationInfoBuilder2);
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder3.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfo.AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmPropagationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmPropagationInfo#AlarmPropagationInfo(boolean, boolean, boolean, List)}
   *   <li>{@link AlarmPropagationInfo#setPropagate(boolean)}
   *   <li>{@link AlarmPropagationInfo#setPropagateRelationTypes(List)}
   *   <li>{@link AlarmPropagationInfo#setPropagateToOwner(boolean)}
   *   <li>{@link AlarmPropagationInfo#setPropagateToTenant(boolean)}
   *   <li>{@link AlarmPropagationInfo#toString()}
   *   <li>{@link AlarmPropagationInfo#getPropagateRelationTypes()}
   *   <li>{@link AlarmPropagationInfo#isPropagate()}
   *   <li>{@link AlarmPropagationInfo#isPropagateToOwner()}
   *   <li>{@link AlarmPropagationInfo#isPropagateToTenant()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmPropagationInfo actualAlarmPropagationInfo = new AlarmPropagationInfo(true, true, true, new ArrayList<>());
    actualAlarmPropagationInfo.setPropagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    actualAlarmPropagationInfo.setPropagateRelationTypes(propagateRelationTypes);
    actualAlarmPropagationInfo.setPropagateToOwner(true);
    actualAlarmPropagationInfo.setPropagateToTenant(true);
    String actualToStringResult = actualAlarmPropagationInfo.toString();
    List<String> actualPropagateRelationTypes = actualAlarmPropagationInfo.getPropagateRelationTypes();
    boolean actualIsPropagateResult = actualAlarmPropagationInfo.isPropagate();
    boolean actualIsPropagateToOwnerResult = actualAlarmPropagationInfo.isPropagateToOwner();
    boolean actualIsPropagateToTenantResult = actualAlarmPropagationInfo.isPropagateToTenant();

    // Assert that nothing has changed
    assertEquals(
        "AlarmPropagationInfo(propagate=true, propagateToOwner=true, propagateToTenant=true, propagateRelationTypes"
            + "=[])",
        actualToStringResult);
    assertTrue(actualPropagateRelationTypes.isEmpty());
    assertTrue(actualIsPropagateResult);
    assertTrue(actualIsPropagateToOwnerResult);
    assertTrue(actualIsPropagateToTenantResult);
    assertSame(propagateRelationTypes, actualPropagateRelationTypes);
  }
}
