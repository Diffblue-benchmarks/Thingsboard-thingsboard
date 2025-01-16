package org.thingsboard.server.service.edge.rpc.constructor;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.alarm.AlarmMsgConstructorFactory;

class BaseMsgConstructorFactoryDiffblueTest {
  /**
   * Test
   * {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getMsgConstructorByEdgeVersion(EdgeVersion); when 'V_3_3_0'")
  void testGetMsgConstructorByEdgeVersion_whenV330() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmMsgConstructorFactory()).getMsgConstructorByEdgeVersion(EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_6_2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getMsgConstructorByEdgeVersion(EdgeVersion); when 'V_3_6_2'")
  void testGetMsgConstructorByEdgeVersion_whenV362() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmMsgConstructorFactory()).getMsgConstructorByEdgeVersion(EdgeVersion.V_3_6_2));
  }
}
