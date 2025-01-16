package org.thingsboard.server.dao.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.dao.model.ModelConstants;

public class OtaPackageCacheEvictEventDiffblueTest {
  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and
   * {@link OtaPackageCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
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
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and
   * {@link OtaPackageCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(
        new OtaPackageId(ModelConstants.NULL_UUID));
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent2 = new OtaPackageCacheEvictEvent(
        new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertEquals(otaPackageCacheEvictEvent, otaPackageCacheEvictEvent2);
    int expectedHashCodeResult = otaPackageCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(mock(OtaPackageId.class));

    // Act and Assert
    assertNotEquals(otaPackageCacheEvictEvent, new OtaPackageCacheEvictEvent(null));
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageCacheEvictEvent(mock(OtaPackageId.class)), "42");
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(null);

    // Act and Assert
    assertNotEquals(otaPackageCacheEvictEvent,
        new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID)));
  }
}
