package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PSKClientCredentialDiffblueTest {
  /**
   * Test {@link PSKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return {@link PSKClientCredential} (default constructor)
   * {@link AbstractLwM2MClientSecurityCredential#securityInBytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PSKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return PSKClientCredential (default constructor) securityInBytes")
  void testGetDecoded_thenReturnPSKClientCredentialSecurityInBytes() throws IllegalArgumentException, DecoderException {
    // Arrange
    PSKClientCredential pskClientCredential = new PSKClientCredential();
    pskClientCredential.setKey("42");

    // Act
    byte[] actualDecoded = pskClientCredential.getDecoded();

    // Assert
    assertSame(pskClientCredential.securityInBytes, actualDecoded);
    assertArrayEquals(new byte[]{'B'}, actualDecoded);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PSKClientCredential}
   *   <li>{@link PSKClientCredential#setIdentity(String)}
   *   <li>{@link PSKClientCredential#getIdentity()}
   *   <li>{@link PSKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    PSKClientCredential actualPskClientCredential = new PSKClientCredential();
    actualPskClientCredential.setIdentity("Identity");
    String actualIdentity = actualPskClientCredential.getIdentity();

    // Assert that nothing has changed
    assertEquals("Identity", actualIdentity);
    assertEquals(LwM2MSecurityMode.PSK, actualPskClientCredential.getSecurityConfigClientMode());
  }
}
