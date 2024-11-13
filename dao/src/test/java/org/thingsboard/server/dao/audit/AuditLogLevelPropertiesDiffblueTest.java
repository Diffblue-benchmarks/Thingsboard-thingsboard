package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class AuditLogLevelPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLogLevelProperties#setMask(Map)}
   *   <li>{@link AuditLogLevelProperties#getMask()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AuditLogLevelProperties auditLogLevelProperties = new AuditLogLevelProperties();
    HashMap<String, String> mask = new HashMap<>();

    // Act
    auditLogLevelProperties.setMask(mask);
    Map<String, String> actualMask = auditLogLevelProperties.getMask();

    // Assert that nothing has changed
    assertTrue(actualMask.isEmpty());
    assertSame(mask, actualMask);
  }
}
