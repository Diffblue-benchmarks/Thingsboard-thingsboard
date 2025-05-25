package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EdgeEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEntity#EdgeEntity()}
   *   <li>{@link EdgeEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeEntity.<init>()", "java.lang.String EdgeEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeEntity actualEdgeEntity = new EdgeEntity();

    // Assert
    assertEquals("EdgeEntity()", actualEdgeEntity.toString());
    assertNull(actualEdgeEntity.getAdditionalInfo());
    assertNull(actualEdgeEntity.getVersion());
    assertNull(actualEdgeEntity.getLabel());
    assertNull(actualEdgeEntity.getName());
    assertNull(actualEdgeEntity.getRoutingKey());
    assertNull(actualEdgeEntity.getSecret());
    assertNull(actualEdgeEntity.getType());
    assertNull(actualEdgeEntity.getId());
    assertNull(actualEdgeEntity.getUuid());
    assertNull(actualEdgeEntity.getCustomerId());
    assertNull(actualEdgeEntity.getRootRuleChainId());
    assertNull(actualEdgeEntity.getTenantId());
    assertEquals(0L, actualEdgeEntity.getCreatedTime());
  }
}
