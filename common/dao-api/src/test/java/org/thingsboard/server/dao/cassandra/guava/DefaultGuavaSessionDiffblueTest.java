package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.session.Session;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultGuavaSessionDiffblueTest {
  /**
   * Test {@link DefaultGuavaSession#DefaultGuavaSession(Session)}.
   *
   * <p>Method under test: {@link DefaultGuavaSession#DefaultGuavaSession(Session)}
   */
  @Test
  @DisplayName("Test new DefaultGuavaSession(Session)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGuavaSession.<init>(Session)"})
  void testNewDefaultGuavaSession() {
    // Arrange
    DefaultDseSession delegate = new DefaultDseSession(null);

    // Act and Assert
    Session delegate2 = new DefaultGuavaSession(delegate).getDelegate();
    assertTrue(delegate2 instanceof DefaultDseSession);
    assertSame(delegate, delegate2);
  }
}
