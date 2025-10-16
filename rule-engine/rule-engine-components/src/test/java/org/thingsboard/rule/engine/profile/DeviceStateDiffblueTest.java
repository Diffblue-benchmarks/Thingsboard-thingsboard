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
package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.exception.ApiUsageLimitsExceededException;
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
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new ApiUsageLimitsExceededException("An error occurred"));
    TbDeviceProfileNodeConfiguration config = new TbDeviceProfileNodeConfiguration();

    // Act and Assert
    assertThrows(
        ApiUsageLimitsExceededException.class,
        () -> new DeviceState(ctx, config, null, null, new RuleNodeState()));
    verify(ctx).getTenantId();
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
