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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.LwM2mResourceInstance;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.request.WriteRequest;
import org.junit.jupiter.api.Test;

class ResourceValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceValue#equals(Object)}
   *   <li>{@link ResourceValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    // Act and Assert
    assertEquals(resourceValue, resourceValue);
    int expectedHashCodeResult = resourceValue.hashCode();
    assertEquals(expectedHashCodeResult, resourceValue.hashCode());
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    // Act
    resourceValue.updateLwM2mResource(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()),
        WriteRequest.Mode.REPLACE);

    // Assert that nothing has changed
    assertNull(resourceValue.getLwM2mResource());
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource2() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource3() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(2, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource4() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newBooleanResource(1, true);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource5() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    // Act
    resourceValue.updateLwM2mResource(null, WriteRequest.Mode.REPLACE);

    // Assert that nothing has changed
    assertNull(resourceValue.getLwM2mResource());
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource6() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newFloatResource(1, 10.0d);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource7() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newIntegerResource(1, 42L);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource8() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    instances2.add(LwM2mResourceInstance.newBooleanInstance(1, true));

    // Act
    resourceValue.updateLwM2mResource(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances2),
        WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource2 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource9() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    LwM2mResourceInstance newBooleanInstanceResult = LwM2mResourceInstance.newBooleanInstance(2, true);
    instances.add(newBooleanInstanceResult);
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    LwM2mResourceInstance newBooleanInstanceResult2 = LwM2mResourceInstance.newBooleanInstance(1, true);
    instances2.add(newBooleanInstanceResult2);

    // Act
    resourceValue.updateLwM2mResource(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances2),
        WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource2 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(1, lwM2mResource2.getId());
    Map<Integer, LwM2mResourceInstance> instances3 = lwM2mResource2.getInstances();
    assertEquals(2, instances3.size());
    assertEquals(ResourceModel.Type.NONE, lwM2mResource2.getType());
    assertTrue(lwM2mResource2.isMultiInstances());
    assertSame(newBooleanInstanceResult2, instances3.get(1));
    assertSame(newBooleanInstanceResult, instances3.get(2));
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource10() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(2, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    instances2.add(LwM2mResourceInstance.newBooleanInstance(1, true));

    // Act
    resourceValue.updateLwM2mResource(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances2),
        WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource2 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource11() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(0, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    instances2.add(LwM2mResourceInstance.newBooleanInstance(1, true));

    // Act
    resourceValue.updateLwM2mResource(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances2),
        WriteRequest.Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource2 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Method under test:
   * {@link ResourceValue#updateLwM2mResource(LwM2mResource, WriteRequest.Mode)}
   */
  @Test
  void testUpdateLwM2mResource12() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, null);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource2, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource2, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource2, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceValue resourceValue = new ResourceValue(
        new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()), null);
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource2, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    instances2.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances2);

    // Act and Assert
    assertNotEquals(resourceValue,
        new ResourceValue(lwM2mResource2, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")),
        null);
  }

  /**
   * Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        new ResourceValue(lwM2mResource,
            new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
                "Range Enumeration", "Units", "The characteristics of someone or something")),
        "Different type to ResourceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceValue#setLwM2mResource(LwM2mResource)}
   *   <li>{@link ResourceValue#setResourceModel(ResourceModel)}
   *   <li>{@link ResourceValue#toString()}
   *   <li>{@link ResourceValue#getLwM2mResource()}
   *   <li>{@link ResourceValue#getResourceModel()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    // Act
    resourceValue.setLwM2mResource(lwM2mResource2);
    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    resourceValue.setResourceModel(resourceModel);
    String actualToStringResult = resourceValue.toString();
    LwM2mResource actualLwM2mResource = resourceValue.getLwM2mResource();

    // Assert that nothing has changed
    assertEquals(
        "ResourceValue(lwM2mResource=LwM2mMultipleResource [id=1, values={}, type=NONE], resourceModel=ResourceDesc"
            + " [id=1, name=Name, operations=NONE, multiple=true, mandatory=true, type=NONE, rangeEnumeration=Range"
            + " Enumeration, units=Units, description=The characteristics of someone or something])",
        actualToStringResult);
    assertSame(resourceModel, resourceValue.getResourceModel());
    assertSame(lwM2mResource2, actualLwM2mResource);
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue() {
    // Arrange
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    assertNull(actualResourceValue.getLwM2mResource());
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue2() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue3() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(2, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue4() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newBooleanResource(1, true);
    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue5() {
    // Arrange
    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(null, resourceModel);

    // Assert
    assertNull(actualResourceValue.getLwM2mResource());
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue6() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newFloatResource(1, 10.0d);
    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Method under test:
   * {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  void testNewResourceValue7() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newIntegerResource(1, 42L);
    ResourceModel resourceModel = new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
        ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }
}
