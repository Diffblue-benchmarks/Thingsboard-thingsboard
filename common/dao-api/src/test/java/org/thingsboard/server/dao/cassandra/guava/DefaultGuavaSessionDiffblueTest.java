package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.internal.core.session.SessionWrapper;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGuavaSession.<init>(Session)"})
  void testNewDefaultGuavaSession() {
    // Arrange
    SessionWrapper delegate = new SessionWrapper(new DefaultDseSession(null));

    // Act and Assert
    assertSame(delegate, new DefaultGuavaSession(delegate).getDelegate());
  }
}
