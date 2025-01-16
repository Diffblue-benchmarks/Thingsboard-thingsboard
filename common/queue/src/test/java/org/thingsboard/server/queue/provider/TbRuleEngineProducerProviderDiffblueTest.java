package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbRuleEngineProducerProvider.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbRuleEngineProducerProviderDiffblueTest {
  @Autowired
  private TbRuleEngineProducerProvider tbRuleEngineProducerProvider;

  @MockBean
  private TbRuleEngineQueueFactory tbRuleEngineQueueFactory;

  /**
   * Test {@link TbRuleEngineProducerProvider#init()}.
   * <p>
   * Method under test: {@link TbRuleEngineProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3270 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider tbRuleEngineProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbRuleEngineQueueFactory tbRuleEngineQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbRuleEngineProducerProvider.init();
  }

  /**
   * Test {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbVersionControlMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3267 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbRuleEngineProducerProvider tbRuleEngineProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbRuleEngineQueueFactory tbRuleEngineQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbRuleEngineProducerProvider.getTbVersionControlMsgProducer();
  }

  /**
   * Test {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer(); then throw RuntimeException")
  void testGetTbVersionControlMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbRuleEngineProducerProvider(null)).getTbVersionControlMsgProducer());
  }
}
