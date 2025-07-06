package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AffectedTenantAdministratorsFilterDiffblueTest {
  /**
   * Test {@link AffectedTenantAdministratorsFilter#equals(Object)}, and {@link
   * AffectedTenantAdministratorsFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AffectedTenantAdministratorsFilter#equals(Object)}
   *   <li>{@link AffectedTenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AffectedTenantAdministratorsFilter.equals(Object)",
    "int AffectedTenantAdministratorsFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter =
        new AffectedTenantAdministratorsFilter();
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter2 =
        new AffectedTenantAdministratorsFilter();

    // Act and Assert
    assertEquals(affectedTenantAdministratorsFilter, affectedTenantAdministratorsFilter2);
    int expectedHashCodeResult = affectedTenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedTenantAdministratorsFilter2.hashCode());
  }

  /**
   * Test {@link AffectedTenantAdministratorsFilter#equals(Object)}, and {@link
   * AffectedTenantAdministratorsFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AffectedTenantAdministratorsFilter#equals(Object)}
   *   <li>{@link AffectedTenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AffectedTenantAdministratorsFilter.equals(Object)",
    "int AffectedTenantAdministratorsFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter =
        new AffectedTenantAdministratorsFilter();

    // Act and Assert
    assertEquals(affectedTenantAdministratorsFilter, affectedTenantAdministratorsFilter);
    int expectedHashCodeResult = affectedTenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedTenantAdministratorsFilter.hashCode());
  }

  /**
   * Test {@link AffectedTenantAdministratorsFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AffectedTenantAdministratorsFilter.equals(Object)",
    "int AffectedTenantAdministratorsFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedTenantAdministratorsFilter(), 1);
  }

  /**
   * Test {@link AffectedTenantAdministratorsFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AffectedTenantAdministratorsFilter.equals(Object)",
    "int AffectedTenantAdministratorsFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedTenantAdministratorsFilter(), null);
  }

  /**
   * Test {@link AffectedTenantAdministratorsFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AffectedTenantAdministratorsFilter.equals(Object)",
    "int AffectedTenantAdministratorsFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AffectedTenantAdministratorsFilter(),
        "Different type to AffectedTenantAdministratorsFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AffectedTenantAdministratorsFilter}
   *   <li>{@link AffectedTenantAdministratorsFilter#toString()}
   *   <li>{@link AffectedTenantAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AffectedTenantAdministratorsFilter.<init>()",
    "UsersFilterType AffectedTenantAdministratorsFilter.getType()",
    "String AffectedTenantAdministratorsFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AffectedTenantAdministratorsFilter actualAffectedTenantAdministratorsFilter =
        new AffectedTenantAdministratorsFilter();
    String actualToStringResult = actualAffectedTenantAdministratorsFilter.toString();

    // Assert
    assertEquals("AffectedTenantAdministratorsFilter()", actualToStringResult);
    assertEquals(
        UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS,
        actualAffectedTenantAdministratorsFilter.getType());
  }
}
