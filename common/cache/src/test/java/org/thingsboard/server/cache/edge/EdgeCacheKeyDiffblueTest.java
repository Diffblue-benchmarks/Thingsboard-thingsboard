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
package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey.EdgeCacheKeyBuilder#build()}
   *   <li>{@link EdgeCacheKey.EdgeCacheKeyBuilder#name(String)}
   *   <li>{@link EdgeCacheKey.EdgeCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testEdgeCacheKeyBuilderBuild() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EdgeCacheKey actualBuildResult = nameResult.tenantId(tenantId).build();

    // Assert
    assertEquals("Name", actualBuildResult.getName());
    assertSame(tenantId, actualBuildResult.getTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder3);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder4.name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.name(Mockito.<String>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder.name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder builderResult = EdgeCacheKey.builder();
    builderResult.name("Name");
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder3);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder4.name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder5 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder5.build()).thenReturn(buildResult2);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder6 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(edgeCacheKeyBuilder5);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder7 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder7.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder6);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult3 = edgeCacheKeyBuilder7.name("Name");
    EdgeCacheKey buildResult3 = nameResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder builderResult = EdgeCacheKey.builder();
    builderResult.name("Name");
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder3);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder4.name("Name");
    EdgeCacheKey buildResult2 = nameResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder5 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder5.build()).thenReturn(buildResult2);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder6 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(edgeCacheKeyBuilder5);
    EdgeCacheKey.EdgeCacheKeyBuilder edgeCacheKeyBuilder7 = mock(EdgeCacheKey.EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder7.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder6);
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult3 = edgeCacheKeyBuilder7.name("Name");
    EdgeCacheKey buildResult3 = nameResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKey.EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EdgeCacheKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#EdgeCacheKey(TenantId, String)}
   *   <li>{@link EdgeCacheKey#toString()}
   *   <li>{@link EdgeCacheKey#getName()}
   *   <li>{@link EdgeCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EdgeCacheKey actualEdgeCacheKey = new EdgeCacheKey(tenantId, "Name");
    actualEdgeCacheKey.toString();
    String actualName = actualEdgeCacheKey.getName();

    // Assert
    assertEquals("Name", actualName);
    assertSame(tenantId, actualEdgeCacheKey.getTenantId());
  }
}
