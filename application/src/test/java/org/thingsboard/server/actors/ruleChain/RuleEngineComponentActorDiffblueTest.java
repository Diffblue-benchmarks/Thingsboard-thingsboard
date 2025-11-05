package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
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
import org.thingsboard.server.actors.TbRuleNodeUpdateException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.rule.RuleChain;

@ContextConfiguration(classes = {RuleChainActor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleEngineComponentActorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @MockBean private RuleChain ruleChain;

  @Autowired
  private RuleEngineComponentActor<RuleChainId, RuleChainActorMessageProcessor>
      ruleEngineComponentActor;

  @MockBean private TenantId tenantId;

  /**
   * Test {@link RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}.
   *
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName(
      "Test logLifecycleEvent(ComponentLifecycleEvent, Exception); then throw TbRuleNodeUpdateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent, Exception)"
  })
  void testLogLifecycleEvent_thenThrowTbRuleNodeUpdateException() {
    // Arrange
    Builder builder = new Builder(1, "https://example.org/example", new HttpHeaders());

    Builder setContentResult = builder.setAttemptCount(3).setContent("https://example.org/example");
    HttpResponseException cause =
        setContentResult
            .setHeaders(new HttpHeaders())
            .setMessage("https://example.org/example")
            .setStatusCode(1)
            .setStatusMessage("https://example.org/example")
            .build();
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", cause);
    doThrow(tbRuleNodeUpdateException)
        .when(actorSystemContext)
        .persistLifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            Mockito.<Exception>any());

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () ->
            ruleEngineComponentActor.logLifecycleEvent(
                ComponentLifecycleEvent.CREATED, new Exception()));
    verify(actorSystemContext)
        .persistLifecycleEvent(
            isA(TenantId.class),
            isNull(),
            eq(ComponentLifecycleEvent.CREATED),
            isA(Exception.class));
  }

  /**
   * Test {@link RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}.
   *
   * <ul>
   *   <li>When {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test logLifecycleEvent(ComponentLifecycleEvent, Exception); when 'CREATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent, Exception)"
  })
  void testLogLifecycleEvent_whenCreated() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistLifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            Mockito.<Exception>any());

    // Act
    ruleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent.CREATED, new Exception());

    // Assert
    verify(actorSystemContext)
        .persistLifecycleEvent(
            isA(TenantId.class),
            isNull(),
            eq(ComponentLifecycleEvent.CREATED),
            isA(Exception.class));
  }

  /**
   * Test {@link RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test logLifecycleEvent(ComponentLifecycleEvent, Exception); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent, Exception)"
  })
  void testLogLifecycleEvent_whenNull() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistLifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            Mockito.<Exception>any());

    // Act
    ruleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent.STARTED, null);

    // Assert
    verify(actorSystemContext)
        .persistLifecycleEvent(
            isA(TenantId.class), isNull(), eq(ComponentLifecycleEvent.STARTED), isNull());
  }

  /**
   * Test {@link RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}.
   *
   * <ul>
   *   <li>When {@code STARTED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentActor#logLifecycleEvent(ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test logLifecycleEvent(ComponentLifecycleEvent, Exception); when 'STARTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent, Exception)"
  })
  void testLogLifecycleEvent_whenStarted() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistLifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            Mockito.<Exception>any());

    // Act
    ruleEngineComponentActor.logLifecycleEvent(ComponentLifecycleEvent.STARTED, new Exception());

    // Assert
    verify(actorSystemContext)
        .persistLifecycleEvent(
            isA(TenantId.class),
            isNull(),
            eq(ComponentLifecycleEvent.STARTED),
            isA(Exception.class));
  }
}
