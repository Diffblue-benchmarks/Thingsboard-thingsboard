package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class StatsPersistMsgDiffblueTest {
  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   * <p>
   * Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(
        (new StatsPersistMsg(1L, -1L, new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null))
            .isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   * <p>
   * Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty2() {
    // Arrange, Act and Assert
    assertFalse(
        (new StatsPersistMsg(0L, -1L, new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null))
            .isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new StatsPersistMsg(0L, 0L, new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null))
            .isEmpty());
  }
}
