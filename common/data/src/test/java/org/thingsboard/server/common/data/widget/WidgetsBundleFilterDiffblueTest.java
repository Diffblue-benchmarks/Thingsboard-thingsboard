package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter.WidgetsBundleFilterBuilder;

@ContextConfiguration(classes = {WidgetsBundleFilterBuilder.class})
@ExtendWith(SpringExtension.class)
class WidgetsBundleFilterDiffblueTest {
  @Autowired private WidgetsBundleFilterBuilder widgetsBundleFilterBuilder;

  /**
   * Test {@link WidgetsBundleFilter#fromTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleFilter#fromTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test fromTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundleFilter WidgetsBundleFilter.fromTenantId(TenantId)"})
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
   * Test {@link WidgetsBundleFilter#fullSearchFromTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleFilter#fullSearchFromTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test fullSearchFromTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundleFilter WidgetsBundleFilter.fullSearchFromTenantId(TenantId)"})
  void testFullSearchFromTenantId() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    WidgetsBundleFilter actualFullSearchFromTenantIdResult =
        WidgetsBundleFilter.fullSearchFromTenantId(tenantId);

    // Assert
    assertFalse(actualFullSearchFromTenantIdResult.isScadaFirst());
    assertTrue(actualFullSearchFromTenantIdResult.isFullSearch());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFullSearchFromTenantIdResult.getTenantId());
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}, and {@link WidgetsBundleFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleFilter buildResult =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder()
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
   * Test {@link WidgetsBundleFilter#equals(Object)}, and {@link WidgetsBundleFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult =
        widgetsBundleFilterBuilder.fullSearch(true).scadaFirst(true).tenantId(null).build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder().fullSearch(false).scadaFirst(true).tenantId(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}, and {@link WidgetsBundleFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleFilter#equals(Object)}
   *   <li>{@link WidgetsBundleFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleFilter buildResult =
        WidgetsBundleFilter.builder()
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
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult =
        widgetsBundleFilterBuilder
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult =
        widgetsBundleFilterBuilder
            .fullSearch(true)
            .scadaFirst(false)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder()
            .fullSearch(false)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilterBuilder scadaFirstResult =
        widgetsBundleFilterBuilder.fullSearch(true).scadaFirst(true);
    WidgetsBundleFilter buildResult =
        scadaFirstResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder()
            .fullSearch(false)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter buildResult =
        widgetsBundleFilterBuilder.fullSearch(true).scadaFirst(true).tenantId(null).build();
    WidgetsBundleFilter buildResult2 =
        WidgetsBundleFilter.builder()
            .fullSearch(false)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilter buildResult =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link WidgetsBundleFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleFilter.equals(Object)",
    "int WidgetsBundleFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleFilter buildResult =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to WidgetsBundleFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleFilter#WidgetsBundleFilter(TenantId, boolean, boolean)}
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WidgetsBundleFilter.<init>(TenantId, boolean, boolean)",
    "TenantId WidgetsBundleFilter.getTenantId()",
    "boolean WidgetsBundleFilter.isFullSearch()",
    "boolean WidgetsBundleFilter.isScadaFirst()",
    "void WidgetsBundleFilter.setFullSearch(boolean)",
    "void WidgetsBundleFilter.setScadaFirst(boolean)",
    "void WidgetsBundleFilter.setTenantId(TenantId)",
    "String WidgetsBundleFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleFilter actualWidgetsBundleFilter =
        new WidgetsBundleFilter(TenantId.SYS_TENANT_ID, true, true);
    actualWidgetsBundleFilter.setFullSearch(true);
    actualWidgetsBundleFilter.setScadaFirst(true);
    actualWidgetsBundleFilter.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualWidgetsBundleFilter.toString();
    TenantId actualTenantId = actualWidgetsBundleFilter.getTenantId();
    boolean actualIsFullSearchResult = actualWidgetsBundleFilter.isFullSearch();

    // Assert
    assertEquals(
        "WidgetsBundleFilter(tenantId=13814000-1dd2-11b2-8080-808080808080, fullSearch=true, scadaFirst=true)",
        actualToStringResult);
    assertTrue(actualIsFullSearchResult);
    assertTrue(actualWidgetsBundleFilter.isScadaFirst());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test WidgetsBundleFilterBuilder {@link WidgetsBundleFilterBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleFilterBuilder#build()}
   *   <li>{@link WidgetsBundleFilterBuilder#fullSearch(boolean)}
   *   <li>{@link WidgetsBundleFilterBuilder#scadaFirst(boolean)}
   *   <li>{@link WidgetsBundleFilterBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test WidgetsBundleFilterBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WidgetsBundleFilterBuilder.<init>()",
    "WidgetsBundleFilter WidgetsBundleFilterBuilder.build()",
    "WidgetsBundleFilterBuilder WidgetsBundleFilterBuilder.fullSearch(boolean)",
    "WidgetsBundleFilterBuilder WidgetsBundleFilterBuilder.scadaFirst(boolean)",
    "WidgetsBundleFilterBuilder WidgetsBundleFilterBuilder.tenantId(TenantId)",
    "String WidgetsBundleFilterBuilder.toString()"
  })
  void testWidgetsBundleFilterBuilderBuild() {
    // Arrange and Act
    WidgetsBundleFilter actualBuildResult =
        WidgetsBundleFilter.builder()
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
