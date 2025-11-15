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
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

class X509ClientCredentialDiffblueTest {
  /**
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  void testGetDecoded() throws IllegalArgumentException, DecoderException {
    // Arrange, Act and Assert
    assertNull((new X509ClientCredential()).getDecoded());
  }

  /**
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  void testGetDecoded2() throws IllegalArgumentException, DecoderException {
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
   * Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  void testGetDecoded3() throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("");

    // Act
    byte[] actualDecoded = x509ClientCredential.getDecoded();

    // Assert
    assertEquals(0, actualDecoded.length);
    assertSame(x509ClientCredential.securityInBytes, actualDecoded);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link X509ClientCredential}
   *   <li>{@link X509ClientCredential#setCert(String)}
   *   <li>{@link X509ClientCredential#getCert()}
   *   <li>{@link X509ClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
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
