package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class CassandraBaseTimeseriesLatestDaoDiffblueTest {
  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>When {@link DeviceProfileId}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_whenDeviceProfileId_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CassandraBaseTimeseriesLatestDao())
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, mock(DeviceProfileId.class))
        .isEmpty());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CassandraBaseTimeseriesLatestDao()).findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null)
        .isEmpty());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link AlarmId}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenAlarmId_whenArrayListAddAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao = new CassandraBaseTimeseriesLatestDao();

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(mock(AlarmId.class));

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds).isEmpty());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao = new CassandraBaseTimeseriesLatestDao();

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds).isEmpty());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao = new CassandraBaseTimeseriesLatestDao();

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds).isEmpty());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao = new CassandraBaseTimeseriesLatestDao();

    // Act and Assert
    assertTrue(cassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>())
        .isEmpty());
  }
}
