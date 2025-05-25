package org.thingsboard.server.dao.sql.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.EdgeEntity;

public class JpaEdgeDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaEdgeDao#getEntityClass()}
   *   <li>{@link JpaEdgeDao#getEntityType()}
   *   <li>{@link JpaEdgeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaEdgeDao.getEntityClass()", "EntityType JpaEdgeDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaEdgeDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaEdgeDao jpaEdgeDao = new JpaEdgeDao();

    // Act
    Class<EdgeEntity> actualEntityClass = jpaEdgeDao.getEntityClass();
    EntityType actualEntityType = jpaEdgeDao.getEntityType();

    // Assert
    assertNull(jpaEdgeDao.getRepository());
    assertEquals(EntityType.EDGE, actualEntityType);
    Class<EdgeEntity> expectedEntityClass = EdgeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
