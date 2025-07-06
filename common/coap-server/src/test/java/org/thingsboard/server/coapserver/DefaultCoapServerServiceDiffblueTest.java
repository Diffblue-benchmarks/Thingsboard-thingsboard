package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
  @Mock private CoapServerContext coapServerContext;

  @InjectMocks private DefaultCoapServerService defaultCoapServerService;

  /**
   * Test {@link DefaultCoapServerService#init()}.
   *
   * <ul>
   *   <li>Then throw {@link UnknownHostException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapServerService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw UnknownHostException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCoapServerService.init()"})
  void testInit_thenThrowUnknownHostException() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("foo"));
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
   * Test {@link DefaultCoapServerService#getCoapServer()}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link
   *       UnknownHostException#UnknownHostException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapServerService#getCoapServer()}
   */
  @Test
  @DisplayName(
      "Test getCoapServer(); given InetAddress getByName(String) throw UnknownHostException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.californium.core.CoapServer DefaultCoapServerService.getCoapServer()"
  })
  void testGetCoapServer_givenInetAddressGetByNameThrowUnknownHostExceptionWithFoo()
      throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("foo"));
      when(coapServerContext.getHost()).thenReturn("localhost");
      when(coapServerContext.getPort()).thenReturn(8080);

      // Act and Assert
      assertThrows(UnknownHostException.class, () -> defaultCoapServerService.getCoapServer());
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(coapServerContext).getHost();
      verify(coapServerContext).getPort();
    }
  }

  /**
   * Test {@link DefaultCoapServerService#getDtlsSessionsMap()}.
   *
   * <p>Method under test: {@link DefaultCoapServerService#getDtlsSessionsMap()}
   */
  @Test
  @DisplayName("Test getDtlsSessionsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.concurrent.ConcurrentMap DefaultCoapServerService.getDtlsSessionsMap()"
  })
  void testGetDtlsSessionsMap() {
    // Arrange, Act and Assert
    assertNull(defaultCoapServerService.getDtlsSessionsMap());
  }
}
