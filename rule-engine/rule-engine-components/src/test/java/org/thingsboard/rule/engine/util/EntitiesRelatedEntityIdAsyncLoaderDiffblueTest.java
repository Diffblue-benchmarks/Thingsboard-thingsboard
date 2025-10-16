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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EntitiesRelatedEntityIdAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext, EntityId,
   * RelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext,
   * EntityId, RelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityAsync(TbContext, EntityId, RelationsQuery); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesRelatedEntityIdAsyncLoader.findEntityAsync(TbContext, EntityId, RelationsQuery)"
  })
  void testFindEntityAsync_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRelationService()).thenThrow(new IllegalStateException());

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesRelatedEntityIdAsyncLoader.findEntityAsync(ctx, null, relationsQuery));
    verify(ctx).getRelationService();
  }
}
