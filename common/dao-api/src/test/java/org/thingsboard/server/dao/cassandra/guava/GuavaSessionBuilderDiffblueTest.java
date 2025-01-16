package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.session.Session;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuavaSessionBuilderDiffblueTest {
  /**
   * Test {@link GuavaSessionBuilder#wrap(CqlSession)}.
   * <p>
   * Method under test: {@link GuavaSessionBuilder#wrap(CqlSession)}
   */
  @Test
  @DisplayName("Test wrap(CqlSession)")
  void testWrap() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDseSession defaultSession = new DefaultDseSession(new DefaultGuavaSession(mock(Session.class)));

    // Act
    GuavaSession actualWrapResult = builderResult.wrap(defaultSession);

    // Assert
    assertTrue(actualWrapResult instanceof DefaultGuavaSession);
    assertNull(actualWrapResult.getContext());
    assertNull(actualWrapResult.getMetadata());
    assertNull(actualWrapResult.getName());
    assertFalse(actualWrapResult.isSchemaMetadataEnabled());
    Optional<CqlIdentifier> keyspace = actualWrapResult.getKeyspace();
    assertFalse(keyspace.isPresent());
    assertSame(defaultSession, ((DefaultGuavaSession) actualWrapResult).getDelegate());
    assertSame(keyspace, actualWrapResult.getMetrics());
  }

  /**
   * Test new {@link GuavaSessionBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link GuavaSessionBuilder}
   */
  @Test
  @DisplayName("Test new GuavaSessionBuilder (default constructor)")
  void testNewGuavaSessionBuilder() {
    // Arrange, Act and Assert
    GuavaSession wrapResult = (new GuavaSessionBuilder()).wrap(null);
    assertTrue(wrapResult instanceof DefaultGuavaSession);
    assertNull(((DefaultGuavaSession) wrapResult).getDelegate());
  }
}
