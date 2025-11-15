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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.junit.jupiter.api.Test;

class ModelObjectDiffblueTest {
  /**
   * Method under test: {@link ModelObject#clone()}
   */
  @Test
  void testClone() throws CloneNotSupportedException {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    ModelObject modelObject = new ModelObject(objectModel, new HashMap<>());

    // Act and Assert
    assertEquals(modelObject, modelObject.clone());
  }

  /**
   * Method under test: {@link ModelObject#clone()}
   */
  @Test
  void testClone2() throws CloneNotSupportedException {
    // Arrange
    HashMap<Integer, LwM2mObjectInstance> instances = new HashMap<>();
    instances.computeIfPresent(1, mock(BiFunction.class));
    ModelObject modelObject = new ModelObject(new ObjectModel(1, "Name", "The characteristics of someone or something",
        "1.0.2", true, true, new ArrayList<>()), instances);

    // Act and Assert
    assertEquals(modelObject, modelObject.clone());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelObject#equals(Object)}
   *   <li>{@link ModelObject#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelObject modelObject = new ModelObject(null, new HashMap<>());
    ModelObject modelObject2 = new ModelObject(null, new HashMap<>());

    // Act and Assert
    assertEquals(modelObject, modelObject2);
    int expectedHashCodeResult = modelObject.hashCode();
    assertEquals(expectedHashCodeResult, modelObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelObject#equals(Object)}
   *   <li>{@link ModelObject#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    ModelObject modelObject = new ModelObject(objectModel, new HashMap<>());

    // Act and Assert
    assertEquals(modelObject, modelObject);
    int expectedHashCodeResult = modelObject.hashCode();
    assertEquals(expectedHashCodeResult, modelObject.hashCode());
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    ModelObject modelObject = new ModelObject(objectModel, new HashMap<>());
    ObjectModel objectModel2 = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(objectModel2, new HashMap<>()));
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ModelObject modelObject = new ModelObject(null, new HashMap<>());
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(objectModel, new HashMap<>()));
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ObjectModel objectModel = mock(ObjectModel.class);
    ModelObject modelObject = new ModelObject(objectModel, new HashMap<>());
    ObjectModel objectModel2 = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(objectModel2, new HashMap<>()));
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<Integer, LwM2mObjectInstance> instances = new HashMap<>();
    instances.put(3, new LwM2mObjectInstance(new ArrayList<>()));
    ModelObject modelObject = new ModelObject(null, instances);

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(null, new HashMap<>()));
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new ModelObject(objectModel, new HashMap<>()), null);
  }

  /**
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new ModelObject(objectModel, new HashMap<>()), "Different type to ModelObject");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelObject#ModelObject(ObjectModel, Map)}
   *   <li>{@link ModelObject#setInstances(Map)}
   *   <li>{@link ModelObject#setObjectModel(ObjectModel)}
   *   <li>{@link ModelObject#toString()}
   *   <li>{@link ModelObject#getInstances()}
   *   <li>{@link ModelObject#getObjectModel()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act
    ModelObject actualModelObject = new ModelObject(objectModel, new HashMap<>());
    HashMap<Integer, LwM2mObjectInstance> instances = new HashMap<>();
    actualModelObject.setInstances(instances);
    ObjectModel objectModel2 = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    actualModelObject.setObjectModel(objectModel2);
    String actualToStringResult = actualModelObject.toString();
    Map<Integer, LwM2mObjectInstance> actualInstances = actualModelObject.getInstances();
    ObjectModel actualObjectModel = actualModelObject.getObjectModel();

    // Assert that nothing has changed
    assertEquals("ModelObject(objectModel=ObjectModel [id=1, name=Name, description=The characteristics of someone or"
        + " something, version=1.0.2, multiple=true, mandatory=true, urn=urn:oma:lwm2m:oma:1:1.0.2, lwm2mVersion=1.0,"
        + " description2=, resources={}], instances={})", actualToStringResult);
    assertTrue(actualInstances.isEmpty());
    assertSame(instances, actualInstances);
    assertSame(objectModel2, actualObjectModel);
  }
}
