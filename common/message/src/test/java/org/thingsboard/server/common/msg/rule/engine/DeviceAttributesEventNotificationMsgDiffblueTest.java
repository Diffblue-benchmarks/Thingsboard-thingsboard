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
package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.msg.MsgType;

class DeviceAttributesEventNotificationMsgDiffblueTest {
  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnUpdate() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ArrayList<AttributeKvEntry> values = new ArrayList<>();

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult = DeviceAttributesEventNotificationMsg.onUpdate(tenantId,
        null, "Scope", values);

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    List<AttributeKvEntry> values2 = actualOnUpdateResult.getValues();
    assertTrue(values2.isEmpty());
    assertSame(values, values2);
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnUpdate2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult = DeviceAttributesEventNotificationMsg.onUpdate(tenantId,
        null, "Scope", values);

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertSame(values, actualOnUpdateResult.getValues());
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnUpdate3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult = DeviceAttributesEventNotificationMsg.onUpdate(tenantId,
        null, "Scope", values);

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertSame(values, actualOnUpdateResult.getValues());
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnUpdate4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(mock(AttributeKvEntry.class));

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult = DeviceAttributesEventNotificationMsg.onUpdate(tenantId,
        null, "Scope", values);

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    List<AttributeKvEntry> values2 = actualOnUpdateResult.getValues();
    assertEquals(1, values2.size());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertSame(values, values2);
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    DeviceAttributesEventNotificationMsg onDeleteResult = DeviceAttributesEventNotificationMsg.onDelete(tenantId,
        deviceId, "Scope", new ArrayList<>());
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(onDeleteResult,
        DeviceAttributesEventNotificationMsg.onDelete(tenantId2, null, "Scope", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnDelete() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult = DeviceAttributesEventNotificationMsg.onDelete(tenantId,
        null, "Scope", new ArrayList<>());

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.getDeletedKeys().isEmpty());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnDelete2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult = DeviceAttributesEventNotificationMsg.onDelete(tenantId,
        null, "Scope", keys);

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(1, actualOnDeleteResult.getDeletedKeys().size());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  void testOnDelete3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult = DeviceAttributesEventNotificationMsg.onDelete(tenantId,
        null, "Scope", keys);

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(2, actualOnDeleteResult.getDeletedKeys().size());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(DeviceAttributesEventNotificationMsg.onDelete(tenantId, deviceId, "Scope", new ArrayList<>()),
        "42");
  }

  /**
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    DeviceAttributesEventNotificationMsg onDeleteResult = DeviceAttributesEventNotificationMsg.onDelete(null, deviceId,
        "Scope", new ArrayList<>());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(onDeleteResult,
        DeviceAttributesEventNotificationMsg.onDelete(tenantId, null, "Scope", new ArrayList<>()));
  }
}
