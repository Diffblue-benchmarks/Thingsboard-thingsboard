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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PSKClientCredentialDiffblueTest {
  /**
   * Test {@link PSKClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Given {@link PSKClientCredential} (default constructor) Key is {@code 42}.
   *   <li>Then return array of {@code byte} with {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link PSKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName(
      "Test getDecoded(); given PSKClientCredential (default constructor) Key is '42'; then return array of byte with 'B'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PSKClientCredential.getDecoded()"})
  void testGetDecoded_givenPSKClientCredentialKeyIs42_thenReturnArrayOfByteWithB()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    PSKClientCredential pskClientCredential = new PSKClientCredential();
    pskClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    pskClientCredential.setIdentity("Identity");
    pskClientCredential.setKey("42");

    // Act and Assert
    assertArrayEquals(new byte[] {'B'}, pskClientCredential.getDecoded());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PSKClientCredential}
   *   <li>{@link PSKClientCredential#setIdentity(String)}
   *   <li>{@link PSKClientCredential#getIdentity()}
   *   <li>{@link PSKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PSKClientCredential.<init>()",
    "String PSKClientCredential.getIdentity()",
    "LwM2MSecurityMode PSKClientCredential.getSecurityConfigClientMode()",
    "void PSKClientCredential.setIdentity(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PSKClientCredential actualPskClientCredential = new PSKClientCredential();
    actualPskClientCredential.setIdentity("Identity");
    String actualIdentity = actualPskClientCredential.getIdentity();
    LwM2MSecurityMode actualSecurityConfigClientMode =
        actualPskClientCredential.getSecurityConfigClientMode();

    // Assert
    assertEquals("Identity", actualIdentity);
    assertNull(actualPskClientCredential.getEndpoint());
    assertNull(actualPskClientCredential.getKey());
    assertEquals(LwM2MSecurityMode.PSK, actualSecurityConfigClientMode);
  }
}
