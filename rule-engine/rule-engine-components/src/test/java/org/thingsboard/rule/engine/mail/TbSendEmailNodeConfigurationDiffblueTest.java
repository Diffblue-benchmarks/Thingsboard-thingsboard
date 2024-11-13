package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbSendEmailNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendEmailNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbSendEmailNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbSendEmailNodeConfiguration actualDefaultConfigurationResult = (new TbSendEmailNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("TLSv1.2", actualDefaultConfigurationResult.getTlsVersion());
    assertEquals("localhost", actualDefaultConfigurationResult.getSmtpHost());
    assertEquals("smtp", actualDefaultConfigurationResult.getSmtpProtocol());
    assertNull(actualDefaultConfigurationResult.getPassword());
    assertNull(actualDefaultConfigurationResult.getProxyHost());
    assertNull(actualDefaultConfigurationResult.getProxyPassword());
    assertNull(actualDefaultConfigurationResult.getProxyPort());
    assertNull(actualDefaultConfigurationResult.getProxyUser());
    assertNull(actualDefaultConfigurationResult.getUsername());
    assertEquals(10000, actualDefaultConfigurationResult.getTimeout());
    assertEquals(25, actualDefaultConfigurationResult.getSmtpPort());
    assertFalse(actualDefaultConfigurationResult.isEnableProxy());
    assertFalse(actualDefaultConfigurationResult.isEnableTls());
    assertTrue(actualDefaultConfigurationResult.isUseSystemSmtpSettings());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setSmtpHost("localhost");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setSmtpHost("localhost");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setUsername("janedoe");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setPassword("iloveyou");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setSmtpProtocol("Smtp Protocol");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setSmtpProtocol("Smtp Protocol");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setTlsVersion("1.0.2");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setTlsVersion("1.0.2");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyHost("localhost");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyPort("Proxy Port");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyPort("Proxy Port");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyUser("Proxy User");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual10() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyPassword("iloveyou");

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}, and
   * {@link TbSendEmailNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendEmailNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendEmailNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration);
    int expectedHashCodeResult = tbSendEmailNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendEmailNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendEmailNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setUseSystemSmtpSettings(true);

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setSmtpHost("localhost");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setSmtpPort(8080);

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setSmtpProtocol("Smtp Protocol");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setTimeout(10);

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setEnableTls(true);

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setTlsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setEnableProxy(true);

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyPort("Proxy Port");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, new TbSendEmailNodeConfiguration());
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setSmtpHost("localhost");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setSmtpProtocol("Smtp Protocol");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setTlsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyHost("localhost");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyPort("Proxy Port");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyUser("Proxy User");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();

    TbSendEmailNodeConfiguration tbSendEmailNodeConfiguration2 = new TbSendEmailNodeConfiguration();
    tbSendEmailNodeConfiguration2.setProxyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbSendEmailNodeConfiguration, tbSendEmailNodeConfiguration2);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendEmailNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendEmailNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendEmailNodeConfiguration(), "Different type to TbSendEmailNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbSendEmailNodeConfiguration}
   *   <li>{@link TbSendEmailNodeConfiguration#setEnableProxy(boolean)}
   *   <li>{@link TbSendEmailNodeConfiguration#setEnableTls(boolean)}
   *   <li>{@link TbSendEmailNodeConfiguration#setPassword(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setProxyHost(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setProxyPassword(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setProxyPort(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setProxyUser(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setSmtpHost(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setSmtpPort(int)}
   *   <li>{@link TbSendEmailNodeConfiguration#setSmtpProtocol(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setTimeout(int)}
   *   <li>{@link TbSendEmailNodeConfiguration#setTlsVersion(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#setUseSystemSmtpSettings(boolean)}
   *   <li>{@link TbSendEmailNodeConfiguration#setUsername(String)}
   *   <li>{@link TbSendEmailNodeConfiguration#toString()}
   *   <li>{@link TbSendEmailNodeConfiguration#getPassword()}
   *   <li>{@link TbSendEmailNodeConfiguration#getProxyHost()}
   *   <li>{@link TbSendEmailNodeConfiguration#getProxyPassword()}
   *   <li>{@link TbSendEmailNodeConfiguration#getProxyPort()}
   *   <li>{@link TbSendEmailNodeConfiguration#getProxyUser()}
   *   <li>{@link TbSendEmailNodeConfiguration#getSmtpHost()}
   *   <li>{@link TbSendEmailNodeConfiguration#getSmtpPort()}
   *   <li>{@link TbSendEmailNodeConfiguration#getSmtpProtocol()}
   *   <li>{@link TbSendEmailNodeConfiguration#getTimeout()}
   *   <li>{@link TbSendEmailNodeConfiguration#getTlsVersion()}
   *   <li>{@link TbSendEmailNodeConfiguration#getUsername()}
   *   <li>{@link TbSendEmailNodeConfiguration#isEnableProxy()}
   *   <li>{@link TbSendEmailNodeConfiguration#isEnableTls()}
   *   <li>{@link TbSendEmailNodeConfiguration#isUseSystemSmtpSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendEmailNodeConfiguration actualTbSendEmailNodeConfiguration = new TbSendEmailNodeConfiguration();
    actualTbSendEmailNodeConfiguration.setEnableProxy(true);
    actualTbSendEmailNodeConfiguration.setEnableTls(true);
    actualTbSendEmailNodeConfiguration.setPassword("iloveyou");
    actualTbSendEmailNodeConfiguration.setProxyHost("localhost");
    actualTbSendEmailNodeConfiguration.setProxyPassword("iloveyou");
    actualTbSendEmailNodeConfiguration.setProxyPort("Proxy Port");
    actualTbSendEmailNodeConfiguration.setProxyUser("Proxy User");
    actualTbSendEmailNodeConfiguration.setSmtpHost("localhost");
    actualTbSendEmailNodeConfiguration.setSmtpPort(8080);
    actualTbSendEmailNodeConfiguration.setSmtpProtocol("Smtp Protocol");
    actualTbSendEmailNodeConfiguration.setTimeout(10);
    actualTbSendEmailNodeConfiguration.setTlsVersion("1.0.2");
    actualTbSendEmailNodeConfiguration.setUseSystemSmtpSettings(true);
    actualTbSendEmailNodeConfiguration.setUsername("janedoe");
    String actualToStringResult = actualTbSendEmailNodeConfiguration.toString();
    String actualPassword = actualTbSendEmailNodeConfiguration.getPassword();
    String actualProxyHost = actualTbSendEmailNodeConfiguration.getProxyHost();
    String actualProxyPassword = actualTbSendEmailNodeConfiguration.getProxyPassword();
    String actualProxyPort = actualTbSendEmailNodeConfiguration.getProxyPort();
    String actualProxyUser = actualTbSendEmailNodeConfiguration.getProxyUser();
    String actualSmtpHost = actualTbSendEmailNodeConfiguration.getSmtpHost();
    int actualSmtpPort = actualTbSendEmailNodeConfiguration.getSmtpPort();
    String actualSmtpProtocol = actualTbSendEmailNodeConfiguration.getSmtpProtocol();
    int actualTimeout = actualTbSendEmailNodeConfiguration.getTimeout();
    String actualTlsVersion = actualTbSendEmailNodeConfiguration.getTlsVersion();
    String actualUsername = actualTbSendEmailNodeConfiguration.getUsername();
    boolean actualIsEnableProxyResult = actualTbSendEmailNodeConfiguration.isEnableProxy();
    boolean actualIsEnableTlsResult = actualTbSendEmailNodeConfiguration.isEnableTls();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualTlsVersion);
    assertEquals("Proxy Port", actualProxyPort);
    assertEquals("Proxy User", actualProxyUser);
    assertEquals("Smtp Protocol", actualSmtpProtocol);
    assertEquals("TbSendEmailNodeConfiguration(useSystemSmtpSettings=true, smtpHost=localhost, smtpPort=8080,"
        + " username=janedoe, password=iloveyou, smtpProtocol=Smtp Protocol, timeout=10, enableTls=true,"
        + " tlsVersion=1.0.2, enableProxy=true, proxyHost=localhost, proxyPort=Proxy Port, proxyUser=Proxy User,"
        + " proxyPassword=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("iloveyou", actualProxyPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("localhost", actualProxyHost);
    assertEquals("localhost", actualSmtpHost);
    assertEquals(10, actualTimeout);
    assertEquals(8080, actualSmtpPort);
    assertTrue(actualIsEnableProxyResult);
    assertTrue(actualIsEnableTlsResult);
    assertTrue(actualTbSendEmailNodeConfiguration.isUseSystemSmtpSettings());
  }
}
