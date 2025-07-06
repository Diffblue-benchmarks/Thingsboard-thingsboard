package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssetInfoDiffblueTest {
  /**
   * Test {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}
   */
  @Test
  @DisplayName("Test new AssetInfo(Asset, String, boolean, String); when Asset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetInfo.<init>(Asset, String, boolean, String)"})
  void testNewAssetInfo_whenAsset() {
    // Arrange and Act
    AssetInfo actualAssetInfo = new AssetInfo(new Asset(), "Dr", true, "foo.txt");

    // Assert
    assertTrue(actualAssetInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualAssetInfo.getCustomerTitle());
    assertEquals("foo.txt", actualAssetInfo.getAssetProfileName());
    assertNull(actualAssetInfo.getVersion());
    assertNull(actualAssetInfo.getLabel());
    assertNull(actualAssetInfo.getName());
    assertNull(actualAssetInfo.getType());
    assertNull(actualAssetInfo.getUuidId());
    assertNull(actualAssetInfo.getExternalId());
    assertNull(actualAssetInfo.getId());
    assertNull(actualAssetInfo.getAssetProfileId());
    assertNull(actualAssetInfo.getCustomerId());
    assertNull(actualAssetInfo.getTenantId());
    assertEquals(0L, actualAssetInfo.getCreatedTime());
    assertTrue(actualAssetInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new AssetInfo(Asset, String, boolean, String); when Asset(Asset) with asset is Asset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetInfo.<init>(Asset, String, boolean, String)"})
  void testNewAssetInfo_whenAssetWithAssetIsAsset() {
    // Arrange and Act
    AssetInfo actualAssetInfo = new AssetInfo(new Asset(new Asset()), "Dr", true, "foo.txt");

    // Assert
    assertTrue(actualAssetInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualAssetInfo.getCustomerTitle());
    assertEquals("foo.txt", actualAssetInfo.getAssetProfileName());
    assertNull(actualAssetInfo.getVersion());
    assertNull(actualAssetInfo.getLabel());
    assertNull(actualAssetInfo.getName());
    assertNull(actualAssetInfo.getType());
    assertNull(actualAssetInfo.getUuidId());
    assertNull(actualAssetInfo.getExternalId());
    assertNull(actualAssetInfo.getId());
    assertNull(actualAssetInfo.getAssetProfileId());
    assertNull(actualAssetInfo.getCustomerId());
    assertNull(actualAssetInfo.getTenantId());
    assertEquals(0L, actualAssetInfo.getCreatedTime());
    assertTrue(actualAssetInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset(Asset)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#AssetInfo(Asset, String, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new AssetInfo(Asset, String, boolean, String); when Asset(Asset) with asset is Asset(Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetInfo.<init>(Asset, String, boolean, String)"})
  void testNewAssetInfo_whenAssetWithAssetIsAsset2() {
    // Arrange and Act
    AssetInfo actualAssetInfo =
        new AssetInfo(new Asset(new Asset(new Asset())), "Dr", true, "foo.txt");

    // Assert
    assertTrue(actualAssetInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualAssetInfo.getCustomerTitle());
    assertEquals("foo.txt", actualAssetInfo.getAssetProfileName());
    assertNull(actualAssetInfo.getVersion());
    assertNull(actualAssetInfo.getLabel());
    assertNull(actualAssetInfo.getName());
    assertNull(actualAssetInfo.getType());
    assertNull(actualAssetInfo.getUuidId());
    assertNull(actualAssetInfo.getExternalId());
    assertNull(actualAssetInfo.getId());
    assertNull(actualAssetInfo.getAssetProfileId());
    assertNull(actualAssetInfo.getCustomerId());
    assertNull(actualAssetInfo.getTenantId());
    assertEquals(0L, actualAssetInfo.getCreatedTime());
    assertTrue(actualAssetInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}, and {@link AssetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfo#equals(Object)}
   *   <li>{@link AssetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    AssetInfo assetInfo2 = new AssetInfo();

    // Act and Assert
    assertEquals(assetInfo, assetInfo2);
    int expectedHashCodeResult = assetInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetInfo2.hashCode());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}, and {@link AssetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfo#equals(Object)}
   *   <li>{@link AssetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo(new Asset(), "Dr", true, "foo.txt");
    AssetInfo assetInfo2 = new AssetInfo(new Asset(), "Dr", true, "foo.txt");

    // Act and Assert
    assertEquals(assetInfo, assetInfo2);
    int notExpectedHashCodeResult = assetInfo.hashCode();
    assertNotEquals(notExpectedHashCodeResult, assetInfo2.hashCode());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}, and {@link AssetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfo#equals(Object)}
   *   <li>{@link AssetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    // Act and Assert
    assertEquals(assetInfo, assetInfo);
    int expectedHashCodeResult = assetInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetInfo.hashCode());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo(new Asset(), "Dr", true, "foo.txt");

    // Act and Assert
    assertNotEquals(assetInfo, new AssetInfo());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    assetInfo.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfo, new AssetInfo());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    assetInfo.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(assetInfo, new AssetInfo());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    assetInfo.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfo, new AssetInfo());
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = new AssetInfo();
    assetInfo2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();

    AssetInfo assetInfo2 = new AssetInfo();
    assetInfo2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfo, assetInfo2);
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfo(), null);
  }

  /**
   * Test {@link AssetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetInfo.equals(Object)", "int AssetInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfo(), "Different type to AssetInfo");
  }
}
