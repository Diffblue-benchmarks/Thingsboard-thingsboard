package org.thingsboard.server.install;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

class ThingsboardInstallConfigurationDiffblueTest {
  /**
   * Test {@link ThingsboardInstallConfiguration#emptyAuditLogLevelFilter()}.
   * <p>
   * Method under test:
   * {@link ThingsboardInstallConfiguration#emptyAuditLogLevelFilter()}
   */
  @Test
  @DisplayName("Test emptyAuditLogLevelFilter()")
  void testEmptyAuditLogLevelFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ThingsboardInstallConfiguration()).emptyAuditLogLevelFilter()
        .logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
