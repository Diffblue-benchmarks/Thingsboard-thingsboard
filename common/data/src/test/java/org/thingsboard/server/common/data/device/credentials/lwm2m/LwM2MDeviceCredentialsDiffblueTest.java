/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class LwM2MDeviceCredentialsDiffblueTest {
  /**
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
