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
package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class LwM2mRPkCredentialsDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("Publ X", "Publ Y", "Priv S"));

    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials(null, null, "Priv S"));
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "Publ Y", "Priv S"));
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("secp256r1", "Publ Y", "Priv S"));
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "EC", "Priv S"));
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials2() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials3() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, null, "");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials4() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("", null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials5() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("Publ X", null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials6() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("Publ X", "", null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Method under test:
   * {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  void testNewLwM2mRPkCredentials7() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("EC", "EC", "EC");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
    assertFalse(actualLwM2mRPkCredentials.getServerPrivateKey().isDestroyed());
  }
}
