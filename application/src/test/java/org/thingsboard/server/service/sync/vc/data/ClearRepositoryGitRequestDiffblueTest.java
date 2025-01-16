package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class ClearRepositoryGitRequestDiffblueTest {
  /**
   * Test {@link ClearRepositoryGitRequest#requiresSettings()}.
   * <p>
   * Method under test: {@link ClearRepositoryGitRequest#requiresSettings()}
   */
  @Test
  @DisplayName("Test requiresSettings()")
  void testRequiresSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ClearRepositoryGitRequest(new TenantId(UUID.randomUUID()))).requiresSettings());
  }
}
