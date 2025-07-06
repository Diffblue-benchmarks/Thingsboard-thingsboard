package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.dao.cassandra.CassandraCluster;

class TbSaveToCustomCassandraTableNodeDiffblueTest {
  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given HashMap(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenHashMap_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenReturn(new CassandraCluster());

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx,
                new TbNodeConfiguration(
                    new POJONode(tbSaveToCustomCassandraTableNodeConfiguration))));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getCassandraCluster()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'null'; when TbContext getCassandraCluster() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenNull_whenTbContextGetCassandraClusterReturnNull() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenReturn(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code Unable to connect to
   *       Cassandra database}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given RuntimeException(String) with 'Unable to connect to Cassandra database'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenRuntimeExceptionWithUnableToConnectToCassandraDatabase()
      throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster())
        .thenThrow(new RuntimeException("Unable to connect to Cassandra database"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getCassandraCluster();
  }
}
