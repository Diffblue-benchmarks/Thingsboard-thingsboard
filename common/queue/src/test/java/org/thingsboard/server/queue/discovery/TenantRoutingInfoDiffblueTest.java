package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

class TenantRoutingInfoDiffblueTest {
  /**
   * Test {@link TenantRoutingInfo#equals(Object)}, and
   * {@link TenantRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantRoutingInfo#equals(Object)}
   *   <li>{@link TenantRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);
    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(null, null, true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    int expectedHashCodeResult = tenantRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, tenantRoutingInfo2.hashCode());
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(UUID.randomUUID()),
        mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantRoutingInfo(new TenantId(UUID.randomUUID()), mock(TenantProfileId.class), true), "42");
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(UUID.randomUUID()),
        mock(TenantProfileId.class), false);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, new TenantProfileId(UUID.randomUUID()), true));
  }
}
