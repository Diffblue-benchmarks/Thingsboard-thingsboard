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
package org.thingsboard.server.transport.lwm2m.server.attributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.response.WriteResponse;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.DownlinkRequestCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class DefaultLwM2MAttributesServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}
   */
  @Test
  void testGetSharedAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    ListenableFuture<List<TransportProtos.TsKvProto>> actualSharedAttributes = defaultLwM2MAttributesService
        .getSharedAttributes(client, new ArrayList<>());

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.GetAttributeRequestMsg.class), isA(TransportServiceCallback.class));
    assertTrue(actualSharedAttributes instanceof SettableFuture);
    assertTrue(client.getResources().isEmpty());
    assertTrue(client.getSharedAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}
   */
  @Test
  void testGetSharedAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    ListenableFuture<List<TransportProtos.TsKvProto>> actualSharedAttributes = defaultLwM2MAttributesService
        .getSharedAttributes(client, new ArrayList<>());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetAttributeRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client).getSession();
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}
   */
  @Test
  void testGetSharedAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    ListenableFuture<List<TransportProtos.TsKvProto>> actualSharedAttributes = defaultLwM2MAttributesService
        .getSharedAttributes(client, keys);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetAttributeRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client).getSession();
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}
   */
  @Test
  void testGetSharedAttributes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    ListenableFuture<List<TransportProtos.TsKvProto>> actualSharedAttributes = defaultLwM2MAttributesService
        .getSharedAttributes(client, keys);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetAttributeRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client).getSession();
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}
   */
  @Test
  void testGetSharedAttributes5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new IllegalArgumentException("foo")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LinkedHashSet<String> keys = new LinkedHashSet<>();
    keys.add("Keys");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultLwM2MAttributesService.getSharedAttributes(client, keys));
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.GetAttributeRequestMsg.class), isA(TransportServiceCallback.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnGetAttributesResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = TransportProtos.GetAttributeResponseMsg
        .getDefaultInstance();

    // Act
    defaultLwM2MAttributesService.onGetAttributesResponse(getAttributesResponse,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = getAttributesResponse.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(getAttributesResponse.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(futures, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(futures, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(futures, toProtoResult.getSourceCodeInfo().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(futures, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(futures, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(futures, options2.getAllFields());
    assertEquals(futures, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(futures, features.getAllFieldsRaw());
    assertEquals(futures, options2.getAllFieldsRaw());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnGetAttributesResponse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    SettableFuture<List<TransportProtos.TsKvProto>> createResult = SettableFuture.create();
    futures.put(0, createResult);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = TransportProtos.GetAttributeResponseMsg
        .getDefaultInstance();

    // Act
    defaultLwM2MAttributesService.onGetAttributesResponse(getAttributesResponse,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = getAttributesResponse.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(getAttributesResponse.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(futures, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(futures, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(futures, toProtoResult.getSourceCodeInfo().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(futures, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(futures, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(futures, options2.getAllFields());
    assertEquals(futures, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(futures, features.getAllFieldsRaw());
    assertEquals(futures, options2.getAllFieldsRaw());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(TransportProtos.AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnAttributesUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientBySessionInfo(Mockito.<TransportProtos.SessionInfoProto>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    TransportProtos.AttributeUpdateNotificationMsg msg = TransportProtos.AttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(msg, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(clientContext).getClientBySessionInfo(isA(TransportProtos.SessionInfoProto.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(TransportProtos.AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnAttributesUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientBySessionInfo(Mockito.<TransportProtos.SessionInfoProto>any())).thenReturn(null);
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    TransportProtos.AttributeUpdateNotificationMsg msg = TransportProtos.AttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(msg, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(clientContext).getClientBySessionInfo(isA(TransportProtos.SessionInfoProto.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(TransportProtos.AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnAttributesUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientBySessionInfo(Mockito.<TransportProtos.SessionInfoProto>any()))
        .thenThrow(new IllegalArgumentException("OnAttributeUpdate, lwM2MClient is null"));
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    TransportProtos.AttributeUpdateNotificationMsg msg = TransportProtos.AttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultLwM2MAttributesService.onAttributesUpdate(msg,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(clientContext).getClientBySessionInfo(isA(TransportProtos.SessionInfoProto.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    when(clientContext.getObjectIdByKeyNameFromProfile(Mockito.<LwM2mClient>any(), Mockito.<String>any()))
        .thenReturn("jane.doe@example.org");
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        downlinkHandler, mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getResources()).thenReturn(new HashMap<>());
    when(lwM2MClient.getSharedAttributes()).thenReturn(new HashMap<>());
    when(lwM2MClient.getResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any()))
        .thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<TransportProtos.TsKvProto> tsKvProtos = new ArrayList<>();
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, tsKvProtos, true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(lwM2MClient).getResourceModel(eq("jane.doe@example.org"), isA(LwM2mModelProvider.class));
    verify(lwM2MClient).getResources();
    verify(lwM2MClient).getSharedAttributes();
    verify(clientContext).getObjectIdByKeyNameFromProfile(isA(LwM2mClient.class), eq(""));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(clientContext).update(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    when(clientContext.getObjectIdByKeyNameFromProfile(Mockito.<LwM2mClient>any(), Mockito.<String>any()))
        .thenReturn("jane.doe@example.org");
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new IllegalArgumentException("[{}] onAttributesUpdate [{}]")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        downlinkHandler, mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getResources()).thenReturn(new HashMap<>());
    when(lwM2MClient.getSharedAttributes()).thenReturn(new HashMap<>());
    when(lwM2MClient.getResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any()))
        .thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<TransportProtos.TsKvProto> tsKvProtos = new ArrayList<>();
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, tsKvProtos, true));
    verify(lwM2MClient).getEndpoint();
    verify(lwM2MClient).getResourceModel(eq("jane.doe@example.org"), isA(LwM2mModelProvider.class));
    verify(lwM2MClient).getResources();
    verify(lwM2MClient).getSharedAttributes();
    verify(clientContext).getObjectIdByKeyNameFromProfile(isA(LwM2mClient.class), eq(""));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(clientContext).update(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getObjectIdByKeyNameFromProfile(Mockito.<LwM2mClient>any(), Mockito.<String>any()))
        .thenReturn(null);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<TransportProtos.TsKvProto> tsKvProtos = new ArrayList<>();
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, tsKvProtos, true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(clientContext).getObjectIdByKeyNameFromProfile(isA(LwM2mClient.class), eq(""));
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    when(clientContext.getObjectIdByKeyNameFromProfile(Mockito.<LwM2mClient>any(), Mockito.<String>any()))
        .thenReturn("jane.doe@example.org");
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        downlinkHandler, mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getResources()).thenReturn(new HashMap<>());
    when(lwM2MClient.getSharedAttributes()).thenReturn(new HashMap<>());
    when(lwM2MClient.getResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any()))
        .thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, false, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<TransportProtos.TsKvProto> tsKvProtos = new ArrayList<>();
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, tsKvProtos, true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(lwM2MClient).getResourceModel(eq("jane.doe@example.org"), isA(LwM2mModelProvider.class));
    verify(lwM2MClient).getResources();
    verify(lwM2MClient).getSharedAttributes();
    verify(clientContext).getObjectIdByKeyNameFromProfile(isA(LwM2mClient.class), eq(""));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(clientContext).update(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)}
   */
  @Test
  void testOnAttributesUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    when(clientContext.getObjectIdByKeyNameFromProfile(Mockito.<LwM2mClient>any(), Mockito.<String>any()))
        .thenReturn("jane.doe@example.org");
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService defaultLwM2MAttributesService = new DefaultLwM2MAttributesService(futures,
        transportService, helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        downlinkHandler, mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getResources()).thenReturn(new HashMap<>());
    when(lwM2MClient.getSharedAttributes()).thenReturn(new HashMap<>());
    when(lwM2MClient.getResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any()))
        .thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<TransportProtos.TsKvProto> tsKvProtos = new ArrayList<>();
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());
    tsKvProtos.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, tsKvProtos, true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(lwM2MClient).getResourceModel(eq("jane.doe@example.org"), isA(LwM2mModelProvider.class));
    verify(lwM2MClient).getResources();
    verify(lwM2MClient, atLeast(1)).getSharedAttributes();
    verify(clientContext, atLeast(1)).getObjectIdByKeyNameFromProfile(isA(LwM2mClient.class), eq(""));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(clientContext).update(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
  }
}
