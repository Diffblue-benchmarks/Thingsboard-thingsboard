package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SqlAbstractDatabaseSchemaServiceDiffblueTest {
  /**
   * Test {@link SqlAbstractDatabaseSchemaService#executeQuery(String)} with
   * {@code query}.
   * <p>
   * Method under test:
   * {@link SqlAbstractDatabaseSchemaService#executeQuery(String)}
   */
  @Test
  @DisplayName("Test executeQuery(String) with 'query'")
  void testExecuteQueryWithQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new SqlEntityDatabaseSchemaService()).executeQuery("Query"));
  }

  /**
   * Test {@link SqlAbstractDatabaseSchemaService#executeQuery(String, String)}
   * with {@code query}, {@code logQuery}.
   * <ul>
   *   <li>When {@code Log Query}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlAbstractDatabaseSchemaService#executeQuery(String, String)}
   */
  @Test
  @DisplayName("Test executeQuery(String, String) with 'query', 'logQuery'; when 'Log Query'")
  void testExecuteQueryWithQueryLogQuery_whenLogQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new SqlEntityDatabaseSchemaService()).executeQuery("Query", "Log Query"));
  }

  /**
   * Test {@link SqlAbstractDatabaseSchemaService#executeQuery(String, String)}
   * with {@code query}, {@code logQuery}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlAbstractDatabaseSchemaService#executeQuery(String, String)}
   */
  @Test
  @DisplayName("Test executeQuery(String, String) with 'query', 'logQuery'; when 'null'")
  void testExecuteQueryWithQueryLogQuery_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new SqlEntityDatabaseSchemaService()).executeQuery("Query", null));
  }
}
