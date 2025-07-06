package org.thingsboard.server.actors.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorCtx;
import org.thingsboard.server.actors.TbActorException;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorNotRegisteredException;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.actors.tenant.TenantActor.ActorCreator;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {ActorCreator.class, TenantId.class, TenantActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class TenantActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private TenantActor tenantActor;

  @MockBean private UUID uUID;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor() {
    // Arrange
    ActorSystemContext context = new ActorSystemContext();

    // Act
    TbActor actualCreateActorResult =
        new ActorCreator(
                context, new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof TenantActor);
    assertNull(((TenantActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertNull(((TenantActor) actualCreateActorResult).getRootChainActor());
    assertNull(((TenantActor) actualCreateActorResult).getRootChain());
    assertFalse(((TenantActor) actualCreateActorResult).cantFindTenant);
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   *
   * <p>Method under test: {@link ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActorId ActorCreator.createActorId()"})
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();
    EntityType actualEntityType = actualCreateActorIdResult.getEntityType();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    EntityId entityId = ((TbEntityActorId) actualCreateActorIdResult).getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, actualCreateActorIdResult.getEntityType());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(entityId.isNullUid());
    assertFalse(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getRuleChainService()}.
   * </ul>
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor(); then calls getRuleChainService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor_thenCallsGetRuleChainService() {
    // Arrange
    when(actorSystemContext.getRuleChainService()).thenReturn(new BaseRuleChainService());

    // Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    verify(actorSystemContext).getRuleChainService();
    assertTrue(actualCreateActorResult instanceof TenantActor);
    assertNull(((TenantActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertNull(((TenantActor) actualCreateActorResult).getRootChainActor());
    assertNull(((TenantActor) actualCreateActorResult).getRootChain());
    assertFalse(((TenantActor) actualCreateActorResult).cantFindTenant);
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit() throws TbActorException {
    // Arrange
    when(actorSystemContext.getTenantService())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getTenantService();
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#getTenantService()} return
   *       {@link TenantServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName(
      "Test init(TbActorCtx); given ActorSystemContext getTenantService() return TenantServiceImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit_givenActorSystemContextGetTenantServiceReturnTenantServiceImpl()
      throws TbActorException {
    // Arrange
    when(actorSystemContext.getTenantService()).thenReturn(new TenantServiceImpl());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getTenantService();
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }
}
