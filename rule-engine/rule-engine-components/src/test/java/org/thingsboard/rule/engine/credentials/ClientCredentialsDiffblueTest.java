package org.thingsboard.rule.engine.credentials;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.ssl.JdkSslClientContext;
import javax.net.ssl.SSLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientCredentialsDiffblueTest {
  /**
   * Test {@link ClientCredentials#initSslContext()}.
   * <ul>
   *   <li>Then calls {@link ClientCredentials#initSslContext()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClientCredentials#initSslContext()}
   */
  @Test
  @DisplayName("Test initSslContext(); then calls initSslContext()")
  void testInitSslContext_thenCallsInitSslContext() throws SSLException {
    // Arrange
    ClientCredentials clientCredentials = mock(ClientCredentials.class);
    when(clientCredentials.initSslContext()).thenReturn(new JdkSslClientContext());

    // Act
    clientCredentials.initSslContext();

    // Assert
    verify(clientCredentials).initSslContext();
  }
}
