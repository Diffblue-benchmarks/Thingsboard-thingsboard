package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AzureIotHubUtilDiffblueTest {
  /**
   * Test {@link AzureIotHubUtil#buildUsername(String, String)}.
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildUsername(String, String)}
   */
  @Test
  @DisplayName("Test buildUsername(String, String)")
  void testBuildUsername() {
    // Arrange, Act and Assert
    assertEquals("localhost/42/?api-version=2018-06-30", AzureIotHubUtil.buildUsername("localhost", "42"));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when empty string; then throw RuntimeException")
  void testBuildSasToken_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", ""));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   * <ul>
   *   <li>When {@code Sas Key}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when 'Sas Key'; then throw RuntimeException")
  void testBuildSasToken_whenSasKey_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", "Sas Key"));
  }
}
