package org.thingsboard.server.common.data.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2mObjectDiffblueTest {
  /**
   * Test {@link LwM2mObject#equals(Object)}, and {@link LwM2mObject#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mObject#equals(Object)}
   *   <li>{@link LwM2mObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}, and {@link LwM2mObject#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mObject#equals(Object)}
   *   <li>{@link LwM2mObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test {@link LwM2mObject#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mObject.equals(Object)", "int LwM2mObject.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mObject.<init>()", "int LwM2mObject.getId()",
      "LwM2mInstance[] LwM2mObject.getInstances()", "String LwM2mObject.getKeyId()", "String LwM2mObject.getName()",
      "boolean LwM2mObject.isMandatory()", "boolean LwM2mObject.isMultiple()", "void LwM2mObject.setId(int)",
      "void LwM2mObject.setInstances(LwM2mInstance[])", "void LwM2mObject.setKeyId(String)",
      "void LwM2mObject.setMandatory(boolean)", "void LwM2mObject.setMultiple(boolean)",
      "void LwM2mObject.setName(String)", "String LwM2mObject.toString()"})
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

    // Assert
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
