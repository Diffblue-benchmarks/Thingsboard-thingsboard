package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class ToEdgeSyncRequestDiffblueTest {
  /**
   * Test {@link ToEdgeSyncRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToEdgeSyncRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    ToEdgeSyncRequest toEdgeSyncRequest = new ToEdgeSyncRequest(id, new TenantId(UUID.randomUUID()), mock(EdgeId.class),
        "42");
    UUID id2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(toEdgeSyncRequest, new ToEdgeSyncRequest(id2, new TenantId(UUID.randomUUID()), null, "42"));
  }

  /**
   * Test {@link ToEdgeSyncRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToEdgeSyncRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(new ToEdgeSyncRequest(id, new TenantId(UUID.randomUUID()), mock(EdgeId.class), "42"), "42");
  }

  /**
   * Test {@link ToEdgeSyncRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToEdgeSyncRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToEdgeSyncRequest toEdgeSyncRequest = new ToEdgeSyncRequest(null, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), "42");
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(toEdgeSyncRequest, new ToEdgeSyncRequest(id, new TenantId(UUID.randomUUID()), null, "42"));
  }
}
