package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class EntitiesCustomerIdAsyncLoaderDiffblueTest {
  /**
   * Test
   * {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return {@link Future#get()} is {@link CustomerId#CustomerId(UUID)}
   * with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, EntityId); then return get() is CustomerId(UUID) with id is randomUUID")
  void testFindEntityIdAsync_thenReturnGetIsCustomerIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult = EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx,
        originator);

    // Assert
    assertSame(originator, actualFindEntityIdAsyncResult.get());
  }

  /**
   * Test
   * {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then return Done")
  void testFindEntityIdAsync_whenAlarmIdWithIdIsRandomUUID_thenReturnDone() {
    // Arrange
    TbContext ctx = mock(TbContext.class);

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult = EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx,
        new AlarmId(UUID.randomUUID()));

    // Assert
    assertTrue(actualFindEntityIdAsyncResult.isDone());
  }
}
