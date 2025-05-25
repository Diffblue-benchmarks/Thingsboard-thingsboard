package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCacheEvictEventDiffblueTest {
  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name",
        "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Old Name", "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "New Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", null);

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeCacheEvictEvent(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        "New Name", "Old Name"), null);
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeCacheEvictEvent.equals(Object)", "int EdgeCacheEvictEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeCacheEvictEvent(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        "New Name", "Old Name"), "Different type to EdgeCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#EdgeCacheEvictEvent(TenantId, String, String)}
   *   <li>{@link EdgeCacheEvictEvent#toString()}
   *   <li>{@link EdgeCacheEvictEvent#getNewName()}
   *   <li>{@link EdgeCacheEvictEvent#getOldName()}
   *   <li>{@link EdgeCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeCacheEvictEvent.<init>(TenantId, String, String)",
      "String EdgeCacheEvictEvent.getNewName()", "String EdgeCacheEvictEvent.getOldName()",
      "TenantId EdgeCacheEvictEvent.getTenantId()", "String EdgeCacheEvictEvent.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EdgeCacheEvictEvent actualEdgeCacheEvictEvent = new EdgeCacheEvictEvent(tenantId, "New Name", "Old Name");
    String actualToStringResult = actualEdgeCacheEvictEvent.toString();
    String actualNewName = actualEdgeCacheEvictEvent.getNewName();
    String actualOldName = actualEdgeCacheEvictEvent.getOldName();

    // Assert
    assertEquals(
        "EdgeCacheEvictEvent(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, newName=New Name, oldName=Old" + " Name)",
        actualToStringResult);
    assertEquals("New Name", actualNewName);
    assertEquals("Old Name", actualOldName);
    assertSame(tenantId, actualEdgeCacheEvictEvent.getTenantId());
  }
}
