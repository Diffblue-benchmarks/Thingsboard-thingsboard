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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class TbResourceInfoFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult2
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter#equals(Object)}
   *   <li>{@link TbResourceInfoFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder2
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder3
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder3
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult2 = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult2
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = TbResourceInfoFilter.builder()
        .resourceSubTypes(resourceSubTypes);
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(null).build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = TbResourceInfoFilter.builder()
        .resourceSubTypes(resourceSubTypes);

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.JKS);
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(resourceTypes).tenantId(null).build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.build()).thenReturn(buildResult);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder2 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(tbResourceInfoFilterBuilder);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder3 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder3.resourceTypes(Mockito.<Set<ResourceType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder2);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder4 = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder4.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(tbResourceInfoFilterBuilder3);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult2 = tbResourceInfoFilterBuilder4
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult2 = resourceSubTypesResult2.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult3 = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult3 = resourceSubTypesResult3.resourceTypes(new HashSet<>()).tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link TbResourceInfoFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter buildResult = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbResourceInfoFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter#TbResourceInfoFilter(TenantId, Set, Set)}
   *   <li>{@link TbResourceInfoFilter#setResourceSubTypes(Set)}
   *   <li>{@link TbResourceInfoFilter#setResourceTypes(Set)}
   *   <li>{@link TbResourceInfoFilter#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfoFilter#toString()}
   *   <li>{@link TbResourceInfoFilter#getResourceSubTypes()}
   *   <li>{@link TbResourceInfoFilter#getResourceTypes()}
   *   <li>{@link TbResourceInfoFilter#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashSet<ResourceType> resourceTypes = new HashSet<>();

    // Act
    TbResourceInfoFilter actualTbResourceInfoFilter = new TbResourceInfoFilter(TenantId.SYS_TENANT_ID, resourceTypes,
        new HashSet<>());
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    actualTbResourceInfoFilter.setResourceSubTypes(resourceSubTypes);
    HashSet<ResourceType> resourceTypes2 = new HashSet<>();
    actualTbResourceInfoFilter.setResourceTypes(resourceTypes2);
    actualTbResourceInfoFilter.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTbResourceInfoFilter.toString();
    Set<ResourceSubType> actualResourceSubTypes = actualTbResourceInfoFilter.getResourceSubTypes();
    Set<ResourceType> actualResourceTypes = actualTbResourceInfoFilter.getResourceTypes();
    TenantId actualTenantId = actualTbResourceInfoFilter.getTenantId();

    // Assert that nothing has changed
    assertEquals(
        "TbResourceInfoFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, resourceTypes=[], resourceSubTypes"
            + "=[])",
        actualToStringResult);
    assertTrue(actualResourceSubTypes.isEmpty());
    assertTrue(actualResourceTypes.isEmpty());
    assertSame(resourceSubTypes, actualResourceSubTypes);
    assertSame(resourceTypes2, actualResourceTypes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoFilter.TbResourceInfoFilterBuilder#build()}
   *   <li>
   * {@link TbResourceInfoFilter.TbResourceInfoFilterBuilder#resourceSubTypes(Set)}
   *   <li>
   * {@link TbResourceInfoFilter.TbResourceInfoFilterBuilder#resourceTypes(Set)}
   *   <li>
   * {@link TbResourceInfoFilter.TbResourceInfoFilterBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testTbResourceInfoFilterBuilderBuild() {
    // Arrange
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(resourceSubTypes);
    HashSet<ResourceType> resourceTypes = new HashSet<>();

    // Act
    TbResourceInfoFilter actualBuildResult = resourceSubTypesResult.resourceTypes(resourceTypes)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    Set<ResourceSubType> resourceSubTypes2 = actualBuildResult.getResourceSubTypes();
    assertTrue(resourceSubTypes2.isEmpty());
    Set<ResourceType> resourceTypes2 = actualBuildResult.getResourceTypes();
    assertTrue(resourceTypes2.isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(resourceSubTypes, resourceSubTypes2);
    assertSame(resourceTypes, resourceTypes2);
  }
}
