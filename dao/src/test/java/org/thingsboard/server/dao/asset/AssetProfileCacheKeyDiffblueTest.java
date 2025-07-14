package org.thingsboard.server.dao.asset;

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
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class AssetProfileCacheKeyDiffblueTest {
  /**
   * Test {@link AssetProfileCacheKey#forName(TenantId, String)}.
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forName(TenantId, String)}
   */
  @Test
  @DisplayName("Test forName(TenantId, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forName(TenantId, String)"})
  void testForName() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AssetProfileCacheKey actualForNameResult = AssetProfileCacheKey.forName(tenantId, "Name");

    // Assert
    assertEquals("Name", actualForNameResult.getName());
    assertNull(actualForNameResult.getAssetProfileId());
    assertFalse(actualForNameResult.isDefaultProfile());
    assertFalse(actualForNameResult.isVersioned());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForNameResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#forId(AssetProfileId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forId(AssetProfileId)}
   */
  @Test
  @DisplayName("Test forId(AssetProfileId); when 'null'; then return Name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forId(AssetProfileId)"})
  void testForId_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    AssetProfileCacheKey actualForIdResult = AssetProfileCacheKey.forId(null);

    // Assert
    assertNull(actualForIdResult.getName());
    assertNull(actualForIdResult.getAssetProfileId());
    assertNull(actualForIdResult.getTenantId());
    assertFalse(actualForIdResult.isDefaultProfile());
    assertFalse(actualForIdResult.isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}.
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}
   */
  @Test
  @DisplayName("Test forDefaultProfile(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forDefaultProfile(TenantId)"})
  void testForDefaultProfile() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AssetProfileCacheKey actualForDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(tenantId);

    // Assert
    assertNull(actualForDefaultProfileResult.getName());
    assertNull(actualForDefaultProfileResult.getAssetProfileId());
    assertFalse(actualForDefaultProfileResult.isVersioned());
    assertTrue(actualForDefaultProfileResult.isDefaultProfile());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForDefaultProfileResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        AssetProfileCacheKey.forId(
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  void testToString_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080_Name}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '13814000-1dd2-11b2-8080-808080808080_Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  void testToString_thenReturn138140001dd211b28080808080808080Name() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080_Name",
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name").toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given forDefaultProfile SYSTEM_TENANT; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileCacheKey.isVersioned()"})
  void testIsVersioned_givenForDefaultProfileSystem_tenant_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfileCacheKey.isVersioned()"})
  void testIsVersioned_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        AssetProfileCacheKey.forId(
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);
    AssetProfileCacheKey forDefaultProfileResult2 =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);
    AssetProfileCacheKey forDefaultProfileResult2 = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");
    AssetProfileCacheKey forNameResult2 =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertEquals(forNameResult, forNameResult2);
    int expectedHashCodeResult = forNameResult.hashCode();
    assertEquals(expectedHashCodeResult, forNameResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult,
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult,
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(
            ModelConstants.SYSTEM_TENANT, "org.thingsboard.server.dao.asset.AssetProfileCacheKey");

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT),
        "Different type to AssetProfileCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#getAssetProfileId()}
   *   <li>{@link AssetProfileCacheKey#getName()}
   *   <li>{@link AssetProfileCacheKey#getTenantId()}
   *   <li>{@link AssetProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfileId AssetProfileCacheKey.getAssetProfileId()",
    "String AssetProfileCacheKey.getName()",
    "TenantId AssetProfileCacheKey.getTenantId()",
    "boolean AssetProfileCacheKey.isDefaultProfile()"
  })
  void testGettersAndSetters() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act
    AssetProfileId actualAssetProfileId = forDefaultProfileResult.getAssetProfileId();
    String actualName = forDefaultProfileResult.getName();
    TenantId actualTenantId = forDefaultProfileResult.getTenantId();

    // Assert
    assertNull(actualName);
    assertNull(actualAssetProfileId);
    assertTrue(forDefaultProfileResult.isDefaultProfile());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
