package org.thingsboard.server.dao.sql.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.AdminSettingsEntity;

public class JpaAdminSettingsDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAdminSettingsDao#getEntityClass()}
   *   <li>{@link JpaAdminSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAdminSettingsDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAdminSettingsDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAdminSettingsDao jpaAdminSettingsDao = new JpaAdminSettingsDao();

    // Act
    Class<AdminSettingsEntity> actualEntityClass = jpaAdminSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaAdminSettingsDao.getRepository());
    Class<AdminSettingsEntity> expectedEntityClass = AdminSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
