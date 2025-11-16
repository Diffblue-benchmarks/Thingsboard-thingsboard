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
package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

class TbOriginatorTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@code Alarm}.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test getRelationType(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then return 'Alarm'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TbOriginatorTypeSwitchNode.getRelationType(TbContext, EntityId)"
  })
  void testGetRelationType_whenAlarmIdWithIdIsRandomUUID_thenReturnAlarm() {
    // Arrange
    TbOriginatorTypeSwitchNode tbOriginatorTypeSwitchNode = new TbOriginatorTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertEquals(
        "Alarm", tbOriginatorTypeSwitchNode.getRelationType(ctx, new AlarmId(UUID.randomUUID())));
  }
}
