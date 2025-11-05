package org.thingsboard.server.dao.audit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

class AuditLogLevelFilterDiffblueTest {
  /**
   * Test {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}.
   *
   * <p>Method under test: {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}
   */
  @Test
  @DisplayName("Test logEnabled(EntityType, ActionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLogLevelFilter.logEnabled(EntityType, ActionType)"})
  void testLogEnabled() {
    // Arrange, Act and Assert
    assertFalse(
        new AuditLogLevelFilter(new AuditLogLevelProperties())
            .logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
