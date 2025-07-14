package org.thingsboard.server.dao.audit.sink;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElasticsearchAuditLogSinkDiffblueTest {
  /**
   * Test {@link ElasticsearchAuditLogSink#init()}.
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.init()"})
  void testInit() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ElasticsearchAuditLogSink().init());
  }
}
