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
class TenantProfileEdgeProcessorDiffblueTest {
  @InjectMocks
  private TenantProfileEdgeProcessor tenantProfileEdgeProcessor;

  /**
   * Test {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg TenantProfileEdgeProcessor.convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertTenantProfileEventToDownlink_whenEdgeEvent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(tenantProfileEdgeProcessor.convertTenantProfileEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
