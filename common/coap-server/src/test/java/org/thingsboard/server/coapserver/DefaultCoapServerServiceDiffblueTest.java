package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.CoapServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultCoapServerServiceDiffblueTest {
  @Mock private CoapServer coapServer;

  @Mock private CoapServerContext coapServerContext;

  @InjectMocks private DefaultCoapServerService defaultCoapServerService;

  @Mock private ScheduledExecutorService scheduledExecutorService;

  @Mock private TbCoapDtlsCertificateVerifier tbCoapDtlsCertificateVerifier;

  /**
   * Test {@link DefaultCoapServerService#init()}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link
   *       UnknownHostException#UnknownHostException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapServerService#init()}
   */
  @Test
  @DisplayName("Test init(); given InetAddress getByName(String) throw UnknownHostException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultCoapServerService.init()"})
  void testInit_givenInetAddressGetByNameThrowUnknownHostException() throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());
      when(coapServerContext.getHost()).thenReturn("localhost");
      when(coapServerContext.getPort()).thenReturn(8080);

      // Act and Assert
      assertThrows(UnknownHostException.class, () -> defaultCoapServerService.init());
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(coapServerContext).getHost();
      verify(coapServerContext).getPort();
    }
  }

  /**
   * Test {@link DefaultCoapServerService#shutdown()}.
   *
   * <p>Method under test: {@link DefaultCoapServerService#shutdown()}
   */
  @Test
  @DisplayName("Test shutdown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultCoapServerService.shutdown()"})
  void testShutdown() {
    // Arrange
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(coapServer).destroy();

    // Act
    defaultCoapServerService.shutdown();

    // Assert
    verify(scheduledExecutorService).shutdownNow();
    verify(coapServer).destroy();
  }

  /**
   * Test {@link DefaultCoapServerService#getDtlsSessionsMap()}.
   *
   * <ul>
   *   <li>Given {@link DefaultCoapServerService} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapServerService#getDtlsSessionsMap()}
   */
  @Test
  @DisplayName(
      "Test getDtlsSessionsMap(); given DefaultCoapServerService (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConcurrentMap DefaultCoapServerService.getDtlsSessionsMap()"})
  void testGetDtlsSessionsMap_givenDefaultCoapServerService_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DefaultCoapServerService().getDtlsSessionsMap());
  }

  /**
   * Test {@link DefaultCoapServerService#getDtlsSessionsMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapServerService#getDtlsSessionsMap()}
   */
  @Test
  @DisplayName("Test getDtlsSessionsMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConcurrentMap DefaultCoapServerService.getDtlsSessionsMap()"})
  void testGetDtlsSessionsMap_thenReturnEmpty() {
    // Arrange
    ConcurrentHashMap<InetSocketAddress, TbCoapDtlsSessionInfo>
        inetSocketAddressTbCoapDtlsSessionInfoMap = new ConcurrentHashMap<>();
    when(tbCoapDtlsCertificateVerifier.getTbCoapDtlsSessionsMap())
        .thenReturn(inetSocketAddressTbCoapDtlsSessionInfoMap);

    // Act
    ConcurrentMap<InetSocketAddress, TbCoapDtlsSessionInfo> actualDtlsSessionsMap =
        defaultCoapServerService.getDtlsSessionsMap();

    // Assert
    verify(tbCoapDtlsCertificateVerifier).getTbCoapDtlsSessionsMap();
    assertTrue(actualDtlsSessionsMap.isEmpty());
    assertSame(inetSocketAddressTbCoapDtlsSessionInfoMap, actualDtlsSessionsMap);
  }
}
