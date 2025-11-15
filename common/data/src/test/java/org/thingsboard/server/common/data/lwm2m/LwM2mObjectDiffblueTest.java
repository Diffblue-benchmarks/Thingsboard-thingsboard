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
package org.thingsboard.server.common.data.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2mObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mObject#equals(Object)}
   *   <li>{@link LwM2mObject#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertEquals(lwM2mObject, lwM2mObject2);
    int expectedHashCodeResult = lwM2mObject.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mObject#equals(Object)}
   *   <li>{@link LwM2mObject#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    // Act and Assert
    assertEquals(lwM2mObject, lwM2mObject);
    int expectedHashCodeResult = lwM2mObject.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mObject.hashCode());
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(2);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("Name");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId(null);
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(false);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(false);
    lwM2mObject.setName("Name");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("42");

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2mInstance lwM2mInstance = mock(LwM2mInstance.class);
    doNothing().when(lwM2mInstance).setId(anyInt());
    doNothing().when(lwM2mInstance).setResources(Mockito.<LwM2mResourceObserve[]>any());
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName(null);

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject2 = new LwM2mObject();
    lwM2mObject2.setId(1);
    lwM2mObject2.setInstances(new LwM2mInstance[]{lwM2mInstance2});
    lwM2mObject2.setKeyId("42");
    lwM2mObject2.setMandatory(true);
    lwM2mObject2.setMultiple(true);
    lwM2mObject2.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, lwM2mObject2);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, null);
  }

  /**
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mObject lwM2mObject = new LwM2mObject();
    lwM2mObject.setId(1);
    lwM2mObject.setInstances(new LwM2mInstance[]{lwM2mInstance});
    lwM2mObject.setKeyId("42");
    lwM2mObject.setMandatory(true);
    lwM2mObject.setMultiple(true);
    lwM2mObject.setName("Name");

    // Act and Assert
    assertNotEquals(lwM2mObject, "Different type to LwM2mObject");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mObject}
   *   <li>{@link LwM2mObject#setId(int)}
   *   <li>{@link LwM2mObject#setInstances(LwM2mInstance[])}
   *   <li>{@link LwM2mObject#setKeyId(String)}
   *   <li>{@link LwM2mObject#setMandatory(boolean)}
   *   <li>{@link LwM2mObject#setMultiple(boolean)}
   *   <li>{@link LwM2mObject#setName(String)}
   *   <li>{@link LwM2mObject#toString()}
   *   <li>{@link LwM2mObject#getId()}
   *   <li>{@link LwM2mObject#getInstances()}
   *   <li>{@link LwM2mObject#getKeyId()}
   *   <li>{@link LwM2mObject#getName()}
   *   <li>{@link LwM2mObject#isMandatory()}
   *   <li>{@link LwM2mObject#isMultiple()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mObject actualLwM2mObject = new LwM2mObject();
    actualLwM2mObject.setId(1);
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});
    LwM2mInstance[] instances = new LwM2mInstance[]{lwM2mInstance};
    actualLwM2mObject.setInstances(instances);
    actualLwM2mObject.setKeyId("42");
    actualLwM2mObject.setMandatory(true);
    actualLwM2mObject.setMultiple(true);
    actualLwM2mObject.setName("Name");
    String actualToStringResult = actualLwM2mObject.toString();
    int actualId = actualLwM2mObject.getId();
    LwM2mInstance[] actualInstances = actualLwM2mObject.getInstances();
    String actualKeyId = actualLwM2mObject.getKeyId();
    String actualName = actualLwM2mObject.getName();
    boolean actualIsMandatoryResult = actualLwM2mObject.isMandatory();

    // Assert that nothing has changed
    assertEquals("42", actualKeyId);
    assertEquals("LwM2mObject(id=1, keyId=42, name=Name, multiple=true, mandatory=true, instances=[LwM2mInstance(id=1,"
        + " resources=[LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true, telemetry=true,"
        + " keyName=name)])])", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1, actualId);
    assertTrue(actualIsMandatoryResult);
    assertTrue(actualLwM2mObject.isMultiple());
    assertSame(instances, actualInstances);
  }
}
