package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProvisionDeviceProfileCredentialsDiffblueTest {
  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}, and {@link ProvisionDeviceProfileCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceProfileCredentials#equals(Object)}
   *   <li>{@link ProvisionDeviceProfileCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", "Provision Device Secret");
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials2 = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", "Provision Device Secret");

    // Act and Assert
    assertEquals(provisionDeviceProfileCredentials, provisionDeviceProfileCredentials2);
    int expectedHashCodeResult = provisionDeviceProfileCredentials.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceProfileCredentials2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}, and {@link ProvisionDeviceProfileCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceProfileCredentials#equals(Object)}
   *   <li>{@link ProvisionDeviceProfileCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(null,
        "Provision Device Secret");
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials2 = new ProvisionDeviceProfileCredentials(null,
        "Provision Device Secret");

    // Act and Assert
    assertEquals(provisionDeviceProfileCredentials, provisionDeviceProfileCredentials2);
    int expectedHashCodeResult = provisionDeviceProfileCredentials.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceProfileCredentials2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}, and {@link ProvisionDeviceProfileCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceProfileCredentials#equals(Object)}
   *   <li>{@link ProvisionDeviceProfileCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", null);
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials2 = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", null);

    // Act and Assert
    assertEquals(provisionDeviceProfileCredentials, provisionDeviceProfileCredentials2);
    int expectedHashCodeResult = provisionDeviceProfileCredentials.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceProfileCredentials2.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}, and {@link ProvisionDeviceProfileCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceProfileCredentials#equals(Object)}
   *   <li>{@link ProvisionDeviceProfileCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", "Provision Device Secret");

    // Act and Assert
    assertEquals(provisionDeviceProfileCredentials, provisionDeviceProfileCredentials);
    int expectedHashCodeResult = provisionDeviceProfileCredentials.hashCode();
    assertEquals(expectedHashCodeResult, provisionDeviceProfileCredentials.hashCode());
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Secret", "Provision Device Secret");

    // Act and Assert
    assertNotEquals(provisionDeviceProfileCredentials,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"));
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(null,
        "Provision Device Secret");

    // Act and Assert
    assertNotEquals(provisionDeviceProfileCredentials,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"));
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", "Provision Device Key");

    // Act and Assert
    assertNotEquals(provisionDeviceProfileCredentials,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"));
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionDeviceProfileCredentials provisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", null);

    // Act and Assert
    assertNotEquals(provisionDeviceProfileCredentials,
        new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"));
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), null);
  }

  /**
   * Test {@link ProvisionDeviceProfileCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProvisionDeviceProfileCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProvisionDeviceProfileCredentials.equals(Object)",
      "int ProvisionDeviceProfileCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"),
        "Different type to ProvisionDeviceProfileCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProvisionDeviceProfileCredentials#ProvisionDeviceProfileCredentials(String, String)}
   *   <li>{@link ProvisionDeviceProfileCredentials#toString()}
   *   <li>{@link ProvisionDeviceProfileCredentials#getProvisionDeviceKey()}
   *   <li>{@link ProvisionDeviceProfileCredentials#getProvisionDeviceSecret()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProvisionDeviceProfileCredentials.<init>(String, String)",
      "String ProvisionDeviceProfileCredentials.getProvisionDeviceKey()",
      "String ProvisionDeviceProfileCredentials.getProvisionDeviceSecret()",
      "String ProvisionDeviceProfileCredentials.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ProvisionDeviceProfileCredentials actualProvisionDeviceProfileCredentials = new ProvisionDeviceProfileCredentials(
        "Provision Device Key", "Provision Device Secret");
    String actualToStringResult = actualProvisionDeviceProfileCredentials.toString();
    String actualProvisionDeviceKey = actualProvisionDeviceProfileCredentials.getProvisionDeviceKey();

    // Assert
    assertEquals("Provision Device Key", actualProvisionDeviceKey);
    assertEquals("Provision Device Secret", actualProvisionDeviceProfileCredentials.getProvisionDeviceSecret());
    assertEquals(
        "ProvisionDeviceProfileCredentials(provisionDeviceKey=Provision Device Key, provisionDeviceSecret=Provision"
            + " Device Secret)",
        actualToStringResult);
  }
}
