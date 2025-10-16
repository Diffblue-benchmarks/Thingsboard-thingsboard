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
    ResourceInfoCacheKey resourceInfoCacheKey =
        ResourceInfoCacheKey.builder().tbResourceId(null).tenantId(null).build();
    ResourceInfoCacheKey resourceInfoCacheKey2 =
        ResourceInfoCacheKey.builder().tbResourceId(null).tenantId(null).build();

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
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey =
        builderResult.tbResourceId(new TbResourceId(null)).tenantId(null).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey2 =
        builderResult2.tbResourceId(new TbResourceId(null)).tenantId(null).build();

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
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

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
        tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult2.tbResourceId(new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build());
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
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey resourceInfoCacheKey =
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID())).tenantId(null).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult2.tbResourceId(new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey, tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build());
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
    ResourceInfoCacheKey resourceInfoCacheKey =
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID())).tenantId(null).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        builderResult2.tbResourceId(new TbResourceId(UUID.randomUUID())).tenantId(null).build());
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
    ResourceInfoCacheKey resourceInfoCacheKey =
        ResourceInfoCacheKey.builder().tbResourceId(null).tenantId(null).build();

    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    // Act and Assert
    assertNotEquals(
        resourceInfoCacheKey,
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID())).tenantId(null).build());
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult =
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey resourceInfoCacheKey =
        tbResourceIdResult.tenantId(new TenantId(null)).build();

    ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();

    ResourceInfoCacheKeyBuilder tbResourceIdResult2 =
        builderResult2.tbResourceId(new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoCacheKey, tbResourceIdResult2.tenantId(new TenantId(null)).build());
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
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build(), null);
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
        builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(
        tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build(),
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
    "java.lang.String ResourceInfoCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoCacheKey actualResourceInfoCacheKey =
        new ResourceInfoCacheKey(tenantId, tbResourceId);
    actualResourceInfoCacheKey.toString();
    TbResourceId actualTbResourceId = actualResourceInfoCacheKey.getTbResourceId();

    // Assert
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
    "java.lang.String ResourceInfoCacheKeyBuilder.toString()"
  })
  void testResourceInfoCacheKeyBuilderBuild() {
    // Arrange and Act
    ResourceInfoCacheKeyBuilder actualBuilderResult = ResourceInfoCacheKey.builder();
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());
    ResourceInfoCacheKeyBuilder actualTbResourceIdResult =
        actualBuilderResult.tbResourceId(tbResourceId);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoCacheKey actualResourceInfoCacheKey =
        actualTbResourceIdResult.tenantId(tenantId).build();

    // Assert
    assertSame(tbResourceId, actualResourceInfoCacheKey.getTbResourceId());
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }
}
