package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbVersionControlProducerProviderDiffblueTest {
  @InjectMocks private TbVersionControlProducerProvider tbVersionControlProducerProvider;

  @Mock private TbVersionControlQueueFactory tbVersionControlQueueFactory;

  /**
   * Test {@link TbVersionControlProducerProvider#init()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbVersionControlProducerProvider.init()"})
  void testInit() {
    // Arrange
    when(tbVersionControlQueueFactory.createTbCoreNotificationsMsgProducer())
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbVersionControlProducerProvider.init());
    verify(tbVersionControlQueueFactory).createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTransportNotificationsMsgProducer()"
  })
  void testGetTransportNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTransportNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getRuleEngineMsgProducer()"
  })
  void testGetRuleEngineMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getRuleEngineMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbCoreMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbCoreMsgProducer()"
  })
  void testGetTbCoreMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getTbCoreMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getRuleEngineNotificationsMsgProducer()"
  })
  void testGetRuleEngineNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbEdgeMsgProducer()"
  })
  void testGetTbEdgeMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getTbEdgeMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbEdgeNotificationsMsgProducer()"
  })
  void testGetTbEdgeNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbVersionControlMsgProducer()"
  })
  void testGetTbVersionControlMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTbVersionControlMsgProducer());
  }
}
