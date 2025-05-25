package org.thingsboard.server.dao.sql.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.WidgetsBundleEntity;

public class JpaWidgetsBundleDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaWidgetsBundleDao#getEntityClass()}
   *   <li>{@link JpaWidgetsBundleDao#getEntityType()}
   *   <li>{@link JpaWidgetsBundleDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaWidgetsBundleDao.getEntityClass()", "EntityType JpaWidgetsBundleDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaWidgetsBundleDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaWidgetsBundleDao jpaWidgetsBundleDao = new JpaWidgetsBundleDao();

    // Act
    Class<WidgetsBundleEntity> actualEntityClass = jpaWidgetsBundleDao.getEntityClass();
    EntityType actualEntityType = jpaWidgetsBundleDao.getEntityType();

    // Assert
    assertNull(jpaWidgetsBundleDao.getRepository());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEntityType);
    Class<WidgetsBundleEntity> expectedEntityClass = WidgetsBundleEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
