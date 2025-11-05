package org.thingsboard.server.dao.audit;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuditLogLevelPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogLevelProperties#setMask(Map)}
   *   <li>{@link AuditLogLevelProperties#getMask()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AuditLogLevelProperties.getMask()",
    "void AuditLogLevelProperties.setMask(Map)"
  })
  void testGettersAndSetters() {
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
