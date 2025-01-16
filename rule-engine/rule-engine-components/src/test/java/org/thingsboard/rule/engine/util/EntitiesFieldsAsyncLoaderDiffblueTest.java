package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesFieldsAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getCustomerService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getCustomerService()")
  void testFindAsync_thenCallsGetCustomerService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCustomerService()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new CustomerId(UUID.randomUUID())));
    verify(ctx).getCustomerService();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getRuleChainService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getRuleChainService()")
  void testFindAsync_thenCallsGetRuleChainService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainService()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new RuleChainId(UUID.randomUUID())));
    verify(ctx).getRuleChainService();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getTenantService()")
  void testFindAsync_thenCallsGetTenantService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantService()).thenThrow(new NoSuchElementException("foo"));

    // Act and Assert
    assertThrows(NoSuchElementException.class,
        () -> EntitiesFieldsAsyncLoader.findAsync(ctx, new TenantId(UUID.randomUUID())));
    verify(ctx).getTenantService();
  }
}
