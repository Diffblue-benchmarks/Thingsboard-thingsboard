package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MConfigurationCheckerDiffblueTest {
  /**
   * Test
   * {@link LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}.
   * <ul>
   *   <li>Then throw {@link InvalidConfigurationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}
   */
  @Test
  @DisplayName("Test validateOneSecurityByServer(BootstrapConfig); then throw InvalidConfigurationException")
  void testValidateOneSecurityByServer_thenThrowInvalidConfigurationException() throws InvalidConfigurationException {
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
   * Test
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent one and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}
   */
  @Test
  @DisplayName("Test getSecurityEntry(BootstrapConfig, int); given HashMap() computeIfPresent one and BiFunction")
  void testGetSecurityEntry_givenHashMapComputeIfPresentOneAndBiFunction() {
    // Arrange
    HashMap<Integer, BootstrapConfig.ACLConfig> integerAclConfigMap = new HashMap<>();
    integerAclConfigMap.computeIfPresent(1, mock(BiFunction.class));
    BootstrapConfig config = new BootstrapConfig();
    config.acls = integerAclConfigMap;

    // Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(config, 1));
  }

  /**
   * Test
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}.
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MConfigurationChecker#getSecurityEntry(BootstrapConfig, int)}
   */
  @Test
  @DisplayName("Test getSecurityEntry(BootstrapConfig, int); when BootstrapConfig (default constructor); then return 'null'")
  void testGetSecurityEntry_whenBootstrapConfig_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(new BootstrapConfig(), 1));
  }
}
