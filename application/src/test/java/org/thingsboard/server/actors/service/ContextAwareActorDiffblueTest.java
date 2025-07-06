package org.thingsboard.server.actors.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.thingsboard.server.actors.stats.StatsActor;

@ContextConfiguration(classes = {StatsActor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class ContextAwareActorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private ContextAwareActor contextAwareActor;

  /**
   * Test {@link ContextAwareActor#doProcessFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Error#Error(String)} with {@code foo}.
   *   <li>Then return Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#doProcessFailure(Throwable)}
   */
  @Test
  @DisplayName("Test doProcessFailure(Throwable); when Error(String) with 'foo'; then return Stop")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.doProcessFailure(Throwable)"
  })
  void testDoProcessFailure_whenErrorWithFoo_thenReturnStop() {
    // Arrange, Act and Assert
    assertTrue(contextAwareActor.doProcessFailure(new Error("foo")).isStop());
  }

  /**
   * Test {@link ContextAwareActor#doProcessFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return not Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#doProcessFailure(Throwable)}
   */
  @Test
  @DisplayName("Test doProcessFailure(Throwable); when Throwable(); then return not Stop")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.doProcessFailure(Throwable)"
  })
  void testDoProcessFailure_whenThrowable_thenReturnNotStop() {
    // Arrange, Act and Assert
    assertFalse(contextAwareActor.doProcessFailure(new Throwable()).isStop());
  }
}
