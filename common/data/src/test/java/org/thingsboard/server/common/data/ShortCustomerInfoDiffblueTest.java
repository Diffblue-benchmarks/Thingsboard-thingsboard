package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ShortCustomerInfoDiffblueTest {
  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and
   * {@link ShortCustomerInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true);
    ShortCustomerInfo shortCustomerInfo2 = new ShortCustomerInfo(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo2);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo2.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and
   * {@link ShortCustomerInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);

    // Act and Assert
    assertNotEquals(shortCustomerInfo,
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true),
        mock(AdminSettingsId.class));
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true),
        null);
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true),
        "Different type to ShortCustomerInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#ShortCustomerInfo(CustomerId, String, boolean)}
   *   <li>{@link ShortCustomerInfo#setCustomerId(CustomerId)}
   *   <li>{@link ShortCustomerInfo#setPublic(boolean)}
   *   <li>{@link ShortCustomerInfo#setTitle(String)}
   *   <li>{@link ShortCustomerInfo#getCustomerId()}
   *   <li>{@link ShortCustomerInfo#getTitle()}
   *   <li>{@link ShortCustomerInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ShortCustomerInfo actualShortCustomerInfo = new ShortCustomerInfo(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualShortCustomerInfo.setCustomerId(customerId);
    actualShortCustomerInfo.setPublic(true);
    actualShortCustomerInfo.setTitle("Dr");
    CustomerId actualCustomerId = actualShortCustomerInfo.getCustomerId();
    String actualTitle = actualShortCustomerInfo.getTitle();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertTrue(actualShortCustomerInfo.isPublic());
    assertSame(customerId, actualCustomerId);
  }
}
