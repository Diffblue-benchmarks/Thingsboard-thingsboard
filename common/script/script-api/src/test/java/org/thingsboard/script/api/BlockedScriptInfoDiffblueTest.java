package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockedScriptInfoDiffblueTest {
  /**
   * Test {@link BlockedScriptInfo#BlockedScriptInfo(int)}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#BlockedScriptInfo(int)}
   */
  @Test
  @DisplayName("Test new BlockedScriptInfo(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BlockedScriptInfo.<init>(int)"})
  void testNewBlockedScriptInfo() {
    // Arrange and Act
    BlockedScriptInfo actualBlockedScriptInfo = new BlockedScriptInfo(3);

    // Assert
    assertEquals(0, actualBlockedScriptInfo.get());
    assertEquals(0L, actualBlockedScriptInfo.getExpirationTime());
  }

  /**
   * Test {@link BlockedScriptInfo#get()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#get()}
   */
  @Test
  @DisplayName("Test get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BlockedScriptInfo.get()"})
  void testGet() {
    // Arrange, Act and Assert
    assertEquals(0, new BlockedScriptInfo(3).get());
  }

  /**
   * Test {@link BlockedScriptInfo#incrementAndGet()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#incrementAndGet()}
   */
  @Test
  @DisplayName("Test incrementAndGet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BlockedScriptInfo.incrementAndGet()"})
  void testIncrementAndGet() {
    // Arrange
    BlockedScriptInfo blockedScriptInfo = new BlockedScriptInfo(3);

    // Act
    int actualIncrementAndGetResult = blockedScriptInfo.incrementAndGet();

    // Assert
    assertEquals(1, blockedScriptInfo.get());
    assertEquals(1, actualIncrementAndGetResult);
  }

  /**
   * Test {@link BlockedScriptInfo#getExpirationTime()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#getExpirationTime()}
   */
  @Test
  @DisplayName("Test getExpirationTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BlockedScriptInfo.getExpirationTime()"})
  void testGetExpirationTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new BlockedScriptInfo(3).getExpirationTime());
  }
}
