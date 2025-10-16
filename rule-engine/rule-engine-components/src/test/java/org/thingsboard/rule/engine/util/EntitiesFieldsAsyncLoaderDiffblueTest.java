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
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesFieldsAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getCustomerService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getCustomerService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"
  })
  void testFindAsync_thenCallsGetCustomerService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCustomerService()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new CustomerId(UUID.randomUUID())));
    verify(ctx).getCustomerService();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getRuleChainService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getRuleChainService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"
  })
  void testFindAsync_thenCallsGetRuleChainService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainService()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new RuleChainId(UUID.randomUUID())));
    verify(ctx).getRuleChainService();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getTenantService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"
  })
  void testFindAsync_thenCallsGetTenantService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantService()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new TenantId(UUID.randomUUID())));
    verify(ctx).getTenantService();
  }
}
