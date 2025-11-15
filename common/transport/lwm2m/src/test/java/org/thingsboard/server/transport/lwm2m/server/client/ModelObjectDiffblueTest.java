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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ModelObjectDiffblueTest {
  /**
   * Test {@link ModelObject#equals(Object)}, and {@link ModelObject#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelObject#equals(Object)}
   *   <li>{@link ModelObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
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
   * Test {@link ModelObject#equals(Object)}, and {@link ModelObject#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelObject#equals(Object)}
   *   <li>{@link ModelObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
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
   * Test {@link ModelObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
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
   * Test {@link ModelObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ModelObject modelObject = new ModelObject(null, new HashMap<>());
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(objectModel, new HashMap<>()));
  }

  /**
   * Test {@link ModelObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<Integer, LwM2mObjectInstance> instances = new HashMap<>();
    instances.put(1, new LwM2mObjectInstance(new ArrayList<>()));
    ModelObject modelObject = new ModelObject(null, instances);

    // Act and Assert
    assertNotEquals(modelObject, new ModelObject(null, new HashMap<>()));
  }

  /**
   * Test {@link ModelObject#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new ModelObject(objectModel, new HashMap<>()), null);
  }

  /**
   * Test {@link ModelObject#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelObject.equals(Object)", "int ModelObject.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new ModelObject(objectModel, new HashMap<>()), "Different type to ModelObject");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ModelObject.<init>(ObjectModel, Map)", "Map ModelObject.getInstances()",
      "ObjectModel ModelObject.getObjectModel()", "void ModelObject.setInstances(Map)",
      "void ModelObject.setObjectModel(ObjectModel)", "String ModelObject.toString()"})
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

    // Assert
    assertEquals("ModelObject(objectModel=ObjectModel [id=1, name=Name, description=The characteristics of someone or"
        + " something, version=1.0.2, multiple=true, mandatory=true, urn=urn:oma:lwm2m:oma:1:1.0.2, lwm2mVersion=1.0,"
        + " description2=, resources={}], instances={})", actualToStringResult);
    assertTrue(actualInstances.isEmpty());
    assertSame(instances, actualInstances);
    assertSame(objectModel2, actualObjectModel);
  }

  /**
   * Test {@link ModelObject#clone()}.
   * <p>
   * Method under test: {@link ModelObject#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelObject ModelObject.clone()"})
  void testClone() throws CloneNotSupportedException {
    // Arrange
    ObjectModel objectModel = new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true,
        true, new ArrayList<>());

    ModelObject modelObject = new ModelObject(objectModel, new HashMap<>());

    // Act and Assert
    assertEquals(modelObject, modelObject.clone());
  }
}
