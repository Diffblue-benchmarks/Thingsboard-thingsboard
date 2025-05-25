package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TenantAdministratorsFilterDiffblueTest {
  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}, and {@link TenantAdministratorsFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantAdministratorsFilter#equals(Object)}
   *   <li>{@link TenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
    int expectedHashCodeResult = tenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, tenantAdministratorsFilter2.hashCode());
  }

  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}, and {@link TenantAdministratorsFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantAdministratorsFilter#equals(Object)}
   *   <li>{@link TenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertEquals(tenantAdministratorsFilter, tenantAdministratorsFilter);
    int expectedHashCodeResult = tenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, tenantAdministratorsFilter.hashCode());
  }

  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(tenantProfilesIds);
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
  }

  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(tenantsIds);

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
  }

  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, null);
  }

  /**
   * Test {@link TenantAdministratorsFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantAdministratorsFilter.equals(Object)", "int TenantAdministratorsFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, "Different type to TenantAdministratorsFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TenantAdministratorsFilter}
   *   <li>{@link TenantAdministratorsFilter#setTenantProfilesIds(Set)}
   *   <li>{@link TenantAdministratorsFilter#setTenantsIds(Set)}
   *   <li>{@link TenantAdministratorsFilter#toString()}
   *   <li>{@link TenantAdministratorsFilter#getTenantProfilesIds()}
   *   <li>{@link TenantAdministratorsFilter#getTenantsIds()}
   *   <li>{@link TenantAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantAdministratorsFilter.<init>()",
      "Set TenantAdministratorsFilter.getTenantProfilesIds()", "Set TenantAdministratorsFilter.getTenantsIds()",
      "UsersFilterType TenantAdministratorsFilter.getType()",
      "void TenantAdministratorsFilter.setTenantProfilesIds(Set)", "void TenantAdministratorsFilter.setTenantsIds(Set)",
      "String TenantAdministratorsFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TenantAdministratorsFilter actualTenantAdministratorsFilter = new TenantAdministratorsFilter();
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    actualTenantAdministratorsFilter.setTenantProfilesIds(tenantProfilesIds);
    HashSet<UUID> tenantsIds = new HashSet<>();
    actualTenantAdministratorsFilter.setTenantsIds(tenantsIds);
    String actualToStringResult = actualTenantAdministratorsFilter.toString();
    Set<UUID> actualTenantProfilesIds = actualTenantAdministratorsFilter.getTenantProfilesIds();
    Set<UUID> actualTenantsIds = actualTenantAdministratorsFilter.getTenantsIds();

    // Assert
    assertEquals("TenantAdministratorsFilter(tenantsIds=[], tenantProfilesIds=[])", actualToStringResult);
    assertEquals(UsersFilterType.TENANT_ADMINISTRATORS, actualTenantAdministratorsFilter.getType());
    assertTrue(actualTenantProfilesIds.isEmpty());
    assertTrue(actualTenantsIds.isEmpty());
    assertSame(tenantProfilesIds, actualTenantProfilesIds);
    assertSame(tenantsIds, actualTenantsIds);
  }
}
