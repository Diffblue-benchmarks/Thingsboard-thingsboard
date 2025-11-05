package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class TbGetTenantDetailsNodeDiffblueTest {
  /**
   * Test {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetTenantDetailsNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetTenantDetailsNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetTenantDetailsNodeConfiguration TbGetTenantDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetTenantDetailsNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();
    tbGetTenantDetailsNodeConfiguration.setDetailsList(detailsList);

    // Act
    TbGetTenantDetailsNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetTenantDetailsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetTenantDetailsNodeConfiguration)));

    // Assert
    assertSame(tbGetTenantDetailsNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetTenantDetailsNodeConfiguration TbGetTenantDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetTenantDetailsNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(new TbGetTenantDetailsNodeConfiguration()))));
  }

  /**
   * Test {@link TbGetTenantDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getContactBasedFuture(TbContext, TbMsg); then return ApiFutureToListenableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetTenantDetailsNode.getContactBasedFuture(TbContext, TbMsg)"
  })
  void testGetContactBasedFuture_thenReturnApiFutureToListenableFuture() {
    // Arrange
    TbGetTenantDetailsNode tbGetTenantDetailsNode = new TbGetTenantDetailsNode();

    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    SettableFuture<Tenant> delegate = SettableFuture.create();
    ForwardingApiFuture<Tenant> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    ApiFutureToListenableFuture<Tenant> apiFutureToListenableFuture =
        new ApiFutureToListenableFuture<>(apiFuture);
    when(tenantServiceImpl.findTenantByIdAsync(Mockito.<TenantId>any(), Mockito.<TenantId>any()))
        .thenReturn(apiFutureToListenableFuture);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getTenantService()).thenReturn(tenantServiceImpl);
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<Tenant> actualContactBasedFuture =
        tbGetTenantDetailsNode.getContactBasedFuture(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getTenantId();
    verify(ctx).getTenantService();
    verify(tenantServiceImpl).findTenantByIdAsync(isA(TenantId.class), isA(TenantId.class));
    assertTrue(actualContactBasedFuture instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualContactBasedFuture);
  }

  /**
   * Test {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTenantDetailsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetTenantDetailsNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetTenantDetailsNode}
   *   <li>{@link TbGetTenantDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGetTenantDetailsNode.<init>()",
    "java.lang.String TbGetTenantDetailsNode.getPrefix()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("tenant_", new TbGetTenantDetailsNode().getPrefix());
  }
}
