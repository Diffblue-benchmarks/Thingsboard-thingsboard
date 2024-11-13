package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserCredentialsIdDiffblueTest {
  /**
   * Test {@link UserCredentialsId#UserCredentialsId(UUID)}.
   * <p>
   * Method under test: {@link UserCredentialsId#UserCredentialsId(UUID)}
   */
  @Test
  @DisplayName("Test new UserCredentialsId(UUID)")
  void testNewUserCredentialsId() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act and Assert
    UUID id2 = (new UserCredentialsId(id)).getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertSame(id, id2);
  }
}
