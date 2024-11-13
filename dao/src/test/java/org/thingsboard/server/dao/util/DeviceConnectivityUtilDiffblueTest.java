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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import org.junit.Test;
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
   * Test
   * {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHttpPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetHttpPublishCommand_whenDeviceCredentials_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -v -X POST https://example.org/example://https://example.org/examplehttps://example.org/example"
            + "/api/v1/null/telemetry --header Content-Type:application/json --data \"{temperature:25}\"",
        DeviceConnectivityUtil.getHttpPublishCommand("https://example.org/example", "https://example.org/example",
            "https://example.org/example", new DeviceCredentials()));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetMqttPublishCommand_givenAccessToken_thenReturnAString() {
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
   * Test
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetMqttPublishCommand_givenMqttBasic_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", null,
        "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getMqttPublishCommand(String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetMqttPublishCommand_givenX509Certificate() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getMqttPublishCommand(DeviceConnectivityUtil.MQTTS, "localhost", null,
        "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1245, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1245, contentAsByteArray.length);
      assertEquals(' ', byteArray[1220]);
      assertEquals(' ', byteArray[1221]);
      assertEquals(' ', byteArray[1227]);
      assertEquals(' ', contentAsByteArray[1220]);
      assertEquals(' ', contentAsByteArray[1221]);
      assertEquals(' ', contentAsByteArray[1227]);
      assertEquals('-', byteArray[1230]);
      assertEquals('-', byteArray[1233]);
      assertEquals('-', contentAsByteArray[1230]);
      assertEquals('-', contentAsByteArray[1233]);
      assertEquals(':', byteArray[1226]);
      assertEquals(':', contentAsByteArray[1226]);
      assertEquals('\n', byteArray[1244]);
      assertEquals('\n', contentAsByteArray[1244]);
      assertEquals('a', byteArray[1223]);
      assertEquals('a', contentAsByteArray[1223]);
      assertEquals('b', byteArray[1229]);
      assertEquals('b', contentAsByteArray[1229]);
      assertEquals('e', byteArray[1225]);
      assertEquals('e', byteArray[1234]);
      assertEquals('e', byteArray[1237]);
      assertEquals('e', contentAsByteArray[1225]);
      assertEquals('e', contentAsByteArray[1234]);
      assertEquals('e', contentAsByteArray[1237]);
      assertEquals('g', byteArray[1231]);
      assertEquals('g', contentAsByteArray[1231]);
      assertEquals('i', byteArray[1240]);
      assertEquals('i', contentAsByteArray[1240]);
      assertEquals('m', byteArray[1224]);
      assertEquals('m', contentAsByteArray[1224]);
      assertEquals('n', byteArray[1222]);
      assertEquals('n', byteArray[1238]);
      assertEquals('n', byteArray[1242]);
      assertEquals('n', contentAsByteArray[1222]);
      assertEquals('n', contentAsByteArray[1238]);
      assertEquals('n', contentAsByteArray[1242]);
      assertEquals('o', byteArray[1241]);
      assertEquals('o', contentAsByteArray[1241]);
      assertEquals('s', byteArray[1239]);
      assertEquals('s', byteArray[1243]);
      assertEquals('s', contentAsByteArray[1239]);
      assertEquals('s', contentAsByteArray[1243]);
      assertEquals('t', byteArray[1228]);
      assertEquals('t', byteArray[1236]);
      assertEquals('t', contentAsByteArray[1228]);
      assertEquals('t', contentAsByteArray[1236]);
      assertEquals('w', byteArray[1232]);
      assertEquals('w', contentAsByteArray[1232]);
      assertEquals('x', byteArray[1235]);
      assertEquals('x', contentAsByteArray[1235]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code http://UU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1245, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1245, contentAsByteArray.length);
      assertEquals(' ', byteArray[1220]);
      assertEquals(' ', byteArray[1221]);
      assertEquals(' ', byteArray[1227]);
      assertEquals(' ', contentAsByteArray[1220]);
      assertEquals(' ', contentAsByteArray[1221]);
      assertEquals(' ', contentAsByteArray[1227]);
      assertEquals('-', byteArray[1230]);
      assertEquals('-', byteArray[1233]);
      assertEquals('-', contentAsByteArray[1230]);
      assertEquals('-', contentAsByteArray[1233]);
      assertEquals(':', byteArray[1226]);
      assertEquals(':', contentAsByteArray[1226]);
      assertEquals('\n', byteArray[1244]);
      assertEquals('\n', contentAsByteArray[1244]);
      assertEquals('a', byteArray[1223]);
      assertEquals('a', contentAsByteArray[1223]);
      assertEquals('b', byteArray[1229]);
      assertEquals('b', contentAsByteArray[1229]);
      assertEquals('e', byteArray[1225]);
      assertEquals('e', byteArray[1234]);
      assertEquals('e', byteArray[1237]);
      assertEquals('e', contentAsByteArray[1225]);
      assertEquals('e', contentAsByteArray[1234]);
      assertEquals('e', contentAsByteArray[1237]);
      assertEquals('g', byteArray[1231]);
      assertEquals('g', contentAsByteArray[1231]);
      assertEquals('i', byteArray[1240]);
      assertEquals('i', contentAsByteArray[1240]);
      assertEquals('m', byteArray[1224]);
      assertEquals('m', contentAsByteArray[1224]);
      assertEquals('n', byteArray[1222]);
      assertEquals('n', byteArray[1238]);
      assertEquals('n', byteArray[1242]);
      assertEquals('n', contentAsByteArray[1222]);
      assertEquals('n', contentAsByteArray[1238]);
      assertEquals('n', contentAsByteArray[1242]);
      assertEquals('o', byteArray[1241]);
      assertEquals('o', contentAsByteArray[1241]);
      assertEquals('s', byteArray[1239]);
      assertEquals('s', byteArray[1243]);
      assertEquals('s', contentAsByteArray[1239]);
      assertEquals('s', contentAsByteArray[1243]);
      assertEquals('t', byteArray[1228]);
      assertEquals('t', byteArray[1236]);
      assertEquals('t', contentAsByteArray[1228]);
      assertEquals('t', contentAsByteArray[1236]);
      assertEquals('w', byteArray[1232]);
      assertEquals('w', contentAsByteArray[1232]);
      assertEquals('x', byteArray[1235]);
      assertEquals('x', contentAsByteArray[1235]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code http://}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is
   * {@code http://}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1245, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1245, contentAsByteArray.length);
      assertEquals(' ', byteArray[1220]);
      assertEquals(' ', byteArray[1221]);
      assertEquals(' ', byteArray[1227]);
      assertEquals(' ', contentAsByteArray[1220]);
      assertEquals(' ', contentAsByteArray[1221]);
      assertEquals(' ', contentAsByteArray[1227]);
      assertEquals('-', byteArray[1230]);
      assertEquals('-', byteArray[1233]);
      assertEquals('-', contentAsByteArray[1230]);
      assertEquals('-', contentAsByteArray[1233]);
      assertEquals(':', byteArray[1226]);
      assertEquals(':', contentAsByteArray[1226]);
      assertEquals('\n', byteArray[1244]);
      assertEquals('\n', contentAsByteArray[1244]);
      assertEquals('a', byteArray[1223]);
      assertEquals('a', contentAsByteArray[1223]);
      assertEquals('b', byteArray[1229]);
      assertEquals('b', contentAsByteArray[1229]);
      assertEquals('e', byteArray[1225]);
      assertEquals('e', byteArray[1234]);
      assertEquals('e', byteArray[1237]);
      assertEquals('e', contentAsByteArray[1225]);
      assertEquals('e', contentAsByteArray[1234]);
      assertEquals('e', contentAsByteArray[1237]);
      assertEquals('g', byteArray[1231]);
      assertEquals('g', contentAsByteArray[1231]);
      assertEquals('i', byteArray[1240]);
      assertEquals('i', contentAsByteArray[1240]);
      assertEquals('m', byteArray[1224]);
      assertEquals('m', contentAsByteArray[1224]);
      assertEquals('n', byteArray[1222]);
      assertEquals('n', byteArray[1238]);
      assertEquals('n', byteArray[1242]);
      assertEquals('n', contentAsByteArray[1222]);
      assertEquals('n', contentAsByteArray[1238]);
      assertEquals('n', contentAsByteArray[1242]);
      assertEquals('o', byteArray[1241]);
      assertEquals('o', contentAsByteArray[1241]);
      assertEquals('s', byteArray[1239]);
      assertEquals('s', byteArray[1243]);
      assertEquals('s', contentAsByteArray[1239]);
      assertEquals('s', contentAsByteArray[1243]);
      assertEquals('t', byteArray[1228]);
      assertEquals('t', byteArray[1236]);
      assertEquals('t', contentAsByteArray[1228]);
      assertEquals('t', contentAsByteArray[1236]);
      assertEquals('w', byteArray[1232]);
      assertEquals('w', contentAsByteArray[1232]);
      assertEquals('x', byteArray[1235]);
      assertEquals('x', contentAsByteArray[1235]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code localhost}.</li>
   *   <li>Then return array length is {@code 1245}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1245, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1245, contentAsByteArray.length);
      assertEquals(' ', byteArray[1220]);
      assertEquals(' ', byteArray[1221]);
      assertEquals(' ', byteArray[1227]);
      assertEquals(' ', contentAsByteArray[1220]);
      assertEquals(' ', contentAsByteArray[1221]);
      assertEquals(' ', contentAsByteArray[1227]);
      assertEquals('-', byteArray[1230]);
      assertEquals('-', byteArray[1233]);
      assertEquals('-', contentAsByteArray[1230]);
      assertEquals('-', contentAsByteArray[1233]);
      assertEquals(':', byteArray[1226]);
      assertEquals(':', contentAsByteArray[1226]);
      assertEquals('\n', byteArray[1244]);
      assertEquals('\n', contentAsByteArray[1244]);
      assertEquals('a', byteArray[1223]);
      assertEquals('a', contentAsByteArray[1223]);
      assertEquals('b', byteArray[1229]);
      assertEquals('b', contentAsByteArray[1229]);
      assertEquals('e', byteArray[1225]);
      assertEquals('e', byteArray[1234]);
      assertEquals('e', byteArray[1237]);
      assertEquals('e', contentAsByteArray[1225]);
      assertEquals('e', contentAsByteArray[1234]);
      assertEquals('e', contentAsByteArray[1237]);
      assertEquals('g', byteArray[1231]);
      assertEquals('g', contentAsByteArray[1231]);
      assertEquals('i', byteArray[1240]);
      assertEquals('i', contentAsByteArray[1240]);
      assertEquals('m', byteArray[1224]);
      assertEquals('m', contentAsByteArray[1224]);
      assertEquals('n', byteArray[1222]);
      assertEquals('n', byteArray[1238]);
      assertEquals('n', byteArray[1242]);
      assertEquals('n', contentAsByteArray[1222]);
      assertEquals('n', contentAsByteArray[1238]);
      assertEquals('n', contentAsByteArray[1242]);
      assertEquals('o', byteArray[1241]);
      assertEquals('o', contentAsByteArray[1241]);
      assertEquals('s', byteArray[1239]);
      assertEquals('s', byteArray[1243]);
      assertEquals('s', contentAsByteArray[1239]);
      assertEquals('s', contentAsByteArray[1243]);
      assertEquals('t', byteArray[1228]);
      assertEquals('t', byteArray[1236]);
      assertEquals('t', contentAsByteArray[1228]);
      assertEquals('t', contentAsByteArray[1236]);
      assertEquals('w', byteArray[1232]);
      assertEquals('w', contentAsByteArray[1232]);
      assertEquals('x', byteArray[1235]);
      assertEquals('x', contentAsByteArray[1235]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return array length is {@code 1220}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1220, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1220, contentAsByteArray.length);
      assertEquals(' ', byteArray[1195]);
      assertEquals(' ', byteArray[1196]);
      assertEquals(' ', byteArray[1202]);
      assertEquals(' ', contentAsByteArray[1195]);
      assertEquals(' ', contentAsByteArray[1196]);
      assertEquals(' ', contentAsByteArray[1202]);
      assertEquals('-', byteArray[1205]);
      assertEquals('-', byteArray[1208]);
      assertEquals('-', contentAsByteArray[1205]);
      assertEquals('-', contentAsByteArray[1208]);
      assertEquals(':', byteArray[1201]);
      assertEquals(':', contentAsByteArray[1201]);
      assertEquals('\n', byteArray[1219]);
      assertEquals('\n', contentAsByteArray[1219]);
      assertEquals('a', byteArray[1198]);
      assertEquals('a', contentAsByteArray[1198]);
      assertEquals('b', byteArray[1204]);
      assertEquals('b', contentAsByteArray[1204]);
      assertEquals('e', byteArray[1209]);
      assertEquals('e', byteArray[1212]);
      assertEquals('e', contentAsByteArray[1209]);
      assertEquals('e', contentAsByteArray[1212]);
      assertEquals('g', byteArray[1206]);
      assertEquals('g', contentAsByteArray[1206]);
      assertEquals('i', byteArray[1215]);
      assertEquals('i', contentAsByteArray[1215]);
      assertEquals('m', byteArray[1199]);
      assertEquals('m', contentAsByteArray[1199]);
      assertEquals('n', byteArray[1197]);
      assertEquals('n', byteArray[1213]);
      assertEquals('n', byteArray[1217]);
      assertEquals('n', contentAsByteArray[1197]);
      assertEquals('n', contentAsByteArray[1213]);
      assertEquals('n', contentAsByteArray[1217]);
      assertEquals('o', byteArray[1216]);
      assertEquals('o', contentAsByteArray[1216]);
      assertEquals('s', byteArray[1214]);
      assertEquals('s', byteArray[1218]);
      assertEquals('s', contentAsByteArray[1214]);
      assertEquals('s', contentAsByteArray[1218]);
      assertEquals('t', byteArray[1203]);
      assertEquals('t', byteArray[1211]);
      assertEquals('t', contentAsByteArray[1203]);
      assertEquals('t', contentAsByteArray[1211]);
      assertEquals('w', byteArray[1207]);
      assertEquals('w', contentAsByteArray[1207]);
      assertEquals('x', byteArray[1210]);
      assertEquals('x', contentAsByteArray[1210]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return array length is {@code 1245}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  public void testGetGatewayDockerComposeFile_givenNull_thenReturnArrayLengthIs1245()
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1245, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1245, contentAsByteArray.length);
      assertEquals(' ', byteArray[1220]);
      assertEquals(' ', byteArray[1221]);
      assertEquals(' ', byteArray[1227]);
      assertEquals(' ', contentAsByteArray[1220]);
      assertEquals(' ', contentAsByteArray[1221]);
      assertEquals(' ', contentAsByteArray[1227]);
      assertEquals('-', byteArray[1230]);
      assertEquals('-', byteArray[1233]);
      assertEquals('-', contentAsByteArray[1230]);
      assertEquals('-', contentAsByteArray[1233]);
      assertEquals(':', byteArray[1226]);
      assertEquals(':', contentAsByteArray[1226]);
      assertEquals('\n', byteArray[1244]);
      assertEquals('\n', contentAsByteArray[1244]);
      assertEquals('a', byteArray[1223]);
      assertEquals('a', contentAsByteArray[1223]);
      assertEquals('b', byteArray[1229]);
      assertEquals('b', contentAsByteArray[1229]);
      assertEquals('e', byteArray[1225]);
      assertEquals('e', byteArray[1234]);
      assertEquals('e', byteArray[1237]);
      assertEquals('e', contentAsByteArray[1225]);
      assertEquals('e', contentAsByteArray[1234]);
      assertEquals('e', contentAsByteArray[1237]);
      assertEquals('g', byteArray[1231]);
      assertEquals('g', contentAsByteArray[1231]);
      assertEquals('i', byteArray[1240]);
      assertEquals('i', contentAsByteArray[1240]);
      assertEquals('m', byteArray[1224]);
      assertEquals('m', contentAsByteArray[1224]);
      assertEquals('n', byteArray[1222]);
      assertEquals('n', byteArray[1238]);
      assertEquals('n', byteArray[1242]);
      assertEquals('n', contentAsByteArray[1222]);
      assertEquals('n', contentAsByteArray[1238]);
      assertEquals('n', contentAsByteArray[1242]);
      assertEquals('o', byteArray[1241]);
      assertEquals('o', contentAsByteArray[1241]);
      assertEquals('s', byteArray[1239]);
      assertEquals('s', byteArray[1243]);
      assertEquals('s', contentAsByteArray[1239]);
      assertEquals('s', contentAsByteArray[1243]);
      assertEquals('t', byteArray[1228]);
      assertEquals('t', byteArray[1236]);
      assertEquals('t', contentAsByteArray[1228]);
      assertEquals('t', contentAsByteArray[1236]);
      assertEquals('w', byteArray[1232]);
      assertEquals('w', contentAsByteArray[1232]);
      assertEquals('x', byteArray[1235]);
      assertEquals('x', contentAsByteArray[1235]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1220, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1220, contentAsByteArray.length);
      assertEquals(' ', byteArray[1195]);
      assertEquals(' ', byteArray[1196]);
      assertEquals(' ', byteArray[1202]);
      assertEquals(' ', contentAsByteArray[1195]);
      assertEquals(' ', contentAsByteArray[1196]);
      assertEquals(' ', contentAsByteArray[1202]);
      assertEquals('-', byteArray[1205]);
      assertEquals('-', byteArray[1208]);
      assertEquals('-', contentAsByteArray[1205]);
      assertEquals('-', contentAsByteArray[1208]);
      assertEquals(':', byteArray[1201]);
      assertEquals(':', contentAsByteArray[1201]);
      assertEquals('\n', byteArray[1219]);
      assertEquals('\n', contentAsByteArray[1219]);
      assertEquals('a', byteArray[1198]);
      assertEquals('a', contentAsByteArray[1198]);
      assertEquals('b', byteArray[1204]);
      assertEquals('b', contentAsByteArray[1204]);
      assertEquals('e', byteArray[1209]);
      assertEquals('e', byteArray[1212]);
      assertEquals('e', contentAsByteArray[1209]);
      assertEquals('e', contentAsByteArray[1212]);
      assertEquals('g', byteArray[1206]);
      assertEquals('g', contentAsByteArray[1206]);
      assertEquals('i', byteArray[1215]);
      assertEquals('i', contentAsByteArray[1215]);
      assertEquals('m', byteArray[1199]);
      assertEquals('m', contentAsByteArray[1199]);
      assertEquals('n', byteArray[1197]);
      assertEquals('n', byteArray[1213]);
      assertEquals('n', byteArray[1217]);
      assertEquals('n', contentAsByteArray[1197]);
      assertEquals('n', contentAsByteArray[1213]);
      assertEquals('n', contentAsByteArray[1217]);
      assertEquals('o', byteArray[1216]);
      assertEquals('o', contentAsByteArray[1216]);
      assertEquals('s', byteArray[1214]);
      assertEquals('s', byteArray[1218]);
      assertEquals('s', contentAsByteArray[1214]);
      assertEquals('s', contentAsByteArray[1218]);
      assertEquals('t', byteArray[1203]);
      assertEquals('t', byteArray[1211]);
      assertEquals('t', contentAsByteArray[1203]);
      assertEquals('t', contentAsByteArray[1211]);
      assertEquals('w', byteArray[1207]);
      assertEquals('w', contentAsByteArray[1207]);
      assertEquals('x', byteArray[1210]);
      assertEquals('x', contentAsByteArray[1210]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Then return array length is {@code 1211}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1211() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("http://UU"));

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(null);

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
      deviceCredentials.setCredentialsValue(null);

      // Act
      Resource actualGatewayDockerComposeFile = DeviceConnectivityUtil.getGatewayDockerComposeFile(
          "https://example.org/example", properties, deviceCredentials, DeviceConnectivityUtil.MQTT);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      assertTrue(actualGatewayDockerComposeFile instanceof ByteArrayResource);
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1211, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1211, contentAsByteArray.length);
      assertEquals(' ', byteArray[1186]);
      assertEquals(' ', byteArray[1187]);
      assertEquals(' ', byteArray[1193]);
      assertEquals(' ', contentAsByteArray[1186]);
      assertEquals(' ', contentAsByteArray[1187]);
      assertEquals(' ', contentAsByteArray[1193]);
      assertEquals('-', byteArray[1196]);
      assertEquals('-', byteArray[1199]);
      assertEquals('-', contentAsByteArray[1196]);
      assertEquals('-', contentAsByteArray[1199]);
      assertEquals(':', byteArray[1192]);
      assertEquals(':', contentAsByteArray[1192]);
      assertEquals('\n', byteArray[1210]);
      assertEquals('\n', contentAsByteArray[1210]);
      assertEquals('a', byteArray[1189]);
      assertEquals('a', contentAsByteArray[1189]);
      assertEquals('b', byteArray[1195]);
      assertEquals('b', contentAsByteArray[1195]);
      assertEquals('e', byteArray[1191]);
      assertEquals('e', byteArray[1203]);
      assertEquals('e', contentAsByteArray[1191]);
      assertEquals('e', contentAsByteArray[1203]);
      assertEquals('g', byteArray[1197]);
      assertEquals('g', contentAsByteArray[1197]);
      assertEquals('i', byteArray[1206]);
      assertEquals('i', contentAsByteArray[1206]);
      assertEquals('m', byteArray[1190]);
      assertEquals('m', contentAsByteArray[1190]);
      assertEquals('n', byteArray[1188]);
      assertEquals('n', byteArray[1204]);
      assertEquals('n', byteArray[1208]);
      assertEquals('n', contentAsByteArray[1188]);
      assertEquals('n', contentAsByteArray[1204]);
      assertEquals('n', contentAsByteArray[1208]);
      assertEquals('o', byteArray[1207]);
      assertEquals('o', contentAsByteArray[1207]);
      assertEquals('s', byteArray[1205]);
      assertEquals('s', byteArray[1209]);
      assertEquals('s', contentAsByteArray[1205]);
      assertEquals('s', contentAsByteArray[1209]);
      assertEquals('t', byteArray[1194]);
      assertEquals('t', byteArray[1202]);
      assertEquals('t', contentAsByteArray[1194]);
      assertEquals('t', contentAsByteArray[1202]);
      assertEquals('w', byteArray[1198]);
      assertEquals('w', contentAsByteArray[1198]);
      assertEquals('x', byteArray[1201]);
      assertEquals('x', contentAsByteArray[1201]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Then return array length is {@code 1234}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1234, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1234, contentAsByteArray.length);
      assertEquals(' ', byteArray[1209]);
      assertEquals(' ', byteArray[1210]);
      assertEquals(' ', byteArray[1216]);
      assertEquals(' ', contentAsByteArray[1209]);
      assertEquals(' ', contentAsByteArray[1210]);
      assertEquals(' ', contentAsByteArray[1216]);
      assertEquals('-', byteArray[1219]);
      assertEquals('-', byteArray[1222]);
      assertEquals('-', contentAsByteArray[1219]);
      assertEquals('-', contentAsByteArray[1222]);
      assertEquals(':', byteArray[1215]);
      assertEquals(':', contentAsByteArray[1215]);
      assertEquals('\n', byteArray[1233]);
      assertEquals('\n', contentAsByteArray[1233]);
      assertEquals('a', byteArray[1212]);
      assertEquals('a', contentAsByteArray[1212]);
      assertEquals('b', byteArray[1218]);
      assertEquals('b', contentAsByteArray[1218]);
      assertEquals('e', byteArray[1214]);
      assertEquals('e', byteArray[1223]);
      assertEquals('e', byteArray[1226]);
      assertEquals('e', contentAsByteArray[1214]);
      assertEquals('e', contentAsByteArray[1223]);
      assertEquals('e', contentAsByteArray[1226]);
      assertEquals('g', byteArray[1220]);
      assertEquals('g', contentAsByteArray[1220]);
      assertEquals('i', byteArray[1229]);
      assertEquals('i', contentAsByteArray[1229]);
      assertEquals('m', byteArray[1213]);
      assertEquals('m', contentAsByteArray[1213]);
      assertEquals('n', byteArray[1211]);
      assertEquals('n', byteArray[1227]);
      assertEquals('n', byteArray[1231]);
      assertEquals('n', contentAsByteArray[1211]);
      assertEquals('n', contentAsByteArray[1227]);
      assertEquals('n', contentAsByteArray[1231]);
      assertEquals('o', byteArray[1230]);
      assertEquals('o', contentAsByteArray[1230]);
      assertEquals('s', byteArray[1228]);
      assertEquals('s', byteArray[1232]);
      assertEquals('s', contentAsByteArray[1228]);
      assertEquals('s', contentAsByteArray[1232]);
      assertEquals('t', byteArray[1217]);
      assertEquals('t', byteArray[1225]);
      assertEquals('t', contentAsByteArray[1217]);
      assertEquals('t', contentAsByteArray[1225]);
      assertEquals('w', byteArray[1221]);
      assertEquals('w', contentAsByteArray[1221]);
      assertEquals('x', byteArray[1224]);
      assertEquals('x', contentAsByteArray[1224]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}.
   * <ul>
   *   <li>Then return array length is {@code 1291}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getGatewayDockerComposeFile(String, DeviceConnectivityInfo, DeviceCredentials, String)}
   */
  @Test
  public void testGetGatewayDockerComposeFile_thenReturnArrayLengthIs1291() throws IOException, URISyntaxException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenReturn(true);
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);

      DeviceConnectivityInfo properties = new DeviceConnectivityInfo();
      properties.setEnabled(true);
      properties.setPort("Port");
      properties.setHost(null);

      BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
      basicMqttCredentials.setClientId("42");
      basicMqttCredentials.setPassword("iloveyou");
      basicMqttCredentials.setUserName("janedoe");
      String credentialsValue = (new ObjectMapper()).writeValueAsString(basicMqttCredentials);

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
      byte[] byteArray = ((ByteArrayResource) actualGatewayDockerComposeFile).getByteArray();
      assertEquals(1291, byteArray.length);
      byte[] contentAsByteArray = actualGatewayDockerComposeFile.getContentAsByteArray();
      assertEquals(1291, contentAsByteArray.length);
      assertEquals(' ', byteArray[1266]);
      assertEquals(' ', byteArray[1267]);
      assertEquals(' ', byteArray[1273]);
      assertEquals(' ', contentAsByteArray[1266]);
      assertEquals(' ', contentAsByteArray[1267]);
      assertEquals(' ', contentAsByteArray[1273]);
      assertEquals('-', byteArray[1276]);
      assertEquals('-', byteArray[1279]);
      assertEquals('-', contentAsByteArray[1276]);
      assertEquals('-', contentAsByteArray[1279]);
      assertEquals(':', byteArray[1272]);
      assertEquals(':', contentAsByteArray[1272]);
      assertEquals('\n', byteArray[1290]);
      assertEquals('\n', contentAsByteArray[1290]);
      assertEquals('a', byteArray[1269]);
      assertEquals('a', contentAsByteArray[1269]);
      assertEquals('b', byteArray[1275]);
      assertEquals('b', contentAsByteArray[1275]);
      assertEquals('e', byteArray[1271]);
      assertEquals('e', byteArray[1280]);
      assertEquals('e', byteArray[1283]);
      assertEquals('e', contentAsByteArray[1271]);
      assertEquals('e', contentAsByteArray[1280]);
      assertEquals('e', contentAsByteArray[1283]);
      assertEquals('g', byteArray[1277]);
      assertEquals('g', contentAsByteArray[1277]);
      assertEquals('i', byteArray[1286]);
      assertEquals('i', contentAsByteArray[1286]);
      assertEquals('m', byteArray[1270]);
      assertEquals('m', contentAsByteArray[1270]);
      assertEquals('n', byteArray[1268]);
      assertEquals('n', byteArray[1284]);
      assertEquals('n', byteArray[1288]);
      assertEquals('n', contentAsByteArray[1268]);
      assertEquals('n', contentAsByteArray[1284]);
      assertEquals('n', contentAsByteArray[1288]);
      assertEquals('o', byteArray[1287]);
      assertEquals('o', contentAsByteArray[1287]);
      assertEquals('s', byteArray[1285]);
      assertEquals('s', byteArray[1289]);
      assertEquals('s', contentAsByteArray[1285]);
      assertEquals('s', contentAsByteArray[1289]);
      assertEquals('t', byteArray[1274]);
      assertEquals('t', byteArray[1282]);
      assertEquals('t', contentAsByteArray[1274]);
      assertEquals('t', contentAsByteArray[1282]);
      assertEquals('w', byteArray[1278]);
      assertEquals('w', contentAsByteArray[1278]);
      assertEquals('x', byteArray[1281]);
      assertEquals('x', contentAsByteArray[1281]);
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetDockerMqttPublishCommand() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("mosquitto_pub -d -q 1"));

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
      deviceCredentials.setCredentialsValue("Device Credentials");

      // Act
      String actualDockerMqttPublishCommand = DeviceConnectivityUtil.getDockerMqttPublishCommand(
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", null, "Device Telemetry Topic",
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
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
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", null, "Device Telemetry Topic",
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetDockerMqttPublishCommand_givenMqttBasic_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
        "https://example.org/example", "localhost", null, "Device Telemetry Topic", deviceCredentials));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetDockerMqttPublishCommand_givenX509Certificate() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      DeviceCredentials deviceCredentials = new DeviceCredentials();
      deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
      deviceCredentials.setCredentialsValue(null);

      // Act and Assert
      assertNull(DeviceConnectivityUtil.getDockerMqttPublishCommand(DeviceConnectivityUtil.MQTTS,
          "https://example.org/example", "localhost", null, "Device Telemetry Topic", deviceCredentials));
    }
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
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
          DeviceConnectivityUtil.MQTTS, "https://example.org/example", "localhost", null, "Device Telemetry Topic",
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@code mosquitto_pub -d -q 1}.</li>
   *   <li>Then calls {@link InetAddress#isLoopbackAddress()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerMqttPublishCommand(String, String, String, String, String, DeviceCredentials)}
   */
  @Test
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
          "mosquitto_pub -d -q 1", "https://example.org/example", "localhost", null, "Device Telemetry Topic",
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
   * Test {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)}
   * with {@code baseUrl}, {@code protocol}.
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String)}
   */
  @Test
  public void testGetCurlPemCertCommandWithBaseUrlProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -f -S -o ca-root.pem https://example.org/example/api/device-connectivity/https://example.org"
            + "/example/certificate/download",
        DeviceConnectivityUtil.getCurlPemCertCommand("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String, String)}
   * with {@code baseUrl}, {@code protocol}, {@code caCertFilePath}.
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getCurlPemCertCommand(String, String, String)}
   */
  @Test
  public void testGetCurlPemCertCommandWithBaseUrlProtocolCaCertFilePath() {
    // Arrange, Act and Assert
    assertEquals(
        "curl -f -S -o https://example.org/example https://example.org/example/api/device-connectivity/https:"
            + "//example.org/example/certificate/download",
        DeviceConnectivityUtil.getCurlPemCertCommand("https://example.org/example", "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>When {@link DeviceConnectivityUtil#COAPS}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
  public void testGetCoapPublishCommand_givenX509Certificate_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertNull(DeviceConnectivityUtil.getCoapPublishCommand("Protocol", "localhost", "Port", deviceCredentials));
  }

  /**
   * Test
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}.
   * <ul>
   *   <li>When {@code coap-client-openssl}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getDockerCoapPublishCommand(String, String, String, DeviceCredentials)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code http://UU}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is
   * {@code http://UU}.</li>
   *   <li>Then return {@code UU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code http://}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is
   * {@code http://}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw
   * {@link UnknownHostException#UnknownHostException(String)} with
   * {@code http://UU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code localhost}.</li>
   *   <li>Then return {@code localhost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Host is
   * {@code null}.</li>
   *   <li>Then return {@code example.org}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getHost(String, DeviceConnectivityInfo, String)}
   */
  @Test
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
   * Test {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
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
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is
   * {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
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
   *   <li>When {@link DeviceConnectivityInfo} (default constructor) Port is
   * {@code Port}.</li>
   *   <li>Then return {@code Port}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityUtil#getPort(DeviceConnectivityInfo)}
   */
  @Test
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
   * Test {@link DeviceConnectivityUtil#isLocalhost(String)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw
   * {@link UnknownHostException#UnknownHostException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
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
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
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
   *   <li>Given {@link InetAddress} {@link InetAddress#isLoopbackAddress()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityUtil#isLocalhost(String)}
   */
  @Test
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
