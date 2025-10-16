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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventType;

class EntityIdFactoryDiffblueTest {
  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnApiUsageStateId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.API_USAGE_STATE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnAssetProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.ASSET_PROFILE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnDeviceProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.DEVICE_PROFILE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return NotificationId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnNotificationId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.NOTIFICATION, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return NotificationRequestId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnNotificationRequestId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.NOTIFICATION_REQUEST, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRequestId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnNotificationRuleId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.NOTIFICATION_RULE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRuleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnNotificationTargetId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.NOTIFICATION_TARGET, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTargetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnNotificationTemplateId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.NOTIFICATION_TEMPLATE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTemplateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnOAuth2ClientId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.OAUTH2_CLIENT, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OAuth2ClientId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnTenantProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.TENANT_PROFILE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_thenReturnWidgetsBundleId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.WIDGETS_BUNDLE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'ALARM'; then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenAlarm_thenReturnAlarmId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.ALARM, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'ASSET'; then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenAsset_thenReturnAssetId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.ASSET, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'CUSTOMER'; then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenCustomer_thenReturnCustomerId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.CUSTOMER, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'DASHBOARD'; then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenDashboard_thenReturnDashboardId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.DASHBOARD, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'DEVICE'; then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenDevice_thenReturnDeviceId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'DOMAIN'; then return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenDomain_thenReturnDomainId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.DOMAIN, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DomainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DOMAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'EDGE'; then return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenEdge_thenReturnEdgeId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.EDGE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EdgeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.EDGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'ENTITY_VIEW'; then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenEntityView_thenReturnEntityViewId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.ENTITY_VIEW, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code MOBILE_APP}.
   *   <li>Then return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'MOBILE_APP'; then return MobileAppId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenMobileApp_thenReturnMobileAppId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.MOBILE_APP, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof MobileAppId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'OTA_PACKAGE'; then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenOtaPackage_thenReturnOtaPackageId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.OTA_PACKAGE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code QUEUE_STATS}.
   *   <li>Then return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'QUEUE_STATS'; then return QueueStatsId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenQueueStats_thenReturnQueueStatsId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.QUEUE_STATS, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueStatsId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'QUEUE'; then return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenQueue_thenReturnQueueId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.QUEUE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code RPC}.
   *   <li>Then return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'RPC'; then return RpcId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenRpc_thenReturnRpcId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.RPC, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RpcId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RPC, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'RULE_CHAIN'; then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenRuleChain_thenReturnRuleChainId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.RULE_CHAIN, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code RULE_NODE}.
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'RULE_NODE'; then return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenRuleNode_thenReturnRuleNodeId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.RULE_NODE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'TB_RESOURCE'; then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenTbResource_thenReturnTbResourceId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.TB_RESOURCE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'TENANT'; then return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenTenant_thenReturnTenantId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.TENANT, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'USER'; then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenUser_thenReturnUserId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.USER, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)} with {@code EntityType},
   * {@code String}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, String) with 'EntityType', 'String'; when 'WIDGET_TYPE'; then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, String)"})
  void testGetByTypeAndUuidWithEntityTypeString_whenWidgetType_thenReturnWidgetTypeId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(
            EntityType.WIDGET_TYPE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnApiUsageStateId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.API_USAGE_STATE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnDeviceProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return NotificationRequestId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnNotificationRequestId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_REQUEST, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnNotificationRuleId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_RULE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnNotificationTargetId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TARGET, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnNotificationTemplateId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION_TEMPLATE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnTenantProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.TENANT_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_thenReturnWidgetsBundleId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(EntityType.WIDGETS_BUNDLE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'ALARM'; then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenAlarm_thenReturnAlarmId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ALARM, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'ASSET_PROFILE'; then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenAssetProfile_thenReturnAssetProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET_PROFILE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'ASSET'; then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenAsset_thenReturnAssetId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ASSET, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'CUSTOMER'; then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenCustomer_thenReturnCustomerId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.CUSTOMER, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'DASHBOARD'; then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenDashboard_thenReturnDashboardId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DASHBOARD, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'DEVICE'; then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenDevice_thenReturnDeviceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DEVICE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'DOMAIN'; then return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenDomain_thenReturnDomainId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.DOMAIN, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DomainId);
    assertEquals(EntityType.DOMAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'EDGE'; then return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenEdge_thenReturnEdgeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.EDGE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EdgeId);
    assertEquals(EntityType.EDGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'ENTITY_VIEW'; then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenEntityView_thenReturnEntityViewId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.ENTITY_VIEW, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code MOBILE_APP}.
   *   <li>Then return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'MOBILE_APP'; then return MobileAppId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenMobileApp_thenReturnMobileAppId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.MOBILE_APP, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION}.
   *   <li>Then return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'NOTIFICATION'; then return NotificationId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenNotification_thenReturnNotificationId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.NOTIFICATION, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.
   *   <li>Then return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'OAUTH2_CLIENT'; then return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenOauth2Client_thenReturnOAuth2ClientId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OAUTH2_CLIENT, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'OTA_PACKAGE'; then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenOtaPackage_thenReturnOtaPackageId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.OTA_PACKAGE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code QUEUE_STATS}.
   *   <li>Then return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'QUEUE_STATS'; then return QueueStatsId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenQueueStats_thenReturnQueueStatsId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE_STATS, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'QUEUE'; then return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenQueue_thenReturnQueueId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.QUEUE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof QueueId);
    assertEquals(EntityType.QUEUE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return not NullUid.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when randomUUID; then return not NullUid")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenRandomUUID_thenReturnNotNullUid() {
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
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code RPC}.
   *   <li>Then return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'RPC'; then return RpcId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenRpc_thenReturnRpcId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RPC, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RpcId);
    assertEquals(EntityType.RPC, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'RULE_CHAIN'; then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenRuleChain_thenReturnRuleChainId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_CHAIN, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code RULE_NODE}.
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'RULE_NODE'; then return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenRuleNode_thenReturnRuleNodeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.RULE_NODE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'TB_RESOURCE'; then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenTbResource_thenReturnTbResourceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TB_RESOURCE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then return SysTenantId.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'TENANT'; then return SysTenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenTenant_thenReturnSysTenantId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.TENANT, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'USER'; then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenUser_thenReturnUserId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.USER, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)} with {@code EntityType}, {@code
   * UUID}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(EntityType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(EntityType, UUID) with 'EntityType', 'UUID'; when 'WIDGET_TYPE'; then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(EntityType, UUID)"})
  void testGetByTypeAndUuidWithEntityTypeUuid_whenWidgetType_thenReturnWidgetTypeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(EntityType.WIDGET_TYPE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when eight; then return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenEight_thenReturnRuleNodeId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(8, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When eleven.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when eleven; then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenEleven_thenReturnWidgetTypeId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(11, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when fifteen; then return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenFifteen_thenReturnApiUsageStateId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(15, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when five; then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenFive_thenReturnDeviceId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(5, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when four; then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenFour_thenReturnAssetId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(4, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When fourteen.
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when fourteen; then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenFourteen_thenReturnAssetProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(14, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When nine.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when nine; then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenNine_thenReturnEntityViewId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(9, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when one; then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenOne_thenReturnCustomerId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(1, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when seven; then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenSeven_thenReturnRuleChainId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(7, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When seventeen.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when seventeen; then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenSeventeen_thenReturnOtaPackageId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(17, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when six; then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenSix_thenReturnAlarmId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(6, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when SIZE; then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenSize_thenReturnTbResourceId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(Short.SIZE, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when ten; then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenTen_thenReturnWidgetsBundleId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(10, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When thirteen.
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when thirteen; then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenThirteen_thenReturnDeviceProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(13, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when three; then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenThree_thenReturnDashboardId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(3, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When twelve.
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when twelve; then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenTwelve_thenReturnTenantProfileId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(12, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when two; then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenTwo_thenReturnUserId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(2, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, String)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, String) with 'int', 'String'; when zero; then return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, String)"})
  void testGetByTypeAndUuidWithIntString_whenZero_thenReturnTenantId() {
    // Arrange and Act
    EntityId actualByTypeAndUuid =
        EntityIdFactory.getByTypeAndUuid(0, "01234567-89AB-CDEF-FEDC-BA9876543210");

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals("01234567-89ab-cdef-fedc-ba9876543210", actualByTypeAndUuid.getId().toString());
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertFalse(actualByTypeAndUuid.isNullUid());
    assertFalse(((TenantId) actualByTypeAndUuid).isSysTenantId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when eight; then return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenEight_thenReturnRuleNodeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(8, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When eleven.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when eleven; then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenEleven_thenReturnWidgetTypeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(11, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when fifteen; then return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenFifteen_thenReturnApiUsageStateId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(15, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when five; then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenFive_thenReturnDeviceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(5, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceId);
    assertEquals(EntityType.DEVICE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when four; then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenFour_thenReturnAssetId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(4, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetId);
    assertEquals(EntityType.ASSET, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When fourteen.
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when fourteen; then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenFourteen_thenReturnAssetProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(14, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When nine.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when nine; then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenNine_thenReturnEntityViewId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(9, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when one; then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenOne_thenReturnCustomerId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(1, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return not NullUid.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when randomUUID; then return not NullUid")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenRandomUUID_thenReturnNotNullUid() {
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
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when seven; then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenSeven_thenReturnRuleChainId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(7, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When seventeen.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when seventeen; then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenSeventeen_thenReturnOtaPackageId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(17, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName("Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when six; then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenSix_thenReturnAlarmId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(6, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof AlarmId);
    assertEquals(EntityType.ALARM, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when SIZE; then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenSize_thenReturnTbResourceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(Short.SIZE, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when ten; then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenTen_thenReturnWidgetsBundleId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(10, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When thirteen.
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when thirteen; then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenThirteen_thenReturnDeviceProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(13, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when three; then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenThree_thenReturnDashboardId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(3, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When twelve.
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when twelve; then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenTwelve_thenReturnTenantProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(12, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName("Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when two; then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenTwo_thenReturnUserId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(2, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof UserId);
    assertEquals(EntityType.USER, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByTypeAndUuid(int, UUID)} with {@code int}, {@code UUID}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return SysTenantId.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByTypeAndUuid(int, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByTypeAndUuid(int, UUID) with 'int', 'UUID'; when zero; then return SysTenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByTypeAndUuid(int, UUID)"})
  void testGetByTypeAndUuidWithIntUuid_whenZero_thenReturnSysTenantId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByTypeAndUuid = EntityIdFactory.getByTypeAndUuid(0, uuid);

    // Assert
    assertTrue(actualByTypeAndUuid instanceof TenantId);
    assertEquals(EntityType.TENANT, actualByTypeAndUuid.getEntityType());
    assertTrue(actualByTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByTypeAndUuid).isSysTenantId());
    assertSame(uuid, actualByTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); then return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_thenReturnNotificationTargetId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_TARGET, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); then return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_thenReturnNotificationTemplateId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_TEMPLATE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code ALARM_COMMENT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'ALARM_COMMENT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenAlarmComment_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            EntityIdFactory.getByEdgeEventTypeAndUuid(
                EdgeEventType.ALARM_COMMENT, EntityId.NULL_UUID));
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'ALARM'; then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenAlarm_thenReturnAlarmId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ALARM, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AlarmId);
    assertEquals(EntityType.ALARM, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'ASSET_PROFILE'; then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenAssetProfile_thenReturnAssetProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ASSET_PROFILE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'ASSET'; then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenAsset_thenReturnAssetId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ASSET, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof AssetId);
    assertEquals(EntityType.ASSET, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'CUSTOMER'; then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenCustomer_thenReturnCustomerId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.CUSTOMER, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'DASHBOARD'; then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenDashboard_thenReturnDashboardId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DASHBOARD, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'DEVICE_PROFILE'; then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenDeviceProfile_thenReturnDeviceProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DEVICE_PROFILE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'DEVICE'; then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenDevice_thenReturnDeviceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DEVICE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DeviceId);
    assertEquals(EntityType.DEVICE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'DOMAIN'; then return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenDomain_thenReturnDomainId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.DOMAIN, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof DomainId);
    assertEquals(EntityType.DOMAIN, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'EDGE'; then return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenEdge_thenReturnEdgeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.EDGE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof EdgeId);
    assertEquals(EntityType.EDGE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'ENTITY_VIEW'; then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenEntityView_thenReturnEntityViewId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.ENTITY_VIEW, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.
   *   <li>Then return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'NOTIFICATION_RULE'; then return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenNotificationRule_thenReturnNotificationRuleId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.NOTIFICATION_RULE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.
   *   <li>Then return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'OAUTH2_CLIENT'; then return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenOauth2Client_thenReturnOAuth2ClientId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.OAUTH2_CLIENT, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'OTA_PACKAGE'; then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenOtaPackage_thenReturnOtaPackageId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.OTA_PACKAGE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'QUEUE'; then return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenQueue_thenReturnQueueId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.QUEUE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof QueueId);
    assertEquals(EntityType.QUEUE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'RULE_CHAIN'; then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenRuleChain_thenReturnRuleChainId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.RULE_CHAIN, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'TB_RESOURCE'; then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenTbResource_thenReturnTbResourceId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TB_RESOURCE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'TENANT_PROFILE'; then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenTenantProfile_thenReturnTenantProfileId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TENANT_PROFILE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'TENANT'; then return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenTenant_thenReturnTenantId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.TENANT, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof TenantId);
    assertEquals(EntityType.TENANT, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertTrue(((TenantId) actualByEdgeEventTypeAndUuid).isSysTenantId());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'USER'; then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenUser_thenReturnUserId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.USER, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof UserId);
    assertEquals(EntityType.USER, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'WIDGET_TYPE'; then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenWidgetType_thenReturnWidgetTypeId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.WIDGET_TYPE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }

  /**
   * Test {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}.
   *
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdFactory#getByEdgeEventTypeAndUuid(EdgeEventType, UUID)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeEventTypeAndUuid(EdgeEventType, UUID); when 'WIDGETS_BUNDLE'; then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType, UUID)"})
  void testGetByEdgeEventTypeAndUuid_whenWidgetsBundle_thenReturnWidgetsBundleId() {
    // Arrange
    UUID uuid = EntityId.NULL_UUID;

    // Act
    EntityId actualByEdgeEventTypeAndUuid =
        EntityIdFactory.getByEdgeEventTypeAndUuid(EdgeEventType.WIDGETS_BUNDLE, uuid);

    // Assert
    assertTrue(actualByEdgeEventTypeAndUuid instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, actualByEdgeEventTypeAndUuid.getEntityType());
    assertTrue(actualByEdgeEventTypeAndUuid.isNullUid());
    assertSame(uuid, actualByEdgeEventTypeAndUuid.getId());
  }
}
