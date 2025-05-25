package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class WidgetTypeEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetTypeEntity}
   *   <li>{@link WidgetTypeEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeEntity#toString()}
   *   <li>{@link WidgetTypeEntity#getDescriptor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetTypeEntity.<init>()", "JsonNode WidgetTypeEntity.getDescriptor()",
      "void WidgetTypeEntity.setDescriptor(JsonNode)", "String WidgetTypeEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeEntity actualWidgetTypeEntity = new WidgetTypeEntity();
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeEntity.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetTypeEntity.toString();
    JsonNode actualDescriptor = actualWidgetTypeEntity.getDescriptor();

    // Assert
    assertEquals("WidgetTypeEntity(descriptor={\"isPublic\":true})", actualToStringResult);
    assertNull(actualWidgetTypeEntity.getVersion());
    assertNull(actualWidgetTypeEntity.getFqn());
    assertNull(actualWidgetTypeEntity.getName());
    assertNull(actualWidgetTypeEntity.getId());
    assertNull(actualWidgetTypeEntity.getUuid());
    assertNull(actualWidgetTypeEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeEntity.getCreatedTime());
    assertFalse(actualWidgetTypeEntity.isDeprecated());
    assertFalse(actualWidgetTypeEntity.isScada());
    assertSame(descriptor, actualDescriptor);
  }
}
