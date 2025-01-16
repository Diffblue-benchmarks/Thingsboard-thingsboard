package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class ContentsDiffGitRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContentsDiffGitRequest#getContent1()}
   *   <li>{@link ContentsDiffGitRequest#getContent2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ContentsDiffGitRequest contentsDiffGitRequest = new ContentsDiffGitRequest(new TenantId(UUID.randomUUID()),
        "Not all who wander are lost", "Not all who wander are lost");

    // Act
    String actualContent1 = contentsDiffGitRequest.getContent1();

    // Assert
    assertEquals("Not all who wander are lost", actualContent1);
    assertEquals("Not all who wander are lost", contentsDiffGitRequest.getContent2());
  }
}
