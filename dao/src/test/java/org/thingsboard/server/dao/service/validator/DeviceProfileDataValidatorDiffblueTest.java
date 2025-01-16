package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.DeviceDao;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DeviceProfileDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class DeviceProfileDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private DashboardService dashboardService;

  @MockBean
  private DeviceDao deviceDao;

  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @Autowired
  private DeviceProfileDataValidator deviceProfileDataValidator;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private QueueService queueService;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile() {
    // Arrange
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    doNothing().when(transportConfiguration).validate();

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getDefaultRuleChainId())
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(deviceProfile.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile.getProvisionType()).thenReturn(DeviceProfileProvisionType.DISABLED);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile, atLeast(1)).getDefaultQueueName();
    verify(deviceProfile).getDefaultRuleChainId();
    verify(deviceProfile).getName();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).getProvisionDeviceKey();
    verify(deviceProfile, atLeast(1)).getProvisionType();
    verify(deviceProfile, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile).isDefault();
    verify(transportConfiguration).validate();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile2() {
    // Arrange
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    doThrow(new DataValidationException("An error occurred")).when(transportConfiguration).validate();

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(deviceProfile.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile.getProvisionType()).thenReturn(DeviceProfileProvisionType.DISABLED);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile, atLeast(1)).getDefaultQueueName();
    verify(deviceProfile).getName();
    verify(deviceProfile).getProfileData();
    verify(deviceProfile).getProvisionDeviceKey();
    verify(deviceProfile, atLeast(1)).getProvisionType();
    verify(deviceProfile, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile).isDefault();
    verify(transportConfiguration).validate();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getName();
    verify(deviceProfile, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile4() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenReturn(null);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getName();
    verify(deviceProfile).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile5() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(null);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getName();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code Device profile name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile_givenDeviceProfileName() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("Device profile name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile_givenFalse() {
    // Arrange
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    doNothing().when(transportConfiguration).validate();

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getDefaultRuleChainId())
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceProfile.isDefault()).thenReturn(false);
    when(deviceProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(deviceProfile.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile.getProvisionType()).thenReturn(DeviceProfileProvisionType.DISABLED);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile, atLeast(1)).getDefaultQueueName();
    verify(deviceProfile).getDefaultRuleChainId();
    verify(deviceProfile).getName();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).getProvisionDeviceKey();
    verify(deviceProfile, atLeast(1)).getProvisionType();
    verify(deviceProfile, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile).isDefault();
    verify(transportConfiguration).validate();
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile_thenCallsGetId() {
    // Arrange
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(new DeviceProfile());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getName();
    verify(deviceProfile, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile).isDefault();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceProfile_thenCallsGetId2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(deviceProfile);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile2.isDefault()).thenReturn(true);
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceProfile2));
    verify(deviceProfile).getId();
    verify(deviceProfile2).getName();
    verify(deviceProfile2, atLeast(1)).getTenantId();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile2).getType();
    verify(deviceProfile2).isDefault();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new DeviceProfile());
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getType()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfile).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile2() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile3() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProvisionType()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile2.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2));
    verify(deviceProfile2).getId();
    verify(deviceProfile2).getProvisionDeviceKey();
    verify(deviceProfile2).getProvisionType();
    verify(deviceProfile2).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile4() {
    // Arrange
    when(deviceDao.countDevicesByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(1L);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.MQTT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2));
    verify(deviceProfile2, atLeast(1)).getId();
    verify(deviceProfile2, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceDao).countDevicesByDeviceProfileId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile5() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProvisionDeviceKey()).thenReturn(null);
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2);

    // Assert
    verify(deviceProfile2).getId();
    verify(deviceProfile2).getProvisionDeviceKey();
    verify(deviceProfile2).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile6() {
    // Arrange
    when(deviceDao.countDevicesByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(0L);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.MQTT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProvisionType()).thenReturn(DeviceProfileProvisionType.DISABLED);
    when(deviceProfile2.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2);

    // Assert
    verify(deviceProfile2, atLeast(1)).getId();
    verify(deviceProfile2).getProvisionDeviceKey();
    verify(deviceProfile2).getProvisionType();
    verify(deviceProfile2, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceDao).countDevicesByDeviceProfileId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile_givenX509CertificateChain() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProvisionType()).thenReturn(DeviceProfileProvisionType.X509_CERTIFICATE_CHAIN);
    when(deviceProfile2.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2);

    // Assert
    verify(deviceProfile2).getId();
    verify(deviceProfile2, atLeast(1)).getProvisionDeviceKey();
    verify(deviceProfile2).getProvisionType();
    verify(deviceProfile2).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getProvisionType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile_thenCallsGetProvisionType() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProvisionType()).thenReturn(DeviceProfileProvisionType.DISABLED);
    when(deviceProfile2.getProvisionDeviceKey()).thenReturn("Provision Device Key");
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2);

    // Assert
    verify(deviceProfile2).getId();
    verify(deviceProfile2).getProvisionDeviceKey();
    verify(deviceProfile2).getProvisionType();
    verify(deviceProfile2).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   * with {@code TenantId}, {@code DeviceProfile}.
   * <ul>
   *   <li>When {@link DeviceProfile} {@link DeviceProfile#getType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileDataValidator#validateUpdate(TenantId, DeviceProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceProfile_whenDeviceProfileGetTypeReturnNull() {
    // Arrange
    when(deviceDao.countDevicesByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(1L);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile.getType()).thenReturn(DeviceProfileType.DEFAULT);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(deviceProfile2.getType()).thenReturn(null);
    when(deviceProfile2.getId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(deviceProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, deviceProfile2));
    verify(deviceProfile2, atLeast(1)).getId();
    verify(deviceProfile2, atLeast(1)).getTenantId();
    verify(deviceProfile).getTransportType();
    verify(deviceProfile2).getTransportType();
    verify(deviceProfile).getType();
    verify(deviceProfile2).getType();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceDao).countDevicesByDeviceProfileId(isA(TenantId.class), isA(UUID.class));
  }
}
