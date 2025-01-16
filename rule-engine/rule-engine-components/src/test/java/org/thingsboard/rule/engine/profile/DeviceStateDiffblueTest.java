package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.rule.RuleNodeState;

class DeviceStateDiffblueTest {
  /**
   * Test
   * {@link DeviceState#DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceState#DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState)}
   */
  @Test
  @DisplayName("Test new DeviceState(TbContext, TbDeviceProfileNodeConfiguration, DeviceId, ProfileState, RuleNodeState); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testNewDeviceState_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));
    TbDeviceProfileNodeConfiguration config = new TbDeviceProfileNodeConfiguration();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new DeviceState(ctx, config, null, null, new RuleNodeState()));

    verify(ctx).getTenantId();
  }

  /**
   * Test {@link DeviceState#toEntityValue(KvEntry)}.
   * <ul>
   *   <li>Then return DataType is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return DataType is 'BOOLEAN'")
  void testToEntityValue_thenReturnDataTypeIsBoolean() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult = DeviceState.toEntityValue(new BooleanDataEntry("Key", true));

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
   * <ul>
   *   <li>Then return DblValue doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return DblValue doubleValue is ten")
  void testToEntityValue_thenReturnDblValueDoubleValueIsTen() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult = DeviceState.toEntityValue(new DoubleDataEntry("Key", 10.0d));

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
   * <ul>
   *   <li>Then return LngValue longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); then return LngValue longValue is forty-two")
  void testToEntityValue_thenReturnLngValueLongValueIsFortyTwo() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult = DeviceState.toEntityValue(new LongDataEntry("Key", 42L));

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
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key}
   * and value is {@code 42}.</li>
   *   <li>Then return JsonValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'; then return JsonValue is '42'")
  void testToEntityValue_whenJsonDataEntryWithKeyAndValueIs42_thenReturnJsonValueIs42() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult = DeviceState.toEntityValue(new JsonDataEntry("Key", "42"));

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
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return StrValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#toEntityValue(KvEntry)}
   */
  @Test
  @DisplayName("Test toEntityValue(KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'; then return StrValue is '42'")
  void testToEntityValue_whenStringDataEntryWithKeyAndValueIs42_thenReturnStrValueIs42() {
    // Arrange and Act
    EntityKeyValue actualToEntityValueResult = DeviceState.toEntityValue(new StringDataEntry("Key", "42"));

    // Assert
    assertEquals("42", actualToEntityValueResult.getStrValue());
    assertNull(actualToEntityValueResult.getBoolValue());
    assertNull(actualToEntityValueResult.getDblValue());
    assertNull(actualToEntityValueResult.getLngValue());
    assertNull(actualToEntityValueResult.getJsonValue());
    assertEquals(DataType.STRING, actualToEntityValueResult.getDataType());
  }
}
