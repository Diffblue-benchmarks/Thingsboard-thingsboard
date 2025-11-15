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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class WidgetTypeFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder3 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder3.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = widgetTypeFilterBuilder3
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(false)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(null);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("42");
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(widgetTypes).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder3 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder3.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = widgetTypeFilterBuilder3
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder builderResult = WidgetTypeFilter.builder();
    builderResult.deprecatedFilter(DeprecatedFilter.ALL);
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(builderResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder3 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder3.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult2 = widgetTypeFilterBuilder3
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to WidgetTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WidgetTypeFilter#WidgetTypeFilter(TenantId, boolean, boolean, DeprecatedFilter, List)}
   *   <li>{@link WidgetTypeFilter#setDeprecatedFilter(DeprecatedFilter)}
   *   <li>{@link WidgetTypeFilter#setFullSearch(boolean)}
   *   <li>{@link WidgetTypeFilter#setScadaFirst(boolean)}
   *   <li>{@link WidgetTypeFilter#setTenantId(TenantId)}
   *   <li>{@link WidgetTypeFilter#setWidgetTypes(List)}
   *   <li>{@link WidgetTypeFilter#toString()}
   *   <li>{@link WidgetTypeFilter#getDeprecatedFilter()}
   *   <li>{@link WidgetTypeFilter#getTenantId()}
   *   <li>{@link WidgetTypeFilter#getWidgetTypes()}
   *   <li>{@link WidgetTypeFilter#isFullSearch()}
   *   <li>{@link WidgetTypeFilter#isScadaFirst()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeFilter actualWidgetTypeFilter = new WidgetTypeFilter(TenantId.SYS_TENANT_ID, true, true,
        DeprecatedFilter.ALL, new ArrayList<>());
    actualWidgetTypeFilter.setDeprecatedFilter(DeprecatedFilter.ALL);
    actualWidgetTypeFilter.setFullSearch(true);
    actualWidgetTypeFilter.setScadaFirst(true);
    actualWidgetTypeFilter.setTenantId(TenantId.SYS_TENANT_ID);
    ArrayList<String> widgetTypes = new ArrayList<>();
    actualWidgetTypeFilter.setWidgetTypes(widgetTypes);
    String actualToStringResult = actualWidgetTypeFilter.toString();
    DeprecatedFilter actualDeprecatedFilter = actualWidgetTypeFilter.getDeprecatedFilter();
    TenantId actualTenantId = actualWidgetTypeFilter.getTenantId();
    List<String> actualWidgetTypes = actualWidgetTypeFilter.getWidgetTypes();
    boolean actualIsFullSearchResult = actualWidgetTypeFilter.isFullSearch();
    boolean actualIsScadaFirstResult = actualWidgetTypeFilter.isScadaFirst();

    // Assert that nothing has changed
    assertEquals("WidgetTypeFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, fullSearch=true, scadaFirst=true,"
        + " deprecatedFilter=ALL, widgetTypes=[])", actualToStringResult);
    assertEquals(DeprecatedFilter.ALL, actualDeprecatedFilter);
    assertTrue(actualWidgetTypes.isEmpty());
    assertTrue(actualIsFullSearchResult);
    assertTrue(actualIsScadaFirstResult);
    assertSame(widgetTypes, actualWidgetTypes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter.WidgetTypeFilterBuilder#build()}
   *   <li>
   * {@link WidgetTypeFilter.WidgetTypeFilterBuilder#deprecatedFilter(DeprecatedFilter)}
   *   <li>{@link WidgetTypeFilter.WidgetTypeFilterBuilder#fullSearch(boolean)}
   *   <li>{@link WidgetTypeFilter.WidgetTypeFilterBuilder#scadaFirst(boolean)}
   *   <li>{@link WidgetTypeFilter.WidgetTypeFilterBuilder#tenantId(TenantId)}
   *   <li>{@link WidgetTypeFilter.WidgetTypeFilterBuilder#widgetTypes(List)}
   * </ul>
   */
  @Test
  void testWidgetTypeFilterBuilderBuild() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    // Act
    WidgetTypeFilter actualBuildResult = tenantIdResult.widgetTypes(widgetTypes).build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(DeprecatedFilter.ALL, actualBuildResult.getDeprecatedFilter());
    List<String> widgetTypes2 = actualBuildResult.getWidgetTypes();
    assertTrue(widgetTypes2.isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualBuildResult.isFullSearch());
    assertTrue(actualBuildResult.isScadaFirst());
    assertSame(widgetTypes, widgetTypes2);
  }
}
