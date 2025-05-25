package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.DeviceProfileEntity;

public class JpaDeviceProfileDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDeviceProfileDao#getEntityClass()}
   *   <li>{@link JpaDeviceProfileDao#getEntityType()}
   *   <li>{@link JpaDeviceProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaDeviceProfileDao.getEntityClass()", "EntityType JpaDeviceProfileDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaDeviceProfileDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceProfileDao jpaDeviceProfileDao = new JpaDeviceProfileDao();

    // Act
    Class<DeviceProfileEntity> actualEntityClass = jpaDeviceProfileDao.getEntityClass();
    EntityType actualEntityType = jpaDeviceProfileDao.getEntityType();

    // Assert
    assertNull(jpaDeviceProfileDao.getRepository());
    assertEquals(EntityType.DEVICE_PROFILE, actualEntityType);
    Class<DeviceProfileEntity> expectedEntityClass = DeviceProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
