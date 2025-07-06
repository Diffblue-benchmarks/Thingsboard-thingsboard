package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MServerSecurityConfigDefaultDiffblueTest {
  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}, and {@link
   * LwM2MServerSecurityConfigDefault#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MServerSecurityConfigDefault#equals(Object)}
   *   <li>{@link LwM2MServerSecurityConfigDefault#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
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
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault2 =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault2.setBinding("Binding");
    lwM2MServerSecurityConfigDefault2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault2.setHost("localhost");
    lwM2MServerSecurityConfigDefault2.setLifetime(1);
    lwM2MServerSecurityConfigDefault2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault2.setPort(8080);
    lwM2MServerSecurityConfigDefault2.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault2.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault2.setShortServerId(1);

    // Act and Assert
    assertEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault2);
    int expectedHashCodeResult = lwM2MServerSecurityConfigDefault.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MServerSecurityConfigDefault2.hashCode());
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}, and {@link
   * LwM2MServerSecurityConfigDefault#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MServerSecurityConfigDefault#equals(Object)}
   *   <li>{@link LwM2MServerSecurityConfigDefault#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
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
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    // Act and Assert
    assertEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault);
    int expectedHashCodeResult = lwM2MServerSecurityConfigDefault.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MServerSecurityConfigDefault.hashCode());
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("Security Host");
    lwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault2 =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault2.setBinding("Binding");
    lwM2MServerSecurityConfigDefault2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault2.setHost("localhost");
    lwM2MServerSecurityConfigDefault2.setLifetime(1);
    lwM2MServerSecurityConfigDefault2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault2.setPort(8080);
    lwM2MServerSecurityConfigDefault2.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault2.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost(null);
    lwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault2 =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault2.setBinding("Binding");
    lwM2MServerSecurityConfigDefault2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault2.setHost("localhost");
    lwM2MServerSecurityConfigDefault2.setLifetime(1);
    lwM2MServerSecurityConfigDefault2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault2.setPort(8080);
    lwM2MServerSecurityConfigDefault2.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault2.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault.setSecurityPort(1);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault2 =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault2.setBinding("Binding");
    lwM2MServerSecurityConfigDefault2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault2.setHost("localhost");
    lwM2MServerSecurityConfigDefault2.setLifetime(1);
    lwM2MServerSecurityConfigDefault2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault2.setPort(8080);
    lwM2MServerSecurityConfigDefault2.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault2.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault.setSecurityPort(null);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault2 =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault2.setBinding("Binding");
    lwM2MServerSecurityConfigDefault2.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault2.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault2.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault2.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault2.setHost("localhost");
    lwM2MServerSecurityConfigDefault2.setLifetime(1);
    lwM2MServerSecurityConfigDefault2.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault2.setPort(8080);
    lwM2MServerSecurityConfigDefault2.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault2.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault2.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault2.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault2.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, lwM2MServerSecurityConfigDefault2);
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
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
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerSecurityConfigDefault, null);
  }

  /**
   * Test {@link LwM2MServerSecurityConfigDefault#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerSecurityConfigDefault#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2MServerSecurityConfigDefault.equals(Object)",
    "int LwM2MServerSecurityConfigDefault.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
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
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);

    // Act and Assert
    assertNotEquals(
        lwM2MServerSecurityConfigDefault, "Different type to LwM2MServerSecurityConfigDefault");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MServerSecurityConfigDefault}
   *   <li>{@link LwM2MServerSecurityConfigDefault#setSecurityHost(String)}
   *   <li>{@link LwM2MServerSecurityConfigDefault#setSecurityPort(Integer)}
   *   <li>{@link LwM2MServerSecurityConfigDefault#toString()}
   *   <li>{@link LwM2MServerSecurityConfigDefault#getSecurityHost()}
   *   <li>{@link LwM2MServerSecurityConfigDefault#getSecurityPort()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void LwM2MServerSecurityConfigDefault.<init>()",
    "String LwM2MServerSecurityConfigDefault.getSecurityHost()",
    "Integer LwM2MServerSecurityConfigDefault.getSecurityPort()",
    "void LwM2MServerSecurityConfigDefault.setSecurityHost(String)",
    "void LwM2MServerSecurityConfigDefault.setSecurityPort(Integer)",
    "String LwM2MServerSecurityConfigDefault.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MServerSecurityConfigDefault actualLwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    actualLwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    actualLwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    String actualToStringResult = actualLwM2MServerSecurityConfigDefault.toString();
    String actualSecurityHost = actualLwM2MServerSecurityConfigDefault.getSecurityHost();
    Integer actualSecurityPort = actualLwM2MServerSecurityConfigDefault.getSecurityPort();

    // Assert
    assertEquals(
        "LwM2MServerSecurityConfigDefault(securityHost=localhost, securityPort=8080)",
        actualToStringResult);
    assertEquals("U", actualLwM2MServerSecurityConfigDefault.getBinding());
    assertEquals("localhost", actualSecurityHost);
    assertNull(actualLwM2MServerSecurityConfigDefault.getPort());
    assertNull(actualLwM2MServerSecurityConfigDefault.getHost());
    assertNull(actualLwM2MServerSecurityConfigDefault.getServerCertificate());
    assertNull(actualLwM2MServerSecurityConfigDefault.getServerPublicKey());
    assertEquals(
        0, actualLwM2MServerSecurityConfigDefault.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualLwM2MServerSecurityConfigDefault.getClientHoldOffTime().intValue());
    assertEquals(1, actualLwM2MServerSecurityConfigDefault.getDefaultMinPeriod().intValue());
    assertEquals(123, actualLwM2MServerSecurityConfigDefault.getShortServerId().intValue());
    assertEquals(300, actualLwM2MServerSecurityConfigDefault.getLifetime().intValue());
    assertEquals(8080, actualSecurityPort.intValue());
    assertFalse(actualLwM2MServerSecurityConfigDefault.isBootstrapServerIs());
    assertTrue(actualLwM2MServerSecurityConfigDefault.isNotifIfDisabled());
  }
}
