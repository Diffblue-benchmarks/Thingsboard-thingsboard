package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class AuditLogLevelMaskDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLogLevelMask#isRead()}
   *   <li>{@link AuditLogLevelMask#isWrite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AuditLogLevelMask valueOfResult = AuditLogLevelMask.valueOf("OFF");

    // Act
    boolean actualIsReadResult = valueOfResult.isRead();

    // Assert
    assertFalse(actualIsReadResult);
    assertFalse(valueOfResult.isWrite());
  }
}
