package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RPKClientCredentialDiffblueTest {
  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKey()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("Key");

    // Act and Assert
    assertArrayEquals(new byte[] {')', -20}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code Key42}.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'Key42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKey42()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("Key42");

    // Act and Assert
    assertArrayEquals(new byte[] {')', -20, -72}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code KeyKey}.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'KeyKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKeyKey()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("KeyKey");

    // Act and Assert
    assertArrayEquals(new byte[] {')', -20, -118, '{'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNine()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("42");

    // Act and Assert
    assertArrayEquals(new byte[] {-29}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine and {@code n}.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine and 'n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNineAndN()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("4242");

    // Act and Assert
    assertArrayEquals(new byte[] {-29, 'n', '6'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnEmptyArrayOfByte()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    rpkClientCredential.setKey("");

    // Act and Assert
    assertArrayEquals(new byte[] {}, rpkClientCredential.getDecoded());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RPKClientCredential}
   *   <li>{@link RPKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RPKClientCredential.<init>()",
    "LwM2MSecurityMode RPKClientCredential.getSecurityConfigClientMode()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RPKClientCredential actualRpkClientCredential = new RPKClientCredential();
    LwM2MSecurityMode actualSecurityConfigClientMode =
        actualRpkClientCredential.getSecurityConfigClientMode();

    // Assert
    assertNull(actualRpkClientCredential.getEndpoint());
    assertNull(actualRpkClientCredential.getKey());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityConfigClientMode);
  }
}
