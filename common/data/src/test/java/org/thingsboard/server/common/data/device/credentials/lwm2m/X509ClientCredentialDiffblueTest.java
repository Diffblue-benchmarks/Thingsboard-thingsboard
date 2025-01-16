package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class X509ClientCredentialDiffblueTest {
  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link X509ClientCredential} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given X509ClientCredential (default constructor); then return 'null'")
  void testGetDecoded_givenX509ClientCredential_thenReturnNull() throws IllegalArgumentException, DecoderException {
    // Arrange, Act and Assert
    assertNull((new X509ClientCredential()).getDecoded());
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array length is zero")
  void testGetDecoded_thenReturnArrayLengthIsZero() throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("");

    // Act and Assert
    assertEquals(0, x509ClientCredential.getDecoded().length);
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with tab and minus twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with tab and minus twenty-two")
  void testGetDecoded_thenReturnArrayOfByteWithTabAndMinusTwentyTwo()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("Cert");

    // Act and Assert
    assertArrayEquals(new byte[]{'\t', -22, -19}, x509ClientCredential.getDecoded());
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return {@link X509ClientCredential} (default constructor)
   * {@link AbstractLwM2MClientSecurityCredential#securityInBytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return X509ClientCredential (default constructor) securityInBytes")
  void testGetDecoded_thenReturnX509ClientCredentialSecurityInBytes()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("42");

    // Act
    byte[] actualDecoded = x509ClientCredential.getDecoded();

    // Assert
    assertSame(x509ClientCredential.securityInBytes, actualDecoded);
    assertArrayEquals(new byte[]{-29}, actualDecoded);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link X509ClientCredential}
   *   <li>{@link X509ClientCredential#setCert(String)}
   *   <li>{@link X509ClientCredential#getCert()}
   *   <li>{@link X509ClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    X509ClientCredential actualX509ClientCredential = new X509ClientCredential();
    actualX509ClientCredential.setCert("Cert");
    String actualCert = actualX509ClientCredential.getCert();

    // Assert that nothing has changed
    assertEquals("Cert", actualCert);
    assertEquals(LwM2MSecurityMode.X509, actualX509ClientCredential.getSecurityConfigClientMode());
  }
}
