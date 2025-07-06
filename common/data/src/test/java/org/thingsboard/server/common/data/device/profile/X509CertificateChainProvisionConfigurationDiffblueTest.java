package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class X509CertificateChainProvisionConfigurationDiffblueTest {
  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}, and {@link
   * X509CertificateChainProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}, and {@link
   * X509CertificateChainProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}, and {@link
   * X509CertificateChainProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(null);

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret(null);

    // Act and Assert
    assertEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}, and {@link
   * X509CertificateChainProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link X509CertificateChainProvisionConfiguration#equals(Object)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration);
    int expectedHashCodeResult = x509CertificateChainProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, x509CertificateChainProvisionConfiguration.hashCode());
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(false);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(
        "Provision Device Secret");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(null);
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(".*");

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(null);

    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration2 =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration2.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration2.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration2.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration, x509CertificateChainProvisionConfiguration2);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(x509CertificateChainProvisionConfiguration, null);
  }

  /**
   * Test {@link X509CertificateChainProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link X509CertificateChainProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean X509CertificateChainProvisionConfiguration.equals(Object)",
    "int X509CertificateChainProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    X509CertificateChainProvisionConfiguration x509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    x509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(true);
    x509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    x509CertificateChainProvisionConfiguration.setProvisionDeviceSecret("Provision Device Secret");

    // Act and Assert
    assertNotEquals(
        x509CertificateChainProvisionConfiguration,
        "Different type to X509CertificateChainProvisionConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       X509CertificateChainProvisionConfiguration}
   *   <li>{@link
   *       X509CertificateChainProvisionConfiguration#setAllowCreateNewDevicesByX509Certificate(boolean)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#setCertificateRegExPattern(String)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#setProvisionDeviceSecret(String)}
   *   <li>{@link X509CertificateChainProvisionConfiguration#toString()}
   *   <li>{@link X509CertificateChainProvisionConfiguration#getCertificateRegExPattern()}
   *   <li>{@link X509CertificateChainProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>{@link X509CertificateChainProvisionConfiguration#getType()}
   *   <li>{@link
   *       X509CertificateChainProvisionConfiguration#isAllowCreateNewDevicesByX509Certificate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void X509CertificateChainProvisionConfiguration.<init>()",
    "String X509CertificateChainProvisionConfiguration.getCertificateRegExPattern()",
    "String X509CertificateChainProvisionConfiguration.getProvisionDeviceSecret()",
    "DeviceProfileProvisionType X509CertificateChainProvisionConfiguration.getType()",
    "boolean X509CertificateChainProvisionConfiguration.isAllowCreateNewDevicesByX509Certificate()",
    "void X509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(boolean)",
    "void X509CertificateChainProvisionConfiguration.setCertificateRegExPattern(String)",
    "void X509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(String)",
    "String X509CertificateChainProvisionConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    X509CertificateChainProvisionConfiguration actualX509CertificateChainProvisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    actualX509CertificateChainProvisionConfiguration.setAllowCreateNewDevicesByX509Certificate(
        true);
    actualX509CertificateChainProvisionConfiguration.setCertificateRegExPattern(".*");
    actualX509CertificateChainProvisionConfiguration.setProvisionDeviceSecret(
        "Provision Device Secret");
    String actualToStringResult = actualX509CertificateChainProvisionConfiguration.toString();
    String actualCertificateRegExPattern =
        actualX509CertificateChainProvisionConfiguration.getCertificateRegExPattern();
    String actualProvisionDeviceSecret =
        actualX509CertificateChainProvisionConfiguration.getProvisionDeviceSecret();
    DeviceProfileProvisionType actualType =
        actualX509CertificateChainProvisionConfiguration.getType();

    // Assert
    assertEquals(".*", actualCertificateRegExPattern);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals(
        "X509CertificateChainProvisionConfiguration(provisionDeviceSecret=Provision Device Secret, certificat"
            + "eRegExPattern=.*, allowCreateNewDevicesByX509Certificate=true)",
        actualToStringResult);
    assertEquals(DeviceProfileProvisionType.X509_CERTIFICATE_CHAIN, actualType);
    assertTrue(
        actualX509CertificateChainProvisionConfiguration
            .isAllowCreateNewDevicesByX509Certificate());
  }
}
