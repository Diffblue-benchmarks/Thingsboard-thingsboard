package org.thingsboard.server.dao.sql.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;

public class JpaApiUsageStateDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaApiUsageStateDao#getEntityClass()}
   *   <li>{@link JpaApiUsageStateDao#getEntityType()}
   *   <li>{@link JpaApiUsageStateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaApiUsageStateDao.getEntityClass()", "EntityType JpaApiUsageStateDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaApiUsageStateDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaApiUsageStateDao jpaApiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));

    // Act
    Class<ApiUsageStateEntity> actualEntityClass = jpaApiUsageStateDao.getEntityClass();
    EntityType actualEntityType = jpaApiUsageStateDao.getEntityType();
    jpaApiUsageStateDao.getRepository();

    // Assert
    assertEquals(EntityType.API_USAGE_STATE, actualEntityType);
    Class<ApiUsageStateEntity> expectedEntityClass = ApiUsageStateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
