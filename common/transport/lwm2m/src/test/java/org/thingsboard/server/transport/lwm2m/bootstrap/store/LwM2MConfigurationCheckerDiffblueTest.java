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
