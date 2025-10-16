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

class X509ClientCredentialDiffblueTest {
  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Given {@link X509ClientCredential} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName(
      "Test getDecoded(); given X509ClientCredential (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] X509ClientCredential.getDecoded()"})
  void testGetDecoded_givenX509ClientCredential_thenReturnNull()
      throws IllegalArgumentException, DecoderException {
    // Arrange, Act and Assert
    assertNull(new X509ClientCredential().getDecoded());
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with minus twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] X509ClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithMinusTwentyNine()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("42");
    x509ClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    x509ClientCredential.setKey("Key");

    // Act and Assert
    assertArrayEquals(new byte[] {-29}, x509ClientCredential.getDecoded());
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with tab and minus twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return array of byte with tab and minus twenty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] X509ClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnArrayOfByteWithTabAndMinusTwentyTwo()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("Cert");
    x509ClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    x509ClientCredential.setKey("Key");

    // Act and Assert
    assertArrayEquals(new byte[] {'\t', -22, -19}, x509ClientCredential.getDecoded());
  }

  /**
   * Test {@link X509ClientCredential#getDecoded()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link X509ClientCredential#getDecoded()}
   */
  @Test
  @DisplayName("Test getDecoded(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] X509ClientCredential.getDecoded()"})
  void testGetDecoded_thenReturnEmptyArrayOfByte()
      throws IllegalArgumentException, DecoderException {
    // Arrange
    X509ClientCredential x509ClientCredential = new X509ClientCredential();
    x509ClientCredential.setCert("");
    x509ClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");
    x509ClientCredential.setKey("Key");

    // Act and Assert
    assertArrayEquals(new byte[] {}, x509ClientCredential.getDecoded());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link X509ClientCredential}
   *   <li>{@link X509ClientCredential#setCert(String)}
   *   <li>{@link X509ClientCredential#getCert()}
   *   <li>{@link X509ClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void X509ClientCredential.<init>()",
    "String X509ClientCredential.getCert()",
    "LwM2MSecurityMode X509ClientCredential.getSecurityConfigClientMode()",
    "void X509ClientCredential.setCert(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    X509ClientCredential actualX509ClientCredential = new X509ClientCredential();
    actualX509ClientCredential.setCert("Cert");
    String actualCert = actualX509ClientCredential.getCert();
    LwM2MSecurityMode actualSecurityConfigClientMode =
        actualX509ClientCredential.getSecurityConfigClientMode();

    // Assert
    assertEquals("Cert", actualCert);
    assertNull(actualX509ClientCredential.getEndpoint());
    assertNull(actualX509ClientCredential.getKey());
    assertEquals(LwM2MSecurityMode.X509, actualSecurityConfigClientMode);
  }
}
