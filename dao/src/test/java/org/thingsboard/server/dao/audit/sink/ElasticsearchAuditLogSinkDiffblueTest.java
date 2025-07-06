package org.thingsboard.server.dao.audit.sink;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ElasticsearchAuditLogSinkDiffblueTest {
  /**
   * Test {@link ElasticsearchAuditLogSink#init()}.
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.init()"})
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ElasticsearchAuditLogSink().init());
  }
}
