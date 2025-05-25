package org.thingsboard.server.common.data.device.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProvisionDeviceCredentialsDataDiffblueTest {
  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", null);
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData2 = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", null);

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData2);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}, and {@link ProvisionDeviceCredentialsData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#equals(Object)}
   *   <li>{@link ProvisionDeviceCredentialsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertEquals(provisionDeviceCredentialsData, provisionDeviceCredentialsData);
    int expectedHashCodeResult = provisionDeviceCredentialsData.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceCredentialsData.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("42", "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData(null, "42",
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123",
        "ABC123", "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", null,
        "janedoe", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "ABC123", "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        null, "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "ABC123", "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", null, "X509 Cert Hash");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", "ABC123");

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProvisionDeviceCredentialsData provisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123", "42",
        "janedoe", "iloveyou", null);

    // Act and Assert
    assertNotEquals(provisionDeviceCredentialsData,
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"));
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"), null);
  }

  /**
   * Test {@link ProvisionDeviceCredentialsData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceCredentialsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceCredentialsData.equals(Object)",
      "int ProvisionDeviceCredentialsData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash"),
        "Different type to ProvisionDeviceCredentialsData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceCredentialsData#ProvisionDeviceCredentialsData(String, String, String, String, String)}
   *   <li>{@link ProvisionDeviceCredentialsData#toString()}
   *   <li>{@link ProvisionDeviceCredentialsData#getClientId()}
   *   <li>{@link ProvisionDeviceCredentialsData#getPassword()}
   *   <li>{@link ProvisionDeviceCredentialsData#getToken()}
   *   <li>{@link ProvisionDeviceCredentialsData#getUsername()}
   *   <li>{@link ProvisionDeviceCredentialsData#getX509CertHash()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProvisionDeviceCredentialsData.<init>(String, String, String, String, String)",
      "String ProvisionDeviceCredentialsData.getClientId()", "String ProvisionDeviceCredentialsData.getPassword()",
      "String ProvisionDeviceCredentialsData.getToken()", "String ProvisionDeviceCredentialsData.getUsername()",
      "String ProvisionDeviceCredentialsData.getX509CertHash()", "String ProvisionDeviceCredentialsData.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ProvisionDeviceCredentialsData actualProvisionDeviceCredentialsData = new ProvisionDeviceCredentialsData("ABC123",
        "42", "janedoe", "iloveyou", "X509 Cert Hash");
    String actualToStringResult = actualProvisionDeviceCredentialsData.toString();
    String actualClientId = actualProvisionDeviceCredentialsData.getClientId();
    String actualPassword = actualProvisionDeviceCredentialsData.getPassword();
    String actualToken = actualProvisionDeviceCredentialsData.getToken();
    String actualUsername = actualProvisionDeviceCredentialsData.getUsername();

    // Assert
    assertEquals("42", actualClientId);
    assertEquals("ABC123", actualToken);
    assertEquals("ProvisionDeviceCredentialsData(token=ABC123, clientId=42, username=janedoe, password=iloveyou,"
        + " x509CertHash=X509 Cert Hash)", actualToStringResult);
    assertEquals("X509 Cert Hash", actualProvisionDeviceCredentialsData.getX509CertHash());
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
  }
}
