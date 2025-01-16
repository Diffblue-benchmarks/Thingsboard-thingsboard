package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MInMemoryBootstrapConfigStoreDiffblueTest {
  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#get(String)} with
   * {@code endpoint}.
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'endpoint'")
  void testGetWithEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LwM2MInMemoryBootstrapConfigStore()).get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#getAll()}.
   * <p>
   * Method under test: {@link LwM2MInMemoryBootstrapConfigStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  void testGetAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new LwM2MInMemoryBootstrapConfigStore()).getAll().isEmpty());
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}.
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).</li>
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} (default constructor) All
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}
   */
  @Test
  @DisplayName("Test add(String, BootstrapConfig); when BootstrapConfig (default constructor); then LwM2MInMemoryBootstrapConfigStore (default constructor) All size is one")
  void testAdd_whenBootstrapConfig_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne()
      throws InvalidConfigurationException {
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
   * Test
   * {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}.
   * <ul>
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} (default constructor) All
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}
   */
  @Test
  @DisplayName("Test addToStore(String, BootstrapConfig); then LwM2MInMemoryBootstrapConfigStore (default constructor) All size is one")
  void testAddToStore_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne() throws InvalidConfigurationException {
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
