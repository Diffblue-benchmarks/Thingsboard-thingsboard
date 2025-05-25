package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetDiffblueTest {
  /**
   * Test {@link Asset#getExternalId()}.
   * <p>
   * Method under test: {@link Asset#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AssetId Asset.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Asset()).getExternalId());
  }

  /**
   * Test {@link Asset#Asset(Asset)}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset(Asset) with asset is Asset()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset(Asset)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#Asset(Asset)}
   */
  @Test
  @DisplayName("Test new Asset(Asset); when Asset(Asset) with asset is Asset(Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Asset.<init>(Asset)"})
  void testNewAsset_whenAssetWithAssetIsAsset2() {
    // Arrange and Act
    Asset actualAsset = new Asset(new Asset(new Asset(new Asset())));

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
   * <p>
   * Method under test: {@link Asset#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AssetId Asset.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Asset()).getId());
  }

  /**
   * Test {@link Asset#getCreatedTime()}.
   * <p>
   * Method under test: {@link Asset#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Asset.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Asset()).getCreatedTime());
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Asset(Asset) with asset is Asset(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAssetWithAssetIsAsset_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Asset(new Asset())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset(Asset)}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Asset(Asset) with asset is Asset(Asset); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAssetWithAssetIsAsset_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Asset(new Asset(new Asset()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Asset#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Asset#Asset()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Asset(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Asset.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenAsset_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Asset()).getAdditionalInfo());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Asset asset = new Asset();
    Asset asset2 = new Asset();

    // Act and Assert
    assertEquals(asset, asset2);
    int expectedHashCodeResult = asset.hashCode();
    assertEquals(expectedHashCodeResult, asset2.hashCode());
  }

  /**
   * Test {@link Asset#equals(Object)}, and {@link Asset#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Asset#equals(Object)}
   *   <li>{@link Asset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    // Act and Assert
    assertNotEquals(assetInfo, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Asset asset = new Asset(new Asset());

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Asset asset = new Asset();

    // Act and Assert
    assertNotEquals(asset, new AssetInfo());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(asset, new Asset());
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Asset asset = new Asset();

    Asset asset2 = new Asset();
    asset2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(asset, asset2);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Asset(), null);
  }

  /**
   * Test {@link Asset#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Asset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Asset.equals(Object)", "int Asset.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Asset(), "Different type to Asset");
  }
}
