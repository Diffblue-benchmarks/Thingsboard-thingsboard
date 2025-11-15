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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.build()).thenReturn(buildResult2);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder6 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder5);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder7 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder7.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder6);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult3 = resourceInfoCacheKeyBuilder7
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.build()).thenReturn(buildResult2);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder6 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder5);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder7 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder7.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder6);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult3 = resourceInfoCacheKeyBuilder7
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ResourceInfoCacheKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#ResourceInfoCacheKey(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoCacheKey#toString()}
   *   <li>{@link ResourceInfoCacheKey#getTbResourceId()}
   *   <li>{@link ResourceInfoCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoCacheKey actualResourceInfoCacheKey = new ResourceInfoCacheKey(tenantId, tbResourceId);
    actualResourceInfoCacheKey.toString();
    TbResourceId actualTbResourceId = actualResourceInfoCacheKey.getTbResourceId();

    // Assert
    assertSame(tbResourceId, actualTbResourceId);
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#build()}
   *   <li>
   * {@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#tbResourceId(TbResourceId)}
   *   <li>
   * {@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testResourceInfoCacheKeyBuilderBuild() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult.tbResourceId(tbResourceId);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ResourceInfoCacheKey actualBuildResult = tbResourceIdResult.tenantId(tenantId).build();

    // Assert
    assertSame(tbResourceId, actualBuildResult.getTbResourceId());
    assertSame(tenantId, actualBuildResult.getTenantId());
  }
}
