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
package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LwM2MConfigurationChecker.class})
@ExtendWith(SpringExtension.class)
class LwM2MConfigurationCheckerDiffblueTest {
  @Autowired private LwM2MConfigurationChecker lwM2MConfigurationChecker;

  /**
   * Test {@link LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}.
   *
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}
   */
  @Test
  @DisplayName(
      "Test validateOneSecurityByServer(BootstrapConfig); when BootstrapConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MConfigurationChecker.validateOneSecurityByServer(BootstrapConfig)"})
  void testValidateOneSecurityByServer_whenBootstrapConfig() throws InvalidConfigurationException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> lwM2MConfigurationChecker.validateOneSecurityByServer(new BootstrapConfig()));
  }

  /**
   * Test {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}.
   *
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}
   */
  @Test
  @DisplayName(
      "Test getSecurityEntry(BootstrapConfig, int); when BootstrapConfig (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BootstrapConfig.ServerSecurity LwM2MConfigurationChecker.getSecurityEntry(BootstrapConfig, int)"
  })
  void testGetSecurityEntry_whenBootstrapConfig_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(new BootstrapConfig(), 1));
  }
}
