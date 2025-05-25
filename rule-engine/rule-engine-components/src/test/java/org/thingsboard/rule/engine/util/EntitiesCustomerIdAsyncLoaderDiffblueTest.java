package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
   * <p>
   * Method under test: {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture EntitiesCustomerIdAsyncLoader.findEntityIdAsync(TbContext, EntityId)"})
  void testFindEntityIdAsync() throws InterruptedException, ExecutionException {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult = EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx,
        originator);

    // Assert
    assertSame(originator, actualFindEntityIdAsyncResult.get());
  }

  /**
   * Test {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesCustomerIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, EntityId); then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture EntitiesCustomerIdAsyncLoader.findEntityIdAsync(TbContext, EntityId)"})
  void testFindEntityIdAsync_thenReturnDone() {
    // Arrange
    TbContext ctx = mock(TbContext.class);

    // Act
    ListenableFuture<CustomerId> actualFindEntityIdAsyncResult = EntitiesCustomerIdAsyncLoader.findEntityIdAsync(ctx,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertTrue(actualFindEntityIdAsyncResult.isDone());
  }
}
