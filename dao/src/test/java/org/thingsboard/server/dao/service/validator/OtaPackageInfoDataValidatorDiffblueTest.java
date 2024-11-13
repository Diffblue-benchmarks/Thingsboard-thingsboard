package org.thingsboard.server.dao.service.validator;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageInfoDao;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {OtaPackageInfoDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class OtaPackageInfoDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @MockBean
  private OtaPackageInfoDao otaPackageInfoDao;

  @Autowired
  private OtaPackageInfoDataValidator otaPackageInfoDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link OtaPackageInfoDataValidator#validateDataImpl(TenantId, OtaPackageInfo)}
   * with {@code TenantId}, {@code OtaPackageInfo}.
   * <ul>
   *   <li>Then calls {@link OtaPackageInfo#getDeviceProfileId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoDataValidator#validateDataImpl(TenantId, OtaPackageInfo)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackageInfo_thenCallsGetDeviceProfileId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getVersion()).thenReturn("1.0.2");
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(null);
    when(otaPackageInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act
    otaPackageInfoDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackageInfo);

    // Assert
    verify(otaPackageInfo).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getTitle();
    verify(otaPackageInfo).getType();
    verify(otaPackageInfo, atLeast(1)).getVersion();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
