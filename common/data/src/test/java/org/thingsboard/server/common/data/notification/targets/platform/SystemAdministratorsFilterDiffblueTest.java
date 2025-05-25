package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemAdministratorsFilterDiffblueTest {
  /**
   * Test {@link SystemAdministratorsFilter#equals(Object)}, and {@link SystemAdministratorsFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemAdministratorsFilter#equals(Object)}
   *   <li>{@link SystemAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemAdministratorsFilter.equals(Object)", "int SystemAdministratorsFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemAdministratorsFilter systemAdministratorsFilter = new SystemAdministratorsFilter();
    SystemAdministratorsFilter systemAdministratorsFilter2 = new SystemAdministratorsFilter();

    // Act and Assert
    assertEquals(systemAdministratorsFilter, systemAdministratorsFilter2);
    int expectedHashCodeResult = systemAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, systemAdministratorsFilter2.hashCode());
  }

  /**
   * Test {@link SystemAdministratorsFilter#equals(Object)}, and {@link SystemAdministratorsFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemAdministratorsFilter#equals(Object)}
   *   <li>{@link SystemAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemAdministratorsFilter.equals(Object)", "int SystemAdministratorsFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemAdministratorsFilter systemAdministratorsFilter = new SystemAdministratorsFilter();

    // Act and Assert
    assertEquals(systemAdministratorsFilter, systemAdministratorsFilter);
    int expectedHashCodeResult = systemAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, systemAdministratorsFilter.hashCode());
  }

  /**
   * Test {@link SystemAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemAdministratorsFilter.equals(Object)", "int SystemAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), 1);
  }

  /**
   * Test {@link SystemAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemAdministratorsFilter.equals(Object)", "int SystemAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), null);
  }

  /**
   * Test {@link SystemAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemAdministratorsFilter.equals(Object)", "int SystemAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), "Different type to SystemAdministratorsFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemAdministratorsFilter}
   *   <li>{@link SystemAdministratorsFilter#toString()}
   *   <li>{@link SystemAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SystemAdministratorsFilter.<init>()", "UsersFilterType SystemAdministratorsFilter.getType()",
      "String SystemAdministratorsFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SystemAdministratorsFilter actualSystemAdministratorsFilter = new SystemAdministratorsFilter();
    String actualToStringResult = actualSystemAdministratorsFilter.toString();

    // Assert
    assertEquals("SystemAdministratorsFilter()", actualToStringResult);
    assertEquals(UsersFilterType.SYSTEM_ADMINISTRATORS, actualSystemAdministratorsFilter.getType());
  }
}
