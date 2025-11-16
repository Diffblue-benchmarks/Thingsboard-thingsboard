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
package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class EntitiesCustomerIdAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} is {@link CustomerId#CustomerId(UUID)} with id
   *       is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityIdAsync(TbContext, EntityId); then return get() is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntitiesCustomerIdAsyncLoader.findEntityIdAsync(TbContext, EntityId)"
  })
  void testFindEntityIdAsync_thenReturnGetIsCustomerIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult =
        EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx, originator);

    // Assert
    assertSame(originator, actualFindEntityIdAsyncResult.get());
  }

  /**
   * Test {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityIdAsync(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntitiesCustomerIdAsyncLoader.findEntityIdAsync(TbContext, EntityId)"
  })
  void testFindEntityIdAsync_whenAlarmIdWithIdIsRandomUUID_thenReturnDone() {
    // Arrange
    TbContext ctx = mock(TbContext.class);

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult =
        EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx, new AlarmId(UUID.randomUUID()));

    // Assert
    assertTrue(actualFindEntityIdAsyncResult.isDone());
  }
}
