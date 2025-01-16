package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageDao;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {OtaPackageDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseOtaPackageDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private BaseOtaPackageDataValidator<OtaPackage> baseOtaPackageDataValidator;

  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @MockBean
  private OtaPackageDao otaPackageDao;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@code 1.0.2}.</li>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getVersion()} return
   * {@code 1.0.2}.</li>
   *   <li>Then calls {@link OtaPackageInfo#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_given102_whenOtaPackageGetVersionReturn102_thenCallsGetType() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getVersion()).thenReturn("1.0.2");
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(null);
    when(otaPackageInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act
    baseOtaPackageDataValidator.validateImpl(otaPackageInfo);

    // Assert
    verify(otaPackageInfo).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getTitle();
    verify(otaPackageInfo).getType();
    verify(otaPackageInfo, atLeast(1)).getVersion();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link Dao#findById(TenantId, UUID)}
   * return {@code null}.</li>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_givenDeviceProfileDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(otaPackageInfo, atLeast(1)).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo).getTitle();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getVersion()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_givenEmptyString_whenOtaPackageGetVersionReturnEmptyString() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getVersion()).thenReturn("");
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(null);
    when(otaPackageInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(otaPackageInfo).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo).getTitle();
    verify(otaPackageInfo).getType();
    verify(otaPackageInfo).getVersion();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getVersion()} return
   * {@code null}.</li>
   *   <li>Then calls {@link OtaPackageInfo#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_givenNull_whenOtaPackageGetVersionReturnNull_thenCallsGetType() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getVersion()).thenReturn(null);
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(null);
    when(otaPackageInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(otaPackageInfo).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo).getTitle();
    verify(otaPackageInfo).getType();
    verify(otaPackageInfo).getVersion();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@link TenantService}.</li>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_givenTenantService_whenOtaPackageInfoTitleIsDr() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   * <ul>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  public void testValidateImpl_thenCallsFindById() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new DeviceProfile());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getVersion()).thenReturn("1.0.2");
    when(otaPackageInfo.getDeviceProfileId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(otaPackageInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getTitle()).thenReturn("Dr");

    // Act
    baseOtaPackageDataValidator.validateImpl(otaPackageInfo);

    // Assert
    verify(otaPackageInfo, atLeast(1)).getDeviceProfileId();
    verify(otaPackageInfo, atLeast(1)).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getTitle();
    verify(otaPackageInfo).getType();
    verify(otaPackageInfo, atLeast(1)).getVersion();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   * with {@code otaPackage}, {@code otaPackageOld}.
   * <ul>
   *   <li>Given {@code SOFTWARE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   */
  @Test
  public void testValidateUpdateWithOtaPackageOtaPackageOld_givenSoftware() {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getType()).thenReturn(OtaPackageType.SOFTWARE);
    OtaPackage otaPackageOld = mock(OtaPackage.class);
    when(otaPackageOld.getType()).thenReturn(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
    verify(otaPackage).getType();
    verify(otaPackageOld).getType();
  }

  /**
   * Test
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   * with {@code otaPackage}, {@code otaPackageOld}.
   * <ul>
   *   <li>Then calls {@link OtaPackageInfo#getVersion()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   */
  @Test
  public void testValidateUpdateWithOtaPackageOtaPackageOld_thenCallsGetVersion() {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getVersion()).thenReturn("Dr");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    OtaPackage otaPackageOld = mock(OtaPackage.class);
    when(otaPackageOld.getVersion()).thenReturn("1.0.2");
    when(otaPackageOld.getTitle()).thenReturn("Dr");
    when(otaPackageOld.getType()).thenReturn(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
    verify(otaPackage).getTitle();
    verify(otaPackageOld).getTitle();
    verify(otaPackage).getType();
    verify(otaPackageOld).getType();
    verify(otaPackage).getVersion();
    verify(otaPackageOld).getVersion();
  }

  /**
   * Test
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   * with {@code otaPackage}, {@code otaPackageOld}.
   * <ul>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getTitle()} return
   * {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)}
   */
  @Test
  public void testValidateUpdateWithOtaPackageOtaPackageOld_whenOtaPackageGetTitleReturn102() {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getTitle()).thenReturn("1.0.2");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    OtaPackage otaPackageOld = mock(OtaPackage.class);
    when(otaPackageOld.getTitle()).thenReturn("Dr");
    when(otaPackageOld.getType()).thenReturn(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
    verify(otaPackage).getTitle();
    verify(otaPackageOld).getTitle();
    verify(otaPackage).getType();
    verify(otaPackageOld).getType();
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}.
   * <p>
   * Method under test: {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}
   */
  @Test
  public void testGetDeviceProfileDao() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OtaPackageDataValidator()).getDeviceProfileDao());
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getTenantService()}.
   * <p>
   * Method under test: {@link BaseOtaPackageDataValidator#getTenantService()}
   */
  @Test
  public void testGetTenantService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OtaPackageDataValidator()).getTenantService());
  }
}
