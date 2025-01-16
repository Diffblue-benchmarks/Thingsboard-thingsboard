package org.thingsboard.rule.engine.mqtt.azure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.credentials.CredentialsType;

class AzureIotHubSasCredentialsDiffblueTest {
  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and
   * {@link AzureIotHubSasCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
    int expectedHashCodeResult = azureIotHubSasCredentials.hashCode();
    assertEquals(expectedHashCodeResult, azureIotHubSasCredentials2.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and
   * {@link AzureIotHubSasCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials.setSasKey("Sas Key");

    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials2.setSasKey("Sas Key");

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
    int expectedHashCodeResult = azureIotHubSasCredentials.hashCode();
    assertEquals(expectedHashCodeResult, azureIotHubSasCredentials2.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and
   * {@link AzureIotHubSasCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials);
    int expectedHashCodeResult = azureIotHubSasCredentials.hashCode();
    assertEquals(expectedHashCodeResult, azureIotHubSasCredentials.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), 1);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(azureIotHubSasCredentials, new AzureIotHubSasCredentials());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();

    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials2.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), null);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), "Different type to AzureIotHubSasCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AzureIotHubSasCredentials}
   *   <li>{@link AzureIotHubSasCredentials#setSasKey(String)}
   *   <li>{@link AzureIotHubSasCredentials#toString()}
   *   <li>{@link AzureIotHubSasCredentials#getSasKey()}
   *   <li>{@link AzureIotHubSasCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AzureIotHubSasCredentials actualAzureIotHubSasCredentials = new AzureIotHubSasCredentials();
    actualAzureIotHubSasCredentials.setSasKey("Sas Key");
    String actualToStringResult = actualAzureIotHubSasCredentials.toString();
    String actualSasKey = actualAzureIotHubSasCredentials.getSasKey();

    // Assert that nothing has changed
    assertEquals("AzureIotHubSasCredentials(sasKey=Sas Key)", actualToStringResult);
    assertEquals("Sas Key", actualSasKey);
    assertEquals(CredentialsType.SAS, actualAzureIotHubSasCredentials.getType());
  }
}
