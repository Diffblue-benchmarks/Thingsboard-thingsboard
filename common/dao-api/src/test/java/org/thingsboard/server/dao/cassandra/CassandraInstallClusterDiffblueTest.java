/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.cassandra;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class CassandraInstallClusterDiffblueTest {
  @Mock private CassandraDriverOptions cassandraDriverOptions;

  @InjectMocks private CassandraInstallCluster cassandraInstallCluster;

  @Mock private Environment environment;

  /**
   * Test {@link CassandraInstallCluster#init()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#acceptsProfiles(Profiles)} return {@code
   *       true}.
   *   <li>Then calls {@link Environment#acceptsProfiles(Profiles)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraInstallCluster#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given Environment acceptsProfiles(Profiles) return 'true'; then calls acceptsProfiles(Profiles)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraInstallCluster.init()"})
  void testInit_givenEnvironmentAcceptsProfilesReturnTrue_thenCallsAcceptsProfiles() {
    // Arrange
    when(cassandraDriverOptions.getLoader()).thenReturn(new DefaultDriverConfigLoader());
    when(environment.acceptsProfiles(Mockito.<Profiles>any())).thenReturn(true);

    // Act
    cassandraInstallCluster.init();

    // Assert
    verify(environment).acceptsProfiles(isA(Profiles.class));
    verify(cassandraDriverOptions).getLoader();
  }
}
