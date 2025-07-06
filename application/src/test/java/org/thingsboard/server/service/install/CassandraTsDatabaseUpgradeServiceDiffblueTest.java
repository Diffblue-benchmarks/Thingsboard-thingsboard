package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CassandraTsDatabaseUpgradeServiceDiffblueTest {
  @InjectMocks private CassandraTsDatabaseUpgradeService cassandraTsDatabaseUpgradeService;

  /**
   * Test {@link CassandraTsDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <p>Method under test: {@link CassandraTsDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraTsDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> cassandraTsDatabaseUpgradeService.upgradeDatabase("jane.doe@example.org"));
  }
}
