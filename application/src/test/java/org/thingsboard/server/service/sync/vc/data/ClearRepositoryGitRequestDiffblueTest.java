package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {ClearRepositoryGitRequest.class, TenantId.class})
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ClearRepositoryGitRequestDiffblueTest {
  @Autowired
  private ClearRepositoryGitRequest clearRepositoryGitRequest;

  @InjectMocks
  private TenantId tenantId;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link ClearRepositoryGitRequest#ClearRepositoryGitRequest(TenantId)}.
   * <ul>
   *   <li>Then return TimeoutTask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearRepositoryGitRequest#ClearRepositoryGitRequest(TenantId)}
   */
  @Test
  @DisplayName("Test new ClearRepositoryGitRequest(TenantId); then return TimeoutTask is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ClearRepositoryGitRequest.<init>(TenantId)"})
  void testNewClearRepositoryGitRequest_thenReturnTimeoutTaskIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ClearRepositoryGitRequest actualClearRepositoryGitRequest = new ClearRepositoryGitRequest(tenantId);

    // Assert
    assertNull(actualClearRepositoryGitRequest.getTimeoutTask());
    assertSame(tenantId, actualClearRepositoryGitRequest.getTenantId());
  }

  /**
   * Test {@link ClearRepositoryGitRequest#requiresSettings()}.
   * <p>
   * Method under test: {@link ClearRepositoryGitRequest#requiresSettings()}
   */
  @Test
  @DisplayName("Test requiresSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClearRepositoryGitRequest.requiresSettings()"})
  void testRequiresSettings() {
    // Arrange, Act and Assert
    assertFalse(clearRepositoryGitRequest.requiresSettings());
  }
}
