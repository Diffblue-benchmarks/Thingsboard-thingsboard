package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class TbResourceEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceEntity#TbResourceEntity()}
   *   <li>{@link TbResourceEntity#setData(byte[])}
   *   <li>{@link TbResourceEntity#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceEntity#setEtag(String)}
   *   <li>{@link TbResourceEntity#setExternalId(UUID)}
   *   <li>{@link TbResourceEntity#setFileName(String)}
   *   <li>{@link TbResourceEntity#setIsPublic(Boolean)}
   *   <li>{@link TbResourceEntity#setPreview(byte[])}
   *   <li>{@link TbResourceEntity#setPublicResourceKey(String)}
   *   <li>{@link TbResourceEntity#setResourceKey(String)}
   *   <li>{@link TbResourceEntity#setResourceSubType(String)}
   *   <li>{@link TbResourceEntity#setResourceType(String)}
   *   <li>{@link TbResourceEntity#setSearchText(String)}
   *   <li>{@link TbResourceEntity#setTenantId(UUID)}
   *   <li>{@link TbResourceEntity#setTitle(String)}
   *   <li>{@link TbResourceEntity#toString()}
   *   <li>{@link TbResourceEntity#getData()}
   *   <li>{@link TbResourceEntity#getDescriptor()}
   *   <li>{@link TbResourceEntity#getEtag()}
   *   <li>{@link TbResourceEntity#getExternalId()}
   *   <li>{@link TbResourceEntity#getFileName()}
   *   <li>{@link TbResourceEntity#getIsPublic()}
   *   <li>{@link TbResourceEntity#getPreview()}
   *   <li>{@link TbResourceEntity#getPublicResourceKey()}
   *   <li>{@link TbResourceEntity#getResourceKey()}
   *   <li>{@link TbResourceEntity#getResourceSubType()}
   *   <li>{@link TbResourceEntity#getResourceType()}
   *   <li>{@link TbResourceEntity#getSearchText()}
   *   <li>{@link TbResourceEntity#getTenantId()}
   *   <li>{@link TbResourceEntity#getTitle()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>()", "byte[] TbResourceEntity.getData()",
      "JsonNode TbResourceEntity.getDescriptor()", "String TbResourceEntity.getEtag()",
      "UUID TbResourceEntity.getExternalId()", "String TbResourceEntity.getFileName()",
      "Boolean TbResourceEntity.getIsPublic()", "byte[] TbResourceEntity.getPreview()",
      "String TbResourceEntity.getPublicResourceKey()", "String TbResourceEntity.getResourceKey()",
      "String TbResourceEntity.getResourceSubType()", "String TbResourceEntity.getResourceType()",
      "String TbResourceEntity.getSearchText()", "UUID TbResourceEntity.getTenantId()",
      "String TbResourceEntity.getTitle()", "void TbResourceEntity.setData(byte[])",
      "void TbResourceEntity.setDescriptor(JsonNode)", "void TbResourceEntity.setEtag(String)",
      "void TbResourceEntity.setExternalId(UUID)", "void TbResourceEntity.setFileName(String)",
      "void TbResourceEntity.setIsPublic(Boolean)", "void TbResourceEntity.setPreview(byte[])",
      "void TbResourceEntity.setPublicResourceKey(String)", "void TbResourceEntity.setResourceKey(String)",
      "void TbResourceEntity.setResourceSubType(String)", "void TbResourceEntity.setResourceType(String)",
      "void TbResourceEntity.setSearchText(String)", "void TbResourceEntity.setTenantId(UUID)",
      "void TbResourceEntity.setTitle(String)", "String TbResourceEntity.toString()"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setData(data);
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTbResourceEntity.setDescriptor(descriptor);
    actualTbResourceEntity.setEtag("Etag");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceEntity.setExternalId(externalId);
    actualTbResourceEntity.setFileName("foo.txt");
    actualTbResourceEntity.setIsPublic(true);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setPreview(preview);
    actualTbResourceEntity.setPublicResourceKey("Public Resource Key");
    actualTbResourceEntity.setResourceKey("Resource Key");
    actualTbResourceEntity.setResourceSubType("Resource Sub Type");
    actualTbResourceEntity.setResourceType("Resource Type");
    actualTbResourceEntity.setSearchText("Search Text");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceEntity.setTenantId(tenantId);
    actualTbResourceEntity.setTitle("Dr");
    String actualToStringResult = actualTbResourceEntity.toString();
    byte[] actualData = actualTbResourceEntity.getData();
    JsonNode actualDescriptor = actualTbResourceEntity.getDescriptor();
    String actualEtag = actualTbResourceEntity.getEtag();
    UUID actualExternalId = actualTbResourceEntity.getExternalId();
    String actualFileName = actualTbResourceEntity.getFileName();
    Boolean actualIsPublic = actualTbResourceEntity.getIsPublic();
    byte[] actualPreview = actualTbResourceEntity.getPreview();
    String actualPublicResourceKey = actualTbResourceEntity.getPublicResourceKey();
    String actualResourceKey = actualTbResourceEntity.getResourceKey();
    String actualResourceSubType = actualTbResourceEntity.getResourceSubType();
    String actualResourceType = actualTbResourceEntity.getResourceType();
    String actualSearchText = actualTbResourceEntity.getSearchText();
    UUID actualTenantId = actualTbResourceEntity.getTenantId();
    String actualTitle = actualTbResourceEntity.getTitle();

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
    assertEquals("TbResourceEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, resourceType=Resource Type,"
        + " resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, fileName=foo.txt,"
        + " data=[65, 88, 65, 88, 65, 88, 65, 88], etag=Etag, descriptor={\"isPublic\":true}, preview=[65, 88, 65,"
        + " 88, 65, 88, 65, 88], isPublic=true, publicResourceKey=Public Resource Key, externalId=784f394c-42b6"
        + "-435a-983c-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(descriptor, actualDescriptor);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPreview);
  }
}
