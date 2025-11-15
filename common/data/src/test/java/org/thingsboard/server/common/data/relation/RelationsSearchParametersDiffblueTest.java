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
package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;

class RelationsSearchParametersDiffblueTest {
  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId() {
    // Arrange and Act
    EntityId actualEntityId = (new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3,
        true)).getEntityId();

    // Assert
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId2() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.CUSTOMER);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId3() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.USER);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.USER, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId4() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DASHBOARD);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId5() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DEVICE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DEVICE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId6() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ASSET);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ASSET, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId7() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ALARM);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ALARM, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId8() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RULE_CHAIN);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId9() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RULE_NODE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId10() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ENTITY_VIEW);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId11() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.WIDGETS_BUNDLE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId12() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.WIDGET_TYPE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId13() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DEVICE_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId14() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ASSET_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AssetProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId15() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.TENANT_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId16() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.API_USAGE_STATE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof ApiUsageStateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId17() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.TB_RESOURCE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof TbResourceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId18() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.OTA_PACKAGE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof OtaPackageId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId19() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.EDGE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof EdgeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.EDGE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId20() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RPC);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RpcId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RPC, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId21() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.QUEUE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof QueueId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.QUEUE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId22() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_TARGET);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationTargetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId23() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_REQUEST);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationRequestId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId24() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_RULE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationRuleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId25() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_TEMPLATE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationTemplateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId26() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId27() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.QUEUE_STATS);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof QueueStatsId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId28() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.OAUTH2_CLIENT);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof OAuth2ClientId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId29() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.MOBILE_APP);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof MobileAppId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  void testGetEntityId30() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DOMAIN);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DomainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DOMAIN, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(entityId2,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters.hashCode());
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(new AlarmId(EntityId.NULL_UUID),
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(null);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId, null, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.TO, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 1, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, false);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true), null);
  }

  /**
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true),
        "Different type to RelationsSearchParameters");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationsSearchParameters#RelationsSearchParameters(UUID, EntityType, EntitySearchDirection, RelationTypeGroup, int, boolean)}
   *   <li>{@link RelationsSearchParameters#setDirection(EntitySearchDirection)}
   *   <li>{@link RelationsSearchParameters#setFetchLastLevelOnly(boolean)}
   *   <li>{@link RelationsSearchParameters#setMaxLevel(int)}
   *   <li>{@link RelationsSearchParameters#setRelationTypeGroup(RelationTypeGroup)}
   *   <li>{@link RelationsSearchParameters#setRootId(UUID)}
   *   <li>{@link RelationsSearchParameters#setRootType(EntityType)}
   *   <li>{@link RelationsSearchParameters#toString()}
   *   <li>{@link RelationsSearchParameters#getDirection()}
   *   <li>{@link RelationsSearchParameters#getMaxLevel()}
   *   <li>{@link RelationsSearchParameters#getRelationTypeGroup()}
   *   <li>{@link RelationsSearchParameters#getRootId()}
   *   <li>{@link RelationsSearchParameters#getRootType()}
   *   <li>{@link RelationsSearchParameters#isFetchLastLevelOnly()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(EntityId.NULL_UUID,
        EntityType.TENANT, EntitySearchDirection.FROM, RelationTypeGroup.COMMON, 3, true);
    actualRelationsSearchParameters.setDirection(EntitySearchDirection.FROM);
    actualRelationsSearchParameters.setFetchLastLevelOnly(true);
    actualRelationsSearchParameters.setMaxLevel(3);
    actualRelationsSearchParameters.setRelationTypeGroup(RelationTypeGroup.COMMON);
    UUID rootId = EntityId.NULL_UUID;
    actualRelationsSearchParameters.setRootId(rootId);
    actualRelationsSearchParameters.setRootType(EntityType.TENANT);
    String actualToStringResult = actualRelationsSearchParameters.toString();
    EntitySearchDirection actualDirection = actualRelationsSearchParameters.getDirection();
    int actualMaxLevel = actualRelationsSearchParameters.getMaxLevel();
    RelationTypeGroup actualRelationTypeGroup = actualRelationsSearchParameters.getRelationTypeGroup();
    UUID actualRootId = actualRelationsSearchParameters.getRootId();
    EntityType actualRootType = actualRelationsSearchParameters.getRootType();

    // Assert that nothing has changed
    assertEquals(
        "RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080, rootType=TENANT, direction=FROM,"
            + " relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true)",
        actualToStringResult);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntityType.TENANT, actualRootType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationTypeGroup);
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    assertSame(rootId, actualRootId);
  }

  /**
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)}
   */
  @Test
  void testNewRelationsSearchParameters() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, RelationTypeGroup.COMMON, true);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRelationsSearchParameters.getRootId().toString());
    assertEquals(3, actualRelationsSearchParameters.getMaxLevel());
    assertEquals(EntityType.TENANT, actualRelationsSearchParameters.getRootType());
    assertEquals(EntitySearchDirection.FROM, actualRelationsSearchParameters.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualRelationsSearchParameters.getRelationTypeGroup());
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualRelationsSearchParameters.getEntityId());
  }

  /**
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)}
   */
  @Test
  void testNewRelationsSearchParameters2() {
    // Arrange
    AlarmId entityId = new AlarmId(EntityId.NULL_UUID);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, RelationTypeGroup.COMMON, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRelationsSearchParameters.getRootId().toString());
    assertEquals(3, actualRelationsSearchParameters.getMaxLevel());
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(EntitySearchDirection.FROM, actualRelationsSearchParameters.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualRelationsSearchParameters.getRelationTypeGroup());
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    assertEquals(entityId, entityId2);
  }

  /**
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean)}
   */
  @Test
  void testNewRelationsSearchParameters3() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRelationsSearchParameters.getRootId().toString());
    assertEquals(3, actualRelationsSearchParameters.getMaxLevel());
    assertEquals(EntityType.TENANT, actualRelationsSearchParameters.getRootType());
    assertEquals(EntitySearchDirection.FROM, actualRelationsSearchParameters.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualRelationsSearchParameters.getRelationTypeGroup());
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualRelationsSearchParameters.getEntityId());
  }

  /**
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean)}
   */
  @Test
  void testNewRelationsSearchParameters4() {
    // Arrange
    AlarmId entityId = new AlarmId(EntityId.NULL_UUID);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRelationsSearchParameters.getRootId().toString());
    assertEquals(3, actualRelationsSearchParameters.getMaxLevel());
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(EntitySearchDirection.FROM, actualRelationsSearchParameters.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualRelationsSearchParameters.getRelationTypeGroup());
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    assertEquals(entityId, entityId2);
  }
}
