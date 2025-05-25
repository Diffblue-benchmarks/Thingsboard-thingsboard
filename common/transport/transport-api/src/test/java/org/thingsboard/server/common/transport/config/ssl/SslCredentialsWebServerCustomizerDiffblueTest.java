package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SslCredentialsWebServerCustomizerDiffblueTest {
  @InjectMocks
  private SslCredentialsWebServerCustomizer sslCredentialsWebServerCustomizer;

  /**
   * Test {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}.
   * <p>
   * Method under test: {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  @DisplayName("Test httpServerSslCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslCredentialsConfig SslCredentialsWebServerCustomizer.httpServerSslCredentials()"})
  void testHttpServerSslCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualHttpServerSslCredentialsResult = sslCredentialsWebServerCustomizer
        .httpServerSslCredentials();

    // Assert
    assertEquals("HTTP Server SSL Credentials", actualHttpServerSslCredentialsResult.getName());
    assertNull(actualHttpServerSslCredentialsResult.getKeystore());
    assertNull(actualHttpServerSslCredentialsResult.getPem());
    assertNull(actualHttpServerSslCredentialsResult.getCredentials());
    assertNull(actualHttpServerSslCredentialsResult.getType());
    assertFalse(actualHttpServerSslCredentialsResult.isTrustsOnly());
    assertTrue(actualHttpServerSslCredentialsResult.isEnabled());
  }
}
