package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;

@ContextConfiguration(classes = {EntityHistoryCmd.class})
@ExtendWith(SpringExtension.class)
class GetTsCmdDiffblueTest {
  @Autowired
  private GetTsCmd getTsCmd;

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams()")
  void testToAggregationParams() {
    // Arrange and Act
    AggregationParams actualToAggregationParamsResult = getTsCmd.toAggregationParams();

    // Assert
    assertNull(actualToAggregationParamsResult.getTzId());
    assertNull(actualToAggregationParamsResult.getIntervalType());
    assertEquals(0L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.NONE, actualToAggregationParamsResult.getAggregation());
  }
}
