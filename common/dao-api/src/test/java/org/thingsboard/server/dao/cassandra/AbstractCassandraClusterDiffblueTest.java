package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.codahale.metrics.jmx.JmxReporter;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.dao.cassandra.guava.GuavaSession;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class AbstractCassandraClusterDiffblueTest {
  @InjectMocks private CassandraCluster cassandraCluster;

  @Mock private CassandraDriverOptions cassandraDriverOptions;

  @Mock private Environment environment;

  @Mock private GuavaSession guavaSession;

  @Mock private JmxReporter jmxReporter;

  /**
   * Test {@link AbstractCassandraCluster#init(String)}.
   *
   * <ul>
   *   <li>Then {@link CassandraCluster} KeyspaceName is {@code Keyspace Name}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#init(String)}
   */
  @Test
  @DisplayName("Test init(String); then CassandraCluster KeyspaceName is 'Keyspace Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCassandraCluster.init(String)"})
  void testInit_thenCassandraClusterKeyspaceNameIsKeyspaceName() {
    // Arrange
    when(cassandraDriverOptions.getLoader()).thenReturn(new DefaultDriverConfigLoader());
    when(environment.acceptsProfiles(Mockito.<Profiles>any())).thenReturn(true);

    // Act
    cassandraCluster.init("Keyspace Name");

    // Assert
    verify(environment).acceptsProfiles(isA(Profiles.class));
    verify(cassandraDriverOptions).getLoader();
    assertEquals("Keyspace Name", cassandraCluster.getKeyspaceName());
  }

  /**
   * Test {@link AbstractCassandraCluster#init(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#init(String)}
   */
  @Test
  @DisplayName("Test init(String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCassandraCluster.init(String)"})
  void testInit_thenThrowIllegalStateException() {
    // Arrange
    when(cassandraDriverOptions.getLoader()).thenReturn(new DefaultDriverConfigLoader());
    when(environment.acceptsProfiles(Mockito.<Profiles>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cassandraCluster.init("Keyspace Name"));
    verify(environment).acceptsProfiles(isA(Profiles.class));
    verify(cassandraDriverOptions).getLoader();
  }

  /**
   * Test {@link AbstractCassandraCluster#getSession()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#acceptsProfiles(Profiles)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#getSession()}
   */
  @Test
  @DisplayName("Test getSession(); given Environment acceptsProfiles(Profiles) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GuavaSession AbstractCassandraCluster.getSession()"})
  void testGetSession_givenEnvironmentAcceptsProfilesReturnFalse() {
    // Arrange
    when(environment.acceptsProfiles(Mockito.<Profiles>any())).thenReturn(false);

    // Act
    cassandraCluster.getSession();

    // Assert
    verify(environment).acceptsProfiles(isA(Profiles.class));
  }

  /**
   * Test {@link AbstractCassandraCluster#getKeyspaceName()}.
   *
   * <p>Method under test: {@link AbstractCassandraCluster#getKeyspaceName()}
   */
  @Test
  @DisplayName("Test getKeyspaceName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCassandraCluster.getKeyspaceName()"})
  void testGetKeyspaceName() {
    // Arrange, Act and Assert
    assertNull(new CassandraCluster().getKeyspaceName());
  }

  /**
   * Test {@link AbstractCassandraCluster#close()}.
   *
   * <ul>
   *   <li>Given {@link CassandraCluster} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#close()}
   */
  @Test
  @DisplayName("Test close(); given CassandraCluster (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCassandraCluster.close()"})
  void testClose_givenCassandraCluster_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new CassandraCluster().close());
  }

  /**
   * Test {@link AbstractCassandraCluster#close()}.
   *
   * <ul>
   *   <li>Given {@link GuavaSession} {@link GuavaSession#close()} does nothing.
   *   <li>Then calls {@link GuavaSession#close()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#close()}
   */
  @Test
  @DisplayName("Test close(); given GuavaSession close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCassandraCluster.close()"})
  void testClose_givenGuavaSessionCloseDoesNothing_thenCallsClose() {
    // Arrange
    doNothing().when(jmxReporter).stop();
    doNothing().when(guavaSession).close();

    // Act
    cassandraCluster.close();

    // Assert
    verify(jmxReporter).stop();
    verify(guavaSession).close();
  }

  /**
   * Test {@link AbstractCassandraCluster#close()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#close()}
   */
  @Test
  @DisplayName("Test close(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCassandraCluster.close()"})
  void testClose_thenThrowIllegalStateException() {
    // Arrange
    doThrow(new IllegalStateException()).when(jmxReporter).stop();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cassandraCluster.close());
    verify(jmxReporter).stop();
  }

  /**
   * Test {@link AbstractCassandraCluster#getDefaultReadConsistencyLevel()}.
   *
   * <ul>
   *   <li>Then calls {@link CassandraDriverOptions#getDefaultReadConsistencyLevel()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#getDefaultReadConsistencyLevel()}
   */
  @Test
  @DisplayName("Test getDefaultReadConsistencyLevel(); then calls getDefaultReadConsistencyLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConsistencyLevel AbstractCassandraCluster.getDefaultReadConsistencyLevel()"})
  void testGetDefaultReadConsistencyLevel_thenCallsGetDefaultReadConsistencyLevel() {
    // Arrange
    when(cassandraDriverOptions.getDefaultReadConsistencyLevel())
        .thenReturn(mock(ConsistencyLevel.class));

    // Act
    cassandraCluster.getDefaultReadConsistencyLevel();

    // Assert
    verify(cassandraDriverOptions).getDefaultReadConsistencyLevel();
  }

  /**
   * Test {@link AbstractCassandraCluster#getDefaultWriteConsistencyLevel()}.
   *
   * <ul>
   *   <li>Then calls {@link CassandraDriverOptions#getDefaultWriteConsistencyLevel()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraCluster#getDefaultWriteConsistencyLevel()}
   */
  @Test
  @DisplayName(
      "Test getDefaultWriteConsistencyLevel(); then calls getDefaultWriteConsistencyLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConsistencyLevel AbstractCassandraCluster.getDefaultWriteConsistencyLevel()"})
  void testGetDefaultWriteConsistencyLevel_thenCallsGetDefaultWriteConsistencyLevel() {
    // Arrange
    when(cassandraDriverOptions.getDefaultWriteConsistencyLevel())
        .thenReturn(mock(ConsistencyLevel.class));

    // Act
    cassandraCluster.getDefaultWriteConsistencyLevel();

    // Assert
    verify(cassandraDriverOptions).getDefaultWriteConsistencyLevel();
  }
}
