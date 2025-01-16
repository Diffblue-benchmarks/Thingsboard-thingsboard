package org.thingsboard.server.dao.audit.sink;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ElasticsearchAuditLogSinkDiffblueTest {
  /**
   * Test {@link ElasticsearchAuditLogSink#init()}.
   * <p>
   * Method under test: {@link ElasticsearchAuditLogSink#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new ElasticsearchAuditLogSink()).init());
  }
}
