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

@ContextConfiguration(classes = {TbVersionControlProducerProvider.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbVersionControlProducerProviderDiffblueTest {
  @Autowired
  private TbVersionControlProducerProvider tbVersionControlProducerProvider;

  @MockBean
  private TbVersionControlQueueFactory tbVersionControlQueueFactory;

  /**
   * Test {@link TbVersionControlProducerProvider#init()}.
   * <p>
   * Method under test: {@link TbVersionControlProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3371 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.init();
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTransportNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3368 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getTransportNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer(); then throw RuntimeException")
  void testGetTransportNotificationsMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTransportNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3350 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getRuleEngineMsgProducer();
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineMsgProducer(); then throw RuntimeException")
  void testGetRuleEngineMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getRuleEngineMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3356 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getTbCoreMsgProducer();
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbCoreMsgProducer(); then throw RuntimeException")
  void testGetTbCoreMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getTbCoreMsgProducer());
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetRuleEngineNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3353 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer(); then throw RuntimeException")
  void testGetRuleEngineNotificationsMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbEdgeMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3359 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getTbEdgeMsgProducer();
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer(); then throw RuntimeException")
  void testGetTbEdgeMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getTbEdgeMsgProducer());
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbEdgeNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3362 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getTbEdgeNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer(); then throw RuntimeException")
  void testGetTbEdgeNotificationsMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbVersionControlMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbVersionControlProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbVersionControlProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3365 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbVersionControlProducerProvider tbVersionControlProducerProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbVersionControlQueueFactory tbVersionControlQueueFactory;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbVersionControlProducerProvider.getTbVersionControlMsgProducer();
  }

  /**
   * Test
   * {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer(); then throw RuntimeException")
  void testGetTbVersionControlMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTbVersionControlMsgProducer());
  }
}
