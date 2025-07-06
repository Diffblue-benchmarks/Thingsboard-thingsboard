package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserCredentialsIdDiffblueTest {
  /**
   * Test {@link UserCredentialsId#UserCredentialsId(UUID)}.
   *
   * <p>Method under test: {@link UserCredentialsId#UserCredentialsId(UUID)}
   */
  @Test
  @DisplayName("Test new UserCredentialsId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserCredentialsId.<init>(UUID)"})
  void testNewUserCredentialsId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    UUID id2 = new UserCredentialsId(id).getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
  }
}
