package org.thingsboard.server.dao.sql.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.OtaPackageInfoEntity;

public class JpaOtaPackageInfoDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOtaPackageInfoDao#getEntityClass()}
   *   <li>{@link JpaOtaPackageInfoDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaOtaPackageInfoDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaOtaPackageInfoDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaOtaPackageInfoDao jpaOtaPackageInfoDao = new JpaOtaPackageInfoDao();

    // Act
    Class<OtaPackageInfoEntity> actualEntityClass = jpaOtaPackageInfoDao.getEntityClass();

    // Assert
    assertNull(jpaOtaPackageInfoDao.getRepository());
    Class<OtaPackageInfoEntity> expectedEntityClass = OtaPackageInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
