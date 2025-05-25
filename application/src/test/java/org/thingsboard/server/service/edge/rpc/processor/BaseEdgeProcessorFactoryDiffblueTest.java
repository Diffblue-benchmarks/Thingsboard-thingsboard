package org.thingsboard.server.service.edge.rpc.processor;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessorFactory;

class BaseEdgeProcessorFactoryDiffblueTest {
  /**
   * Test {@link BaseEdgeProcessorFactory#getProcessorByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessorFactory#getProcessorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getProcessorByEdgeVersion(EdgeVersion); when 'V_3_3_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.edge.rpc.processor.EdgeProcessor BaseEdgeProcessorFactory.getProcessorByEdgeVersion(EdgeVersion)"})
  void testGetProcessorByEdgeVersion_whenV330() {
    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorFactory()).getProcessorByEdgeVersion(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link BaseEdgeProcessorFactory#getProcessorByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_6_2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessorFactory#getProcessorByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getProcessorByEdgeVersion(EdgeVersion); when 'V_3_6_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.edge.rpc.processor.EdgeProcessor BaseEdgeProcessorFactory.getProcessorByEdgeVersion(EdgeVersion)"})
  void testGetProcessorByEdgeVersion_whenV362() {
    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorFactory()).getProcessorByEdgeVersion(EdgeVersion.V_3_6_2));
  }
}
