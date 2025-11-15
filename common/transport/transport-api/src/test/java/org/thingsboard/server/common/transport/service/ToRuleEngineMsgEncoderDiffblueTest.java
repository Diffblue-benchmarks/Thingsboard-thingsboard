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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ToRuleEngineMsgEncoderDiffblueTest {
  /**
   * Method under test:
   * {@link ToRuleEngineMsgEncoder#encode(TransportProtos.ToRuleEngineMsg)}
   */
  @Test
  void testEncode() {
    // Arrange
    ToRuleEngineMsgEncoder toRuleEngineMsgEncoder = new ToRuleEngineMsgEncoder();

    // Act and Assert
    assertEquals(0, toRuleEngineMsgEncoder.encode(TransportProtos.ToRuleEngineMsg.getDefaultInstance()).length);
  }
}
