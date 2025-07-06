package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileInfo.<init>(UUID, UUID, String, String, UUID)"})
  void testNewAssetProfileInfo_thenReturnDefaultDashboardIdEntityTypeIsDashboard() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID defaultDashboardId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    AssetProfileInfo actualAssetProfileInfo =
        new AssetProfileInfo(uuid, tenantId, "Name", "Image", defaultDashboardId);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    assertEquals("Image", actualAssetProfileInfo.getImage());
    assertEquals("Name", actualAssetProfileInfo.getName());
    assertEquals(EntityType.ASSET_PROFILE, id.getEntityType());
    DashboardId defaultDashboardId2 = actualAssetProfileInfo.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    TenantId tenantId2 = actualAssetProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(defaultDashboardId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(uuid, id.getId());
    assertSame(defaultDashboardId, defaultDashboardId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String, UUID)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DefaultDashboardId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#AssetProfileInfo(UUID, UUID, String, String,
   * UUID)}
   */
  @Test
  @DisplayName(
      "Test new AssetProfileInfo(UUID, UUID, String, String, UUID); when 'null'; then return DefaultDashboardId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileInfo.<init>(UUID, UUID, String, String, UUID)"})
  void testNewAssetProfileInfo_whenNull_thenReturnDefaultDashboardIdIsNull() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    AssetProfileInfo actualAssetProfileInfo =
        new AssetProfileInfo(uuid, tenantId, "Name", "Image", null);

    // Assert
    EntityId id = actualAssetProfileInfo.getId();
    assertTrue(id instanceof AssetProfileId);
    assertEquals("Image", actualAssetProfileInfo.getImage());
    assertEquals("Name", actualAssetProfileInfo.getName());
    assertNull(actualAssetProfileInfo.getDefaultDashboardId());
    assertEquals(EntityType.ASSET_PROFILE, id.getEntityType());
    TenantId tenantId2 = actualAssetProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(uuid, id.getId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileInfo assetProfileInfo2 =
        new AssetProfileInfo(
            uuid2,
            tenantId2,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(assetProfileInfo, assetProfileInfo2);
    int expectedHashCodeResult = assetProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileInfo2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfile profile = new AssetProfile();
    profile.setTenantId(TenantId.SYS_TENANT_ID);
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(profile);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfile profile = new AssetProfile();
    profile.setImage("Image");
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(profile);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());

    AssetProfile profile = new AssetProfile();
    profile.setImage("Image");

    // Act and Assert
    assertNotEquals(assetProfileInfo, new AssetProfileInfo(profile));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            uuid,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Name",
            "Image",
            EntityId.NULL_UUID);
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            uuid2,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileInfo assetProfileInfo =
        new AssetProfileInfo(
            uuid, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Name", "Image", null);
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        assetProfileInfo,
        new AssetProfileInfo(
            uuid2,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileInfo.equals(Object)", "int AssetProfileInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfileInfo(new AssetProfile()), "Different type to AssetProfileInfo");
  }
}
