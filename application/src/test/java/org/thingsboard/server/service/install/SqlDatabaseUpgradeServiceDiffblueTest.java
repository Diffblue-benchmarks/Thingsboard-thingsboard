package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@ExtendWith(MockitoExtension.class)
class SqlDatabaseUpgradeServiceDiffblueTest {
  @Mock private InstallScripts installScripts;

  @Mock private JdbcTemplate jdbcTemplate;

  @Mock private PlatformTransactionManager platformTransactionManager;

  @InjectMocks private SqlDatabaseUpgradeService sqlDatabaseUpgradeService;

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase() throws DataAccessException, TransactionException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    doThrow(new RuntimeException("3.5.1"))
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.5.1"));
    verify(jdbcTemplate)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 48522364}.
   *   <li>When {@code 3.5.1}.
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName(
      "Test upgradeDatabase(String); given ArrayList() add '48522364'; when '3.5.1'; then calls commit(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenArrayListAdd48522364_when351_thenCallsCommit()
      throws DataAccessException, TransactionException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    // Act
    sqlDatabaseUpgradeService.upgradeDatabase("3.5.1");

    // Assert
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 48522364}.
   *   <li>When {@code 3.6.0}.
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName(
      "Test upgradeDatabase(String); given ArrayList() add '48522364'; when '3.6.0'; then calls commit(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenArrayListAdd48522364_when360_thenCallsCommit()
      throws DataAccessException, TransactionException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    // Act
    sqlDatabaseUpgradeService.upgradeDatabase("3.6.0");

    // Assert
    verify(jdbcTemplate)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus one.
   *   <li>When {@code 3.5.1}.
   *   <li>Then calls {@link InstallScripts#getDataDir()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName(
      "Test upgradeDatabase(String); given ArrayList() add minus one; when '3.5.1'; then calls getDataDir()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenArrayListAddMinusOne_when351_thenCallsGetDataDir()
      throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-1L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.5.1"));
    verify(jdbcTemplate)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate} {@link JdbcTemplate#execute(StatementCallback)} return {@code
   *       Execute}.
   *   <li>Then calls {@link JdbcTemplate#execute(StatementCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName(
      "Test upgradeDatabase(String); given JdbcTemplate execute(StatementCallback) return 'Execute'; then calls execute(StatementCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenJdbcTemplateExecuteReturnExecute_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.execute(Mockito.<StatementCallback<Object>>any())).thenReturn("Execute");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    InstallScripts installScripts = new InstallScripts();

    // Act
    new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager())
        .upgradeDatabase("3.5.0");

    // Assert
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).execute(isA(StatementCallback.class));
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>Then calls {@link InstallScripts#getDataDir()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls getDataDir()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_thenCallsGetDataDir() throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.5.1"));
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate)
        .queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName(
      "Test upgradeDatabase(String); when 'jane.doe@example.org'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_whenJaneDoeExampleOrg_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sqlDatabaseUpgradeService.upgradeDatabase("jane.doe@example.org"));
  }
}
