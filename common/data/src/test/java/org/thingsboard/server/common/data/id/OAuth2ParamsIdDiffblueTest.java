package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OAuth2ParamsIdDiffblueTest {
  /**
   * Test {@link OAuth2ParamsId#OAuth2ParamsId(UUID)}.
   *
   * <p>Method under test: {@link OAuth2ParamsId#OAuth2ParamsId(UUID)}
   */
  @Test
  @DisplayName("Test new OAuth2ParamsId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ParamsId.<init>(UUID)"})
  void testNewOAuth2ParamsId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    UUID id2 = new OAuth2ParamsId(id).getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
  }
}
