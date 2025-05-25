package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.MobileAppSettingsEntity;

public class JpaMobileAppSettingsDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaMobileAppSettingsDao#getEntityClass()}
   *   <li>{@link JpaMobileAppSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaMobileAppSettingsDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaMobileAppSettingsDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppSettingsDao jpaMobileAppSettingsDao = new JpaMobileAppSettingsDao();

    // Act
    Class<MobileAppSettingsEntity> actualEntityClass = jpaMobileAppSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaMobileAppSettingsDao.getRepository());
    Class<MobileAppSettingsEntity> expectedEntityClass = MobileAppSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
