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
package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsType;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ResponseStatus;
import org.thingsboard.server.gen.transport.TransportProtos.ValidateDeviceTokenRequestMsg;
import org.thingsboard.server.transport.http.DeviceApiController.DeviceProvisionCallback;

@ExtendWith(MockitoExtension.class)
class DeviceApiControllerDiffblueTest {
  @InjectMocks private DeviceApiController deviceApiController;

  @Mock private HttpTransportContext httpTransportContext;

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new DeviceProvisionCallback(new DeferredResult<>())
                .onSuccess(ProvisionDeviceResponseMsg.getDefaultInstance()));
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg2() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getStatus()).thenReturn(ResponseStatus.NOT_FOUND);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg3() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsType()).thenReturn(CredentialsType.LWM2M_CREDENTIALS);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg, atLeast(1)).getCredentialsType();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg4() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsValue())
        .thenThrow(new HttpMessageNotReadableException("https://example.org/example"));
    when(msg.getCredentialsType()).thenReturn(CredentialsType.ACCESS_TOKEN);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        HttpMessageNotReadableException.class, () -> deviceProvisionCallback.onSuccess(msg));
    verify(msg).getCredentialsType();
    verify(msg).getCredentialsValue();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg5() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsValue())
        .thenThrow(new HttpMessageNotReadableException("https://example.org/example"));
    when(msg.getCredentialsType()).thenReturn(CredentialsType.MQTT_BASIC);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        HttpMessageNotReadableException.class, () -> deviceProvisionCallback.onSuccess(msg));
    verify(msg).getCredentialsType();
    verify(msg).getCredentialsValue();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.ResponseStatus#FAILURE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'; given FAILURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProvisionCallback.onSuccess(ProvisionDeviceResponseMsg)"})
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg_givenFailure() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getStatus()).thenReturn(ResponseStatus.FAILURE);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test {@link DeviceApiController#getDeviceAttributes(String, String, String)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#getDeviceAttributes(String, String, String)}
   */
  @Test
  @DisplayName("Test getDeviceAttributes(String, String, String); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.getDeviceAttributes(String, String, String)"
  })
  void testGetDeviceAttributes_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualDeviceAttributes =
        deviceApiController.getDeviceAttributes(
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualDeviceAttributes.getResult());
    assertFalse(actualDeviceAttributes.hasResult());
    assertFalse(actualDeviceAttributes.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#postDeviceAttributes(String, String)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#postDeviceAttributes(String, String)}
   */
  @Test
  @DisplayName("Test postDeviceAttributes(String, String); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeferredResult DeviceApiController.postDeviceAttributes(String, String)"})
  void testPostDeviceAttributes_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualPostDeviceAttributesResult =
        deviceApiController.postDeviceAttributes(
            "https://example.org/example", "https://example.org/example");

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualPostDeviceAttributesResult.getResult());
    assertFalse(actualPostDeviceAttributesResult.hasResult());
    assertFalse(actualPostDeviceAttributesResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#postTelemetry(String, String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#postTelemetry(String, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test postTelemetry(String, String, HttpServletRequest); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.postTelemetry(String, String, HttpServletRequest)"
  })
  void testPostTelemetry_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualPostTelemetryResult =
        deviceApiController.postTelemetry(
            "https://example.org/example",
            "https://example.org/example",
            new MockHttpServletRequest());

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualPostTelemetryResult.getResult());
    assertFalse(actualPostTelemetryResult.hasResult());
    assertFalse(actualPostTelemetryResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#claimDevice(String, String)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#claimDevice(String, String)}
   */
  @Test
  @DisplayName("Test claimDevice(String, String); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeferredResult DeviceApiController.claimDevice(String, String)"})
  void testClaimDevice_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualClaimDeviceResult =
        deviceApiController.claimDevice(
            "https://example.org/example", "https://example.org/example");

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualClaimDeviceResult.getResult());
    assertFalse(actualClaimDeviceResult.hasResult());
    assertFalse(actualClaimDeviceResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#subscribeToCommands(String, long)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#subscribeToCommands(String, long)}
   */
  @Test
  @DisplayName("Test subscribeToCommands(String, long); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeferredResult DeviceApiController.subscribeToCommands(String, long)"})
  void testSubscribeToCommands_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualSubscribeToCommandsResult =
        deviceApiController.subscribeToCommands("https://example.org/example", 10L);

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualSubscribeToCommandsResult.getResult());
    assertFalse(actualSubscribeToCommandsResult.hasResult());
    assertFalse(actualSubscribeToCommandsResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#replyToCommand(String, Integer, String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#replyToCommand(String, Integer, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test replyToCommand(String, Integer, String, HttpServletRequest); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.replyToCommand(String, Integer, String, HttpServletRequest)"
  })
  void testReplyToCommand_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualReplyToCommandResult =
        deviceApiController.replyToCommand(
            "https://example.org/example",
            1,
            "https://example.org/example",
            new MockHttpServletRequest());

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualReplyToCommandResult.getResult());
    assertFalse(actualReplyToCommandResult.hasResult());
    assertFalse(actualReplyToCommandResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#postRpcRequest(String, String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#postRpcRequest(String, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test postRpcRequest(String, String, HttpServletRequest); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.postRpcRequest(String, String, HttpServletRequest)"
  })
  void testPostRpcRequest_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualPostRpcRequestResult =
        deviceApiController.postRpcRequest(
            "https://example.org/example",
            "https://example.org/example",
            new MockHttpServletRequest());

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualPostRpcRequestResult.getResult());
    assertFalse(actualPostRpcRequestResult.hasResult());
    assertFalse(actualPostRpcRequestResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#subscribeToAttributes(String, long)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#subscribeToAttributes(String, long)}
   */
  @Test
  @DisplayName("Test subscribeToAttributes(String, long); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeferredResult DeviceApiController.subscribeToAttributes(String, long)"})
  void testSubscribeToAttributes_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualSubscribeToAttributesResult =
        deviceApiController.subscribeToAttributes("https://example.org/example", 10L);

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualSubscribeToAttributesResult.getResult());
    assertFalse(actualSubscribeToAttributesResult.hasResult());
    assertFalse(actualSubscribeToAttributesResult.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#getFirmware(String, String, String, int, int)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#getFirmware(String, String, String, int, int)}
   */
  @Test
  @DisplayName("Test getFirmware(String, String, String, int, int); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.getFirmware(String, String, String, int, int)"
  })
  void testGetFirmware_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualFirmware =
        deviceApiController.getFirmware(
            "https://example.org/example", "Dr", "https://example.org/example", 3, 1);

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualFirmware.getResult());
    assertFalse(actualFirmware.hasResult());
    assertFalse(actualFirmware.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#getSoftware(String, String, String, int, int)}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceApiController#getSoftware(String, String, String, int, int)}
   */
  @Test
  @DisplayName("Test getSoftware(String, String, String, int, int); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult DeviceApiController.getSoftware(String, String, String, int, int)"
  })
  void testGetSoftware_thenReturnResultIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateDeviceTokenRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(httpTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    DeferredResult<ResponseEntity> actualSoftware =
        deviceApiController.getSoftware(
            "https://example.org/example", "Dr", "https://example.org/example", 3, 1);

    // Assert
    verify(httpTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            eq(DeviceTransportType.DEFAULT),
            isA(ValidateDeviceTokenRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertNull(actualSoftware.getResult());
    assertFalse(actualSoftware.hasResult());
    assertFalse(actualSoftware.isSetOrExpired());
  }

  /**
   * Test {@link DeviceApiController#getName()}.
   *
   * <p>Method under test: {@link DeviceApiController#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceApiController.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("HTTP", new DeviceApiController().getName());
  }
}
