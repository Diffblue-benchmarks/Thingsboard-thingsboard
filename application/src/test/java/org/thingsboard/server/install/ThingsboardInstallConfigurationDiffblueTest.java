package org.thingsboard.server.install;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

class ThingsboardInstallConfigurationDiffblueTest {
  /**
   * Test {@link ThingsboardInstallConfiguration#emptyAuditLogLevelFilter()}.
   * <p>
   * Method under test: {@link ThingsboardInstallConfiguration#emptyAuditLogLevelFilter()}
   */
  @Test
  @DisplayName("Test emptyAuditLogLevelFilter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.dao.audit.AuditLogLevelFilter ThingsboardInstallConfiguration.emptyAuditLogLevelFilter()"})
  void testEmptyAuditLogLevelFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertFalse((new ThingsboardInstallConfiguration()).emptyAuditLogLevelFilter()
        .logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
