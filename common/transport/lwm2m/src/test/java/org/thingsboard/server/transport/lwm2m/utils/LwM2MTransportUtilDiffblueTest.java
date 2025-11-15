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
import org.eclipse.leshan.core.model.StaticModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.node.ObjectLink;
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
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  void testConvertOtaUpdateValueToString() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("Path Id Ver", "Value", ResourceModel.Type.NONE);

    // Assert
    assertEquals("Value", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.NONE, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  void testConvertOtaUpdateValueToString2() {
    // Arrange, Act and Assert
    assertEquals(ResourceModel.Type.NONE,
        LwM2MTransportUtil.convertOtaUpdateValueToString(null, 42L, ResourceModel.Type.NONE).getCurrentType());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  void testConvertOtaUpdateValueToString3() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/5/0/3", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  void testConvertOtaUpdateValueToString4() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/7", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("DownloadStarted", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertOtaUpdateValueToString(String, Object, ResourceModel.Type)}
   */
  @Test
  void testConvertOtaUpdateValueToString5() {
    // Arrange and Act
    LwM2mOtaConvert actualConvertOtaUpdateValueToStringResult = LwM2MTransportUtil
        .convertOtaUpdateValueToString("/9/0/9", 1L, ResourceModel.Type.NONE);

    // Assert
    assertEquals("Downloading", actualConvertOtaUpdateValueToStringResult.getValue());
    assertEquals(ResourceModel.Type.STRING, actualConvertOtaUpdateValueToStringResult.getCurrentType());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
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
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  void testToLwM2MClientProfile2() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#toLwM2MClientProfile(DeviceProfile)}
   */
  @Test
  void testToLwM2MClientProfile3() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
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
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  void testGetBootstrapParametersFromThingsboard2() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#getBootstrapParametersFromThingsboard(DeviceProfile)}
   */
  @Test
  void testGetBootstrapParametersFromThingsboard3() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#fromVersionedIdToObjectId(String)}
   */
  @Test
  void testFromVersionedIdToObjectId() {
    // Arrange, Act and Assert
    assertEquals("Path Id Ver", LwM2MTransportUtil.fromVersionedIdToObjectId("Path Id Ver"));
    assertNull(LwM2MTransportUtil.fromVersionedIdToObjectId(null));
    assertEquals("/5/0/3", LwM2MTransportUtil.fromVersionedIdToObjectId("/5/0/3"));
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#getVerFromPathIdVerOrId(String)}
   */
  @Test
  void testGetVerFromPathIdVerOrId() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil.getVerFromPathIdVerOrId("Path"));
    assertEquals(LwM2MTransportUtil.LWM2M_OBJECT_VERSION_DEFAULT, LwM2MTransportUtil.getVerFromPathIdVerOrId("/5/0/3"));
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertObjectIdToVersionedId(String, LwM2mClient)}
   */
  @Test
  void testConvertObjectIdToVersionedId() {
    // Arrange, Act and Assert
    assertEquals("Path", LwM2MTransportUtil.convertObjectIdToVersionedId("Path",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    assertEquals("/5_null/0/3", LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    assertNull(LwM2MTransportUtil.convertObjectIdToVersionedId("/5/0/3", null));
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#equalsResourceTypeGetSimpleName(Object)}
   */
  @Test
  void testEqualsResourceTypeGetSimpleName() {
    // Arrange, Act and Assert
    assertEquals(ResourceModel.Type.STRING, LwM2MTransportUtil.equalsResourceTypeGetSimpleName("Value"));
    assertEquals(ResourceModel.Type.INTEGER, LwM2MTransportUtil.equalsResourceTypeGetSimpleName(42));
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#getJsonPrimitiveValue(JsonPrimitive)}
   */
  @Test
  void testGetJsonPrimitiveValue() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.getJsonPrimitiveValue(new JsonPrimitive("String")));
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  void testValidateVersionedId() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  void testValidateVersionedId2() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  void testValidateVersionedId3() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#validateVersionedId(LwM2mClient, HasVersionedId)}
   */
  @Test
  void testValidateVersionedId4() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    HasVersionedId request = mock(HasVersionedId.class);
    when(request.getObjectId()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MTransportUtil.validateVersionedId(client, request));
    verify(request).getObjectId();
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertMultiResourceValuesFromRpcBody() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody("Value", ResourceModel.Type.NONE, "42");

    // Assert
    assertNull(actualConvertMultiResourceValuesFromRpcBodyResult);
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertMultiResourceValuesFromRpcBody2() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new HashMap<>(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromRpcBody(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertMultiResourceValuesFromRpcBody3() throws Exception {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromRpcBodyResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromRpcBody(new JsonObject(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromRpcBodyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertMultiResourceValuesFromJson(JsonElement, ResourceModel.Type, String)}
   */
  @Test
  void testConvertMultiResourceValuesFromJson() {
    // Arrange and Act
    Map<Integer, Object> actualConvertMultiResourceValuesFromJsonResult = LwM2MTransportUtil
        .convertMultiResourceValuesFromJson(new JsonObject(), ResourceModel.Type.NONE, "42");

    // Assert
    assertTrue(actualConvertMultiResourceValuesFromJsonResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertValueByTypeResource() {
    // Arrange, Act and Assert
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "/"));
    assertEquals("String", LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), null, "42"));
    assertEquals("String",
        LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("String"), ResourceModel.Type.STRING, "/"));
    assertEquals(42.0f,
        ((Float) LwM2MTransportUtil.convertValueByTypeResource(new JsonPrimitive("42"), ResourceModel.Type.FLOAT, "/"))
            .floatValue());
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertValueByTypeResource2() {
    // Arrange and Act
    Object actualConvertValueByTypeResourceResult = LwM2MTransportUtil
        .convertValueByTypeResource(new JsonPrimitive(true), ResourceModel.Type.STRING, "42");

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertValueByTypeResourceResult);
  }

  /**
   * Method under test:
   * {@link LwM2MTransportUtil#convertValueByTypeResource(Object, ResourceModel.Type, String)}
   */
  @Test
  void testConvertValueByTypeResource3() {
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
   * Method under test:
   * {@link LwM2MTransportUtil#getResourceValueFromLwM2MClient(LwM2mClient, String)}
   */
  @Test
  void testGetResourceValueFromLwM2MClient() {
    // Arrange, Act and Assert
    assertNull(LwM2MTransportUtil
        .getResourceValueFromLwM2MClient(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Path"));
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString("Content");

    // Assert
    assertEquals("Content", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString2() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(null);

    // Assert
    assertFalse(actualContentToStringResult.isPresent());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString3() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil.contentToString(new HashMap<>());

    // Assert
    assertEquals("{}", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString4() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    // Assert
    assertEquals("LwM2mMultipleResource [id=1, values={}, type=NONE]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString5() {
    // Arrange and Act
    Optional<String> actualContentToStringResult = LwM2MTransportUtil
        .contentToString(LwM2mSingleResource.newBooleanResource(1, true));

    // Assert
    assertEquals("LwM2mSingleResource [id=1, value=true, type=BOOLEAN]", actualContentToStringResult.get());
    assertTrue(actualContentToStringResult.isPresent());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString6() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString7() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString8() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString9() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString10() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString11() {
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
   * Method under test: {@link LwM2MTransportUtil#contentToString(Object)}
   */
  @Test
  void testContentToString12() {
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
   * Method under test: {@link LwM2MTransportUtil#createModelsDefault()}
   */
  @Test
  void testCreateModelsDefault() {
    // Arrange and Act
    LwM2mModel actualCreateModelsDefaultResult = LwM2MTransportUtil.createModelsDefault();

    // Assert
    assertTrue(actualCreateModelsDefaultResult instanceof StaticModel);
    assertEquals(9, actualCreateModelsDefaultResult.getObjectModels().size());
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#compareAttNameKeyOta(String)}
   */
  @Test
  void testCompareAttNameKeyOta() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.compareAttNameKeyOta("Attr Name"));
  }

  /**
   * Method under test: {@link LwM2MTransportUtil#valueEquals(Object, Object)}
   */
  @Test
  void testValueEquals() {
    // Arrange, Act and Assert
    assertFalse(LwM2MTransportUtil.valueEquals("New Value", "Old Value"));
    assertTrue(LwM2MTransportUtil.valueEquals("Old Value", "Old Value"));
  }
}
