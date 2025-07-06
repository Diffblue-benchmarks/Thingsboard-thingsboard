package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AuditLogLevelMaskDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuditLogLevelMask.isRead()", "boolean AuditLogLevelMask.isWrite()"})
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
