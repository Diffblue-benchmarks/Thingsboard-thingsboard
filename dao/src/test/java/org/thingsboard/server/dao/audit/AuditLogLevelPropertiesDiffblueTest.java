package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AuditLogLevelProperties.getMask()", "void AuditLogLevelProperties.setMask(Map)"})
  public void testGettersAndSetters() {
    // Arrange
    AuditLogLevelProperties auditLogLevelProperties = new AuditLogLevelProperties();
    HashMap<String, String> mask = new HashMap<>();

    // Act
    auditLogLevelProperties.setMask(mask);
    Map<String, String> actualMask = auditLogLevelProperties.getMask();

    // Assert
    assertTrue(actualMask.isEmpty());
    assertSame(mask, actualMask);
  }
}
