package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantNotFoundExceptionDiffblueTest {
  /**
   * Test {@link TenantNotFoundException#TenantNotFoundException(TenantId)}.
   * <p>
   * Method under test:
   * {@link TenantNotFoundException#TenantNotFoundException(TenantId)}
   */
  @Test
  @DisplayName("Test new TenantNotFoundException(TenantId)")
  void testNewTenantNotFoundException() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    TenantNotFoundException actualTenantNotFoundException = new TenantNotFoundException(tenantId);

    // Assert
    assertEquals("Tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantNotFoundException.getLocalizedMessage());
    assertEquals("Tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantNotFoundException.getMessage());
    assertNull(actualTenantNotFoundException.getCause());
    assertEquals(0, actualTenantNotFoundException.getSuppressed().length);
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualTenantNotFoundException.getTenantId());
  }

  /**
   * Test {@link TenantNotFoundException#getTenantId()}.
   * <p>
   * Method under test: {@link TenantNotFoundException#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() {
    // Arrange and Act
    TenantId actualTenantId = (new TenantNotFoundException(TenantId.SYS_TENANT_ID)).getTenantId();

    // Assert
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
