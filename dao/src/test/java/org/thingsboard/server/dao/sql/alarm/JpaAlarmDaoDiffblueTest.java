package org.thingsboard.server.dao.sql.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.AlarmEntity;

public class JpaAlarmDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAlarmDao#getEntityClass()}
   *   <li>{@link JpaAlarmDao#getEntityType()}
   *   <li>{@link JpaAlarmDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAlarmDao.getEntityClass()", "EntityType JpaAlarmDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAlarmDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    // Act
    Class<AlarmEntity> actualEntityClass = jpaAlarmDao.getEntityClass();
    EntityType actualEntityType = jpaAlarmDao.getEntityType();

    // Assert
    assertNull(jpaAlarmDao.getRepository());
    assertEquals(EntityType.ALARM, actualEntityType);
    Class<AlarmEntity> expectedEntityClass = AlarmEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
