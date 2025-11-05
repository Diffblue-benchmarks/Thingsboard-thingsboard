package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OriginatorEntityOwnerUsersFilterDiffblueTest {
  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}, and {@link
   * OriginatorEntityOwnerUsersFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
    "int OriginatorEntityOwnerUsersFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter =
        new OriginatorEntityOwnerUsersFilter();
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter2 =
        new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter2);
    assertEquals(
        originatorEntityOwnerUsersFilter.hashCode(), originatorEntityOwnerUsersFilter2.hashCode());
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}, and {@link
   * OriginatorEntityOwnerUsersFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
    "int OriginatorEntityOwnerUsersFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter =
        new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter);
    int expectedHashCodeResult = originatorEntityOwnerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, originatorEntityOwnerUsersFilter.hashCode());
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
    "int OriginatorEntityOwnerUsersFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), null);
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
    "int OriginatorEntityOwnerUsersFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OriginatorEntityOwnerUsersFilter(),
        "Different type to OriginatorEntityOwnerUsersFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OriginatorEntityOwnerUsersFilter}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#toString()}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OriginatorEntityOwnerUsersFilter.<init>()",
    "UsersFilterType OriginatorEntityOwnerUsersFilter.getType()",
    "String OriginatorEntityOwnerUsersFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OriginatorEntityOwnerUsersFilter actualOriginatorEntityOwnerUsersFilter =
        new OriginatorEntityOwnerUsersFilter();
    String actualToStringResult = actualOriginatorEntityOwnerUsersFilter.toString();

    // Assert
    assertEquals("OriginatorEntityOwnerUsersFilter()", actualToStringResult);
    assertEquals(
        UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS,
        actualOriginatorEntityOwnerUsersFilter.getType());
  }
}
