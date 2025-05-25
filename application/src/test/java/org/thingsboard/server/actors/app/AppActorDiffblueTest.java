package org.thingsboard.server.actors.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.thingsboard.server.actors.app.AppActor.ActorCreator;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {ActorCreator.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class AppActorDiffblueTest {
  @Autowired
  private ActorCreator actorCreator;

  @MockBean
  private ActorSystemContext actorSystemContext;

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   * <p>
   * Method under test: {@link ActorCreator#createActorId()}
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
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, actualCreateActorIdResult.getEntityType());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   * <ul>
   *   <li>Given {@link ActorCreator#ActorCreator(ActorSystemContext)} with context is {@link ActorSystemContext} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor(); given ActorCreator(ActorSystemContext) with context is ActorSystemContext (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor_givenActorCreatorWithContextIsActorSystemContext() {
    // Arrange and Act
    TbActor actualCreateActorResult = (new ActorCreator(new ActorSystemContext())).createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof AppActor);
    assertNull(((AppActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getTenantService()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor(); then calls getTenantService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor_thenCallsGetTenantService() {
    // Arrange
    when(actorSystemContext.getTenantService()).thenReturn(new TenantServiceImpl());

    // Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    verify(actorSystemContext).getTenantService();
    assertTrue(actualCreateActorResult instanceof AppActor);
    assertNull(((AppActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }
}
