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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter.WidgetTypeFilterBuilder;

class WidgetTypeFilterDiffblueTest {
  /**
   * Test {@link WidgetTypeFilter#equals(Object)}, and
   * {@link WidgetTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}, and
   * {@link WidgetTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}, and
   * {@link WidgetTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.fullSearch(anyBoolean())).thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder2 = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder2.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(widgetTypeFilterBuilder);
    WidgetTypeFilter.WidgetTypeFilterBuilder scadaFirstResult = widgetTypeFilterBuilder2
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = scadaFirstResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter buildResult2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link WidgetTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test WidgetTypeFilterBuilder {@link WidgetTypeFilterBuilder#build()}.
   * <p>
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
  @DisplayName("Test WidgetTypeFilterBuilder build()")
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
