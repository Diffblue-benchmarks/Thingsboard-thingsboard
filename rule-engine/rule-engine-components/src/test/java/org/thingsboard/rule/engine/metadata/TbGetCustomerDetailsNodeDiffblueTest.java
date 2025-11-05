package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class TbGetCustomerDetailsNodeDiffblueTest {
  /**
   * Test {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetCustomerDetailsNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetCustomerDetailsNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetCustomerDetailsNodeConfiguration TbGetCustomerDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetCustomerDetailsNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);

    // Act
    TbGetCustomerDetailsNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetCustomerDetailsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetCustomerDetailsNodeConfiguration)));

    // Assert
    assertSame(tbGetCustomerDetailsNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetCustomerDetailsNodeConfiguration TbGetCustomerDetailsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetCustomerDetailsNode.loadNodeConfiguration(
                new TbNodeConfiguration(
                    new POJONode(new TbGetCustomerDetailsNodeConfiguration()))));
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbGetCustomerDetailsNode.getContactBasedFuture(TbContext, TbMsg)"
  })
  void testGetContactBasedFuture() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenThrow(new NoSuchElementException());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg));
    verify(ctx).getDeviceService();
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbGetCustomerDetailsNode.getContactBasedFuture(TbContext, TbMsg)"
  })
  void testGetContactBasedFuture_thenCallsGetTenantId() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    TbContext ctx = mock(TbContext.class);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    when(ctx.getTenantId()).thenThrow(new NoSuchElementException());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg));
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbGetCustomerDetailsNode.getContactBasedFuture(TbContext, TbMsg)"
  })
  void testGetContactBasedFuture_thenReturnDone() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg).isDone());
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetCustomerDetailsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetCustomerDetailsNode().upgrade(1, oldConfiguration);

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
   *   <li>default or parameterless constructor of {@link TbGetCustomerDetailsNode}
   *   <li>{@link TbGetCustomerDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGetCustomerDetailsNode.<init>()",
    "java.lang.String TbGetCustomerDetailsNode.getPrefix()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("customer_", new TbGetCustomerDetailsNode().getPrefix());
  }
}
