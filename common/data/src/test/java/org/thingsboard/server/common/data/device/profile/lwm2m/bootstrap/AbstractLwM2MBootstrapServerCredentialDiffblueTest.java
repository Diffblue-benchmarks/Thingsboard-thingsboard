package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   *
   * <p>Method under test: {@link
   * AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapServerCredential.getDecodedCServerPublicKey()"})
  void testGetDecodedCServerPublicKey() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("Server Public Key");

    // Act and Assert
    assertArrayEquals(
        new byte[] {'I', -22, -17, 'z', -77, -18, 'n', 'X', -100, ')', -20},
        noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   *
   * <p>Method under test: {@link
   * AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapServerCredential.getDecodedCServerPublicKey()"})
  void testGetDecodedCServerPublicKey2() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("U");

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   *
   * <p>Method under test: {@link
   * AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapServerCredential.getDecodedCServerPublicKey()"})
  void testGetDecodedCServerPublicKey3() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("");

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   *
   * <p>Method under test: {@link
   * AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName("Test getDecodedCServerPublicKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapServerCredential.getDecodedCServerPublicKey()"})
  void testGetDecodedCServerPublicKey4() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("Server Public KeyU");

    // Act and Assert
    assertArrayEquals(
        new byte[] {'I', -22, -17, 'z', -77, -18, 'n', 'X', -100, ')', -20, -108},
        noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLwM2MBootstrapServerCredential#getDecodedCServerPublicKey()}
   */
  @Test
  @DisplayName(
      "Test getDecodedCServerPublicKey(); then return array of byte with minus twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapServerCredential.getDecodedCServerPublicKey()"})
  void testGetDecodedCServerPublicKey_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    NoSecLwM2MBootstrapServerCredential noSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    noSecLwM2MBootstrapServerCredential.setServerPublicKey("42");

    // Act and Assert
    assertArrayEquals(
        new byte[] {-29}, noSecLwM2MBootstrapServerCredential.getDecodedCServerPublicKey());
  }
}
