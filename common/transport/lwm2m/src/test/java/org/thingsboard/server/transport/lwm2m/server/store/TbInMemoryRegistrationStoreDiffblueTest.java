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
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mIncompletePath;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.observation.CompositeObservation;
import org.eclipse.leshan.core.observation.Observation;
import org.eclipse.leshan.core.observation.ObservationIdentifier;
import org.eclipse.leshan.core.observation.SingleObservation;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbInMemoryRegistrationStoreDiffblueTest {
  /**
   * Test {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}
   */
  @Test
  @DisplayName("Test new TbInMemoryRegistrationStore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbInMemoryRegistrationStore.<init>()"})
  void testNewTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertFalse(new TbInMemoryRegistrationStore().getAllRegistrations().hasNext());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<LwM2mPath> paths = new ArrayList<>();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    CompositeObservation observation =
        new CompositeObservation(
            id, "42", paths, requestContentFormat, responseContentFormat, context, new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbInMemoryRegistrationStore.addObservation("42", observation, false));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int)} with objectId is one.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test addObservation(String, Observation, boolean); when LwM2mIncompletePath(int) with objectId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation_whenLwM2mIncompletePathWithObjectIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mIncompletePath path = new LwM2mIncompletePath(1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    SingleObservation observation =
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbInMemoryRegistrationStore.addObservation("42", observation, true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <ul>
   *   <li>When {@link LwM2mIncompletePath#LwM2mIncompletePath(int, int)} with objectId is one and
   *       resourceId is one.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test addObservation(String, Observation, boolean); when LwM2mIncompletePath(int, int) with objectId is one and resourceId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation_whenLwM2mIncompletePathWithObjectIdIsOneAndResourceIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mIncompletePath path = new LwM2mIncompletePath(1, 1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    SingleObservation observation =
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbInMemoryRegistrationStore.addObservation("42", observation, true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int)} with objectId is one.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test addObservation(String, Observation, boolean); when LwM2mPath(int) with objectId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation_whenLwM2mPathWithObjectIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mPath path = new LwM2mPath(1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    SingleObservation observation =
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbInMemoryRegistrationStore.addObservation("42", observation, true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <ul>
   *   <li>When {@link LwM2mPath#LwM2mPath(int, int)} with objectId is one and objectInstanceId is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test addObservation(String, Observation, boolean); when LwM2mPath(int, int) with objectId is one and objectInstanceId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation_whenLwM2mPathWithObjectIdIsOneAndObjectInstanceIdIsOne()
      throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mPath path = new LwM2mPath(1, 1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    SingleObservation observation =
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbInMemoryRegistrationStore.addObservation("42", observation, true));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemoryRegistrationStore#addObservation(String, Observation,
   * boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection TbInMemoryRegistrationStore.addObservation(String, Observation, boolean)"
  })
  void testAddObservation_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new TbInMemoryRegistrationStore().addObservation("42", null, true));
  }
}
