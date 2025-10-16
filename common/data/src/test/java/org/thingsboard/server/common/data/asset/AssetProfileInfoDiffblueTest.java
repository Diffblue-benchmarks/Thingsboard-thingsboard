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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetProfileInfoDiffblueTest {
  /**
   * Test {@link AssetProfileInfo#AssetProfileInfo(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileInfo#AssetProfileInfo(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileInfo(AssetProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileInfo.<init>(AssetProfile)"})
  void testNewAssetProfileInfo() {
    // Arrange and Act
    AssetProfileInfo actualAssetProfileInfo = new AssetProfileInfo(new AssetProfile());

    // Assert
    assertNull(actualAssetProfileInfo.getName());
    assertNull(actualAssetProfileInfo.getImage());
    assertNull(actualAssetProfileInfo.getDefaultDashboardId());
    assertNull(actualAssetProfileInfo.getId());
    assertNull(actualAssetProfileInfo.getTenantId());
  }

  /**
   * Test {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String, UUID)}.
   *
   * <ul>
   *   <li>Then return DefaultDashboardId EntityType is {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String,
   * UUID)}
   */
  @Test
  @DisplayName(
      "Test new AssetProfileInfo(UUID, UUID, String, String, UUID); then return DefaultDashboardId EntityType is 'DASHBOARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileInfo.<init>(UUID, UUID, String, String, UUID)"})
  void testNewAssetProfileInfo_thenReturnDefaultDashboardIdEntityTypeIsDashboard() {
    // Arrange
    UUID defaultDashboardId = EntityId.NULL_UUID;

    // Act
    AssetProfileInfo actualAssetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", defaultDashboardId);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    DashboardId defaultDashboardId2 = actualAssetProfileInfo.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    assertTrue(defaultDashboardId2.isNullUid());
    UUID id2 = defaultDashboardId2.getId();
    assertSame(id2, id.getId());
    assertSame(id2, actualAssetProfileInfo.getTenantId().getId());
    assertSame(defaultDashboardId, id2);
  }

  /**
   * Test {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String, UUID)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String,
   * UUID)}
   */
  @Test
  @DisplayName(
      "Test new AssetProfileInfo(UUID, UUID, String, String, UUID); when 'null'; then return 'Image'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileInfo.<init>(UUID, UUID, String, String, UUID)"})
  void testNewAssetProfileInfo_whenNull_thenReturnImage() {
    // Arrange
    UUID tenantId = EntityId.NULL_UUID;

    // Act
    AssetProfileInfo actualAssetProfileInfo =
        new AssetProfileInfo(EntityId.NULL_UUID, tenantId, "Name", "Image", null);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    assertEquals("Image", actualAssetProfileInfo.getImage());
    assertEquals("Name", actualAssetProfileInfo.getName());
    assertNull(actualAssetProfileInfo.getDefaultDashboardId());
    assertEquals(EntityType.ASSET_PROFILE, id.getEntityType());
    TenantId tenantId2 = actualAssetProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}, and {@link AssetProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileInfo#equals(Object)}
   *   <li>{@link AssetProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    AssetProfileInfo assetProfileInfo2 = new AssetProfileInfo(new AssetProfile());

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo2);
    assertEquals(assetProfileInfo.hashCode(), assetProfileInfo2.hashCode());
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}, and {@link AssetProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileInfo#equals(Object)}
   *   <li>{@link AssetProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID);
    AssetProfileInfo assetProfileInfo2 =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo2);
    assertEquals(assetProfileInfo.hashCode(), assetProfileInfo2.hashCode());
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}, and {@link AssetProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileInfo#equals(Object)}
   *   <li>{@link AssetProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo);
    int expectedHashCodeResult = assetProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileInfo.hashCode());
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetProfileInfo, new AssetProfileInfo(new AssetProfile()));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Name", EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", null, EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, UUID.randomUUID(), "Name", "Image", EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", UUID.randomUUID());

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", null);

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image", EntityId.NULL_UUID));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());

    AssetProfile profile = new AssetProfile();
    profile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetProfileInfo, new AssetProfileInfo(profile));
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileInfo(new AssetProfile()), null);
  }

  /**
   * Test {@link AssetProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileInfo(new AssetProfile()), "Different type to AssetProfileInfo");
  }
}
