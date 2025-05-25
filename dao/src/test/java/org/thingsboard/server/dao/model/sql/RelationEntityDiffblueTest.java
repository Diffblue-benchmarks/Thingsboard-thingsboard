package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class RelationEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntity#RelationEntity()}
   *   <li>{@link RelationEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RelationEntity#setFromId(UUID)}
   *   <li>{@link RelationEntity#setFromType(String)}
   *   <li>{@link RelationEntity#setRelationType(String)}
   *   <li>{@link RelationEntity#setRelationTypeGroup(String)}
   *   <li>{@link RelationEntity#setToId(UUID)}
   *   <li>{@link RelationEntity#setToType(String)}
   *   <li>{@link RelationEntity#setVersion(Long)}
   *   <li>{@link RelationEntity#toString()}
   *   <li>{@link RelationEntity#getAdditionalInfo()}
   *   <li>{@link RelationEntity#getFromId()}
   *   <li>{@link RelationEntity#getFromType()}
   *   <li>{@link RelationEntity#getRelationType()}
   *   <li>{@link RelationEntity#getRelationTypeGroup()}
   *   <li>{@link RelationEntity#getToId()}
   *   <li>{@link RelationEntity#getToType()}
   *   <li>{@link RelationEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationEntity.<init>()", "JsonNode RelationEntity.getAdditionalInfo()",
      "UUID RelationEntity.getFromId()", "String RelationEntity.getFromType()",
      "String RelationEntity.getRelationType()", "String RelationEntity.getRelationTypeGroup()",
      "UUID RelationEntity.getToId()", "String RelationEntity.getToType()", "Long RelationEntity.getVersion()",
      "void RelationEntity.setAdditionalInfo(JsonNode)", "void RelationEntity.setFromId(UUID)",
      "void RelationEntity.setFromType(String)", "void RelationEntity.setRelationType(String)",
      "void RelationEntity.setRelationTypeGroup(String)", "void RelationEntity.setToId(UUID)",
      "void RelationEntity.setToType(String)", "void RelationEntity.setVersion(Long)",
      "String RelationEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    RelationEntity actualRelationEntity = new RelationEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRelationEntity.setAdditionalInfo(additionalInfo);
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationEntity.setFromId(fromId);
    actualRelationEntity.setFromType("jane.doe@example.org");
    actualRelationEntity.setRelationType("Relation Type");
    actualRelationEntity.setRelationTypeGroup("Relation Type Group");
    UUID toId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationEntity.setToId(toId);
    actualRelationEntity.setToType("To Type");
    actualRelationEntity.setVersion(1L);
    String actualToStringResult = actualRelationEntity.toString();
    JsonNode actualAdditionalInfo = actualRelationEntity.getAdditionalInfo();
    UUID actualFromId = actualRelationEntity.getFromId();
    String actualFromType = actualRelationEntity.getFromType();
    String actualRelationType = actualRelationEntity.getRelationType();
    String actualRelationTypeGroup = actualRelationEntity.getRelationTypeGroup();
    UUID actualToId = actualRelationEntity.getToId();
    String actualToType = actualRelationEntity.getToType();
    Long actualVersion = actualRelationEntity.getVersion();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualToId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationEntity(fromId=784f394c-42b6-435a-983c-b7beff2784f9, fromType=jane.doe@example.org, toId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9, toType=To Type, relationTypeGroup=Relation Type Group, relationType=Relation"
            + " Type, version=1, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("To Type", actualToType);
    assertEquals("jane.doe@example.org", actualFromType);
    assertEquals(1L, actualVersion.longValue());
    assertSame(fromId, actualFromId);
    assertSame(toId, actualToId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
