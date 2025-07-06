package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SqlTsDatabaseUpgradeServiceDiffblueTest {
  @Mock private InstallScripts installScripts;

  @InjectMocks private SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService;

  /**
   * Test {@link SqlTsDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <p>Method under test: {@link SqlTsDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlTsDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sqlTsDatabaseUpgradeService.upgradeDatabase("jane.doe@example.org"));
  }

  /**
   * Test {@link SqlTsDatabaseUpgradeService#loadSql(Connection, String, String)}.
   *
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#getDataDir()} return {@code Data Dir}.
   *   <li>Then calls {@link InstallScripts#getDataDir()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsDatabaseUpgradeService#loadSql(Connection, String, String)}
   */
  @Test
  @DisplayName(
      "Test loadSql(Connection, String, String); given InstallScripts getDataDir() return 'Data Dir'; then calls getDataDir()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlTsDatabaseUpgradeService.loadSql(Connection, String, String)"})
  void testLoadSql_givenInstallScriptsGetDataDirReturnDataDir_thenCallsGetDataDir() {
    // Arrange
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    // Act
    sqlTsDatabaseUpgradeService.loadSql(mock(Connection.class), "foo.txt", "1.0.2");

    // Assert
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlTsDatabaseUpgradeService#loadSql(Connection, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsDatabaseUpgradeService#loadSql(Connection, String, String)}
   */
  @Test
  @DisplayName("Test loadSql(Connection, String, String); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlTsDatabaseUpgradeService.loadSql(Connection, String, String)"})
  void testLoadSql_thenThrowRuntimeException() {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("upgrade"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sqlTsDatabaseUpgradeService.loadSql(mock(Connection.class), "foo.txt", "1.0.2"));
    verify(installScripts).getDataDir();
  }
}
