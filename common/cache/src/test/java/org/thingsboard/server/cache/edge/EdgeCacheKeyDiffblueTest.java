package org.thingsboard.server.cache.edge;

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
import org.thingsboard.server.cache.edge.EdgeCacheKey.EdgeCacheKeyBuilder;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {EdgeCacheKeyBuilder.class})
@ExtendWith(SpringExtension.class)
class EdgeCacheKeyDiffblueTest {
  @Autowired private EdgeCacheKeyBuilder edgeCacheKeyBuilder;

  /**
   * Test EdgeCacheKeyBuilder {@link EdgeCacheKeyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKeyBuilder#build()}
   *   <li>{@link EdgeCacheKeyBuilder#name(String)}
   *   <li>{@link EdgeCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeCacheKeyBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCacheKeyBuilder.<init>()",
    "EdgeCacheKey EdgeCacheKeyBuilder.build()",
    "EdgeCacheKeyBuilder EdgeCacheKeyBuilder.name(String)",
    "EdgeCacheKeyBuilder EdgeCacheKeyBuilder.tenantId(TenantId)",
    "String EdgeCacheKeyBuilder.toString()"
  })
  void testEdgeCacheKeyBuilderBuild() {
    // Arrange and Act
    EdgeCacheKeyBuilder actualNameResult = EdgeCacheKey.builder().name("Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeCacheKey actualEdgeCacheKey = actualNameResult.tenantId(tenantId).build();

    // Assert
    assertEquals("Name", actualEdgeCacheKey.getName());
    assertSame(tenantId, actualEdgeCacheKey.getTenantId());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey edgeCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey edgeCacheKey2 =
        nameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(edgeCacheKey, edgeCacheKey2);
    assertEquals(edgeCacheKey.hashCode(), edgeCacheKey2.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCacheKey edgeCacheKey = EdgeCacheKey.builder().name("Name").tenantId(null).build();
    EdgeCacheKey edgeCacheKey2 = EdgeCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertEquals(edgeCacheKey, edgeCacheKey2);
    assertEquals(edgeCacheKey.hashCode(), edgeCacheKey2.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name(null);
    EdgeCacheKey edgeCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name(null);
    EdgeCacheKey edgeCacheKey2 =
        nameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(edgeCacheKey, edgeCacheKey2);
    assertEquals(edgeCacheKey.hashCode(), edgeCacheKey2.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}, and {@link EdgeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKey#equals(Object)}
   *   <li>{@link EdgeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey edgeCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(edgeCacheKey, edgeCacheKey);
    int expectedHashCodeResult = edgeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheKey.hashCode());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");
    EdgeCacheKey edgeCacheKey = nameResult.tenantId(new TenantId(UUID.randomUUID())).build();

    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheKey,
        nameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheKey edgeCacheKey = EdgeCacheKey.builder().name("Name").tenantId(null).build();

    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheKey,
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name(null);
    EdgeCacheKey edgeCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheKey,
        nameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("42");
    EdgeCacheKey edgeCacheKey =
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    EdgeCacheKeyBuilder nameResult2 = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheKey,
        nameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build(),
        null);
  }

  /**
   * Test {@link EdgeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCacheKey.equals(Object)", "int EdgeCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeCacheKeyBuilder nameResult = EdgeCacheKey.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build(),
        "Different type to EdgeCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheKey#EdgeCacheKey(TenantId, String)}
   *   <li>{@link EdgeCacheKey#toString()}
   *   <li>{@link EdgeCacheKey#getName()}
   *   <li>{@link EdgeCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCacheKey.<init>(TenantId, String)",
    "String EdgeCacheKey.getName()",
    "TenantId EdgeCacheKey.getTenantId()",
    "String EdgeCacheKey.toString()"
  })
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
