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

class LwM2MInMemoryBootstrapConfigStoreDiffblueTest {
  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#get(String)} with {@code endpoint}.
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'endpoint'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MInMemoryBootstrapConfigStore.get(String)"})
  void testGetWithEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2MInMemoryBootstrapConfigStore().get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#getAll()}.
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map LwM2MInMemoryBootstrapConfigStore.getAll()"})
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue(new LwM2MInMemoryBootstrapConfigStore().getAll().isEmpty());
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}.
   *
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} (default constructor) All size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#add(String, BootstrapConfig)}
   */
  @Test
  @DisplayName(
      "Test add(String, BootstrapConfig); when BootstrapConfig (default constructor); then LwM2MInMemoryBootstrapConfigStore (default constructor) All size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MInMemoryBootstrapConfigStore.add(String, BootstrapConfig)"})
  void testAdd_whenBootstrapConfig_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne()
      throws InvalidConfigurationException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore =
        new LwM2MInMemoryBootstrapConfigStore();
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.add("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MInMemoryBootstrapConfigStore} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given LwM2MInMemoryBootstrapConfigStore (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MInMemoryBootstrapConfigStore.remove(String)"})
  void testRemove_givenLwM2MInMemoryBootstrapConfigStore_thenReturnNull() {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore =
        new LwM2MInMemoryBootstrapConfigStore();

    // Act and Assert
    assertNull(lwM2MInMemoryBootstrapConfigStore.remove("https://config.us-east-2.amazonaws.com"));
    assertTrue(lwM2MInMemoryBootstrapConfigStore.getAll().isEmpty());
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#remove(String)}.
   *
   * <ul>
   *   <li>Then return {@link BootstrapConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); then return BootstrapConfig (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MInMemoryBootstrapConfigStore.remove(String)"})
  void testRemove_thenReturnBootstrapConfig() throws InvalidConfigurationException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore =
        new LwM2MInMemoryBootstrapConfigStore();
    BootstrapConfig config = new BootstrapConfig();
    lwM2MInMemoryBootstrapConfigStore.add("https://config.us-east-2.amazonaws.com", config);

    // Act
    BootstrapConfig actualRemoveResult =
        lwM2MInMemoryBootstrapConfigStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    assertTrue(lwM2MInMemoryBootstrapConfigStore.getAll().isEmpty());
    assertSame(config, actualRemoveResult);
  }

  /**
   * Test {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String, BootstrapConfig)}.
   *
   * <ul>
   *   <li>Then {@link LwM2MInMemoryBootstrapConfigStore} (default constructor) All size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MInMemoryBootstrapConfigStore#addToStore(String,
   * BootstrapConfig)}
   */
  @Test
  @DisplayName(
      "Test addToStore(String, BootstrapConfig); then LwM2MInMemoryBootstrapConfigStore (default constructor) All size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MInMemoryBootstrapConfigStore.addToStore(String, BootstrapConfig)"})
  void testAddToStore_thenLwM2MInMemoryBootstrapConfigStoreAllSizeIsOne()
      throws InvalidConfigurationException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore =
        new LwM2MInMemoryBootstrapConfigStore();
    BootstrapConfig config = new BootstrapConfig();

    // Act
    lwM2MInMemoryBootstrapConfigStore.addToStore("https://config.us-east-2.amazonaws.com", config);

    // Assert
    Map<String, BootstrapConfig> all = lwM2MInMemoryBootstrapConfigStore.getAll();
    assertEquals(1, all.size());
    assertSame(config, all.get("https://config.us-east-2.amazonaws.com"));
  }
}
