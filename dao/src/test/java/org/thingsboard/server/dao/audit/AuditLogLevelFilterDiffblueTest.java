package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

public class AuditLogLevelFilterDiffblueTest {
  /**
   * Test {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}.
   *
   * <p>Method under test: {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuditLogLevelFilter.logEnabled(EntityType, ActionType)"})
  public void testLogEnabled() {
    // Arrange, Act and Assert
    assertFalse(
        new AuditLogLevelFilter(new AuditLogLevelProperties())
            .logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
