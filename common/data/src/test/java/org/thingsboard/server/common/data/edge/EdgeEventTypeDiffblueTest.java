package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EdgeEventTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventType#getEntityType()}
   *   <li>{@link EdgeEventType#isAllEdgesRelated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EdgeEventType valueOfResult = EdgeEventType.valueOf("DASHBOARD");

    // Act
    EntityType actualEntityType = valueOfResult.getEntityType();

    // Assert
    assertEquals(EntityType.DASHBOARD, actualEntityType);
    assertFalse(valueOfResult.isAllEdgesRelated());
  }
}
