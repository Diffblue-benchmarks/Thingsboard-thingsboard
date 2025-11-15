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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mIncompletePath;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.observation.Observation;
import org.eclipse.leshan.core.observation.ObservationIdentifier;
import org.eclipse.leshan.core.observation.SingleObservation;
import org.eclipse.leshan.core.peer.LwM2mIdentity;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.server.registration.Registration;
import org.eclipse.leshan.server.registration.RegistrationUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbInMemoryRegistrationStoreDiffblueTest {
  /**
   * Test {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}
   */
  @Test
  @DisplayName("Test new TbInMemoryRegistrationStore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbInMemoryRegistrationStore.<init>()"})
  void testNewTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertFalse((new TbInMemoryRegistrationStore()).getAllRegistrations().hasNext());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addRegistration(Registration)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addRegistration(Registration)}
   */
  @Test
  @DisplayName("Test addRegistration(Registration); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.server.registration.Deregistration TbInMemoryRegistrationStore.addRegistration(Registration)"})
  void testAddRegistration_thenThrowIllegalStateException() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    LwM2mPeer lwM2mPeer = mock(LwM2mPeer.class);
    when(lwM2mPeer.getIdentity()).thenThrow(new IllegalStateException("foo"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");
    when(registration.getClientTransportData()).thenReturn(lwM2mPeer);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addRegistration(registration));
    verify(lwM2mPeer).getIdentity();
    verify(registration).getClientTransportData();
    verify(registration).getEndpoint();
    verify(registration).getId();
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#updateRegistration(RegistrationUpdate)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#updateRegistration(RegistrationUpdate)}
   */
  @Test
  @DisplayName("Test updateRegistration(RegistrationUpdate); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.server.registration.UpdatedRegistration TbInMemoryRegistrationStore.updateRegistration(RegistrationUpdate)"})
  void testUpdateRegistration_thenReturnNull() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    LwM2mPeer clientTransportData = mock(LwM2mPeer.class);
    HashSet<ContentFormat> supportedContentFormats = new HashSet<>();
    HashMap<Integer, Version> supportedObjects = new HashMap<>();
    HashSet<LwM2mPath> availableInstances = new HashSet<>();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.updateRegistration(new RegistrationUpdate("42", clientTransportData, 1L,
        "42", null, new Link[]{new Link("Uri Reference", new ArrayList<>())}, "Alternate Path", supportedContentFormats,
        supportedObjects, availableInstances, additionalAttributes, new HashMap<>())));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistration(String)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getRegistration(String)}
   */
  @Test
  @DisplayName("Test getRegistration(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Registration TbInMemoryRegistrationStore.getRegistration(String)"})
  void testGetRegistration() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistration("42"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getRegistrationByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Registration TbInMemoryRegistrationStore.getRegistrationByEndpoint(String)"})
  void testGetRegistrationByEndpoint() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistrationByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test getRegistrationByAdress(InetSocketAddress)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Registration TbInMemoryRegistrationStore.getRegistrationByAdress(InetSocketAddress)"})
  void testGetRegistrationByAdress() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getRegistrationByAdress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistrationByIdentity(LwM2mIdentity)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getRegistrationByIdentity(LwM2mIdentity)}
   */
  @Test
  @DisplayName("Test getRegistrationByIdentity(LwM2mIdentity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Registration TbInMemoryRegistrationStore.getRegistrationByIdentity(LwM2mIdentity)"})
  void testGetRegistrationByIdentity() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistrationByIdentity(mock(LwM2mIdentity.class)));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getAllRegistrations()}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getAllRegistrations()}
   */
  @Test
  @DisplayName("Test getAllRegistrations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator TbInMemoryRegistrationStore.getAllRegistrations()"})
  void testGetAllRegistrations() {
    // Arrange, Act and Assert
    assertFalse((new TbInMemoryRegistrationStore()).getAllRegistrations().hasNext());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeRegistration(String)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#removeRegistration(String)}
   */
  @Test
  @DisplayName("Test removeRegistration(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.server.registration.Deregistration TbInMemoryRegistrationStore.removeRegistration(String)"})
  void testRemoveRegistration() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).removeRegistration("42"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", null, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int)} with objectId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when LwM2mIncompletePath(int) with objectId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation_whenLwM2mIncompletePathWithObjectIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mIncompletePath path = new LwM2mIncompletePath(1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int, int)} with objectId is one and resourceId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when LwM2mIncompletePath(int, int) with objectId is one and resourceId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation_whenLwM2mIncompletePathWithObjectIdIsOneAndResourceIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mIncompletePath path = new LwM2mIncompletePath(1, 1);

    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int)} with objectId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when LwM2mPath(int) with objectId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation_whenLwM2mPathWithObjectIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mPath path = new LwM2mPath(1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int, int)} with objectId is one and objectInstanceId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when LwM2mPath(int, int) with objectId is one and objectInstanceId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation_whenLwM2mPathWithObjectIdIsOneAndObjectInstanceIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mPath path = new LwM2mPath(1, 1);

    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"})
  void testAddObservation_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new TbInMemoryRegistrationStore()).addObservation("42", null, true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)} with {@code observationId}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(ObservationIdentifier) with 'observationId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Observation TbInMemoryRegistrationStore.getObservation(ObservationIdentifier)"})
  void testGetObservationWithObservationId() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getObservation(new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)} with {@code registrationId}, {@code observationId}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(String, ObservationIdentifier) with 'registrationId', 'observationId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Observation TbInMemoryRegistrationStore.getObservation(String, ObservationIdentifier)"})
  void testGetObservationWithRegistrationIdObservationId() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(
        tbInMemoryRegistrationStore.getObservation("42", new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getObservations(String)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getObservations(String)}
   */
  @Test
  @DisplayName("Test getObservations(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.getObservations(String)"})
  void testGetObservations() {
    // Arrange and Act
    Collection<Observation> actualObservations = (new TbInMemoryRegistrationStore()).getObservations("42");

    // Assert
    assertTrue(actualObservations instanceof List);
    assertTrue(actualObservations.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeObservations(String)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#removeObservations(String)}
   */
  @Test
  @DisplayName("Test removeObservations(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection TbInMemoryRegistrationStore.removeObservations(String)"})
  void testRemoveObservations() {
    // Arrange and Act
    Collection<Observation> actualRemoveObservationsResult = (new TbInMemoryRegistrationStore())
        .removeObservations("42");

    // Assert
    assertTrue(actualRemoveObservationsResult instanceof List);
    assertTrue(actualRemoveObservationsResult.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}
   */
  @Test
  @DisplayName("Test removeFromMap(Map, Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbInMemoryRegistrationStore.removeFromMap(Map, Object, Object)"})
  void testRemoveFromMap() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertFalse(tbInMemoryRegistrationStore.removeFromMap(new HashMap<>(), "Key", "Value"));
  }
}
