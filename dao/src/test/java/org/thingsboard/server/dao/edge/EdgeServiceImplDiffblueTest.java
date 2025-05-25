package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class EdgeServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeServiceImpl#getEntityType()}
   *   <li>{@link EdgeServiceImpl#isEdgesEnabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType EdgeServiceImpl.getEntityType()", "boolean EdgeServiceImpl.isEdgesEnabled()"})
  public void testGettersAndSetters() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act
    EntityType actualEntityType = edgeServiceImpl.getEntityType();

    // Assert
    assertEquals(EntityType.EDGE, actualEntityType);
    assertFalse(edgeServiceImpl.isEdgesEnabled());
  }
}
