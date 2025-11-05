package org.thingsboard.server.transport.lwm2m.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.eclipse.californium.elements.config.BasicDefinition;
import org.eclipse.californium.elements.config.Configuration;
import org.eclipse.californium.elements.config.DocumentedDefinition;
import org.eclipse.leshan.core.model.LwM2mModel;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.model.StaticModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mResourceInstance;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.node.ObjectLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.transport.lwm2m.server.LwM2mOtaConvert;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.downlink.HasVersionedId;

class LwM2MTransportUtilDiffblueTest {
  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code /5/0/3}.
   *   <li>Then return Value is {@code Downloading}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when '/5/0/3'; then return Value is 'Downloading'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_when503_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString("/5/0/3", 1L, Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code /9/0/7}.
   *   <li>Then return Value is {@code DownloadStarted}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/7'; then return Value is 'DownloadStarted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_when907_thenReturnValueIsDownloadStarted() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString("/9/0/7", 1L, Type.NONE);

    // Assert
    assertEquals("DownloadStarted", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code /9/0/9}.
   *   <li>Then return Value is {@code Downloading}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/9'; then return Value is 'Downloading'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_when909_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString("/9/0/9", 1L, Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   *   <li>Then return Value longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when 'foo/bar'; then return Value longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_whenFooBar_thenReturnValueLongValueIsFortyTwo() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString("foo/bar", 42L, Type.NONE);

    // Assert
    assertEquals(42L, ((Long) actualConvertOtaUpdateValueToStringResult.getValue()).longValue());
    assertEquals(Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Value longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when 'null'; then return Value longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_whenNull_thenReturnValueLongValueIsFortyTwo() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString(null, 42L, Type.NONE);

    // Assert
    assertEquals(42L, ((Long) actualConvertOtaUpdateValueToStringResult.getValue()).longValue());
    assertEquals(Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   *
   * <ul>
   *   <li>When {@code Path Id Ver}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object,
   * ResourceModel.Type)}
   */
  @Test
  @DisplayName(
      "Test convertOtaUpdateValueToString(String, Object, Type); when 'Path Id Ver'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"
  })
  void testConvertOtaUpdateValueToString_whenPathIdVer_thenReturnValue() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult =
        LwM2MTransportUtil.convertOtaUpdateValueToString("Path Id Ver", "Value", Type.NONE);

    // Assert
    assertEquals("Value", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   *
   * <p>Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"
  })
  void testToLwM2MClientProfile() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenThrow(new IllegalArgumentException());

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"
  })
  void testToLwM2MClientProfile_givenIllegalArgumentException() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new IllegalArgumentException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DeviceProfile} {@link DeviceProfile#getId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test toLwM2MClientProfile(DeviceProfile); given 'null'; when DeviceProfile getId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"
  })
  void testToLwM2MClientProfile_givenNull_whenDeviceProfileGetIdReturnNull() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(null);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(transportConfiguration, atLeast(1)).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   *
   * <p>Method under test: {@link
   * LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"
  })
  void testGetBootstrapParametersFromThingsboard() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenThrow(new IllegalArgumentException());

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test getBootstrapParametersFromThingsboard(DeviceProfile); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"
  })
  void testGetBootstrapParametersFromThingsboard_givenIllegalArgumentException() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new IllegalArgumentException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"
  })
  void testGetBootstrapParametersFromThingsboard_givenNull() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(null);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(transportConfiguration, atLeast(1)).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   *   <li>Then return {@code foo/bar}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'foo/bar'; then return 'foo/bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
  void testFromVersionedIdToObjectId_whenFooBar_thenReturnFooBar() {
    // Arrange, Act and Assert
    assertEquals("foo/bar", LwM2MTransportUtil.fromVersionedIdToObjectId("foo/bar"));
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
  void testFromVersionedIdToObjectId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.fromVersionedIdToObjectId(null));
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   *
   * <ul>
   *   <li>When {@code Path Id Ver}.
   *   <li>Then return {@code Path Id Ver}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName(
      "Test fromVersionedIdToObjectId(String); when 'Path Id Ver'; then return 'Path Id Ver'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
  void testFromVersionedIdToObjectId_whenPathIdVer_thenReturnPathIdVer() {
    // Arrange, Act and Assert
    assertEquals("Path Id Ver", LwM2MTransportUtil.fromVersionedIdToObjectId("Path Id Ver"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   *   <li>Then return {@link LwM2MTransportUtil#LWM2M_OBJECT_VERSION_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}
   */
  @Test
  @DisplayName(
      "Test getVerFromPathIdVerOrId(String); when 'foo/bar'; then return LWM2M_OBJECT_VERSION_DEFAULT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.getVerFromPathIdVerOrId(String)"})
  void testGetVerFromPathIdVerOrId_whenFooBar_thenReturnLwm2m_object_version_default() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MTransportUtil.LWM2M_OBJECT_VERSION_DEFAULT,
        LwM2MTransportUtil.getVerFromPathIdVerOrId("foo/bar"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}
   */
  @Test
  @DisplayName("Test getVerFromPathIdVerOrId(String); when 'Path'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.getVerFromPathIdVerOrId(String)"})
  void testGetVerFromPathIdVerOrId_whenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.getVerFromPathIdVerOrId("Path"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@code /5/0/3}.
   *   <li>Then return {@code /5_null/0/3}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String,
   * LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test convertObjectIdToVersionedId(String, LwM2mClient); when '/5/0/3'; then return '/5_null/0/3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_when503_thenReturn5Null03() {
    // Arrange and Act
    String actualConvertObjectIdToVersionedIdResult =
        LwM2MTransportUtil.convertObjectIdToVersionedId(
            "/5/0/3", new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals("/5_null/0/3", actualConvertObjectIdToVersionedIdResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String,
   * LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test convertObjectIdToVersionedId(String, LwM2mClient); when 'foo/bar'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_whenFooBar_thenReturnNull() {
    // Arrange and Act
    String actualConvertObjectIdToVersionedIdResult =
        LwM2MTransportUtil.convertObjectIdToVersionedId(
            "foo/bar", new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertNull(actualConvertObjectIdToVersionedIdResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String,
   * LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test convertObjectIdToVersionedId(String, LwM2mClient); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3", null));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String,
   * LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test convertObjectIdToVersionedId(String, LwM2mClient); when 'Path'; then return 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_whenPath_thenReturnPath() {
    // Arrange and Act
    String actualConvertObjectIdToVersionedIdResult =
        LwM2MTransportUtil.convertObjectIdToVersionedId(
            "Path", new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals("Path", actualConvertObjectIdToVersionedIdResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName(
      "Test equalsResourceTypeGetSimpleName(Object); when forty-two; then return 'INTEGER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2MTransportUtil.equalsResourceTypeGetSimpleName(Object)"
  })
  void testEqualsResourceTypeGetSimpleName_whenFortyTwo_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(Type.INTEGER, LwM2MTransportUtil.equalsResourceTypeGetSimpleName(42));
  }

  /**
   * Test {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName("Test equalsResourceTypeGetSimpleName(Object); when 'Value'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2MTransportUtil.equalsResourceTypeGetSimpleName(Object)"
  })
  void testEqualsResourceTypeGetSimpleName_whenValue_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(Type.STRING, LwM2MTransportUtil.equalsResourceTypeGetSimpleName("Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   *
   * <p>Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient,
   * HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
  void testValidateVersionedId() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getObjectId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   *
   * <p>Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient,
   * HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
  void testValidateVersionedId2() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenThrow(new IllegalArgumentException());
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getObjectId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient,
   * HasVersionedId)}
   */
  @Test
  @DisplayName(
      "Test validateVersionedId(LwM2mClient, HasVersionedId); given 'null'; when HasVersionedId getObjectId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
  void testValidateVersionedId_givenNull_whenHasVersionedIdGetObjectIdReturnNull() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getObjectId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient,
   * HasVersionedId)}
   */
  @Test
  @DisplayName(
      "Test validateVersionedId(LwM2mClient, HasVersionedId); given '/'; when HasVersionedId getVersionedId() return '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
  void testValidateVersionedId_givenSlash_whenHasVersionedIdGetVersionedIdReturnSlash() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenReturn("/");
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   *
   * <ul>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient,
   * HasVersionedId)}
   */
  @Test
  @DisplayName(
      "Test validateVersionedId(LwM2mClient, HasVersionedId); when HasVersionedId getVersionedId() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
  void testValidateVersionedId_whenHasVersionedIdGetVersionedIdReturn42() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenReturn("42");
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"
  })
  void testConvertMultiResourceValuesFromRpcBody_whenHashMap_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult =
        LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(new HashMap<>(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when JsonObject (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"
  })
  void testConvertMultiResourceValuesFromRpcBody_whenJsonObject_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult =
        LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(new JsonObject(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when 'Value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"
  })
  void testConvertMultiResourceValuesFromRpcBody_whenValue_thenReturnNull() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult =
        LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody("Value", Type.NONE, "42");

    // Assert
    assertNull(actualConvertMultiResourceValuesFromRpcBodyResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, Type, String)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertMultiResourceValuesFromJson(JsonElement, Type, String); when JsonObject (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map LwM2MTransportUtil.convertMultiResourceValuesFromJson(JsonElement, ResourceModel.Type, String)"
  })
  void testConvertMultiResourceValuesFromJson_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromJsonResult =
        LwM2MTransportUtil.convertMultiResourceValuesFromJson(new JsonObject(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromJsonResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_thenReturnFalse() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(
            new JsonPrimitive(Boolean.FALSE.toString()), Type.BOOLEAN, "");

    // Assert
    assertFalse((Boolean) actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>Then return {@link ObjectLink}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); then return ObjectLink")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_thenReturnObjectLink() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("/"), Type.OBJLNK, "");

    // Assert
    assertTrue(actualConvertValueByTypeResourceResult instanceof ObjectLink);
    assertEquals(65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectId());
    assertEquals(
        65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectInstanceId());
    assertTrue(((ObjectLink) actualConvertValueByTypeResourceResult).isNullLink());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@code /5/0/3}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when '/5/0/3'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_when503_thenReturnString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "/5/0/3");

    // Assert
    assertEquals("String", actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link ResourceModel.Type#FLOAT}.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when FLOAT; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenFloat_thenReturnFloatValueIsFortyTwo() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), Type.FLOAT, "");

    // Assert
    assertEquals(42.0f, ((Float) actualConvertValueByTypeResourceResult).floatValue());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link ResourceModel.Type#INTEGER}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when INTEGER; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenInteger_thenReturnLongValueIsFortyTwo() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), Type.INTEGER, "");

    // Assert
    assertEquals(42L, ((Long) actualConvertValueByTypeResourceResult).longValue());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@link Boolean#TRUE}
   *       toString.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when JsonPrimitive(String) with string is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenJsonPrimitiveWithStringIsTrueToString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(
            new JsonPrimitive(Boolean.TRUE.toString()), Type.BOOLEAN, "");

    // Assert
    assertTrue((Boolean) actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenNull_thenReturnString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "42");

    // Assert
    assertEquals("String", actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenNull_thenReturnTrue() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(true), null, "42");

    // Assert
    assertTrue((Boolean) actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@link ResourceModel.Type#STRING}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when STRING; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenString_thenReturnString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult =
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), Type.STRING, "");

    // Assert
    assertEquals("String", actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object,
   * ResourceModel.Type, String)}
   */
  @Test
  @DisplayName(
      "Test convertValueByTypeResource(Object, Type, String); when 'STRING'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"
  })
  void testConvertValueByTypeResource_whenString_thenReturnTrueToString() {
    // Arrange, Act and Assert
    assertEquals(
        Boolean.TRUE.toString(),
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(true), Type.STRING, "42"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient,
   * String)}
   */
  @Test
  @DisplayName("Test getResourceValueFromLwM2MClient(LwM2mClient, String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.node.LwM2mResource LwM2MTransportUtil.getResourceValueFromLwM2MClient(LwM2mClient, String)"
  })
  void testGetResourceValueFromLwM2MClient_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        LwM2MTransportUtil.getResourceValueFromLwM2MClient(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Path"));
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Given newBooleanInstance one and {@code true}.
   *   <li>Then return {@link Optional#get()} is a string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); given newBooleanInstance one and 'true'; then return get() is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_givenNewBooleanInstanceOneAndTrue_thenReturnGetIsAString() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mMultipleResource =
        new LwM2mMultipleResource(1, Type.OPAQUE, instances);

    // Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(lwM2mMultipleResource);

    // Assert
    assertEquals(
        "LwM2mMultipleResource [id=1, values={1=LwM2mResourceInstance [id=1, value=true, type=BOOLEAN]},"
            + " type=OPAQUE]",
        actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link TreeMap#TreeMap()} {@code Key} is {@code Value}.
   *   <li>Then return {@link Optional#get()} is {@code {Key=Value}}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); given 'Value'; when TreeMap() 'Key' is 'Value'; then return get() is '{Key=Value}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_givenValue_whenTreeMapKeyIsValue_thenReturnGetIsKeyValue() {
    // Arrange
    TreeMap<Object, Object> objectObjectMap = new TreeMap<>();
    objectObjectMap.put("Key", "Value");

    // Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{Key=Value}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code {Key=LwM2mMultipleResource [id=1, values={},
   *       type=NONE]}}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); then return get() is '{Key=LwM2mMultipleResource [id=1, values={}, type=NONE]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsKeyLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    TreeMap<Object, Object> objectObjectMap = new TreeMap<>();
    LwM2mMultipleResource lwM2mMultipleResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    objectObjectMap.put("Key", lwM2mMultipleResource);

    // Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals(
        "{Key=LwM2mMultipleResource [id=1, values={}, type=NONE]}",
        actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mMultipleResource [id=1, values={},
   *       type=NONE]}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); then return get() is 'LwM2mMultipleResource [id=1, values={}, type=NONE]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    LwM2mMultipleResource lwM2mMultipleResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(lwM2mMultipleResource);

    // Assert
    assertEquals(
        "LwM2mMultipleResource [id=1, values={}, type=NONE]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mMultipleResource id=1 values={}
   *       type=OPAQUE}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); then return get() is 'LwM2mMultipleResource id=1 values={} type=OPAQUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsLwM2mMultipleResourceId1ValuesTypeOpaque() {
    // Arrange
    LwM2mMultipleResource lwM2mMultipleResource =
        new LwM2mMultipleResource(1, Type.OPAQUE, new ArrayList<>());

    // Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(lwM2mMultipleResource);

    // Assert
    assertEquals(
        "LwM2mMultipleResource id=1 values={} type=OPAQUE", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mSingleResource [id=1, value=true,
   *       type=BOOLEAN]}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName(
      "Test contentToString(Object); then return get() is 'LwM2mSingleResource [id=1, value=true, type=BOOLEAN]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsLwM2mSingleResourceId1ValueTrueTypeBoolean() {
    // Arrange and Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(LwM2mSingleResource.newBooleanResource(1, true));

    // Assert
    assertEquals(
        "LwM2mSingleResource [id=1, value=true, type=BOOLEAN]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>When {@code Content}.
   *   <li>Then return {@link Optional#get()} is {@code Content}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when 'Content'; then return get() is 'Content'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_whenContent_thenReturnGetIsContent() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString("Content");

    // Assert
    assertEquals("Content", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Optional#get()} is {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when HashMap(); then return get() is '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_whenHashMap_thenReturnGetIsLeftCurlyBracketRightCurlyBracket() {
    // Arrange and Act
    Optional<String> actualContentToStringResult =
        LwM2MTransportUtil.contentToString(new HashMap<>());

    // Assert
    assertEquals("{}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(null);

    // Assert
    assertFalse(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#createModelsDefault()}.
   *
   * <p>Method under test: {@link LwM2MTransportUtil#createModelsDefault()}
   */
  @Test
  @DisplayName("Test createModelsDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mModel LwM2MTransportUtil.createModelsDefault()"})
  void testCreateModelsDefault() {
    // Arrange and Act
    LwM2mModel actualCreateModelsDefaultResult = LwM2MTransportUtil.createModelsDefault();

    // Assert
    assertTrue(actualCreateModelsDefaultResult instanceof StaticModel);
    assertEquals(9, actualCreateModelsDefaultResult.getObjectModels().size());
  }

  /**
   * Test {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}.
   *
   * <p>Method under test: {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}
   */
  @Test
  @DisplayName("Test compareAttNameKeyOta(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2MTransportUtil.compareAttNameKeyOta(String)"})
  void testCompareAttNameKeyOta() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.compareAttNameKeyOta("Attr Name"));
  }

  /**
   * Test {@link LwM2MTransportUtil#valueEquals(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code New Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#valueEquals(Object, Object)}
   */
  @Test
  @DisplayName("Test valueEquals(Object, Object); when 'New Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2MTransportUtil.valueEquals(Object, Object)"})
  void testValueEquals_whenNewValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.valueEquals("New Value", "Old Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#valueEquals(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Old Value}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#valueEquals(Object, Object)}
   */
  @Test
  @DisplayName("Test valueEquals(Object, Object); when 'Old Value'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2MTransportUtil.valueEquals(Object, Object)"})
  void testValueEquals_whenOldValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(LwM2MTransportUtil.valueEquals("Old Value", "Old Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#setDtlsConnectorConfigCidLength(Configuration, Integer)}.
   *
   * <ul>
   *   <li>Given createStandardWithoutFile.
   *   <li>Then calls {@link Configuration#set(BasicDefinition, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#setDtlsConnectorConfigCidLength(Configuration,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test setDtlsConnectorConfigCidLength(Configuration, Integer); given createStandardWithoutFile; then calls set(BasicDefinition, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MTransportUtil.setDtlsConnectorConfigCidLength(Configuration, Integer)"
  })
  void testSetDtlsConnectorConfigCidLength_givenCreateStandardWithoutFile_thenCallsSet() {
    // Arrange
    Configuration serverCoapConfig = mock(Configuration.class);
    when(serverCoapConfig.set(Mockito.<BasicDefinition<Integer>>any(), Mockito.<Integer>any()))
        .thenReturn(Configuration.createStandardWithoutFile());
    when(serverCoapConfig.setTransient(Mockito.<DocumentedDefinition<Integer>>any()))
        .thenReturn(Configuration.createStandardWithoutFile());

    // Act
    LwM2MTransportUtil.setDtlsConnectorConfigCidLength(serverCoapConfig, 1);

    // Assert
    verify(serverCoapConfig, atLeast(1))
        .set(Mockito.<BasicDefinition<Integer>>any(), Mockito.<Integer>any());
    verify(serverCoapConfig, atLeast(1)).setTransient(Mockito.<DocumentedDefinition<Integer>>any());
  }

  /**
   * Test {@link LwM2MTransportUtil#setDtlsConnectorConfigCidLength(Configuration, Integer)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then calls {@link Configuration#set(BasicDefinition, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MTransportUtil#setDtlsConnectorConfigCidLength(Configuration,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test setDtlsConnectorConfigCidLength(Configuration, Integer); when five; then calls set(BasicDefinition, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MTransportUtil.setDtlsConnectorConfigCidLength(Configuration, Integer)"
  })
  void testSetDtlsConnectorConfigCidLength_whenFive_thenCallsSet() {
    // Arrange
    Configuration serverCoapConfig = mock(Configuration.class);
    when(serverCoapConfig.set(Mockito.<BasicDefinition<Integer>>any(), Mockito.<Integer>any()))
        .thenReturn(Configuration.createStandardWithoutFile());
    when(serverCoapConfig.setTransient(Mockito.<DocumentedDefinition<Integer>>any()))
        .thenReturn(Configuration.createStandardWithoutFile());

    // Act
    LwM2MTransportUtil.setDtlsConnectorConfigCidLength(serverCoapConfig, 5);

    // Assert
    verify(serverCoapConfig, atLeast(1))
        .set(Mockito.<BasicDefinition<Integer>>any(), Mockito.<Integer>any());
    verify(serverCoapConfig, atLeast(1)).setTransient(Mockito.<DocumentedDefinition<Integer>>any());
  }
}
