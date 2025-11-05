package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter.WidgetTypeFilterBuilder;

@ContextConfiguration(classes = {WidgetTypeFilterBuilder.class})
@ExtendWith(SpringExtension.class)
class WidgetTypeFilterDiffblueTest {
  @Autowired private WidgetTypeFilterBuilder widgetTypeFilterBuilder;

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}, and {@link WidgetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(widgetTypeFilter, widgetTypeFilter2);
    assertEquals(widgetTypeFilter.hashCode(), widgetTypeFilter2.hashCode());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}, and {@link WidgetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(null)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(null)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(widgetTypeFilter, widgetTypeFilter2);
    assertEquals(widgetTypeFilter.hashCode(), widgetTypeFilter2.hashCode());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}, and {@link WidgetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(null);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(null);
    WidgetTypeFilter widgetTypeFilter2 = tenantIdResult2.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(widgetTypeFilter, widgetTypeFilter2);
    assertEquals(widgetTypeFilter.hashCode(), widgetTypeFilter2.hashCode());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}, and {@link WidgetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilter#equals(Object)}
   *   <li>{@link WidgetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(widgetTypeFilter, widgetTypeFilter);
    int expectedHashCodeResult = widgetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeFilter.hashCode());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(null)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ACTUAL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(false)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(false)
            .tenantId(TenantId.SYS_TENANT_ID);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeFilterBuilder scadaFirstResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true);

    WidgetTypeFilterBuilder tenantIdResult =
        scadaFirstResult.tenantId(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(null);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    WidgetTypeFilterBuilder tenantIdResult2 =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult2.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    WidgetTypeFilter widgetTypeFilter =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .widgetTypes(widgetTypes)
            .build();

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(widgetTypeFilter, tenantIdResult.widgetTypes(new ArrayList<>()).build());
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenantIdResult.widgetTypes(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link WidgetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeFilter.equals(Object)", "int WidgetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(
        tenantIdResult.widgetTypes(new ArrayList<>()).build(),
        "Different type to WidgetTypeFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilter#WidgetTypeFilter(TenantId, boolean, boolean, DeprecatedFilter,
   *       List)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeFilter.<init>(TenantId, boolean, boolean, DeprecatedFilter, List)",
    "DeprecatedFilter WidgetTypeFilter.getDeprecatedFilter()",
    "TenantId WidgetTypeFilter.getTenantId()",
    "List WidgetTypeFilter.getWidgetTypes()",
    "boolean WidgetTypeFilter.isFullSearch()",
    "boolean WidgetTypeFilter.isScadaFirst()",
    "void WidgetTypeFilter.setDeprecatedFilter(DeprecatedFilter)",
    "void WidgetTypeFilter.setFullSearch(boolean)",
    "void WidgetTypeFilter.setScadaFirst(boolean)",
    "void WidgetTypeFilter.setTenantId(TenantId)",
    "void WidgetTypeFilter.setWidgetTypes(List)",
    "String WidgetTypeFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeFilter actualWidgetTypeFilter =
        new WidgetTypeFilter(
            TenantId.SYS_TENANT_ID, true, true, DeprecatedFilter.ALL, new ArrayList<>());
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

    // Assert
    assertEquals(
        "WidgetTypeFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, fullSearch=true, scadaFirst=true,"
            + " deprecatedFilter=ALL, widgetTypes=[])",
        actualToStringResult);
    assertEquals(DeprecatedFilter.ALL, actualDeprecatedFilter);
    assertTrue(actualWidgetTypes.isEmpty());
    assertTrue(actualIsFullSearchResult);
    assertTrue(actualIsScadaFirstResult);
    assertSame(widgetTypes, actualWidgetTypes);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test WidgetTypeFilterBuilder {@link WidgetTypeFilterBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeFilterBuilder#build()}
   *   <li>{@link WidgetTypeFilterBuilder#deprecatedFilter(DeprecatedFilter)}
   *   <li>{@link WidgetTypeFilterBuilder#fullSearch(boolean)}
   *   <li>{@link WidgetTypeFilterBuilder#scadaFirst(boolean)}
   *   <li>{@link WidgetTypeFilterBuilder#tenantId(TenantId)}
   *   <li>{@link WidgetTypeFilterBuilder#widgetTypes(List)}
   * </ul>
   */
  @Test
  @DisplayName("Test WidgetTypeFilterBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeFilterBuilder.<init>()",
    "WidgetTypeFilter WidgetTypeFilterBuilder.build()",
    "WidgetTypeFilterBuilder WidgetTypeFilterBuilder.deprecatedFilter(DeprecatedFilter)",
    "WidgetTypeFilterBuilder WidgetTypeFilterBuilder.fullSearch(boolean)",
    "WidgetTypeFilterBuilder WidgetTypeFilterBuilder.scadaFirst(boolean)",
    "WidgetTypeFilterBuilder WidgetTypeFilterBuilder.tenantId(TenantId)",
    "String WidgetTypeFilterBuilder.toString()",
    "WidgetTypeFilterBuilder WidgetTypeFilterBuilder.widgetTypes(List)"
  })
  void testWidgetTypeFilterBuilderBuild() {
    // Arrange and Act
    WidgetTypeFilterBuilder actualTenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID);
    ArrayList<String> widgetTypes = new ArrayList<>();
    WidgetTypeFilter actualWidgetTypeFilter = actualTenantIdResult.widgetTypes(widgetTypes).build();

    // Assert
    assertEquals(DeprecatedFilter.ALL, actualWidgetTypeFilter.getDeprecatedFilter());
    List<String> widgetTypes2 = actualWidgetTypeFilter.getWidgetTypes();
    assertTrue(widgetTypes2.isEmpty());
    assertTrue(actualWidgetTypeFilter.isFullSearch());
    assertTrue(actualWidgetTypeFilter.isScadaFirst());
    assertSame(widgetTypes, widgetTypes2);
    assertSame(TenantId.SYS_TENANT_ID, actualWidgetTypeFilter.getTenantId());
  }
}
