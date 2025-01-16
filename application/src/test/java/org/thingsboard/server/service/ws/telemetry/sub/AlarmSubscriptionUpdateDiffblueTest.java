package org.thingsboard.server.service.ws.telemetry.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.service.subscription.SubscriptionErrorCode;

@DisabledInAotMode
class AlarmSubscriptionUpdateDiffblueTest {
  @MockBean
  private AlarmSubscriptionUpdate alarmSubscriptionUpdate;

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link AlarmInfo#AlarmInfo()}.</li>
   *   <li>Then return not AlarmDeleted.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(AlarmInfo)}
   *   <li>{@link AlarmSubscriptionUpdate#toString()}
   *   <li>{@link AlarmSubscriptionUpdate#getAlarm()}
   *   <li>{@link AlarmSubscriptionUpdate#getErrorCode()}
   *   <li>{@link AlarmSubscriptionUpdate#getErrorMsg()}
   *   <li>{@link AlarmSubscriptionUpdate#isAlarmDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AlarmInfo(); then return not AlarmDeleted")
  void testGettersAndSetters_whenAlarmInfo_thenReturnNotAlarmDeleted() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();

    // Act
    AlarmSubscriptionUpdate actualAlarmSubscriptionUpdate = new AlarmSubscriptionUpdate(alarm);
    String actualToStringResult = actualAlarmSubscriptionUpdate.toString();
    AlarmInfo actualAlarm = actualAlarmSubscriptionUpdate.getAlarm();
    int actualErrorCode = actualAlarmSubscriptionUpdate.getErrorCode();
    String actualErrorMsg = actualAlarmSubscriptionUpdate.getErrorMsg();

    // Assert
    assertEquals("AlarmSubscriptionUpdate(errorCode=0, errorMsg=null, alarm=AlarmInfo(super=Alarm(tenantId=null,"
        + " customerId=null, type=null, originator=null, severity=null, acknowledged=false, cleared=false,"
        + " assigneeId=null, startTs=0, endTs=0, ackTs=0, clearTs=0, assignTs=0, details=null, propagate=false,"
        + " propagateToOwner=false, propagateToTenant=false, propagateRelationTypes=null), originatorName=null,"
        + " originatorLabel=null, assignee=null), alarmDeleted=false)", actualToStringResult);
    assertNull(actualErrorMsg);
    assertEquals(0, actualErrorCode);
    assertFalse(actualAlarmSubscriptionUpdate.isAlarmDeleted());
    assertSame(alarm, actualAlarm);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return AlarmDeleted.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(AlarmInfo, boolean)}
   *   <li>{@link AlarmSubscriptionUpdate#toString()}
   *   <li>{@link AlarmSubscriptionUpdate#getAlarm()}
   *   <li>{@link AlarmSubscriptionUpdate#getErrorCode()}
   *   <li>{@link AlarmSubscriptionUpdate#getErrorMsg()}
   *   <li>{@link AlarmSubscriptionUpdate#isAlarmDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return AlarmDeleted")
  void testGettersAndSetters_whenTrue_thenReturnAlarmDeleted() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();

    // Act
    AlarmSubscriptionUpdate actualAlarmSubscriptionUpdate = new AlarmSubscriptionUpdate(alarm, true);
    String actualToStringResult = actualAlarmSubscriptionUpdate.toString();
    AlarmInfo actualAlarm = actualAlarmSubscriptionUpdate.getAlarm();
    int actualErrorCode = actualAlarmSubscriptionUpdate.getErrorCode();
    String actualErrorMsg = actualAlarmSubscriptionUpdate.getErrorMsg();

    // Assert
    assertEquals("AlarmSubscriptionUpdate(errorCode=0, errorMsg=null, alarm=AlarmInfo(super=Alarm(tenantId=null,"
        + " customerId=null, type=null, originator=null, severity=null, acknowledged=false, cleared=false,"
        + " assigneeId=null, startTs=0, endTs=0, ackTs=0, clearTs=0, assignTs=0, details=null, propagate=false,"
        + " propagateToOwner=false, propagateToTenant=false, propagateRelationTypes=null), originatorName=null,"
        + " originatorLabel=null, assignee=null), alarmDeleted=true)", actualToStringResult);
    assertNull(actualErrorMsg);
    assertEquals(0, actualErrorCode);
    assertTrue(actualAlarmSubscriptionUpdate.isAlarmDeleted());
    assertSame(alarm, actualAlarm);
  }

  /**
   * Test
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode, String)}.
   * <ul>
   *   <li>When {@code NO_ERROR}.</li>
   *   <li>Then return ErrorMsg is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode, String)}
   */
  @Test
  @DisplayName("Test new AlarmSubscriptionUpdate(SubscriptionErrorCode, String); when 'NO_ERROR'; then return ErrorMsg is 'An error occurred'")
  void testNewAlarmSubscriptionUpdate_whenNoError_thenReturnErrorMsgIsAnErrorOccurred() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AlarmSubscriptionUpdate actualAlarmSubscriptionUpdate = new AlarmSubscriptionUpdate(SubscriptionErrorCode.NO_ERROR,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualAlarmSubscriptionUpdate.getErrorMsg());
    assertNull(actualAlarmSubscriptionUpdate.getAlarm());
    assertEquals(0, actualAlarmSubscriptionUpdate.getErrorCode());
    assertFalse(actualAlarmSubscriptionUpdate.isAlarmDeleted());
  }

  /**
   * Test
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode)}.
   * <ul>
   *   <li>When {@code NO_ERROR}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode)}
   */
  @Test
  @DisplayName("Test new AlarmSubscriptionUpdate(SubscriptionErrorCode); when 'NO_ERROR'; then return ErrorMsg is 'null'")
  void testNewAlarmSubscriptionUpdate_whenNoError_thenReturnErrorMsgIsNull() {
    // Arrange and Act
    AlarmSubscriptionUpdate actualAlarmSubscriptionUpdate = new AlarmSubscriptionUpdate(SubscriptionErrorCode.NO_ERROR);

    // Assert
    assertNull(actualAlarmSubscriptionUpdate.getErrorMsg());
    assertNull(actualAlarmSubscriptionUpdate.getAlarm());
    assertEquals(0, actualAlarmSubscriptionUpdate.getErrorCode());
    assertFalse(actualAlarmSubscriptionUpdate.isAlarmDeleted());
  }

  /**
   * Test
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode, String)}.
   * <ul>
   *   <li>When {@code NO_ERROR}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmSubscriptionUpdate#AlarmSubscriptionUpdate(SubscriptionErrorCode, String)}
   */
  @Test
  @DisplayName("Test new AlarmSubscriptionUpdate(SubscriptionErrorCode, String); when 'NO_ERROR'; then return ErrorMsg is 'null'")
  void testNewAlarmSubscriptionUpdate_whenNoError_thenReturnErrorMsgIsNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AlarmSubscriptionUpdate actualAlarmSubscriptionUpdate = new AlarmSubscriptionUpdate(SubscriptionErrorCode.NO_ERROR,
        null);

    // Assert
    assertNull(actualAlarmSubscriptionUpdate.getErrorMsg());
    assertNull(actualAlarmSubscriptionUpdate.getAlarm());
    assertEquals(0, actualAlarmSubscriptionUpdate.getErrorCode());
    assertFalse(actualAlarmSubscriptionUpdate.isAlarmDeleted());
  }
}
