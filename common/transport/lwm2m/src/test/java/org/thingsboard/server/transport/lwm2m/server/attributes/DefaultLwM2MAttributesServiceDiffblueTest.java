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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.LazyStringArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultLwM2MAttributesServiceDiffblueTest {
  @InjectMocks private DefaultLwM2MAttributesService defaultLwM2MAttributesService;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private Map<Integer, SettableFuture<List<TsKvProto>>> map;

  @Mock private TransportService transportService;

  /**
   * Test {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getSharedAttributes(LwM2mClient, Collection); given 'foo'; when ArrayList() add 'foo'; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DefaultLwM2MAttributesService.getSharedAttributes(LwM2mClient, Collection)"
  })
  void testGetSharedAttributes_givenFoo_whenArrayListAddFoo_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<TsKvProto>> createResult = SettableFuture.create();
    when(map.put(Mockito.<Integer>any(), Mockito.<SettableFuture<List<TsKvProto>>>any()))
        .thenReturn(createResult);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    ListenableFuture<List<TsKvProto>> actualSharedAttributes =
        defaultLwM2MAttributesService.getSharedAttributes(client, keys);

    // Assert
    verify(map).put(eq(1), isA(SettableFuture.class));
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getSharedAttributes(LwM2mClient, Collection); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DefaultLwM2MAttributesService.getSharedAttributes(LwM2mClient, Collection)"
  })
  void testGetSharedAttributes_thenThrowIllegalArgumentException() {
    // Arrange
    SettableFuture<List<TsKvProto>> createResult = SettableFuture.create();
    when(map.put(Mockito.<Integer>any(), Mockito.<SettableFuture<List<TsKvProto>>>any()))
        .thenReturn(createResult);
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultLwM2MAttributesService.getSharedAttributes(client, new ArrayList<>()));
    verify(map).put(eq(1), isA(SettableFuture.class));
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getSharedAttributes(LwM2mClient, Collection); when ArrayList(); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DefaultLwM2MAttributesService.getSharedAttributes(LwM2mClient, Collection)"
  })
  void testGetSharedAttributes_whenArrayList_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<TsKvProto>> createResult = SettableFuture.create();
    when(map.put(Mockito.<Integer>any(), Mockito.<SettableFuture<List<TsKvProto>>>any()))
        .thenReturn(createResult);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    ListenableFuture<List<TsKvProto>> actualSharedAttributes =
        defaultLwM2MAttributesService.getSharedAttributes(client, new ArrayList<>());

    // Assert
    verify(map).put(eq(1), isA(SettableFuture.class));
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   *
   * <ul>
   *   <li>When emptyList.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#getSharedAttributes(LwM2mClient,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getSharedAttributes(LwM2mClient, Collection); when emptyList; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DefaultLwM2MAttributesService.getSharedAttributes(LwM2mClient, Collection)"
  })
  void testGetSharedAttributes_whenEmptyList_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<TsKvProto>> createResult = SettableFuture.create();
    when(map.put(Mockito.<Integer>any(), Mockito.<SettableFuture<List<TsKvProto>>>any()))
        .thenReturn(createResult);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    ListenableFuture<List<TsKvProto>> actualSharedAttributes =
        defaultLwM2MAttributesService.getSharedAttributes(client, LazyStringArrayList.emptyList());

    // Assert
    verify(map).put(eq(1), isA(SettableFuture.class));
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    assertTrue(actualSharedAttributes instanceof SettableFuture);
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#remove(Object)} return create.
   *   <li>Then calls {@link Map#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg, SessionInfoProto); given Map remove(Object) return create; then calls remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onGetAttributesResponse(GetAttributeResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnGetAttributesResponse_givenMapRemoveReturnCreate_thenCallsRemove() {
    // Arrange
    SettableFuture<List<TsKvProto>> createResult = SettableFuture.create();
    when(map.remove(Mockito.<Object>any())).thenReturn(createResult);

    // Act
    defaultLwM2MAttributesService.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(map).remove(isA(Object.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#remove(Object)} return {@code null}.
   *   <li>Then calls {@link Map#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg, SessionInfoProto); given Map remove(Object) return 'null'; then calls remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onGetAttributesResponse(GetAttributeResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnGetAttributesResponse_givenMapRemoveReturnNull_thenCallsRemove() {
    // Arrange
    when(map.remove(Mockito.<Object>any())).thenReturn(null);

    // Act
    defaultLwM2MAttributesService.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(map).remove(isA(Object.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@link SettableFuture} {@link SettableFuture#set(Object)} return {@code true}.
   *   <li>Then calls {@link SettableFuture#set(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg, SessionInfoProto); given SettableFuture set(Object) return 'true'; then calls set(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onGetAttributesResponse(GetAttributeResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnGetAttributesResponse_givenSettableFutureSetReturnTrue_thenCallsSet() {
    // Arrange
    SettableFuture<List<TsKvProto>> settableFuture = mock(SettableFuture.class);
    when(settableFuture.set(Mockito.<List<TsKvProto>>any())).thenReturn(true);
    when(map.remove(Mockito.<Object>any())).thenReturn(settableFuture);

    // Act
    defaultLwM2MAttributesService.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(settableFuture).set(isA(List.class));
    verify(map).remove(isA(Object.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onGetAttributesResponse(GetAttributeResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg, SessionInfoProto); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onGetAttributesResponse(GetAttributeResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnGetAttributesResponse_thenThrowIllegalArgumentException() {
    // Arrange
    SettableFuture<List<TsKvProto>> settableFuture = mock(SettableFuture.class);
    when(settableFuture.set(Mockito.<List<TsKvProto>>any()))
        .thenThrow(new IllegalArgumentException());
    when(map.remove(Mockito.<Object>any())).thenReturn(settableFuture);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MAttributesService.onGetAttributesResponse(
                GetAttributeResponseMsg.getDefaultInstance(),
                SessionInfoProto.getDefaultInstance()));
    verify(settableFuture).set(isA(List.class));
    verify(map).remove(isA(Object.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient lwM2MClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(lwM2mClientContext)
        .update(Mockito.<LwM2mClient>any());
    LwM2mClient lwM2MClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue3() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * SessionInfoProto)} with {@code msg}, {@code sessionInfo}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(AttributeUpdateNotificationMsg, SessionInfoProto) with 'msg', 'sessionInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnAttributesUpdateWithMsgSessionInfo() {
    // Arrange
    when(lwM2mClientContext.getClientBySessionInfo(Mockito.<SessionInfoProto>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(
        AttributeUpdateNotificationMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(lwM2mClientContext).getClientBySessionInfo(isA(SessionInfoProto.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * SessionInfoProto)} with {@code msg}, {@code sessionInfo}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(AttributeUpdateNotificationMsg, SessionInfoProto) with 'msg', 'sessionInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnAttributesUpdateWithMsgSessionInfo2() {
    // Arrange
    when(lwM2mClientContext.getClientBySessionInfo(Mockito.<SessionInfoProto>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MAttributesService.onAttributesUpdate(
                AttributeUpdateNotificationMsg.getDefaultInstance(),
                SessionInfoProto.getDefaultInstance()));
    verify(lwM2mClientContext).getClientBySessionInfo(isA(SessionInfoProto.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * SessionInfoProto)} with {@code msg}, {@code sessionInfo}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(AttributeUpdateNotificationMsg, SessionInfoProto) with 'msg', 'sessionInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnAttributesUpdateWithMsgSessionInfo3() {
    // Arrange
    when(lwM2mClientContext.getClientBySessionInfo(Mockito.<SessionInfoProto>any()))
        .thenReturn(null);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(msg, SessionInfoProto.getDefaultInstance());

    // Assert
    verify(msg).getSharedUpdatedCount();
    verify(lwM2mClientContext).getClientBySessionInfo(isA(SessionInfoProto.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * SessionInfoProto)} with {@code msg}, {@code sessionInfo}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(AttributeUpdateNotificationMsg, SessionInfoProto) with 'msg', 'sessionInfo'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnAttributesUpdateWithMsgSessionInfo_givenArrayList() {
    // Arrange
    when(lwM2mClientContext.getClientBySessionInfo(Mockito.<SessionInfoProto>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(msg, SessionInfoProto.getDefaultInstance());

    // Assert
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    verify(lwM2mClientContext).getClientBySessionInfo(isA(SessionInfoProto.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * SessionInfoProto)} with {@code msg}, {@code sessionInfo}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MAttributesService#onAttributesUpdate(AttributeUpdateNotificationMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(AttributeUpdateNotificationMsg, SessionInfoProto) with 'msg', 'sessionInfo'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(AttributeUpdateNotificationMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnAttributesUpdateWithMsgSessionInfo_givenIllegalArgumentException() {
    // Arrange
    when(lwM2mClientContext.getClientBySessionInfo(Mockito.<SessionInfoProto>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedUpdatedList()).thenThrow(new IllegalArgumentException());
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MAttributesService.onAttributesUpdate(
                msg, SessionInfoProto.getDefaultInstance()));
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    verify(lwM2mClientContext).getClientBySessionInfo(isA(SessionInfoProto.class));
  }
}
