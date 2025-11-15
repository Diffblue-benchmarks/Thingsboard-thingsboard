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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.Test;

class LwM2MInMemoryBootstrapConfigStoreDiffblueTest {
  /**
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#get(String)}
   */
  @Test
  void testGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LwM2MInMemoryBootstrapConfigStore()).get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#getAll()}
   */
  @Test
  void testGetAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new LwM2MInMemoryBootstrapConfigStore()).getAll().isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}
   */
  @Test
  void testAdd() throws InvalidConfigurationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.add("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}
   */
  @Test
  void testAddToStore() throws InvalidConfigurationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.addToStore("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }
}
