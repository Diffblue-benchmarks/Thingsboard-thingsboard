package org.thingsboard.server.common.data.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;

class ComponentDescriptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptor#ComponentDescriptor(ComponentDescriptorId)}
   *   <li>{@link ComponentDescriptor#setActions(String)}
   *   <li>{@link ComponentDescriptor#setClazz(String)}
   *   <li>{@link ComponentDescriptor#setClusteringMode(ComponentClusteringMode)}
   *   <li>{@link ComponentDescriptor#setConfigurationDescriptor(JsonNode)}
   *   <li>{@link ComponentDescriptor#setConfigurationVersion(int)}
   *   <li>{@link ComponentDescriptor#setHasQueueName(boolean)}
   *   <li>{@link ComponentDescriptor#setName(String)}
   *   <li>{@link ComponentDescriptor#setScope(ComponentScope)}
   *   <li>{@link ComponentDescriptor#setType(ComponentType)}
   *   <li>{@link ComponentDescriptor#toString()}
   *   <li>{@link ComponentDescriptor#getActions()}
   *   <li>{@link ComponentDescriptor#getClazz()}
   *   <li>{@link ComponentDescriptor#getClusteringMode()}
   *   <li>{@link ComponentDescriptor#getConfigurationDescriptor()}
   *   <li>{@link ComponentDescriptor#getConfigurationVersion()}
   *   <li>{@link ComponentDescriptor#getName()}
   *   <li>{@link ComponentDescriptor#getScope()}
   *   <li>{@link ComponentDescriptor#getType()}
   *   <li>{@link ComponentDescriptor#isHasQueueName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ComponentDescriptor.<init>()",
    "void ComponentDescriptor.<init>(ComponentDescriptorId)",
    "String ComponentDescriptor.getActions()",
    "String ComponentDescriptor.getClazz()",
    "ComponentClusteringMode ComponentDescriptor.getClusteringMode()",
    "JsonNode ComponentDescriptor.getConfigurationDescriptor()",
    "int ComponentDescriptor.getConfigurationVersion()",
    "String ComponentDescriptor.getName()",
    "ComponentScope ComponentDescriptor.getScope()",
    "ComponentType ComponentDescriptor.getType()",
    "boolean ComponentDescriptor.isHasQueueName()",
    "void ComponentDescriptor.setActions(String)",
    "void ComponentDescriptor.setClazz(String)",
    "void ComponentDescriptor.setClusteringMode(ComponentClusteringMode)",
    "void ComponentDescriptor.setConfigurationDescriptor(JsonNode)",
    "void ComponentDescriptor.setConfigurationVersion(int)",
    "void ComponentDescriptor.setHasQueueName(boolean)",
    "void ComponentDescriptor.setName(String)",
    "void ComponentDescriptor.setScope(ComponentScope)",
    "void ComponentDescriptor.setType(ComponentType)",
    "String ComponentDescriptor.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ComponentDescriptorId id =
        new ComponentDescriptorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentDescriptor actualComponentDescriptor = new ComponentDescriptor(id);
    actualComponentDescriptor.setActions("Actions");
    actualComponentDescriptor.setClazz("Clazz");
    actualComponentDescriptor.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    DoubleNode configurationDescriptor = DoubleNode.valueOf(10.0d);
    actualComponentDescriptor.setConfigurationDescriptor(configurationDescriptor);
    actualComponentDescriptor.setConfigurationVersion(1);
    actualComponentDescriptor.setHasQueueName(true);
    actualComponentDescriptor.setName("Name");
    actualComponentDescriptor.setScope(ComponentScope.SYSTEM);
    actualComponentDescriptor.setType(ComponentType.ENRICHMENT);
    String actualToStringResult = actualComponentDescriptor.toString();
    String actualActions = actualComponentDescriptor.getActions();
    String actualClazz = actualComponentDescriptor.getClazz();
    ComponentClusteringMode actualClusteringMode = actualComponentDescriptor.getClusteringMode();
    JsonNode actualConfigurationDescriptor = actualComponentDescriptor.getConfigurationDescriptor();
    int actualConfigurationVersion = actualComponentDescriptor.getConfigurationVersion();
    String actualName = actualComponentDescriptor.getName();
    ComponentScope actualScope = actualComponentDescriptor.getScope();
    ComponentType actualType = actualComponentDescriptor.getType();
    boolean actualIsHasQueueNameResult = actualComponentDescriptor.isHasQueueName();

    // Assert
    assertEquals("Actions", actualActions);
    assertEquals("Clazz", actualClazz);
    assertEquals(
        "ComponentDescriptor(type=ENRICHMENT, scope=SYSTEM, clusteringMode=USER_PREFERENCE, name=Name, clazz=Clazz,"
            + " configurationDescriptor=10.0, configurationVersion=1, actions=Actions, hasQueueName=true)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(0L, actualComponentDescriptor.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualClusteringMode);
    assertEquals(ComponentScope.SYSTEM, actualScope);
    assertEquals(ComponentType.ENRICHMENT, actualType);
    assertTrue(actualIsHasQueueNameResult);
    assertSame(id, actualComponentDescriptor.getId());
    assertSame(configurationDescriptor, actualConfigurationDescriptor);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptor#ComponentDescriptor()}
   *   <li>{@link ComponentDescriptor#setActions(String)}
   *   <li>{@link ComponentDescriptor#setClazz(String)}
   *   <li>{@link ComponentDescriptor#setClusteringMode(ComponentClusteringMode)}
   *   <li>{@link ComponentDescriptor#setConfigurationDescriptor(JsonNode)}
   *   <li>{@link ComponentDescriptor#setConfigurationVersion(int)}
   *   <li>{@link ComponentDescriptor#setHasQueueName(boolean)}
   *   <li>{@link ComponentDescriptor#setName(String)}
   *   <li>{@link ComponentDescriptor#setScope(ComponentScope)}
   *   <li>{@link ComponentDescriptor#setType(ComponentType)}
   *   <li>{@link ComponentDescriptor#toString()}
   *   <li>{@link ComponentDescriptor#getActions()}
   *   <li>{@link ComponentDescriptor#getClazz()}
   *   <li>{@link ComponentDescriptor#getClusteringMode()}
   *   <li>{@link ComponentDescriptor#getConfigurationDescriptor()}
   *   <li>{@link ComponentDescriptor#getConfigurationVersion()}
   *   <li>{@link ComponentDescriptor#getName()}
   *   <li>{@link ComponentDescriptor#getScope()}
   *   <li>{@link ComponentDescriptor#getType()}
   *   <li>{@link ComponentDescriptor#isHasQueueName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ComponentDescriptor.<init>()",
    "void ComponentDescriptor.<init>(ComponentDescriptorId)",
    "String ComponentDescriptor.getActions()",
    "String ComponentDescriptor.getClazz()",
    "ComponentClusteringMode ComponentDescriptor.getClusteringMode()",
    "JsonNode ComponentDescriptor.getConfigurationDescriptor()",
    "int ComponentDescriptor.getConfigurationVersion()",
    "String ComponentDescriptor.getName()",
    "ComponentScope ComponentDescriptor.getScope()",
    "ComponentType ComponentDescriptor.getType()",
    "boolean ComponentDescriptor.isHasQueueName()",
    "void ComponentDescriptor.setActions(String)",
    "void ComponentDescriptor.setClazz(String)",
    "void ComponentDescriptor.setClusteringMode(ComponentClusteringMode)",
    "void ComponentDescriptor.setConfigurationDescriptor(JsonNode)",
    "void ComponentDescriptor.setConfigurationVersion(int)",
    "void ComponentDescriptor.setHasQueueName(boolean)",
    "void ComponentDescriptor.setName(String)",
    "void ComponentDescriptor.setScope(ComponentScope)",
    "void ComponentDescriptor.setType(ComponentType)",
    "String ComponentDescriptor.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    ComponentDescriptor actualComponentDescriptor = new ComponentDescriptor();
    actualComponentDescriptor.setActions("Actions");
    actualComponentDescriptor.setClazz("Clazz");
    actualComponentDescriptor.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    DoubleNode configurationDescriptor = DoubleNode.valueOf(10.0d);
    actualComponentDescriptor.setConfigurationDescriptor(configurationDescriptor);
    actualComponentDescriptor.setConfigurationVersion(1);
    actualComponentDescriptor.setHasQueueName(true);
    actualComponentDescriptor.setName("Name");
    actualComponentDescriptor.setScope(ComponentScope.SYSTEM);
    actualComponentDescriptor.setType(ComponentType.ENRICHMENT);
    String actualToStringResult = actualComponentDescriptor.toString();
    String actualActions = actualComponentDescriptor.getActions();
    String actualClazz = actualComponentDescriptor.getClazz();
    ComponentClusteringMode actualClusteringMode = actualComponentDescriptor.getClusteringMode();
    JsonNode actualConfigurationDescriptor = actualComponentDescriptor.getConfigurationDescriptor();
    int actualConfigurationVersion = actualComponentDescriptor.getConfigurationVersion();
    String actualName = actualComponentDescriptor.getName();
    ComponentScope actualScope = actualComponentDescriptor.getScope();
    ComponentType actualType = actualComponentDescriptor.getType();
    boolean actualIsHasQueueNameResult = actualComponentDescriptor.isHasQueueName();

    // Assert
    assertEquals("Actions", actualActions);
    assertEquals("Clazz", actualClazz);
    assertEquals(
        "ComponentDescriptor(type=ENRICHMENT, scope=SYSTEM, clusteringMode=USER_PREFERENCE, name=Name, clazz=Clazz,"
            + " configurationDescriptor=10.0, configurationVersion=1, actions=Actions, hasQueueName=true)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertNull(actualComponentDescriptor.getId());
    assertEquals(0L, actualComponentDescriptor.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualClusteringMode);
    assertEquals(ComponentScope.SYSTEM, actualScope);
    assertEquals(ComponentType.ENRICHMENT, actualType);
    assertTrue(actualIsHasQueueNameResult);
    assertSame(configurationDescriptor, actualConfigurationDescriptor);
  }

  /**
   * Test {@link ComponentDescriptor#ComponentDescriptor(ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ComponentDescriptor#ComponentDescriptor()} HasQueueName is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#ComponentDescriptor(ComponentDescriptor)}
   */
  @Test
  @DisplayName(
      "Test new ComponentDescriptor(ComponentDescriptor); given 'true'; when ComponentDescriptor() HasQueueName is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComponentDescriptor.<init>(ComponentDescriptor)"})
  void testNewComponentDescriptor_givenTrue_whenComponentDescriptorHasQueueNameIsTrue() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setHasQueueName(true);

    // Act and Assert
    assertEquals(plugin, new ComponentDescriptor(plugin));
  }

  /**
   * Test {@link ComponentDescriptor#ComponentDescriptor(ComponentDescriptor)}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptor#ComponentDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#ComponentDescriptor(ComponentDescriptor)}
   */
  @Test
  @DisplayName("Test new ComponentDescriptor(ComponentDescriptor); when ComponentDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComponentDescriptor.<init>(ComponentDescriptor)"})
  void testNewComponentDescriptor_whenComponentDescriptor() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();

    // Act and Assert
    assertEquals(plugin, new ComponentDescriptor(plugin));
  }

  /**
   * Test {@link ComponentDescriptor#getId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptorId ComponentDescriptor.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ComponentDescriptor().getId());
  }

  /**
   * Test {@link ComponentDescriptor#getCreatedTime()}.
   *
   * <p>Method under test: {@link ComponentDescriptor#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ComponentDescriptor.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new ComponentDescriptor().getCreatedTime());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}, and {@link ComponentDescriptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptor#equals(Object)}
   *   <li>{@link ComponentDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    ComponentDescriptor componentDescriptor2 = new ComponentDescriptor();

    // Act and Assert
    assertEquals(componentDescriptor, componentDescriptor2);
    int expectedHashCodeResult = componentDescriptor.hashCode();
    assertEquals(expectedHashCodeResult, componentDescriptor2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}, and {@link ComponentDescriptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptor#equals(Object)}
   *   <li>{@link ComponentDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();

    // Act and Assert
    assertEquals(componentDescriptor, componentDescriptor);
    int expectedHashCodeResult = componentDescriptor.hashCode();
    assertEquals(expectedHashCodeResult, componentDescriptor.hashCode());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComponentDescriptor(), 1);
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setType(ComponentType.ENRICHMENT);

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setScope(ComponentScope.SYSTEM);

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setName("Name");

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setConfigurationDescriptor(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setConfigurationVersion(1);

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setActions("Actions");

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    componentDescriptor.setHasQueueName(true);

    // Act and Assert
    assertNotEquals(componentDescriptor, new ComponentDescriptor());
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();

    ComponentDescriptor componentDescriptor2 = new ComponentDescriptor();
    componentDescriptor2.setHasQueueName(true);

    // Act and Assert
    assertNotEquals(componentDescriptor, componentDescriptor2);
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComponentDescriptor(), null);
  }

  /**
   * Test {@link ComponentDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ComponentDescriptor.equals(Object)",
    "int ComponentDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComponentDescriptor(), "Different type to ComponentDescriptor");
  }
}
