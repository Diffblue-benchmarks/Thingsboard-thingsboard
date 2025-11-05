package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.handler.ssl.JdkSslClientContext;
import io.netty.handler.ssl.SslContext;
import javax.net.ssl.SSLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttClientConfigDiffblueTest {
  /**
   * Test {@link MqttClientConfig#MqttClientConfig()}.
   *
   * <p>Method under test: {@link MqttClientConfig#MqttClientConfig()}
   */
  @Test
  @DisplayName("Test new MqttClientConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.<init>()"})
  void testNewMqttClientConfig() {
    // Arrange and Act
    MqttClientConfig actualMqttClientConfig = new MqttClientConfig();

    // Assert
    assertNull(actualMqttClientConfig.getSslContext());
    assertNull(actualMqttClientConfig.getOwnerId());
    assertNull(actualMqttClientConfig.getPassword());
    assertNull(actualMqttClientConfig.getUsername());
    assertNull(actualMqttClientConfig.getLastWill());
    assertEquals(1L, actualMqttClientConfig.getReconnectDelay());
    assertEquals(60, actualMqttClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualMqttClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualMqttClientConfig.getProtocolVersion());
    assertTrue(actualMqttClientConfig.isCleanSession());
    assertTrue(actualMqttClientConfig.isReconnect());
    Class<NioSocketChannel> expectedChannelClass = NioSocketChannel.class;
    assertEquals(expectedChannelClass, actualMqttClientConfig.getChannelClass());
  }

  /**
   * Test {@link MqttClientConfig#MqttClientConfig(SslContext)}.
   *
   * <p>Method under test: {@link MqttClientConfig#MqttClientConfig(SslContext)}
   */
  @Test
  @DisplayName("Test new MqttClientConfig(SslContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.<init>(SslContext)"})
  void testNewMqttClientConfig2() throws SSLException {
    // Arrange
    JdkSslClientContext sslContext = new JdkSslClientContext();

    // Act
    MqttClientConfig actualMqttClientConfig = new MqttClientConfig(sslContext);

    // Assert
    SslContext sslContext2 = actualMqttClientConfig.getSslContext();
    assertTrue(sslContext2 instanceof JdkSslClientContext);
    assertNull(actualMqttClientConfig.getOwnerId());
    assertNull(actualMqttClientConfig.getPassword());
    assertNull(actualMqttClientConfig.getUsername());
    assertNull(actualMqttClientConfig.getLastWill());
    assertEquals(1L, actualMqttClientConfig.getReconnectDelay());
    assertEquals(60, actualMqttClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualMqttClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualMqttClientConfig.getProtocolVersion());
    assertTrue(actualMqttClientConfig.isCleanSession());
    assertTrue(actualMqttClientConfig.isReconnect());
    Class<NioSocketChannel> expectedChannelClass = NioSocketChannel.class;
    assertEquals(expectedChannelClass, actualMqttClientConfig.getChannelClass());
    assertSame(sslContext, sslContext2);
  }

  /**
   * Test {@link MqttClientConfig#setClientId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link MqttClientConfig#MqttClientConfig()} ClientId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setClientId(String)}
   */
  @Test
  @DisplayName("Test setClientId(String); when '42'; then MqttClientConfig() ClientId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setClientId(String)"})
  void testSetClientId_when42_thenMqttClientConfigClientIdIs42() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setClientId("42");

    // Assert
    assertEquals("42", mqttClientConfig.getClientId());
  }

  /**
   * Test {@link MqttClientConfig#setTimeoutSeconds(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link MqttClientConfig#MqttClientConfig()} TimeoutSeconds is minus one.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  @DisplayName(
      "Test setTimeoutSeconds(int); when minus one; then MqttClientConfig() TimeoutSeconds is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setTimeoutSeconds(int)"})
  void testSetTimeoutSeconds_whenMinusOne_thenMqttClientConfigTimeoutSecondsIsMinusOne() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setTimeoutSeconds(-1);

    // Assert
    assertEquals(-1, mqttClientConfig.getTimeoutSeconds());
  }

  /**
   * Test {@link MqttClientConfig#setTimeoutSeconds(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link MqttClientConfig#MqttClientConfig()} TimeoutSeconds is ten.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  @DisplayName(
      "Test setTimeoutSeconds(int); when ten; then MqttClientConfig() TimeoutSeconds is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setTimeoutSeconds(int)"})
  void testSetTimeoutSeconds_whenTen_thenMqttClientConfigTimeoutSecondsIsTen() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setTimeoutSeconds(10);

    // Assert
    assertEquals(10, mqttClientConfig.getTimeoutSeconds());
  }

  /**
   * Test {@link MqttClientConfig#setTimeoutSeconds(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  @DisplayName("Test setTimeoutSeconds(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setTimeoutSeconds(int)"})
  void testSetTimeoutSeconds_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MqttClientConfig().setTimeoutSeconds(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttClientConfig#setChannelClass(Class)}
   *   <li>{@link MqttClientConfig#setCleanSession(boolean)}
   *   <li>{@link MqttClientConfig#setLastWill(MqttLastWill)}
   *   <li>{@link MqttClientConfig#setOwnerId(String)}
   *   <li>{@link MqttClientConfig#setPassword(String)}
   *   <li>{@link MqttClientConfig#setReconnect(boolean)}
   *   <li>{@link MqttClientConfig#setUsername(String)}
   *   <li>{@link MqttClientConfig#getChannelClass()}
   *   <li>{@link MqttClientConfig#getClientId()}
   *   <li>{@link MqttClientConfig#getLastWill()}
   *   <li>{@link MqttClientConfig#getMaxBytesInMessage()}
   *   <li>{@link MqttClientConfig#getOwnerId()}
   *   <li>{@link MqttClientConfig#getPassword()}
   *   <li>{@link MqttClientConfig#getProtocolVersion()}
   *   <li>{@link MqttClientConfig#getReconnectDelay()}
   *   <li>{@link MqttClientConfig#getSslContext()}
   *   <li>{@link MqttClientConfig#getTimeoutSeconds()}
   *   <li>{@link MqttClientConfig#getUsername()}
   *   <li>{@link MqttClientConfig#isCleanSession()}
   *   <li>{@link MqttClientConfig#isReconnect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MqttClientConfig.getChannelClass()",
    "String MqttClientConfig.getClientId()",
    "MqttLastWill MqttClientConfig.getLastWill()",
    "int MqttClientConfig.getMaxBytesInMessage()",
    "String MqttClientConfig.getOwnerId()",
    "String MqttClientConfig.getPassword()",
    "MqttVersion MqttClientConfig.getProtocolVersion()",
    "long MqttClientConfig.getReconnectDelay()",
    "SslContext MqttClientConfig.getSslContext()",
    "int MqttClientConfig.getTimeoutSeconds()",
    "String MqttClientConfig.getUsername()",
    "boolean MqttClientConfig.isCleanSession()",
    "boolean MqttClientConfig.isReconnect()",
    "void MqttClientConfig.setChannelClass(Class)",
    "void MqttClientConfig.setCleanSession(boolean)",
    "void MqttClientConfig.setLastWill(MqttLastWill)",
    "void MqttClientConfig.setOwnerId(String)",
    "void MqttClientConfig.setPassword(String)",
    "void MqttClientConfig.setReconnect(boolean)",
    "void MqttClientConfig.setUsername(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();
    Class<Channel> channelClass = Channel.class;

    // Act
    mqttClientConfig.setChannelClass(channelClass);
    mqttClientConfig.setCleanSession(true);
    MqttLastWill lastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();
    mqttClientConfig.setLastWill(lastWill);
    mqttClientConfig.setOwnerId("42");
    mqttClientConfig.setPassword("iloveyou");
    mqttClientConfig.setReconnect(true);
    mqttClientConfig.setUsername("janedoe");
    Class<? extends Channel> actualChannelClass = mqttClientConfig.getChannelClass();
    mqttClientConfig.getClientId();
    MqttLastWill actualLastWill = mqttClientConfig.getLastWill();
    int actualMaxBytesInMessage = mqttClientConfig.getMaxBytesInMessage();
    String actualOwnerId = mqttClientConfig.getOwnerId();
    String actualPassword = mqttClientConfig.getPassword();
    MqttVersion actualProtocolVersion = mqttClientConfig.getProtocolVersion();
    long actualReconnectDelay = mqttClientConfig.getReconnectDelay();
    SslContext actualSslContext = mqttClientConfig.getSslContext();
    int actualTimeoutSeconds = mqttClientConfig.getTimeoutSeconds();
    String actualUsername = mqttClientConfig.getUsername();
    boolean actualIsCleanSessionResult = mqttClientConfig.isCleanSession();

    // Assert
    assertEquals("42", actualOwnerId);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertNull(actualSslContext);
    assertEquals(1L, actualReconnectDelay);
    assertEquals(60, actualTimeoutSeconds);
    assertEquals(8092, actualMaxBytesInMessage);
    assertEquals(MqttVersion.MQTT_3_1, actualProtocolVersion);
    assertTrue(actualIsCleanSessionResult);
    assertTrue(mqttClientConfig.isReconnect());
    Class<Channel> expectedChannelClass = Channel.class;
    assertEquals(expectedChannelClass, actualChannelClass);
    assertSame(lastWill, actualLastWill);
  }

  /**
   * Test {@link MqttClientConfig#setReconnectDelay(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setReconnectDelay(long)}
   */
  @Test
  @DisplayName("Test setReconnectDelay(long); when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setReconnectDelay(long)"})
  void testSetReconnectDelay_whenOne_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new MqttClientConfig().setReconnectDelay(1L));
  }

  /**
   * Test {@link MqttClientConfig#setReconnectDelay(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setReconnectDelay(long)}
   */
  @Test
  @DisplayName("Test setReconnectDelay(long); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setReconnectDelay(long)"})
  void testSetReconnectDelay_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MqttClientConfig().setReconnectDelay(0L));
  }

  /**
   * Test {@link MqttClientConfig#setMaxBytesInMessage(int)}.
   *
   * <ul>
   *   <li>When {@code 256000001}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  @DisplayName(
      "Test setMaxBytesInMessage(int); when '256000001'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setMaxBytesInMessage(int)"})
  void testSetMaxBytesInMessage_when256000001_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MqttClientConfig().setMaxBytesInMessage(256000001));
  }

  /**
   * Test {@link MqttClientConfig#setMaxBytesInMessage(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then {@link MqttClientConfig#MqttClientConfig()} MaxBytesInMessage is three.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  @DisplayName(
      "Test setMaxBytesInMessage(int); when three; then MqttClientConfig() MaxBytesInMessage is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setMaxBytesInMessage(int)"})
  void testSetMaxBytesInMessage_whenThree_thenMqttClientConfigMaxBytesInMessageIsThree() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setMaxBytesInMessage(3);

    // Assert
    assertEquals(3, mqttClientConfig.getMaxBytesInMessage());
  }

  /**
   * Test {@link MqttClientConfig#setMaxBytesInMessage(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  @DisplayName("Test setMaxBytesInMessage(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientConfig.setMaxBytesInMessage(int)"})
  void testSetMaxBytesInMessage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MqttClientConfig().setMaxBytesInMessage(0));
  }
}
