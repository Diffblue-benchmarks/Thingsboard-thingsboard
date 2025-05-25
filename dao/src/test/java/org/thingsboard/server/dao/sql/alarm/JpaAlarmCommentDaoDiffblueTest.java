package org.thingsboard.server.dao.sql.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.AlarmCommentEntity;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

public class JpaAlarmCommentDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAlarmCommentDao#getEntityClass()}
   *   <li>{@link JpaAlarmCommentDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAlarmCommentDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAlarmCommentDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmCommentDao jpaAlarmCommentDao = new JpaAlarmCommentDao(mock(SqlPartitioningRepository.class));

    // Act
    Class<AlarmCommentEntity> actualEntityClass = jpaAlarmCommentDao.getEntityClass();

    // Assert
    assertNull(jpaAlarmCommentDao.getRepository());
    Class<AlarmCommentEntity> expectedEntityClass = AlarmCommentEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
