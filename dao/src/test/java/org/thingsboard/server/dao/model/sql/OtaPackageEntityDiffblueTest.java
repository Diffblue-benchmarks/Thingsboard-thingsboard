package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class OtaPackageEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageEntity#OtaPackageEntity()}
   *   <li>{@link OtaPackageEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OtaPackageEntity#setChecksum(String)}
   *   <li>{@link OtaPackageEntity#setChecksumAlgorithm(ChecksumAlgorithm)}
   *   <li>{@link OtaPackageEntity#setContentType(String)}
   *   <li>{@link OtaPackageEntity#setData(byte[])}
   *   <li>{@link OtaPackageEntity#setDataSize(Long)}
   *   <li>{@link OtaPackageEntity#setDeviceProfileId(UUID)}
   *   <li>{@link OtaPackageEntity#setFileName(String)}
   *   <li>{@link OtaPackageEntity#setTag(String)}
   *   <li>{@link OtaPackageEntity#setTenantId(UUID)}
   *   <li>{@link OtaPackageEntity#setTitle(String)}
   *   <li>{@link OtaPackageEntity#setType(OtaPackageType)}
   *   <li>{@link OtaPackageEntity#setUrl(String)}
   *   <li>{@link OtaPackageEntity#setVersion(String)}
   *   <li>{@link OtaPackageEntity#toString()}
   *   <li>{@link OtaPackageEntity#getAdditionalInfo()}
   *   <li>{@link OtaPackageEntity#getChecksum()}
   *   <li>{@link OtaPackageEntity#getChecksumAlgorithm()}
   *   <li>{@link OtaPackageEntity#getContentType()}
   *   <li>{@link OtaPackageEntity#getData()}
   *   <li>{@link OtaPackageEntity#getDataSize()}
   *   <li>{@link OtaPackageEntity#getDeviceProfileId()}
   *   <li>{@link OtaPackageEntity#getFileName()}
   *   <li>{@link OtaPackageEntity#getTag()}
   *   <li>{@link OtaPackageEntity#getTenantId()}
   *   <li>{@link OtaPackageEntity#getTitle()}
   *   <li>{@link OtaPackageEntity#getType()}
   *   <li>{@link OtaPackageEntity#getUrl()}
   *   <li>{@link OtaPackageEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OtaPackageEntity.<init>()", "JsonNode OtaPackageEntity.getAdditionalInfo()",
      "String OtaPackageEntity.getChecksum()", "ChecksumAlgorithm OtaPackageEntity.getChecksumAlgorithm()",
      "String OtaPackageEntity.getContentType()", "byte[] OtaPackageEntity.getData()",
      "Long OtaPackageEntity.getDataSize()", "UUID OtaPackageEntity.getDeviceProfileId()",
      "String OtaPackageEntity.getFileName()", "String OtaPackageEntity.getTag()",
      "UUID OtaPackageEntity.getTenantId()", "String OtaPackageEntity.getTitle()",
      "OtaPackageType OtaPackageEntity.getType()", "String OtaPackageEntity.getUrl()",
      "String OtaPackageEntity.getVersion()", "void OtaPackageEntity.setAdditionalInfo(JsonNode)",
      "void OtaPackageEntity.setChecksum(String)", "void OtaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm)",
      "void OtaPackageEntity.setContentType(String)", "void OtaPackageEntity.setData(byte[])",
      "void OtaPackageEntity.setDataSize(Long)", "void OtaPackageEntity.setDeviceProfileId(UUID)",
      "void OtaPackageEntity.setFileName(String)", "void OtaPackageEntity.setTag(String)",
      "void OtaPackageEntity.setTenantId(UUID)", "void OtaPackageEntity.setTitle(String)",
      "void OtaPackageEntity.setType(OtaPackageType)", "void OtaPackageEntity.setUrl(String)",
      "void OtaPackageEntity.setVersion(String)", "String OtaPackageEntity.toString()"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    OtaPackageEntity actualOtaPackageEntity = new OtaPackageEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOtaPackageEntity.setAdditionalInfo(additionalInfo);
    actualOtaPackageEntity.setChecksum("Checksum");
    actualOtaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    actualOtaPackageEntity.setContentType("text/plain");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualOtaPackageEntity.setData(data);
    actualOtaPackageEntity.setDataSize(3L);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageEntity.setDeviceProfileId(deviceProfileId);
    actualOtaPackageEntity.setFileName("foo.txt");
    actualOtaPackageEntity.setTag("Tag");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageEntity.setTenantId(tenantId);
    actualOtaPackageEntity.setTitle("Dr");
    actualOtaPackageEntity.setType(OtaPackageType.FIRMWARE);
    actualOtaPackageEntity.setUrl("https://example.org/example");
    actualOtaPackageEntity.setVersion("1.0.2");
    String actualToStringResult = actualOtaPackageEntity.toString();
    JsonNode actualAdditionalInfo = actualOtaPackageEntity.getAdditionalInfo();
    String actualChecksum = actualOtaPackageEntity.getChecksum();
    ChecksumAlgorithm actualChecksumAlgorithm = actualOtaPackageEntity.getChecksumAlgorithm();
    String actualContentType = actualOtaPackageEntity.getContentType();
    byte[] actualData = actualOtaPackageEntity.getData();
    Long actualDataSize = actualOtaPackageEntity.getDataSize();
    UUID actualDeviceProfileId = actualOtaPackageEntity.getDeviceProfileId();
    String actualFileName = actualOtaPackageEntity.getFileName();
    String actualTag = actualOtaPackageEntity.getTag();
    UUID actualTenantId = actualOtaPackageEntity.getTenantId();
    String actualTitle = actualOtaPackageEntity.getTitle();
    OtaPackageType actualType = actualOtaPackageEntity.getType();
    String actualUrl = actualOtaPackageEntity.getUrl();

    // Assert
    assertEquals("1.0.2", actualOtaPackageEntity.getVersion());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDeviceProfileId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Checksum", actualChecksum);
    assertEquals("Dr", actualTitle);
    assertEquals("OtaPackageEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, deviceProfileId=784f394c-42b6-435a"
        + "-983c-b7beff2784f9, type=FIRMWARE, title=Dr, version=1.0.2, tag=Tag, url=https://example.org/example,"
        + " fileName=foo.txt, contentType=text/plain, checksumAlgorithm=MD5, checksum=Checksum, data=[65, 88, 65,"
        + " 88, 65, 88, 65, 88], dataSize=3, additionalInfo={\"isPublic\":true})", actualToStringResult);
    assertEquals("Tag", actualTag);
    assertEquals("foo.txt", actualFileName);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("text/plain", actualContentType);
    assertNull(actualOtaPackageEntity.getId());
    assertNull(actualOtaPackageEntity.getUuid());
    assertEquals(0L, actualOtaPackageEntity.getCreatedTime());
    assertEquals(3L, actualDataSize.longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualChecksumAlgorithm);
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertSame(data, actualData);
    assertSame(deviceProfileId, actualDeviceProfileId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
