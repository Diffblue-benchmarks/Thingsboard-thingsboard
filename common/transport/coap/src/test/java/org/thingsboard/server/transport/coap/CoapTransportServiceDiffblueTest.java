package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.UnknownHostException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.coapserver.CoapServerService;

@ExtendWith(MockitoExtension.class)
class CoapTransportServiceDiffblueTest {
  @Mock private CoapServerService coapServerService;

  @InjectMocks private CoapTransportService coapTransportService;

  /**
   * Test {@link CoapTransportService#init()}.
   *
   * <ul>
   *   <li>Then throw {@link UnknownHostException}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw UnknownHostException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapTransportService.init()"})
  void testInit_thenThrowUnknownHostException() throws UnknownHostException {
    // Arrange
    when(coapServerService.getCoapServer()).thenThrow(new UnknownHostException());

    // Act and Assert
    assertThrows(UnknownHostException.class, () -> coapTransportService.init());
    verify(coapServerService).getCoapServer();
  }

  /**
   * Test {@link CoapTransportService#getName()}.
   *
   * <p>Method under test: {@link CoapTransportService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CoapTransportService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("COAP", new CoapTransportService().getName());
  }
}
