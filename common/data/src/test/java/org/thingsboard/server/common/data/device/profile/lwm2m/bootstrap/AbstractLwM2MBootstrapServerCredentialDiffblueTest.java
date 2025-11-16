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
package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
