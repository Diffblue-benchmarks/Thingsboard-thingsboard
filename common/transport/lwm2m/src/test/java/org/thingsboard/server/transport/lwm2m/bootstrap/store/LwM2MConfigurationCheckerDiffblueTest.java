package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig.ServerConfig;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MConfigurationCheckerDiffblueTest {
  /**
   * Test {@link LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidConfigurationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MConfigurationChecker#validateOneSecurityByServer(BootstrapConfig)}
   */
  @Test
  @DisplayName(
      "Test validateOneSecurityByServer(BootstrapConfig); then throw InvalidConfigurationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MConfigurationChecker.validateOneSecurityByServer(BootstrapConfig)"})
  void testValidateOneSecurityByServer_thenThrowInvalidConfigurationException()
      throws InvalidConfigurationException {
    // Arrange
    LwM2MConfigurationChecker lwM2MConfigurationChecker = new LwM2MConfigurationChecker();

    HashMap<Integer, ServerConfig> integerServerConfigMap = new HashMap<>();
    integerServerConfigMap.put(1, new ServerConfig());
    BootstrapConfig config = new BootstrapConfig();
    config.servers = integerServerConfigMap;

    // Act and Assert
    assertThrows(
        InvalidConfigurationException.class,
        () -> lwM2MConfigurationChecker.validateOneSecurityByServer(config));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "BootstrapConfig.ServerSecurity LwM2MConfigurationChecker.getSecurityEntry(BootstrapConfig, int)"
  })
  void testGetSecurityEntry_whenBootstrapConfig_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MConfigurationChecker.getSecurityEntry(new BootstrapConfig(), 1));
  }
}
