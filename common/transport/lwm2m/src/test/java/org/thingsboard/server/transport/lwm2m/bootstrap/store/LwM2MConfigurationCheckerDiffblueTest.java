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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.Test;

class LwM2MConfigurationCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}
   */
  @Test
  void testValidateOneSecurityByServer() throws InvalidConfigurationException {
    // Arrange
    LwM2MConfigurationChecker lwM2MConfigurationChecker = new LwM2MConfigurationChecker();

    HashMap<Integer, BootstrapConfig.ServerConfig> integerServerConfigMap = new HashMap<>();
    integerServerConfigMap.put(1, new BootstrapConfig.ServerConfig());
    BootstrapConfig config = new BootstrapConfig();
    config.servers = integerServerConfigMap;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> lwM2MConfigurationChecker.validateOneSecurityByServer(config));
  }

  /**
   * Method under test:
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}
   */
  @Test
  void testGetSecurityEntry() {
    // Arrange, Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(new BootstrapConfig(), 1));
  }

  /**
   * Method under test:
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}
   */
  @Test
  void testGetSecurityEntry2() {
    // Arrange
    HashMap<Integer, BootstrapConfig.ACLConfig> integerAclConfigMap = new HashMap<>();
    integerAclConfigMap.computeIfPresent(1, mock(BiFunction.class));
    BootstrapConfig config = new BootstrapConfig();
    config.acls = integerAclConfigMap;

    // Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(config, 1));
  }
}
