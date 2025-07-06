package org.thingsboard.server.service.edge.rpc.constructor;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.alarm.AlarmMsgConstructorFactory;

class BaseMsgConstructorFactoryDiffblueTest {
  /**
   * Test {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_3_0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getMsgConstructorByEdgeVersion(EdgeVersion); when 'V_3_3_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.service.edge.rpc.constructor.MsgConstructor BaseMsgConstructorFactory.getMsgConstructorByEdgeVersion(EdgeVersion)"
  })
  void testGetMsgConstructorByEdgeVersion_whenV330() {
    // Arrange, Act and Assert
    assertNull(
        new AlarmMsgConstructorFactory().getMsgConstructorByEdgeVersion(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_6_2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseMsgConstructorFactory#getMsgConstructorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getMsgConstructorByEdgeVersion(EdgeVersion); when 'V_3_6_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.service.edge.rpc.constructor.MsgConstructor BaseMsgConstructorFactory.getMsgConstructorByEdgeVersion(EdgeVersion)"
  })
  void testGetMsgConstructorByEdgeVersion_whenV362() {
    // Arrange, Act and Assert
    assertNull(
        new AlarmMsgConstructorFactory().getMsgConstructorByEdgeVersion(EdgeVersion.V_3_6_2));
  }
}
