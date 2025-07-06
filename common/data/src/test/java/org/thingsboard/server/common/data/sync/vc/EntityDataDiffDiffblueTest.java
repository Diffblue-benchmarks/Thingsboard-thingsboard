package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;

class EntityDataDiffDiffblueTest {
  /**
   * Test {@link EntityDataDiff#equals(Object)}, and {@link EntityDataDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataDiff.equals(Object)", "int EntityDataDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(null, new EntityExportData<>());
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(null, new EntityExportData<>());

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff2.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}, and {@link EntityDataDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataDiff.equals(Object)", "int EntityDataDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(new EntityExportData<>(), null);
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(new EntityExportData<>(), null);

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff2.hashCode());
  }
}
