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
package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.codec.LwM2mValueConverter;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.gen.transport.TransportProtos;

class LwM2mClientDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2mClient#init(ValidateDeviceCredentialsResponse, UUID)}
   */
  @Test
  void testInit() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    ValidateDeviceCredentialsResponse credentials = mock(ValidateDeviceCredentialsResponse.class);
    when(credentials.getDeviceInfo()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.init(credentials, UUID.randomUUID()));
    verify(credentials).getDeviceInfo();
  }

  /**
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  void testSetRegistration() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenThrow(new IllegalArgumentException("/"));
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
  }

  /**
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  void testSetRegistration2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenReturn(new Link[]{new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(1, lwM2mClient.getClientSupportContentFormats().size());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
    assertSame(registration, lwM2mClient.getRegistration());
  }

  /**
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  void testSetRegistration3() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenReturn(new Link[]{new Link("42", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(1, lwM2mClient.getSupportedClientObjects().size());
    assertEquals(1, lwM2mClient.getClientSupportContentFormats().size());
    assertEquals(11542, defaultContentFormat.getCode());
    assertSame(registration, lwM2mClient.getRegistration());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  void testSaveResourceValue() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mMultipleResource resource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("/", resource, modelProvider, WriteRequest.Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  void testSaveResourceValue2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mMultipleResource resource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("42", resource, modelProvider, WriteRequest.Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  void testGetResourceModel() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getResourceModel("/",
        mock(LwM2mModelProvider.class)));
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getResourceModel("42",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  void testGetObjectModel() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("Path Id Ver",
        mock(LwM2mModelProvider.class)));
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("/",
        mock(LwM2mModelProvider.class)));
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel(null,
        mock(LwM2mModelProvider.class)));
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("42",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  void testGetNewResourceForInstance() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourceForInstance("/", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  void testGetNewResourceForInstance2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourceForInstance("42", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  void testGetNewResourcesForInstance() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourcesForInstance("/", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  void testGetNewResourcesForInstance2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourcesForInstance("42", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  void testIsValidObjectVersion() {
    // Arrange, Act and Assert
    assertEquals("Specified object id null absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("/"));
    assertEquals("Specified object id 42 absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("42"));
    assertEquals("Specified object id null absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("//"));
  }

  /**
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  void testGetLwM2mPathFromString() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("/");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  void testGetLwM2mPathFromString2() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("42");

    // Assert
    assertNull(actualLwM2mPathFromString.getObjectInstanceId());
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    LwM2mPath toParenPathResult2 = toParenPathResult.toParenPath();
    assertNull(toParenPathResult2.getResourceId());
    assertNull(actualLwM2mPathFromString.getResourceId());
    assertNull(toParenPathResult.getResourceInstanceId());
    assertNull(toParenPathResult2.getResourceInstanceId());
    assertNull(actualLwM2mPathFromString.getResourceInstanceId());
    assertEquals(42, toMaxDescendantResult.getObjectId().intValue());
    assertEquals(42, toParenPathResult.getObjectId().intValue());
    assertEquals(42, toParenPathResult2.getObjectId().intValue());
    assertEquals(42, actualLwM2mPathFromString.getObjectId().intValue());
    assertEquals(65534, toMaxDescendantResult.getObjectInstanceId().intValue());
    assertEquals(65534, toParenPathResult.getObjectInstanceId().intValue());
    assertEquals(65534, toParenPathResult2.getObjectInstanceId().intValue());
    assertEquals(65535, toMaxDescendantResult.getResourceId().intValue());
    assertEquals(65535, toParenPathResult.getResourceId().intValue());
    assertEquals(65535, toMaxDescendantResult.getResourceInstanceId().intValue());
    assertFalse(toMaxDescendantResult.isObject());
    assertFalse(toParenPathResult.isObject());
    assertFalse(toParenPathResult2.isObject());
    assertFalse(toMaxDescendantResult.isObjectInstance());
    assertFalse(toParenPathResult.isObjectInstance());
    assertFalse(actualLwM2mPathFromString.isObjectInstance());
    assertFalse(toMaxDescendantResult.isResource());
    assertFalse(toParenPathResult2.isResource());
    assertFalse(actualLwM2mPathFromString.isResource());
    assertFalse(toParenPathResult.isResourceInstance());
    assertFalse(toParenPathResult2.isResourceInstance());
    assertFalse(actualLwM2mPathFromString.isResourceInstance());
    assertFalse(toMaxDescendantResult.isRoot());
    assertFalse(toParenPathResult.isRoot());
    assertFalse(toParenPathResult2.isRoot());
    assertFalse(actualLwM2mPathFromString.isRoot());
    assertTrue(actualLwM2mPathFromString.isObject());
    assertTrue(toParenPathResult2.isObjectInstance());
    assertTrue(toParenPathResult.isResource());
    assertTrue(toMaxDescendantResult.isResourceInstance());
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    assertEquals(toMaxDescendantResult2, toParenPathResult2.toMaxDescendant());
    assertEquals(actualLwM2mPathFromString, toParenPathResult2.toParenPath());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
    LwM2mPath expectedToParenPathResult = actualLwM2mPathFromString.ROOTPATH;
    assertSame(expectedToParenPathResult, actualLwM2mPathFromString.toParenPath());
  }

  /**
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  void testGetLwM2mPathFromString3() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("//");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  void testGetDefaultObjectIDVer() {
    // Arrange and Act
    LwM2m.Version actualDefaultObjectIDVer = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getDefaultObjectIDVer();

    // Assert
    assertEquals(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  void testGetDefaultObjectIDVer2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setDefaultObjectIDVer(LwM2m.Version.getDefault());

    // Act
    LwM2m.Version actualDefaultObjectIDVer = lwM2mClient.getDefaultObjectIDVer();

    // Assert
    assertSame(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  void testGetDefaultObjectIDVer3() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setSleepTask(new FutureTask<>(mock(Callable.class)));

    // Act
    LwM2m.Version actualDefaultObjectIDVer = lwM2mClient.getDefaultObjectIDVer();

    // Assert
    assertEquals(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Method under test: {@link LwM2mClient#getSupportedObjectVersion(Integer)}
   */
  @Test
  void testGetSupportedObjectVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getSupportedObjectVersion(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", null);

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient.hashCode());
  }

  /**
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "Endpoint");

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Different type to LwM2mClient");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#setAsleep(boolean)}
   *   <li>{@link LwM2mClient#setDefaultObjectIDVer(LwM2m.Version)}
   *   <li>{@link LwM2mClient#setLastSentRpcId(UUID)}
   *   <li>{@link LwM2mClient#setSleepTask(Future)}
   *   <li>{@link LwM2mClient#setState(LwM2MClientState)}
   *   <li>{@link LwM2mClient#checkFirstDownlink()}
   *   <li>{@link LwM2mClient#toString()}
   *   <li>{@link LwM2mClient#getClientSupportContentFormats()}
   *   <li>{@link LwM2mClient#getDefaultContentFormat()}
   *   <li>{@link LwM2mClient#getDeviceId()}
   *   <li>{@link LwM2mClient#getEdrxCycle()}
   *   <li>{@link LwM2mClient#getEndpoint()}
   *   <li>{@link LwM2mClient#getLastSentRpcId()}
   *   <li>{@link LwM2mClient#getLastUplinkTime()}
   *   <li>{@link LwM2mClient#getNodeId()}
   *   <li>{@link LwM2mClient#getPagingTransmissionWindow()}
   *   <li>{@link LwM2mClient#getPowerMode()}
   *   <li>{@link LwM2mClient#getProfileId()}
   *   <li>{@link LwM2mClient#getPsmActivityTimer()}
   *   <li>{@link LwM2mClient#getRegistration()}
   *   <li>{@link LwM2mClient#getResources()}
   *   <li>{@link LwM2mClient#getRetryAttempts()}
   *   <li>{@link LwM2mClient#getSession()}
   *   <li>{@link LwM2mClient#getSharedAttributes()}
   *   <li>{@link LwM2mClient#getSleepTask()}
   *   <li>{@link LwM2mClient#getState()}
   *   <li>{@link LwM2mClient#getSupportedClientObjects()}
   *   <li>{@link LwM2mClient#getTenantId()}
   *   <li>{@link LwM2mClient#isAsleep()}
   *   <li>{@link LwM2mClient#getKeyTsLatestMap()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mClient.setAsleep(true);
    lwM2mClient.setDefaultObjectIDVer(LwM2m.Version.getDefault());
    UUID lastSentRpcId = UUID.randomUUID();
    lwM2mClient.setLastSentRpcId(lastSentRpcId);
    CompletableFuture<Void> sleepTask = new CompletableFuture<>();
    lwM2mClient.setSleepTask(sleepTask);
    lwM2mClient.setState(LwM2MClientState.CREATED);
    boolean actualCheckFirstDownlinkResult = lwM2mClient.checkFirstDownlink();
    String actualToStringResult = lwM2mClient.toString();
    lwM2mClient.getClientSupportContentFormats();
    lwM2mClient.getDefaultContentFormat();
    lwM2mClient.getDeviceId();
    lwM2mClient.getEdrxCycle();
    String actualEndpoint = lwM2mClient.getEndpoint();
    UUID actualLastSentRpcId = lwM2mClient.getLastSentRpcId();
    long actualLastUplinkTime = lwM2mClient.getLastUplinkTime();
    String actualNodeId = lwM2mClient.getNodeId();
    lwM2mClient.getPagingTransmissionWindow();
    lwM2mClient.getPowerMode();
    lwM2mClient.getProfileId();
    lwM2mClient.getPsmActivityTimer();
    lwM2mClient.getRegistration();
    Map<String, ResourceValue> actualResources = lwM2mClient.getResources();
    AtomicInteger actualRetryAttempts = lwM2mClient.getRetryAttempts();
    lwM2mClient.getSession();
    Map<String, TransportProtos.TsKvProto> actualSharedAttributes = lwM2mClient.getSharedAttributes();
    Future<Void> actualSleepTask = lwM2mClient.getSleepTask();
    LwM2MClientState actualState = lwM2mClient.getState();
    lwM2mClient.getSupportedClientObjects();
    lwM2mClient.getTenantId();
    boolean actualIsAsleepResult = lwM2mClient.isAsleep();

    // Assert that nothing has changed
    boolean actualIsEmptyResult = lwM2mClient.getKeyTsLatestMap().isEmpty();
    boolean actualIsEmptyResult2 = actualResources.isEmpty();
    int actualGetResult = actualRetryAttempts.get();
    int actualAndDecrement = actualRetryAttempts.getAndDecrement();
    int actualAndIncrement = actualRetryAttempts.getAndIncrement();
    assertTrue(actualSleepTask instanceof CompletableFuture);
    assertEquals("42", actualNodeId);
    assertEquals("LwM2mClient(endpoint=https://config.us-east-2.amazonaws.com)", actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertEquals(-1, actualAndIncrement);
    assertEquals(0, actualGetResult);
    assertEquals(0, actualAndDecrement);
    assertEquals(0L, actualLastUplinkTime);
    assertEquals(LwM2MClientState.CREATED, actualState);
    assertTrue(actualIsEmptyResult);
    assertTrue(actualIsEmptyResult2);
    assertTrue(actualSharedAttributes.isEmpty());
    assertTrue(actualCheckFirstDownlinkResult);
    assertTrue(actualIsAsleepResult);
    assertSame(sleepTask, actualSleepTask);
    assertSame(lastSentRpcId, actualLastSentRpcId);
  }
}
