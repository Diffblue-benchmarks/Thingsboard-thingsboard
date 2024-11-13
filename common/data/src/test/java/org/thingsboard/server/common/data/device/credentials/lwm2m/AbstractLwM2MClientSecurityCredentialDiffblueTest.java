package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractLwM2MClientSecurityCredentialDiffblueTest {
  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#getKey()}.
   * <p>
   * Method under test: {@link AbstractLwM2MClientSecurityCredential#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new PSKClientCredential()).getKey());
  }

  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#setKey(String)}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MClientSecurityCredential#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String)")
  void testSetKey() {
    // Arrange
    PSKClientCredential pskClientCredential = new PSKClientCredential();

    // Act
    pskClientCredential.setKey("Key");

    // Assert
    assertEquals("Key", pskClientCredential.getKey());
  }
}
