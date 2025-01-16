package org.thingsboard.server.dao.sqlts.sql;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class JpaSqlTimeseriesDaoDiffblueTest {
  /**
   * Test {@link JpaSqlTimeseriesDao#init()}.
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new JpaSqlTimeseriesDao()).init());
  }
}
