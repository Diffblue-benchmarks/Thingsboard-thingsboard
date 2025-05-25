package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbSaveToCustomCassandraTableNodeDiffblueTest {
  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbContext} {@link TbContext#getCassandraCluster()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'null'; when TbContext getCassandraCluster() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenNull_whenTbContextGetCassandraClusterReturnNull() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode = new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbSaveToCustomCassandraTableNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code Unable to connect to Cassandra database}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given RuntimeException(String) with 'Unable to connect to Cassandra database'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenRuntimeExceptionWithUnableToConnectToCassandraDatabase() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode = new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenThrow(new RuntimeException("Unable to connect to Cassandra database"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbSaveToCustomCassandraTableNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getCassandraCluster();
  }
}
