package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
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
public class OtaPackageDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @MockBean
  private OtaPackageDao otaPackageDao;

  @Autowired
  private OtaPackageDataValidator otaPackageDataValidator;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>Then calls {@link OtaPackageInfo#getDataSize()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateCreateWithTenantIdOtaPackage_thenCallsGetDataSize() {
    // Arrange
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(new DefaultTenantProfileConfiguration());
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getDataSize()).thenReturn(3L);

    // Act
    otaPackageDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(otaPackage).getDataSize();
    verify(tenantProfile).getProfileData();
    verify(tenantProfileData).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getData()).thenThrow(new DataValidationException("An error occurred"));
    when(otaPackage.hasUrl()).thenReturn(true);
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getData();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage2() throws UnsupportedEncodingException {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(otaPackageService.generateChecksum(Mockito.<ChecksumAlgorithm>any(), Mockito.<ByteBuffer>any()))
        .thenReturn("Generate Checksum");
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getData();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(otaPackageService).generateChecksum(eq(ChecksumAlgorithm.MD5), isA(ByteBuffer.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage3() throws UnsupportedEncodingException {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(otaPackageService.generateChecksum(Mockito.<ChecksumAlgorithm>any(), Mockito.<ByteBuffer>any()))
        .thenReturn("Checksum");
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act
    otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(otaPackage).getData();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(otaPackageService).generateChecksum(eq(ChecksumAlgorithm.MD5), isA(ByteBuffer.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage4() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(null);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage5() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getContentType()).thenReturn(null);
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage_givenEmptyString() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getChecksum()).thenReturn("");
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getChecksum();
    verify(otaPackage).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage_givenTrue() throws UnsupportedEncodingException {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.hasUrl()).thenReturn(true);
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getData();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getChecksum()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage_whenOtaPackageGetChecksumReturnNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getChecksum()).thenReturn(null);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getChecksum();
    verify(otaPackage).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>When {@link OtaPackage} {@link OtaPackage#getData()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage_whenOtaPackageGetDataReturnNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getData()).thenReturn(null);
    when(otaPackage.hasUrl()).thenReturn(true);
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act
    otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(otaPackage).getData();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getFileName()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOtaPackage_whenOtaPackageGetFileNameReturnNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.hasUrl()).thenReturn(false);
    when(otaPackage.getFileName()).thenReturn(null);
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackage.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getTenantId();
    verify(otaPackage, atLeast(1)).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getVersion();
    verify(otaPackage).hasUrl();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)}
   * with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)}
   */
  @Test
  public void testValidateUpdateWithTenantIdOtaPackage_thenThrowDataValidationException() {
    // Arrange
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new OtaPackage()));
    verify(otaPackageDao).findById(isA(TenantId.class), isNull());
  }
}
