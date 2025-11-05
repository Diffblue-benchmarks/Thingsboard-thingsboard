package org.thingsboard.server.queue.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;

class HousekeeperConfigDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HousekeeperConfig#getDisabledTaskTypes()}
   *   <li>{@link HousekeeperConfig#getMaxReprocessingAttempts()}
   *   <li>{@link HousekeeperConfig#getPollInterval()}
   *   <li>{@link HousekeeperConfig#getTaskProcessingTimeout()}
   *   <li>{@link HousekeeperConfig#getTaskReprocessingDelay()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set HousekeeperConfig.getDisabledTaskTypes()",
    "int HousekeeperConfig.getMaxReprocessingAttempts()",
    "int HousekeeperConfig.getPollInterval()",
    "int HousekeeperConfig.getTaskProcessingTimeout()",
    "int HousekeeperConfig.getTaskReprocessingDelay()"
  })
  void testGettersAndSetters() {
    // Arrange
    HousekeeperConfig housekeeperConfig = new HousekeeperConfig();

    // Act
    Set<HousekeeperTaskType> actualDisabledTaskTypes = housekeeperConfig.getDisabledTaskTypes();
    int actualMaxReprocessingAttempts = housekeeperConfig.getMaxReprocessingAttempts();
    int actualPollInterval = housekeeperConfig.getPollInterval();
    int actualTaskProcessingTimeout = housekeeperConfig.getTaskProcessingTimeout();

    // Assert
    assertNull(actualDisabledTaskTypes);
    assertEquals(0, actualMaxReprocessingAttempts);
    assertEquals(0, actualPollInterval);
    assertEquals(0, actualTaskProcessingTimeout);
    assertEquals(0, housekeeperConfig.getTaskReprocessingDelay());
  }
}
