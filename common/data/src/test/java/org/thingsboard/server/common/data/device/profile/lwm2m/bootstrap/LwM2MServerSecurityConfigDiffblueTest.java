package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2MServerSecurityConfigDiffblueTest {
  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}, and {@link LwM2MServerSecurityConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MServerSecurityConfig#equals(Object)}
   *   <li>{@link LwM2MServerSecurityConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
    int expectedHashCodeResult = lwM2MServerSecurityConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MServerSecurityConfig2.hashCode());
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}, and {@link LwM2MServerSecurityConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MServerSecurityConfig#equals(Object)}
   *   <li>{@link LwM2MServerSecurityConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault = mock(LwM2MServerSecurityConfigDefault.class);
    when(lwM2MServerSecurityConfigDefault.getBinding()).thenReturn("Binding");
    when(lwM2MServerSecurityConfigDefault.getServerCertificate()).thenReturn("Server Certificate");
    when(lwM2MServerSecurityConfigDefault.getServerPublicKey()).thenReturn("Server Public Key");
    when(lwM2MServerSecurityConfigDefault.getHost()).thenReturn("localhost");
    when(lwM2MServerSecurityConfigDefault.getDefaultMinPeriod()).thenReturn(1);
    when(lwM2MServerSecurityConfigDefault.getLifetime()).thenReturn(1);
    when(lwM2MServerSecurityConfigDefault.getBootstrapServerAccountTimeout()).thenReturn(3);
    when(lwM2MServerSecurityConfigDefault.getClientHoldOffTime()).thenReturn(1);
    when(lwM2MServerSecurityConfigDefault.getPort()).thenReturn(8080);
    when(lwM2MServerSecurityConfigDefault.getShortServerId()).thenReturn(1);
    when(lwM2MServerSecurityConfigDefault.isNotifIfDisabled()).thenReturn(true);
    when(lwM2MServerSecurityConfigDefault.isBootstrapServerIs()).thenReturn(true);
    when(lwM2MServerSecurityConfigDefault.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(lwM2MServerSecurityConfigDefault).setBinding(Mockito.<String>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setBootstrapServerAccountTimeout(Mockito.<Integer>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setBootstrapServerIs(anyBoolean());
    doNothing().when(lwM2MServerSecurityConfigDefault).setClientHoldOffTime(Mockito.<Integer>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setDefaultMinPeriod(Mockito.<Integer>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setHost(Mockito.<String>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setLifetime(Mockito.<Integer>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setNotifIfDisabled(anyBoolean());
    doNothing().when(lwM2MServerSecurityConfigDefault).setPort(Mockito.<Integer>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setServerCertificate(Mockito.<String>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setServerPublicKey(Mockito.<String>any());
    doNothing().when(lwM2MServerSecurityConfigDefault).setShortServerId(Mockito.<Integer>any());
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    // Act and Assert
    assertEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfigDefault);
    int notExpectedHashCodeResult = lwM2MServerSecurityConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, lwM2MServerSecurityConfigDefault.hashCode());
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}, and {@link LwM2MServerSecurityConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MServerSecurityConfig#equals(Object)}
   *   <li>{@link LwM2MServerSecurityConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    // Act and Assert
    assertEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig);
    int expectedHashCodeResult = lwM2MServerSecurityConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MServerSecurityConfig.hashCode());
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault = new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("localhost");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("localhost");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("localhost");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfig);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("localhost");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding(null);
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(10);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(null);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(false);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(3);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(null);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(3);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(null);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("Server Public Key");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost(null);
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(3);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(null);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(false);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(1);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(null);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("localhost");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate(null);
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("localhost");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey(null);
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(2);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(null);

    LwM2MServerSecurityConfig lwM2MServerSecurityConfig2 = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig2.setBinding("Binding");
    lwM2MServerSecurityConfig2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig2.setHost("localhost");
    lwM2MServerSecurityConfig2.setLifetime(1);
    lwM2MServerSecurityConfig2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig2.setPort(8080);
    lwM2MServerSecurityConfig2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfig2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault = new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("localhost");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("localhost");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("localhost");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, lwM2MServerSecurityConfigDefault);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, null);
  }

  /**
   * Test {@link LwM2MServerSecurityConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServerSecurityConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MServerSecurityConfig.equals(Object)", "int LwM2MServerSecurityConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfig lwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    lwM2MServerSecurityConfig.setBinding("Binding");
    lwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfig.setBootstrapServerIs(true);
    lwM2MServerSecurityConfig.setClientHoldOffTime(1);
    lwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfig.setHost("localhost");
    lwM2MServerSecurityConfig.setLifetime(1);
    lwM2MServerSecurityConfig.setNotifIfDisabled(true);
    lwM2MServerSecurityConfig.setPort(8080);
    lwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfig.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfig, "Different type to LwM2MServerSecurityConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MServerSecurityConfig}
   *   <li>{@link LwM2MServerSecurityConfig#setBinding(String)}
   *   <li>{@link LwM2MServerSecurityConfig#setBootstrapServerAccountTimeout(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#setBootstrapServerIs(boolean)}
   *   <li>{@link LwM2MServerSecurityConfig#setClientHoldOffTime(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#setDefaultMinPeriod(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#setHost(String)}
   *   <li>{@link LwM2MServerSecurityConfig#setLifetime(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#setNotifIfDisabled(boolean)}
   *   <li>{@link LwM2MServerSecurityConfig#setPort(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#setServerCertificate(String)}
   *   <li>{@link LwM2MServerSecurityConfig#setServerPublicKey(String)}
   *   <li>{@link LwM2MServerSecurityConfig#setShortServerId(Integer)}
   *   <li>{@link LwM2MServerSecurityConfig#toString()}
   *   <li>{@link LwM2MServerSecurityConfig#getBinding()}
   *   <li>{@link LwM2MServerSecurityConfig#getBootstrapServerAccountTimeout()}
   *   <li>{@link LwM2MServerSecurityConfig#getClientHoldOffTime()}
   *   <li>{@link LwM2MServerSecurityConfig#getDefaultMinPeriod()}
   *   <li>{@link LwM2MServerSecurityConfig#getHost()}
   *   <li>{@link LwM2MServerSecurityConfig#getLifetime()}
   *   <li>{@link LwM2MServerSecurityConfig#getPort()}
   *   <li>{@link LwM2MServerSecurityConfig#getServerCertificate()}
   *   <li>{@link LwM2MServerSecurityConfig#getServerPublicKey()}
   *   <li>{@link LwM2MServerSecurityConfig#getShortServerId()}
   *   <li>{@link LwM2MServerSecurityConfig#isBootstrapServerIs()}
   *   <li>{@link LwM2MServerSecurityConfig#isNotifIfDisabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MServerSecurityConfig.<init>()", "String LwM2MServerSecurityConfig.getBinding()",
      "Integer LwM2MServerSecurityConfig.getBootstrapServerAccountTimeout()",
      "Integer LwM2MServerSecurityConfig.getClientHoldOffTime()",
      "Integer LwM2MServerSecurityConfig.getDefaultMinPeriod()", "String LwM2MServerSecurityConfig.getHost()",
      "Integer LwM2MServerSecurityConfig.getLifetime()", "Integer LwM2MServerSecurityConfig.getPort()",
      "String LwM2MServerSecurityConfig.getServerCertificate()",
      "String LwM2MServerSecurityConfig.getServerPublicKey()", "Integer LwM2MServerSecurityConfig.getShortServerId()",
      "boolean LwM2MServerSecurityConfig.isBootstrapServerIs()",
      "boolean LwM2MServerSecurityConfig.isNotifIfDisabled()", "void LwM2MServerSecurityConfig.setBinding(String)",
      "void LwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(Integer)",
      "void LwM2MServerSecurityConfig.setBootstrapServerIs(boolean)",
      "void LwM2MServerSecurityConfig.setClientHoldOffTime(Integer)",
      "void LwM2MServerSecurityConfig.setDefaultMinPeriod(Integer)", "void LwM2MServerSecurityConfig.setHost(String)",
      "void LwM2MServerSecurityConfig.setLifetime(Integer)",
      "void LwM2MServerSecurityConfig.setNotifIfDisabled(boolean)", "void LwM2MServerSecurityConfig.setPort(Integer)",
      "void LwM2MServerSecurityConfig.setServerCertificate(String)",
      "void LwM2MServerSecurityConfig.setServerPublicKey(String)",
      "void LwM2MServerSecurityConfig.setShortServerId(Integer)", "String LwM2MServerSecurityConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MServerSecurityConfig actualLwM2MServerSecurityConfig = new LwM2MServerSecurityConfig();
    actualLwM2MServerSecurityConfig.setBinding("Binding");
    actualLwM2MServerSecurityConfig.setBootstrapServerAccountTimeout(3);
    actualLwM2MServerSecurityConfig.setBootstrapServerIs(true);
    actualLwM2MServerSecurityConfig.setClientHoldOffTime(1);
    actualLwM2MServerSecurityConfig.setDefaultMinPeriod(1);
    actualLwM2MServerSecurityConfig.setHost("localhost");
    actualLwM2MServerSecurityConfig.setLifetime(1);
    actualLwM2MServerSecurityConfig.setNotifIfDisabled(true);
    actualLwM2MServerSecurityConfig.setPort(8080);
    actualLwM2MServerSecurityConfig.setServerCertificate("Server Certificate");
    actualLwM2MServerSecurityConfig.setServerPublicKey("Server Public Key");
    actualLwM2MServerSecurityConfig.setShortServerId(1);
    String actualToStringResult = actualLwM2MServerSecurityConfig.toString();
    String actualBinding = actualLwM2MServerSecurityConfig.getBinding();
    Integer actualBootstrapServerAccountTimeout = actualLwM2MServerSecurityConfig.getBootstrapServerAccountTimeout();
    Integer actualClientHoldOffTime = actualLwM2MServerSecurityConfig.getClientHoldOffTime();
    Integer actualDefaultMinPeriod = actualLwM2MServerSecurityConfig.getDefaultMinPeriod();
    String actualHost = actualLwM2MServerSecurityConfig.getHost();
    Integer actualLifetime = actualLwM2MServerSecurityConfig.getLifetime();
    Integer actualPort = actualLwM2MServerSecurityConfig.getPort();
    String actualServerCertificate = actualLwM2MServerSecurityConfig.getServerCertificate();
    String actualServerPublicKey = actualLwM2MServerSecurityConfig.getServerPublicKey();
    Integer actualShortServerId = actualLwM2MServerSecurityConfig.getShortServerId();
    boolean actualIsBootstrapServerIsResult = actualLwM2MServerSecurityConfig.isBootstrapServerIs();
    boolean actualIsNotifIfDisabledResult = actualLwM2MServerSecurityConfig.isNotifIfDisabled();

    // Assert
    assertEquals("Binding", actualBinding);
    assertEquals("LwM2MServerSecurityConfig(shortServerId=1, bootstrapServerIs=true, host=localhost, port=8080,"
        + " clientHoldOffTime=1, serverPublicKey=Server Public Key, serverCertificate=Server Certificate,"
        + " bootstrapServerAccountTimeout=3, lifetime=1, defaultMinPeriod=1, notifIfDisabled=true, binding=Binding"
        + ")", actualToStringResult);
    assertEquals("Server Certificate", actualServerCertificate);
    assertEquals("Server Public Key", actualServerPublicKey);
    assertEquals("localhost", actualHost);
    assertEquals(1, actualClientHoldOffTime.intValue());
    assertEquals(1, actualDefaultMinPeriod.intValue());
    assertEquals(1, actualLifetime.intValue());
    assertEquals(1, actualShortServerId.intValue());
    assertEquals(3, actualBootstrapServerAccountTimeout.intValue());
    assertEquals(8080, actualPort.intValue());
    assertTrue(actualIsBootstrapServerIsResult);
    assertTrue(actualIsNotifIfDisabledResult);
  }
}
