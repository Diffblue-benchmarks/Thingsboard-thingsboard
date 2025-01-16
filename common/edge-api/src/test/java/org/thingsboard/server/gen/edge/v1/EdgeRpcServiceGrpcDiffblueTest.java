package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeRpcServiceGrpc.AsyncService;

class EdgeRpcServiceGrpcDiffblueTest {
  /**
   * Test {@link EdgeRpcServiceGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeRpcServiceGrpc#bindService(EdgeRpcServiceGrpc.AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = EdgeRpcServiceGrpc
        .bindService(mock(EdgeRpcServiceGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(1, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("edge.EdgeRpcService/handleMsgs", getResult.getFullMethodName());
    assertEquals("handleMsgs", getResult.getBareMethodName());
    assertEquals(1, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.BIDI_STREAMING, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeRpcServiceGrpc#bindService(EdgeRpcServiceGrpc.AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = EdgeRpcServiceGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(1, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("edge.EdgeRpcService/handleMsgs", getResult.getFullMethodName());
    assertEquals("handleMsgs", getResult.getBareMethodName());
    assertEquals(1, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.BIDI_STREAMING, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#getHandleMsgsMethod()}.
   * <p>
   * Method under test: {@link EdgeRpcServiceGrpc#getHandleMsgsMethod()}
   */
  @Test
  @DisplayName("Test getHandleMsgsMethod()")
  void testGetHandleMsgsMethod() {
    // Arrange and Act
    MethodDescriptor<RequestMsg, ResponseMsg> actualHandleMsgsMethod = EdgeRpcServiceGrpc.getHandleMsgsMethod();

    // Assert
    assertEquals("edge.EdgeRpcService/handleMsgs", actualHandleMsgsMethod.getFullMethodName());
    assertEquals("handleMsgs", actualHandleMsgsMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.BIDI_STREAMING, actualHandleMsgsMethod.getType());
    assertFalse(actualHandleMsgsMethod.isIdempotent());
    assertFalse(actualHandleMsgsMethod.isSafe());
    assertTrue(actualHandleMsgsMethod.isSampledToLocalTracing());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, actualHandleMsgsMethod.getServiceName());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link EdgeRpcServiceGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = EdgeRpcServiceGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(1, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("edge.EdgeRpcService/handleMsgs", getResult.getFullMethodName());
    assertEquals("handleMsgs", getResult.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.BIDI_STREAMING, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeRpcServiceGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    EdgeRpcServiceGrpc.EdgeRpcServiceBlockingStub actualNewBlockingStubResult = EdgeRpcServiceGrpc
        .newBlockingStub(channel);

    // Assert
    CallOptions callOptions = actualNewBlockingStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewBlockingStubResult.getChannel());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeRpcServiceGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    EdgeRpcServiceGrpc.EdgeRpcServiceFutureStub actualNewFutureStubResult = EdgeRpcServiceGrpc.newFutureStub(channel);

    // Assert
    CallOptions callOptions = actualNewFutureStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewFutureStubResult.getChannel());
  }

  /**
   * Test {@link EdgeRpcServiceGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeRpcServiceGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    EdgeRpcServiceGrpc.EdgeRpcServiceStub actualNewStubResult = EdgeRpcServiceGrpc.newStub(channel);

    // Assert
    CallOptions callOptions = actualNewStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewStubResult.getChannel());
  }
}
