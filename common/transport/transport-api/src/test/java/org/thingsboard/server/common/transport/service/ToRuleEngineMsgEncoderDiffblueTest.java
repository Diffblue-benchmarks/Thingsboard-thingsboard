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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;

class ToRuleEngineMsgEncoderDiffblueTest {
  /**
   * Test {@link ToRuleEngineMsgEncoder#encode(ToRuleEngineMsg)} with {@code ToRuleEngineMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ToRuleEngineMsgEncoder#encode(TransportProtos.ToRuleEngineMsg)}
   */
  @Test
  @DisplayName(
      "Test encode(ToRuleEngineMsg) with 'ToRuleEngineMsg'; when DefaultInstance; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ToRuleEngineMsgEncoder.encode(TransportProtos.ToRuleEngineMsg)"})
  void testEncodeWithToRuleEngineMsg_whenDefaultInstance_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {}, new ToRuleEngineMsgEncoder().encode(ToRuleEngineMsg.getDefaultInstance()));
  }
}
