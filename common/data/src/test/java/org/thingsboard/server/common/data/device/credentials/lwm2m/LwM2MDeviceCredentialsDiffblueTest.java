package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MDeviceCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MDeviceCredentials}
   *   <li>
   * {@link LwM2MDeviceCredentials#setBootstrap(LwM2MBootstrapClientCredentials)}
   *   <li>{@link LwM2MDeviceCredentials#setClient(LwM2MClientCredential)}
   *   <li>{@link LwM2MDeviceCredentials#getBootstrap()}
   *   <li>{@link LwM2MDeviceCredentials#getClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MDeviceCredentials actualLwM2MDeviceCredentials = new LwM2MDeviceCredentials();
    LwM2MBootstrapClientCredentials bootstrap = new LwM2MBootstrapClientCredentials();
    bootstrap.setBootstrapServer(mock(LwM2MBootstrapClientCredential.class));
    bootstrap.setLwm2mServer(mock(LwM2MBootstrapClientCredential.class));
    actualLwM2MDeviceCredentials.setBootstrap(bootstrap);
    NoSecClientCredential client = new NoSecClientCredential();
    actualLwM2MDeviceCredentials.setClient(client);
    LwM2MBootstrapClientCredentials actualBootstrap = actualLwM2MDeviceCredentials.getBootstrap();

    // Assert that nothing has changed
    assertSame(bootstrap, actualBootstrap);
    assertSame(client, actualLwM2MDeviceCredentials.getClient());
  }
}
