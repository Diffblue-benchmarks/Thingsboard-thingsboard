package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.edge.EdgeCacheKey.EdgeCacheKeyBuilder;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {EdgeCacheKeyBuilder.class})
@ExtendWith(SpringExtension.class)
class EdgeCacheKeyDiffblueTest {
  @Autowired
  private EdgeCacheKeyBuilder edgeCacheKeyBuilder;

  /**
   * Test EdgeCacheKeyBuilder {@link EdgeCacheKeyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKeyBuilder#build()}
   *   <li>{@link EdgeCacheKeyBuilder#name(String)}
   *   <li>{@link EdgeCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeCacheKeyBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeCacheKeyBuilder.<init>()", "EdgeCacheKey EdgeCacheKeyBuilder.build()",
      "EdgeCacheKeyBuilder EdgeCacheKeyBuilder.name(String)",
      "EdgeCacheKeyBuilder EdgeCacheKeyBuilder.tenantId(TenantId)", "String EdgeCacheKeyBuilder.toString()"})
  void testEdgeCacheKeyBuilderBuild() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EdgeCacheKey actualBuildResult = nameResult.tenantId(tenantId).build();

    // Assert
    assertEquals("Name", actualBuildResult.getName());
    assertSame(tenantId, actualBuildResult.getTenantId());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder3);
    EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder4.name("Name");
    EdgeCacheKey buildResult2 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.name(Mockito.<String>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder.name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder2.name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult2 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKeyBuilder.class);
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    when(edgeCacheKeyBuilder.build()).thenReturn(buildResult);
    EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder2);
    EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder3.name("Name");
    EdgeCacheKey buildResult2 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder edgeCacheKeyBuilder5 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder5.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder4);
    EdgeCacheKeyBuilder nameResult3 = edgeCacheKeyBuilder5.name("Name");
    EdgeCacheKey buildResult3 = nameResult3
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeCacheKeyBuilder edgeCacheKeyBuilder = mock(EdgeCacheKeyBuilder.class);
    EdgeCacheKey buildResult = EdgeCacheKey.builder().name("Name").tenantId(null).build();
    when(edgeCacheKeyBuilder.build()).thenReturn(buildResult);
    EdgeCacheKeyBuilder edgeCacheKeyBuilder2 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(edgeCacheKeyBuilder);
    EdgeCacheKeyBuilder edgeCacheKeyBuilder3 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder2);
    EdgeCacheKeyBuilder nameResult = edgeCacheKeyBuilder3.name("Name");
    EdgeCacheKey buildResult2 = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    EdgeCacheKeyBuilder edgeCacheKeyBuilder4 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(EdgeCacheKey.builder());
    EdgeCacheKeyBuilder edgeCacheKeyBuilder5 = mock(EdgeCacheKeyBuilder.class);
    when(edgeCacheKeyBuilder5.name(Mockito.<String>any())).thenReturn(edgeCacheKeyBuilder4);
    EdgeCacheKeyBuilder nameResult2 = edgeCacheKeyBuilder5.name("Name");
    EdgeCacheKey buildResult3 = nameResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey buildResult = nameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EdgeCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheKey#EdgeCacheKey(TenantId, String)}
   *   <li>{@link EdgeCacheKey#toString()}
   *   <li>{@link EdgeCacheKey#getName()}
   *   <li>{@link EdgeCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeCacheKey.<init>(TenantId, String)", "String EdgeCacheKey.getName()",
      "TenantId EdgeCacheKey.getTenantId()", "String EdgeCacheKey.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EdgeCacheKey actualEdgeCacheKey = new EdgeCacheKey(tenantId, "Name");
    String actualToStringResult = actualEdgeCacheKey.toString();
    String actualName = actualEdgeCacheKey.getName();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_Name", actualToStringResult);
    assertEquals("Name", actualName);
    assertSame(tenantId, actualEdgeCacheKey.getTenantId());
  }
}
