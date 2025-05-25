package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateRequest;

@ContextConfiguration(classes = {CommitGitRequest.class, TenantId.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CommitGitRequestDiffblueTest {
  @Autowired
  private CommitGitRequest commitGitRequest;

  @MockBean
  private UUID uUID;

  @MockBean
  private VersionCreateRequest versionCreateRequest;

  /**
   * Test {@link CommitGitRequest#CommitGitRequest(TenantId, VersionCreateRequest)}.
   * <ul>
   *   <li>Then return TimeoutTask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommitGitRequest#CommitGitRequest(TenantId, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new CommitGitRequest(TenantId, VersionCreateRequest); then return TimeoutTask is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommitGitRequest.<init>(TenantId, VersionCreateRequest)"})
  void testNewCommitGitRequest_thenReturnTimeoutTaskIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    CommitGitRequest actualCommitGitRequest = new CommitGitRequest(tenantId, versionCreateRequest);

    // Assert
    assertNull(actualCommitGitRequest.getTimeoutTask());
    assertSame(tenantId, actualCommitGitRequest.getTenantId());
  }
}
