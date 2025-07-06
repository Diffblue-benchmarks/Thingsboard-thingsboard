package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.EventLoopGroup;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasRuleEngineProfile;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
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
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.executors.ExternalCallExecutorService;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.executors.PubSubRuleNodeExecutorProvider;
import org.thingsboard.server.service.executors.SharedEventLoopGroupService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.sms.SmsExecutorService;
import org.thingsboard.server.service.stats.DefaultJsInvokeStats;

@ContextConfiguration(
    classes = {
      DefaultTbContext.class,
      String.class,
      RuleNodeCtx.class,
      TenantId.class,
      RuleNode.class
    })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultTbContextDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private DefaultTbContext defaultTbContext;

  @MockBean private TbActorRef tbActorRef;

  @MockBean private UUID uUID;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultTbContext#DefaultTbContext(ActorSystemContext, String, RuleNodeCtx)}
   *   <li>{@link DefaultTbContext#getRuleChainName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultTbContext.<init>(ActorSystemContext, String, RuleNodeCtx)",
    "String DefaultTbContext.getRuleChainName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);
    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertEquals(
        "Rule Chain Name",
        new DefaultTbContext(
                mainCtx,
                "Rule Chain Name",
                new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode()))
            .getRuleChainName());
  }

  /**
   * Test {@link DefaultTbContext#updateSelf(RuleNode)}.
   *
   * <p>Method under test: {@link DefaultTbContext#updateSelf(RuleNode)}
   */
  @Test
  @DisplayName("Test updateSelf(RuleNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.updateSelf(RuleNode)"})
  void testUpdateSelf() {
    // Arrange
    RuleNode self = new RuleNode();

    // Act
    defaultTbContext.updateSelf(self);

    // Assert
    assertSame(self, defaultTbContext.getSelf());
  }

  /**
   * Test {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}
   */
  @Test
  @DisplayName("Test deviceCreatedMsg(Device, RuleNodeId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.deviceCreatedMsg(Device, RuleNodeId)"
  })
  void testDeviceCreatedMsg_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    Device device = new Device(new Device());
    device.setDeviceProfileId(
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.deviceCreatedMsg(
                device, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}
   */
  @Test
  @DisplayName("Test assetCreatedMsg(Asset, RuleNodeId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.assetCreatedMsg(Asset, RuleNodeId)"
  })
  void testAssetCreatedMsg_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    Asset asset = new Asset(new Asset());
    asset.setAssetProfileId(
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.assetCreatedMsg(
                asset, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#alarmActionMsg(Alarm, RuleNodeId, TbMsgType)} with {@code alarm},
   * {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#alarmActionMsg(Alarm, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test alarmActionMsg(Alarm, RuleNodeId, TbMsgType) with 'alarm', 'ruleNodeId', 'actionMsgType'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.alarmActionMsg(Alarm, RuleNodeId, TbMsgType)"
  })
  void testAlarmActionMsgWithAlarmRuleNodeIdActionMsgType_thenThrowRuntimeException() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(new AlarmId(null));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.alarmActionMsg(
                alarm,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST)
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null,
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile())
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile()));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null, alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile5() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(
                1, alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_thenThrowRuntimeException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.<Object, EntityId>entityActionMsg(
                1,
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg("Entity", alarmId, ruleNodeId, "Action", new DeviceProfile())
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Action",
                null));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenThrowRuntimeException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>When {@code -597393278}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; when '-597393278'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_when597393278() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(
                -597393278, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(
                1, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#getSelfId()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSelfId()}
   */
  @Test
  @DisplayName("Test getSelfId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeId DefaultTbContext.getSelfId()"})
  void testGetSelfId() {
    // Arrange, Act and Assert
    assertNull(defaultTbContext.getSelfId());
  }

  /**
   * Test {@link DefaultTbContext#getSelf()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSelf()}
   */
  @Test
  @DisplayName("Test getSelf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNode DefaultTbContext.getSelf()"})
  void testGetSelf() {
    // Arrange and Act
    RuleNode actualSelf = defaultTbContext.getSelf();

    // Assert
    assertNull(actualSelf.getConfigurationBytes());
    assertNull(actualSelf.getAdditionalInfo());
    assertNull(actualSelf.getConfiguration());
    assertNull(actualSelf.getName());
    assertNull(actualSelf.getQueueName());
    assertNull(actualSelf.getType());
    assertNull(actualSelf.getUuidId());
    assertNull(actualSelf.getRuleChainId());
    assertNull(actualSelf.getExternalId());
    assertNull(actualSelf.getId());
    assertEquals(0, actualSelf.getConfigurationVersion());
    assertEquals(0L, actualSelf.getCreatedTime());
    assertFalse(actualSelf.isDebugMode());
    assertFalse(actualSelf.isSingletonMode());
  }

  /**
   * Test {@link DefaultTbContext#getQueueName()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueName()}
   */
  @Test
  @DisplayName("Test getQueueName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultTbContext.getQueueName()"})
  void testGetQueueName() {
    // Arrange, Act and Assert
    assertNull(defaultTbContext.getQueueName());
  }

  /**
   * Test {@link DefaultTbContext#getTenantId()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId DefaultTbContext.getTenantId()"})
  void testGetTenantId() {
    // Arrange and Act
    TenantId actualTenantId = defaultTbContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link MailExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then return MailExecutorService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
  void testGetMailExecutor_thenReturnMailExecutorService() {
    // Arrange
    MailExecutorService mailExecutorService = new MailExecutorService();
    when(actorSystemContext.getMailExecutor()).thenReturn(mailExecutorService);

    // Act
    ListeningExecutor actualMailExecutor = defaultTbContext.getMailExecutor();

    // Assert
    verify(actorSystemContext).getMailExecutor();
    assertTrue(actualMailExecutor instanceof MailExecutorService);
    assertNull(((MailExecutorService) actualMailExecutor).executor());
    assertSame(mailExecutorService, actualMailExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
  void testGetMailExecutor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null).getMailExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
  void testGetMailExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMailExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailExecutor());
    verify(actorSystemContext).getMailExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
  void testGetSmsExecutor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null).getSmsExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link SmsExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then return SmsExecutorService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
  void testGetSmsExecutor_thenReturnSmsExecutorService() {
    // Arrange
    SmsExecutorService smsExecutorService = new SmsExecutorService();
    when(actorSystemContext.getSmsExecutor()).thenReturn(smsExecutorService);

    // Act
    ListeningExecutor actualSmsExecutor = defaultTbContext.getSmsExecutor();

    // Assert
    verify(actorSystemContext).getSmsExecutor();
    assertTrue(actualSmsExecutor instanceof SmsExecutorService);
    assertNull(((SmsExecutorService) actualSmsExecutor).executor());
    assertSame(smsExecutorService, actualSmsExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
  void testGetSmsExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSmsExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsExecutor());
    verify(actorSystemContext).getSmsExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link DbCallbackExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then return DbCallbackExecutorService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor_thenReturnDbCallbackExecutorService() {
    // Arrange
    DbCallbackExecutorService dbCallbackExecutorService = new DbCallbackExecutorService();
    when(actorSystemContext.getDbCallbackExecutor()).thenReturn(dbCallbackExecutorService);

    // Act
    ListeningExecutor actualDbCallbackExecutor = defaultTbContext.getDbCallbackExecutor();

    // Assert
    verify(actorSystemContext).getDbCallbackExecutor();
    assertTrue(actualDbCallbackExecutor instanceof DbCallbackExecutorService);
    assertNull(((DbCallbackExecutorService) actualDbCallbackExecutor).executor());
    assertSame(dbCallbackExecutorService, actualDbCallbackExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getDbCallbackExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDbCallbackExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDbCallbackExecutor());
    verify(actorSystemContext).getDbCallbackExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link ExternalCallExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then return ExternalCallExecutorService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenReturnExternalCallExecutorService() {
    // Arrange
    ExternalCallExecutorService externalCallExecutorService = new ExternalCallExecutorService();
    when(actorSystemContext.getExternalCallExecutorService())
        .thenReturn(externalCallExecutorService);

    // Act
    ListeningExecutor actualExternalCallExecutor = defaultTbContext.getExternalCallExecutor();

    // Assert
    verify(actorSystemContext).getExternalCallExecutorService();
    assertTrue(actualExternalCallExecutor instanceof ExternalCallExecutorService);
    assertNull(((ExternalCallExecutorService) actualExternalCallExecutor).executor());
    assertSame(externalCallExecutorService, actualExternalCallExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getExternalCallExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getExternalCallExecutorService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getExternalCallExecutor());
    verify(actorSystemContext).getExternalCallExecutorService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then return NotificationExecutorService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
  void testGetNotificationExecutor_thenReturnNotificationExecutorService() {
    // Arrange
    NotificationExecutorService notificationExecutorService = new NotificationExecutorService();
    when(actorSystemContext.getNotificationExecutor()).thenReturn(notificationExecutorService);

    // Act
    ListeningExecutor actualNotificationExecutor = defaultTbContext.getNotificationExecutor();

    // Assert
    verify(actorSystemContext).getNotificationExecutor();
    assertTrue(actualNotificationExecutor instanceof NotificationExecutorService);
    assertNull(((NotificationExecutorService) actualNotificationExecutor).executor());
    assertSame(notificationExecutorService, actualNotificationExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
  void testGetNotificationExecutor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getNotificationExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
  void testGetNotificationExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationExecutor())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationExecutor());
    verify(actorSystemContext).getNotificationExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then return Executor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then return Executor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenReturnExecutorIsNull() {
    // Arrange
    PubSubRuleNodeExecutorProvider pubSubRuleNodeExecutorProvider =
        new PubSubRuleNodeExecutorProvider();
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider())
        .thenReturn(pubSubRuleNodeExecutorProvider);

    // Act
    PubSubRuleNodeExecutorProvider actualPubSubRuleNodeExecutorProvider =
        defaultTbContext.getPubSubRuleNodeExecutorProvider();

    // Assert
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
    assertNull(actualPubSubRuleNodeExecutorProvider.getExecutor());
    assertSame(pubSubRuleNodeExecutorProvider, actualPubSubRuleNodeExecutorProvider);
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getPubSubRuleNodeExecutorProvider());
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getPubSubRuleNodeExecutorProvider());
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
  }

  /**
   * Test {@link DefaultTbContext#createJsScriptEngine(String, String[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createJsScriptEngine(String, String[])}
   */
  @Test
  @DisplayName("Test createJsScriptEngine(String, String[]); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createJsScriptEngine(String, String[])"
  })
  void testCreateJsScriptEngine_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getJsInvokeService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.createJsScriptEngine("Script", "Arg Names"));
    verify(actorSystemContext).getJsInvokeService();
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); given ActorSystemContext; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_givenActorSystemContext_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultTbContext.createScriptEngine(null, null, null));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getJsInvokeService()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); then calls getJsInvokeService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_thenCallsGetJsInvokeService() {
    // Arrange
    when(actorSystemContext.getJsInvokeService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, "Script", "Arg Names"));
    verify(actorSystemContext).getJsInvokeService();
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getTbelInvokeService()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); then calls getTbelInvokeService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_thenCallsGetTbelInvokeService() {
    // Arrange
    when(actorSystemContext.getTbelInvokeService()).thenThrow(new IllegalArgumentException("msg"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.TBEL, "Script", null));
    verify(actorSystemContext).getTbelInvokeService();
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); when empty string; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.createScriptEngine(null, "", null));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); when space; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultTbContext.createScriptEngine(null, " ", null));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); when space; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_whenSpace_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, " ", null));
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalRequest());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalRequest());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isStatisticsEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName(
      "Test logJsEvalRequest(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementRequests()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); then calls incrementRequests()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest_thenCallsIncrementRequests() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementRequests();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementRequests();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalResponse());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalResponse());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isStatisticsEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName(
      "Test logJsEvalResponse(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementResponses()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); then calls incrementResponses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse_thenCallsIncrementResponses() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementResponses();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementResponses();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalFailure());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalFailure());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isStatisticsEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName(
      "Test logJsEvalFailure(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalFailure();

    // Assert
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementFailures()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure(); then calls incrementFailures()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure_thenCallsIncrementFailures() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementFailures();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalFailure();

    // Assert
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementFailures();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then return {@code Device State Node Rate Limit Config}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName(
      "Test getDeviceStateNodeRateLimitConfig(); then return 'Device State Node Rate Limit Config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenReturnDeviceStateNodeRateLimitConfig() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig())
        .thenReturn("Device State Node Rate Limit Config");

    // Act
    String actualDeviceStateNodeRateLimitConfig =
        defaultTbContext.getDeviceStateNodeRateLimitConfig();

    // Assert
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
    assertEquals("Device State Node Rate Limit Config", actualDeviceStateNodeRateLimitConfig);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getDeviceStateNodeRateLimitConfig());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getDeviceStateNodeRateLimitConfig());
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseAlarmCommentService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then return BaseAlarmCommentService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
  void testGetAlarmCommentService_thenReturnBaseAlarmCommentService() {
    // Arrange
    BaseAlarmCommentService baseAlarmCommentService = new BaseAlarmCommentService();
    when(actorSystemContext.getAlarmCommentService()).thenReturn(baseAlarmCommentService);

    // Act
    AlarmCommentService actualAlarmCommentService = defaultTbContext.getAlarmCommentService();

    // Assert
    verify(actorSystemContext).getAlarmCommentService();
    assertTrue(actualAlarmCommentService instanceof BaseAlarmCommentService);
    assertSame(baseAlarmCommentService, actualAlarmCommentService);
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
  void testGetAlarmCommentService_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .getAlarmCommentService());
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
  void testGetAlarmCommentService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAlarmCommentService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAlarmCommentService());
    verify(actorSystemContext).getAlarmCommentService();
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventLoopGroup DefaultTbContext.getSharedEventLoop()"})
  void testGetSharedEventLoop_thenReturnNull() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService())
        .thenReturn(new SharedEventLoopGroupService());

    // Act
    EventLoopGroup actualSharedEventLoop = defaultTbContext.getSharedEventLoop();

    // Assert
    verify(actorSystemContext).getSharedEventLoopGroupService();
    assertNull(actualSharedEventLoop);
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventLoopGroup DefaultTbContext.getSharedEventLoop()"})
  void testGetSharedEventLoop_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSharedEventLoop());
    verify(actorSystemContext).getSharedEventLoopGroupService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.MailService DefaultTbContext.getMailService(boolean)"
  })
  void testGetMailService() {
    // Arrange
    when(actorSystemContext.isAllowSystemMailService())
        .thenThrow(new IllegalArgumentException("Access to System Mail Service is forbidden!"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.rule.engine.api.SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService() {
    // Arrange
    when(actorSystemContext.isAllowSystemSmsService())
        .thenThrow(new IllegalArgumentException("Access to System SMS Service is forbidden!"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsService());
    verify(actorSystemContext).isAllowSystemSmsService();
  }

  /**
   * Test {@link DefaultTbContext#getSlackService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.notification.SlackService DefaultTbContext.getSlackService()"
  })
  void testGetSlackService_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null).getSlackService());
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenReturn(false);

    // Act
    boolean actualIsExternalNodeForceAckResult = defaultTbContext.isExternalNodeForceAck();

    // Assert
    verify(actorSystemContext).isExternalNodeForceAck();
    assertFalse(actualIsExternalNodeForceAckResult);
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck2() {
    // Arrange, Act and Assert
    assertFalse(
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null)
            .isExternalNodeForceAck());
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck_thenReturnTrue() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenReturn(true);

    // Act
    boolean actualIsExternalNodeForceAckResult = defaultTbContext.isExternalNodeForceAck();

    // Assert
    verify(actorSystemContext).isExternalNodeForceAck();
    assertTrue(actualIsExternalNodeForceAckResult);
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isExternalNodeForceAck());
    verify(actorSystemContext).isExternalNodeForceAck();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStates(PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStates(PageLink)}
   */
  @Test
  @DisplayName("Test findRuleNodeStates(PageLink); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DefaultTbContext.findRuleNodeStates(PageLink)"
  })
  void testFindRuleNodeStates_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStates(new PageLink(3)));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test findRuleNodeStateForEntity(EntityId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.findRuleNodeStateForEntity(EntityId)"})
  void testFindRuleNodeStateForEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName("Test saveRuleNodeState(RuleNodeState); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.saveRuleNodeState(new RuleNodeState()));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName("Test clearRuleNodeStates(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.clearRuleNodeStates()"})
  void testClearRuleNodeStates_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.clearRuleNodeStates());
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.removeRuleNodeStateForEntity(EntityId)"})
  void testRemoveRuleNodeStateForEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService())
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.removeRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.addTenantProfileListener(Consumer)"})
  void testAddTenantProfileListener_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.addTenantProfileListener(mock(Consumer.class)));
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link TbDeviceProfileCache#addListener(TenantId, EntityId, Consumer,
   *       BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test addDeviceProfileListeners(Consumer, BiConsumer); then calls addListener(TenantId, EntityId, Consumer, BiConsumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.addDeviceProfileListeners(Consumer, BiConsumer)"})
  void testAddDeviceProfileListeners_thenCallsAddListener() {
    // Arrange
    TbDeviceProfileCache tbDeviceProfileCache = mock(TbDeviceProfileCache.class);
    doNothing()
        .when(tbDeviceProfileCache)
        .addListener(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<Consumer<DeviceProfile>>any(),
            Mockito.<BiConsumer<DeviceId, DeviceProfile>>any());
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(tbDeviceProfileCache);

    // Act
    defaultTbContext.addDeviceProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(tbDeviceProfileCache)
        .addListener(isA(TenantId.class), isNull(), isA(Consumer.class), isA(BiConsumer.class));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test addDeviceProfileListeners(Consumer, BiConsumer); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.addDeviceProfileListeners(Consumer, BiConsumer)"})
  void testAddDeviceProfileListeners_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addDeviceProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link TbAssetProfileCache#addListener(TenantId, EntityId, Consumer,
   *       BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test addAssetProfileListeners(Consumer, BiConsumer); then calls addListener(TenantId, EntityId, Consumer, BiConsumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.addAssetProfileListeners(Consumer, BiConsumer)"})
  void testAddAssetProfileListeners_thenCallsAddListener() {
    // Arrange
    TbAssetProfileCache tbAssetProfileCache = mock(TbAssetProfileCache.class);
    doNothing()
        .when(tbAssetProfileCache)
        .addListener(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<Consumer<AssetProfile>>any(),
            Mockito.<BiConsumer<AssetId, AssetProfile>>any());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(tbAssetProfileCache);

    // Act
    defaultTbContext.addAssetProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(tbAssetProfileCache)
        .addListener(isA(TenantId.class), isNull(), isA(Consumer.class), isA(BiConsumer.class));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test addAssetProfileListeners(Consumer, BiConsumer); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.addAssetProfileListeners(Consumer, BiConsumer)"})
  void testAddAssetProfileListeners_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addAssetProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners2() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException("foo"));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    when(actorSystemContext.getDeviceProfileCache())
        .thenReturn(
            new DefaultTbDeviceProfileCache(
                deviceProfileService,
                new DeviceServiceImpl(
                    deviceDao,
                    deviceCredentialsService,
                    deviceProfileService2,
                    eventService,
                    tenantService,
                    deviceValidator,
                    countService,
                    new JpaExecutorService())));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners3() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    when(actorSystemContext.getAssetProfileCache())
        .thenReturn(new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    when(actorSystemContext.getDeviceProfileCache())
        .thenReturn(
            new DefaultTbDeviceProfileCache(
                deviceProfileService,
                new DeviceServiceImpl(
                    deviceDao,
                    deviceCredentialsService,
                    deviceProfileService2,
                    eventService,
                    tenantService,
                    deviceValidator,
                    countService,
                    new JpaExecutorService())));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getTenantProfileCache()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners(); then calls getTenantProfileCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners_thenCallsGetTenantProfileCache() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    when(actorSystemContext.getTenantProfileCache())
        .thenReturn(new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    when(actorSystemContext.getAssetProfileCache())
        .thenReturn(new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    when(actorSystemContext.getDeviceProfileCache())
        .thenReturn(
            new DefaultTbDeviceProfileCache(
                deviceProfileService,
                new DeviceServiceImpl(
                    deviceDao,
                    deviceCredentialsService,
                    deviceProfileService2,
                    eventService,
                    tenantService,
                    deviceValidator,
                    countService,
                    new JpaExecutorService())));

    // Act
    defaultTbContext.removeListeners();

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName("Test getTenantProfile(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile DefaultTbContext.getTenantProfile()"
  })
  void testGetTenantProfile_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantProfile());
    verify(actorSystemContext).getTenantProfileCache();
  }
}
