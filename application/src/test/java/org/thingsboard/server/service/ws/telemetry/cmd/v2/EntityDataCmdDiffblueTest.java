package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.service.ws.WsCmdType;

class EntityDataCmdDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return AggHistoryCmd is {@link AggHistoryCmd} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataCmd#EntityDataCmd(int, EntityDataQuery, EntityHistoryCmd, LatestValueCmd, TimeSeriesCmd, AggHistoryCmd, AggTimeSeriesCmd)}
   *   <li>{@link EntityDataCmd#getAggHistoryCmd()}
   *   <li>{@link EntityDataCmd#getAggTsCmd()}
   *   <li>{@link EntityDataCmd#getHistoryCmd()}
   *   <li>{@link EntityDataCmd#getLatestCmd()}
   *   <li>{@link EntityDataCmd#getQuery()}
   *   <li>{@link EntityDataCmd#getTsCmd()}
   *   <li>{@link EntityDataCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; given one; then return AggHistoryCmd is AggHistoryCmd (default constructor)")
  void testGettersAndSetters_givenOne_thenReturnAggHistoryCmdIsAggHistoryCmd() {
    // Arrange
    EntityDataQuery query = new EntityDataQuery();
    EntityHistoryCmd historyCmd = new EntityHistoryCmd();

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());
    TimeSeriesCmd tsCmd = new TimeSeriesCmd();

    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    AggTimeSeriesCmd aggTsCmd = new AggTimeSeriesCmd();
    aggTsCmd.setKeys(new ArrayList<>());
    aggTsCmd.setStartTs(1L);
    aggTsCmd.setTimeWindow(10L);

    // Act
    EntityDataCmd actualEntityDataCmd = new EntityDataCmd(1, query, historyCmd, latestCmd, tsCmd, aggHistoryCmd,
        aggTsCmd);
    AggHistoryCmd actualAggHistoryCmd = actualEntityDataCmd.getAggHistoryCmd();
    AggTimeSeriesCmd actualAggTsCmd = actualEntityDataCmd.getAggTsCmd();
    EntityHistoryCmd actualHistoryCmd = actualEntityDataCmd.getHistoryCmd();
    LatestValueCmd actualLatestCmd = actualEntityDataCmd.getLatestCmd();
    EntityDataQuery actualQuery = actualEntityDataCmd.getQuery();
    TimeSeriesCmd actualTsCmd = actualEntityDataCmd.getTsCmd();
    WsCmdType actualType = actualEntityDataCmd.getType();

    // Assert
    assertEquals(1, actualEntityDataCmd.getCmdId());
    assertEquals(WsCmdType.ENTITY_DATA, actualType);
    assertSame(query, actualQuery);
    assertSame(aggHistoryCmd, actualAggHistoryCmd);
    assertSame(aggTsCmd, actualAggTsCmd);
    assertSame(historyCmd, actualHistoryCmd);
    assertSame(latestCmd, actualLatestCmd);
    assertSame(tsCmd, actualTsCmd);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return AggHistoryCmd is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataCmd#EntityDataCmd(int, EntityDataQuery, EntityHistoryCmd, LatestValueCmd, TimeSeriesCmd)}
   *   <li>{@link EntityDataCmd#getAggHistoryCmd()}
   *   <li>{@link EntityDataCmd#getAggTsCmd()}
   *   <li>{@link EntityDataCmd#getHistoryCmd()}
   *   <li>{@link EntityDataCmd#getLatestCmd()}
   *   <li>{@link EntityDataCmd#getQuery()}
   *   <li>{@link EntityDataCmd#getTsCmd()}
   *   <li>{@link EntityDataCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return AggHistoryCmd is 'null'")
  void testGettersAndSetters_thenReturnAggHistoryCmdIsNull() {
    // Arrange
    EntityDataQuery query = new EntityDataQuery();
    EntityHistoryCmd historyCmd = new EntityHistoryCmd();

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());
    TimeSeriesCmd tsCmd = new TimeSeriesCmd();

    // Act
    EntityDataCmd actualEntityDataCmd = new EntityDataCmd(1, query, historyCmd, latestCmd, tsCmd);
    AggHistoryCmd actualAggHistoryCmd = actualEntityDataCmd.getAggHistoryCmd();
    AggTimeSeriesCmd actualAggTsCmd = actualEntityDataCmd.getAggTsCmd();
    EntityHistoryCmd actualHistoryCmd = actualEntityDataCmd.getHistoryCmd();
    LatestValueCmd actualLatestCmd = actualEntityDataCmd.getLatestCmd();
    EntityDataQuery actualQuery = actualEntityDataCmd.getQuery();
    TimeSeriesCmd actualTsCmd = actualEntityDataCmd.getTsCmd();
    WsCmdType actualType = actualEntityDataCmd.getType();

    // Assert
    assertNull(actualAggHistoryCmd);
    assertNull(actualAggTsCmd);
    assertEquals(1, actualEntityDataCmd.getCmdId());
    assertEquals(WsCmdType.ENTITY_DATA, actualType);
    assertSame(query, actualQuery);
    assertSame(historyCmd, actualHistoryCmd);
    assertSame(latestCmd, actualLatestCmd);
    assertSame(tsCmd, actualTsCmd);
  }
}
