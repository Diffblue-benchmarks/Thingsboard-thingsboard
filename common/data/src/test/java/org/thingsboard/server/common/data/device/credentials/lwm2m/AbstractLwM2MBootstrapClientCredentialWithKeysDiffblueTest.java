package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractLwM2MBootstrapClientCredentialWithKeysDiffblueTest {
  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId()")
  void testGetDecodedClientPublicKeyOrId() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42Client Public Key Or Id");

    // Act
    byte[] actualDecodedClientPublicKeyOrId = pskBootstrapClientCredential.getDecodedClientPublicKeyOrId();

    // Assert
    assertEquals((byte) -119, actualDecodedClientPublicKeyOrId[3]);
    assertEquals((byte) -119, actualDecodedClientPublicKeyOrId[9]);
    assertEquals((byte) -19, actualDecodedClientPublicKeyOrId[5]);
    assertEquals((byte) -22, actualDecodedClientPublicKeyOrId[13]);
    assertEquals((byte) -23, actualDecodedClientPublicKeyOrId[4]);
    assertEquals((byte) -26, actualDecodedClientPublicKeyOrId[7]);
    assertEquals((byte) -27, actualDecodedClientPublicKeyOrId[8]);
    assertEquals((byte) -56, actualDecodedClientPublicKeyOrId[12]);
    assertEquals((byte) -56, actualDecodedClientPublicKeyOrId[14]);
    assertEquals((byte) -62, actualDecodedClientPublicKeyOrId[10]);
    assertEquals((byte) -91, actualDecodedClientPublicKeyOrId[2]);
    assertEquals((byte) -98, actualDecodedClientPublicKeyOrId[11]);
    assertEquals(15, actualDecodedClientPublicKeyOrId.length);
    assertEquals('>', actualDecodedClientPublicKeyOrId[6]);
    assertEquals('`', actualDecodedClientPublicKeyOrId[1]);
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array length is zero")
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayLengthIsZero() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("");

    // Act and Assert
    assertEquals(0, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId().length);
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with lf and 'X'")
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithLfAndX() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("Client Public Key Or Id");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -45, -18, 'n', 'X', -100, ')', -20, -114, -84, -121},
        pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with minus twenty-nine")
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine and
   * {@code n}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getDecodedClientPublicKeyOrId(); then return array of byte with minus twenty-nine and 'n'")
  void testGetDecodedClientPublicKeyOrId_thenReturnArrayOfByteWithMinusTwentyNineAndN() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("4242");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, 'n', '6'}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey()")
  void testGetDecodedClientSecretKey() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey()")
  void testGetDecodedClientSecretKey2() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key42");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20, -72},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return array length is zero")
  void testGetDecodedClientSecretKey_thenReturnArrayLengthIsZero() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("");

    // Act and Assert
    assertEquals(0, pskBootstrapClientCredential.getDecodedClientSecretKey().length);
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return array of byte with minus twenty-nine")
  void testGetDecodedClientSecretKey_thenReturnArrayOfByteWithMinusTwentyNine() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with seventeen and {@code p}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  @DisplayName("Test getDecodedClientSecretKey(); then return array of byte with seventeen and 'p'")
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
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientPublicKeyOrId()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientPublicKeyOrId()}
   */
  @Test
  @DisplayName("Test getClientPublicKeyOrId()")
  void testGetClientPublicKeyOrId() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientPublicKeyOrId());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientSecretKey()}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientSecretKey()}
   */
  @Test
  @DisplayName("Test getClientSecretKey()")
  void testGetClientSecretKey() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientSecretKey());
  }

  /**
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientPublicKeyOrId(String)}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientPublicKeyOrId(String)}
   */
  @Test
  @DisplayName("Test setClientPublicKeyOrId(String)")
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
   * Test
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientSecretKey(String)}.
   * <p>
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientSecretKey(String)}
   */
  @Test
  @DisplayName("Test setClientSecretKey(String)")
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
