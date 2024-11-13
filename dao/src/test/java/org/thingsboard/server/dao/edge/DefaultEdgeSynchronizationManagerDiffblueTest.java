package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DefaultEdgeSynchronizationManagerDiffblueTest {
  /**
   * Test {@link DefaultEdgeSynchronizationManager#getEdgeId()}.
   * <p>
   * Method under test: {@link DefaultEdgeSynchronizationManager#getEdgeId()}
   */
  @Test
  public void testGetEdgeId() {
    // Arrange, Act and Assert
    assertNull((new DefaultEdgeSynchronizationManager()).getEdgeId().get());
  }
}
