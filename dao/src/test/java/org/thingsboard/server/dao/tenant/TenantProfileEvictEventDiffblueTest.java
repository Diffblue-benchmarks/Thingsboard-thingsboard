package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantProfileEvictEventDiffblueTest {
  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and
   * {@link TenantProfileEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    int expectedHashCodeResult = tenantProfileEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and
   * {@link TenantProfileEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(
        new TenantProfileId(ModelConstants.NULL_UUID), true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 = new TenantProfileEvictEvent(
        new TenantProfileId(ModelConstants.NULL_UUID), true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    int expectedHashCodeResult = tenantProfileEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfileEvictEvent(mock(TenantProfileId.class), true), "42");
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(mock(TenantProfileId.class), false);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent,
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true));
  }
}
