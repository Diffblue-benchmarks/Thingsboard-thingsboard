package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class WidgetTypeDetailsEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}
   *   <li>{@link WidgetTypeDetailsEntity#setDescription(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeDetailsEntity#setExternalId(UUID)}
   *   <li>{@link WidgetTypeDetailsEntity#setImage(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setTags(String[])}
   *   <li>{@link WidgetTypeDetailsEntity#toString()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescription()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescriptor()}
   *   <li>{@link WidgetTypeDetailsEntity#getExternalId()}
   *   <li>{@link WidgetTypeDetailsEntity#getImage()}
   *   <li>{@link WidgetTypeDetailsEntity#getTags()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>()", "String WidgetTypeDetailsEntity.getDescription()",
      "JsonNode WidgetTypeDetailsEntity.getDescriptor()", "UUID WidgetTypeDetailsEntity.getExternalId()",
      "String WidgetTypeDetailsEntity.getImage()", "String[] WidgetTypeDetailsEntity.getTags()",
      "void WidgetTypeDetailsEntity.setDescription(String)", "void WidgetTypeDetailsEntity.setDescriptor(JsonNode)",
      "void WidgetTypeDetailsEntity.setExternalId(UUID)", "void WidgetTypeDetailsEntity.setImage(String)",
      "void WidgetTypeDetailsEntity.setTags(String[])", "String WidgetTypeDetailsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    actualWidgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeDetailsEntity.setDescriptor(descriptor);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetTypeDetailsEntity.setExternalId(externalId);
    actualWidgetTypeDetailsEntity.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeDetailsEntity.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetailsEntity.toString();
    String actualDescription = actualWidgetTypeDetailsEntity.getDescription();
    JsonNode actualDescriptor = actualWidgetTypeDetailsEntity.getDescriptor();
    UUID actualExternalId = actualWidgetTypeDetailsEntity.getExternalId();
    String actualImage = actualWidgetTypeDetailsEntity.getImage();
    String[] actualTags = actualWidgetTypeDetailsEntity.getTags();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetTypeDetailsEntity(image=Image, description=The characteristics of someone or something, tags=[Tags],"
            + " descriptor={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
    assertSame(externalId, actualExternalId);
    assertSame(tags, actualTags);
    assertSame(descriptor, actualDescriptor);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }
}
