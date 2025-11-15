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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return Value is {@code Downloading}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/5/0/3'; then return Value is 'Downloading'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"})
  void testConvertOtaUpdateValueToString_when503_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/5/0/3", 1L, Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /9/0/7}.</li>
   *   <li>Then return Value is {@code DownloadStarted}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/7'; then return Value is 'DownloadStarted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"})
  void testConvertOtaUpdateValueToString_when907_thenReturnValueIsDownloadStarted() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/7", 1L, Type.NONE);

    // Assert
    assertEquals("DownloadStarted", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code /9/0/9}.</li>
   *   <li>Then return Value is {@code Downloading}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when '/9/0/9'; then return Value is 'Downloading'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"})
  void testConvertOtaUpdateValueToString_when909_thenReturnValueIsDownloading() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/9", 1L, Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Value longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when 'null'; then return Value longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"})
  void testConvertOtaUpdateValueToString_whenNull_thenReturnValueLongValueIsFortyTwo() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil.convertOtaUpdateValueToString(null,
        42L, Type.NONE);

    // Assert
    assertEquals(42L, ((Long) actualConvertOtaUpdateValueToStringResult.getValue()).longValue());
    assertEquals(Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, Type)}.
   * <ul>
   *   <li>When {@code Path Id Ver}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  @DisplayName("Test convertOtaUpdateValueToString(String, Object, Type); when 'Path Id Ver'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "LwM2mOtaConvert LwM2MTransportUtil.convertOtaUpdateValueToString(String, Object, ResourceModel.Type)"})
  void testConvertOtaUpdateValueToString_whenPathIdVer_thenReturnValue() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("Path Id Ver", "Value", Type.NONE);

    // Assert
    assertEquals("Value", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Test {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"})
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
   *   <li>When {@link DeviceProfile} {@link DeviceProfile#getId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile); given 'null'; when DeviceProfile getId() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"})
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
   * Method under test: {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toLwM2MClientProfile(DeviceProfile); then calls getTransportConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2MTransportUtil.toLwM2MClientProfile(DeviceProfile)"})
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
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"})
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
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"})
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
   * Test {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileData#getTransportConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  @DisplayName("Test getBootstrapParametersFromThingsboard(DeviceProfile); then calls getTransportConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LwM2MTransportUtil.getBootstrapParametersFromThingsboard(DeviceProfile)"})
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
   * Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when '/5/0/3'; then return '/5/0/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
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
   * Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
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
   * Method under test: {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  @DisplayName("Test fromVersionedIdToObjectId(String); when 'Path Id Ver'; then return 'Path Id Ver'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.fromVersionedIdToObjectId(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.getVerFromPathIdVerOrId(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.getVerFromPathIdVerOrId(String)"})
  void testGetVerFromPathIdVerOrId_whenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.getVerFromPathIdVerOrId("Path"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code /5/0/3}.</li>
   *   <li>Then return {@code /5_null/0/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when '/5/0/3'; then return '/5_null/0/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_when503_thenReturn5Null03() {
    // Arrange, Act and Assert
    assertEquals("/5_null/0/3", LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
  void testConvertObjectIdToVersionedId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3", null));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  @DisplayName("Test convertObjectIdToVersionedId(String, LwM2mClient); when 'Path'; then return 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2MTransportUtil.convertObjectIdToVersionedId(String, LwM2mClient)"})
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
   * Method under test: {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName("Test equalsResourceTypeGetSimpleName(Object); when forty-two; then return 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceModel.Type LwM2MTransportUtil.equalsResourceTypeGetSimpleName(Object)"})
  void testEqualsResourceTypeGetSimpleName_whenFortyTwo_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(Type.INTEGER, LwM2MTransportUtil.equalsResourceTypeGetSimpleName(42));
  }

  /**
   * Test {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  @DisplayName("Test equalsResourceTypeGetSimpleName(Object); when 'Value'; then return 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceModel.Type LwM2MTransportUtil.equalsResourceTypeGetSimpleName(Object)"})
  void testEqualsResourceTypeGetSimpleName_whenValue_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(Type.STRING, LwM2MTransportUtil.equalsResourceTypeGetSimpleName("Value"));
  }

  /**
   * Test {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}
   */
  @Test
  @DisplayName("Test getJsonPrimitiveValue(JsonPrimitive); when JsonPrimitive(Boolean) with bool is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.getJsonPrimitiveValue(JsonPrimitive)"})
  void testGetJsonPrimitiveValue_whenJsonPrimitiveWithBoolIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) LwM2MTransportUtil.getJsonPrimitiveValue(new JsonPrimitive(false)));
  }

  /**
   * Test {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}
   */
  @Test
  @DisplayName("Test getJsonPrimitiveValue(JsonPrimitive); when JsonPrimitive(Boolean) with bool is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.getJsonPrimitiveValue(JsonPrimitive)"})
  void testGetJsonPrimitiveValue_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) LwM2MTransportUtil.getJsonPrimitiveValue(new JsonPrimitive(true)));
  }

  /**
   * Test {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}
   */
  @Test
  @DisplayName("Test getJsonPrimitiveValue(JsonPrimitive); when JsonPrimitive(String) with 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.getJsonPrimitiveValue(JsonPrimitive)"})
  void testGetJsonPrimitiveValue_whenJsonPrimitiveWithString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.getJsonPrimitiveValue(new JsonPrimitive("String")));
  }

  /**
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
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
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getObjectId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given 'null'; when HasVersionedId getObjectId() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
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
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()} return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); given '/'; when HasVersionedId getVersionedId() return '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
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
   * Test {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}.
   * <ul>
   *   <li>When {@link HasVersionedId} {@link HasVersionedId#getVersionedId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  @DisplayName("Test validateVersionedId(LwM2mClient, HasVersionedId); when HasVersionedId getVersionedId() return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MTransportUtil.validateVersionedId(LwM2mClient, HasVersionedId)"})
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
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"})
  void testConvertMultiResourceValuesFromRpcBody_whenHashMap_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new HashMap<>(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"})
  void testConvertMultiResourceValuesFromRpcBody_whenJsonObject_thenReturnEmpty() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new JsonObject(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, Type, String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromRpcBody(Object, Type, String); when 'Value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Map LwM2MTransportUtil.convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)"})
  void testConvertMultiResourceValuesFromRpcBody_whenValue_thenReturnNull() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody("Value", Type.NONE, "42");

    // Assert
    assertNull(actualConvertMultiResourceValuesFromRpcBodyResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, Type, String)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertMultiResourceValuesFromJson(JsonElement, Type, String); when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Map LwM2MTransportUtil.convertMultiResourceValuesFromJson(JsonElement, ResourceModel.Type, String)"})
  void testConvertMultiResourceValuesFromJson_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromJsonResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromJson(new JsonObject(), Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromJsonResult.isEmpty());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>Then return {@link ObjectLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); then return ObjectLink")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_thenReturnObjectLink() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult = LwM2MTransportUtil
        .convertValueByTypeResource(new JsonPrimitive("/"), Type.OBJLNK, "/");

    // Assert
    assertTrue(actualConvertValueByTypeResourceResult instanceof ObjectLink);
    assertEquals(65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectId());
    assertEquals(65535, ((ObjectLink) actualConvertValueByTypeResourceResult).getObjectInstanceId());
    assertTrue(((ObjectLink) actualConvertValueByTypeResourceResult).isNullLink());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link ResourceModel.Type#FLOAT}.</li>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when FLOAT; then return floatValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenFloat_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f,
        ((Float) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), Type.FLOAT, "/")).floatValue());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link ResourceModel.Type#INTEGER}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when INTEGER; then return longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenInteger_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L,
        ((Long) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), Type.INTEGER, "/")).longValue());
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when JsonPrimitive(Boolean) with bool is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenJsonPrimitiveWithBoolIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(false), null, "42"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when JsonPrimitive(String) with string is FALSE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenJsonPrimitiveWithStringIsFalseToString() {
    // Arrange, Act and Assert
    assertFalse((Boolean) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(Boolean.FALSE.toString()),
        Type.BOOLEAN, "/"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when JsonPrimitive(String) with string is TRUE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenJsonPrimitiveWithStringIsTrueToString() {
    // Arrange, Act and Assert
    assertTrue((Boolean) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(Boolean.TRUE.toString()),
        Type.BOOLEAN, "/"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenNull_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "/"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenNull_thenReturnString2() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "42"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive(true), null, "42"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@link ResourceModel.Type#STRING}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when STRING; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String",
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), Type.STRING, "/"));
  }

  /**
   * Test {@link LwM2MTransportUtil#convertValueByTypeResource(Object, Type, String)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  @DisplayName("Test convertValueByTypeResource(Object, Type, String); when 'STRING'; then return TRUE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LwM2MTransportUtil.convertValueByTypeResource(Object, ResourceModel.Type, String)"})
  void testConvertValueByTypeResource_whenString_thenReturnTrueToString() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult = LwM2MTransportUtil
        .convertValueByTypeResource(new JsonPrimitive(true), Type.STRING, "42");

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertValueByTypeResourceResult);
  }

  /**
   * Test {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test getResourceValueFromLwM2MClient(LwM2mClient, String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.core.node.LwM2mResource LwM2MTransportUtil.getResourceValueFromLwM2MClient(LwM2mClient, String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    LwM2mMultipleResource lwM2mMultipleResource = new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    objectObjectMap.put(lwM2mMultipleResource, new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString2() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    LwM2mSingleResource newBooleanResourceResult = LwM2mSingleResource.newBooleanResource(1, true);
    objectObjectMap.put(newBooleanResourceResult, new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
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
   *   <li>Given newBooleanInstance one and {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); given newBooleanInstance one and 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_givenNewBooleanInstanceOneAndTrue() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(new LwM2mMultipleResource(1, Type.OPAQUE, instances));

    // Assert
    assertEquals("LwM2mMultipleResource [id=1, values={1=LwM2mResourceInstance [id=1, value=true, type=BOOLEAN]},"
        + " type=OPAQUE]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code {42=LwM2mMultipleResource [id=1, values={}, type=NONE]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is '{42=LwM2mMultipleResource [id=1, values={}, type=NONE]}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIs42LwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()));

    // Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(objectObjectMap);

    // Assert
    assertEquals("{42=LwM2mMultipleResource [id=1, values={}, type=NONE]}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mMultipleResource [id=1, values={}, type=NONE]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is 'LwM2mMultipleResource [id=1, values={}, type=NONE]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()));

    // Assert
    assertEquals("LwM2mMultipleResource [id=1, values={}, type=NONE]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mMultipleResource id=1 values={} type=OPAQUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is 'LwM2mMultipleResource id=1 values={} type=OPAQUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsLwM2mMultipleResourceId1ValuesTypeOpaque() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(new LwM2mMultipleResource(1, Type.OPAQUE, new ArrayList<>()));

    // Assert
    assertEquals("LwM2mMultipleResource id=1 values={} type=OPAQUE", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Test {@link LwM2MTransportUtil#contentToString(Object)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code LwM2mSingleResource [id=1, value=true, type=BOOLEAN]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is 'LwM2mSingleResource [id=1, value=true, type=BOOLEAN]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
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
   *   <li>Then return {@link Optional#get()} is {@code {null=LwM2mMultipleResource [id=1, values={}, type=NONE]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); then return get() is '{null=LwM2mMultipleResource [id=1, values={}, type=NONE]}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
  void testContentToString_thenReturnGetIsNullLwM2mMultipleResourceId1ValuesTypeNone() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(null, new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()));

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
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Optional#get()} is {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  @DisplayName("Test contentToString(Object); when HashMap(); then return get() is '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional LwM2MTransportUtil.contentToString(Object)"})
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
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}
   */
  @Test
  @DisplayName("Test compareAttNameKeyOta(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MTransportUtil.compareAttNameKeyOta(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MTransportUtil.valueEquals(Object, Object)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MTransportUtil.valueEquals(Object, Object)"})
  void testValueEquals_whenOldValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(LwM2MTransportUtil.valueEquals("Old Value", "Old Value"));
  }
}
