package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  void testGetDecodedCServerPublicKey() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential = new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("Server Public Key");

    // Act and Assert
    assertArrayEquals(new byte[]{'I', -22, -17, 'z', -77, -18, 'n', 'X', -100, ')', -20},
        noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  void testGetDecodedCServerPublicKey2() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential = new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("U");

    // Act and Assert
    assertEquals(0, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey().length);
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  void testGetDecodedCServerPublicKey3() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential = new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("");

    // Act and Assert
    assertEquals(0, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey().length);
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  void testGetDecodedCServerPublicKey4() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential = new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("Server Public KeyU");

    // Act and Assert
    assertArrayEquals(new byte[]{'I', -22, -17, 'z', -77, -18, 'n', 'X', -100, ')', -20, -108},
        noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey(); then return array of byte with minus twenty-nine")
  void testGetDecodedCServerPublicKey_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential = new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }
}
