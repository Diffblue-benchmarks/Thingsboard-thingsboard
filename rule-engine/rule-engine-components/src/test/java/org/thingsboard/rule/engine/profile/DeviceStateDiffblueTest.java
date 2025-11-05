package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.exception.ApiUsageLimitsExceededException;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.device.DeviceService;

class DeviceStateDiffblueTest {
  /**
   * Test {@link DeviceState#DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId,
   * ProfileState, RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link DeviceService} {@link DeviceService#findDeviceById(TenantId, DeviceId)}
   *       return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#DeviceState(TbContext,
   * TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)}
   */
  @Test
  @DisplayName(
      "Test new DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState); given DeviceService findDeviceById(TenantId, DeviceId) return Device()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceState.<init>(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)"
  })
  void testNewDeviceState_givenDeviceServiceFindDeviceByIdReturnDevice() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getDeviceService()).thenReturn(deviceService);
    TbDeviceProfileNodeConfiguration config = new TbDeviceProfileNodeConfiguration();

    // Act
    new DeviceState(ctx, config, null, null, new RuleNodeState());

    // Assert
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceState#DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId,
   * ProfileState, RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link DeviceService} {@link DeviceService#findDeviceById(TenantId, DeviceId)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#DeviceState(TbContext,
   * TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)}
   */
  @Test
  @DisplayName(
      "Test new DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState); given DeviceService findDeviceById(TenantId, DeviceId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceState.<init>(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)"
  })
  void testNewDeviceState_givenDeviceServiceFindDeviceByIdReturnNull() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getDeviceService()).thenReturn(deviceService);
    TbDeviceProfileNodeConfiguration config = new TbDeviceProfileNodeConfiguration();

    // Act
    new DeviceState(ctx, config, null, null, new RuleNodeState());

    // Assert
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceState#DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId,
   * ProfileState, RuleNodeState)}.
   *
   * <ul>
   *   <li>Then throw {@link ApiUsageLimitsExceededException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#DeviceState(TbContext,
   * TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)}
   */
  @Test
  @DisplayName(
      "Test new DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState); then throw ApiUsageLimitsExceededException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceState.<init>(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)"
  })
  void testNewDeviceState_thenThrowApiUsageLimitsExceededException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getCustomerId()).thenThrow(new ApiUsageLimitsExceededException());

    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(device);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getDeviceService()).thenReturn(deviceService);
    TbDeviceProfileNodeConfiguration config = new TbDeviceProfileNodeConfiguration();

    // Act and Assert
    assertThrows(
        ApiUsageLimitsExceededException.class,
        () -> new DeviceState(ctx, config, null, null, new RuleNodeState()));
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
    verify(device).getCustomerId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   *
   * <ul>
   *   <li>Then return DataType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return DataType is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DeviceState.toEntityValue(KvEntry)"})
  void testToEntityValue_thenReturnDataTypeIsBoolean() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult =
        DeviceState.toEntityValue(new BooleanDataEntry("Key", true));

    // Assert
    assertNull(actualToEntityValueResult.getDblValue());
    assertNull(actualToEntityValueResult.getLngValue());
    assertNull(actualToEntityValueResult.getJsonValue());
    assertNull(actualToEntityValueResult.getStrValue());
    assertEquals(DataType.BOOLEAN, actualToEntityValueResult.getDataType());
    assertTrue(actualToEntityValueResult.getBoolValue());
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   *
   * <ul>
   *   <li>Then return DblValue doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return DblValue doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DeviceState.toEntityValue(KvEntry)"})
  void testToEntityValue_thenReturnDblValueDoubleValueIsTen() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult =
        DeviceState.toEntityValue(new DoubleDataEntry("Key", 10.0d));

    // Assert
    assertNull(actualToEntityValueResult.getBoolValue());
    assertNull(actualToEntityValueResult.getLngValue());
    assertNull(actualToEntityValueResult.getJsonValue());
    assertNull(actualToEntityValueResult.getStrValue());
    assertEquals(10.0d, actualToEntityValueResult.getDblValue().doubleValue());
    assertEquals(DataType.DOUBLE, actualToEntityValueResult.getDataType());
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   *
   * <ul>
   *   <li>Then return LngValue longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return LngValue longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DeviceState.toEntityValue(KvEntry)"})
  void testToEntityValue_thenReturnLngValueLongValueIsFortyTwo() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult =
        DeviceState.toEntityValue(new LongDataEntry("Key", 42L));

    // Assert
    assertNull(actualToEntityValueResult.getBoolValue());
    assertNull(actualToEntityValueResult.getDblValue());
    assertNull(actualToEntityValueResult.getJsonValue());
    assertNull(actualToEntityValueResult.getStrValue());
    assertEquals(42L, actualToEntityValueResult.getLngValue().longValue());
    assertEquals(DataType.LONG, actualToEntityValueResult.getDataType());
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return JsonValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toEntityValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'; then return JsonValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DeviceState.toEntityValue(KvEntry)"})
  void testToEntityValue_whenJsonDataEntryWithKeyAndValueIs42_thenReturnJsonValueIs42() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult =
        DeviceState.toEntityValue(new JsonDataEntry("Key", "42"));

    // Assert
    assertEquals("42", actualToEntityValueResult.getJsonValue());
    assertNull(actualToEntityValueResult.getBoolValue());
    assertNull(actualToEntityValueResult.getDblValue());
    assertNull(actualToEntityValueResult.getLngValue());
    assertNull(actualToEntityValueResult.getStrValue());
    assertEquals(DataType.JSON, actualToEntityValueResult.getDataType());
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   *   <li>Then return StrValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toEntityValue(KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'; then return StrValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DeviceState.toEntityValue(KvEntry)"})
  void testToEntityValue_whenStringDataEntryWithKeyAndValueIs42_thenReturnStrValueIs42() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult =
        DeviceState.toEntityValue(new StringDataEntry("Key", "42"));

    // Assert
    assertEquals("42", actualToEntityValueResult.getStrValue());
    assertNull(actualToEntityValueResult.getBoolValue());
    assertNull(actualToEntityValueResult.getDblValue());
    assertNull(actualToEntityValueResult.getLngValue());
    assertNull(actualToEntityValueResult.getJsonValue());
    assertEquals(DataType.STRING, actualToEntityValueResult.getDataType());
  }
}
