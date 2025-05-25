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

@ContextConfiguration(classes = {ContentsDiffGitRequest.class, TenantId.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ContentsDiffGitRequestDiffblueTest {
  @Autowired
  private ContentsDiffGitRequest contentsDiffGitRequest;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link ContentsDiffGitRequest#ContentsDiffGitRequest(TenantId, String, String)}.
   * <ul>
   *   <li>Then return Content1 is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentsDiffGitRequest#ContentsDiffGitRequest(TenantId, String, String)}
   */
  @Test
  @DisplayName("Test new ContentsDiffGitRequest(TenantId, String, String); then return Content1 is 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContentsDiffGitRequest.<init>(TenantId, String, String)"})
  void testNewContentsDiffGitRequest_thenReturnContent1IsNotAllWhoWanderAreLost() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ContentsDiffGitRequest actualContentsDiffGitRequest = new ContentsDiffGitRequest(tenantId,
        "Not all who wander are lost", "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualContentsDiffGitRequest.getContent1());
    assertEquals("Not all who wander are lost", actualContentsDiffGitRequest.getContent2());
    assertNull(actualContentsDiffGitRequest.getTimeoutTask());
    assertSame(tenantId, actualContentsDiffGitRequest.getTenantId());
  }

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ContentsDiffGitRequest.getContent1()", "String ContentsDiffGitRequest.getContent2()"})
  void testGettersAndSetters() {
    // Arrange
    ContentsDiffGitRequest contentsDiffGitRequest = new ContentsDiffGitRequest(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Not all who wander are lost",
        "Not all who wander are lost");

    // Act
    String actualContent1 = contentsDiffGitRequest.getContent1();

    // Assert
    assertEquals("Not all who wander are lost", actualContent1);
    assertEquals("Not all who wander are lost", contentsDiffGitRequest.getContent2());
  }
}
