package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ActivateUserRequestDiffblueTest {
  /**
   * Test {@link ActivateUserRequest#equals(Object)}, and
   * {@link ActivateUserRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivateUserRequest#equals(Object)}
   *   <li>{@link ActivateUserRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword("iloveyou");

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(activateUserRequest, activateUserRequest2);
    int expectedHashCodeResult = activateUserRequest.hashCode();
    assertEquals(expectedHashCodeResult, activateUserRequest2.hashCode());
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}, and
   * {@link ActivateUserRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivateUserRequest#equals(Object)}
   *   <li>{@link ActivateUserRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken(null);
    activateUserRequest.setPassword("iloveyou");

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken(null);
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(activateUserRequest, activateUserRequest2);
    int expectedHashCodeResult = activateUserRequest.hashCode();
    assertEquals(expectedHashCodeResult, activateUserRequest2.hashCode());
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}, and
   * {@link ActivateUserRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivateUserRequest#equals(Object)}
   *   <li>{@link ActivateUserRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword(null);

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword(null);

    // Act and Assert
    assertEquals(activateUserRequest, activateUserRequest2);
    int expectedHashCodeResult = activateUserRequest.hashCode();
    assertEquals(expectedHashCodeResult, activateUserRequest2.hashCode());
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}, and
   * {@link ActivateUserRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivateUserRequest#equals(Object)}
   *   <li>{@link ActivateUserRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword("iloveyou");

    // Act and Assert
    assertEquals(activateUserRequest, activateUserRequest);
    int expectedHashCodeResult = activateUserRequest.hashCode();
    assertEquals(expectedHashCodeResult, activateUserRequest.hashCode());
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("iloveyou");
    activateUserRequest.setPassword("iloveyou");

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, activateUserRequest2);
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken(null);
    activateUserRequest.setPassword("iloveyou");

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, activateUserRequest2);
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword("ABC123");

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, activateUserRequest2);
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword(null);

    ActivateUserRequest activateUserRequest2 = new ActivateUserRequest();
    activateUserRequest2.setActivateToken("ABC123");
    activateUserRequest2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, activateUserRequest2);
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, null);
  }

  /**
   * Test {@link ActivateUserRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivateUserRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ActivateUserRequest activateUserRequest = new ActivateUserRequest();
    activateUserRequest.setActivateToken("ABC123");
    activateUserRequest.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(activateUserRequest, "Different type to ActivateUserRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ActivateUserRequest}
   *   <li>{@link ActivateUserRequest#setActivateToken(String)}
   *   <li>{@link ActivateUserRequest#setPassword(String)}
   *   <li>{@link ActivateUserRequest#toString()}
   *   <li>{@link ActivateUserRequest#getActivateToken()}
   *   <li>{@link ActivateUserRequest#getPassword()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ActivateUserRequest actualActivateUserRequest = new ActivateUserRequest();
    actualActivateUserRequest.setActivateToken("ABC123");
    actualActivateUserRequest.setPassword("iloveyou");
    String actualToStringResult = actualActivateUserRequest.toString();
    String actualActivateToken = actualActivateUserRequest.getActivateToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ActivateUserRequest(activateToken=ABC123, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualActivateUserRequest.getPassword());
  }
}
