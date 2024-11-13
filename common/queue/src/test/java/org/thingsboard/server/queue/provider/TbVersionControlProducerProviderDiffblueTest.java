package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbVersionControlProducerProviderDiffblueTest {
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
