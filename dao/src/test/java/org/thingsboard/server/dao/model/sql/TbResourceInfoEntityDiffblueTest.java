package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class TbResourceInfoEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoEntity#TbResourceInfoEntity()}
   *   <li>{@link TbResourceInfoEntity#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfoEntity#setEtag(String)}
   *   <li>{@link TbResourceInfoEntity#setExternalId(UUID)}
   *   <li>{@link TbResourceInfoEntity#setFileName(String)}
   *   <li>{@link TbResourceInfoEntity#setIsPublic(Boolean)}
   *   <li>{@link TbResourceInfoEntity#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceKey(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceSubType(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceType(String)}
   *   <li>{@link TbResourceInfoEntity#setSearchText(String)}
   *   <li>{@link TbResourceInfoEntity#setTenantId(UUID)}
   *   <li>{@link TbResourceInfoEntity#setTitle(String)}
   *   <li>{@link TbResourceInfoEntity#toString()}
   *   <li>{@link TbResourceInfoEntity#getDescriptor()}
   *   <li>{@link TbResourceInfoEntity#getEtag()}
   *   <li>{@link TbResourceInfoEntity#getExternalId()}
   *   <li>{@link TbResourceInfoEntity#getFileName()}
   *   <li>{@link TbResourceInfoEntity#getIsPublic()}
   *   <li>{@link TbResourceInfoEntity#getPublicResourceKey()}
   *   <li>{@link TbResourceInfoEntity#getResourceKey()}
   *   <li>{@link TbResourceInfoEntity#getResourceSubType()}
   *   <li>{@link TbResourceInfoEntity#getResourceType()}
   *   <li>{@link TbResourceInfoEntity#getSearchText()}
   *   <li>{@link TbResourceInfoEntity#getTenantId()}
   *   <li>{@link TbResourceInfoEntity#getTitle()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceInfoEntity.<init>()", "JsonNode TbResourceInfoEntity.getDescriptor()",
      "String TbResourceInfoEntity.getEtag()", "UUID TbResourceInfoEntity.getExternalId()",
      "String TbResourceInfoEntity.getFileName()", "Boolean TbResourceInfoEntity.getIsPublic()",
      "String TbResourceInfoEntity.getPublicResourceKey()", "String TbResourceInfoEntity.getResourceKey()",
      "String TbResourceInfoEntity.getResourceSubType()", "String TbResourceInfoEntity.getResourceType()",
      "String TbResourceInfoEntity.getSearchText()", "UUID TbResourceInfoEntity.getTenantId()",
      "String TbResourceInfoEntity.getTitle()", "void TbResourceInfoEntity.setDescriptor(JsonNode)",
      "void TbResourceInfoEntity.setEtag(String)", "void TbResourceInfoEntity.setExternalId(UUID)",
      "void TbResourceInfoEntity.setFileName(String)", "void TbResourceInfoEntity.setIsPublic(Boolean)",
      "void TbResourceInfoEntity.setPublicResourceKey(String)", "void TbResourceInfoEntity.setResourceKey(String)",
      "void TbResourceInfoEntity.setResourceSubType(String)", "void TbResourceInfoEntity.setResourceType(String)",
      "void TbResourceInfoEntity.setSearchText(String)", "void TbResourceInfoEntity.setTenantId(UUID)",
      "void TbResourceInfoEntity.setTitle(String)", "String TbResourceInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity();
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTbResourceInfoEntity.setDescriptor(descriptor);
    actualTbResourceInfoEntity.setEtag("Etag");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceInfoEntity.setExternalId(externalId);
    actualTbResourceInfoEntity.setFileName("foo.txt");
    actualTbResourceInfoEntity.setIsPublic(true);
    actualTbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfoEntity.setResourceKey("Resource Key");
    actualTbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    actualTbResourceInfoEntity.setResourceType("Resource Type");
    actualTbResourceInfoEntity.setSearchText("Search Text");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceInfoEntity.setTenantId(tenantId);
    actualTbResourceInfoEntity.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfoEntity.toString();
    JsonNode actualDescriptor = actualTbResourceInfoEntity.getDescriptor();
    String actualEtag = actualTbResourceInfoEntity.getEtag();
    UUID actualExternalId = actualTbResourceInfoEntity.getExternalId();
    String actualFileName = actualTbResourceInfoEntity.getFileName();
    Boolean actualIsPublic = actualTbResourceInfoEntity.getIsPublic();
    String actualPublicResourceKey = actualTbResourceInfoEntity.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfoEntity.getResourceKey();
    String actualResourceSubType = actualTbResourceInfoEntity.getResourceSubType();
    String actualResourceType = actualTbResourceInfoEntity.getResourceType();
    String actualSearchText = actualTbResourceInfoEntity.getSearchText();
    UUID actualTenantId = actualTbResourceInfoEntity.getTenantId();
    String actualTitle = actualTbResourceInfoEntity.getTitle();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals("TbResourceInfoEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, resourceType=Resource"
        + " Type, resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, etag=Etag,"
        + " fileName=foo.txt, descriptor={\"isPublic\":true}, isPublic=true, publicResourceKey=Public Resource Key,"
        + " externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceInfoEntity.getId());
    assertNull(actualTbResourceInfoEntity.getUuid());
    assertEquals(0L, actualTbResourceInfoEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(descriptor, actualDescriptor);
  }
}
