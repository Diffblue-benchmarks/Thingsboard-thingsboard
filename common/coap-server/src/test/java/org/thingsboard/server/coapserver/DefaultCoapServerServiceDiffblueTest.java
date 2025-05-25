package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultCoapServerServiceDiffblueTest {
  @InjectMocks
  private DefaultCoapServerService defaultCoapServerService;

  /**
   * Test {@link DefaultCoapServerService#getDtlsSessionsMap()}.
   * <p>
   * Method under test: {@link DefaultCoapServerService#getDtlsSessionsMap()}
   */
  @Test
  @DisplayName("Test getDtlsSessionsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.concurrent.ConcurrentMap DefaultCoapServerService.getDtlsSessionsMap()"})
  void testGetDtlsSessionsMap() {
    // Arrange, Act and Assert
    assertNull(defaultCoapServerService.getDtlsSessionsMap());
  }
}
