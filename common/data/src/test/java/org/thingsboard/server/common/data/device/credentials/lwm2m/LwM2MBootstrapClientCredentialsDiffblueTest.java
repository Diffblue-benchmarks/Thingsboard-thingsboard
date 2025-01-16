package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapClientCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link LwM2MBootstrapClientCredentials}
   *   <li>
   * {@link LwM2MBootstrapClientCredentials#setBootstrapServer(LwM2MBootstrapClientCredential)}
   *   <li>
   * {@link LwM2MBootstrapClientCredentials#setLwm2mServer(LwM2MBootstrapClientCredential)}
   *   <li>{@link LwM2MBootstrapClientCredentials#getBootstrapServer()}
   *   <li>{@link LwM2MBootstrapClientCredentials#getLwm2mServer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapClientCredentials actualLwM2MBootstrapClientCredentials = new LwM2MBootstrapClientCredentials();
    LwM2MBootstrapClientCredential bootstrapServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapClientCredentials.setBootstrapServer(bootstrapServer);
    LwM2MBootstrapClientCredential lwm2mServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapClientCredentials.setLwm2mServer(lwm2mServer);
    LwM2MBootstrapClientCredential actualBootstrapServer = actualLwM2MBootstrapClientCredentials.getBootstrapServer();

    // Assert that nothing has changed
    assertSame(bootstrapServer, actualBootstrapServer);
    assertSame(lwm2mServer, actualLwM2MBootstrapClientCredentials.getLwm2mServer());
  }
}
