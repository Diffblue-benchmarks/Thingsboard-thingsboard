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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ClaimRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    ClaimRequest claimRequest2 = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(claimRequest, claimRequest2);
    int expectedHashCodeResult = claimRequest.hashCode();
    assertEquals(expectedHashCodeResult, claimRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest(null);
    ClaimRequest claimRequest2 = new ClaimRequest(null);

    // Act and Assert
    assertEquals(claimRequest, claimRequest2);
    int expectedHashCodeResult = claimRequest.hashCode();
    assertEquals(expectedHashCodeResult, claimRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(claimRequest, claimRequest);
    int expectedHashCodeResult = claimRequest.hashCode();
    assertEquals(expectedHashCodeResult, claimRequest.hashCode());
  }

  /**
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("Secret Key");

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest(null);

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), null);
  }

  /**
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), "Different type to ClaimRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#ClaimRequest(String)}
   *   <li>{@link ClaimRequest#toString()}
   *   <li>{@link ClaimRequest#getSecretKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ClaimRequest actualClaimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    String actualToStringResult = actualClaimRequest.toString();

    // Assert
    assertEquals("ClaimRequest(secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualClaimRequest.getSecretKey());
  }
}
