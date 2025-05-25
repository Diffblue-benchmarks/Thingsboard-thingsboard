package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.TenantProfile;

class TbMsgTimeseriesNodeDiffblueTest {
  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgTimeseriesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException("foo")).when(ctx)
        .addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then calls {@link TbContext#getTenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given TenantProfile(); then calls getTenantProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgTimeseriesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTenantProfile_thenCallsGetTenantProfile() throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantProfile()).thenReturn(new TenantProfile());
    doNothing().when(ctx).addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act
    tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(new POJONode(null)));

    // Assert
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
    verify(ctx).getTenantProfile();
  }
}
