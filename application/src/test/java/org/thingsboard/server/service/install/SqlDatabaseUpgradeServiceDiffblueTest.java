package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@ExtendWith(MockitoExtension.class)
class SqlDatabaseUpgradeServiceDiffblueTest {
  @Mock
  private InstallScripts installScripts;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @InjectMocks
  private SqlDatabaseUpgradeService sqlDatabaseUpgradeService;

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.5.1}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.5.1'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when351_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.5.1");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.6.2}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.2'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when362_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.2");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.6.3}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.3'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when363_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.3");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.6.4}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.4'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when364_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.4");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.7.0}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.7.0'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when370_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.7.0");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.8.1}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.8.1'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when381_thenCallsClose()
      throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.8.1");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#getDataDir()} return {@code Data Dir}.</li>
   *   <li>When {@code 3.5.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given InstallScripts getDataDir() return 'Data Dir'; when '3.5.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenInstallScriptsGetDataDirReturnDataDir_when350()
      throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.5.0"));
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#getDataDir()} return {@code Data Dir}.</li>
   *   <li>When {@code 3.6.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given InstallScripts getDataDir() return 'Data Dir'; when '3.6.1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenInstallScriptsGetDataDirReturnDataDir_when361()
      throws SQLException, DataAccessException {
    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new DataSourceTransactionManager(dataSource)))
        .upgradeDatabase("3.6.1");

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link JdbcTemplate} {@link JdbcTemplate#execute(StatementCallback)} return {@code Execute}.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(StatementCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given JdbcTemplate execute(StatementCallback) return 'Execute'; then calls execute(StatementCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_givenJdbcTemplateExecuteReturnExecute_thenCallsExecute() throws DataAccessException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.execute(Mockito.<StatementCallback<Object>>any())).thenReturn("Execute");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    InstallScripts installScripts = new InstallScripts();

    // Act
    (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager()))
        .upgradeDatabase("3.5.0");

    // Assert
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).execute(isA(StatementCallback.class));
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls commit(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_thenCallsCommit() throws DataAccessException, TransactionException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    resultLongList.add(-1L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    // Act
    sqlDatabaseUpgradeService.upgradeDatabase("3.6.0");

    // Assert
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls rollback(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_thenCallsRollback() throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("3.5.0"));
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.6.0"));
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#rollback(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls rollback(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_thenCallsRollback2() throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("3.5.0"));

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-1L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("3.6.0"));
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Then calls {@link Connection#rollback()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls rollback()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_thenCallsRollback3() throws SQLException, DataAccessException {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doThrow(new RuntimeException("3.5.1")).when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).rollback();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new SqlDatabaseUpgradeService(mock(InstallScripts.class), jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.0"));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).rollback();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate, atLeast(1)).queryForList(eq("SELECT schema_version FROM tb_schema_settings"),
        isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>When {@code 3.6.1}.</li>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); when '3.6.1'; then calls commit(TransactionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_when361_thenCallsCommit() throws DataAccessException, TransactionException {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("3.5.0"));

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    resultLongList.add(-1L);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    // Act
    sqlDatabaseUpgradeService.upgradeDatabase("3.6.1");

    // Assert
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>When {@code jane.doe@example.org}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); when 'jane.doe@example.org'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SqlDatabaseUpgradeService.upgradeDatabase(String)"})
  void testUpgradeDatabase_whenJaneDoeExampleOrg_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> sqlDatabaseUpgradeService.upgradeDatabase("jane.doe@example.org"));
  }
}
