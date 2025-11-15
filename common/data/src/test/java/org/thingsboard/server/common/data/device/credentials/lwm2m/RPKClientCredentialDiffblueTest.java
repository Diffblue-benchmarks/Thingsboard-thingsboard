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

class RPKClientCredentialDiffblueTest {
  /**
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  void testGetDecoded() throws IllegalArgumentException, DecoderException {
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
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  void testGetDecoded2() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("");

    // Act
    byte[] actualDecoded = rpkClientCredential.getDecoded();

    // Assert
    assertEquals(0, actualDecoded.length);
    assertSame(rpkClientCredential.securityInBytes, actualDecoded);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RPKClientCredential}
   *   <li>{@link RPKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
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
