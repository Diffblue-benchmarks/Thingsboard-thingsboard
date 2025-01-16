package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RPKClientCredentialDiffblueTest {
  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is
   * {@code Key42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'Key42'")
  void testGetDecoded_givenRPKClientCredentialKeyIsKey42() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("Key42");

    // Act and Assert
    assertArrayEquals(new byte[]{')', -20, -72}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is
   * {@code KeyKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'KeyKey'")
  void testGetDecoded_givenRPKClientCredentialKeyIsKeyKey() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("KeyKey");

    // Act and Assert
    assertArrayEquals(new byte[]{')', -20, -118, '{'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array length is zero")
  void testGetDecoded_thenReturnArrayLengthIsZero() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("");

    // Act and Assert
    assertEquals(0, rpkClientCredential.getDecoded().length);
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine")
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNine() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("42");

    // Act
    byte[] actualDecoded = rpkClientCredential.getDecoded();

    // Assert
    assertSame(rpkClientCredential.securityInBytes, actualDecoded);
    assertArrayEquals(new byte[]{-29}, actualDecoded);
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine and
   * {@code n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine and 'n'")
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNineAndN() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("4242");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, 'n', '6'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RPKClientCredential}
   *   <li>{@link RPKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RPKClientCredential actualRpkClientCredential = new RPKClientCredential();
    LwM2MSecurityMode actualSecurityConfigClientMode = actualRpkClientCredential.getSecurityConfigClientMode();

    // Assert
    assertNull(actualRpkClientCredential.getEndpoint());
    assertNull(actualRpkClientCredential.getKey());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityConfigClientMode);
  }
}
