package org.thingsboard.server.dao.device.provision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.ProvisionDeviceCredentialsData;
import org.thingsboard.server.common.data.device.profile.ProvisionDeviceProfileCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;

class ProvisionRequestDiffblueTest {
  /**
   * Test {@link ProvisionRequest#equals(Object)}, and {@link ProvisionRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}, and {@link ProvisionRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            null,
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 =
        new ProvisionRequest(
            null,
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}, and {@link ProvisionRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            null,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest2 =
        new ProvisionRequest(
            "Device Name",
            null,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}, and {@link ProvisionRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            null,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionRequest provisionRequest2 =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            null,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest2);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest2.hashCode());
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}, and {@link ProvisionRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#equals(Object)}
   *   <li>{@link ProvisionRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertEquals(provisionRequest, provisionRequest);
    int expectedHashCodeResult = provisionRequest.hashCode();
    assertEquals(expectedHashCodeResult, provisionRequest.hashCode());
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "ABC123",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            null,
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            null,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.X509_CERTIFICATE,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData(
            "Device Name", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            null,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials("Device Name", "Provision Device Secret"),
            true);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            new ProvisionDeviceCredentialsData(
                "ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"),
            null,
            true);
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            false);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            null);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        provisionRequest,
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData2,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true));
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true),
        null);
  }

  /**
   * Test {@link ProvisionRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionRequest.equals(Object)", "int ProvisionRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true),
        "Different type to ProvisionRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionRequest#ProvisionRequest(String, DeviceCredentialsType,
   *       ProvisionDeviceCredentialsData, ProvisionDeviceProfileCredentials, Boolean)}
   *   <li>{@link ProvisionRequest#setCredentials(ProvisionDeviceProfileCredentials)}
   *   <li>{@link ProvisionRequest#setCredentialsData(ProvisionDeviceCredentialsData)}
   *   <li>{@link ProvisionRequest#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link ProvisionRequest#setDeviceName(String)}
   *   <li>{@link ProvisionRequest#setGateway(Boolean)}
   *   <li>{@link ProvisionRequest#toString()}
   *   <li>{@link ProvisionRequest#getCredentials()}
   *   <li>{@link ProvisionRequest#getCredentialsData()}
   *   <li>{@link ProvisionRequest#getCredentialsType()}
   *   <li>{@link ProvisionRequest#getDeviceName()}
   *   <li>{@link ProvisionRequest#getGateway()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ProvisionRequest.<init>(String, DeviceCredentialsType, ProvisionDeviceCredentialsData, ProvisionDeviceProfileCredentials, Boolean)",
    "ProvisionDeviceProfileCredentials ProvisionRequest.getCredentials()",
    "ProvisionDeviceCredentialsData ProvisionRequest.getCredentialsData()",
    "DeviceCredentialsType ProvisionRequest.getCredentialsType()",
    "String ProvisionRequest.getDeviceName()",
    "Boolean ProvisionRequest.getGateway()",
    "void ProvisionRequest.setCredentials(ProvisionDeviceProfileCredentials)",
    "void ProvisionRequest.setCredentialsData(ProvisionDeviceCredentialsData)",
    "void ProvisionRequest.setCredentialsType(DeviceCredentialsType)",
    "void ProvisionRequest.setDeviceName(String)",
    "void ProvisionRequest.setGateway(Boolean)",
    "String ProvisionRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act
    ProvisionRequest actualProvisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);
    ProvisionDeviceProfileCredentials credentials =
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret");

    actualProvisionRequest.setCredentials(credentials);
    ProvisionDeviceCredentialsData credentialsData2 =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");

    actualProvisionRequest.setCredentialsData(credentialsData2);
    actualProvisionRequest.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualProvisionRequest.setDeviceName("Device Name");
    actualProvisionRequest.setGateway(true);
    String actualToStringResult = actualProvisionRequest.toString();
    ProvisionDeviceProfileCredentials actualCredentials = actualProvisionRequest.getCredentials();
    ProvisionDeviceCredentialsData actualCredentialsData =
        actualProvisionRequest.getCredentialsData();
    DeviceCredentialsType actualCredentialsType = actualProvisionRequest.getCredentialsType();
    String actualDeviceName = actualProvisionRequest.getDeviceName();

    // Assert
    assertEquals("Device Name", actualDeviceName);
    assertEquals(
        "ProvisionRequest(deviceName=Device Name, credentialsType=ACCESS_TOKEN, credentialsData=ProvisionDevi"
            + "ceCredentialsData(token=ABC123, clientId=42, username=janedoe, password=iloveyou, x509CertHash=X509"
            + " Cert Hash), credentials=ProvisionDeviceProfileCredentials(provisionDeviceKey=Provision Device Key,"
            + " provisionDeviceSecret=Provision Device Secret), gateway=true)",
        actualToStringResult);
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertTrue(actualProvisionRequest.getGateway());
    assertSame(credentialsData2, actualCredentialsData);
    assertSame(credentials, actualCredentials);
  }
}
