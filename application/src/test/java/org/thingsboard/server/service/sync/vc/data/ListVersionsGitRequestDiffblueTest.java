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

@ContextConfiguration(classes = {ListVersionsGitRequest.class, TenantId.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ListVersionsGitRequestDiffblueTest {
  @Autowired
  private ListVersionsGitRequest listVersionsGitRequest;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link ListVersionsGitRequest#ListVersionsGitRequest(TenantId)}.
   * <ul>
   *   <li>Then return TimeoutTask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListVersionsGitRequest#ListVersionsGitRequest(TenantId)}
   */
  @Test
  @DisplayName("Test new ListVersionsGitRequest(TenantId); then return TimeoutTask is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ListVersionsGitRequest.<init>(TenantId)"})
  void testNewListVersionsGitRequest_thenReturnTimeoutTaskIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListVersionsGitRequest actualListVersionsGitRequest = new ListVersionsGitRequest(tenantId);

    // Assert
    assertNull(actualListVersionsGitRequest.getTimeoutTask());
    assertSame(tenantId, actualListVersionsGitRequest.getTenantId());
  }
}
