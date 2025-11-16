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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.link.attributes.AttributeSet;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.node.codec.LwM2mValueConverter;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.request.WriteRequest.Mode;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;

class LwM2mClientDiffblueTest {
  /**
   * Test {@link LwM2mClient#clone()}.
   *
   * <p>Method under test: {@link LwM2mClient#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LwM2mClient.clone()"})
  void testClone() throws CloneNotSupportedException {
    // Arrange, Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").clone());
  }

  /**
   * Test {@link LwM2mClient#LwM2mClient(String, String)}.
   *
   * <p>Method under test: {@link LwM2mClient#LwM2mClient(String, String)}
   */
  @Test
  @DisplayName("Test new LwM2mClient(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.<init>(String, String)"})
  void testNewLwM2mClient() {
    // Arrange and Act
    LwM2mClient actualLwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Assert
    assertEquals("42", actualLwM2mClient.getNodeId());
    assertEquals("https://config.us-east-2.amazonaws.com", actualLwM2mClient.getEndpoint());
    assertNull(actualLwM2mClient.getEdrxCycle());
    assertNull(actualLwM2mClient.getPagingTransmissionWindow());
    assertNull(actualLwM2mClient.getPsmActivityTimer());
    assertNull(actualLwM2mClient.getSupportedClientObjects());
    assertNull(actualLwM2mClient.getClientSupportContentFormats());
    assertNull(actualLwM2mClient.getDeviceId());
    assertNull(actualLwM2mClient.getLastSentRpcId());
    assertNull(actualLwM2mClient.getProfileId());
    assertNull(actualLwM2mClient.getSleepTask());
    assertNull(actualLwM2mClient.getDefaultContentFormat());
    assertNull(actualLwM2mClient.getRegistration());
    assertNull(actualLwM2mClient.getPowerMode());
    assertNull(actualLwM2mClient.getTenantId());
    assertNull(actualLwM2mClient.getSession());
    assertEquals(0L, actualLwM2mClient.getLastUplinkTime());
    assertEquals(LwM2MClientState.CREATED, actualLwM2mClient.getState());
    assertFalse(actualLwM2mClient.isAsleep());
    assertTrue(actualLwM2mClient.getKeyTsLatestMap().isEmpty());
    assertTrue(actualLwM2mClient.getResources().isEmpty());
    assertTrue(actualLwM2mClient.getSharedAttributes().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#init(ValidateDeviceCredentialsResponse, UUID)}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#init(ValidateDeviceCredentialsResponse, UUID)}
   */
  @Test
  @DisplayName(
      "Test init(ValidateDeviceCredentialsResponse, UUID); when randomUUID; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.init(ValidateDeviceCredentialsResponse, UUID)"})
  void testInit_whenRandomUUID_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    ValidateDeviceCredentialsResponse credentials = mock(ValidateDeviceCredentialsResponse.class);
    when(credentials.getDeviceInfo()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> lwM2mClient.init(credentials, UUID.randomUUID()));
    verify(credentials).getDeviceInfo();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getLwM2mVersion()).thenThrow(new IllegalArgumentException());
    Link link = new Link("/", new AttributeSet(new ArrayList<>()));
    when(registration.getObjectLinks()).thenReturn(new Link[] {link});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenThrow(new IllegalArgumentException());
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    Link link = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration3() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    Link link = new Link("/", new AttributeSet(new ArrayList<>()));
    when(registration.getSortedObjectLinks()).thenReturn(new Link[] {link});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    Link link2 = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link2});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration4() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    Link link = new Link("42", new ArrayList<>());
    when(registration.getSortedObjectLinks()).thenReturn(new Link[] {link});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    Link link2 = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link2});

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
    assertEquals(11542, defaultContentFormat.getCode());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration5() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    Link link = new Link("/", new AttributeSet(new ArrayList<>()));
    when(registration.getSortedObjectLinks()).thenReturn(new Link[] {link});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.lastSupported());
    Link link2 = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link2});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TEXT", defaultContentFormat.getName());
    assertEquals("text/plain", defaultContentFormat.getMediaType());
    assertEquals(0, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration6() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setDefaultObjectIDVer(Version.getDefault());

    Registration registration = mock(Registration.class);
    Link link = new Link("42", new ArrayList<>());
    when(registration.getSortedObjectLinks()).thenReturn(new Link[] {link});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    Link link2 = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link2});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    Map<Integer, Version> supportedClientObjects = lwM2mClient.getSupportedClientObjects();
    assertEquals(1, supportedClientObjects.size());
    assertSame(Version.V1_0, supportedClientObjects.get(42));
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Link}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration); given empty array of Link")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration_givenEmptyArrayOfLink() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getLwM2mVersion()).thenThrow(new IllegalArgumentException());
    when(registration.getObjectLinks()).thenReturn(new Link[] {});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getLwM2mVersion()).thenThrow(new IllegalArgumentException());
    Link link = new Link("Uri Reference", new ArrayList<>());
    when(registration.getObjectLinks()).thenReturn(new Link[] {link});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <ul>
   *   <li>When {@link Registration} {@link Registration#getObjectLinks()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName(
      "Test setRegistration(Registration); when Registration getObjectLinks() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration_whenRegistrationGetObjectLinksThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getObjectLinks()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#saveResourceValue(String, LwM2mResource,
   * LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName(
      "Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mClient.saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)"
  })
  void testSaveResourceValue_when42_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mSingleResource resource = LwM2mSingleResource.newBooleanResource(1, true);

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("42", resource, modelProvider, Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#saveResourceValue(String, LwM2mResource,
   * LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName(
      "Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mClient.saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)"
  })
  void testSaveResourceValue_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mSingleResource resource = LwM2mSingleResource.newBooleanResource(1, true);

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("", resource, modelProvider, Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#saveResourceValue(String, LwM2mResource,
   * LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName(
      "Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mClient.saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)"
  })
  void testSaveResourceValue_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mSingleResource resource = LwM2mSingleResource.newBooleanResource(1, true);

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("/", resource, modelProvider, Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ResourceModel LwM2mClient.getResourceModel(String, LwM2mModelProvider)"
  })
  void testGetResourceModel_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getResourceModel("42", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName(
      "Test getResourceModel(String, LwM2mModelProvider); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ResourceModel LwM2mClient.getResourceModel(String, LwM2mModelProvider)"
  })
  void testGetResourceModel_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getResourceModel("", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '/'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ResourceModel LwM2mClient.getResourceModel(String, LwM2mModelProvider)"
  })
  void testGetResourceModel_whenSlash_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getResourceModel("/", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_when42() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("42", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'foo/bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenFooBar() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("foo/bar", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel(null, mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code Path Id Ver}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'Path Id Ver'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenPathIdVer() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("Path Id Ver", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenSlash() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("/", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourceForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourceForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourceForInstance(
                "42", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourceForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourceForInstance_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourceForInstance(
                "", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourceForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourceForInstance_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourceForInstance(
                "/", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourcesForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourcesForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    HashMap<Object, Object> objectObjectMap = new HashMap<>();

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourcesForInstance(
                "42", objectObjectMap, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourcesForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourcesForInstance_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    HashMap<Object, Object> objectObjectMap = new HashMap<>();

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourcesForInstance(
                "", objectObjectMap, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourcesForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourcesForInstance_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    HashMap<Object, Object> objectObjectMap = new HashMap<>();

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourcesForInstance(
                "/", objectObjectMap, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_when42() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id 42 absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("42"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_when422() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id 42 absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .isValidObjectVersion("/42"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id null absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion(""));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_whenSlash() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id null absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("/"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '//'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_whenSlashSlash() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id null absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("//"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    assertEquals(lwM2mClient.hashCode(), lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", null);

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    assertEquals(lwM2mClient.hashCode(), lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "Endpoint");

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
        "Different type to LwM2mClient");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#setAsleep(boolean)}
   *   <li>{@link LwM2mClient#setDefaultObjectIDVer(Version)}
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
   *   <li>{@link LwM2mClient#getKeyTsLatestMap()}
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
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mClient.checkFirstDownlink()",
    "Set LwM2mClient.getClientSupportContentFormats()",
    "ContentFormat LwM2mClient.getDefaultContentFormat()",
    "UUID LwM2mClient.getDeviceId()",
    "Long LwM2mClient.getEdrxCycle()",
    "String LwM2mClient.getEndpoint()",
    "ConcurrentMap LwM2mClient.getKeyTsLatestMap()",
    "UUID LwM2mClient.getLastSentRpcId()",
    "long LwM2mClient.getLastUplinkTime()",
    "String LwM2mClient.getNodeId()",
    "Long LwM2mClient.getPagingTransmissionWindow()",
    "PowerMode LwM2mClient.getPowerMode()",
    "UUID LwM2mClient.getProfileId()",
    "Long LwM2mClient.getPsmActivityTimer()",
    "Registration LwM2mClient.getRegistration()",
    "Map LwM2mClient.getResources()",
    "AtomicInteger LwM2mClient.getRetryAttempts()",
    "TransportProtos.SessionInfoProto LwM2mClient.getSession()",
    "Map LwM2mClient.getSharedAttributes()",
    "Future LwM2mClient.getSleepTask()",
    "LwM2MClientState LwM2mClient.getState()",
    "Map LwM2mClient.getSupportedClientObjects()",
    "TenantId LwM2mClient.getTenantId()",
    "boolean LwM2mClient.isAsleep()",
    "void LwM2mClient.setAsleep(boolean)",
    "void LwM2mClient.setDefaultObjectIDVer(Version)",
    "void LwM2mClient.setLastSentRpcId(UUID)",
    "void LwM2mClient.setSleepTask(Future)",
    "void LwM2mClient.setState(LwM2MClientState)",
    "String LwM2mClient.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mClient.setAsleep(true);
    lwM2mClient.setDefaultObjectIDVer(Version.getDefault());
    UUID lastSentRpcId = UUID.randomUUID();
    lwM2mClient.setLastSentRpcId(lastSentRpcId);
    CompletableFuture<Void> sleepTask = new CompletableFuture<>();
    lwM2mClient.setSleepTask(sleepTask);
    lwM2mClient.setState(LwM2MClientState.CREATED);
    boolean actualCheckFirstDownlinkResult = lwM2mClient.checkFirstDownlink();
    String actualToStringResult = lwM2mClient.toString();
    Set<ContentFormat> actualClientSupportContentFormats =
        lwM2mClient.getClientSupportContentFormats();
    ContentFormat actualDefaultContentFormat = lwM2mClient.getDefaultContentFormat();
    UUID actualDeviceId = lwM2mClient.getDeviceId();
    Long actualEdrxCycle = lwM2mClient.getEdrxCycle();
    String actualEndpoint = lwM2mClient.getEndpoint();
    ConcurrentMap<String, AtomicLong> actualKeyTsLatestMap = lwM2mClient.getKeyTsLatestMap();
    UUID actualLastSentRpcId = lwM2mClient.getLastSentRpcId();
    long actualLastUplinkTime = lwM2mClient.getLastUplinkTime();
    String actualNodeId = lwM2mClient.getNodeId();
    Long actualPagingTransmissionWindow = lwM2mClient.getPagingTransmissionWindow();
    PowerMode actualPowerMode = lwM2mClient.getPowerMode();
    UUID actualProfileId = lwM2mClient.getProfileId();
    Long actualPsmActivityTimer = lwM2mClient.getPsmActivityTimer();
    Registration actualRegistration = lwM2mClient.getRegistration();
    Map<String, ResourceValue> actualResources = lwM2mClient.getResources();
    AtomicInteger actualRetryAttempts = lwM2mClient.getRetryAttempts();
    SessionInfoProto actualSession = lwM2mClient.getSession();
    Map<String, TsKvProto> actualSharedAttributes = lwM2mClient.getSharedAttributes();
    Future<Void> actualSleepTask = lwM2mClient.getSleepTask();
    LwM2MClientState actualState = lwM2mClient.getState();
    Map<Integer, Version> actualSupportedClientObjects = lwM2mClient.getSupportedClientObjects();
    TenantId actualTenantId = lwM2mClient.getTenantId();
    boolean actualIsAsleepResult = lwM2mClient.isAsleep();

    // Assert
    boolean actualIsEmptyResult = actualKeyTsLatestMap.isEmpty();
    boolean actualIsEmptyResult2 = actualResources.isEmpty();
    int actualGetResult = actualRetryAttempts.get();
    int actualAcquire = actualRetryAttempts.getAcquire();
    int actualAndDecrement = actualRetryAttempts.getAndDecrement();
    int actualAndIncrement = actualRetryAttempts.getAndIncrement();
    int actualOpaque = actualRetryAttempts.getOpaque();
    int actualPlain = actualRetryAttempts.getPlain();
    assertTrue(actualSleepTask instanceof CompletableFuture);
    assertEquals("42", actualNodeId);
    assertEquals(
        "LwM2mClient(endpoint=https://config.us-east-2.amazonaws.com)", actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertNull(actualEdrxCycle);
    assertNull(actualPagingTransmissionWindow);
    assertNull(actualPsmActivityTimer);
    assertNull(actualSupportedClientObjects);
    assertNull(actualClientSupportContentFormats);
    assertNull(actualDeviceId);
    assertNull(actualProfileId);
    assertNull(actualDefaultContentFormat);
    assertNull(actualRegistration);
    assertNull(actualPowerMode);
    assertNull(actualTenantId);
    assertNull(actualSession);
    assertEquals(-1, actualAndIncrement);
    assertEquals(0, actualGetResult);
    assertEquals(0, actualAcquire);
    assertEquals(0, actualAndDecrement);
    assertEquals(0, actualOpaque);
    assertEquals(0, actualPlain);
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

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_when42() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("42");

    // Assert
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    LwM2mPath toMaxDescendantResult3 = actualLwM2mPathFromString.toParenPath().toMaxDescendant();
    assertEquals(
        toMaxDescendantResult3.toParenPath().toParenPath().toMaxDescendant(),
        toMaxDescendantResult3.toParenPath().toParenPath().toMaxDescendant());
    assertEquals(actualLwM2mPathFromString, toParenPathResult.toParenPath().toParenPath());
    assertSame(toMaxDescendantResult3.toMaxDescendant(), toMaxDescendantResult3.toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_when422() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("/42");

    // Assert
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    LwM2mPath toMaxDescendantResult3 = actualLwM2mPathFromString.toParenPath().toMaxDescendant();
    assertEquals(
        toMaxDescendantResult3.toParenPath().toParenPath().toMaxDescendant(),
        toMaxDescendantResult3.toParenPath().toParenPath().toMaxDescendant());
    assertEquals(actualLwM2mPathFromString, toParenPathResult.toParenPath().toParenPath());
    assertSame(toMaxDescendantResult3.toMaxDescendant(), toMaxDescendantResult3.toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_whenEmptyString() {
    // Arrange, Act and Assert
    LwM2mPath toMaxDescendantResult =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("")
            .toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    LwM2mPath toParenPathResult2 = toParenPathResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult2.toMaxDescendant());
    assertEquals(
        toMaxDescendantResult2, toParenPathResult2.toParenPath().toParenPath().toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_whenSlash() {
    // Arrange, Act and Assert
    LwM2mPath toMaxDescendantResult =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("/")
            .toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    LwM2mPath toParenPathResult2 = toParenPathResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult2.toMaxDescendant());
    assertEquals(
        toMaxDescendantResult2, toParenPathResult2.toParenPath().toParenPath().toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '//'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_whenSlashSlash() {
    // Arrange, Act and Assert
    LwM2mPath toMaxDescendantResult =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("//")
            .toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    LwM2mPath toParenPathResult2 = toParenPathResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult2.toMaxDescendant());
    assertEquals(
        toMaxDescendantResult2, toParenPathResult2.toParenPath().toParenPath().toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   *
   * <p>Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version LwM2mClient.getDefaultObjectIDVer()"})
  void testGetDefaultObjectIDVer() {
    // Arrange, Act and Assert
    assertEquals(
        Version.V1_0,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").getDefaultObjectIDVer());
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   *
   * <p>Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version LwM2mClient.getDefaultObjectIDVer()"})
  void testGetDefaultObjectIDVer2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setDefaultObjectIDVer(Version.getDefault());

    // Act and Assert
    assertSame(Version.V1_0, lwM2mClient.getDefaultObjectIDVer());
  }

  /**
   * Test {@link LwM2mClient#getSupportedObjectVersion(Integer)}.
   *
   * <p>Method under test: {@link LwM2mClient#getSupportedObjectVersion(Integer)}
   */
  @Test
  @DisplayName("Test getSupportedObjectVersion(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version LwM2mClient.getSupportedObjectVersion(Integer)"})
  void testGetSupportedObjectVersion() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getSupportedObjectVersion(1));
  }
}
