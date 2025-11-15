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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LwM2MInMemoryBootstrapConfigStoreDiffblueTest {
  @InjectMocks
  private LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore;

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#get(String)} with {@code endpoint}.
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'endpoint'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MInMemoryBootstrapConfigStore.get(String)"})
  void testGetWithEndpoint() {
    // Arrange, Act and Assert
    assertNull(lwM2MInMemoryBootstrapConfigStore.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#getAll()}.
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map LwM2MInMemoryBootstrapConfigStore.getAll()"})
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue(lwM2MInMemoryBootstrapConfigStore.getAll().isEmpty());
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}.
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).</li>
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} All size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}
   */
  @Test
  @DisplayName("Test add(String, BootstrapConfig); when BootstrapConfig (default constructor); then LwM2MInMemoryBootstrapConfigStore All size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MInMemoryBootstrapConfigStore.add(String, BootstrapConfig)"})
  void testAdd_whenBootstrapConfig_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne()
      throws InvalidConfigurationException {
    // Arrange
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.add("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}.
   * <ul>
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} All size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}
   */
  @Test
  @DisplayName("Test addToStore(String, BootstrapConfig); then LwM2MInMemoryBootstrapConfigStore All size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MInMemoryBootstrapConfigStore.addToStore(String, BootstrapConfig)"})
  void testAddToStore_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne() throws InvalidConfigurationException {
    // Arrange
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.addToStore("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }
}
