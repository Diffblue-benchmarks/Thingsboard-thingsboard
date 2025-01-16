package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.profile.state.PersistedAlarmRuleState;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.device.profile.AlarmCondition;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionKeyType;
import org.thingsboard.server.common.data.device.profile.AlarmConditionSpec;
import org.thingsboard.server.common.data.device.profile.AlarmRule;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceServiceImpl;

class AlarmRuleStateDiffblueTest {
  /**
   * Test {@link AlarmRuleState#validateTsUpdate(Set)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateTsUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateTsUpdate(Set); then return 'false'")
  void testValidateTsUpdate_thenReturnFalse() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    HashSet<AlarmConditionFilterKey> changedKeys = new HashSet<>();
    changedKeys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    // Act
    boolean actualValidateTsUpdateResult = alarmRuleState.validateTsUpdate(changedKeys);

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateTsUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateTsUpdate(Set)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateTsUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateTsUpdate(Set); then return 'true'")
  void testValidateTsUpdate_thenReturnTrue() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    entityKeys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    HashSet<AlarmConditionFilterKey> changedKeys = new HashSet<>();
    changedKeys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    // Act
    boolean actualValidateTsUpdateResult = alarmRuleState.validateTsUpdate(changedKeys);

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertTrue(actualValidateTsUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateTsUpdate(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateTsUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateTsUpdate(Set); when HashSet(); then return 'false'")
  void testValidateTsUpdate_whenHashSet_thenReturnFalse() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    // Act
    boolean actualValidateTsUpdateResult = alarmRuleState.validateTsUpdate(new HashSet<>());

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateTsUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateAttrUpdate(Set)}.
   * <p>
   * Method under test: {@link AlarmRuleState#validateAttrUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateAttrUpdate(Set)")
  void testValidateAttrUpdate() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    entityKeys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    // Act
    boolean actualValidateAttrUpdateResult = alarmRuleState.validateAttrUpdate(new HashSet<>());

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateAttrUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateAttrUpdate(Set)}.
   * <ul>
   *   <li>Given
   * {@link AlarmConditionFilterKey#AlarmConditionFilterKey(AlarmConditionKeyType, String)}
   * with type is {@code ATTRIBUTE} and {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateAttrUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateAttrUpdate(Set); given AlarmConditionFilterKey(AlarmConditionKeyType, String) with type is 'ATTRIBUTE' and 'Key'")
  void testValidateAttrUpdate_givenAlarmConditionFilterKeyWithTypeIsAttributeAndKey() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    HashSet<AlarmConditionFilterKey> changedKeys = new HashSet<>();
    changedKeys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    // Act
    boolean actualValidateAttrUpdateResult = alarmRuleState.validateAttrUpdate(changedKeys);

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateAttrUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateAttrUpdate(Set)}.
   * <ul>
   *   <li>Then calls {@link AlarmConditionFilterKey#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateAttrUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateAttrUpdate(Set); then calls getType()")
  void testValidateAttrUpdate_thenCallsGetType() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);
    AlarmConditionFilterKey alarmConditionFilterKey = mock(AlarmConditionFilterKey.class);
    when(alarmConditionFilterKey.getType()).thenReturn(AlarmConditionKeyType.TIME_SERIES);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    entityKeys.add(alarmConditionFilterKey);
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    // Act
    boolean actualValidateAttrUpdateResult = alarmRuleState.validateAttrUpdate(new HashSet<>());

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmConditionFilterKey).getType();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateAttrUpdateResult);
  }

  /**
   * Test {@link AlarmRuleState#validateAttrUpdate(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmRuleState#validateAttrUpdate(Set)}
   */
  @Test
  @DisplayName("Test validateAttrUpdate(Set); when HashSet(); then return 'false'")
  void testValidateAttrUpdate_whenHashSet_thenReturnFalse() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));
    AlarmRule alarmRule = mock(AlarmRule.class);
    when(alarmRule.getCondition()).thenReturn(alarmCondition);
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    DynamicPredicateValueCtxImpl dynamicPredicateValueCtx = new DynamicPredicateValueCtxImpl(
        new TenantId(UUID.randomUUID()), mock(DeviceId.class), ctx);

    HashSet<AlarmConditionFilterKey> entityKeys = new HashSet<>();
    AlarmRuleState alarmRuleState = new AlarmRuleState(AlarmSeverity.CRITICAL, alarmRule, entityKeys,
        new PersistedAlarmRuleState(1L, 1L, 3L), dynamicPredicateValueCtx);

    // Act
    boolean actualValidateAttrUpdateResult = alarmRuleState.validateAttrUpdate(new HashSet<>());

    // Assert
    verify(ctx).getDeviceService();
    verify(alarmRule).getCondition();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertFalse(actualValidateAttrUpdateResult);
  }
}
