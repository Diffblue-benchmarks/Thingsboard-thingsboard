package org.thingsboard.server.dao.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.OtaPackageId;

public class OtaPackageCacheEvictEventDiffblueTest {
  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and {@link
   * OtaPackageCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(null);
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent2 = new OtaPackageCacheEvictEvent(null);

    // Act and Assert
    assertEquals(otaPackageCacheEvictEvent, otaPackageCacheEvictEvent2);
    int expectedHashCodeResult = otaPackageCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and {@link
   * OtaPackageCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent =
        new OtaPackageCacheEvictEvent(
            new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent2 =
        new OtaPackageCacheEvictEvent(
            new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(otaPackageCacheEvictEvent, otaPackageCacheEvictEvent2);
    int expectedHashCodeResult = otaPackageCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent =
        new OtaPackageCacheEvictEvent(
            new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(otaPackageCacheEvictEvent, new OtaPackageCacheEvictEvent(null));
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageCacheEvictEvent(null), 1);
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        otaPackageCacheEvictEvent,
        new OtaPackageCacheEvictEvent(
            new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
