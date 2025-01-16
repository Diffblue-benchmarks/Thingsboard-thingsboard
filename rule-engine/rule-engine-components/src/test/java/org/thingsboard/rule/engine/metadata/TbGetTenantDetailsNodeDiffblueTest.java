package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class TbGetTenantDetailsNodeDiffblueTest {
  /**
   * Test {@link TbGetTenantDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetTenantDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then return ApiFutureToListenableFuture")
  void testGetContactBasedFuture_thenReturnApiFutureToListenableFuture() {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    SettableFuture<Tenant> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<Tenant> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(tenantServiceImpl.findTenantByIdAsync(Mockito.<TenantId>any(), Mockito.<TenantId>any()))
        .thenReturn(apiFutureToListenableFuture);
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getTenantService()).thenReturn(tenantServiceImpl);

    // Act
    ListenableFuture<Tenant> actualContactBasedFuture = tbGetTenantDetailsNode.getContactBasedFuture(ctx, null);

    // Assert
    verify(ctx, atLeast(1)).getTenantId();
    verify(ctx).getTenantService();
    verify(tenantServiceImpl).findTenantByIdAsync(isA(TenantId.class), isA(TenantId.class));
    assertTrue(actualContactBasedFuture instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualContactBasedFuture);
  }

  /**
   * Test {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetTenantDetailsNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetTenantDetailsNode}
   *   <li>{@link TbGetTenantDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("tenant_", (new TbGetTenantDetailsNode()).getPrefix());
  }
}
