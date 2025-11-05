package org.thingsboard.rule.engine.mqtt.azure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAzureIotHubNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAzureIotHubNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbAzureIotHubNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbAzureIotHubNodeConfiguration TbAzureIotHubNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();

    // Act
    TbAzureIotHubNodeConfiguration actualDefaultConfigurationResult =
        tbAzureIotHubNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbAzureIotHubNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbAzureIotHubNodeConfiguration#equals(Object)}, and {@link
   * TbAzureIotHubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbAzureIotHubNodeConfiguration#equals(Object)}
   *   <li>{@link TbAzureIotHubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAzureIotHubNodeConfiguration.equals(Object)",
    "int TbAzureIotHubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration2 =
        new TbAzureIotHubNodeConfiguration();

    // Act and Assert
    assertEquals(tbAzureIotHubNodeConfiguration, tbAzureIotHubNodeConfiguration2);
    assertEquals(
        tbAzureIotHubNodeConfiguration.hashCode(), tbAzureIotHubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAzureIotHubNodeConfiguration#equals(Object)}, and {@link
   * TbAzureIotHubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbAzureIotHubNodeConfiguration#equals(Object)}
   *   <li>{@link TbAzureIotHubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAzureIotHubNodeConfiguration.equals(Object)",
    "int TbAzureIotHubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();

    // Act and Assert
    assertEquals(tbAzureIotHubNodeConfiguration, tbAzureIotHubNodeConfiguration);
    int expectedHashCodeResult = tbAzureIotHubNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAzureIotHubNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAzureIotHubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAzureIotHubNodeConfiguration.equals(Object)",
    "int TbAzureIotHubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAzureIotHubNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAzureIotHubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAzureIotHubNodeConfiguration.equals(Object)",
    "int TbAzureIotHubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAzureIotHubNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAzureIotHubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAzureIotHubNodeConfiguration.equals(Object)",
    "int TbAzureIotHubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbAzureIotHubNodeConfiguration(), "Different type to TbAzureIotHubNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbAzureIotHubNodeConfiguration}
   *   <li>{@link TbAzureIotHubNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAzureIotHubNodeConfiguration.<init>()",
    "java.lang.String TbAzureIotHubNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbAzureIotHubNodeConfiguration actualTbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();

    // Assert
    assertEquals(
        "TbAzureIotHubNodeConfiguration()", actualTbAzureIotHubNodeConfiguration.toString());
    assertNull(actualTbAzureIotHubNodeConfiguration.getClientId());
    assertNull(actualTbAzureIotHubNodeConfiguration.getHost());
    assertNull(actualTbAzureIotHubNodeConfiguration.getTopicPattern());
    assertNull(actualTbAzureIotHubNodeConfiguration.getCredentials());
    assertEquals(0, actualTbAzureIotHubNodeConfiguration.getConnectTimeoutSec());
    assertEquals(0, actualTbAzureIotHubNodeConfiguration.getPort());
    assertFalse(actualTbAzureIotHubNodeConfiguration.isAppendClientIdSuffix());
    assertFalse(actualTbAzureIotHubNodeConfiguration.isCleanSession());
    assertFalse(actualTbAzureIotHubNodeConfiguration.isParseToPlainText());
    assertFalse(actualTbAzureIotHubNodeConfiguration.isRetainedMessage());
    assertFalse(actualTbAzureIotHubNodeConfiguration.isSsl());
  }
}
