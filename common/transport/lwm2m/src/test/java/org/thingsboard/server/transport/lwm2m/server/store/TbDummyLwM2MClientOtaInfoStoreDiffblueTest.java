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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDummyLwM2MClientOtaInfoStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MClientOtaInfoStore#getFw(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientOtaInfoStore#getFw(String)}
   */
  @Test
  @DisplayName("Test getFw(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo TbDummyLwM2MClientOtaInfoStore.getFw(String)"})
  void testGetFw() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientOtaInfoStore()).getFw("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbDummyLwM2MClientOtaInfoStore#getSw(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientOtaInfoStore#getSw(String)}
   */
  @Test
  @DisplayName("Test getSw(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo TbDummyLwM2MClientOtaInfoStore.getSw(String)"})
  void testGetSw() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientOtaInfoStore()).getSw("https://config.us-east-2.amazonaws.com"));
  }
}
