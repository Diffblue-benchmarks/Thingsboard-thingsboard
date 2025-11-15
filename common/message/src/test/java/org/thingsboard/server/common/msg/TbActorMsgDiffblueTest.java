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
package org.thingsboard.server.common.msg;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbActorMsgDiffblueTest {
  /**
   * Method under test: {@link TbActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  void testOnTbActorStopped() {
    // Arrange
    TbActorMsg tbActorMsg = mock(TbActorMsg.class);
    doNothing().when(tbActorMsg).onTbActorStopped(Mockito.<TbActorStopReason>any());

    // Act
    tbActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert that nothing has changed
    verify(tbActorMsg).onTbActorStopped(eq(TbActorStopReason.INIT_FAILED));
  }
}
