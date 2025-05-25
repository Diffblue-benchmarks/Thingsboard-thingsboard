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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.device.DeviceConnectivityInfo;

public class DeviceConnectivityUtilDiffblueTest {
  /**
   * Test {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHttpPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetHttpPublishCommand_whenDeviceCredentials_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -v -X POST https://example.org/example://https://example.org/examplehttps://example.org/example"
            + "/api/v1/null/telemetry --header Content-Type:application/json --data \"{temperature:25}\"",
        DeviceConnectivityUtil.getHttpPublishCommand("https://example.org/example", "https://example.org/example",
            "https://example.org/example", new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertEquals(
        "mosquitto_pub -d -q 1 -h localhost -p Port -t Device Telemetry Topic -u \"null\" -m \"{temperature:25}\"",
        DeviceConnectivityUtil.getMqttPublishCommand("Protocol", "localhost", "Port", "Device Telemetry Topic",
            deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenAccessToken_whenEmptyString_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", "",
            "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenAccessToken_whenNull_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", null,
            "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When {@code Port}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenAccessToken_whenPort_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -p Port -t Device Telemetry Topic -u \"null\""
            + " -m \"{temperature:25}\"",
        DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", "Port",
            "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When space.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenAccessToken_whenSpace_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertEquals(
        "mosquitto_pub -d -q 1 --cafile ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m"
            + " \"{temperature:25}\"",
        DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", " ",
            "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenMqttBasic_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", " ",
        "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getMqttPublishCommand(String, String, String, String, DeviceCredentials)"})
  public void testGetMqttPublishCommand_givenX509Certificate() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getMqttPublishCommand("Protocol", "localhost", "Port", "Device Telemetry Topic",
        deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenEmptyString() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code http://UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenHttpUu() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://UU");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code http://}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenHttp_whenDeviceConnectivityInfoHostIsHttp()
      throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code localhost}.</li>
   *   <li>Then return array length is {@code 1245}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenLocalhost_thenReturnArrayLengthIs1245()
      throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return array length is {@code 1220}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenMqttBasic_thenReturnArrayLengthIs1220()
      throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1220, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1220, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenNull_whenDeviceConnectivityInfoHostIsNull()
      throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost(null);
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_givenX509Certificate() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1220, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1220, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Then return array length is {@code 1234}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1234() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(false);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil
          .getGatewayDockerComposeFile("https://example.org/example", properties, deviceCredentials, "Mqtt Type");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1234, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1234, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Then return array length is {@code 1291}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1291() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(" ");

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue = JsonMapper.builder()
          .findAndAddModules()
          .build()
          .writeValueAsString(basicMqttCredentials);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(credentialsValue);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil.getGatewayDockerComposeFile(
          "https://example.org/example", properties, deviceCredentials, DeviceConnectivityUtil.MQTT);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1291, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1291, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()} CredentialsValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource DeviceConnectivityUtil.getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)"})
  public void testGetGatewayDockerComposeFile_whenDeviceCredentialsCredentialsValueIsNull()
      throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(" ");

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(null);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil.getGatewayDockerComposeFile(
          "https://example.org/example", properties, deviceCredentials, DeviceConnectivityUtil.MQTT);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      assertEquals(1245, ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray().length);
      assertEquals(1245, actualGatewayDockerComposeFile.getContentAsByteArray().length);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("mosquitto_pub -d -q 1"));

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(null);

      // Act
      String actualDockerMqttPublishCommand = DeviceConnectivityUtil.getDockerMqttPublishCommand(
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", "", "Device Telemetry Topic",
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
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenInetAddressIsLoopbackAddressReturnFalse()
      throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(false);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(null);

      // Act
      String actualDockerMqttPublishCommand = DeviceConnectivityUtil.getDockerMqttPublishCommand(
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", " ", "Device Telemetry Topic",
          deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals(
          "docker run --rm -it thingsboard/mosquitto-clients /bin/sh -c \"curl -f -S -o ca-root.pem https://example"
              + ".org/example/api/device-connectivity/mqtts/certificate/download && mosquitto_pub -d -q 1 --cafile"
              + " ca-root.pem -h localhost -t Device Telemetry Topic -u \"null\" -m \"{temperature:25}\"\"",
          actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenMqttBasic_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
        "https://example.org/example", "localhost", " ", "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenMqttBasic_whenEmptyString_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
        "https://example.org/example", "localhost", "", "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenMqttBasic_whenNull_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
        "https://example.org/example", "localhost", null, "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>When {@code Port}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenMqttBasic_whenPort_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
        "https://example.org/example", "localhost", "Port", "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_givenX509Certificate() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
      deviceCredentials.setCredentialsValue(null);

      // Act and Assert
      assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
          "https://example.org/example", "localhost", " ", "Device Telemetry Topic", deviceCredentials));
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_thenCallsIsLoopbackAddress() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(null);

      // Act
      String actualDockerMqttPublishCommand = DeviceConnectivityUtil.getDockerMqttPublishCommand(
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", " ", "Device Telemetry Topic",
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
   * Test {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@code mosquitto_pub -d -q 1}.</li>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)"})
  public void testGetDockerMqttPublishCommand_whenMosquittoPubDQ1_thenCallsIsLoopbackAddress()
      throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue(null);

      // Act
      String actualDockerMqttPublishCommand = DeviceConnectivityUtil.getDockerMqttPublishCommand(
          "mosquitto_pub -d -q 1", "https://example.org/example", "localhost", " ", "Device Telemetry Topic",
          deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals("docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/mosquitto-clients"
          + " mosquitto_pub -d -q 1 -h host.docker.internal -t Device Telemetry Topic -u \"null\" -m \"{temperature"
          + ":25}\"", actualDockerMqttPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)} with {@code baseUrl}, {@code protocol}.
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCurlPemCertCommand(String, String)"})
  public void testGetCurlPemCertCommandWithBaseUrlProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/https://example.org"
            + "/example/certificate/download",
        DeviceConnectivityUtil.getCurlPemCertCommand("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String, String)} with {@code baseUrl}, {@code protocol}, {@code caCertFilePath}.
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCurlPemCertCommand(String, String, String)"})
  public void testGetCurlPemCertCommandWithBaseUrlProtocolCaCertFilePath() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -f -S -o https://example.org/example https://example.org/example/api/device-connectivity/https:"
            + "//example.org/example/certificate/download",
        DeviceConnectivityUtil.getCurlPemCertCommand("https://example.org/example", "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetCoapPublishCommand_givenAccessToken_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertEquals(
        "coap-client -v 6 -m POST Protocol://localhostPort/api/v1/null/telemetry -t json -e" + " \"{temperature:25}\"",
        DeviceConnectivityUtil.getCoapPublishCommand("Protocol", "localhost", "Port", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When {@link DeviceConnectivityUtil#COAPS}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetCoapPublishCommand_givenAccessToken_whenCoaps_thenReturnAString() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertEquals(
        "coap-client-openssl -v 6 -m POST coaps://localhostPort/api/v1/null/telemetry -t json -e"
            + " \"{temperature:25}\"",
        DeviceConnectivityUtil.getCoapPublishCommand(DeviceConnectivityUtil.COAPS, "localhost", "Port",
            deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetCoapPublishCommand_givenX509Certificate_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getCoapPublishCommand("Protocol", "localhost", "Port", deviceCredentials));
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetDockerCoapPublishCommand_givenInetAddressIsLoopbackAddressReturnFalse()
      throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(false);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand = DeviceConnectivityUtil
          .getDockerCoapPublishCommand(DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals("docker run --rm -it thingsboard/coap-clients coap-client-openssl -v 6 -m POST coaps://localhostPort"
          + "/api/v1/null/telemetry -t json -e \"{temperature:25}\"", actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetDockerCoapPublishCommand_givenX509Certificate_thenReturnNull() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

      // Act and Assert
      assertNull(DeviceConnectivityUtil.getDockerCoapPublishCommand(DeviceConnectivityUtil.COAPS, "localhost", "Port",
          deviceCredentials));
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetDockerCoapPublishCommand_thenReturnAString() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand = DeviceConnectivityUtil
          .getDockerCoapPublishCommand(DeviceConnectivityUtil.COAPS, "localhost", "Port", deviceCredentials);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).isLoopbackAddress();
      assertEquals("docker run --rm -it --add-host=host.docker.internal:host-gateway thingsboard/coap-clients"
          + " coap-client-openssl -v 6 -m POST coaps://host.docker.internalPort/api/v1/null/telemetry -t json -e"
          + " \"{temperature:25}\"", actualDockerCoapPublishCommand);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@code coap-client-openssl}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String DeviceConnectivityUtil.getDockerCoapPublishCommand(String, String, String, DeviceCredentials)"})
  public void testGetDockerCoapPublishCommand_whenCoapClientOpenssl_thenReturnAString() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

      // Act
      String actualDockerCoapPublishCommand = DeviceConnectivityUtil.getDockerCoapPublishCommand("coap-client-openssl",
          "localhost", "Port", deviceCredentials);

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
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenEmptyString_whenDeviceConnectivityInfoHostIsEmptyString()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("");
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code http://UU}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://UU}.</li>
   *   <li>Then return {@code UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenHttpUu_whenDeviceConnectivityInfoHostIsHttpUu_thenReturnUu()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://UU");
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("UU", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code http://}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code http://}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenHttp_whenDeviceConnectivityInfoHostIsHttp_thenReturnEmptyString()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("http://");
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link UnknownHostException#UnknownHostException(String)} with {@code http://UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenInetAddressGetByNameThrowUnknownHostExceptionWithHttpUu()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("http://UU"));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("localhost", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code localhost}.</li>
   *   <li>Then return {@code localhost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenLocalhost_thenReturnLocalhost() throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost("localhost");
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("localhost", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is {@code null}.</li>
   *   <li>Then return {@code example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenNull_whenDeviceConnectivityInfoHostIsNull_thenReturnExampleOrg()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setHost(null);
      properties.setPort("Port");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties, "Protocol");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceConnectivityUtil.getHost(String, DeviceConnectivityInfo, String)"})
  public void testGetHost_givenSpace_whenDeviceConnectivityInfoHostIsSpace()
      throws URISyntaxException, UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(" ");

      // Act
      String actualHost = DeviceConnectivityUtil.getHost("https://example.org/example", properties,
          DeviceConnectivityUtil.MQTT);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertEquals("example.org", actualHost);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code Port}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is {@code Port}.</li>
   *   <li>Then return {@code Port}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link UnknownHostException#UnknownHostException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityUtil.isLocalhost(String)"})
  public void testIsLocalhost_givenInetAddressGetByNameThrowUnknownHostExceptionWithFoo() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("foo"));

      // Act
      boolean actualIsLocalhostResult = DeviceConnectivityUtil.isLocalhost("localhost");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualIsLocalhostResult);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#isLocalhost(String)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityUtil.isLocalhost(String)"})
  public void testIsLocalhost_givenInetAddressIsLoopbackAddressReturnFalse_thenReturnFalse()
      throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(false);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      // Act
      boolean actualIsLocalhostResult = DeviceConnectivityUtil.isLocalhost("localhost");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(inetAddress).isLoopbackAddress();
      assertFalse(actualIsLocalhostResult);
    }
  }

  /**
   * Test {@link DeviceConnectivityUtil#isLocalhost(String)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityUtil.isLocalhost(String)"})
  public void testIsLocalhost_givenInetAddressIsLoopbackAddressReturnTrue_thenReturnTrue() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      // Act
      boolean actualIsLocalhostResult = DeviceConnectivityUtil.isLocalhost("localhost");

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(inetAddress).isLoopbackAddress();
      assertTrue(actualIsLocalhostResult);
    }
  }
}
