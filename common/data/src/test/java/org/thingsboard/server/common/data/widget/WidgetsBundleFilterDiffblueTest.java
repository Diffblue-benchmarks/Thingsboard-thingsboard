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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class WidgetsBundleFilterDiffblueTest {
  /**
   * Method under test: {@link WidgetsBundleFilter#fromTenantId(TenantId)}
   */
  @Test
  void testFromTenantId() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    WidgetsBundleFilter actualFromTenantIdResult = WidgetsBundleFilter.fromTenantId(tenantId);

    // Assert
    assertFalse(actualFromTenantIdResult.isFullSearch());
    assertFalse(actualFromTenantIdResult.isScadaFirst());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFromTenantIdResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link WidgetsBundleFilter#fullSearchFromTenantId(TenantId)}
   */
  @Test
  void testFullSearchFromTenantId() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    WidgetsBundleFilter actualFullSearchFromTenantIdResult = WidgetsBundleFilter.fullSearchFromTenantId(tenantId);

    // Assert
    assertFalse(actualFullSearchFromTenantIdResult.isScadaFirst());
    assertTrue(actualFullSearchFromTenantIdResult.isFullSearch());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFullSearchFromTenantIdResult.getTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleFilter buildResult = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
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
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleFilter.WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(
        WidgetsBundleFilter.WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult = widgetsBundleFilterBuilder.fullSearch(true)
        .scadaFirst(true)
        .tenantId(null)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleFilter buildResult = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilter.WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(
        WidgetsBundleFilter.WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult = widgetsBundleFilterBuilder.fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleFilter.WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(
        WidgetsBundleFilter.WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult = widgetsBundleFilterBuilder.fullSearch(true)
        .scadaFirst(false)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleFilter.WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(
        WidgetsBundleFilter.WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult = widgetsBundleFilterBuilder.fullSearch(true)
        .scadaFirst(true)
        .tenantId(null)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleFilter.WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(
        WidgetsBundleFilter.WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult = widgetsBundleFilterBuilder.fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    WidgetsBundleFilter buildResult2 = WidgetsBundleFilter.builder()
        .fullSearch(false)
        .scadaFirst(true)
        .tenantId(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilter buildResult = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilter buildResult = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to WidgetsBundleFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WidgetsBundleFilter#WidgetsBundleFilter(TenantId, boolean, boolean)}
   *   <li>{@link WidgetsBundleFilter#setFullSearch(boolean)}
   *   <li>{@link WidgetsBundleFilter#setScadaFirst(boolean)}
   *   <li>{@link WidgetsBundleFilter#setTenantId(TenantId)}
   *   <li>{@link WidgetsBundleFilter#toString()}
   *   <li>{@link WidgetsBundleFilter#getTenantId()}
   *   <li>{@link WidgetsBundleFilter#isFullSearch()}
   *   <li>{@link WidgetsBundleFilter#isScadaFirst()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleFilter actualWidgetsBundleFilter = new WidgetsBundleFilter(TenantId.SYS_TENANT_ID, true, true);
    actualWidgetsBundleFilter.setFullSearch(true);
    actualWidgetsBundleFilter.setScadaFirst(true);
    actualWidgetsBundleFilter.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualWidgetsBundleFilter.toString();
    TenantId actualTenantId = actualWidgetsBundleFilter.getTenantId();
    boolean actualIsFullSearchResult = actualWidgetsBundleFilter.isFullSearch();

    // Assert that nothing has changed
    assertEquals("WidgetsBundleFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, fullSearch=true, scadaFirst=true)",
        actualToStringResult);
    assertTrue(actualIsFullSearchResult);
    assertTrue(actualWidgetsBundleFilter.isScadaFirst());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleFilter.WidgetsBundleFilterBuilder#build()}
   *   <li>
   * {@link WidgetsBundleFilter.WidgetsBundleFilterBuilder#fullSearch(boolean)}
   *   <li>
   * {@link WidgetsBundleFilter.WidgetsBundleFilterBuilder#scadaFirst(boolean)}
   *   <li>{@link WidgetsBundleFilter.WidgetsBundleFilterBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testWidgetsBundleFilterBuilderBuild() {
    // Arrange and Act
    WidgetsBundleFilter actualBuildResult = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualBuildResult.isFullSearch());
    assertTrue(actualBuildResult.isScadaFirst());
  }
}
