package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PSKClientCredentialDiffblueTest {
  /**
   * Test {@link PSKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link PSKClientCredential} (default constructor) Key is {@code 42}.</li>
   *   <li>Then return array of {@code byte} with {@code B}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PSKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given PSKClientCredential (default constructor) Key is '42'; then return array of byte with 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PSKClientCredential.getDecoded()"})
  void testGetDecoded_givenPSKClientCredentialKeyIs42_thenReturnArrayOfByteWithB()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    PSKClientCredential pskClientCredential = new PSKClientCredential();
    pskClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    pskClientCredential.setIdentity("Identity");
    pskClientCredential.setKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{'B'}, pskClientCredential.getDecoded());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PSKClientCredential.<init>()", "String PSKClientCredential.getIdentity()",
      "LwM2MSecurityMode PSKClientCredential.getSecurityConfigClientMode()",
      "void PSKClientCredential.setIdentity(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    PSKClientCredential actualPskClientCredential = new PSKClientCredential();
    actualPskClientCredential.setIdentity("Identity");
    String actualIdentity = actualPskClientCredential.getIdentity();
    LwM2MSecurityMode actualSecurityConfigClientMode = actualPskClientCredential.getSecurityConfigClientMode();

    // Assert
    assertEquals("Identity", actualIdentity);
    assertNull(actualPskClientCredential.getEndpoint());
    assertNull(actualPskClientCredential.getKey());
    assertEquals(LwM2MSecurityMode.PSK, actualSecurityConfigClientMode);
  }
}
