/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceProfileServiceImplDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.handleEvictEvent(DeviceProfileEvictEvent)"})
  public void testHandleEvictEventWithDeviceProfileEvictEvent_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    DeviceProfile savedDeviceProfile = mock(DeviceProfile.class);
    when(savedDeviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceProfileEvictEvent event =
        new DeviceProfileEvictEvent(
            ModelConstants.SYSTEM_TENANT,
            "New Name",
            "Old Name",
            null,
            true,
            "Provision Device Key");
    event.setSavedDeviceProfile(savedDeviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceProfileServiceImpl.handleEvictEvent(event));
    verify(savedDeviceProfile).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId, DeviceProfileId)} with
   * {@code tenantId}, {@code deviceProfileId}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileById(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.findDeviceProfileById(TenantId, DeviceProfileId)"
  })
  public void testFindDeviceProfileByIdWithTenantIdDeviceProfileId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.findDeviceProfileById(TenantId, DeviceProfileId, boolean)"
  })
  public void testFindDeviceProfileByIdWithTenantIdDeviceProfileIdPutInCache() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo DeviceProfileServiceImpl.findDeviceProfileInfoById(TenantId, DeviceProfileId)"
  })
  public void testFindDeviceProfileInfoById_thenThrowDataValidationException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  public void testSaveDeviceProfileWithDeviceProfile() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  public void testSaveDeviceProfileWithDeviceProfile2() {
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
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent4() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent5() {
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
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)} with
   * {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile, boolean, boolean)"
  })
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent6() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.saveDeviceProfile(DeviceProfile)"})
  public void testSaveDeviceProfileWithDeviceProfile_thenCallsSetProfileData() {
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
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testDeleteDeviceProfile_thenThrowDataValidationException() {
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
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"
  })
  public void testFindDeviceProfiles() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"
  })
  public void testFindDeviceProfiles2() {
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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"
  })
  public void testFindDeviceProfiles_thenCallsGetId() {
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
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"
  })
  public void testFindDeviceProfiles_thenCallsGetSortOrder() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos2() {
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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_thenCallsGetId() {
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
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_thenCallsGetSortOrder() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * Test {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#createDefaultDeviceProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.createDefaultDeviceProfile(TenantId)"})
  public void testCreateDefaultDeviceProfile_thenThrowDataValidationException() {
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
   * Test {@link DeviceProfileServiceImpl#findDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDefaultDeviceProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileServiceImpl.findDefaultDeviceProfile(TenantId)"})
  public void testFindDefaultDeviceProfile_thenThrowDataValidationException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo DeviceProfileServiceImpl.findDefaultDeviceProfileInfo(TenantId)"
  })
  public void testFindDefaultDeviceProfileInfo_thenThrowDataValidationException() {
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
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testSetDefaultDeviceProfile_thenThrowDataValidationException() {
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
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  public void testDeleteDeviceProfilesByTenantId_thenThrowDataValidationException() {
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
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowDataValidationException() {
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
   * Test {@link DeviceProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DeviceProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List DeviceProfileServiceImpl.findDeviceProfileNamesByTenantId(TenantId, boolean)"
  })
  public void testFindDeviceProfileNamesByTenantId_thenThrowDataValidationException() {
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
}
