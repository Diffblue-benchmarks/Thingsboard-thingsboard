/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.dao.exception.DataValidationException;

@ExtendWith(MockitoExtension.class)
class TbAwsLambdaNodeDiffblueTest {
  @Mock private AWSLambdaAsync aWSLambdaAsync;

  @InjectMocks private TbAwsLambdaNode tbAwsLambdaNode;

  @Mock private TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration;

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowDataValidationException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tbAwsLambdaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbAwsLambdaNodeConfiguration()))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAwsLambdaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbAwsLambdaNodeConfiguration()))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is 'null'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
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
  void testOnMsg() {
    // Arrange
    when(tbAwsLambdaNodeConfiguration.getFunctionName())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tbAwsLambdaNode.onMsg(mock(TbContext.class), mock(TbMsg.class)));
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
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.onMsg(ctx, msg));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration).getQualifier();
    verify(msg).getData();
    verify(msg).getMetaData();
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
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.onMsg(ctx, msg));
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
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
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration).getQualifier();
    verify(msg, atLeast(1)).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code 42} is {@code Value}.
   *   <li>Then calls {@link AWSLambdaAsync#invokeAsync(InvokeRequest, AsyncHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value '42' is 'Value'; then calls invokeAsync(InvokeRequest, AsyncHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValue42IsValue_thenCallsInvokeAsync() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenReturn(new CompletableFuture<>());
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("Qualifier");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = mock(TbContext.class);

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("42", "Value");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link AWSLambdaAsync#invokeAsync(InvokeRequest, AsyncHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls invokeAsync(InvokeRequest, AsyncHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsInvokeAsync() {
    // Arrange
    when(aWSLambdaAsync.invokeAsync(
            Mockito.<InvokeRequest>any(), Mockito.<AsyncHandler<InvokeRequest, InvokeResult>>any()))
        .thenReturn(new CompletableFuture<>());
    when(tbAwsLambdaNodeConfiguration.getQualifier()).thenReturn("Qualifier");
    when(tbAwsLambdaNodeConfiguration.getFunctionName()).thenReturn("Function Name");
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbAwsLambdaNode.onMsg(ctx, msg);

    // Assert
    verify(aWSLambdaAsync).invokeAsync(isA(InvokeRequest.class), isA(AsyncHandler.class));
    verify(tbAwsLambdaNodeConfiguration).getFunctionName();
    verify(tbAwsLambdaNodeConfiguration, atLeast(1)).getQualifier();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
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
