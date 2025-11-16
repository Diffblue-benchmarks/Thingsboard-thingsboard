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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmInfo;

class TbAlarmResultDiffblueTest {
  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Updated.
   * </ul>
   *
   * <p>Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName("Test fromAlarmResult(AlarmApiCallResult); given 'false'; then return Updated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbAlarmResult TbAlarmResult.fromAlarmResult(AlarmApiCallResult)"})
  void testFromAlarmResult_givenFalse_thenReturnUpdated() {
    // Arrange
    AlarmApiCallResult result = mock(AlarmApiCallResult.class);
    when(result.isModified()).thenReturn(true);
    when(result.isSeverityChanged()).thenReturn(false);
    when(result.isCleared()).thenReturn(true);
    when(result.isCreated()).thenReturn(true);
    AlarmInfo alarmInfo = new AlarmInfo();
    when(result.getAlarm()).thenReturn(alarmInfo);

    // Act
    TbAlarmResult actualFromAlarmResultResult = TbAlarmResult.fromAlarmResult(result);

    // Assert
    verify(result).getAlarm();
    verify(result).isCleared();
    verify(result).isCreated();
    verify(result).isModified();
    verify(result).isSeverityChanged();
    Alarm alarm = actualFromAlarmResultResult.getAlarm();
    assertTrue(alarm instanceof AlarmInfo);
    assertFalse(actualFromAlarmResultResult.isSeverityUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertTrue(actualFromAlarmResultResult.isUpdated());
    assertSame(alarmInfo, alarm);
  }

  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   *
   * <ul>
   *   <li>Then return SeverityUpdated.
   * </ul>
   *
   * <p>Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName("Test fromAlarmResult(AlarmApiCallResult); then return SeverityUpdated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbAlarmResult TbAlarmResult.fromAlarmResult(AlarmApiCallResult)"})
  void testFromAlarmResult_thenReturnSeverityUpdated() {
    // Arrange
    AlarmApiCallResult result = mock(AlarmApiCallResult.class);
    when(result.isCleared()).thenReturn(true);
    when(result.isCreated()).thenReturn(true);
    when(result.isModified()).thenReturn(true);
    when(result.isSeverityChanged()).thenReturn(true);
    AlarmInfo alarmInfo = new AlarmInfo();
    when(result.getAlarm()).thenReturn(alarmInfo);

    // Act
    TbAlarmResult actualFromAlarmResultResult = TbAlarmResult.fromAlarmResult(result);

    // Assert
    verify(result).getAlarm();
    verify(result).isCleared();
    verify(result).isCreated();
    verify(result).isModified();
    verify(result).isSeverityChanged();
    Alarm alarm = actualFromAlarmResultResult.getAlarm();
    assertTrue(alarm instanceof AlarmInfo);
    assertFalse(actualFromAlarmResultResult.isUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertTrue(actualFromAlarmResultResult.isSeverityUpdated());
    assertSame(alarmInfo, alarm);
  }

  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   *
   * <ul>
   *   <li>When {@link AlarmApiCallResult} {@link AlarmApiCallResult#isModified()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName(
      "Test fromAlarmResult(AlarmApiCallResult); when AlarmApiCallResult isModified() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbAlarmResult TbAlarmResult.fromAlarmResult(AlarmApiCallResult)"})
  void testFromAlarmResult_whenAlarmApiCallResultIsModifiedReturnFalse() {
    // Arrange
    AlarmApiCallResult result = mock(AlarmApiCallResult.class);
    when(result.isModified()).thenReturn(false);
    when(result.isSeverityChanged()).thenReturn(false);
    when(result.isCleared()).thenReturn(true);
    when(result.isCreated()).thenReturn(true);
    AlarmInfo alarmInfo = new AlarmInfo();
    when(result.getAlarm()).thenReturn(alarmInfo);

    // Act
    TbAlarmResult actualFromAlarmResultResult = TbAlarmResult.fromAlarmResult(result);

    // Assert
    verify(result).getAlarm();
    verify(result).isCleared();
    verify(result).isCreated();
    verify(result).isModified();
    verify(result).isSeverityChanged();
    Alarm alarm = actualFromAlarmResultResult.getAlarm();
    assertTrue(alarm instanceof AlarmInfo);
    assertFalse(actualFromAlarmResultResult.isSeverityUpdated());
    assertFalse(actualFromAlarmResultResult.isUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertSame(alarmInfo, alarm);
  }
}
