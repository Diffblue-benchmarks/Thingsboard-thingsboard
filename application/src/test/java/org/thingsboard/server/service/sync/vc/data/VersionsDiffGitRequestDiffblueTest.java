package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class VersionsDiffGitRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionsDiffGitRequest#getPath()}
   *   <li>{@link VersionsDiffGitRequest#getVersionId1()}
   *   <li>{@link VersionsDiffGitRequest#getVersionId2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    VersionsDiffGitRequest versionsDiffGitRequest = new VersionsDiffGitRequest(new TenantId(UUID.randomUUID()), "Path",
        "1.0.2", "1.0.2");

    // Act
    String actualPath = versionsDiffGitRequest.getPath();
    String actualVersionId1 = versionsDiffGitRequest.getVersionId1();

    // Assert
    assertEquals("1.0.2", actualVersionId1);
    assertEquals("1.0.2", versionsDiffGitRequest.getVersionId2());
    assertEquals("Path", actualPath);
  }
}
