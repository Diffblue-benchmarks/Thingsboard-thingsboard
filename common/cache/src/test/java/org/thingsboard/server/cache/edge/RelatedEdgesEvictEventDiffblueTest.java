package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;

class RelatedEdgesEvictEventDiffblueTest {
  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent = new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), mock(AlarmId.class)), "42");
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent = new RelatedEdgesEvictEvent(null, mock(AlarmId.class));

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null));
  }
}
