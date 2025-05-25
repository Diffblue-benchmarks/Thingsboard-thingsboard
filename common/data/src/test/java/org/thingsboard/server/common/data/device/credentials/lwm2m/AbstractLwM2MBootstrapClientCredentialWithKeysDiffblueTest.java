package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLwM2MBootstrapClientCredentialWithKeysDiffblueTest {
  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientPublicKeyOrId()"})
  void testGetDecodedClientPublicKeyOrId() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42Client Public Key Or Id");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, '`', -91, -119, -23, -19, '>', -26, -27, -119, -62, -98, -56, -22, -56},
        pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with lf and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientPublicKeyOrId()"})
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithLfAndX() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("Client Public Key Or Id");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -45, -18, 'n', 'X', -100, ')', -20, -114, -84, -121},
        pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with minus twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientPublicKeyOrId()"})
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine and {@code n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with minus twenty-nine and 'n'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientPublicKeyOrId()"})
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithMinusTwentyNineAndN() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("4242");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, 'n', '6'}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientPublicKeyOrId()"})
  void testGetDecodedClientPublicKeyOrId_thenReturnEmptyArrayOfByte() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("");

    // Act and Assert
    assertArrayEquals(new byte[]{}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientSecretKey()"})
  void testGetDecodedClientSecretKey() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientSecretKey()"})
  void testGetDecodedClientSecretKey2() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key42");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20, -72},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return array of byte with minus twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientSecretKey()"})
  void testGetDecodedClientSecretKey_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with seventeen and {@code p}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return array of byte with seventeen and 'p'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientSecretKey()"})
  void testGetDecodedClientSecretKey_thenReturnArrayOfByteWithSeventeenAndP() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertArrayEquals(new byte[]{17, 'p', '\f', '<', -79, '\n', 17, -116, '#', 'j', 'Z', -41, 'R', -39, -59, 16, -62,
        '?', '+', -77, 3, 16, -47, -65, 'l', -4, 'Q', '~', ' ', -104},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractLwM2MBootstrapClientCredentialWithKeys.getDecodedClientSecretKey()"})
  void testGetDecodedClientSecretKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("");

    // Act and Assert
    assertArrayEquals(new byte[]{}, pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientPublicKeyOrId()}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getClientPublicKeyOrId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractLwM2MBootstrapClientCredentialWithKeys.getClientPublicKeyOrId()"})
  void testGetClientPublicKeyOrId() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientSecretKey()}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientSecretKey()}
   */
  @Test
  @DisplayName("Test getClientSecretKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractLwM2MBootstrapClientCredentialWithKeys.getClientSecretKey()"})
  void testGetClientSecretKey() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientSecretKey());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientPublicKeyOrId(String)}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientPublicKeyOrId(String)}
   */
  @Test
  @DisplayName("Test setClientPublicKeyOrId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractLwM2MBootstrapClientCredentialWithKeys.setClientPublicKeyOrId(String)"})
  void testSetClientPublicKeyOrId() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();

    // Act
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");

    // Assert
    assertEquals("42", pskBootstrapClientCredential.getClientPublicKeyOrId());
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientSecretKey(String)}.
   * <p>
   * Method under test: {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientSecretKey(String)}
   */
  @Test
  @DisplayName("Test setClientSecretKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractLwM2MBootstrapClientCredentialWithKeys.setClientSecretKey(String)"})
  void testSetClientSecretKey() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();

    // Act
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Assert
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", pskBootstrapClientCredential.getClientSecretKey());
    assertArrayEquals(new byte[]{17, 'p', '\f', '<', -79, '\n', 17, -116, '#', 'j', 'Z', -41, 'R', -39, -59, 16, -62,
        '?', '+', -77, 3, 16, -47, -65, 'l', -4, 'Q', '~', ' ', -104},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }
}
