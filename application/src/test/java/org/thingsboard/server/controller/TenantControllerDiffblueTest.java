package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class TenantControllerDiffblueTest {
  /**
   * Test {@link TenantController#deleteTenant(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TenantController#deleteTenant(String)}
   */
  @Test
  @DisplayName("Test deleteTenant(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantController.deleteTenant(String)"})
  void testDeleteTenant_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TenantController tenantController = new TenantController(new TenantServiceImpl(), null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> tenantController.deleteTenant("42"));
  }

  /**
   * Test {@link TenantController#deleteTenant(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantController#deleteTenant(String)}
   */
  @Test
  @DisplayName("Test deleteTenant(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantController.deleteTenant(String)"})
  void testDeleteTenant_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TenantController tenantController = new TenantController(new TenantServiceImpl(), null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> tenantController.deleteTenant(""));
  }
}
