package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.controller.TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest;

class TwoFactorAuthConfigControllerDiffblueTest {
  /**
   * Test TwoFaAccountConfigUpdateRequest
   * {@link TwoFaAccountConfigUpdateRequest#equals(Object)}, and
   * {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest);
    int expectedHashCodeResult = twoFaAccountConfigUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, twoFaAccountConfigUpdateRequest.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest
   * {@link TwoFaAccountConfigUpdateRequest#equals(Object)}, and
   * {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
    int expectedHashCodeResult = twoFaAccountConfigUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, twoFaAccountConfigUpdateRequest2.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest
   * {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual() {
    // Arrange
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, "Different type to TwoFaAccountConfigUpdateRequest");
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest
   * {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual2() {
    // Arrange
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(false);

    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest
   * {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); when other is 'null'; then return not equal")
  void testTwoFaAccountConfigUpdateRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, null);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest}
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#setUseByDefault(boolean)}
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#toString()}
   *   <li>
   * {@link TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest#isUseByDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest getters and setters")
  void testTwoFaAccountConfigUpdateRequestGettersAndSetters() {
    // Arrange and Act
    TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest actualTwoFaAccountConfigUpdateRequest = new TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest();
    actualTwoFaAccountConfigUpdateRequest.setUseByDefault(true);
    String actualToStringResult = actualTwoFaAccountConfigUpdateRequest.toString();

    // Assert that nothing has changed
    assertEquals("TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest(useByDefault=true)",
        actualToStringResult);
    assertTrue(actualTwoFaAccountConfigUpdateRequest.isUseByDefault());
  }
}
