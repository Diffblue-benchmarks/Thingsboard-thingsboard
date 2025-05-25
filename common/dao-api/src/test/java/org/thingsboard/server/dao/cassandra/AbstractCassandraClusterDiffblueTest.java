package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.dao.cassandra.guava.GuavaSession;

@ExtendWith(MockitoExtension.class)
class AbstractCassandraClusterDiffblueTest {
  @InjectMocks
  private CassandraCluster cassandraCluster;

  @Mock
  private Environment environment;

  /**
   * Test {@link AbstractCassandraCluster#getSession()}.
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#acceptsProfiles(Profiles)} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCassandraCluster#getSession()}
   */
  @Test
  @DisplayName("Test getSession(); given Environment acceptsProfiles(Profiles) return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GuavaSession AbstractCassandraCluster.getSession()"})
  void testGetSession_givenEnvironmentAcceptsProfilesReturnFalse_thenReturnNull() {
    // Arrange
    when(environment.acceptsProfiles(Mockito.<Profiles>any())).thenReturn(false);

    // Act
    GuavaSession actualSession = cassandraCluster.getSession();

    // Assert
    verify(environment).acceptsProfiles(isA(Profiles.class));
    assertNull(actualSession);
  }

  /**
   * Test {@link AbstractCassandraCluster#getKeyspaceName()}.
   * <p>
   * Method under test: {@link AbstractCassandraCluster#getKeyspaceName()}
   */
  @Test
  @DisplayName("Test getKeyspaceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractCassandraCluster.getKeyspaceName()"})
  void testGetKeyspaceName() {
    // Arrange, Act and Assert
    assertNull((new CassandraCluster()).getKeyspaceName());
  }
}
