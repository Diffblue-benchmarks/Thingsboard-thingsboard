package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrivacyProtocolDiffblueTest {
  /**
   * Test {@link PrivacyProtocol#forName(String)}.
   * <ul>
   *   <li>When {@code AES_128}.</li>
   *   <li>Then return {@link Optional#get()} is {@code AES_128}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrivacyProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'AES_128'; then return get() is 'AES_128'")
  void testForName_whenAes128_thenReturnGetIsAes128() {
    // Arrange and Act
    Optional<PrivacyProtocol> actualForNameResult = PrivacyProtocol.forName("AES_128");

    // Assert
    assertEquals(PrivacyProtocol.AES_128, actualForNameResult.get());
    assertTrue(actualForNameResult.isPresent());
  }

  /**
   * Test {@link PrivacyProtocol#forName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrivacyProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then return not Present")
  void testForName_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<PrivacyProtocol> actualForNameResult = PrivacyProtocol.forName("Name");

    // Assert
    assertFalse(actualForNameResult.isPresent());
  }
}
