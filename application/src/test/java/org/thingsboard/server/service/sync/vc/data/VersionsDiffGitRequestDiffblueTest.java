package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@ContextConfiguration(classes = {VersionsDiffGitRequest.class, TenantId.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class VersionsDiffGitRequestDiffblueTest {
  @MockBean
  private UUID uUID;

  @Autowired
  private VersionsDiffGitRequest versionsDiffGitRequest;

  /**
   * Test {@link VersionsDiffGitRequest#VersionsDiffGitRequest(TenantId, String, String, String)}.
   * <ul>
   *   <li>Then return VersionId1 is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionsDiffGitRequest#VersionsDiffGitRequest(TenantId, String, String, String)}
   */
  @Test
  @DisplayName("Test new VersionsDiffGitRequest(TenantId, String, String, String); then return VersionId1 is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionsDiffGitRequest.<init>(TenantId, String, String, String)"})
  void testNewVersionsDiffGitRequest_thenReturnVersionId1Is102() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    VersionsDiffGitRequest actualVersionsDiffGitRequest = new VersionsDiffGitRequest(tenantId, "Path", "1.0.2",
        "1.0.2");

    // Assert
    assertEquals("1.0.2", actualVersionsDiffGitRequest.getVersionId1());
    assertEquals("1.0.2", actualVersionsDiffGitRequest.getVersionId2());
    assertEquals("Path", actualVersionsDiffGitRequest.getPath());
    assertNull(actualVersionsDiffGitRequest.getTimeoutTask());
    assertSame(tenantId, actualVersionsDiffGitRequest.getTenantId());
  }

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionsDiffGitRequest.getPath()", "String VersionsDiffGitRequest.getVersionId1()",
      "String VersionsDiffGitRequest.getVersionId2()"})
  void testGettersAndSetters() {
    // Arrange
    VersionsDiffGitRequest versionsDiffGitRequest = new VersionsDiffGitRequest(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Path", "1.0.2", "1.0.2");

    // Act
    String actualPath = versionsDiffGitRequest.getPath();
    String actualVersionId1 = versionsDiffGitRequest.getVersionId1();

    // Assert
    assertEquals("1.0.2", actualVersionId1);
    assertEquals("1.0.2", versionsDiffGitRequest.getVersionId2());
    assertEquals("Path", actualPath);
  }
}
