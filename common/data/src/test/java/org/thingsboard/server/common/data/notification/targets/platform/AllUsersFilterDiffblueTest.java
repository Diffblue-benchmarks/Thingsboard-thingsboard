package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllUsersFilterDiffblueTest {
  /**
   * Test {@link AllUsersFilter#equals(Object)}, and {@link AllUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();
    AllUsersFilter allUsersFilter2 = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter2);
    int expectedHashCodeResult = allUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, allUsersFilter2.hashCode());
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}, and {@link AllUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter);
    int expectedHashCodeResult = allUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, allUsersFilter.hashCode());
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), 1);
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), null);
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), "Different type to AllUsersFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AllUsersFilter}
   *   <li>{@link AllUsersFilter#toString()}
   *   <li>{@link AllUsersFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AllUsersFilter.<init>()", "UsersFilterType AllUsersFilter.getType()",
      "String AllUsersFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AllUsersFilter actualAllUsersFilter = new AllUsersFilter();
    String actualToStringResult = actualAllUsersFilter.toString();

    // Assert
    assertEquals("AllUsersFilter()", actualToStringResult);
    assertEquals(UsersFilterType.ALL_USERS, actualAllUsersFilter.getType());
  }
}
