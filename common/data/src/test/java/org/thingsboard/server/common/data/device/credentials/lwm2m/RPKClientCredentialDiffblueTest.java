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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RPKClientCredentialDiffblueTest {
  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKey() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("Key");

    // Act and Assert
    assertArrayEquals(new byte[]{')', -20}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code Key42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'Key42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKey42() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("Key42");

    // Act and Assert
    assertArrayEquals(new byte[]{')', -20, -72}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Given {@link RPKClientCredential} (default constructor) Key is {@code KeyKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); given RPKClientCredential (default constructor) Key is 'KeyKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_givenRPKClientCredentialKeyIsKeyKey() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("KeyKey");

    // Act and Assert
    assertArrayEquals(new byte[]{')', -20, -118, '{'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNine() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("42");

    // Act and Assert
    assertArrayEquals(new byte[]{-29}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine and {@code n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine and 'n'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNineAndN() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("4242");

    // Act and Assert
    assertArrayEquals(new byte[]{-29, 'n', '6'}, rpkClientCredential.getDecoded());
  }

  /**
   * Test {@link RPKClientCredential#getDecoded()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RPKClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RPKClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnEmptyArrayOfByte() throws IllegalArgumentException, DecoderException {
    // Arrange
    RPKClientCredential rpkClientCredential = new RPKClientCredential();
    rpkClientCredential.setKey("");

    // Act and Assert
    assertArrayEquals(new byte[]{}, rpkClientCredential.getDecoded());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RPKClientCredential}
   *   <li>{@link RPKClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RPKClientCredential.<init>()",
      "LwM2MSecurityMode RPKClientCredential.getSecurityConfigClientMode()"})
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
