package org.thingsboard.server.service.install.cql;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CQLStatementsParserDiffblueTest {
  /**
   * Test {@link CQLStatementsParser#getStatements()}.
   * <p>
   * Method under test: {@link CQLStatementsParser#getStatements()}
   */
  @Test
  @DisplayName("Test getStatements()")
  void testGetStatements() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new CQLStatementsParser(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"))).getStatements()
        .isEmpty());
  }
}
