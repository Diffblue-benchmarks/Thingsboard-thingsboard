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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetDiffblueTest {
  /**
   * Test {@link Asset#getExternalId()}.
   *
   * <p>Method under test: {@link Asset#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetId Asset.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new Asset().getExternalId());
  }

  /**
   * Test {@link Asset#Asset(Asset)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Asset.<init>(Asset)"})
  void testNewAsset_whenAsset() {
    // Arrange and Act
    Asset actualAsset = new Asset(new Asset());

    // Assert
    assertTrue(actualAsset.getAdditionalInfo() instanceof NullNode);
    assertNull(actualAsset.getVersion());
    assertNull(actualAsset.getLabel());
    assertNull(actualAsset.getName());
    assertNull(actualAsset.getType());
    assertNull(actualAsset.getUuidId());
    assertNull(actualAsset.getExternalId());
    assertNull(actualAsset.getId());
    assertNull(actualAsset.getAssetProfileId());
    assertNull(actualAsset.getCustomerId());
    assertNull(actualAsset.getTenantId());
    assertEquals(0L, actualAsset.getCreatedTime());
  }

  /**
   * Test {@link Asset#Asset(Asset)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset(Asset) with asset is Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Asset.<init>(Asset)"})
  void testNewAsset_whenAssetWithAssetIsAsset() {
    // Arrange and Act
    Asset actualAsset = new Asset(new Asset(new Asset()));

    // Assert
    assertTrue(actualAsset.getAdditionalInfo() instanceof NullNode);
    assertNull(actualAsset.getVersion());
    assertNull(actualAsset.getLabel());
    assertNull(actualAsset.getName());
    assertNull(actualAsset.getType());
    assertNull(actualAsset.getUuidId());
    assertNull(actualAsset.getExternalId());
    assertNull(actualAsset.getId());
    assertNull(actualAsset.getAssetProfileId());
    assertNull(actualAsset.getCustomerId());
    assertNull(actualAsset.getTenantId());
    assertEquals(0L, actualAsset.getCreatedTime());
  }

  /**
   * Test {@link Asset#Asset(Asset)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset(Asset)}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset(Asset) with asset is Asset(Asset)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Asset.<init>(Asset)"})
  void testNewAsset_whenAssetWithAssetIsAsset2() {
    // Arrange
    Asset asset = new Asset(new Asset(new Asset()));

    // Act
    Asset actualAsset = new Asset(asset);

    // Assert
    assertTrue(actualAsset.getAdditionalInfo() instanceof NullNode);
    assertNull(actualAsset.getVersion());
    assertNull(actualAsset.getLabel());
    assertNull(actualAsset.getName());
    assertNull(actualAsset.getType());
    assertNull(actualAsset.getUuidId());
    assertNull(actualAsset.getExternalId());
    assertNull(actualAsset.getId());
    assertNull(actualAsset.getAssetProfileId());
    assertNull(actualAsset.getCustomerId());
    assertNull(actualAsset.getTenantId());
    assertEquals(0L, actualAsset.getCreatedTime());
  }

  /**
   * Test {@link Asset#getId()}.
   *
   * <p>Method under test: {@link Asset#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetId Asset.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new Asset().getId());
  }

  /**
   * Test {@link Asset#getCreatedTime()}.
   *
   * <p>Method under test: {@link Asset#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Asset.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new Asset().getCreatedTime());
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Asset(Asset) with asset is Asset(); then return instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAssetWithAssetIsAsset_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Asset(new Asset()).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset(Asset)}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Asset(Asset) with asset is Asset(Asset); then return instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAssetWithAssetIsAsset_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Asset(new Asset(new Asset())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Asset#Asset()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Asset(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAsset_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Asset().getAdditionalInfo());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Asset asset = new Asset();
    Asset asset2 = new Asset();

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(TenantId.SYS_TENANT_ID);

    Asset asset2 = new Asset();
    asset2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    Asset asset2 = new Asset();
    asset2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Asset asset = new Asset();
    asset.setName("Name");

    Asset asset2 = new Asset();
    asset2.setName("Name");

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Asset asset = new Asset();
    asset.setType("Type");

    Asset asset2 = new Asset();
    asset2.setType("Type");

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Asset asset = new Asset();
    asset.setLabel("Label");

    Asset asset2 = new Asset();
    asset2.setLabel("Label");

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    Asset asset = new Asset();
    asset.setVersion(1L);

    Asset asset2 = new Asset();
    asset2.setVersion(1L);

    // Act and Assert
    assertEquals(asset, asset2);
    assertEquals(asset.hashCode(), asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Asset asset = new Asset();

    // Act and Assert
    assertEquals(asset, asset);
    int expectedHashCodeResult = asset.hashCode();
    assertEquals(expectedHashCodeResult, asset.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    // Act and Assert
    assertNotEquals(assetInfo, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Asset asset = new Asset(new Asset());

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Asset asset = new Asset();

    // Act and Assert
    assertNotEquals(asset, new AssetInfo());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Asset asset = new Asset();
    asset.setName("Name");

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Asset asset = new Asset();
    asset.setType("Type");

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Asset asset = new Asset();
    asset.setLabel("Label");

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Asset asset = new Asset();
    asset.setVersion(1L);

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setName("Name");

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setType("Type");

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setLabel("Label");

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setVersion(1L);

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = mock(AssetInfo.class);
    when(assetInfo2.getVersion()).thenReturn(1L);
    when(assetInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = mock(AssetInfo.class);
    when(assetInfo2.getLabel()).thenReturn(null);
    when(assetInfo2.getName()).thenReturn(null);
    when(assetInfo2.getType()).thenReturn(null);
    when(assetInfo2.getExternalId()).thenReturn(null);
    when(assetInfo2.getAssetProfileId()).thenReturn(null);
    when(assetInfo2.getCustomerId()).thenReturn(null);
    when(assetInfo2.getTenantId()).thenReturn(null);
    when(assetInfo2.isCustomerIsPublic()).thenReturn(true);
    when(assetInfo2.getAssetProfileName()).thenReturn("foo.txt");
    when(assetInfo2.getCustomerTitle()).thenReturn("Dr");
    when(assetInfo2.getVersion()).thenReturn(null);
    when(assetInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = mock(AssetInfo.class);
    when(assetInfo2.getLabel()).thenReturn(null);
    when(assetInfo2.getName()).thenReturn(null);
    when(assetInfo2.getType()).thenReturn(null);
    when(assetInfo2.getExternalId()).thenReturn(new AssetId(EntityId.NULL_UUID));
    when(assetInfo2.getAssetProfileId()).thenReturn(null);
    when(assetInfo2.getCustomerId()).thenReturn(null);
    when(assetInfo2.getTenantId()).thenReturn(null);
    when(assetInfo2.isCustomerIsPublic()).thenReturn(true);
    when(assetInfo2.getAssetProfileName()).thenReturn("foo.txt");
    when(assetInfo2.getCustomerTitle()).thenReturn("Dr");
    when(assetInfo2.getVersion()).thenReturn(null);
    when(assetInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = mock(AssetInfo.class);
    when(assetInfo2.getLabel()).thenReturn(null);
    when(assetInfo2.getName()).thenReturn(null);
    when(assetInfo2.getType()).thenReturn(null);
    when(assetInfo2.getExternalId()).thenReturn(null);
    when(assetInfo2.getAssetProfileId()).thenReturn(new AssetProfileId(EntityId.NULL_UUID));
    when(assetInfo2.getCustomerId()).thenReturn(null);
    when(assetInfo2.getTenantId()).thenReturn(null);
    when(assetInfo2.isCustomerIsPublic()).thenReturn(true);
    when(assetInfo2.getAssetProfileName()).thenReturn("foo.txt");
    when(assetInfo2.getCustomerTitle()).thenReturn("Dr");
    when(assetInfo2.getVersion()).thenReturn(null);
    when(assetInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Asset(), null);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Asset(), "Different type to Asset");
  }
}
