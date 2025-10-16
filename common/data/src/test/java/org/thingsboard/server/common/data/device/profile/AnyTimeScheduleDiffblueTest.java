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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;

class AnyTimeScheduleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AnyTimeSchedule}
   *   <li>{@link AnyTimeSchedule#getDynamicValue()}
   *   <li>{@link AnyTimeSchedule#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AnyTimeSchedule.<init>()",
    "DynamicValue AnyTimeSchedule.getDynamicValue()",
    "AlarmScheduleType AnyTimeSchedule.getType()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AnyTimeSchedule actualAnyTimeSchedule = new AnyTimeSchedule();
    DynamicValue<String> actualDynamicValue = actualAnyTimeSchedule.getDynamicValue();

    // Assert
    assertNull(actualDynamicValue);
    assertEquals(AlarmScheduleType.ANY_TIME, actualAnyTimeSchedule.getType());
  }
}
