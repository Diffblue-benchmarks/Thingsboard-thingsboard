package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileInfo;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.validator.DeviceProfileDataValidator;

@ExtendWith(MockitoExtension.class)
class DeviceProfileServiceImplDiffblueTest {
  @Mock private DeviceProfileDao deviceProfileDao;

  @Mock private DeviceProfileDataValidator deviceProfileDataValidator;

  @InjectMocks private DeviceProfileServiceImpl deviceProfileServiceImpl;

  @Mock private ImageService imageService;

  /**
   * Test {@link DeviceProfileServiceImpl#handleEvictEvent(DeviceProfileEvictEvent)} with {@code
   * DeviceProfileEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProfileServiceImpl#handleEvictEvent(DeviceProfileEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(DeviceProfileEvictEvent) with 'DeviceProfileEvictEvent'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.handleEvictEvent(DeviceProfileEvictEvent)"})
  void testHandleEvictEventWithDeviceProfileEvictEvent_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceProfileEvictEvent event = mock(DeviceProfileEvictEvent.class);
    when(event.getNewName()).thenReturn("New Name");
    when(event.getSavedDeviceProfile()).thenReturn(deviceProfile);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceProfileServiceImpl.handleEvictEvent(event));
    verify(deviceProfile).getId();
    verify(event).getNewName();
    verify(event, atLeast(1)).getSavedDeviceProfile();
    verify(event).getTenantId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId, DeviceProfileId)} with
   * {@code tenantId}, {@code deviceProfileId}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileById(TenantId, DeviceProfileId) with 'tenantId', 'deviceProfileId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.findDeviceProfileById(TenantId, DeviceProfileId)"
  })
  void testFindDeviceProfileByIdWithTenantIdDeviceProfileId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileById(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId, DeviceProfileId, boolean)}
   * with {@code tenantId}, {@code deviceProfileId}, {@code putInCache}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId,
   * DeviceProfileId, boolean)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileById(TenantId, DeviceProfileId, boolean) with 'tenantId', 'deviceProfileId', 'putInCache'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.findDeviceProfileById(TenantId, DeviceProfileId, boolean)"
  })
  void testFindDeviceProfileByIdWithTenantIdDeviceProfileIdPutInCache() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileById(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, true));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfoById(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfoById(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileInfoById(TenantId, DeviceProfileId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo DeviceProfileServiceImpl.findDeviceProfileInfoById(TenantId, DeviceProfileId)"
  })
  void testFindDeviceProfileInfoById_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfoById(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with {@code
   * deviceProfile}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test saveDeviceProfile(DeviceProfile) with 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfileWithDeviceProfile() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    when(provisionConfiguration.getProvisionDeviceSecret())
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(provisionConfiguration).getProvisionDeviceSecret();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with {@code
   * deviceProfile}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test saveDeviceProfile(DeviceProfile) with 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfileWithDeviceProfile2() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(provisionConfiguration)
        .setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("Provision Device Secret");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("Provision Device Secret");
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with {@code
   * deviceProfile}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test saveDeviceProfile(DeviceProfile) with 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfileWithDeviceProfile3() {
    // Arrange
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(new DeviceProfile()));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    when(provisionConfiguration.getProvisionDeviceSecret())
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(provisionConfiguration).getProvisionDeviceSecret();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent2() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(provisionConfiguration)
        .setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("Provision Device Secret");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("Provision Device Secret");
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent3() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doNothing().when(provisionConfiguration).setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("");
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent4() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doNothing().when(provisionConfiguration).setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("Provision Device Secret");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    doNothing().when(deviceProfile).setProfileData(Mockito.<DeviceProfileData>any());
    doNothing().when(deviceProfile).setProvisionDeviceKey(Mockito.<String>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, false, true));
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfile)
        .setProvisionDeviceKey("8ad26c004d923aad3801c59d223b8f4ce0f0d7a8b37a40561a47924758130877");
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("Provision Device Secret");
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent5() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doNothing().when(provisionConfiguration).setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret())
        .thenReturn("-----BEGIN CERTIFICATE-----\\s*.*?\\s*-----END CERTIFICATE-----");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(deviceProfileId);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(deviceProfile).setProfileData(Mockito.<DeviceProfileData>any());
    doNothing().when(deviceProfile).setProvisionDeviceKey(Mockito.<String>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, false, true));
    verify(deviceProfile, atLeast(1)).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).getTenantId();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfile)
        .setProvisionDeviceKey("15877861e70a277483c3a2cc87343a16a724a234068fe207a0138cc4da58d91d");
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("\\s*.*?\\s*");
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent6() {
    // Arrange
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(new DeviceProfile(), true, true));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent7() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceProfile>any()))
        .thenReturn(deviceProfile);

    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenReturn(deviceProfile2);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(new DeviceProfile(), true, true));
    verify(deviceProfile2).getName();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).saveAndFlush(isNull(), isA(DeviceProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("device profile"));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile, boolean, boolean) with 'deviceProfile', 'doValidate', 'publishSaveEvent'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doNothing().when(provisionConfiguration).setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("Provision Device Secret");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(deviceProfileId);
    when(deviceProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(deviceProfile).setProfileData(Mockito.<DeviceProfileData>any());
    doNothing().when(deviceProfile).setProvisionDeviceKey(Mockito.<String>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, false, true));
    verify(deviceProfile, atLeast(1)).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).getTenantId();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfile)
        .setProvisionDeviceKey("8ad26c004d923aad3801c59d223b8f4ce0f0d7a8b37a40561a47924758130877");
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("Provision Device Secret");
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with {@code
   * deviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile) with 'deviceProfile'; then calls setProfileData(DeviceProfileData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfileWithDeviceProfile_thenCallsSetProfileData() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration provisionConfiguration =
        mock(X509CertificateChainProvisionConfiguration.class);
    doNothing().when(provisionConfiguration).setProvisionDeviceSecret(Mockito.<String>any());
    when(provisionConfiguration.getProvisionDeviceSecret()).thenReturn("");

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(provisionConfiguration);
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(provisionConfiguration, atLeast(1)).getProvisionDeviceSecret();
    verify(provisionConfiguration).setProvisionDeviceSecret("");
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with {@code
   * deviceProfile}.
   *
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.
   *   <li>Then calls {@link DeviceProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceProfile(DeviceProfile) with 'deviceProfile'; when DeviceProfile(); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfileWithDeviceProfile_whenDeviceProfile_thenCallsGetName() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceProfile>any()))
        .thenReturn(deviceProfile);

    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenReturn(deviceProfile2);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(new DeviceProfile()));
    verify(deviceProfile2).getName();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).saveAndFlush(isNull(), isA(DeviceProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("device profile"));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(TenantId, DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(TenantId, DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(TenantId, DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile3() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(false);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).getId();
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteDeviceProfile(TenantId, DeviceProfileId); given DeviceProfileDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile_givenDeviceProfileDaoFindByIdReturnNull() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    deviceProfileServiceImpl.deleteDeviceProfile(
        ModelConstants.SYSTEM_TENANT,
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#isDefault()} return {@code true}.
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteDeviceProfile(TenantId, DeviceProfileId); given DeviceProfile isDefault() return 'true'; then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile_givenDeviceProfileIsDefaultReturnTrue_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link DeviceProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteDeviceProfile(TenantId, DeviceProfileId); given DeviceProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile_givenDeviceProfileServiceImpl_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(TenantId, DeviceProfileId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testDeleteDeviceProfile_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.isDefault()).thenReturn(false);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity3() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   *   <li>Then calls {@link DeviceProfileDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given DeviceProfileDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenDeviceProfileDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    deviceProfileServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, false));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles2() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles3() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles4() {
    // Arrange
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfiles(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles_givenBy_created_time_desc() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceProfiles(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles_thenCallsGetProperty() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfiles(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  void testFindDeviceProfiles_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos2() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos3() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos4() {
    // Arrange
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT,
                BaseRelatedEdgesService.FIRST_PAGE,
                "Transport Type"));
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileInfos(TenantId, PageLink, String); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos_givenBy_created_time_desc() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                tenantId, mock(PageLink.class), "Transport Type"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findDeviceProfileInfos(TenantId, PageLink, String); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos_thenCallsGetProperty() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileInfos(TenantId, PageLink, String); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  void testFindDeviceProfileInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE, "Transport Type");

    // Assert
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}
   */
  @Test
  @DisplayName("Test createDefaultDeviceProfile(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.createDefaultDeviceProfile(TenantId)"})
  void testCreateDefaultDeviceProfile() {
    // Arrange
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.createDefaultDeviceProfile(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}
   */
  @Test
  @DisplayName(
      "Test createDefaultDeviceProfile(TenantId); given DeviceProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.createDefaultDeviceProfile(TenantId)"})
  void testCreateDefaultDeviceProfile_givenDeviceProfileServiceImpl_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.createDefaultDeviceProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}
   */
  @Test
  @DisplayName("Test createDefaultDeviceProfile(TenantId); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.createDefaultDeviceProfile(TenantId)"})
  void testCreateDefaultDeviceProfile_thenCallsGetName() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceProfile>any()))
        .thenReturn(deviceProfile);

    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDataValidator.validate(
            Mockito.<DeviceProfile>any(), Mockito.<Function<DeviceProfile, TenantId>>any()))
        .thenReturn(deviceProfile2);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.createDefaultDeviceProfile(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile2).getName();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).saveAndFlush(isA(TenantId.class), isA(DeviceProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("device profile"));
    verify(deviceProfileDataValidator).validate(isA(DeviceProfile.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDefaultDeviceProfile(TenantId)}
   */
  @Test
  @DisplayName("Test findDefaultDeviceProfile(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.findDefaultDeviceProfile(TenantId)"})
  void testFindDefaultDeviceProfile_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDefaultDeviceProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDefaultDeviceProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDefaultDeviceProfileInfo(TenantId)}
   */
  @Test
  @DisplayName("Test findDefaultDeviceProfileInfo(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo DeviceProfileServiceImpl.findDefaultDeviceProfileInfo(TenantId)"
  })
  void testFindDefaultDeviceProfileInfo_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDefaultDeviceProfileInfo(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} Default is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDeviceProfile(TenantId, DeviceProfileId); given DeviceProfile() Default is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testSetDefaultDeviceProfile_givenDeviceProfileDefaultIsTrue_thenReturnFalse() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act
    boolean actualSetDefaultDeviceProfileResult =
        deviceProfileServiceImpl.setDefaultDeviceProfile(
            null, new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfileDao).findById(isNull(), isA(UUID.class));
    assertFalse(actualSetDefaultDeviceProfileResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link DeviceProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDeviceProfile(TenantId, DeviceProfileId); given DeviceProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testSetDefaultDeviceProfile_givenDeviceProfileServiceImpl_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.setDefaultDeviceProfile(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(TenantId, DeviceProfileId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testSetDefaultDeviceProfile_thenCallsGetId() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.setDefaultDeviceProfile(
                tenantId,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tenantId).getId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(TenantId, DeviceProfileId); then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  void testSetDefaultDeviceProfile_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act
    boolean actualSetDefaultDeviceProfileResult =
        deviceProfileServiceImpl.setDefaultDeviceProfile(
            ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultDeviceProfileResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfilesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  void testDeleteDeviceProfilesByTenantId() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfilesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  void testDeleteDeviceProfilesByTenantId2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteDeviceProfilesByTenantId(TenantId); given DeviceProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  void testDeleteDeviceProfilesByTenantId_givenDeviceProfileServiceImpl_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfilesByTenantId(TenantId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  void testDeleteDeviceProfilesByTenantId_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);
    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findDeviceProfiles(TenantId,
   *       PageLink)} return emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given DeviceProfileDao findDeviceProfiles(TenantId, PageLink) return emptyPageData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenDeviceProfileDaoFindDeviceProfilesReturnEmptyPageData() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given DeviceProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenDeviceProfileServiceImpl_thenCallsGetId() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceProfileServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);
    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DeviceProfileServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE, new DeviceProfileServiceImpl().getEntityType());
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileNamesByTenantId(TenantId, boolean); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DeviceProfileServiceImpl.findDeviceProfileNamesByTenantId(TenantId, boolean)"
  })
  void testFindDeviceProfileNamesByTenantId_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfileNamesByTenantId(tenantId, true));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}
   */
  @Test
  @DisplayName(
      "Test findDeviceProfileNamesByTenantId(TenantId, boolean); when SYSTEM_TENANT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DeviceProfileServiceImpl.findDeviceProfileNamesByTenantId(TenantId, boolean)"
  })
  void testFindDeviceProfileNamesByTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(deviceProfileDao.findTenantDeviceProfileNames(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindDeviceProfileNamesByTenantIdResult =
        deviceProfileServiceImpl.findDeviceProfileNamesByTenantId(
            ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(deviceProfileDao).findTenantDeviceProfileNames(isA(UUID.class), eq(true));
    assertTrue(actualFindDeviceProfileNamesByTenantIdResult.isEmpty());
  }
}
