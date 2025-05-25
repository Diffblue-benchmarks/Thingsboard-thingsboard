package org.thingsboard.server.dao.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;

public class ApiUsageStateServiceImplDiffblueTest {
  /**
   * Test {@link ApiUsageStateServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link ApiUsageStateServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType ApiUsageStateServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    // Act and Assert
    assertEquals(EntityType.API_USAGE_STATE, (new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService, tsService, new ApiUsageDataValidator())).getEntityType());
  }
}
