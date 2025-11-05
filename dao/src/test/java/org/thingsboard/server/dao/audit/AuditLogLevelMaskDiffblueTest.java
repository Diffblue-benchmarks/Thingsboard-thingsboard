package org.thingsboard.server.dao.audit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuditLogLevelMaskDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogLevelMask#isRead()}
   *   <li>{@link AuditLogLevelMask#isWrite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLogLevelMask.isRead()", "boolean AuditLogLevelMask.isWrite()"})
  void testGettersAndSetters() {
    // Arrange
    AuditLogLevelMask valueOfResult = AuditLogLevelMask.valueOf("OFF");

    // Act
    boolean actualIsReadResult = valueOfResult.isRead();

    // Assert
    assertFalse(actualIsReadResult);
    assertFalse(valueOfResult.isWrite());
  }
}
