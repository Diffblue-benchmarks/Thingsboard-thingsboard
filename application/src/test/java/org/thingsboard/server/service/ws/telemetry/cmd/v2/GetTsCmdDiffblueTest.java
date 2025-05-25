package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.IntervalType;

@ContextConfiguration(classes = {EntityHistoryCmd.class})
@ExtendWith(SpringExtension.class)
class GetTsCmdDiffblueTest {
  @Autowired
  private GetTsCmd getTsCmd;

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Given {@link EntityHistoryCmd} (default constructor) Agg is {@code NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); given EntityHistoryCmd (default constructor) Agg is 'NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_givenEntityHistoryCmdAggIsNone() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setAgg(Aggregation.NONE);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertNull(actualToAggregationParamsResult.getTzId());
    assertNull(actualToAggregationParamsResult.getIntervalType());
    assertEquals(0L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.NONE, actualToAggregationParamsResult.getAggregation());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Given {@link EntityHistoryCmd} (default constructor) IntervalType is {@code MILLISECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); given EntityHistoryCmd (default constructor) IntervalType is 'MILLISECONDS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_givenEntityHistoryCmdIntervalTypeIsMilliseconds() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setIntervalType(IntervalType.MILLISECONDS);
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertNull(actualToAggregationParamsResult.getTzId());
    assertEquals(0L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.MIN, actualToAggregationParamsResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualToAggregationParamsResult.getIntervalType());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Given {@link EntityHistoryCmd} (default constructor) TimeZoneId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); given EntityHistoryCmd (default constructor) TimeZoneId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_givenEntityHistoryCmdTimeZoneIdIs42() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setTimeZoneId("42");
    entityHistoryCmd.setIntervalType(IntervalType.WEEK);
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertEquals(604800000L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.MIN, actualToAggregationParamsResult.getAggregation());
    assertEquals(IntervalType.WEEK, actualToAggregationParamsResult.getIntervalType());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Given {@link GetTsCmd}.</li>
   *   <li>Then return IntervalType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); given GetTsCmd; then return IntervalType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_givenGetTsCmd_thenReturnIntervalTypeIsNull() {
    // Arrange and Act
    AggregationParams actualToAggregationParamsResult = getTsCmd.toAggregationParams();

    // Assert
    assertNull(actualToAggregationParamsResult.getTzId());
    assertNull(actualToAggregationParamsResult.getIntervalType());
    assertEquals(0L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.NONE, actualToAggregationParamsResult.getAggregation());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Then return Interval is {@code 604800000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); then return Interval is '604800000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_thenReturnIntervalIs604800000() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setIntervalType(IntervalType.WEEK);
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertEquals(604800000L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.MIN, actualToAggregationParamsResult.getAggregation());
    assertEquals(IntervalType.WEEK, actualToAggregationParamsResult.getIntervalType());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Then return IntervalType is {@code MILLISECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); then return IntervalType is 'MILLISECONDS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_thenReturnIntervalTypeIsMilliseconds() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertNull(actualToAggregationParamsResult.getTzId());
    assertEquals(0L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.MIN, actualToAggregationParamsResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualToAggregationParamsResult.getIntervalType());
  }

  /**
   * Test {@link GetTsCmd#toAggregationParams()}.
   * <ul>
   *   <li>Then return TzId toString is {@code UTC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTsCmd#toAggregationParams()}
   */
  @Test
  @DisplayName("Test toAggregationParams(); then return TzId toString is 'UTC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregationParams GetTsCmd.toAggregationParams()"})
  void testToAggregationParams_thenReturnTzIdToStringIsUtc() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setTimeZoneId("UTC");
    entityHistoryCmd.setIntervalType(IntervalType.WEEK);
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act
    AggregationParams actualToAggregationParamsResult = entityHistoryCmd.toAggregationParams();

    // Assert
    assertEquals("UTC", actualToAggregationParamsResult.getTzId().toString());
    assertEquals(604800000L, actualToAggregationParamsResult.getInterval());
    assertEquals(Aggregation.MIN, actualToAggregationParamsResult.getAggregation());
    assertEquals(IntervalType.WEEK, actualToAggregationParamsResult.getIntervalType());
  }
}
