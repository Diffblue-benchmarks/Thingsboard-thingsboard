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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;
import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

class SqlDatabaseUpgradeServiceDiffblueTest {
  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus one.</li>
   *   <li>When {@code 3.5.0}.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given ArrayList() add minus one; when '3.5.0'; then calls execute(String)")
  void testUpgradeDatabase_givenArrayListAddMinusOne_when350_thenCallsExecute() throws DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(48522364L);
    resultLongList.add(-1L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    InstallScripts installScripts = mock(InstallScripts.class);

    // Act
    (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager()))
        .upgradeDatabase("3.5.0");

    // Assert
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus one.</li>
   *   <li>When {@code 3.5.0}.</li>
   *   <li>Then calls {@link InstallScripts#getDataDir()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given ArrayList() add minus one; when '3.5.0'; then calls getDataDir()")
  void testUpgradeDatabase_givenArrayListAddMinusOne_when350_thenCallsGetDataDir() throws DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-1L);
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(resultLongList);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager()))
            .upgradeDatabase("3.5.0"));
    verify(jdbcTemplate).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings (schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version))"));
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   *   <li>When {@code 3.5.1}.</li>
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.5.1'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when351_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>When {@code 3.6.0}.</li>
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.0'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when360_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.0");

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
   *   <li>When {@code 3.6.2}.</li>
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.2'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when362_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.3'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when363_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.6.4'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when364_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.7.0'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when370_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() does nothing; when '3.8.1'; then calls commit()")
  void testUpgradeDatabase_givenConnectionCommitDoesNothing_when381_thenCallsCommit()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.6.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.6.0'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when360()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.6.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.6.1'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when361()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.1"));
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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.6.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.6.2'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when362()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.2"));
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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.6.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.6.3'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when363()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.3"));
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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.6.4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.6.4'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when364()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.6.4"));
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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.7.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.7.0'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when370()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.7.0"));
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
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link RuntimeException#RuntimeException(String)} with {@code 3.5.1}.</li>
   *   <li>When {@code 3.8.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); given Connection commit() throw RuntimeException(String) with '3.5.1'; when '3.8.1'")
  void testUpgradeDatabase_givenConnectionCommitThrowRuntimeExceptionWith351_when381()
      throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.8.1"));
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
   *   <li>Then calls {@link JdbcTemplate#execute(StatementCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls execute(StatementCallback)")
  void testUpgradeDatabase_thenCallsExecute() throws DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link InstallScripts#getDataDir()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); then calls getDataDir()")
  void testUpgradeDatabase_thenCallsGetDataDir() throws DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager()))
            .upgradeDatabase("3.5.0"));
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).queryForList(eq("SELECT schema_version FROM tb_schema_settings"), isA(Class.class));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}.
   * <ul>
   *   <li>When {@code 3.5.1}.</li>
   *   <li>Then calls {@link InstallScripts#getDataDir()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); when '3.5.1'; then calls getDataDir()")
  void testUpgradeDatabase_when351_thenCallsGetDataDir() throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(new ArrayList<>());
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).rollback();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate,
        new DataSourceTransactionManager(dataSource))).upgradeDatabase("3.5.1"));
    verify(connection).close();
    verify(connection).getAutoCommit();
    verify(connection).rollback();
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
   *   <li>When {@code 3.6.1}.</li>
   *   <li>Then calls {@link InstallScripts#getDataDir()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); when '3.6.1'; then calls getDataDir()")
  void testUpgradeDatabase_when361_thenCallsGetDataDir() throws SQLException, DataAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>When {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String); when 'jane.doe@example.org'")
  void testUpgradeDatabase_whenJaneDoeExampleOrg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = new InstallScripts();
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new SqlDatabaseUpgradeService(installScripts, jdbcTemplate, new PseudoTransactionManager()))
            .upgradeDatabase("jane.doe@example.org"));
  }
}
