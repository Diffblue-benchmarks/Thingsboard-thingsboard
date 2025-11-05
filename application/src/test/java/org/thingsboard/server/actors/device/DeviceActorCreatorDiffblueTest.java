package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.service.session.DefaultDeviceSessionCacheService;

@ContextConfiguration(classes = {DeviceActorCreator.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DeviceActorCreatorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private DeviceActorCreator deviceActorCreator;

  @MockBean private DeviceId deviceId;

  @MockBean private TenantId tenantId;

  /**
   * Test {@link DeviceActorCreator#createActorId()}.
   *
   * <p>Method under test: {@link DeviceActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test createActorId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActorId DeviceActorCreator.createActorId()"})
  void testCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = deviceActorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link DeviceActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isEdgesEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test createActor(); given ActorSystemContext isEdgesEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor DeviceActorCreator.createActor()"})
  void testCreateActor_givenActorSystemContextIsEdgesEnabledReturnFalse() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());
    when(actorSystemContext.isEdgesEnabled()).thenReturn(false);
    when(actorSystemContext.isLocalCacheType()).thenReturn(true);
    when(actorSystemContext.getRpcSubmitStrategy()).thenReturn("Rpc Submit Strategy");
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());
    when(actorSystemContext.getMaxConcurrentSessionsPerDevice()).thenReturn(1L);
    when(actorSystemContext.getDeviceService()).thenReturn(deviceService);

    // Act
    TbActor actualCreateActorResult = deviceActorCreator.createActor();

    // Assert
    verify(actorSystemContext).getDeviceService();
    verify(actorSystemContext).getMaxConcurrentSessionsPerDevice();
    verify(actorSystemContext).getRpcSubmitStrategy();
    verify(actorSystemContext).getScheduler();
    verify(actorSystemContext).isEdgesEnabled();
    verify(actorSystemContext).isLocalCacheType();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertTrue(actualCreateActorResult instanceof DeviceActor);
    assertNull(((DeviceActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test {@link DeviceActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation#EntityRelation()}.
   *   <li>Then calls {@link ActorSystemContext#getRelationService()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActorCreator#createActor()}
   */
  @Test
  @DisplayName(
      "Test createActor(); given ArrayList() add EntityRelation(); then calls getRelationService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor DeviceActorCreator.createActor()"})
  void testCreateActor_givenArrayListAddEntityRelation_thenCallsGetRelationService() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    when(baseRelationService.findByToAndType(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(actorSystemContext.getRelationService()).thenReturn(baseRelationService);
    when(actorSystemContext.isEdgesEnabled()).thenReturn(true);
    when(actorSystemContext.isLocalCacheType()).thenReturn(true);
    when(actorSystemContext.getRpcSubmitStrategy()).thenReturn("Rpc Submit Strategy");
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());
    when(actorSystemContext.getMaxConcurrentSessionsPerDevice()).thenReturn(1L);
    when(actorSystemContext.getDeviceService()).thenReturn(deviceService);

    // Act
    TbActor actualCreateActorResult = deviceActorCreator.createActor();

    // Assert
    verify(actorSystemContext).getDeviceService();
    verify(actorSystemContext).getMaxConcurrentSessionsPerDevice();
    verify(actorSystemContext).getRelationService();
    verify(actorSystemContext).getRpcSubmitStrategy();
    verify(actorSystemContext).getScheduler();
    verify(actorSystemContext).isEdgesEnabled();
    verify(actorSystemContext).isLocalCacheType();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    verify(baseRelationService)
        .findByToAndType(
            isA(TenantId.class), isA(EntityId.class), eq("Contains"), eq(RelationTypeGroup.EDGE));
    assertTrue(actualCreateActorResult instanceof DeviceActor);
    assertNull(((DeviceActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test {@link DeviceActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Given {@link DeviceService} {@link DeviceService#findDeviceById(TenantId, DeviceId)}
   *       return {@code null}.
   *   <li>Then return {@link DeviceActor}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActorCreator#createActor()}
   */
  @Test
  @DisplayName(
      "Test createActor(); given DeviceService findDeviceById(TenantId, DeviceId) return 'null'; then return DeviceActor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor DeviceActorCreator.createActor()"})
  void testCreateActor_givenDeviceServiceFindDeviceByIdReturnNull_thenReturnDeviceActor() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    when(actorSystemContext.getRpcSubmitStrategy()).thenReturn("Rpc Submit Strategy");
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());
    when(actorSystemContext.getMaxConcurrentSessionsPerDevice()).thenReturn(1L);
    when(actorSystemContext.getDeviceService()).thenReturn(deviceService);

    // Act
    TbActor actualCreateActorResult = deviceActorCreator.createActor();

    // Assert
    verify(actorSystemContext).getDeviceService();
    verify(actorSystemContext).getMaxConcurrentSessionsPerDevice();
    verify(actorSystemContext).getRpcSubmitStrategy();
    verify(actorSystemContext).getScheduler();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertTrue(actualCreateActorResult instanceof DeviceActor);
    assertNull(((DeviceActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test {@link DeviceActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getDeviceSessionCacheService()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test createActor(); then calls getDeviceSessionCacheService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor DeviceActorCreator.createActor()"})
  void testCreateActor_thenCallsGetDeviceSessionCacheService() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    when(baseRelationService.findByToAndType(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(actorSystemContext.getRelationService()).thenReturn(baseRelationService);
    when(actorSystemContext.isEdgesEnabled()).thenReturn(true);
    when(actorSystemContext.isLocalCacheType()).thenReturn(false);
    when(actorSystemContext.getDeviceSessionCacheService())
        .thenReturn(new DefaultDeviceSessionCacheService());
    when(actorSystemContext.getRpcSubmitStrategy()).thenReturn("Rpc Submit Strategy");
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());
    when(actorSystemContext.getMaxConcurrentSessionsPerDevice()).thenReturn(1L);
    when(actorSystemContext.getDeviceService()).thenReturn(deviceService);

    // Act
    TbActor actualCreateActorResult = deviceActorCreator.createActor();

    // Assert
    verify(actorSystemContext).getDeviceService();
    verify(actorSystemContext).getDeviceSessionCacheService();
    verify(actorSystemContext).getMaxConcurrentSessionsPerDevice();
    verify(actorSystemContext).getRelationService();
    verify(actorSystemContext).getRpcSubmitStrategy();
    verify(actorSystemContext).getScheduler();
    verify(actorSystemContext).isEdgesEnabled();
    verify(actorSystemContext).isLocalCacheType();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    verify(baseRelationService)
        .findByToAndType(
            isA(TenantId.class), isA(EntityId.class), eq("Contains"), eq(RelationTypeGroup.EDGE));
    assertTrue(actualCreateActorResult instanceof DeviceActor);
    assertNull(((DeviceActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test {@link DeviceActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getRelationService()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test createActor(); then calls getRelationService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor DeviceActorCreator.createActor()"})
  void testCreateActor_thenCallsGetRelationService() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    when(baseRelationService.findByToAndType(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(actorSystemContext.getRelationService()).thenReturn(baseRelationService);
    when(actorSystemContext.isEdgesEnabled()).thenReturn(true);
    when(actorSystemContext.isLocalCacheType()).thenReturn(true);
    when(actorSystemContext.getRpcSubmitStrategy()).thenReturn("Rpc Submit Strategy");
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());
    when(actorSystemContext.getMaxConcurrentSessionsPerDevice()).thenReturn(1L);
    when(actorSystemContext.getDeviceService()).thenReturn(deviceService);

    // Act
    TbActor actualCreateActorResult = deviceActorCreator.createActor();

    // Assert
    verify(actorSystemContext).getDeviceService();
    verify(actorSystemContext).getMaxConcurrentSessionsPerDevice();
    verify(actorSystemContext).getRelationService();
    verify(actorSystemContext).getRpcSubmitStrategy();
    verify(actorSystemContext).getScheduler();
    verify(actorSystemContext).isEdgesEnabled();
    verify(actorSystemContext).isLocalCacheType();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    verify(baseRelationService)
        .findByToAndType(
            isA(TenantId.class), isA(EntityId.class), eq("Contains"), eq(RelationTypeGroup.EDGE));
    assertTrue(actualCreateActorResult instanceof DeviceActor);
    assertNull(((DeviceActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }
}
