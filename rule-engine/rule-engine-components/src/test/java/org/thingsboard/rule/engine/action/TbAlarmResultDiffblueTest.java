package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmInfo;

class TbAlarmResultDiffblueTest {
  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   * <ul>
   *   <li>Then return not SeverityUpdated.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName("Test fromAlarmResult(AlarmApiCallResult); then return not SeverityUpdated")
  void testFromAlarmResult_thenReturnNotSeverityUpdated() {
    // Arrange
    AlarmApiCallResult result = mock(AlarmApiCallResult.class);
    when(result.isCleared()).thenReturn(true);
    when(result.isCreated()).thenReturn(true);
    when(result.isModified()).thenReturn(true);
    when(result.isSeverityChanged()).thenReturn(false);
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
    assertFalse(actualFromAlarmResultResult.isSeverityUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertTrue(actualFromAlarmResultResult.isUpdated());
    assertSame(alarmInfo, actualFromAlarmResultResult.getAlarm());
  }

  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   * <ul>
   *   <li>Then return not Updated.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName("Test fromAlarmResult(AlarmApiCallResult); then return not Updated")
  void testFromAlarmResult_thenReturnNotUpdated() {
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
    assertFalse(actualFromAlarmResultResult.isUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertTrue(actualFromAlarmResultResult.isSeverityUpdated());
    assertSame(alarmInfo, actualFromAlarmResultResult.getAlarm());
  }

  /**
   * Test {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}.
   * <ul>
   *   <li>When {@link AlarmApiCallResult} {@link AlarmApiCallResult#isModified()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAlarmResult#fromAlarmResult(AlarmApiCallResult)}
   */
  @Test
  @DisplayName("Test fromAlarmResult(AlarmApiCallResult); when AlarmApiCallResult isModified() return 'false'")
  void testFromAlarmResult_whenAlarmApiCallResultIsModifiedReturnFalse() {
    // Arrange
    AlarmApiCallResult result = mock(AlarmApiCallResult.class);
    when(result.isCleared()).thenReturn(true);
    when(result.isCreated()).thenReturn(true);
    when(result.isModified()).thenReturn(false);
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
    assertFalse(actualFromAlarmResultResult.isUpdated());
    assertTrue(actualFromAlarmResultResult.isCleared());
    assertTrue(actualFromAlarmResultResult.isCreated());
    assertTrue(actualFromAlarmResultResult.isSeverityUpdated());
    assertSame(alarmInfo, actualFromAlarmResultResult.getAlarm());
  }
}
