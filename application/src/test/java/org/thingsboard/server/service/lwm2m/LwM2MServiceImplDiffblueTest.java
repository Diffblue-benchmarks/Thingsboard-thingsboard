package org.thingsboard.server.service.lwm2m;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MServerSecurityConfigDefault;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;

@ExtendWith(MockitoExtension.class)
class LwM2MServiceImplDiffblueTest {
  @InjectMocks private LwM2MServiceImpl lwM2MServiceImpl;

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MServiceImpl}.
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName(
      "Test getServerSecurityInfo(boolean); given LwM2MServiceImpl; when 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "LwM2MServerSecurityConfigDefault LwM2MServiceImpl.getServerSecurityInfo(boolean)"
  })
  void testGetServerSecurityInfo_givenLwM2MServiceImpl_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(lwM2MServiceImpl.getServerSecurityInfo(false));
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   *
   * <ul>
   *   <li>Then return Port is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); then return Port is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "LwM2MServerSecurityConfigDefault LwM2MServiceImpl.getServerSecurityInfo(boolean)"
  })
  void testGetServerSecurityInfo_thenReturnPortIsNull() {
    // Arrange
    LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig =
        Optional.of(new LwM2MTransportBootstrapConfig());

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo =
        new LwM2MServiceImpl(serverConfig, bootstrapConfig).getServerSecurityInfo(true);

    // Assert
    assertNull(actualServerSecurityInfo.getPort());
    assertNull(actualServerSecurityInfo.getShortServerId());
    assertNull(actualServerSecurityInfo.getSecurityPort());
    assertNull(actualServerSecurityInfo.getHost());
    assertNull(actualServerSecurityInfo.getSecurityHost());
  }
}
