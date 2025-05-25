package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuditLogIdDiffblueTest {
  /**
   * Test {@link AuditLogId#AuditLogId(UUID)}.
   * <p>
   * Method under test: {@link AuditLogId#AuditLogId(UUID)}
   */
  @Test
  @DisplayName("Test new AuditLogId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogId.<init>(UUID)"})
  void testNewAuditLogId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    UUID id2 = (new AuditLogId(id)).getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
  }
}
