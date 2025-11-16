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
package org.thingsboard.server.dao.device.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClaimDataDiffblueTest {
  /**
   * Test {@link ClaimData#equals(Object)}, and {@link ClaimData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimData#equals(Object)}
   *   <li>{@link ClaimData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimData claimData = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L);
    ClaimData claimData2 = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L);

    // Act and Assert
    assertEquals(claimData, claimData2);
    assertEquals(claimData.hashCode(), claimData2.hashCode());
  }

  /**
   * Test {@link ClaimData#equals(Object)}, and {@link ClaimData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimData#equals(Object)}
   *   <li>{@link ClaimData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimData claimData = new ClaimData(null, 1L);
    ClaimData claimData2 = new ClaimData(null, 1L);

    // Act and Assert
    assertEquals(claimData, claimData2);
    assertEquals(claimData.hashCode(), claimData2.hashCode());
  }

  /**
   * Test {@link ClaimData#equals(Object)}, and {@link ClaimData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimData#equals(Object)}
   *   <li>{@link ClaimData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimData claimData = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L);

    // Act and Assert
    assertEquals(claimData, claimData);
    int expectedHashCodeResult = claimData.hashCode();
    assertEquals(expectedHashCodeResult, claimData.hashCode());
  }

  /**
   * Test {@link ClaimData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClaimData claimData = new ClaimData("Secret Key", 1L);

    // Act and Assert
    assertNotEquals(claimData, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
  }

  /**
   * Test {@link ClaimData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClaimData claimData = new ClaimData(null, 1L);

    // Act and Assert
    assertNotEquals(claimData, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
  }

  /**
   * Test {@link ClaimData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ClaimData claimData = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 3L);

    // Act and Assert
    assertNotEquals(claimData, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
  }

  /**
   * Test {@link ClaimData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L), null);
  }

  /**
   * Test {@link ClaimData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimData.equals(Object)", "int ClaimData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L),
        "Different type to ClaimData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimData#ClaimData(String, long)}
   *   <li>{@link ClaimData#toString()}
   *   <li>{@link ClaimData#getExpirationTime()}
   *   <li>{@link ClaimData#getSecretKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClaimData.<init>(String, long)",
    "long ClaimData.getExpirationTime()",
    "String ClaimData.getSecretKey()",
    "String ClaimData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ClaimData actualClaimData = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L);
    String actualToStringResult = actualClaimData.toString();
    long actualExpirationTime = actualClaimData.getExpirationTime();

    // Assert
    assertEquals(
        "ClaimData(secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY, expirationTime=1)",
        actualToStringResult);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualClaimData.getSecretKey());
    assertEquals(1L, actualExpirationTime);
  }
}
