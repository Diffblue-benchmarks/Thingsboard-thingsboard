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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventType;

class EntityIdFactoryDiffblueTest {
  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(1, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid2() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(2, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid3() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(3, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid4() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(4, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid5() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(5, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid6() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(0, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid7() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(6, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid8() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(7, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid9() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(8, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid10() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(9, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid11() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(10, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid12() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(11, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid13() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(12, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid14() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(13, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid15() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(14, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid16() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(15, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid17() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(Short.SIZE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  void testGetByTypeAndUuid18() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(17, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid19() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(1, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid20() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(2, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid21() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(3, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid22() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(4, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid23() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(5, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid24() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(0, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid25() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(6, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid26() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(7, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid27() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(8, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid28() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(9, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid29() {
    // Arrange
    UUID uuid = UUID.randomUUID();

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(0, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid30() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(10, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid31() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(11, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid32() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(12, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid33() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(13, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid34() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(14, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid35() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(15, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid36() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(Short.SIZE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  void testGetByTypeAndUuid37() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(17, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid38() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid39() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.CUSTOMER,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid40() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.USER,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid41() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DASHBOARD,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid42() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid43() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid44() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ALARM,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid45() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_CHAIN,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid46() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_NODE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid47() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ENTITY_VIEW,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid48() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.WIDGETS_BUNDLE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid49() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.WIDGET_TYPE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid50() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE_PROFILE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid51() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET_PROFILE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid52() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT_PROFILE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid53() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.API_USAGE_STATE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid54() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TB_RESOURCE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid55() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OTA_PACKAGE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid56() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.EDGE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EdgeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.EDGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid57() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RPC,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RpcId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RPC, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid58() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.QUEUE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid59() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TARGET,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTargetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid60() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_REQUEST,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRequestId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid61() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_RULE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRuleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid62() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TEMPLATE,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTemplateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid63() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid64() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE_STATS,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueStatsId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid65() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OAUTH2_CLIENT,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OAuth2ClientId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid66() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.MOBILE_APP,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof MobileAppId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  void testGetByTypeAndUuid67() {
    // Arrange and Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DOMAIN,
        "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DomainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DOMAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid68() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid69() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.CUSTOMER, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid70() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.USER, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid71() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DASHBOARD, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid72() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid73() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid74() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ALARM, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid75() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_CHAIN, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid76() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_NODE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid77() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ENTITY_VIEW, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid78() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.WIDGETS_BUNDLE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid79() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.WIDGET_TYPE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid80() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid81() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid82() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid83() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.API_USAGE_STATE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid84() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TB_RESOURCE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid85() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OTA_PACKAGE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid86() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.EDGE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EdgeId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.EDGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid87() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RPC, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RpcId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RPC, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid88() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.QUEUE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid89() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TARGET, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTargetId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid90() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_REQUEST, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRequestId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid91() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_RULE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRuleId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid92() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TEMPLATE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTemplateId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid93() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid94() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE_STATS, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueStatsId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.QUEUE_STATS, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid95() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OAUTH2_CLIENT, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OAuth2ClientId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid96() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.MOBILE_APP, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof MobileAppId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.MOBILE_APP, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid97() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DOMAIN, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DomainId);
    UUID id = actualByTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DOMAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  void testGetByTypeAndUuid98() {
    // Arrange
    UUID uuid = UUID.randomUUID();

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DASHBOARD, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DashboardId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DASHBOARD, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid2() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TENANT, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TenantId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByEdgeEventTypeAndUuid).isSysTenantId());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid3() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.CUSTOMER, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof CustomerId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid4() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.USER, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof UserId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.USER, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid5() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DEVICE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DeviceId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid6() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ASSET, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AssetId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid7() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ALARM, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AlarmId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ALARM, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid8() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.RULE_CHAIN, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof RuleChainId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_CHAIN, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid9() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ENTITY_VIEW, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof EntityViewId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid10() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.WIDGETS_BUNDLE,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof WidgetsBundleId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid11() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.WIDGET_TYPE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof WidgetTypeId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid12() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DEVICE_PROFILE,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DeviceProfileId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid13() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ASSET_PROFILE,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AssetProfileId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid14() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TENANT_PROFILE,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TenantProfileId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid15() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.OTA_PACKAGE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof OtaPackageId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid16() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.EDGE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof EdgeId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.EDGE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid17() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.QUEUE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof QueueId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.QUEUE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid18() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TB_RESOURCE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TbResourceId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.TB_RESOURCE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid19() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_RULE,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationRuleId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid20() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_TARGET,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationTargetId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid21() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory
        .getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_TEMPLATE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationTemplateId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid22() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.OAUTH2_CLIENT,
        uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof OAuth2ClientId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid23() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid = EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DOMAIN, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DomainId);
    UUID id = actualByEdgeEventTypeAndUuid.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.DOMAIN, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, id);
  }

  /**
   * Method under test:
   * {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  void testGetByEdgeEventTypeAndUuid24() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ALARM_COMMENT, EntityId.NULL_UUID));
  }
}
