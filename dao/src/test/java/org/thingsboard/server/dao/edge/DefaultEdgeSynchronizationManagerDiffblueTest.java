package org.thingsboard.server.dao.edge;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultEdgeSynchronizationManagerDiffblueTest {
  /**
   * Test {@link DefaultEdgeSynchronizationManager#getEdgeId()}.
   *
   * <p>Method under test: {@link DefaultEdgeSynchronizationManager#getEdgeId()}
   */
  @Test
  @DisplayName("Test getEdgeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.ThreadLocal DefaultEdgeSynchronizationManager.getEdgeId()"})
  void testGetEdgeId() {
    // Arrange, Act and Assert
    assertNull(new DefaultEdgeSynchronizationManager().getEdgeId().get());
  }
}
