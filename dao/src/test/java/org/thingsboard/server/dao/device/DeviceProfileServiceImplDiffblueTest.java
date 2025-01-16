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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceProfileServiceImplDiffblueTest {
  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("\n");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("\r");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\\s*.*?\\s*-----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\n");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)} with
   * {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfile11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\r");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("\n");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("\r");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\\s*.*?\\s*-----END CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration
        .setProvisionDeviceSecret("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\n");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code doValidate}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#saveDeviceProfile(DeviceProfile, boolean, boolean)}
   */
  @Test
  public void testSaveDeviceProfileWithDeviceProfileDoValidatePublishSaveEvent11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration = new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("-----BEGIN CERTIFICATE-----\r");
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(x509CertificateChainProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doThrow(new DataValidationException("An error occurred")).when(deviceProfile)
        .setProfileData(Mockito.<DeviceProfileData>any());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.saveDeviceProfile(deviceProfile, true, true));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile).setProfileData(isA(DeviceProfileData.class));
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData, atLeast(1)).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindDeviceProfiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindDeviceProfiles_thenCallsGetSortOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}
   */
  @Test
  public void testFindDeviceProfileInfos() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl
        .findDeviceProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}
   */
  @Test
  public void testFindDeviceProfileInfos_thenCallsGetSortOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceProfileServiceImpl
        .findDeviceProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE, (new DeviceProfileServiceImpl()).getEntityType());
  }
}
