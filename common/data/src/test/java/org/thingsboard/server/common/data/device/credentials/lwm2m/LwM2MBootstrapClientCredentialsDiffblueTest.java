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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapClientCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MBootstrapClientCredentials}
   *   <li>{@link
   *       LwM2MBootstrapClientCredentials#setBootstrapServer(LwM2MBootstrapClientCredential)}
   *   <li>{@link LwM2MBootstrapClientCredentials#setLwm2mServer(LwM2MBootstrapClientCredential)}
   *   <li>{@link LwM2MBootstrapClientCredentials#getBootstrapServer()}
   *   <li>{@link LwM2MBootstrapClientCredentials#getLwm2mServer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapClientCredentials.<init>()",
    "LwM2MBootstrapClientCredential LwM2MBootstrapClientCredentials.getBootstrapServer()",
    "LwM2MBootstrapClientCredential LwM2MBootstrapClientCredentials.getLwm2mServer()",
    "void LwM2MBootstrapClientCredentials.setBootstrapServer(LwM2MBootstrapClientCredential)",
    "void LwM2MBootstrapClientCredentials.setLwm2mServer(LwM2MBootstrapClientCredential)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapClientCredentials actualLwM2MBootstrapClientCredentials =
        new LwM2MBootstrapClientCredentials();
    LwM2MBootstrapClientCredential bootstrapServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapClientCredentials.setBootstrapServer(bootstrapServer);
    LwM2MBootstrapClientCredential lwm2mServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapClientCredentials.setLwm2mServer(lwm2mServer);
    LwM2MBootstrapClientCredential actualBootstrapServer =
        actualLwM2MBootstrapClientCredentials.getBootstrapServer();

    // Assert
    assertSame(bootstrapServer, actualBootstrapServer);
    assertSame(lwm2mServer, actualLwM2MBootstrapClientCredentials.getLwm2mServer());
  }
}
