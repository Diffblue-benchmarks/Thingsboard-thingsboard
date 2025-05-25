package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AutoCommitSettingsDiffblueTest {
  /**
   * Test new {@link AutoCommitSettings} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AutoCommitSettings}
   */
  @Test
  @DisplayName("Test new AutoCommitSettings (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AutoCommitSettings.<init>()"})
  void testNewAutoCommitSettings() {
    // Arrange, Act and Assert
    assertTrue((new AutoCommitSettings()).isEmpty());
  }
}
