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
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.thingsboard.server.common.data.device.credentials.BasicMqttCredentials;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.device.DeviceConnectivityInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceConnectivityUtilDiffblueTest {
  /**
   * Test {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHttpPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetHttpPublishCommand_whenDeviceCredentials_thenReturnAString() {
    // Arrange and Act
    String actualHttpPublishCommand =
        DeviceConnectivityUtil.getHttpPublishCommand(
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            new DeviceCredentials());

    // Assert
    assertEquals(
        "curl -v -X POST https://example.org/example://https://example.org/examplehttps://example.org/example"
            + "/api/v1/null/telemetry --header Content-Type:application/json --data \"{temperature:25}\"",
        actualHttpPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand() throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            "Protocol", "localhost", "Port", "Device Telemetry Topic", deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 -h localhost -p Port -t Device Telemetry Topic -u \"null\" -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>When empty string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenAccessToken_whenEmptyString_thenReturnAString()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            "",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>When {@code null}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenAccessToken_whenNull_thenReturnAString()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            null,
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenBasicMqttCredentialsClientIdIs42()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -i \"42\" -u \"janedoe\""
            + " -P \"iloveyou\" -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenBasicMqttCredentialsClientIdIsEmptyString()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"janedoe\" -P"
            + " \"iloveyou\" -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenBasicMqttCredentialsClientIdIsNull()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId(null);
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"janedoe\" -P"
            + " \"iloveyou\" -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) Password is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenBasicMqttCredentialsPasswordIsNull()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword(null);
    basicMqttCredentials.setUserName("janedoe");
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -i \"42\" -u \"janedoe\""
            + " -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) UserName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenBasicMqttCredentialsUserNameIsNull()
      throws JsonProcessingException {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName(null);
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -i \"42\" -P \"iloveyou\""
            + " -m \"{temperature:25}\"",
        actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertNull(actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String,
   * String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"
  })
  public void testGetMqttPublishCommand_givenX509Certificate() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    String actualMqttPublishCommand =
        DeviceConnectivityUtil.getMqttPublishCommand(
            "Protocol", "localhost", "Port", "Device Telemetry Topic", deviceCredentials);

    // Assert
    assertNull(actualMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>Then return array length is {@code 1245}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenAccessToken_thenReturnArrayLengthIs1245()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenBasicMqttCredentialsClientIdIsEmptyString()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1271, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1271, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenBasicMqttCredentialsClientIdIsNull()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId(null);
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1271, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1271, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@code http://}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenHttp_whenDeviceConnectivityInfoHostIsHttp()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenNull_whenDeviceConnectivityInfoHostIsNull()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost(null);
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_givenX509Certificate()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1220, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1220, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Then return array length is {@code 1234}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1234()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(false);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1234, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1234, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Then return array length is {@code 1265}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1265()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword(null);
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1265, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1265, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Then return array length is {@code 1266}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1266()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName(null);
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1266, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1266, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>Then return array length is {@code 1291}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1291()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1291, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1291, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_whenDeviceConnectivityInfoHostIsEmptyString()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://UU}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_whenDeviceConnectivityInfoHostIsHttpUu()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://UU");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo,
   * DeviceCredentials, String)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()} CredentialsType is {@code MQTT_BASIC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String,
   * DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"
  })
  public void testGetGatewayDockerComposeFile_whenDeviceCredentialsCredentialsTypeIsMqttBasic()
      throws IOException, URISyntaxException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);

      // Act
      Resource actualGatewayDockerComposeFile =
          DeviceConnectivityUtil.getGatewayDockerComposeFile(
              "https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(
          1220, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1220, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      assertEquals(
          "docker run --rm -it thingsboard/mosquitto-clients /bin/sh -c \"curl -f -S -o ca-root.pem https://example"
              + ".org/example/api/device-connectivity/mqtts/certificate/download && mosquitto_pub -d -q 1 --cafile"
              + " ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenAccessToken()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -u"
              + " \"null\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>When {@code mosquitto_pub -d -q 1}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenAccessToken_whenMosquittoPubDQ1()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              "mosquitto_pub -d -q 1",
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients"
              + " mosquitto_pub -d -q 1 -h host.docker.internal -t Device Telemetry Topic -u \"null\" -m \"{temperature"
              + ":25}\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>When {@code mosquitto_pub -d -q 1}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenAccessToken_whenMosquittoPubDQ12()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              "mosquitto_pub -d -q 1",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -p mosquitto_pub -d -q 1 -t"
              + " Device Telemetry Topic -u \"null\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenBasicMqttCredentialsClientIdIsEmptyString()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -u"
              + " \"janedoe\" -P \"iloveyou\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) ClientId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenBasicMqttCredentialsClientIdIsNull()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId(null);
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -u"
              + " \"janedoe\" -P \"iloveyou\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) Password is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenBasicMqttCredentialsPasswordIsNull()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword(null);
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -i"
              + " \"42\" -u \"janedoe\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link BasicMqttCredentials} (default constructor) UserName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenBasicMqttCredentialsUserNameIsNull()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName(null);
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -i"
              + " \"42\" -P \"iloveyou\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act
    String actualDockerMqttPublishCommand =
        DeviceConnectivityUtil.getDockerMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "https://example.org/example",
            "localhost",
            " ",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertNull(actualDockerMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenNull_whenEmptyString_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act
    String actualDockerMqttPublishCommand =
        DeviceConnectivityUtil.getDockerMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "https://example.org/example",
            "localhost",
            "",
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertNull(actualDockerMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenNull_whenNull_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act
    String actualDockerMqttPublishCommand =
        DeviceConnectivityUtil.getDockerMqttPublishCommand(
            DeviceConnectivityUtil.MQTTS,
            "https://example.org/example",
            "localhost",
            null,
            "Device Telemetry Topic",
            deviceCredentials);

    // Assert
    assertNull(actualDockerMqttPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_givenX509Certificate()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      assertNull(actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String,
   * String, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String,
   * String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"
  })
  public void testGetDockerMqttPublishCommand_thenCallsIsLoopbackAddress()
      throws JsonProcessingException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue =
          JsonMapper.builder().findAndAddModules().build().writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      String actualDockerMqttPublishCommand =
          DeviceConnectivityUtil.getDockerMqttPublishCommand(
              DeviceConnectivityUtil.MQTTS,
              "https://example.org/example",
              "localhost",
              " ",
              "Device Telemetry Topic",
              deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients /bin/sh"
              + " -c \"curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/mqtts/certificate/download"
              + " && mosquitto_pub -d -q 1 --cafile ca-root.pem -h host.docker.internal -t Device Telemetry Topic -i"
              + " \"42\" -u \"janedoe\" -P \"iloveyou\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)} with {@code baseUrl},
   * {@code protocol}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCurlPemCertCommand(String, String)"})
  public void testGetCurlPemCertCommandWithBaseUrlProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/https://example.org"
            + "/example/certificate/download",
        DeviceConnectivityUtil.getCurlPemCertCommand(
            "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String, String)} with {@code
   * baseUrl}, {@code protocol}, {@code caCertFilePath}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCurlPemCertCommand(String, String, String)"})
  public void testGetCurlPemCertCommandWithBaseUrlProtocolCaCertFilePath() {
    // Arrange and Act
    String actualCurlPemCertCommand =
        DeviceConnectivityUtil.getCurlPemCertCommand(
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Assert
    assertEquals(
        "curl -f -S -o https://example.org/example https://example.org/example/api/device-connectivity/https:"
            + "//example.org/example/certificate/download",
        actualCurlPemCertCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>When {@link DeviceConnectivityUtil#COAPS}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetCoapPublishCommand_givenAccessToken_whenCoaps_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    String actualCoapPublishCommand =
        DeviceConnectivityUtil.getCoapPublishCommand(
            DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

    // Assert
    assertEquals(
        "coap-client-openssl -v 6 -m POST coaps://localhostPort/api/v1/null/telemetry -t json -e"
            + " \"{temperature:25}\"",
        actualCoapPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetCoapPublishCommand_givenX509Certificate_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    String actualCoapPublishCommand =
        DeviceConnectivityUtil.getCoapPublishCommand(
            "Protocol", "localhost", "Port", deviceCredentials);

    // Assert
    assertNull(actualCoapPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()} CredentialsType is {@code
   *       ACCESS_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetCoapPublishCommand_whenDeviceCredentialsCredentialsTypeIsAccessToken() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    String actualCoapPublishCommand =
        DeviceConnectivityUtil.getCoapPublishCommand(
            "Protocol", "localhost", "Port", deviceCredentials);

    // Assert
    assertEquals(
        "coap-client -v 6 -m POST Protocol://localhostPort/api/v1/null/telemetry -t json -e"
            + " \"{temperature:25}\"",
        actualCoapPublishCommand);
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetDockerCoapPublishCommand() throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand =
          DeviceConnectivityUtil.getDockerCoapPublishCommand(
              DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      assertEquals(
          "docker run --rm -it thingsboard/coap-clients coap-client-openssl -v 6 -m POST coaps://localhostPort"
              + "/api/v1/null/telemetry -t json -e \"{temperature:25}\"",
          actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetDockerCoapPublishCommand_givenX509Certificate_thenReturnNull()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

      // Act
      String actualDockerCoapPublishCommand =
          DeviceConnectivityUtil.getDockerCoapPublishCommand(
              DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

      // Assert
      assertNull(actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetDockerCoapPublishCommand_thenCallsIsLoopbackAddress()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand =
          DeviceConnectivityUtil.getDockerCoapPublishCommand(
              DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/coap-clients"
              + " coap-client-openssl -v 6 -m POST coaps://host.docker.internalPort/api/v1/null/telemetry -t json -e"
              + " \"{temperature:25}\"",
          actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String,
   * DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@code coap-client-openssl}.
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String,
   * String, DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"
  })
  public void testGetDockerCoapPublishCommand_whenCoapClientOpenssl_thenCallsIsLoopbackAddress()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      DeviceCredentials deviceCredentials =
          new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand =
          DeviceConnectivityUtil.getDockerCoapPublishCommand(
              "coap-client-openssl", "localhost", "Port", deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/coap-clients coap-client"
              + " -v 6 -m POST coap-client-openssl://host.docker.internalPort/api/v1/null/telemetry -t json -e"
              + " \"{temperature:25}\"",
          actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenEmptyString_whenDeviceConnectivityInfoHostIsEmptyString()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code http://UU^https?://}.
   *   <li>Then return {@code UU^https?://}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenHttpUuHttps_thenReturnUuHttps()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://UU^https?://");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("UU^https?://", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code http://UU}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://UU}.
   *   <li>Then return {@code UU}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenHttpUu_whenDeviceConnectivityInfoHostIsHttpUu_thenReturnUu()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://UU");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("UU", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code http://}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenHttp_whenDeviceConnectivityInfoHostIsHttp_thenReturnEmptyString()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link
   *       UnknownHostException#UnknownHostException()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenInetAddressGetByNameThrowUnknownHostException()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("localhost", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code localhost}.
   *   <li>Then return {@code localhost}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenLocalhost_thenReturnLocalhost()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("localhost", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code null}.
   *   <li>Then return {@code example.org}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenNull_whenDeviceConnectivityInfoHostIsNull_thenReturnExampleOrg()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost(null);
      properties.setPort("Port");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is space.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"
  })
  public void testGetHost_givenSpace_whenDeviceConnectivityInfoHostIsSpace()
      throws URISyntaxException, UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(" ");

      // Act
      String actualHost =
          DeviceConnectivityUtil.getHost(
              "https://example.org/example", properties, DeviceConnectivityUtil.MQTT);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getPort(DeviceConnectivityInfo)"})
  public void testGetPort_givenEmptyString_whenDeviceConnectivityInfoPortIsEmptyString() {
    // Arrange
    DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
    properties.setEnabled(true);
    properties.setHost("localhost");
    properties.setPort("");

    // Act and Assert
    assertEquals("", DeviceConnectivityUtil.getPort(properties));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getPort(DeviceConnectivityInfo)"})
  public void testGetPort_givenNull_whenDeviceConnectivityInfoPortIsNull_thenReturnEmptyString() {
    // Arrange
    DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
    properties.setEnabled(true);
    properties.setHost("localhost");
    properties.setPort(null);

    // Act and Assert
    assertEquals("", DeviceConnectivityUtil.getPort(properties));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   *
   * <ul>
   *   <li>Given {@code Port}.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is {@code Port}.
   *   <li>Then return {@code Port}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getPort(DeviceConnectivityInfo)"})
  public void testGetPort_givenPort_whenDeviceConnectivityInfoPortIsPort_thenReturnPort() {
    // Arrange
    DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
    properties.setEnabled(true);
    properties.setHost("localhost");
    properties.setPort("Port");

    // Act and Assert
    assertEquals("Port", DeviceConnectivityUtil.getPort(properties));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is space.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceConnectivityUtil.getPort(DeviceConnectivityInfo)"})
  public void testGetPort_givenSpace_whenDeviceConnectivityInfoPortIsSpace() {
    // Arrange
    DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
    properties.setEnabled(true);
    properties.setHost("localhost");
    properties.setPort(" ");

    // Act and Assert
    assertEquals("", DeviceConnectivityUtil.getPort(properties));
  }

  /**
   * Test {@link DeviceConnectivityUtil#isLocalhost(String)}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityUtil.isLocalhost(String)"})
  public void testIsLocalhost_givenInetAddressIsLoopbackAddressReturnTrue_thenReturnTrue()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(inetAddress);

      // Act
      boolean actualIsLocalhostResult = DeviceConnectivityUtil.isLocalhost("localhost");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualIsLocalhostResult);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#isLocalhost(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityUtil.isLocalhost(String)"})
  public void testIsLocalhost_thenReturnFalse() throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());

      // Act
      boolean actualIsLocalhostResult = DeviceConnectivityUtil.isLocalhost("localhost");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualIsLocalhostResult);
    }
  }
}
