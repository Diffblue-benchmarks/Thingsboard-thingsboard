package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.UserAuthSettingsEntity;

public class JpaUserAuthSettingsDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaUserAuthSettingsDao#getEntityClass()}
   *   <li>{@link JpaUserAuthSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaUserAuthSettingsDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaUserAuthSettingsDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaUserAuthSettingsDao jpaUserAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));

    // Act
    Class<UserAuthSettingsEntity> actualEntityClass = jpaUserAuthSettingsDao.getEntityClass();
    jpaUserAuthSettingsDao.getRepository();

    // Assert
    Class<UserAuthSettingsEntity> expectedEntityClass = UserAuthSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
