package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.plugin.ComponentClusteringMode;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class ComponentDescriptorEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#ComponentDescriptorEntity()}
   *   <li>{@link ComponentDescriptorEntity#setActions(String)}
   *   <li>{@link ComponentDescriptorEntity#setClazz(String)}
   *   <li>{@link ComponentDescriptorEntity#setClusteringMode(ComponentClusteringMode)}
   *   <li>{@link ComponentDescriptorEntity#setConfigurationDescriptor(JsonNode)}
   *   <li>{@link ComponentDescriptorEntity#setConfigurationVersion(int)}
   *   <li>{@link ComponentDescriptorEntity#setHasQueueName(boolean)}
   *   <li>{@link ComponentDescriptorEntity#setName(String)}
   *   <li>{@link ComponentDescriptorEntity#setScope(ComponentScope)}
   *   <li>{@link ComponentDescriptorEntity#setType(ComponentType)}
   *   <li>{@link ComponentDescriptorEntity#toString()}
   *   <li>{@link ComponentDescriptorEntity#getActions()}
   *   <li>{@link ComponentDescriptorEntity#getClazz()}
   *   <li>{@link ComponentDescriptorEntity#getClusteringMode()}
   *   <li>{@link ComponentDescriptorEntity#getConfigurationDescriptor()}
   *   <li>{@link ComponentDescriptorEntity#getConfigurationVersion()}
   *   <li>{@link ComponentDescriptorEntity#getName()}
   *   <li>{@link ComponentDescriptorEntity#getScope()}
   *   <li>{@link ComponentDescriptorEntity#getType()}
   *   <li>{@link ComponentDescriptorEntity#isHasQueueName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ComponentDescriptorEntity.<init>()", "String ComponentDescriptorEntity.getActions()",
      "String ComponentDescriptorEntity.getClazz()",
      "ComponentClusteringMode ComponentDescriptorEntity.getClusteringMode()",
      "JsonNode ComponentDescriptorEntity.getConfigurationDescriptor()",
      "int ComponentDescriptorEntity.getConfigurationVersion()", "String ComponentDescriptorEntity.getName()",
      "ComponentScope ComponentDescriptorEntity.getScope()", "ComponentType ComponentDescriptorEntity.getType()",
      "boolean ComponentDescriptorEntity.isHasQueueName()", "void ComponentDescriptorEntity.setActions(String)",
      "void ComponentDescriptorEntity.setClazz(String)",
      "void ComponentDescriptorEntity.setClusteringMode(ComponentClusteringMode)",
      "void ComponentDescriptorEntity.setConfigurationDescriptor(JsonNode)",
      "void ComponentDescriptorEntity.setConfigurationVersion(int)",
      "void ComponentDescriptorEntity.setHasQueueName(boolean)", "void ComponentDescriptorEntity.setName(String)",
      "void ComponentDescriptorEntity.setScope(ComponentScope)",
      "void ComponentDescriptorEntity.setType(ComponentType)", "String ComponentDescriptorEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ComponentDescriptorEntity actualComponentDescriptorEntity = new ComponentDescriptorEntity();
    actualComponentDescriptorEntity.setActions("Actions");
    actualComponentDescriptorEntity.setClazz("Clazz");
    actualComponentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    JsonNode configurationDescriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualComponentDescriptorEntity.setConfigurationDescriptor(configurationDescriptor);
    actualComponentDescriptorEntity.setConfigurationVersion(1);
    actualComponentDescriptorEntity.setHasQueueName(true);
    actualComponentDescriptorEntity.setName("Name");
    actualComponentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    actualComponentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    String actualToStringResult = actualComponentDescriptorEntity.toString();
    String actualActions = actualComponentDescriptorEntity.getActions();
    String actualClazz = actualComponentDescriptorEntity.getClazz();
    ComponentClusteringMode actualClusteringMode = actualComponentDescriptorEntity.getClusteringMode();
    JsonNode actualConfigurationDescriptor = actualComponentDescriptorEntity.getConfigurationDescriptor();
    int actualConfigurationVersion = actualComponentDescriptorEntity.getConfigurationVersion();
    String actualName = actualComponentDescriptorEntity.getName();
    ComponentScope actualScope = actualComponentDescriptorEntity.getScope();
    ComponentType actualType = actualComponentDescriptorEntity.getType();
    boolean actualIsHasQueueNameResult = actualComponentDescriptorEntity.isHasQueueName();

    // Assert
    assertEquals("Actions", actualActions);
    assertEquals("Clazz", actualClazz);
    assertEquals("ComponentDescriptorEntity(type=ENRICHMENT, scope=SYSTEM, clusteringMode=USER_PREFERENCE, name=Name,"
        + " clazz=Clazz, configurationDescriptor={\"isPublic\":true}, configurationVersion=1, actions=Actions,"
        + " hasQueueName=true)", actualToStringResult);
    assertEquals("Name", actualName);
    assertNull(actualComponentDescriptorEntity.getId());
    assertNull(actualComponentDescriptorEntity.getUuid());
    assertEquals(0L, actualComponentDescriptorEntity.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualClusteringMode);
    assertEquals(ComponentScope.SYSTEM, actualScope);
    assertEquals(ComponentType.ENRICHMENT, actualType);
    assertTrue(actualIsHasQueueNameResult);
    assertSame(configurationDescriptor, actualConfigurationDescriptor);
  }
}
