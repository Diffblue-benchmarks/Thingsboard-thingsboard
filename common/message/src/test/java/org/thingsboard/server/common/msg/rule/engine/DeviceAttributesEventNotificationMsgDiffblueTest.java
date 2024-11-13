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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.msg.MsgType;

class DeviceAttributesEventNotificationMsgDiffblueTest {
  /**
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry}.</li>
   *   <li>Then return Values is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onUpdate(TenantId, DeviceId, String, List); given AttributeKvEntry; then return Values is ArrayList()")
  void testOnUpdate_givenAttributeKvEntry_thenReturnValuesIsArrayList() {
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
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertSame(values, actualOnUpdateResult.getValues());
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onUpdate(TenantId, DeviceId, String, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Values size is one")
  void testOnUpdate_givenJsonDataEntryWithKeyAndValueIs42_thenReturnValuesSizeIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    values.add(baseAttributeKvEntry);

    // Act and Assert
    List<AttributeKvEntry> values2 = DeviceAttributesEventNotificationMsg.onUpdate(tenantId, null, "Scope", values)
        .getValues();
    assertEquals(1, values2.size());
    assertSame(baseAttributeKvEntry, values2.get(0));
  }

  /**
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onUpdate(TenantId, DeviceId, String, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Values size is two")
  void testOnUpdate_givenJsonDataEntryWithKeyAndValueIs42_thenReturnValuesSizeIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    values.add(baseAttributeKvEntry);

    // Act and Assert
    List<AttributeKvEntry> values2 = DeviceAttributesEventNotificationMsg.onUpdate(tenantId, null, "Scope", values)
        .getValues();
    assertEquals(2, values2.size());
    assertSame(baseAttributeKvEntry, values2.get(1));
  }

  /**
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Values Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onUpdate(TenantId, DeviceId, String, List); when ArrayList(); then return Values Empty")
  void testOnUpdate_whenArrayList_thenReturnValuesEmpty() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult = DeviceAttributesEventNotificationMsg.onUpdate(tenantId,
        null, "Scope", new ArrayList<>());

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    assertEquals(MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertTrue(actualOnUpdateResult.getValues().isEmpty());
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return DeletedKeys size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onDelete(TenantId, DeviceId, String, List); given '42'; when ArrayList() add '42'; then return DeletedKeys size is two")
  void testOnDelete_given42_whenArrayListAdd42_thenReturnDeletedKeysSizeIsTwo() {
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
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return DeletedKeys size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onDelete(TenantId, DeviceId, String, List); given 'foo'; when ArrayList() add 'foo'; then return DeletedKeys size is one")
  void testOnDelete_givenFoo_whenArrayListAddFoo_thenReturnDeletedKeysSizeIsOne() {
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
   * Test
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DeletedKeys Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}
   */
  @Test
  @DisplayName("Test onDelete(TenantId, DeviceId, String, List); when ArrayList(); then return DeletedKeys Empty")
  void testOnDelete_whenArrayList_thenReturnDeletedKeysEmpty() {
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
   * Test {@link DeviceAttributesEventNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link DeviceAttributesEventNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(DeviceAttributesEventNotificationMsg.onDelete(tenantId, deviceId, "Scope", new ArrayList<>()),
        "42");
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributesEventNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
