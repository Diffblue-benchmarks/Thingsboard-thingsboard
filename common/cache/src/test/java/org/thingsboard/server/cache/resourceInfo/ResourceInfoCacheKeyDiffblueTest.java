package org.thingsboard.server.cache.resourceInfo;

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
import org.thingsboard.server.cache.resourceInfo.ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {ResourceInfoCacheKeyBuilder.class})
@ExtendWith(SpringExtension.class)
class ResourceInfoCacheKeyDiffblueTest {
  @Autowired private ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder;

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult2.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey resourceInfoCacheKey2 =
        tbResourceIdResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(resourceInfoCacheKey, resourceInfoCacheKey2);
    assertEquals(resourceInfoCacheKey.hashCode(), resourceInfoCacheKey2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        ResourceInfoCacheKey.builder().tbResourceId(null);
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        ResourceInfoCacheKey.builder().tbResourceId(null);
    ResourceInfoCacheKey resourceInfoCacheKey2 =
        tbResourceIdResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(resourceInfoCacheKey, resourceInfoCacheKey2);
    assertEquals(resourceInfoCacheKey.hashCode(), resourceInfoCacheKey2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey =
        builderResult
            .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(null)
            .build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey2 =
        builderResult2
            .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(null)
            .build();

    // Act and Assert
    assertEquals(resourceInfoCacheKey, resourceInfoCacheKey2);
    assertEquals(resourceInfoCacheKey.hashCode(), resourceInfoCacheKey2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and {@link ResourceInfoCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(resourceInfoCacheKey, resourceInfoCacheKey);
    int expectedHashCodeResult = resourceInfoCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, resourceInfoCacheKey.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult2.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        tbResourceIdResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        ResourceInfoCacheKey.builder().tbResourceId(null);
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        tbResourceIdResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult2.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        tbResourceIdResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey =
        builderResult
            .tbResourceId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(null)
            .build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult2.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build(),
        null);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoCacheKey.equals(Object)",
    "int ResourceInfoCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        tbResourceIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build(),
        "Different type to ResourceInfoCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#ResourceInfoCacheKey(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoCacheKey#toString()}
   *   <li>{@link ResourceInfoCacheKey#getTbResourceId()}
   *   <li>{@link ResourceInfoCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceInfoCacheKey.<init>(TenantId, TbResourceId)",
    "TbResourceId ResourceInfoCacheKey.getTbResourceId()",
    "TenantId ResourceInfoCacheKey.getTenantId()",
    "String ResourceInfoCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId tbResourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ResourceInfoCacheKey actualResourceInfoCacheKey =
        new ResourceInfoCacheKey(tenantId, tbResourceId);
    String actualToStringResult = actualResourceInfoCacheKey.toString();
    TbResourceId actualTbResourceId = actualResourceInfoCacheKey.getTbResourceId();

    // Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9_784f394c-42b6-435a-983c-b7beff2784f9",
        actualToStringResult);
    assertSame(tbResourceId, actualTbResourceId);
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }

  /**
   * Test ResourceInfoCacheKeyBuilder {@link ResourceInfoCacheKeyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoCacheKeyBuilder#build()}
   *   <li>{@link ResourceInfoCacheKeyBuilder#tbResourceId(TbResourceId)}
   *   <li>{@link ResourceInfoCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test ResourceInfoCacheKeyBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceInfoCacheKeyBuilder.<init>()",
    "ResourceInfoCacheKey ResourceInfoCacheKeyBuilder.build()",
    "ResourceInfoCacheKeyBuilder ResourceInfoCacheKeyBuilder.tbResourceId(TbResourceId)",
    "ResourceInfoCacheKeyBuilder ResourceInfoCacheKeyBuilder.tenantId(TenantId)",
    "String ResourceInfoCacheKeyBuilder.toString()"
  })
  void testResourceInfoCacheKeyBuilderBuild() {
    // Arrange and Act
    ResourceInfoCacheKeyBuilder actualBuilderResult = ResourceInfoCacheKey.builder();
    TbResourceId tbResourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoCacheKeyBuilder actualTbResourceIdResult =
        actualBuilderResult.tbResourceId(tbResourceId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoCacheKey actualResourceInfoCacheKey =
        actualTbResourceIdResult.tenantId(tenantId).build();

    // Assert
    assertSame(tbResourceId, actualResourceInfoCacheKey.getTbResourceId());
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }
}
