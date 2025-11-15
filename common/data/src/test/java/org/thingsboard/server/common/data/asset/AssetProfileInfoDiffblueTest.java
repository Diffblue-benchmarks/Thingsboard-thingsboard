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
package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetProfileInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileInfo#equals(Object)}
   *   <li>{@link AssetProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    AssetProfileInfo assetProfileInfo2 = new AssetProfileInfo(new AssetProfile());

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo2);
    int expectedHashCodeResult = assetProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileInfo#equals(Object)}
   *   <li>{@link AssetProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo);
    int expectedHashCodeResult = assetProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileInfo.hashCode());
  }

  /**
   * Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image",
        EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetProfileInfo, new AssetProfileInfo(new AssetProfile()));
  }

  /**
   * Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileInfo(new AssetProfile()), null);
  }

  /**
   * Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileInfo(new AssetProfile()), "Different type to AssetProfileInfo");
  }

  /**
   * Method under test:
   * {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String, UUID)}
   */
  @Test
  void testNewAssetProfileInfo() {
    // Arrange
    UUID defaultDashboardId = EntityId.NULL_UUID;

    // Act
    AssetProfileInfo actualAssetProfileInfo = new AssetProfileInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, "Name",
        "Image", defaultDashboardId);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    DashboardId defaultDashboardId2 = actualAssetProfileInfo.getDefaultDashboardId();
    UUID id2 = defaultDashboardId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals("Image", actualAssetProfileInfo.getImage());
    assertEquals("Name", actualAssetProfileInfo.getName());
    assertEquals(EntityType.ASSET_PROFILE, id.getEntityType());
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    TenantId tenantId = actualAssetProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(defaultDashboardId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(defaultDashboardId, id.getId());
    assertSame(defaultDashboardId, id2);
    assertSame(defaultDashboardId, tenantId.getId());
  }

  /**
   * Method under test:
   * {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String, UUID)}
   */
  @Test
  void testNewAssetProfileInfo2() {
    // Arrange
    UUID tenantId = EntityId.NULL_UUID;

    // Act
    AssetProfileInfo actualAssetProfileInfo = new AssetProfileInfo(EntityId.NULL_UUID, tenantId, "Name", "Image", null);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    TenantId tenantId2 = actualAssetProfileInfo.getTenantId();
    UUID id2 = tenantId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals("Image", actualAssetProfileInfo.getImage());
    assertEquals("Name", actualAssetProfileInfo.getName());
    assertNull(actualAssetProfileInfo.getDefaultDashboardId());
    assertEquals(EntityType.ASSET_PROFILE, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, id2);
  }

  /**
   * Method under test: {@link AssetProfileInfo#AssetProfileInfo(AssetProfile)}
   */
  @Test
  void testNewAssetProfileInfo3() {
    // Arrange and Act
    AssetProfileInfo actualAssetProfileInfo = new AssetProfileInfo(new AssetProfile());

    // Assert
    assertNull(actualAssetProfileInfo.getName());
    assertNull(actualAssetProfileInfo.getImage());
    assertNull(actualAssetProfileInfo.getDefaultDashboardId());
    assertNull(actualAssetProfileInfo.getId());
    assertNull(actualAssetProfileInfo.getTenantId());
  }
}
