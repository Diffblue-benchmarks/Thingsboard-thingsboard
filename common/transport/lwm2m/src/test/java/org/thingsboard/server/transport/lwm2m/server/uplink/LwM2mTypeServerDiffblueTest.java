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
package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mTypeServerDiffblueTest {
  /**
   * Test {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}.
   *
   * <ul>
   *   <li>When {@code bootstrap}.
   *   <li>Then return {@code BOOTSTRAP}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}
   */
  @Test
  @DisplayName("Test fromLwM2mTypeServer(String); when 'bootstrap'; then return 'BOOTSTRAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mTypeServer LwM2mTypeServer.fromLwM2mTypeServer(String)"})
  void testFromLwM2mTypeServer_whenBootstrap_thenReturnBootstrap() {
    // Arrange, Act and Assert
    assertEquals(LwM2mTypeServer.BOOTSTRAP, LwM2mTypeServer.fromLwM2mTypeServer("bootstrap"));
  }

  /**
   * Test {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}.
   *
   * <ul>
   *   <li>When {@code client}.
   *   <li>Then return {@code CLIENT}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}
   */
  @Test
  @DisplayName("Test fromLwM2mTypeServer(String); when 'client'; then return 'CLIENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mTypeServer LwM2mTypeServer.fromLwM2mTypeServer(String)"})
  void testFromLwM2mTypeServer_whenClient_thenReturnClient() {
    // Arrange, Act and Assert
    assertEquals(LwM2mTypeServer.CLIENT, LwM2mTypeServer.fromLwM2mTypeServer("client"));
  }
}
