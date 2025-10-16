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
package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbGpsGeofencingFilterNodeDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingFilterNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGpsGeofencingFilterNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingFilterNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbGpsGeofencingFilterNode tbGpsGeofencingFilterNode = new TbGpsGeofencingFilterNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingFilterNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGpsGeofencingFilterNode}
   *   <li>{@link TbGpsGeofencingFilterNode#getConfigClazz()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGpsGeofencingFilterNode.<init>()",
    "Class TbGpsGeofencingFilterNode.getConfigClazz()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Class<TbGpsGeofencingFilterNodeConfiguration> actualConfigClazz =
        new TbGpsGeofencingFilterNode().getConfigClazz();

    // Assert
    Class<TbGpsGeofencingFilterNodeConfiguration> expectedConfigClazz =
        TbGpsGeofencingFilterNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
