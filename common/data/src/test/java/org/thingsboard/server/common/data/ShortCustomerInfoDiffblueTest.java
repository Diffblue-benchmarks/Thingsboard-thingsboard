package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ShortCustomerInfoDiffblueTest {
  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and {@link ShortCustomerInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShortCustomerInfo.equals(Object)",
    "int ShortCustomerInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    CustomerId customerId2 =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo2 = new ShortCustomerInfo(customerId2, "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo2);
    assertEquals(shortCustomerInfo.hashCode(), shortCustomerInfo2.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and {@link ShortCustomerInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShortCustomerInfo.equals(Object)",
    "int ShortCustomerInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShortCustomerInfo.equals(Object)",
    "int ShortCustomerInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(shortCustomerInfo, new ShortCustomerInfo(customerId, "Dr", true));
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShortCustomerInfo.equals(Object)",
    "int ShortCustomerInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(new ShortCustomerInfo(customerId, "Dr", true), null);
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShortCustomerInfo.equals(Object)",
    "int ShortCustomerInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new ShortCustomerInfo(customerId, "Dr", true), "Different type to ShortCustomerInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShortCustomerInfo.<init>(CustomerId, String, boolean)",
    "CustomerId ShortCustomerInfo.getCustomerId()",
    "String ShortCustomerInfo.getTitle()",
    "boolean ShortCustomerInfo.isPublic()",
    "void ShortCustomerInfo.setCustomerId(CustomerId)",
    "void ShortCustomerInfo.setPublic(boolean)",
    "void ShortCustomerInfo.setTitle(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ShortCustomerInfo actualShortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    CustomerId customerId2 =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualShortCustomerInfo.setCustomerId(customerId2);
    actualShortCustomerInfo.setPublic(true);
    actualShortCustomerInfo.setTitle("Dr");
    CustomerId actualCustomerId = actualShortCustomerInfo.getCustomerId();
    String actualTitle = actualShortCustomerInfo.getTitle();

    // Assert
    assertEquals("Dr", actualTitle);
    assertTrue(actualShortCustomerInfo.isPublic());
    assertSame(customerId2, actualCustomerId);
  }
}
