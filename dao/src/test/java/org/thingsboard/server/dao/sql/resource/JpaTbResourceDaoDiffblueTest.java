package org.thingsboard.server.dao.sql.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.TbResourceEntity;

public class JpaTbResourceDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTbResourceDao#getEntityClass()}
   *   <li>{@link JpaTbResourceDao#getEntityType()}
   *   <li>{@link JpaTbResourceDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaTbResourceDao.getEntityClass()", "EntityType JpaTbResourceDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaTbResourceDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaTbResourceDao jpaTbResourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    // Act
    Class<TbResourceEntity> actualEntityClass = jpaTbResourceDao.getEntityClass();
    EntityType actualEntityType = jpaTbResourceDao.getEntityType();
    jpaTbResourceDao.getRepository();

    // Assert
    assertEquals(EntityType.TB_RESOURCE, actualEntityType);
    Class<TbResourceEntity> expectedEntityClass = TbResourceEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
