package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserSettingsTypeDiffblueTest {
  /**
   * Test {@link UserSettingsType#isReserved()}.
   * <p>
   * Method under test: {@link UserSettingsType#isReserved()}
   */
  @Test
  @DisplayName("Test isReserved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserSettingsType.isReserved()"})
  void testIsReserved() {
    // Arrange, Act and Assert
    assertFalse(UserSettingsType.valueOf("GENERAL").isReserved());
  }
}
