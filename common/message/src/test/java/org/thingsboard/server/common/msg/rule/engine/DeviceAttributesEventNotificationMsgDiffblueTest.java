package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.msg.MsgType;

class DeviceAttributesEventNotificationMsgDiffblueTest {
  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return Values is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onUpdate(TenantId, DeviceId, String, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Values is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onUpdate(TenantId, DeviceId, String, List)"
  })
  void testOnUpdate_givenJsonDataEntryWithKeyAndValueIs42_thenReturnValuesIsArrayList() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    values.add(baseAttributeKvEntry);

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult =
        DeviceAttributesEventNotificationMsg.onUpdate(tenantId, null, "Scope", values);

    // Assert
    assertSame(values, actualOnUpdateResult.getValues());
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onUpdate(TenantId, DeviceId, String, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onUpdate(TenantId, DeviceId, String, List)"
  })
  void testOnUpdate_givenJsonDataEntryWithKeyAndValueIs42_thenReturnValuesSizeIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    values.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    values.add(baseAttributeKvEntry2);

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult =
        DeviceAttributesEventNotificationMsg.onUpdate(tenantId, null, "Scope", values);

    // Assert
    List<AttributeKvEntry> values2 = actualOnUpdateResult.getValues();
    assertEquals(2, values2.size());
    assertSame(baseAttributeKvEntry2, values2.get(1));
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Scope}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onUpdate(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onUpdate(TenantId, DeviceId, String, List); when ArrayList(); then return 'Scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onUpdate(TenantId, DeviceId, String, List)"
  })
  void testOnUpdate_whenArrayList_thenReturnScope() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceAttributesEventNotificationMsg actualOnUpdateResult =
        DeviceAttributesEventNotificationMsg.onUpdate(tenantId, null, "Scope", new ArrayList<>());

    // Assert
    assertEquals("Scope", actualOnUpdateResult.getScope());
    assertNull(actualOnUpdateResult.getDeletedKeys());
    assertNull(actualOnUpdateResult.getDeviceId());
    assertEquals(
        MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnUpdateResult.getMsgType());
    assertFalse(actualOnUpdateResult.isDeleted());
    assertTrue(actualOnUpdateResult.getValues().isEmpty());
    assertSame(tenantId, actualOnUpdateResult.getTenantId());
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return DeletedKeys size is two.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onDelete(TenantId, DeviceId, String, List); given '42'; when ArrayList() add '42'; then return DeletedKeys size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onDelete(TenantId, DeviceId, String, List)"
  })
  void testOnDelete_given42_whenArrayListAdd42_thenReturnDeletedKeysSizeIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult =
        DeviceAttributesEventNotificationMsg.onDelete(tenantId, null, "Scope", keys);

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(2, actualOnDeleteResult.getDeletedKeys().size());
    assertEquals(
        MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return DeletedKeys size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onDelete(TenantId, DeviceId, String, List); given 'foo'; when ArrayList() add 'foo'; then return DeletedKeys size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onDelete(TenantId, DeviceId, String, List)"
  })
  void testOnDelete_givenFoo_whenArrayListAddFoo_thenReturnDeletedKeysSizeIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult =
        DeviceAttributesEventNotificationMsg.onDelete(tenantId, null, "Scope", keys);

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(1, actualOnDeleteResult.getDeletedKeys().size());
    assertEquals(
        MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }

  /**
   * Test {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId, String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return DeletedKeys Empty.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributesEventNotificationMsg#onDelete(TenantId, DeviceId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test onDelete(TenantId, DeviceId, String, List); when ArrayList(); then return DeletedKeys Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceAttributesEventNotificationMsg DeviceAttributesEventNotificationMsg.onDelete(TenantId, DeviceId, String, List)"
  })
  void testOnDelete_whenArrayList_thenReturnDeletedKeysEmpty() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceAttributesEventNotificationMsg actualOnDeleteResult =
        DeviceAttributesEventNotificationMsg.onDelete(tenantId, null, "Scope", new ArrayList<>());

    // Assert
    assertNull(actualOnDeleteResult.getScope());
    assertNull(actualOnDeleteResult.getValues());
    assertNull(actualOnDeleteResult.getDeviceId());
    assertEquals(
        MsgType.DEVICE_ATTRIBUTES_UPDATE_TO_DEVICE_ACTOR_MSG, actualOnDeleteResult.getMsgType());
    assertTrue(actualOnDeleteResult.getDeletedKeys().isEmpty());
    assertTrue(actualOnDeleteResult.isDeleted());
    assertSame(tenantId, actualOnDeleteResult.getTenantId());
  }
}
