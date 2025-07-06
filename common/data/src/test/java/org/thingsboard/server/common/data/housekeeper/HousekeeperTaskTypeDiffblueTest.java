package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HousekeeperTaskTypeDiffblueTest {
  /**
   * Test {@link HousekeeperTaskType#getDescription()}.
   *
   * <p>Method under test: {@link HousekeeperTaskType#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String HousekeeperTaskType.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals(
        "attributes deletion", HousekeeperTaskType.valueOf("DELETE_ATTRIBUTES").getDescription());
  }
}
