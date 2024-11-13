package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClaimRequestDiffblueTest {
  /**
   * Test {@link ClaimRequest#equals(Object)}, and
   * {@link ClaimRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link ClaimRequest#equals(Object)}, and
   * {@link ClaimRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link ClaimRequest#equals(Object)}, and
   * {@link ClaimRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#equals(Object)}
   *   <li>{@link ClaimRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest("Secret Key");

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClaimRequest claimRequest = new ClaimRequest(null);

    // Act and Assert
    assertNotEquals(claimRequest, new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), null);
  }

  /**
   * Test {@link ClaimRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), "Different type to ClaimRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimRequest#ClaimRequest(String)}
   *   <li>{@link ClaimRequest#toString()}
   *   <li>{@link ClaimRequest#getSecretKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ClaimRequest actualClaimRequest = new ClaimRequest("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    String actualToStringResult = actualClaimRequest.toString();

    // Assert
    assertEquals("ClaimRequest(secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualClaimRequest.getSecretKey());
  }
}
