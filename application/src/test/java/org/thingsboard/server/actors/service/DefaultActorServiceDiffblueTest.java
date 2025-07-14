package org.thingsboard.server.actors.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystem;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultActorServiceDiffblueTest {
  @Mock private ActorSystemContext actorSystemContext;

  @InjectMocks private DefaultActorService defaultActorService;

  /**
   * Test {@link DefaultActorService#initActorSystem()}.
   *
   * <p>Method under test: {@link DefaultActorService#initActorSystem()}
   */
  @Test
  @DisplayName("Test initActorSystem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultActorService.initActorSystem()"})
  void testInitActorSystem() {
    // Arrange
    when(actorSystemContext.getTenantService()).thenReturn(new TenantServiceImpl());
    doNothing().when(actorSystemContext).setActorService(Mockito.<ActorService>any());
    doNothing().when(actorSystemContext).setActorSystem(Mockito.<TbActorSystem>any());
    doNothing().when(actorSystemContext).setAppActor(Mockito.<TbActorRef>any());
    doNothing().when(actorSystemContext).setStatsActor(Mockito.<TbActorRef>any());

    // Act
    defaultActorService.initActorSystem();

    // Assert
    verify(actorSystemContext).getTenantService();
    verify(actorSystemContext).setActorService(isA(ActorService.class));
    verify(actorSystemContext).setActorSystem(isA(TbActorSystem.class));
    verify(actorSystemContext).setAppActor(isA(TbActorRef.class));
    verify(actorSystemContext).setStatsActor(isA(TbActorRef.class));
  }
}
