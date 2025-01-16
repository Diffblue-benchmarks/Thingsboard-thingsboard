package org.thingsboard.server.transport.lwm2m.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import org.eclipse.leshan.core.model.LwM2mModel;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.model.StaticModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.node.ObjectLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.transport.lwm2m.server.LwM2mOtaConvert;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.downlink.HasVersionedId;

class LwM2MTransportUtilDiffblueTest {
  /**
   * Test
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return Value is {@code Downloading}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/5/0/3'; then return Value is 'Downloading'")
  void testConvertOtaUpdateValueToString_when503_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/5/0/3", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /9/0/7}.</li>
   *   <li>Then return Value is {@code DownloadStarted}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/7'; then return Value is 'DownloadStarted'")
  void testConvertOtaUpdateValueToString_when907_thenReturnValueIsDownloadStarted() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/7", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("DownloadStarted", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /9/0/9}.</li>
   *   <li>Then return Value is {@code Downloading}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/9'; then return Value is 'Downloading'")
  void testConvertOtaUpdateValueToString_when909_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/9", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return CurrentType is {@code NONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when 'null'; then return CurrentType is 'NONE'")
  void testConvertOtaUpdateValueToString_whenNull_thenReturnCurrentTypeIsNone() {
    // Arrange, Act and Assert
    assertEquals(ResourceModel.Type.NONE,
        LwM2MTransportUtil.convertOtaUpdateValueToString(null, 42L, ResourceModel.Type.NONE).getCurrentType());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code Path Id Ver}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when 'Path Id Ver'; then return 'Value'")
  void testConvertOtaUpdateValueToString_whenPathIdVer_thenReturnValue() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("Path Id Ver", "Value", ResourceModel.Type.NONE);

    // Assert
    assertEquals("Value", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile)")
  void testToLwM2MClientProfile() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenThrow(new IllegalArgumentException("[{}] Received profile with invalid transport configuration: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceProfile} {@link DeviceProfile#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile); given 'null'; when DeviceProfile getId() return 'null'")
  void testToLwM2MClientProfile_givenNull_whenDeviceProfileGetIdReturnNull() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
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
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(transportConfiguration, atLeast(1)).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileData#getTransportConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile); then calls getTransportConfiguration()")
  void testToLwM2MClientProfile_thenCallsGetTransportConfiguration() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    when(deviceProfileTransportConfiguration.getType()).thenThrow(new IllegalArgumentException("foo"));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getTransportConfiguration()).thenReturn(deviceProfileTransportConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.toLwM2MClientProfile(deviceProfile));
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getTransportConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileTransportConfiguration).getType();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile)")
  void testGetBootstrapParametersFromThingsboard() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenThrow(new IllegalArgumentException("[{}] Received profile with invalid transport configuration: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile); given 'null'")
  void testGetBootstrapParametersFromThingsboard_givenNull() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
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
    assertThrows(IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(transportConfiguration, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileData#getTransportConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile); then calls getTransportConfiguration()")
  void testGetBootstrapParametersFromThingsboard_thenCallsGetTransportConfiguration() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    when(deviceProfileTransportConfiguration.getType()).thenThrow(new IllegalArgumentException("foo"));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getTransportConfiguration()).thenReturn(deviceProfileTransportConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> LwM2MTransportUtil.getBootstrapParametersFromThingsboard(deviceProfile));
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getTransportConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileTransportConfiguration).getType();
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return {@code /5/0/3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when '/5/0/3'; then return '/5/0/3'")
  void testFromVersionedIdToObjectId_when503_thenReturn503() {
    // Arrange, Act and Assert
    assertEquals("/5/0/3", LwM2MTransportUtil.fromVersionedIdToObjectId("/5/0/3"));
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'null'; then return 'null'")
  void testFromVersionedIdToObjectId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.fromVersionedIdToObjectId(null));
  }

  /**
   * Test {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}.
   * <ul>
   *   <li>When {@code Path Id Ver}.</li>
   *   <li>Then return {@code Path Id Ver}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'Path Id Ver'; then return 'Path Id Ver'")
  void testFromVersionedIdToObjectId_whenPathIdVer_thenReturnPathIdVer() {
    // Arrange, Act and Assert
    assertEquals("Path Id Ver", LwM2MTransportUtil.fromVersionedIdToObjectId("Path Id Ver"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return {@link LwM2MTransportUtil#LWM2M_OBJECT_VERSION_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}
   */
  @Test
  @DisplayName("Test getVerFromPathIdVerOrId(String); when '/5/0/3'; then return LWM2M_OBJECT_VERSION_DEFAULT")
  void testGetVerFromPathIdVerOrId_when503_thenReturnLwm2m_object_version_default() {
    // Arrange, Act and Assert
    assertEquals(LwM2MTransportUtil.LWM2M_OBJECT_VERSION_DEFAULT, LwM2MTransportUtil.getVerFromPathIdVerOrId("/5/0/3"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}
   */
  @Test
  @DisplayName("Test getVerFromPathIdVerOrId(String); when 'Path'; then return 'null'")
  void testGetVerFromPathIdVerOrId_whenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.getVerFromPathIdVerOrId("Path"));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return {@code /5_null/0/3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when '/5/0/3'; then return '/5_null/0/3'")
  void testConvertObjectIdToVersionedId_when503_thenReturn5Null03() {
    // Arrange, Act and Assert
    assertEquals("/5_null/0/3", LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when 'null'; then return 'null'")
  void testConvertObjectIdToVersionedId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3", null));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when 'Path'; then return 'Path'")
  void testConvertObjectIdToVersionedId_whenPath_thenReturnPath() {
    // Arrange, Act and Assert
    assertEquals("Path", LwM2MTransportUtil.convertObjectIdToVersionedId("Path",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName("Test equalsResourceTypeGetSimpleName(Object); when forty-two; then return 'INTEGER'")
  void testEqualsResourceTypeGetSimpleName_whenFortyTwo_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(ResourceModel.Type.INTEGER, LwM2MTransportUtil.equalsResourceTypeGetSimpleName(42));
  }

  /**
   * Test {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName("Test equalsResourceTypeGetSimpleName(Object); when 'Value'; then return 'STRING'")
  void testEqualsResourceTypeGetSimpleName_whenValue_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(ResourceModel.Type.STRING, LwM2MTransportUtil.equalsResourceTypeGetSimpleName("Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}
   */
  @Test
  @DisplayName("Test getJsonPrimitiveValue(JsonPrimitive); when JsonPrimitive(String) with 'String'; then return 'String'")
  void testGetJsonPrimitiveValue_whenJsonPrimitiveWithString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.getJsonPrimitiveValue(new JsonPrimitive("String")));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given IllegalArgumentException(String) with 'foo'")
  void testValidateVersionedId_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenThrow(new IllegalArgumentException("foo"));
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getObjectId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given 'null'; when HasVersionedId getObjectId() return 'null'")
  void testValidateVersionedId_givenNull_whenHasVersionedIdGetObjectIdReturnNull() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getObjectId()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()}
   * return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given '/'; when HasVersionedId getVersionedId() return '/'")
  void testValidateVersionedId_givenSlash_whenHasVersionedIdGetVersionedIdReturnSlash() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenReturn("/");
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()}
   * return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); when HasVersionedId getVersionedId() return '42'")
  void testValidateVersionedId_whenHasVersionedIdGetVersionedIdReturn42() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getVersionedId()).thenReturn("42");
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
    verify(request).getVersionedId();
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when HashMap(); then return Empty")
  void testConvertMultiResourceValuesFromRpcBody_whenHashMap_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new HashMap<>(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when JsonObject (default constructor); then return Empty")
  void testConvertMultiResourceValuesFromRpcBody_whenJsonObject_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new JsonObject(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when 'Value'; then return 'null'")
  void testConvertMultiResourceValuesFromRpcBody_whenValue_thenReturnNull() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody("Value", ResourceModel.Type.NONE, "42");

    // Assert
    assertNull(actualConvertMultiResourceValuesFromRpcBodyResult);
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, Type, String)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromJson(JsonElement, Type, String); when JsonObject (default constructor); then return Empty")
  void testConvertMultiResourceValuesFromJson_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromJsonResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromJson(new JsonObject(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromJsonResult.isEmpty());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>Then return {@link ObjectLink}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); then return ObjectLink")
  void testConvertValueByTypeResource_thenReturnObjectLink() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult = LwM2MTransportUtil
        .convertValueByTypeResource(new JsonPrimitive("/"), ResourceModel.Type.OBJLNK, "/");

    // Assert
    assertTrue(actualConvertValueByTypeResourceResult instanceof ObjectLink);
    assertEquals(65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectId());
    assertEquals(65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectInstanceId());
    assertTrue(((ObjectLink) actualConvertValueByTypeResourceResult).isNullLink());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link Type#FLOAT}.</li>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when FLOAT; then return floatValue is forty-two")
  void testConvertValueByTypeResource_whenFloat_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f,
        ((Float) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), ResourceModel.Type.FLOAT, "/"))
            .floatValue());
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'String'")
  void testConvertValueByTypeResource_whenNull_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "/"));
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "42"));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link Type#STRING}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when STRING; then return 'String'")
  void testConvertValueByTypeResource_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String",
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), ResourceModel.Type.STRING, "/"));
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'STRING'; then return TRUE toString")
  void testConvertValueByTypeResource_whenString_thenReturnTrueToString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult = LwM2MTransportUtil
        .convertValueByTypeResource(new JsonPrimitive(true), ResourceModel.Type.STRING, "42");

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertValueByTypeResourceResult);
  }

  /**
   * Test
   * {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test getResourceValueFromLwM2MClient(LwM2mClient, String); then return 'null'")
  void testGetResourceValueFromLwM2MClient_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil
        .getResourceValueFromLwM2MClient(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Path"));
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object)")
  void testContentToString() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    LwM2mMultipleResource lwM2mMultipleResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE,
        new ArrayList<>());

    objectObjectMap.put(lwM2mMultipleResource,
        new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals(
        "{LwM2mMultipleResource [id=1, values={}, type=NONE]=LwM2mMultipleResource [id=1, values={}," + " type=NONE]}",
        actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object)")
  void testContentToString2() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    LwM2mSingleResource newBooleanResourceResult = LwM2mSingleResource.newBooleanResource(1, true);
    objectObjectMap.put(newBooleanResourceResult,
        new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{LwM2mSingleResource [id=1, value=true, type=BOOLEAN]=LwM2mMultipleResource [id=1, values={},"
        + " type=NONE]}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object)")
  void testContentToString3() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(null, LwM2mSingleResource.newBooleanResource(1, true));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{null=LwM2mSingleResource [id=1, value=true, type=BOOLEAN]}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code {42=42}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); given '42'; when HashMap() '42' is '42'; then return get() is '{42=42}'")
  void testContentToString_given42_whenHashMap42Is42_thenReturnGetIs4242() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{42=42}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); given BiFunction; when HashMap() computeIfPresent '42' and BiFunction")
  void testContentToString_givenBiFunction_whenHashMapComputeIfPresent42AndBiFunction() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.computeIfPresent("42", mock(BiFunction.class));
    objectObjectMap.put("42", "42");

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{42=42}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code {42=LwM2mMultipleResource
   * [id=1, values={}, type=NONE]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is '{42=LwM2mMultipleResource [id=1, values={}, type=NONE]}'")
  void testContentToString_thenReturnGetIs42LwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{42=LwM2mMultipleResource [id=1, values={}, type=NONE]}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mMultipleResource [id=1,
   * values={}, type=NONE]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is 'LwM2mMultipleResource [id=1, values={}, type=NONE]'")
  void testContentToString_thenReturnGetIsLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Assert
    assertEquals("LwM2mMultipleResource [id=1, values={}, type=NONE]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is
   * {@code LwM2mSingleResource [id=1, value=true, type=BOOLEAN]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is 'LwM2mSingleResource [id=1, value=true, type=BOOLEAN]'")
  void testContentToString_thenReturnGetIsLwM2mSingleResourceId1ValueTrueTypeBoolean() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(LwM2mSingleResource.newBooleanResource(1, true));

    // Assert
    assertEquals("LwM2mSingleResource [id=1, value=true, type=BOOLEAN]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code {null=LwM2mMultipleResource
   * [id=1, values={}, type=NONE]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is '{null=LwM2mMultipleResource [id=1, values={}, type=NONE]}'")
  void testContentToString_thenReturnGetIsNullLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(null, new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{null=LwM2mMultipleResource [id=1, values={}, type=NONE]}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>When {@code Content}.</li>
   *   <li>Then return {@link Optional#get()} is {@code Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when 'Content'; then return get() is 'Content'")
  void testContentToString_whenContent_thenReturnGetIsContent() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString("Content");

    // Assert
    assertEquals("Content", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Optional#get()} is {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when HashMap(); then return get() is '{}'")
  void testContentToString_whenHashMap_thenReturnGetIsLeftCurlyBracketRightCurlyBracket() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(new HashMap<>());

    // Assert
    assertEquals("{}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when 'null'; then return not Present")
  void testContentToString_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(null);

    // Assert
    assertFalse(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#createModelsDefault()}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#createModelsDefault()}
   */
  @Test
  @DisplayName("Test createModelsDefault()")
  void testCreateModelsDefault() {
    // Arrange and Act
    LwM2mModel actualCreateModelsDefaultResult = LwM2MTransportUtil.createModelsDefault();

    // Assert
    assertTrue(actualCreateModelsDefaultResult instanceof StaticModel);
    assertEquals(9, actualCreateModelsDefaultResult.getObjectModels().size());
  }

  /**
   * Test {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}
   */
  @Test
  @DisplayName("Test compareAttNameKeyOta(String)")
  void testCompareAttNameKeyOta() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.compareAttNameKeyOta("Attr Name"));
  }

  /**
   * Test {@link LwM2MTransportUtil#valueEquals(Object, Object)}.
   * <ul>
   *   <li>When {@code New Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#valueEquals(Object, Object)}
   */
  @Test
  @DisplayName("Test valueEquals(Object, Object); when 'New Value'; then return 'false'")
  void testValueEquals_whenNewValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.valueEquals("New Value", "Old Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#valueEquals(Object, Object)}.
   * <ul>
   *   <li>When {@code Old Value}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#valueEquals(Object, Object)}
   */
  @Test
  @DisplayName("Test valueEquals(Object, Object); when 'Old Value'; then return 'true'")
  void testValueEquals_whenOldValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(LwM2MTransportUtil.valueEquals("Old Value", "Old Value"));
  }
}
