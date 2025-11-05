package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsersFilterTypeDiffblueTest {
  /**
   * Test {@link UsersFilterType#isForRules()}.
   *
   * <p>Method under test: {@link UsersFilterType#isForRules()}
   */
  @Test
  @DisplayName("Test isForRules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsersFilterType.isForRules()"})
  void testIsForRules() {
    // Arrange, Act and Assert
    assertFalse(UsersFilterType.valueOf("USER_LIST").isForRules());
  }
}
