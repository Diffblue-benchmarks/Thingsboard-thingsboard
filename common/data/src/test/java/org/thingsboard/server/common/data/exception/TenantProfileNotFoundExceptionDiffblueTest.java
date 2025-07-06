package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantProfileNotFoundExceptionDiffblueTest {
  /**
   * Test {@link TenantProfileNotFoundException#TenantProfileNotFoundException(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileNotFoundException#TenantProfileNotFoundException(TenantId)}
   */
  @Test
  @DisplayName("Test new TenantProfileNotFoundException(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfileNotFoundException.<init>(TenantId)"})
  void testNewTenantProfileNotFoundException() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    TenantProfileNotFoundException actualTenantProfileNotFoundException =
        new TenantProfileNotFoundException(tenantId);

    // Assert
    assertEquals(
        "Profile for tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantProfileNotFoundException.getLocalizedMessage());
    assertEquals(
        "Profile for tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantProfileNotFoundException.getMessage());
    assertNull(actualTenantProfileNotFoundException.getCause());
    assertEquals(0, actualTenantProfileNotFoundException.getSuppressed().length);
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualTenantProfileNotFoundException.getTenantId());
  }

  /**
   * Test {@link TenantProfileNotFoundException#getTenantId()}.
   *
   * <p>Method under test: {@link TenantProfileNotFoundException#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TenantProfileNotFoundException.getTenantId()"})
  void testGetTenantId() {
    // Arrange and Act
    TenantId actualTenantId =
        new TenantProfileNotFoundException(TenantId.SYS_TENANT_ID).getTenantId();

    // Assert
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
