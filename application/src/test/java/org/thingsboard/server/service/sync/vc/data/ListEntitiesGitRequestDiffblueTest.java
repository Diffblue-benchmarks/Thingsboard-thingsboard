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

@ContextConfiguration(classes = {ListEntitiesGitRequest.class, TenantId.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ListEntitiesGitRequestDiffblueTest {
  @Autowired
  private ListEntitiesGitRequest listEntitiesGitRequest;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link ListEntitiesGitRequest#ListEntitiesGitRequest(TenantId)}.
   * <ul>
   *   <li>Then return TimeoutTask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListEntitiesGitRequest#ListEntitiesGitRequest(TenantId)}
   */
  @Test
  @DisplayName("Test new ListEntitiesGitRequest(TenantId); then return TimeoutTask is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ListEntitiesGitRequest.<init>(TenantId)"})
  void testNewListEntitiesGitRequest_thenReturnTimeoutTaskIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListEntitiesGitRequest actualListEntitiesGitRequest = new ListEntitiesGitRequest(tenantId);

    // Assert
    assertNull(actualListEntitiesGitRequest.getTimeoutTask());
    assertSame(tenantId, actualListEntitiesGitRequest.getTenantId());
  }
}
