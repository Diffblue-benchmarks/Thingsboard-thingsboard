package org.thingsboard.server.dao.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetCacheKey.AssetCacheKeyBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {AssetCacheKeyBuilder.class})
@ExtendWith(SpringExtension.class)
class AssetCacheKeyDiffblueTest {
  @Autowired private AssetCacheKeyBuilder assetCacheKeyBuilder;

  /**
   * Test AssetCacheKeyBuilder {@link AssetCacheKeyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKeyBuilder#build()}
   *   <li>{@link AssetCacheKeyBuilder#name(String)}
   *   <li>{@link AssetCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test AssetCacheKeyBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetCacheKeyBuilder.<init>()",
    "AssetCacheKey AssetCacheKeyBuilder.build()",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.name(String)",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.tenantId(TenantId)",
    "String AssetCacheKeyBuilder.toString()"
  })
  void testAssetCacheKeyBuilderBuild() {
    // Arrange and Act
    AssetCacheKey actualAssetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Assert
    assertEquals("Name", actualAssetCacheKey.getName());
    assertSame(TenantId.SYS_TENANT_ID, actualAssetCacheKey.getTenantId());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey assetCacheKey2 =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey assetCacheKey2 =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetCacheKey assetCacheKey = AssetCacheKey.builder().name("Name").tenantId(null).build();
    AssetCacheKey assetCacheKey2 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey);
    int expectedHashCodeResult = assetCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheKey.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("42").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetCacheKeyBuilder nameResult = AssetCacheKey.builder().name("Name");
    AssetCacheKey assetCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetCacheKey assetCacheKey = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build(), null);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build(),
        "Different type to AssetCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#AssetCacheKey(TenantId, String)}
   *   <li>{@link AssetCacheKey#toString()}
   *   <li>{@link AssetCacheKey#getName()}
   *   <li>{@link AssetCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetCacheKey.<init>(TenantId, String)",
    "String AssetCacheKey.getName()",
    "TenantId AssetCacheKey.getTenantId()",
    "String AssetCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetCacheKey actualAssetCacheKey = new AssetCacheKey(ModelConstants.SYSTEM_TENANT, "Name");
    String actualToStringResult = actualAssetCacheKey.toString();
    String actualName = actualAssetCacheKey.getName();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Name", actualToStringResult);
    assertEquals("Name", actualName);
    assertSame(TenantId.SYS_TENANT_ID, actualAssetCacheKey.getTenantId());
  }
}
