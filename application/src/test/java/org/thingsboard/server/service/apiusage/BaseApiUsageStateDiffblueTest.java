package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.apiusage.BaseApiUsageState.StatsCalculationResult;
import org.thingsboard.server.service.apiusage.BaseApiUsageState.StatsCalculationResult.StatsCalculationResultBuilder;

@ContextConfiguration(classes = {StatsCalculationResultBuilder.class, CustomerApiUsageState.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseApiUsageStateDiffblueTest {
  @MockBean private ApiUsageState apiUsageState;

  @Autowired private BaseApiUsageState baseApiUsageState;

  @Autowired private StatsCalculationResultBuilder statsCalculationResultBuilder;

  /**
   * Test {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState}.
   *   <li>When {@code null}.
   *   <li>Then return NewValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculate(ApiUsageRecordKey, long, String); given ApiUsageState; when 'null'; then return NewValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "StatsCalculationResult BaseApiUsageState.calculate(ApiUsageRecordKey, long, String)"
  })
  void testCalculate_givenApiUsageState_whenNull_thenReturnNewValueIsFortyTwo() {
    // Arrange and Act
    StatsCalculationResult actualCalculateResult =
        baseApiUsageState.calculate(ApiUsageRecordKey.ACTIVE_DEVICES, 42L, null);

    // Assert
    assertEquals(42L, actualCalculateResult.getNewHourlyValue());
    assertEquals(42L, actualCalculateResult.getNewValue());
    assertFalse(actualCalculateResult.isHourlyValueChanged());
  }

  /**
   * Test {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState}.
   *   <li>When three.
   *   <li>Then return NewValue is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculate(ApiUsageRecordKey, long, String); given ApiUsageState; when three; then return NewValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "StatsCalculationResult BaseApiUsageState.calculate(ApiUsageRecordKey, long, String)"
  })
  void testCalculate_givenApiUsageState_whenThree_thenReturnNewValueIsThree() {
    // Arrange and Act
    StatsCalculationResult actualCalculateResult =
        baseApiUsageState.calculate(ApiUsageRecordKey.ACTIVE_DEVICES, 3L, "42");

    // Assert
    assertEquals(3L, actualCalculateResult.getNewValue());
    assertEquals(42L, actualCalculateResult.getNewHourlyValue());
    assertFalse(actualCalculateResult.isHourlyValueChanged());
  }

  /**
   * Test {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}.
   *
   * <ul>
   *   <li>Then return NewHourlyValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculate(ApiUsageRecordKey, long, String); then return NewHourlyValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "StatsCalculationResult BaseApiUsageState.calculate(ApiUsageRecordKey, long, String)"
  })
  void testCalculate_thenReturnNewHourlyValueIsZero() {
    // Arrange and Act
    StatsCalculationResult actualCalculateResult =
        new CustomerApiUsageState(new ApiUsageState())
            .calculate(ApiUsageRecordKey.ACTIVE_DEVICES, 0L, "42");

    // Assert
    assertEquals(0L, actualCalculateResult.getNewHourlyValue());
    assertEquals(0L, actualCalculateResult.getNewValue());
    assertTrue(actualCalculateResult.isHourlyValueChanged());
    assertTrue(actualCalculateResult.isValueChanged());
  }

  /**
   * Test {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}.
   *
   * <ul>
   *   <li>When {@code TRANSPORT_MSG_COUNT}.
   *   <li>Then return HourlyValueChanged.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculate(ApiUsageRecordKey, long, String); when 'TRANSPORT_MSG_COUNT'; then return HourlyValueChanged")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "StatsCalculationResult BaseApiUsageState.calculate(ApiUsageRecordKey, long, String)"
  })
  void testCalculate_whenTransportMsgCount_thenReturnHourlyValueChanged() {
    // Arrange and Act
    StatsCalculationResult actualCalculateResult =
        baseApiUsageState.calculate(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 42L, "42");

    // Assert
    assertTrue(actualCalculateResult.isHourlyValueChanged());
    assertTrue(actualCalculateResult.isValueChanged());
  }

  /**
   * Test {@link BaseApiUsageState#setHour(long)}.
   *
   * <p>Method under test: {@link BaseApiUsageState#setHour(long)}
   */
  @Test
  @DisplayName("Test setHour(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseApiUsageState.setHour(long)"})
  void testSetHour() {
    // Arrange and Act
    baseApiUsageState.setHour(1L);

    // Assert
    assertTrue(baseApiUsageState instanceof CustomerApiUsageState);
    assertEquals(1L, baseApiUsageState.getCurrentHourTs());
  }

  /**
   * Test {@link BaseApiUsageState#setCycles(long, long)}.
   *
   * <p>Method under test: {@link BaseApiUsageState#setCycles(long, long)}
   */
  @Test
  @DisplayName("Test setCycles(long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseApiUsageState.setCycles(long, long)"})
  void testSetCycles() {
    // Arrange and Act
    baseApiUsageState.setCycles(1L, 1L);

    // Assert
    assertTrue(baseApiUsageState instanceof CustomerApiUsageState);
    assertEquals(1L, baseApiUsageState.getCurrentCycleTs());
    assertEquals(1L, baseApiUsageState.getNextCycleTs());
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getAlarmExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getAlarmExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetAlarmExecState() {
    // Arrange
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.ALARM);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getDbStorageState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getDbStorageState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetDbStorageState() {
    // Arrange
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.DB);

    // Assert
    verify(apiUsageState).getDbStorageState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getEmailExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getEmailExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetEmailExecState() {
    // Arrange
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.EMAIL);

    // Assert
    verify(apiUsageState).getEmailExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getJsExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getJsExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetJsExecState() {
    // Arrange
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.JS);

    // Assert
    verify(apiUsageState).getJsExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getReExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getReExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetReExecState() {
    // Arrange
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.RE);

    // Assert
    verify(apiUsageState).getReExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getSmsExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getSmsExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetSmsExecState() {
    // Arrange
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.SMS);

    // Assert
    verify(apiUsageState).getSmsExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTbelExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getTbelExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetTbelExecState() {
    // Arrange
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.TBEL);

    // Assert
    verify(apiUsageState).getTbelExecState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#getFeatureValue(ApiFeature)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTransportState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#getFeatureValue(ApiFeature)}
   */
  @Test
  @DisplayName("Test getFeatureValue(ApiFeature); then calls getTransportState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue BaseApiUsageState.getFeatureValue(ApiFeature)"})
  void testGetFeatureValue_thenCallsGetTransportState() {
    // Arrange
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);

    // Act
    ApiUsageStateValue actualFeatureValue = baseApiUsageState.getFeatureValue(ApiFeature.TRANSPORT);

    // Assert
    verify(apiUsageState).getTransportState();
    assertEquals(ApiUsageStateValue.ENABLED, actualFeatureValue);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState} {@link ApiUsageState#getTransportState()} return {@code
   *       ENABLED}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test setFeatureValue(ApiFeature, ApiUsageStateValue); given ApiUsageState getTransportState() return 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_givenApiUsageStateGetTransportStateReturnEnabled() {
    // Arrange
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getAlarmExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getAlarmExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetAlarmExecState() {
    // Arrange
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setAlarmExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.ALARM, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getDbStorageState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getDbStorageState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetDbStorageState() {
    // Arrange
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.DB, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getEmailExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getEmailExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetEmailExecState() {
    // Arrange
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setEmailExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.EMAIL, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getJsExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getJsExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetJsExecState() {
    // Arrange
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setJsExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.JS, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getReExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getReExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetReExecState() {
    // Arrange
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.RE, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getSmsExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getSmsExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetSmsExecState() {
    // Arrange
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setSmsExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.SMS, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTbelExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test setFeatureValue(ApiFeature, ApiUsageStateValue); then calls getTbelExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenCallsGetTbelExecState() {
    // Arrange
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTbelExecState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.TBEL, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    assertFalse(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#setFeatureValue(ApiFeature, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test setFeatureValue(ApiFeature, ApiUsageStateValue); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseApiUsageState.setFeatureValue(ApiFeature, ApiUsageStateValue)"})
  void testSetFeatureValue_thenReturnTrue() {
    // Arrange
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.WARNING);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());

    // Act
    boolean actualSetFeatureValueResult =
        baseApiUsageState.setFeatureValue(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED);

    // Assert
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    assertTrue(actualSetFeatureValueResult);
  }

  /**
   * Test {@link BaseApiUsageState#getTenantId()}.
   *
   * <p>Method under test: {@link BaseApiUsageState#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId BaseApiUsageState.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(apiUsageState.getTenantId()).thenReturn(tenantId);

    // Act
    TenantId actualTenantId = baseApiUsageState.getTenantId();

    // Assert
    verify(apiUsageState).getTenantId();
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link BaseApiUsageState#getEntityId()}.
   *
   * <p>Method under test: {@link BaseApiUsageState#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseApiUsageState.getEntityId()"})
  void testGetEntityId() {
    // Arrange
    when(apiUsageState.getEntityId()).thenReturn(null);

    // Act
    EntityId actualEntityId = baseApiUsageState.getEntityId();

    // Assert
    verify(apiUsageState).getEntityId();
    assertNull(actualEntityId);
  }

  /**
   * Test {@link BaseApiUsageState#getApiUsageState()}.
   *
   * <p>Method under test: {@link BaseApiUsageState#getApiUsageState()}
   */
  @Test
  @DisplayName("Test getApiUsageState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState BaseApiUsageState.getApiUsageState()"})
  void testGetApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act and Assert
    assertSame(apiUsageState, new CustomerApiUsageState(apiUsageState).getApiUsageState());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}, and {@link
   * StatsCalculationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#equals(Object)}
   *   <li>{@link StatsCalculationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatsCalculationResult buildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();
    StatsCalculationResult buildResult2 =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}, and {@link
   * StatsCalculationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#equals(Object)}
   *   <li>{@link StatsCalculationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatsCalculationResult buildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatsCalculationResultBuilder statsCalculationResultBuilder =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder.hourlyValueChanged(anyBoolean()))
        .thenReturn(StatsCalculationResult.builder());
    StatsCalculationResult buildResult =
        statsCalculationResultBuilder
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();
    StatsCalculationResult buildResult2 =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatsCalculationResultBuilder statsCalculationResultBuilder =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder.newHourlyValue(anyLong()))
        .thenReturn(StatsCalculationResult.builder());
    StatsCalculationResultBuilder statsCalculationResultBuilder2 =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder2.hourlyValueChanged(anyBoolean()))
        .thenReturn(statsCalculationResultBuilder);
    StatsCalculationResult buildResult =
        statsCalculationResultBuilder2
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();
    StatsCalculationResult buildResult2 =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatsCalculationResultBuilder statsCalculationResultBuilder =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder.newValue(anyLong()))
        .thenReturn(StatsCalculationResult.builder());
    StatsCalculationResultBuilder statsCalculationResultBuilder2 =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder2.newHourlyValue(anyLong()))
        .thenReturn(statsCalculationResultBuilder);
    StatsCalculationResultBuilder statsCalculationResultBuilder3 =
        mock(StatsCalculationResultBuilder.class);
    when(statsCalculationResultBuilder3.hourlyValueChanged(anyBoolean()))
        .thenReturn(statsCalculationResultBuilder2);
    StatsCalculationResult buildResult =
        statsCalculationResultBuilder3
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();
    StatsCalculationResult buildResult2 =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatsCalculationResult buildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatsCalculationResult buildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to StatsCalculationResult");
  }

  /**
   * Test StatsCalculationResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#toString()}
   *   <li>{@link StatsCalculationResult#getNewHourlyValue()}
   *   <li>{@link StatsCalculationResult#getNewValue()}
   *   <li>{@link StatsCalculationResult#isHourlyValueChanged()}
   *   <li>{@link StatsCalculationResult#isValueChanged()}
   * </ul>
   */
  @Test
  @DisplayName("Test StatsCalculationResult getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long StatsCalculationResult.getNewHourlyValue()",
    "long StatsCalculationResult.getNewValue()",
    "boolean StatsCalculationResult.isHourlyValueChanged()",
    "boolean StatsCalculationResult.isValueChanged()",
    "String StatsCalculationResult.toString()"
  })
  void testStatsCalculationResultGettersAndSetters() {
    // Arrange
    StatsCalculationResult buildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act
    String actualToStringResult = buildResult.toString();
    long actualNewHourlyValue = buildResult.getNewHourlyValue();
    long actualNewValue = buildResult.getNewValue();
    boolean actualIsHourlyValueChangedResult = buildResult.isHourlyValueChanged();

    // Assert
    assertEquals(
        "BaseApiUsageState.StatsCalculationResult(newValue=42, valueChanged=true, newHourlyValue=42,"
            + " hourlyValueChanged=true)",
        actualToStringResult);
    assertEquals(42L, actualNewHourlyValue);
    assertEquals(42L, actualNewValue);
    assertTrue(actualIsHourlyValueChangedResult);
    assertTrue(buildResult.isValueChanged());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#StatsCalculationResult(long, boolean,
   * long, boolean)}.
   *
   * <p>Method under test: {@link StatsCalculationResult#StatsCalculationResult(long, boolean, long,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult new StatsCalculationResult(long, boolean, long, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatsCalculationResult.<init>(long, boolean, long, boolean)"})
  void testStatsCalculationResultNewStatsCalculationResult() {
    // Arrange and Act
    StatsCalculationResult actualStatsCalculationResult =
        new StatsCalculationResult(42L, true, 42L, true);

    // Assert
    assertEquals(42L, actualStatsCalculationResult.getNewHourlyValue());
    assertEquals(42L, actualStatsCalculationResult.getNewValue());
    assertTrue(actualStatsCalculationResult.isHourlyValueChanged());
    assertTrue(actualStatsCalculationResult.isValueChanged());
  }

  /**
   * Test StatsCalculationResult_StatsCalculationResultBuilder {@link
   * StatsCalculationResult.StatsCalculationResultBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#build()}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#hourlyValueChanged(boolean)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#newHourlyValue(long)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#newValue(long)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#valueChanged(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test StatsCalculationResult_StatsCalculationResultBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void StatsCalculationResult.StatsCalculationResultBuilder.<init>()",
    "StatsCalculationResult StatsCalculationResult.StatsCalculationResultBuilder.build()",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.hourlyValueChanged(boolean)",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.newHourlyValue(long)",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.newValue(long)",
    "String StatsCalculationResult.StatsCalculationResultBuilder.toString()",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.valueChanged(boolean)"
  })
  void testStatsCalculationResult_StatsCalculationResultBuilderBuild() {
    // Arrange and Act
    StatsCalculationResult actualBuildResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Assert
    assertEquals(42L, actualBuildResult.getNewHourlyValue());
    assertEquals(42L, actualBuildResult.getNewValue());
    assertTrue(actualBuildResult.isHourlyValueChanged());
    assertTrue(actualBuildResult.isValueChanged());
  }
}
