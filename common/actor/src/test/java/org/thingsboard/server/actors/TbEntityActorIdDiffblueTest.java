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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;

class TbEntityActorIdDiffblueTest {
  /**
   * Test {@link TbEntityActorId#equals(Object)}, and {@link TbEntityActorId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEntityActorId#equals(Object)}
   *   <li>{@link TbEntityActorId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbEntityActorId tbEntityActorId = new TbEntityActorId(new AlarmId(null));
    TbEntityActorId tbEntityActorId2 = new TbEntityActorId(mock(AlarmId.class));

    // Act and Assert
    assertEquals(tbEntityActorId, tbEntityActorId2);
    assertNotEquals(tbEntityActorId.hashCode(), tbEntityActorId2.hashCode());
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), null);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), 1);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbEntityActorId tbEntityActorId = new TbEntityActorId(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(tbEntityActorId, new TbEntityActorId(null));
  }

  /**
   * Test {@link TbEntityActorId#getEntityType()}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#getEntityType()}
   */
  @Test
  @DisplayName(
      "Test getEntityType(); given AlarmId(UUID) with id is randomUUID; then return 'ALARM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType TbEntityActorId.getEntityType()"})
  void testGetEntityType_givenAlarmIdWithIdIsRandomUUID_thenReturnAlarm() {
    // Arrange, Act and Assert
    assertEquals(
        EntityType.ALARM, new TbEntityActorId(new AlarmId(UUID.randomUUID())).getEntityType());
  }
}
