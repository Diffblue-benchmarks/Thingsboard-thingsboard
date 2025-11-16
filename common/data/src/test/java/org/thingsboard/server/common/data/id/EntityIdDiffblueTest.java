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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityIdDiffblueTest {
  /**
   * Test {@link EntityId#isNullUid()}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); given AlarmId(UUID) with id is randomUUID; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityId.isNullUid()"})
  void testIsNullUid_givenAlarmIdWithIdIsRandomUUID_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmId(UUID.randomUUID()).isNullUid());
  }

  /**
   * Test {@link EntityId#isNullUid()}.
   *
   * <ul>
   *   <li>Given {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); given SYS_TENANT_ID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityId.isNullUid()"})
  void testIsNullUid_givenSys_tenant_id_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TenantId.SYS_TENANT_ID.isNullUid());
  }
}
