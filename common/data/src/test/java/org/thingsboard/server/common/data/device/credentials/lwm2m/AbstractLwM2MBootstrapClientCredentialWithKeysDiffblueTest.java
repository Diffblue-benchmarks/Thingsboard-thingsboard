/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AbstractLwM2MBootstrapClientCredentialWithKeysDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientPublicKeyOrId()}
   */
  @Test
  void testGetClientPublicKeyOrId() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientPublicKeyOrId());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  void testGetDecodedClientPublicKeyOrId() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  void testGetDecodedClientPublicKeyOrId2() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("Client Public Key Or Id");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -45, -18, 'n', 'X', -100, ')', -20, -114, -84, -121},
        pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  void testGetDecodedClientPublicKeyOrId3() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("");

    // Act and Assert
    assertEquals(0, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId().length);
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  void testGetDecodedClientPublicKeyOrId4() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("4242");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, 'n', '6'}, pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientPublicKeyOrId()}
   */
  @Test
  void testGetDecodedClientPublicKeyOrId5() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42Client Public Key Or Id");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, '`', -91, -119, -23, -19, '>', -26, -27, -119, -62, -98, -56, -22, -56},
        pskBootstrapClientCredential.getDecodedClientPublicKeyOrId());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  void testGetDecodedClientSecretKey() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertArrayEquals(new byte[]{17, 'p', '\f', '<', -79, '\n', 17, -116, '#', 'j', 'Z', -41, 'R', -39, -59, 16, -62,
        '?', '+', -77, 3, 16, -47, -65, 'l', -4, 'Q', '~', ' ', -104},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  void testGetDecodedClientSecretKey2() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  void testGetDecodedClientSecretKey3() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  void testGetDecodedClientSecretKey4() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("");

    // Act and Assert
    assertEquals(0, pskBootstrapClientCredential.getDecodedClientSecretKey().length);
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getDecodedClientSecretKey()}
   */
  @Test
  void testGetDecodedClientSecretKey5() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientSecretKey("Client Secret Key42");

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 'X', -98, -98, -44, -98, 'r', -73, -83, ')', -20, -72},
        pskBootstrapClientCredential.getDecodedClientSecretKey());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#getClientSecretKey()}
   */
  @Test
  void testGetClientSecretKey() {
    // Arrange, Act and Assert
    assertNull((new PSKBootstrapClientCredential()).getClientSecretKey());
  }

  /**
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientPublicKeyOrId(String)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLwM2MBootstrapClientCredentialWithKeys#setClientSecretKey(String)}
   */
  @Test
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
