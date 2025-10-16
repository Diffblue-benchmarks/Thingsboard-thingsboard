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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClaimRequestDiffblueTest {
  /**
   * Test {@link ClaimRequest#equals(Object)}, and {@link ClaimRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    ClaimRequest claimRequest2 = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(claimRequest, claimRequest2);
    assertEquals(claimRequest.hashCode(), claimRequest2.hashCode());
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}, and {@link ClaimRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest(null);
    ClaimRequest claimRequest2 = new ClaimRequest(null);

    // Act and Assert
    assertEquals(claimRequest, claimRequest2);
    assertEquals(claimRequest.hashCode(), claimRequest2.hashCode());
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}, and {@link ClaimRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(claimRequest, claimRequest);
    int expectedHashCodeResult = claimRequest.hashCode();
    assertEquals(expectedHashCodeResult, claimRequest.hashCode());
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("Secret Key");

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest(null);

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), null);
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimRequest.equals(Object)", "int ClaimRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
        "Different type to ClaimRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimRequest#ClaimRequest(String)}
   *   <li>{@link ClaimRequest#toString()}
   *   <li>{@link ClaimRequest#getSecretKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClaimRequest.<init>(String)",
    "String ClaimRequest.getSecretKey()",
    "String ClaimRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ClaimRequest actualClaimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    String actualToStringResult = actualClaimRequest.toString();

    // Assert
    assertEquals(
        "ClaimRequest(secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualClaimRequest.getSecretKey());
  }
}
