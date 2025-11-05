package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.exception.DataValidationException;

@ExtendWith(MockitoExtension.class)
class TbAwsLambdaNodeDiffblueTest {
  @Mock private AWSLambdaAsync aWSLambdaAsync;

  @InjectMocks private TbAwsLambdaNode tbAwsLambdaNode;

  @Mock private TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration;

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    when(tbAwsLambdaNodeConfiguration.getFunctionName())
        .thenThrow(new DataValidationException("An error occurred"));
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.onMsg(ctx, msg));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() {
    // Arrange
    when(tbAwsLambdaNodeConfiguration.getQualifier())
        .thenThrow(new DataValidationException("An error occurred"));
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.onMsg(ctx, msg));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration).getQualifier();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg3() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("Qualifier");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.onMsg(ctx, msg));
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNodeConfiguration} {@link
   *       TbAwsLambdaNodeConfiguration#getQualifier()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbAwsLambdaNodeConfiguration getQualifier() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbAwsLambdaNodeConfigurationGetQualifierReturnEmptyString() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenReturn(new CompletableFuture<>());
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration).getQualifier();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNodeConfiguration} {@link
   *       TbAwsLambdaNodeConfiguration#getQualifier()} return {@code Qualifier}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbAwsLambdaNodeConfiguration getQualifier() return 'Qualifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbAwsLambdaNodeConfigurationGetQualifierReturnQualifier() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenReturn(new CompletableFuture<>());
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("Qualifier");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNodeConfiguration} {@link
   *       TbAwsLambdaNodeConfiguration#getQualifier()} return {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbAwsLambdaNodeConfiguration getQualifier() return '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbAwsLambdaNodeConfigurationGetQualifierReturnUu() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenReturn(new CompletableFuture<>());
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("$[UU]");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
  }

  /**
   * Test {@link TbAwsLambdaNode#destroy()}.
   *
   * <p>Method under test: {@link TbAwsLambdaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.destroy()"})
  void testDestroy() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(aWSLambdaAsync).shutdown();

    // Act
    tbAwsLambdaNode.destroy();

    // Assert
    verify(aWSLambdaAsync).shutdown();
  }

  /**
   * Test {@link TbAwsLambdaNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link AWSLambdaAsync} {@link AWSLambdaAsync#shutdown()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given AWSLambdaAsync shutdown() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.destroy()"})
  void testDestroy_givenAWSLambdaAsyncShutdownDoesNothing() {
    // Arrange
    doNothing().when(aWSLambdaAsync).shutdown();

    // Act
    tbAwsLambdaNode.destroy();

    // Assert
    verify(aWSLambdaAsync).shutdown();
  }
}
