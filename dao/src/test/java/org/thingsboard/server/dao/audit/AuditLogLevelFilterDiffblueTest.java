package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

public class AuditLogLevelFilterDiffblueTest {
  /**
   * Test {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}.
   * <p>
   * Method under test:
   * {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}
   */
  @Test
  public void testLogEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new AuditLogLevelFilter(new AuditLogLevelProperties())).logEnabled(EntityType.TENANT, ActionType.ADDED));
  }

  /**
   * Test {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}
   */
  @Test
  public void testLogEnabled_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> mask = new HashMap<>();
    mask.computeIfPresent("foo", mock(BiFunction.class));

    AuditLogLevelProperties auditLogLevelProperties = new AuditLogLevelProperties();
    auditLogLevelProperties.setMask(mask);

    // Act and Assert
    assertFalse((new AuditLogLevelFilter(auditLogLevelProperties)).logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
