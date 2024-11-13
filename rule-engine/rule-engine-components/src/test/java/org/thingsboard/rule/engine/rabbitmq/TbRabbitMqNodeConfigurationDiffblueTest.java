package org.thingsboard.rule.engine.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRabbitMqNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbRabbitMqNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testDefaultConfiguration_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> clientProperties = new HashMap<>();
    clientProperties.computeIfPresent("foo", mock(BiFunction.class));

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setClientProperties(clientProperties);

    // Act
    TbRabbitMqNodeConfiguration actualDefaultConfigurationResult = tbRabbitMqNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getExchangeNamePattern());
    assertEquals("", actualDefaultConfigurationResult.getRoutingKeyPattern());
    assertEquals("/", actualDefaultConfigurationResult.getVirtualHost());
    assertEquals("guest", actualDefaultConfigurationResult.getPassword());
    assertEquals("guest", actualDefaultConfigurationResult.getUsername());
    assertEquals("localhost", actualDefaultConfigurationResult.getHost());
    assertNull(actualDefaultConfigurationResult.getMessageProperties());
    assertEquals(10000, actualDefaultConfigurationResult.getHandshakeTimeout());
    assertEquals(5672, actualDefaultConfigurationResult.getPort());
    assertEquals(60000, actualDefaultConfigurationResult.getConnectionTimeout());
    assertFalse(actualDefaultConfigurationResult.isAutomaticRecoveryEnabled());
    assertTrue(actualDefaultConfigurationResult.getClientProperties().isEmpty());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link TbRabbitMqNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given TbRabbitMqNodeConfiguration (default constructor)")
  void testDefaultConfiguration_givenTbRabbitMqNodeConfiguration() {
    // Arrange and Act
    TbRabbitMqNodeConfiguration actualDefaultConfigurationResult = (new TbRabbitMqNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getExchangeNamePattern());
    assertEquals("", actualDefaultConfigurationResult.getRoutingKeyPattern());
    assertEquals("/", actualDefaultConfigurationResult.getVirtualHost());
    assertEquals("guest", actualDefaultConfigurationResult.getPassword());
    assertEquals("guest", actualDefaultConfigurationResult.getUsername());
    assertEquals("localhost", actualDefaultConfigurationResult.getHost());
    assertNull(actualDefaultConfigurationResult.getMessageProperties());
    assertEquals(10000, actualDefaultConfigurationResult.getHandshakeTimeout());
    assertEquals(5672, actualDefaultConfigurationResult.getPort());
    assertEquals(60000, actualDefaultConfigurationResult.getConnectionTimeout());
    assertFalse(actualDefaultConfigurationResult.isAutomaticRecoveryEnabled());
    assertTrue(actualDefaultConfigurationResult.getClientProperties().isEmpty());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setExchangeNamePattern("Exchange Name Pattern");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setExchangeNamePattern("Exchange Name Pattern");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setRoutingKeyPattern("Routing Key Pattern");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setRoutingKeyPattern("Routing Key Pattern");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setMessageProperties("Message Properties");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setMessageProperties("Message Properties");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setHost("localhost");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setHost("localhost");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setVirtualHost("localhost");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setVirtualHost("localhost");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setUsername("janedoe");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setPassword("iloveyou");

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setClientProperties(new HashMap<>());

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setClientProperties(new HashMap<>());

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}, and
   * {@link TbRabbitMqNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqNodeConfiguration#equals(Object)}
   *   <li>{@link TbRabbitMqNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    // Act and Assert
    assertEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration);
    int expectedHashCodeResult = tbRabbitMqNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setExchangeNamePattern("Exchange Name Pattern");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setRoutingKeyPattern("Routing Key Pattern");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setMessageProperties("Message Properties");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setPort(8080);

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setVirtualHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setAutomaticRecoveryEnabled(true);

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setConnectionTimeout(10);

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setHandshakeTimeout(10);

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setClientProperties(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setExchangeNamePattern("Exchange Name Pattern");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setRoutingKeyPattern("Routing Key Pattern");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setMessageProperties("Message Properties");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setVirtualHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration2 = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration2.setClientProperties(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, tbRabbitMqNodeConfiguration2);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    HashMap<String, String> clientProperties = new HashMap<>();
    clientProperties.computeIfPresent("foo", mock(BiFunction.class));

    TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    tbRabbitMqNodeConfiguration.setClientProperties(clientProperties);

    // Act and Assert
    assertNotEquals(tbRabbitMqNodeConfiguration, new TbRabbitMqNodeConfiguration());
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqNodeConfiguration(), null);
  }

  /**
   * Test {@link TbRabbitMqNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqNodeConfiguration(), "Different type to TbRabbitMqNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbRabbitMqNodeConfiguration}
   *   <li>{@link TbRabbitMqNodeConfiguration#setAutomaticRecoveryEnabled(boolean)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setClientProperties(Map)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setConnectionTimeout(int)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setExchangeNamePattern(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setHandshakeTimeout(int)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setHost(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setMessageProperties(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setPassword(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setPort(int)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setRoutingKeyPattern(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setUsername(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#setVirtualHost(String)}
   *   <li>{@link TbRabbitMqNodeConfiguration#toString()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getClientProperties()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getConnectionTimeout()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getExchangeNamePattern()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getHandshakeTimeout()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getHost()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getMessageProperties()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getPassword()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getPort()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getRoutingKeyPattern()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getUsername()}
   *   <li>{@link TbRabbitMqNodeConfiguration#getVirtualHost()}
   *   <li>{@link TbRabbitMqNodeConfiguration#isAutomaticRecoveryEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbRabbitMqNodeConfiguration actualTbRabbitMqNodeConfiguration = new TbRabbitMqNodeConfiguration();
    actualTbRabbitMqNodeConfiguration.setAutomaticRecoveryEnabled(true);
    HashMap<String, String> clientProperties = new HashMap<>();
    actualTbRabbitMqNodeConfiguration.setClientProperties(clientProperties);
    actualTbRabbitMqNodeConfiguration.setConnectionTimeout(10);
    actualTbRabbitMqNodeConfiguration.setExchangeNamePattern("Exchange Name Pattern");
    actualTbRabbitMqNodeConfiguration.setHandshakeTimeout(10);
    actualTbRabbitMqNodeConfiguration.setHost("localhost");
    actualTbRabbitMqNodeConfiguration.setMessageProperties("Message Properties");
    actualTbRabbitMqNodeConfiguration.setPassword("iloveyou");
    actualTbRabbitMqNodeConfiguration.setPort(8080);
    actualTbRabbitMqNodeConfiguration.setRoutingKeyPattern("Routing Key Pattern");
    actualTbRabbitMqNodeConfiguration.setUsername("janedoe");
    actualTbRabbitMqNodeConfiguration.setVirtualHost("localhost");
    String actualToStringResult = actualTbRabbitMqNodeConfiguration.toString();
    Map<String, String> actualClientProperties = actualTbRabbitMqNodeConfiguration.getClientProperties();
    int actualConnectionTimeout = actualTbRabbitMqNodeConfiguration.getConnectionTimeout();
    String actualExchangeNamePattern = actualTbRabbitMqNodeConfiguration.getExchangeNamePattern();
    int actualHandshakeTimeout = actualTbRabbitMqNodeConfiguration.getHandshakeTimeout();
    String actualHost = actualTbRabbitMqNodeConfiguration.getHost();
    String actualMessageProperties = actualTbRabbitMqNodeConfiguration.getMessageProperties();
    String actualPassword = actualTbRabbitMqNodeConfiguration.getPassword();
    int actualPort = actualTbRabbitMqNodeConfiguration.getPort();
    String actualRoutingKeyPattern = actualTbRabbitMqNodeConfiguration.getRoutingKeyPattern();
    String actualUsername = actualTbRabbitMqNodeConfiguration.getUsername();
    String actualVirtualHost = actualTbRabbitMqNodeConfiguration.getVirtualHost();
    boolean actualIsAutomaticRecoveryEnabledResult = actualTbRabbitMqNodeConfiguration.isAutomaticRecoveryEnabled();

    // Assert that nothing has changed
    assertEquals("Exchange Name Pattern", actualExchangeNamePattern);
    assertEquals("Message Properties", actualMessageProperties);
    assertEquals("Routing Key Pattern", actualRoutingKeyPattern);
    assertEquals("TbRabbitMqNodeConfiguration(exchangeNamePattern=Exchange Name Pattern, routingKeyPattern=Routing Key"
        + " Pattern, messageProperties=Message Properties, host=localhost, port=8080, virtualHost=localhost,"
        + " username=janedoe, password=iloveyou, automaticRecoveryEnabled=true, connectionTimeout=10, handshakeTimeout"
        + "=10, clientProperties={})", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("localhost", actualHost);
    assertEquals("localhost", actualVirtualHost);
    assertEquals(10, actualConnectionTimeout);
    assertEquals(10, actualHandshakeTimeout);
    assertEquals(8080, actualPort);
    assertTrue(actualClientProperties.isEmpty());
    assertTrue(actualIsAutomaticRecoveryEnabledResult);
    assertSame(clientProperties, actualClientProperties);
  }
}
