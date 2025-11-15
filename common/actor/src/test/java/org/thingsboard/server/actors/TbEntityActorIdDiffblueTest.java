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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;

class TbEntityActorIdDiffblueTest {
  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), null);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), 1);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbEntityActorId tbEntityActorId = new TbEntityActorId(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(tbEntityActorId, new TbEntityActorId(null));
  }

  /**
   * Test {@link TbEntityActorId#getEntityType()}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType(); given AlarmId(UUID) with id is randomUUID; then return 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType TbEntityActorId.getEntityType()"})
  void testGetEntityType_givenAlarmIdWithIdIsRandomUUID_thenReturnAlarm() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ALARM, (new TbEntityActorId(new AlarmId(UUID.randomUUID()))).getEntityType());
  }
}
