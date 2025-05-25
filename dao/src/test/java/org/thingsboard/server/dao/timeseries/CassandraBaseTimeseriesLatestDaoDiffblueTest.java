package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class CassandraBaseTimeseriesLatestDaoDiffblueTest {
  @InjectMocks
  private CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao;

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CassandraBaseTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"})
  public void testFindAllKeysByDeviceProfileId_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null).isEmpty());
  }

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_whenArrayList() {
    // Arrange, Act and Assert
    assertTrue(cassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>())
        .isEmpty());
  }
}
