package org.thingsboard.server.service.edge.rpc.processor.tenant;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

@ExtendWith(MockitoExtension.class)
class TenantEdgeProcessorDiffblueTest {
  @InjectMocks
  private TenantEdgeProcessor tenantEdgeProcessor;

  /**
   * Test {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg TenantEdgeProcessor.convertTenantEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertTenantEventToDownlink_whenEdgeEvent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(tenantEdgeProcessor.convertTenantEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
