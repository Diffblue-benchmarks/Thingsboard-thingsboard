package org.thingsboard.server.dao.sql.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.AssetProfileEntity;

public class JpaAssetProfileDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAssetProfileDao#getEntityClass()}
   *   <li>{@link JpaAssetProfileDao#getEntityType()}
   *   <li>{@link JpaAssetProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAssetProfileDao.getEntityClass()", "EntityType JpaAssetProfileDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAssetProfileDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetProfileDao jpaAssetProfileDao = new JpaAssetProfileDao();

    // Act
    Class<AssetProfileEntity> actualEntityClass = jpaAssetProfileDao.getEntityClass();
    EntityType actualEntityType = jpaAssetProfileDao.getEntityType();

    // Assert
    assertNull(jpaAssetProfileDao.getRepository());
    assertEquals(EntityType.ASSET_PROFILE, actualEntityType);
    Class<AssetProfileEntity> expectedEntityClass = AssetProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
