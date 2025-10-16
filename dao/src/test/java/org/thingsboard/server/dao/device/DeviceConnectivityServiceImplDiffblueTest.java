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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.net.URISyntaxException;
import java.util.Iterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.settings.AdminSettingsService;

@ContextConfiguration(classes = {DeviceConnectivityServiceImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceConnectivityServiceImplDiffblueTest {
  @MockBean private AdminSettingsService adminSettingsService;

  @Autowired private DeviceConnectivityServiceImpl deviceConnectivityServiceImpl;

  @MockBean private DeviceCredentialsService deviceCredentialsService;

  @MockBean private DeviceProfileService deviceProfileService;

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenThrow(new RuntimeException());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
                "https://example.org/example", device));
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands2() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
                "https://example.org/example", device));
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands3() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService, atLeast(1))
        .findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    assertEquals("{ }", actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(0, actualFindDevicePublishTelemetryCommandsResult.size());
    assertFalse(actualFindDevicePublishTelemetryCommandsResult.iterator().hasNext());
    assertTrue(actualFindDevicePublishTelemetryCommandsResult.isEmpty());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands4() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
                "https://example.org/example", device));
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands5() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService, atLeast(1))
        .findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    assertEquals("{ }", actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(0, actualFindDevicePublishTelemetryCommandsResult.size());
    assertFalse(actualFindDevicePublishTelemetryCommandsResult.iterator().hasNext());
    assertTrue(actualFindDevicePublishTelemetryCommandsResult.isEmpty());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands6() throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService, atLeast(1))
        .findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    assertEquals("{ }", actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(0, actualFindDevicePublishTelemetryCommandsResult.size());
    assertFalse(actualFindDevicePublishTelemetryCommandsResult.iterator().hasNext());
    assertTrue(actualFindDevicePublishTelemetryCommandsResult.isEmpty());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} TransportType is {@code COAP}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands_givenDeviceProfileTransportTypeIsCoap()
      throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.COAP);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService, atLeast(1))
        .findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    assertEquals("{ }", actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(0, actualFindDevicePublishTelemetryCommandsResult.size());
    assertFalse(actualFindDevicePublishTelemetryCommandsResult.iterator().hasNext());
    assertTrue(actualFindDevicePublishTelemetryCommandsResult.isEmpty());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} TransportType is {@code COAP}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands_givenDeviceProfileTransportTypeIsCoap2()
      throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.COAP);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
                "https://example.org/example", device));
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <ul>
   *   <li>Then iterator next return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands_thenIteratorNextReturnObjectNode()
      throws URISyntaxException {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(deviceCredentials);

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    verify(adminSettingsService, atLeast(1))
        .findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    Iterator<JsonNode> iteratorResult = actualFindDevicePublishTelemetryCommandsResult.iterator();
    assertTrue(iteratorResult.next() instanceof ObjectNode);
    assertTrue(iteratorResult.next() instanceof ObjectNode);
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    assertEquals(
        "{\n"
            + "  \"mqtt\" : {\n"
            + "    \"mqtts\" : \"Check documentation\"\n"
            + "  },\n"
            + "  \"coap\" : {\n"
            + "    \"coaps\" : \"Check documentation\"\n"
            + "  }\n"
            + "}",
        actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(2, actualFindDevicePublishTelemetryCommandsResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   *
   * <ul>
   *   <li>Then iterator next return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode DeviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(String, Device)"
  })
  public void testFindDevicePublishTelemetryCommands_thenIteratorNextReturnTextNode()
      throws URISyntaxException {
    // Arrange
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.LWM2M);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);

    Device device = new Device(new Device());
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    JsonNode actualFindDevicePublishTelemetryCommandsResult =
        deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands(
            "https://example.org/example", device);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isNull(), isA(DeviceId.class));
    verify(deviceProfileService).findDeviceProfileById(isNull(), isNull());
    assertTrue(actualFindDevicePublishTelemetryCommandsResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualFindDevicePublishTelemetryCommandsResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"Check documentation\"", nextResult.toPrettyString());
    assertEquals(
        "{\n  \"LWM2M\" : \"Check documentation\"\n}",
        actualFindDevicePublishTelemetryCommandsResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(1, actualFindDevicePublishTelemetryCommandsResult.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> deviceConnectivityServiceImpl.getPemCertFile("Protocol"));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()} JsonValue is valueOf ten.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_givenAdminSettingsJsonValueIsValueOfTen_thenReturnNull() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(DoubleNode.valueOf(10.0d));
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsService} {@link
   *       AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link JsonNode#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_givenJsonNodeGetThrowRuntimeException_thenCallsGet() {
    // Arrange
    JsonNode jsonValue = mock(JsonNode.class);
    when(jsonValue.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> deviceConnectivityServiceImpl.getPemCertFile("Protocol"));
    verify(jsonValue).get("Protocol");
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_thenCallsGetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new RuntimeException());
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> deviceConnectivityServiceImpl.getPemCertFile("Protocol"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_thenReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   *
   * <ul>
   *   <li>When {@code mqtts}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource DeviceConnectivityServiceImpl.getPemCertFile(String)"})
  public void testGetPemCertFile_whenMqtts_thenReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("mqtts");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}.
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityServiceImpl.createGatewayDockerComposeFile(String, Device)"
  })
  public void testCreateGatewayDockerComposeFile() throws URISyntaxException {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.createGatewayDockerComposeFile(
                "https://example.org/example", new Device()));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityServiceImpl.createGatewayDockerComposeFile(String, Device)"
  })
  public void testCreateGatewayDockerComposeFile_thenCallsGetJsonValue() throws URISyntaxException {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new RuntimeException());
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            deviceConnectivityServiceImpl.createGatewayDockerComposeFile(
                "https://example.org/example", new Device()));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceConnectivityServiceImpl.isEnabled("Protocol"));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(DoubleNode.valueOf(10.0d));
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsService} {@link
   *       AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return {@link
   *       AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled_givenAdminSettingsServiceFindAdminSettingsByKeyReturnAdminSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsService} {@link
   *       AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link JsonNode#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled_givenJsonNodeGetThrowRuntimeException_thenCallsGet() {
    // Arrange
    JsonNode jsonValue = mock(JsonNode.class);
    when(jsonValue.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(jsonValue);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceConnectivityServiceImpl.isEnabled("Protocol"));
    verify(jsonValue).get("Protocol");
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityServiceImpl.isEnabled(String)"})
  public void testIsEnabled_thenCallsGetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new RuntimeException());
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceConnectivityServiceImpl.isEnabled("Protocol"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }
}
