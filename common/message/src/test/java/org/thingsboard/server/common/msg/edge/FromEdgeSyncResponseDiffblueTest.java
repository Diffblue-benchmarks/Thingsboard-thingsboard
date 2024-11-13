package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class FromEdgeSyncResponseDiffblueTest {
  /**
   * Test {@link FromEdgeSyncResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), true, "An error occurred");
    UUID id2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id2, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }

  /**
   * Test {@link FromEdgeSyncResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(
        new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()), mock(EdgeId.class), true, "An error occurred"),
        "42");
  }

  /**
   * Test {@link FromEdgeSyncResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(null, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), true, "An error occurred");
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }

  /**
   * Test {@link FromEdgeSyncResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID id = UUID.randomUUID();
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), false, "An error occurred");
    UUID id2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id2, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }
}
