package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultEdgeSynchronizationManagerDiffblueTest {
  /**
   * Test {@link DefaultEdgeSynchronizationManager#getEdgeId()}.
   *
   * <p>Method under test: {@link DefaultEdgeSynchronizationManager#getEdgeId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.ThreadLocal DefaultEdgeSynchronizationManager.getEdgeId()"})
  public void testGetEdgeId() {
    // Arrange, Act and Assert
    assertNull(new DefaultEdgeSynchronizationManager().getEdgeId().get());
  }
}
